package org.oep.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.PortletLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.TreeNode;
import com.liferay.portlet.configuration.kernel.util.PortletConfigurationUtil;


public class PortletUtil {

	private static Log log = LogFactoryUtil.getLog(PortletUtil.class);
	
	public static long getDefaultPlid(long groupId, String portletId) throws PortalException, SystemException{
		long plid = LayoutLocalServiceUtil.getDefaultPlid(groupId, true, portletId);
		if(plid > 0){
			return plid;
		}
		
		return LayoutLocalServiceUtil.getDefaultPlid(groupId, false, portletId);
	}
	
	public static String createRenderURL(ThemeDisplay themeDisplay, long plid, String portletId, Map<String, String> params){
		
		try {
			LiferayPortletURL renderURL = PortletURLFactoryUtil.create(themeDisplay.getRequest(), portletId, plid, PortletRequest.RENDER_PHASE);
			renderURL.setWindowState(WindowState.NORMAL);		
			renderURL.setPortletMode(PortletMode.VIEW);
			for(String key : params.keySet()){
				renderURL.setParameter(key, params.get(key));
			}
			return renderURL.toString();
		} catch (WindowStateException e) {
			log.error(e);
		} catch(PortletModeException e){
			log.error(e);
		}
		
		return "";
	}
	
	public static Map<String,String> getPortletCustomTitle(long layoutId, String languageId){	    
		Map<String, String> result = new HashMap<String, String>();
		try{
			Layout layout = LayoutLocalServiceUtil.fetchLayout(layoutId);
			if (layout != null) {
				LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();
				if (layoutTypePortlet != null) {
					List<String> portletIds = layoutTypePortlet.getPortletIds();
					if (portletIds != null && portletIds.size() > 0) {
						for (String portletId : portletIds) {
							if (portletId != null) {
								PortletPreferences portletSetup = PortletPreferencesFactoryUtil.getLayoutPortletSetup(layout, portletId);
								String portletCustomTitle = PortletConfigurationUtil .getPortletTitle(portletSetup, languageId);
								if(portletCustomTitle == null || portletCustomTitle.trim().length()<=0){
									try{
										portletCustomTitle = PortletLocalServiceUtil.getPortletById(portletId).getPortletInfo().getTitle();
									}catch(Exception e){
										portletCustomTitle = portletId;
									}
								}
								result.put(portletId, portletCustomTitle);
							}
						}
					}
				}
			}
		}catch (Exception e) {
			log.error(e);
		}
		return result;
	}
	
	private static void addLeaves(TreeNode<Layout> tree, long groupId, boolean privateLayout, long parentLayoutId) throws SystemException{
		List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(groupId, privateLayout, parentLayoutId);
		for(Layout layout : layouts){
			TreeNode<Layout> child = tree.addChildNode(layout);
			addLeaves(child, groupId, privateLayout, layout.getLayoutId());
		}
	}
	
	private static TreeNode<Layout> getLayoutTree(long groupId, boolean privateLayout) throws SystemException{
		TreeNode<Layout> root = new TreeNode<Layout>(null);
		addLeaves(root, groupId, privateLayout, 0);
		return root;
	}
	
	private static String leftFill(String st, String pad, int times){
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < times; i++){
			builder.append(pad);
		}
		builder.append(st);
		return builder.toString();
	}
	
	private static void convertLayoutTreeToListOption(TreeNode<Layout> tree, int level, Locale locale, List<KeyValuePair> options){
		Layout layout = tree.getValue();
		if(layout != null){
			String layoutName = layout.getName(locale);
			options.add(new KeyValuePair(String.valueOf(layout.getPlid()), leftFill(layoutName, "-", 2*level)));
		}
		
		List<TreeNode<Layout>> nodes = tree.getChildNodes();
		for(TreeNode<Layout> node : nodes){
			convertLayoutTreeToListOption(node, level + 1, locale, options);
		}
	}
	
	public static List<KeyValuePair> getLayoutListOption(long groupId, boolean privateLayout, Locale locale) throws SystemException{
		List<KeyValuePair> options = new ArrayList<KeyValuePair>();
		TreeNode<Layout> tree = getLayoutTree(groupId, privateLayout);
		convertLayoutTreeToListOption(tree, -1, locale, options);
		return options;
	}
	
	public static Object[] getDefaultPlidAndType(long groupId, String portletId) throws PortalException, SystemException{
		long plid = LayoutLocalServiceUtil.getDefaultPlid(groupId, true, portletId);
		if(plid > 0){
			return new Object[]{plid, true};
		}
		
		return new Object[]{ LayoutLocalServiceUtil.getDefaultPlid(groupId, false, portletId), false};
	}
}
