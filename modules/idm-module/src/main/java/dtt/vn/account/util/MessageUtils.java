package dtt.vn.account.util;

import java.util.Enumeration;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

public class MessageUtils {
	/**
	 * @param requestParam
	 * @param message
	 * @param request
	 */
	public static void saveError(String requestParam, String message, PortletRequest request) {
		request.setAttribute(requestParam, message);
		SessionErrors.add(request, requestParam);
		hideDefualtErrorMessage(request);
	}

	/**
	 * @param requestParam
	 * @param message
	 * @param request
	 */
	public static void saveMessage(String requestParam, String message, PortletRequest request) {
		request.setAttribute(requestParam, message);
		SessionMessages.add(request, requestParam);
		hideDefualtSuccessMessage(request);
	}

	/**
	 * Hide default message
	 * 
	 * @param request
	 */
	public static void hideDefualtErrorMessage(PortletRequest request) {
		SessionMessages.add(request,
				PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * Hide Default success message
	 * 
	 * @param request
	 */
	public static void hideDefualtSuccessMessage(PortletRequest request) {
		SessionMessages.add(request,
				PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	private void copyRequestParameters(ActionRequest request,ActionResponse actionResponse) {

		actionResponse.setRenderParameter("p_p_lifecycle", "1");

		Enumeration<String> enu = request.getParameterNames();

		Map<String, String[]> renderParameters = actionResponse.getRenderParameterMap();

		while (enu.hasMoreElements()) {
			String param = enu.nextElement();
			String[] values = request.getParameterValues(param);

			if (renderParameters.get(actionResponse.getNamespace() + param) == null
					&& (Validator.isNotNull(param) && Validator.isNotNull(values))) {
				actionResponse.setRenderParameter(param, values);
			}
		}
	}	
}
