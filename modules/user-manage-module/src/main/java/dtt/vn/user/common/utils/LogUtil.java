package dtt.vn.user.common.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;

public class LogUtil {

	public static String dumpRequestParam(PortletRequest request){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(String param : request.getParameterMap().keySet()){
			String[] values = request.getParameterValues(param);
			if(values != null && values.length > 0){
				paramMap.put(param, values[0]);
			}
		}
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		if(themeDisplay != null){		
			paramMap.put("userId", themeDisplay.getUserId());
			paramMap.put("groupId", themeDisplay.getScopeGroupId());
		}
		paramMap.put("time", new Date());
		
		return paramMap.toString();
	}
	
	public static String dumpRequestParam(UploadPortletRequest request){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(String param : request.getParameterMap().keySet()){
			String[] values = request.getParameterValues(param);
			if(values != null && values.length > 0){
				paramMap.put(param, values[0]);
			}
		}
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		if(themeDisplay != null){		
			paramMap.put("userId", themeDisplay.getUserId());
			paramMap.put("groupId", themeDisplay.getScopeGroupId());
		}
		paramMap.put("time", new Date());
		
		return paramMap.toString();
	}
	
	public static String dumpActionError(PortletRequest request){
		
		List<String> errorList = new ArrayList<String>();
		Iterator<String> errors = SessionErrors.iterator(request);
		while(errors.hasNext()){
			errorList.add(errors.next());
		}
		
		return errorList.toString();
	}
}
