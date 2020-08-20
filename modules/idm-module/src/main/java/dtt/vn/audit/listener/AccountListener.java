/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dtt.vn.audit.listener;

import com.google.gson.Gson;
import com.liferay.portal.kernel.audit.AuditRequestThreadLocal;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import dtt.vn.account.util.PortletKeysUtil;
import dtt.vn.audit.business.MessageUpdateAccount;
import dtt.vn.audit.service.AuditEventLocalServiceUtil;
import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
    service = ModelListener.class
)
public class AccountListener extends BaseModelListener<Account> {
	private static Log log = LogFactoryUtil.getLog(AccountListener.class.getName()); 
	private static final Configuration _configuration = ConfigurationFactoryUtil
		    .getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	//this code create new
	@Override
	public void onAfterCreate(Account model) throws ModelListenerException {
		// TODO Auto-generated method stub
		this.addAuditLog(model,"0");
	}
	
	@Override
	public void onAfterUpdate(Account model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterUpdate(model);
	}
	@Override
	public void onBeforeUpdate(Account model) throws ModelListenerException {
		// TODO Auto-generated method stub
		try {
			Account acc = AccountLocalServiceUtil.getAccount(model.getAccountId());
			log.info("accold:"+acc.getAccountStatus());
			log.info("accnew:"+model.getAccountStatus());
			List<MessageUpdateAccount> fieldchange = CheckFieldUpdateAccount(acc,model);
			this.addAuditLog(model,new Gson().toJson(fieldchange));
			super.onBeforeUpdate(model);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void onAfterRemove(Account model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterRemove(model);
	}
	
	
	
	public  void addAuditLog(Account acc,String message) {
		try {
			log.info("message:"+message);
			//idm.vnpost.audit.action.dangky
			if(message.equals("0")) {
				long companyId = CompanyThreadLocal.getCompanyId();
				long userId = 0;
				 userId = GetterUtil.getLong(PrincipalThreadLocal.getName());
				String realUserName = acc.getFullName();
				String eventType = _configuration.get("idm.vnpost.audit.action.dangky");
				String className = Account.class.getName();
				 AuditRequestThreadLocal auditRequestThreadLocal = AuditRequestThreadLocal.getAuditThreadLocal();
				String clientHost = auditRequestThreadLocal.getClientHost();
				   String clientIP = auditRequestThreadLocal.getClientIP();
				   String serverName = auditRequestThreadLocal.getServerName();
				   int serverPort = auditRequestThreadLocal.getServerPort();
				   String sessionID = auditRequestThreadLocal.getSessionID();
				AuditEventLocalServiceUtil.addAuditEvent(companyId, acc.getUserId(), acc.getAccountName(), eventType, className, acc.getAccountId()+"", realUserName, clientHost, clientIP, serverName, serverPort, sessionID, eventType);
			}else {
				MessageUpdateAccount[] messageUpdate = new Gson().fromJson(message, MessageUpdateAccount[].class);
				long companyId = CompanyThreadLocal.getCompanyId();
				long userId = 0;
				 userId = GetterUtil.getLong(PrincipalThreadLocal.getName());
				String realUserName = UserLocalServiceUtil.getUser(userId).getFullName();
				String userame =  UserLocalServiceUtil.getUser(userId).getScreenName();
				boolean ischangestatus = false;
				MessageUpdateAccount accstatus = null;
				for(MessageUpdateAccount pt:messageUpdate) {
					if(pt.nameField.equals("AccountStatus")) {
						ischangestatus = true;
						accstatus = pt;
					}
				}
				if(ischangestatus || acc.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh) {
					String eventType = checkAction(accstatus != null?Integer.parseInt(accstatus.valueOld):PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh,accstatus != null?Integer.parseInt(accstatus.valuenew):PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh);
					String infomessage = getInfoAction(accstatus != null?Integer.parseInt(accstatus.valueOld):PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh,accstatus != null?Integer.parseInt(accstatus.valuenew):PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh,acc);
					String className = Account.class.getName();
					 AuditRequestThreadLocal auditRequestThreadLocal = AuditRequestThreadLocal.getAuditThreadLocal();
					String clientHost = auditRequestThreadLocal.getClientHost();
					   String clientIP = auditRequestThreadLocal.getClientIP();
					   String serverName = auditRequestThreadLocal.getServerName();
					   int serverPort = auditRequestThreadLocal.getServerPort();
					   String sessionID = auditRequestThreadLocal.getSessionID();
					AuditEventLocalServiceUtil.addAuditEvent(companyId, userId, userame, eventType, className, acc.getAccountId()+"", realUserName, clientHost, clientIP, serverName, serverPort, sessionID, infomessage);
				}else {
					String eventType = checkAction(accstatus != null?Integer.parseInt(accstatus.valueOld):PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh,accstatus != null?Integer.parseInt(accstatus.valuenew):PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh);
					String className = Account.class.getName();
					String infomessage = getInfoAction(accstatus != null?Integer.parseInt(accstatus.valueOld):PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh,accstatus != null?Integer.parseInt(accstatus.valuenew):PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh,acc);
					 AuditRequestThreadLocal auditRequestThreadLocal = AuditRequestThreadLocal.getAuditThreadLocal();
					String clientHost = auditRequestThreadLocal.getClientHost();
					   String clientIP = auditRequestThreadLocal.getClientIP();
					   String serverName = auditRequestThreadLocal.getServerName();
					   int serverPort = auditRequestThreadLocal.getServerPort();
					   String sessionID = auditRequestThreadLocal.getSessionID();
					AuditEventLocalServiceUtil.addAuditEvent(companyId, userId, userame, eventType, className, acc.getAccountId()+"", realUserName, clientHost, clientIP, serverName, serverPort, sessionID, infomessage);
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public  String checkAction(int oldAccountstatus,int newAccountstatus) {
		log.info("checkAction:"+oldAccountstatus+"-"+newAccountstatus);
		if(oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Cho_Xac_Minh && newAccountstatus == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh) {
			return _configuration.get("idm.vnpost.audit.action.luutam");
		}else if((oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Cho_Xac_Minh || oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh) && newAccountstatus == PortletKeysUtil.TrangThaiKeys.Cho_Phe_Duyet) {
			return _configuration.get("idm.vnpost.audit.action.xacminhdung");
		}else if((oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Cho_Xac_Minh || oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh) && newAccountstatus == PortletKeysUtil.TrangThaiKeys.Da_Tra_KQ_Khong_Hop_Le) {
			return _configuration.get("idm.vnpost.audit.action.xacminhsai");
		}else if(oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Cho_Phe_Duyet && newAccountstatus == PortletKeysUtil.TrangThaiKeys.Cap_Chung_Nhan_Dinh_Danh) {
			return _configuration.get("idm.vnpost.audit.action.pheduyet");
		}else if(oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Cho_Phe_Duyet && newAccountstatus == PortletKeysUtil.TrangThaiKeys.Da_Tra_KQ_Khong_Hop_Le) {
			return _configuration.get("idm.vnpost.audit.action.tuchoipheduyet");
		}else if(oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh && newAccountstatus == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh) {
			return _configuration.get("idm.vnpost.audit.action.luutam");
		}else{
			return _configuration.get("idm.vnpost.audit.action.chinhsuataikhoan");
		}
	}
	public  String getInfoAction(int oldAccountstatus,int newAccountstatus,Account accnew) {
		log.info("getInfoAction:"+oldAccountstatus+"-"+newAccountstatus);
		if(oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Cho_Xac_Minh && newAccountstatus == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh) {
			System.out.println(_configuration.get("idm.vnpost.audit.massage.luutam"));
			return _configuration.get("idm.vnpost.audit.massage.luutam").replace("[$USERNAME]", accnew.getAccountName()).replace("[$FULLNAME]", accnew.getFullName()).replace("[$STATUSACCOUNT]", _configuration.get("idm.vnpost.audit.status."+accnew.getAccountStatus()));
		}else if((oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Cho_Xac_Minh || oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh) && newAccountstatus == PortletKeysUtil.TrangThaiKeys.Cho_Phe_Duyet) {
			return _configuration.get("idm.vnpost.audit.massage.xacminhdung").replace("[$USERNAME]", accnew.getAccountName()).replace("[$FULLNAME]", accnew.getFullName()).replace("[$STATUSACCOUNT]", _configuration.get("idm.vnpost.audit.status."+accnew.getAccountStatus()));
		}else if((oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Cho_Xac_Minh || oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh) && newAccountstatus == PortletKeysUtil.TrangThaiKeys.Da_Tra_KQ_Khong_Hop_Le) {
			return _configuration.get("idm.vnpost.audit.massage.xacminhsai").replace("[$USERNAME]", accnew.getAccountName()).replace("[$FULLNAME]", accnew.getFullName()).replace("[$STATUSACCOUNT]", _configuration.get("idm.vnpost.audit.status."+accnew.getAccountStatus()));
		}else if(oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Cho_Phe_Duyet && newAccountstatus == PortletKeysUtil.TrangThaiKeys.Cap_Chung_Nhan_Dinh_Danh) {
			return _configuration.get("idm.vnpost.audit.massage.pheduyet").replace("[$USERNAME]", accnew.getAccountName()).replace("[$FULLNAME]", accnew.getFullName()).replace("[$STATUSACCOUNT]", _configuration.get("idm.vnpost.audit.status."+accnew.getAccountStatus()));
		}else if(oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Cho_Phe_Duyet && newAccountstatus == PortletKeysUtil.TrangThaiKeys.Da_Tra_KQ_Khong_Hop_Le) {
			return _configuration.get("idm.vnpost.audit.massage.tuchoipheduyet").replace("[$USERNAME]", accnew.getAccountName()).replace("[$FULLNAME]", accnew.getFullName()).replace("[$STATUSACCOUNT]", _configuration.get("idm.vnpost.audit.status."+accnew.getAccountStatus()));
		}else if(oldAccountstatus == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh && newAccountstatus == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh) {
			return _configuration.get("idm.vnpost.audit.massage.luutam").replace("[$USERNAME]", accnew.getAccountName()).replace("[$FULLNAME]", accnew.getFullName()).replace("[$STATUSACCOUNT]", _configuration.get("idm.vnpost.audit.status."+accnew.getAccountStatus()));
		}else{
			return _configuration.get("idm.vnpost.audit.action.chinhsuataikhoan");
		}
	}
public  List<MessageUpdateAccount> CheckFieldUpdateAccount(Account accountOld,Account accountNew) {
		
		try {
			List<MessageUpdateAccount> out = new ArrayList<MessageUpdateAccount>();
			if(accountOld.getAccountId() != accountNew.getAccountId()) {
				MessageUpdateAccount me = new MessageUpdateAccount("AccountId",accountOld.getAccountId()+"",accountNew.getAccountId()+"",true);
				out.add(me);
			}
			if(accountOld.getAccountType() != accountNew.getAccountType()) {
				MessageUpdateAccount me = new MessageUpdateAccount("AccountType",accountOld.getAccountType()+"",accountNew.getAccountType()+"",true);
				out.add(me);
			}
			if(!accountOld.getAccountName().equals(accountNew.getAccountName())) {
				MessageUpdateAccount me = new MessageUpdateAccount("AccountName",accountOld.getAccountName()+"",accountNew.getAccountName()+"",true);
				out.add(me);
			}
			if(accountOld.getCompanyId() != accountNew.getCompanyId()) {
				MessageUpdateAccount me = new MessageUpdateAccount("CompanyId",accountOld.getCompanyId()+"",accountNew.getCompanyId()+"",true);
				out.add(me);
			}
			if(accountOld.getGroupId() != accountNew.getGroupId()) {
				MessageUpdateAccount me = new MessageUpdateAccount("GroupId",accountOld.getGroupId()+"",accountNew.getGroupId()+"",true);
				out.add(me);
			}
			if(accountOld.getUserId() != accountNew.getUserId()) {
				MessageUpdateAccount me = new MessageUpdateAccount("UserId",accountOld.getUserId()+"",accountNew.getUserId()+"",true);
				out.add(me);
			}
			if(!accountOld.getFullName().equals(accountNew.getFullName())) {
				MessageUpdateAccount me = new MessageUpdateAccount("FullName",accountOld.getFullName()+"",accountNew.getFullName()+"",true);
				out.add(me);
			}
			if(!(accountOld.getBirthdate()+"").equals(accountNew.getBirthdate()+"")) {
				MessageUpdateAccount me = new MessageUpdateAccount("Birthdate",accountOld.getBirthdate()+"",accountNew.getBirthdate()+"",true);
				out.add(me);
			}
			if(!accountOld.getEmail().equals(accountNew.getEmail())) {
				MessageUpdateAccount me = new MessageUpdateAccount("Email",accountOld.getEmail()+"",accountNew.getEmail()+"",true);
				out.add(me);
			}
			if(!accountOld.getTelNo().equals(accountNew.getTelNo())) {
				MessageUpdateAccount me = new MessageUpdateAccount("TelNo",accountOld.getTelNo()+"",accountNew.getTelNo()+"",true);
				out.add(me);
			}
			if(!accountOld.getPersonalId().equals(accountNew.getPersonalId())) {
				MessageUpdateAccount me = new MessageUpdateAccount("PersonalId",accountOld.getPersonalId()+"",accountNew.getPersonalId()+"",true);
				out.add(me);
			}
			if(!accountOld.getAddress().equals(accountNew.getAddress())) {
				MessageUpdateAccount me = new MessageUpdateAccount("Address",accountOld.getAddress()+"",accountNew.getAddress()+"",true);
				out.add(me);
			}
			if(accountOld.getGender() != accountNew.getGender()) {
				MessageUpdateAccount me = new MessageUpdateAccount("Gender",accountOld.getGender()+"",accountNew.getGender()+"",true);
				out.add(me);
			}
			if(!accountOld.getLegalDelegate().equals(accountNew.getLegalDelegate())) {
				MessageUpdateAccount me = new MessageUpdateAccount("LegalDelegate",accountOld.getLegalDelegate()+"",accountNew.getLegalDelegate()+"",true);
				out.add(me);
			}
			if(!accountOld.getTaxCode().equals(accountNew.getTaxCode())) {
				MessageUpdateAccount me = new MessageUpdateAccount("TaxCode",accountOld.getTaxCode()+"",accountNew.getTaxCode()+"",true);
				out.add(me);
			}
			if(!accountOld.getInsuranceCode().equals(accountNew.getInsuranceCode())) {
				MessageUpdateAccount me = new MessageUpdateAccount("InsuranceCode",accountOld.getInsuranceCode()+"",accountNew.getInsuranceCode()+"",true);
				out.add(me);
			}
			if(!accountOld.getNationality().equals(accountNew.getNationality())) {
				MessageUpdateAccount me = new MessageUpdateAccount("Nationality",accountOld.getNationality()+"",accountNew.getNationality()+"",true);
				out.add(me);
			}
			if(!accountOld.getEthnicGroup().equals(accountNew.getEthnicGroup())) {
				MessageUpdateAccount me = new MessageUpdateAccount("EthnicGroup",accountOld.getEthnicGroup()+"",accountNew.getEthnicGroup()+"",true);
				out.add(me);
			}
			if(!accountOld.getFamilyRegNo().equals(accountNew.getFamilyRegNo())) {
				MessageUpdateAccount me = new MessageUpdateAccount("FamilyRegNo",accountOld.getFamilyRegNo()+"",accountNew.getFamilyRegNo()+"",true);
				out.add(me);
			}
			if(accountOld.getMaritalStatus() != accountNew.getMaritalStatus()) {
				MessageUpdateAccount me = new MessageUpdateAccount("MaritalStatus",accountOld.getMaritalStatus()+"",accountNew.getMaritalStatus()+"",true);
				out.add(me);
			}
			if(!accountOld.getWorkingPlace().equals(accountNew.getWorkingPlace())) {
				MessageUpdateAccount me = new MessageUpdateAccount("WorkingPlace",accountOld.getWorkingPlace()+"",accountNew.getWorkingPlace()+"",true);
				out.add(me);
			}
			if(!accountOld.getNativePlace().equals(accountNew.getNativePlace())) {
				MessageUpdateAccount me = new MessageUpdateAccount("NativePlace",accountOld.getNativePlace()+"",accountNew.getNativePlace()+"",true);
				out.add(me);
			}
			if(!accountOld.getCityCode().equals(accountNew.getCityCode())) {
				MessageUpdateAccount me = new MessageUpdateAccount("CityCode",accountOld.getCityCode()+"",accountNew.getCityCode()+"",true);
				out.add(me);
			}
			if(!accountOld.getDistrictCode().equals(accountNew.getDistrictCode())) {
				MessageUpdateAccount me = new MessageUpdateAccount("DistrictCode",accountOld.getDistrictCode()+"",accountNew.getDistrictCode()+"",true);
				out.add(me);
			}
			if(!accountOld.getWardCode().equals(accountNew.getWardCode())) {
				MessageUpdateAccount me = new MessageUpdateAccount("WardCode",accountOld.getWardCode()+"",accountNew.getWardCode()+"",true);
				out.add(me);
			}
			if(accountOld.getAccountStatus() != accountNew.getAccountStatus()) {
				MessageUpdateAccount me = new MessageUpdateAccount("AccountStatus",accountOld.getAccountStatus()+"",accountNew.getAccountStatus()+"",true);
				out.add(me);
			}
			if(accountOld.getProcessStatus() != accountNew.getProcessStatus()) {
				MessageUpdateAccount me = new MessageUpdateAccount("ProcessStatus",accountOld.getProcessStatus()+"",accountNew.getProcessStatus()+"",true);
				out.add(me);
			}
			if(accountOld.getHoSoId() != accountNew.getHoSoId()) {
				MessageUpdateAccount me = new MessageUpdateAccount("HoSoId",accountOld.getHoSoId()+"",accountNew.getHoSoId()+"",true);
				out.add(me);
			}
			/*if(!accountOld.getMessage().equals(accountNew.getMessage())) {
				MessageUpdateAccount me = new MessageUpdateAccount("Message",accountOld.getMessage()+"",accountNew.getMessage()+"",true);
				out.add(me);
			}*/
			if(accountOld.getAssignUserId() != accountNew.getAssignUserId()) {
				MessageUpdateAccount me = new MessageUpdateAccount("AssignUserId",accountOld.getAssignUserId()+"",accountNew.getAssignUserId()+"",true);
				out.add(me);
			}
			if(accountOld.getIpLevel() != accountNew.getIpLevel()) {
				MessageUpdateAccount me = new MessageUpdateAccount("IpLevel",accountOld.getIpLevel()+"",accountNew.getIpLevel()+"",true);
				out.add(me);
			}
			if(accountOld.getReOpen() != accountNew.getReOpen()) {
				MessageUpdateAccount me = new MessageUpdateAccount("ReOpen",accountOld.getReOpen()+"",accountNew.getReOpen()+"",true);
				out.add(me);
			}
			return out;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}