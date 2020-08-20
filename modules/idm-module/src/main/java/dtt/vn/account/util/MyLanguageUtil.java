package dtt.vn.account.util;

import com.liferay.portal.kernel.language.LanguageUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;

public class MyLanguageUtil {
	public static String get(HttpServletRequest request, Locale locale, String key) {
	    if (request == null) {
	      return key;
	    }

	    PortletConfig portletConfig = (PortletConfig) request.getAttribute("javax.portlet.config");
	    if (portletConfig != null) {
	      ResourceBundle resourceBundle = portletConfig.getResourceBundle(locale);
	      if (resourceBundle.containsKey(key)) {
	        return LanguageUtil.get(resourceBundle, key, key);
	      }
	    }

	    return LanguageUtil.get(locale, key);
	  }
}
