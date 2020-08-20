package dtt.vn.user.quanly.business;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.PasswordTrackerLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import dtt.vn.user.keycloak.connect.KeycloakUtils;
import dtt.vn.user.quanly.keys.CapNhatMatKhauKeys;


public class UserBusiness {
	/** Avatar */
	private byte[] avatar = new byte[0]; 
	
	

	/**
	 * @return the avatar
	 */
	public byte[] getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	
	private static Log log = LogFactoryUtil.getLog(UserBusiness.class);
	
	public void updatePasswordUser(long userId, String password_old,  String password_new,  String password_confirm,  ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		if(validateFormUpdatePassword(password_old, password_new, password_confirm, request, response)) {
			long companyId = themeDisplay.getCompanyId();
			User existUser = null; 
			existUser = UserLocalServiceUtil.getUserById(companyId, userId);
			if(existUser != null) {
				UserLocalServiceUtil.updatePassword(existUser.getUserId(), password_new, password_new, false);
				KeycloakUtils.changeUserPassword(existUser.getScreenName(), password_new);
				// Update portrait
				if (this.avatar.length > 0) {
					UserLocalServiceUtil.updatePortrait(existUser.getUserId(), this.avatar);
				}
			}
			request.setAttribute("isdonemk", true);
		}
		request.setAttribute("iserrormk", true);
	}
	
	/*Kiem tra tinh hop le cap nhat mat khau*/ 
	
	public static boolean validateFormUpdatePassword(String password_old, String password_new, String password_confirm, ActionRequest request,
			ActionResponse response){
		boolean result = true;
		User    currentUser = null;
		boolean res = false;
		try {
			
			if(password_old.equals("")){
				SessionErrors.add(request,CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_OLD);
				result = false;
			} else {
				currentUser = PortalUtil.getUser(request);
				log.info("currentUser........." + currentUser);
				res         = PasswordTrackerLocalServiceUtil.isSameAsCurrentPassword(currentUser.getUserId(), password_old);
				log.info("password_old..........." + password_old);
				if(res == false) {
					SessionErrors.add(request,CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_PASSWORD_ERROR);
					result = false;
				}
			}
			
			if(password_new.equals("")){
				SessionErrors.add(request,CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_NEW);
				result = false;
			} else if(password_new.length() < 8){
				SessionErrors.add(request, CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_VALIDATE_PASSWORD_NEW);
				result = false;
			} 
			
			if(password_confirm.equals("")){
				SessionErrors.add(request,CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_CONFIRM);
				result = false;
			} else if(!password_new.equals(password_confirm)){
				SessionErrors.add(request,CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_PASSWORD_NEW_NOT_DUPLICATE_PASSWORD_CONFIRM);
				result = false;
			}
			
		} catch (Exception e) {
			log.error("_____UserBusiness.validateFormUpdatePassword_____" + e);
		}
		
		return result;
	}
}
