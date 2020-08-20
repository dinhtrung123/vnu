package dtt.vn.vnpost.service.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;



public class PortalUtil extends com.liferay.portal.kernel.util.PortalUtil {
	public static final String getUserId() {
		return "0";
	}

	static Log _log = LogFactoryUtil.getLog(PortalUtil.class);

	public static long getGlobalGroupId() {
		long groupId = 0;
		try {
			groupId = GroupLocalServiceUtil.getCompanyGroup(PortalUtil.getDefaultCompanyId()).getGroupId();
		} catch (PortalException e) {
			_log.info(e.getMessage());
		} catch (SystemException e) {
			_log.info(e.getMessage());
		}
		return groupId;
	}

	public static ThemeDisplay getThemeDisplay(PortletRequest request) {
		return (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	public static long getGroupId(PortletRequest request) {
		return getThemeDisplay(request).getScopeGroupId();
	}

	public static long getLayoutId(PortletRequest request) {
		return getThemeDisplay(request).getPlid();
	}

	@SuppressWarnings("finally")
	public static long getLayoutIdViewDetail(PortletRequest request, String friendlyURL) {
		// return news page layout
		long layoutId = 0;
		try {
			layoutId = LayoutLocalServiceUtil.getFriendlyURLLayout(getGroupId(request), false, friendlyURL).getPlid();
			if (layoutId > 0) {
				return layoutId;
			}
		} catch (PortalException | SystemException e) {
			layoutId = getLayoutId(request);
		} finally {
			return layoutId;
		}
	}

	public static PortletDisplay getDisplayPortlet(PortletRequest request) {
		return getThemeDisplay(request).getPortletDisplay();
	}

	/*
	 * public static ResourceResponse toJson(ResourceResponse res, Object obj)
	 * throws IOException { return toJSON(res, GsonUtils.toJson(obj)); }
	 */

	public static ResourceResponse toJSON(ResourceResponse res, String json) throws IOException {
		res.getWriter().write(json);
		res.setContentType(ContentTypes.APPLICATION_JSON);
		res.setCharacterEncoding(StringPool.UTF8);
		return res;
	}

	public static String getResourceURL(ResourceResponse res, String ID) {
		ResourceURL resourceURL = res.createResourceURL();
		resourceURL.setResourceID(ID);
		return resourceURL.toString();
	}

	public static User isEmployee(String userId) {
		if (isNumber(userId)) {
			try {
				User user = UserLocalServiceUtil.getUser(Long.valueOf(userId));
				long[] groups = user.getUserGroupIds();
				if (groups.length == 0) {
					return null;
				} else {
					return user;
				}
			} catch (NumberFormatException | PortalException | SystemException e) {
				_log.error(e.getMessage());
			}
		}
		return null;
	}

	public static boolean isNumber(String numberString) {
		if (numberString == null || numberString.length() == 0) {
			return false;
		} else {
			try {
				Double.parseDouble(numberString);
				return true;
			} catch (NumberFormatException nfe) {
				return false;
			}
		}
	}

	public static String formatPhone(String numberPhone) {
		if (numberPhone.length() > 5) {
			return "*****" + (String) numberPhone.subSequence(5, numberPhone.length());
		}
		return "";
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	public static String convertDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if (date != null) {
			return sdf.format(date);
		}
		return CommonConstants.SPACE;
	}

	/*
	 * public static void toJson(ResourceResponse resourceResponse, Object obj,
	 * String name) throws IOException { Gson gson = new Gson(); JSONObject json
	 * = JSONFactoryUtil.createJSONObject(); json.put(name, gson.toJson(obj));
	 * resourceResponse.getWriter().write(json.toString()); }
	 */

	public static List<Long> getAllChildGroup(PortletRequest req) {
		List<Long> listGroupIds = new ArrayList<Long>();
		ThemeDisplay themeDisplay = PortalUtil.getThemeDisplay(req);
		long groupId = themeDisplay.getLayout().getGroupId();
		listGroupIds.add(groupId);
		try {
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			if (group != null) {
				listGroupIds.addAll(getAllChildGroup(group, listGroupIds));
			}
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}

		return listGroupIds;
	}

	private static List<Long> getAllChildGroup(Group parentGroup, List<Long> listGroup) {
		try {
			List<Group> listChild = parentGroup.getChildren(true);
			if (listChild != null) {
				for (Group child : listChild) {
					listGroup.add(child.getGroupId());
					getAllChildGroup(child, listGroup);
				}
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return listGroup;
	}

	public static String getFileNameInUrl(String url) {
		String fileName = "";
		if (!url.isEmpty()) {
			try {
				url = URLDecoder.decode(url, "UTF-8");
				if (url != null) {
					url = url.replace("http://", "");
					String[] urlSplit = url.split(StringPool.FORWARD_SLASH);
					for (int i = 1; i < urlSplit.length; i++) {
						if (urlSplit[i].contains("."))
							return urlSplit[i];
					}
				}
			} catch (UnsupportedEncodingException e) {
				return fileName;
			}

		}
		return fileName;
	}

	public static String formatSearchFiled(String keyword) {
		if (!keyword.isEmpty())
			return keyword.trim().replaceAll("[\"']", "");
		return keyword;
	}

	public static String rebuildSQLQuery(int num) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < num; i++) {
			builder.append("?,");
		}
		if (builder.length() > 0) {
			return builder.substring(0, builder.length() - 1);
		}
		return builder.toString();
	}

	public static ServiceContext getServiceContext(long userId, long companyId) throws Exception {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setPortletPreferencesIds(null);
		serviceContext.setCompanyId(companyId);
		serviceContext.setUserId(userId);
		return serviceContext;
	}

	/*public static String getValueFromProps(String keyProps) {
		return GetterUtil.getString(PortletProps.get(keyProps));
	}*/
}
