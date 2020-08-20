package dtt.vn.account.business;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import dtt.vn.account.util.DateUtil;
import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.model.WorkItem;
import dtt.vn.vnpost.service.WorkItemLocalServiceUtil;


public class AccountBusiness {
public static Account accountFromRequest(ActionRequest request, Account model) throws SystemException, PortalException{
		
		
		
		String fullname = ParamUtil.getString(request, "fullname");
		String email = ParamUtil.getString(request, "email");
		String birthdate = ParamUtil.getString(request, "ngaySinh");
		
		int gender = ParamUtil.getInteger(request, "gender");
		int maritalStatus = ParamUtil.getInteger(request, "maritalStatus");
		String nationality = ParamUtil.getString(request, "nationality");
		String ethnicGroup = ParamUtil.getString(request, "ethnicGroup");
		
		String telNo = ParamUtil.getString(request, "telNo");
		String address = ParamUtil.getString(request, "address");
		String taxCode = ParamUtil.getString(request, "taxCode");
		String insuranceCode = ParamUtil.getString(request, "insuranceCode");
		String familyRegNo = ParamUtil.getString(request, "familyRegNo");
		String workingPlace = ParamUtil.getString(request, "workingPlace");
		String personalId = ParamUtil.getString(request, "personalId");
		String nativePlace = ParamUtil.getString(request, "nativePlace");
		String tinh = ParamUtil.getString(request, "tinh");
		String huyen = ParamUtil.getString(request, "huyen");
		String xa = ParamUtil.getString(request, "xa");
		String message = ParamUtil.getString(request, "message");
		int ipLevel = ParamUtil.getInteger(request, "ipLevel");
		int accountStatus = ParamUtil.getInteger(request, "accountStatus");
		int processStatus = ParamUtil.getInteger(request, "processStatus");
		boolean reopen = ParamUtil.getBoolean(request, "reopen");
		
		
		model.setFullName(fullname);
		model.setEmail(email);
		model.setBirthdate(DateUtil.parseStringToDate(birthdate, DateUtil.DATE_FORMAT_D_M_Y));
		model.setGender(gender);
		model.setMaritalStatus(maritalStatus);
		model.setNationality(nationality);
		model.setEthnicGroup(ethnicGroup);
		model.setTelNo(telNo);
		model.setAddress(address);
		model.setInsuranceCode(insuranceCode);
		model.setFamilyRegNo(familyRegNo);
		model.setTaxCode(taxCode);
		model.setWorkingPlace(workingPlace);
		model.setNativePlace(nativePlace);
		model.setPersonalId(personalId);
		model.setCityCode(tinh);
		model.setDistrictCode(huyen);
		model.setWardCode(xa);
		model.setIpLevel(ipLevel);
		model.setAccountStatus(accountStatus);
		model.setProcessStatus(processStatus);
		model.setMessage(message);
		model.setReOpen(reopen);
	//	model.setId(quanLyThuGomId);

		return model;
	}	


	public static List<User> getUsers() throws PortalException, SystemException {

		//long[] userIds = UserLocalServiceUtil.getRoleUserIds(getRoleId("Power User"));

		List<User> userList = new ArrayList<User>();
		//Lo cal 9643828
		//IDM SV 9642808
		List<UserGroupRole> userGroupRoles =     UserGroupRoleLocalServiceUtil.getUserGroupRolesByGroupAndRole(111405, getRoleId("CanBoXacMinh")); 
		for (UserGroupRole userGroupRole : userGroupRoles) {
			userList.add(UserLocalServiceUtil.getUser(userGroupRole.getUserId()));
		}
/*		
		
x
		for (int i = 0; i < userIds.length; i++) {
			userList.add(UserLocalServiceUtil.getUser(userIds[i]));
		}
*/		
		
		return userList;
	}
	
	public static List<WorkItem> getQuaTrinhXuly(long accountId) throws PortalException, SystemException {

		return WorkItemLocalServiceUtil.getQuaTrinhXuLy(accountId);
	}	
	
	public static long getRoleId(String roleName) throws PortalException, SystemException {
		long companyId = CompanyThreadLocal.getCompanyId();
		Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
		return role.getRoleId();
	}	
}
