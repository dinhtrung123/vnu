package dtt.vn.user.utils;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.DuplicateUserEmailAddressException;
import com.liferay.portal.kernel.exception.DuplicateUserScreenNameException;
import com.liferay.portal.kernel.exception.NoSuchRoleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import dtt.vn.user.common.utils.StringUtil;
import dtt.vn.user.keycloak.connect.KeycloakUtilTemp;
import dtt.vn.user.service.model.DataImport;
import dtt.vn.user.service.service.DataImportLocalServiceUtil;

public class LiferayUserUtil {
	private static Log log = LogFactoryUtil.getLog(LiferayUserUtil.class);

	public static long createUser(long companyId, String email, String screenName, String password, String hoVaTen,
			boolean isCompany, String fisrtName) throws PortalException {
		// check exist account with email and screen name
		log.info("createUser:[email=" + email + "],[screenName=" + screenName + "],[hoVaTen=" + hoVaTen
				+ "],[isCompany=" + isCompany + "]");
		try {

			User user = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, email);
			if (user != null) {
				throw new DuplicateUserEmailAddressException();
			}
			if (screenName != null && screenName.trim().length() <= 0) {
				user = UserLocalServiceUtil.fetchUserByScreenName(companyId, screenName);
				if (user != null) {
					log.info("DuplicateUserScreenNameException...:" + screenName);
					throw new DuplicateUserScreenNameException();
				}
			}
		} catch (Exception e) {

		}
		// set parameter for create user
		long creatorUserId = 0;
		boolean autoPassword = false;
		// Lower case the password

		String password1 = password;
		String password2 = password;

		boolean autoScreenName = false;
		// boolean autoScreenName = false;

		long userId = CounterLocalServiceUtil.increment(User.class.getName());

		if (isCompany) {
			if (StringUtil.isNullOrEmpty(screenName)) {
				screenName = "TC" + userId;
			}
			if (StringUtil.isNullOrEmpty(hoVaTen)) {
				hoVaTen = email.split("@")[0];
			}

		} else {
			if (StringUtil.isNullOrEmpty(screenName)) {
				screenName = "CD" + userId;
			}
			if (StringUtil.isNullOrEmpty(hoVaTen)) {
				hoVaTen = email.split("@")[0];
			}
		}

		String emailAddress = email;
		long facebookId = 0;
		String openId = StringPool.BLANK;
		Locale locale = LocaleUtil.getDefault();
		String firstName = hoVaTen;
		String middleName = "";
		String lastName = fisrtName;

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

