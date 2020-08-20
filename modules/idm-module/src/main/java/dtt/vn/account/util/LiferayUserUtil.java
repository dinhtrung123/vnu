package dtt.vn.account.util;

import java.util.Calendar;
import java.util.Locale;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.DuplicateUserEmailAddressException;
import com.liferay.portal.kernel.exception.DuplicateUserScreenNameException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class LiferayUserUtil {
	private static Log log= LogFactoryUtil.getLog(LiferayUserUtil.class);
	public static long createUser (long companyId,String email,String screenName, String password, String hoVaTen, boolean isCompany,String cmndORtaxCode) throws PortalException{
		// check exist account with email and screen name
		log.info("createUser:[email="+email+"],[screenName="+screenName+"],[hoVaTen="+hoVaTen+"],[isCompany="+isCompany+"]");
try{
			
			
			User user = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, email);
			if(user != null){
				throw new DuplicateUserEmailAddressException();
			}
			if(screenName != null && screenName.trim().length()<=0){
				user = UserLocalServiceUtil.fetchUserByScreenName(companyId, screenName);
				if(user != null){
					log.info("DuplicateUserScreenNameException...:"+screenName);
					throw new DuplicateUserScreenNameException();
				}
			}
		}catch(Exception e){
			
		}
		//set parameter for create user
		long creatorUserId = 0;
		boolean autoPassword = false;
		// Lower case the password
		
		String password1 = password;
		String password2 = password;
		
		boolean autoScreenName = true;
		//boolean autoScreenName = false;
		
		long userId = CounterLocalServiceUtil.increment(User.class.getName());
	
		if(isCompany) {
			if(StringUtil.isNullOrEmpty(screenName)){				
				screenName = "TC"+userId;
			}
			if(StringUtil.isNullOrEmpty(hoVaTen)){
				hoVaTen =email.split("@")[0];
			}
			
		} else {
			if(StringUtil.isNullOrEmpty(screenName)){				
				screenName = "CD"+userId;
			}
			if(StringUtil.isNullOrEmpty(hoVaTen)){
				hoVaTen = email.split("@")[0];
			}
		}
		
		
		String emailAddress = email;
		long facebookId = 0;
		String openId = StringPool.BLANK;
		Locale locale = LocaleUtil.getDefault();
		String firstName = hoVaTen;
		String middleName = "";
		String lastName = cmndORtaxCode;
		
		int prefixId = 0;
		int suffixId = 0;
		boolean male = true; // Default is male
		
		Calendar cal = Calendar.getInstance();
	
		int birthdayMonth = cal.get(Calendar.MONTH);
		int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
		int birthdayYear = cal.get(Calendar.YEAR);
		
		String jobTitle = StringPool.BLANK;
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = false;
		ServiceContext serviceContext = new ServiceContext();
		
		// fix loi : LDAP: error code 65 - object class 'inetOrgPerson' requires attribute 'sn'...
		/*if (Validator.isNull(middleName)) {
			middleName = screenName;
		}*/
		User user = null;
		try {
			 user = UserLocalServiceUtil.addUser(
					creatorUserId, companyId, autoPassword, password1, password2,
					autoScreenName, screenName, emailAddress, facebookId, openId,
					locale,firstName, middleName, lastName, prefixId, suffixId, male,
					birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
					organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		// update default role
		String roleDNStr = "20109";
		String roleCNStr = "20109";
		long roleDN = 0;
		long roleCN = 0;
		//add role for DN
		if(!Validator.isBlank(roleDNStr) && isCompany){
			roleDN = Long.valueOf(roleDNStr.trim());
			UserLocalServiceUtil.addRoleUser(20109, user);
		}
		//add role for Citizen 
		if(!Validator.isBlank(roleCNStr) && !isCompany){
			roleCN = Long.valueOf(roleCNStr.trim());
			UserLocalServiceUtil.addRoleUser(20109, user);
		}

		UserLocalServiceUtil.updateLastLogin( user.getUserId(), user.getLoginIP());

		UserLocalServiceUtil.updatePasswordReset(user.getUserId(), false);
		UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), false);
		UserLocalServiceUtil.updateAgreedToTermsOfUse(user.getUserId(), false);
		return user.getUserId();
		
	}
	
	public static boolean deleteUserByEmail (long companyId, String emailAddress){
		boolean result = false;
		User user = null;
		try {
			log.info("delete UserByEmail : "+emailAddress);
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			if(user != null){
				UserLocalServiceUtil.deleteUser(user);
				result = true;
			}else {
				log.info("getUserByEmailAddressEXception.....NULL");
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return result;
		
	}
	
	
}