		// fix loi : LDAP: error code 65 - object class 'inetOrgPerson' requires
		// attribute 'sn'...
		/*
		 * if (Validator.isNull(middleName)) { middleName = screenName; }
		 */
		User user = null;
		try {
			user = UserLocalServiceUtil.addUser(creatorUserId, companyId, autoPassword, password1, password2,
					autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, middleName,
					lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
					organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// update default role
		String roleDNStr = "20109";
		String roleCNStr = "20109";
		long roleDN = 0;
		long roleCN = 0;
		// add role for DN
		if (!Validator.isBlank(roleDNStr) && isCompany) {
			roleDN = Long.valueOf(roleDNStr.trim());
			UserLocalServiceUtil.addRoleUser(20109, user);
		}
		// add role for Citizen
		if (!Validator.isBlank(roleCNStr) && !isCompany) {
			roleCN = Long.valueOf(roleCNStr.trim());
			UserLocalServiceUtil.addRoleUser(20109, user);
		}

		//UserLocalServiceUtil.updateLastLogin(user.getUserId(), user.getLoginIP());
		user.setPasswordReset(false);
		UserLocalServiceUtil.updatePasswordReset(user.getUserId(), false);
		UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), false);
		UserLocalServiceUtil.updateAgreedToTermsOfUse(user.getUserId(), false);
		UserLocalServiceUtil.updateUser(user);
		return user.getUserId();

	}

	public static boolean deleteUserByEmail(long companyId, String emailAddress) {
		boolean result = false;
		User user = null;
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			if (user != null) {
				UserLocalServiceUtil.deleteUser(user);
				result = true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return result;

	}

	public static long createUserCanBo(long companyId, String email, String screenName, String password, String hoVaTen,
			boolean isXacMinh) throws PortalException {
		// check exist account with email and screen name
		log.info("createUser:[email=" + email + "],[screenName=" + screenName + "],[hoVaTen=" + hoVaTen
				+ "],[isXacMinh=" + isXacMinh + "]");
		try {

			User user = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, email);
			if (user != null) {
				throw new DuplicateUserEmailAddressException();
			}
			if (screenName != null && screenName.trim().length() <= 0) {
				user = UserLocalServiceUtil.fetchUserByScreenName(companyId, screenName);
				if (user != null) {
					log.info("DuplicateUserScreenNameException...:" + screenName);
					throw new DuplicateUserScreenNameException();
				}
			}
		} catch (Exception e) {

		}
		// set parameter for create user
		long creatorUserId = 0;
		boolean autoPassword = false;
		// Lower case the password

		String password1 = password;
		String password2 = password;

		// boolean autoScreenName = true;
		boolean autoScreenName = false;

		long userId = CounterLocalServiceUtil.increment(User.class.getName());

		if (isXacMinh) {
			if (StringUtil.isNullOrEmpty(screenName)) {
				screenName = "XM" + userId;
			}
			if (StringUtil.isNullOrEmpty(hoVaTen)) {
				hoVaTen = email.split("@")[0];
			}

		} else {
			if (StringUtil.isNullOrEmpty(screenName)) {
				screenName = "PD" + userId;
			}
			if (StringUtil.isNullOrEmpty(hoVaTen)) {
				hoVaTen = email.split("@")[0];
			}
		}

		String emailAddress = email;
		long facebookId = 0;
		String openId = StringPool.BLANK;
		Locale locale = LocaleUtil.getDefault();
		String firstName = hoVaTen;
		String middleName = "";
		String lastName = "UAT";

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

		// fix loi : LDAP: error code 65 - object class 'inetOrgPerson' requires
		// attribute 'sn'...
		/*
		 * if (Validator.isNull(middleName)) { middleName = screenName; }
		 */
		User user = null;
		try {
			user = UserLocalServiceUtil.addUser(creatorUserId, companyId, autoPassword, password1, password2,
					autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, middleName,
					lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
					organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// update default role
		String roleDNStr = "20109";
		String roleCNStr = "20109";
		long roleDN = 0;
		long roleCN = 0;
		long roleXM = 111458;
		long rolePD = 149016;
		// add role for DN
		if (!Validator.isBlank(roleDNStr) && isXacMinh) {
			roleDN = Long.valueOf(roleDNStr.trim());
			UserLocalServiceUtil.addRoleUser(roleXM, user);
		}
		// add role for Citizen
		if (!Validator.isBlank(roleCNStr) && !isXacMinh) {
			roleCN = Long.valueOf(roleCNStr.trim());
			UserLocalServiceUtil.addRoleUser(rolePD, user);
		}

		UserLocalServiceUtil.updateLastLogin(user.getUserId(), user.getLoginIP());
		UserLocalServiceUtil.updatePasswordReset(user.getUserId(), false);
		UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), false);
		UserLocalServiceUtil.updateAgreedToTermsOfUse(user.getUserId(), false);
		return user.getUserId();

	}

	public static void importUser(List<DataImport> listData) throws IOException {
		long creatorUserId = 0;
		boolean autoPassword = false;
		// Lower case the password
		String password = "123456";
		String password1 = password;
		String password2 = password;

		boolean autoScreenName = true;
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = false;
		String middleName = "";

		Locale locale = LocaleUtil.getDefault();
		long companyId = PortalUtil.getDefaultCompanyId();
		
		long facebookId = 0;
		String openId = StringPool.BLANK;
		ServiceContext serviceContext = new ServiceContext();

		int prefixId = 0;
		int suffixId = 0;
		boolean male = true; // Default is male

		Calendar cal = Calendar.getInstance();

		int birthdayMonth = cal.get(Calendar.MONTH);
		int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
		int birthdayYear = cal.get(Calendar.YEAR);

		User user = null;
		try {
			int i = 0;
			for (DataImport data : listData) {
				DataImport dataImport = DataImportLocalServiceUtil.getDataImport(data.getId());
				try {
					user = UserLocalServiceUtil.addUser(creatorUserId, companyId, autoPassword, password1, password2,
							autoScreenName, data.getScreenName(), data.getEmailAddress(), facebookId, openId, locale, "VNPost",
							middleName, data.getLastName(), prefixId, suffixId, male, birthdayMonth, birthdayDay,
							birthdayYear, data.getJobTitle(), groupIds, organizationIds, roleIds, userGroupIds, sendEmail,
							serviceContext);	
					
					UserLocalServiceUtil.updateLastLogin(user.getUserId(), user.getLoginIP());
					UserLocalServiceUtil.updatePasswordReset(user.getUserId(), false);
					UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), false);
					UserLocalServiceUtil.updateAgreedToTermsOfUse(user.getUserId(), false);
					KeycloakUtilTemp.importCanBoKC(data);
					log.info("insert user KC thanh cong");

					String roleName = data.getNameRole().trim();
					if (roleName.startsWith("4")) {
						roleName = "PheDuyet";
					} else if (roleName.startsWith("3")) {
						roleName = "CanBoXacMinh";
					} else if (roleName.startsWith("5")) {
						roleName = "XacMinh&PheDuyet";
					}
					
					long roleId = 0;
					Role role = getRoleById(companyId, roleName);
					if (Validator.isNull(role)) {
						throw new NoSuchRoleException();
					} else {
						roleId = role.getRoleId();
					}
				
					UserLocalServiceUtil.addRoleUser(roleId, user);
					dataImport.setHasImport("1");
					log.info(++i + ".Insert user " + data.getScreenName() + " success");
					
				} catch (Exception e) {
					// TODO: handle exception
					if (e instanceof UserEmailAddressException) {
						log.error("ERROR " + data.getEmailAddress() + " " + e.toString());
						dataImport.setHasImport("-1");
						dataImport.setErrorMsg(e.getClass().getName());
					} else if (e instanceof NoSuchRoleException) {
						log.error("ERROR " + e.toString());
						dataImport.setHasImport("1");
						dataImport.setErrorMsg(e.getClass().getName());
					} else {
						dataImport.setHasImport("-1");
						log.error("ERROR " + e.toString());
						dataImport.setErrorMsg(e.getClass().getName());
					}
				} finally {
					DataImportLocalServiceUtil.updateDataImport(dataImport);
				}			
			}
			log.info("Data Import" + i);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.toString());
		}
	}

	private static Role getRoleById(final long companyId, final String roleStrId) {
		try {
			return RoleLocalServiceUtil.getRole(companyId, roleStrId);
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
}
