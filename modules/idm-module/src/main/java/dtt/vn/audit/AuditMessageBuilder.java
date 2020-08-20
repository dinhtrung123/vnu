package dtt.vn.audit;



import java.util.List;



import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.audit.AuditRequestThreadLocal;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;

import dtt.vn.audit.model.AuditEvent;
import dtt.vn.audit.service.AuditEventLocalServiceUtil;
import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.model.Photo;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;
import dtt.vn.vnpost.service.PhotoLocalServiceUtil;

public class AuditMessageBuilder {
 
	public static AuditEvent buildAuditMessage(String eventType, String className, long classPK, String message,
			  List < Attribute > attributes) throws SystemException {


			  long companyId = CompanyThreadLocal.getCompanyId();

			  long userId = 0;

			  JSONObject additionalInfo = JSONFactoryUtil.createJSONObject();
			  String _clientHost = "";
			  String _clientIP = "";
			  String _serverName = "";
			  int _serverPort = 0;
			  String _sessionID = "";
			  String realUserName = "dd";
			  User updater = null;

			  if (PrincipalThreadLocal.getName() != null) {
			   userId = GetterUtil.getLong(PrincipalThreadLocal.getName());

			   realUserName = Long.toString(userId);
			   try {
			    realUserName = UserLocalServiceUtil.getUser(userId).getFullName();
			    _clientIP = UserLocalServiceUtil.getUser(userId).getLoginIP();
			    // updater = UserLocalServiceUtil.getUser(userId);
			    // userName = updater.getFullName();
			   } catch (PortalException e) {
			    e.printStackTrace();
			    realUserName = "Portail exception:" + userId;

			   } catch (SystemException e) {
			    e.printStackTrace();
			    realUserName = "SystemException:" + userId;

			   }
			  } else {

			   AuditRequestThreadLocal auditRequestThreadLocal = AuditRequestThreadLocal.getAuditThreadLocal();


			   System.out.println("auditRequestThreadLocal : " + auditRequestThreadLocal.getServerName());

			   long realUserId = auditRequestThreadLocal.getRealUserId();

			   System.out.println("PrincipalThreadLocal. realUserId" + realUserId);

			   realUserName = PortalUtil.getUserName(realUserId, StringPool.BLANK);



			   if ((realUserId > 0) && (userId != realUserId)) {
			    additionalInfo.put("doAsUserId", String.valueOf(userId));
			    additionalInfo.put("doAsUserName", PortalUtil.getUserName(userId, StringPool.BLANK));
			   }

			   if (attributes != null) {
			    additionalInfo.put("attributes", _getAttributesJSON(attributes));
			   }

			   _clientHost = auditRequestThreadLocal.getClientHost();
			   _clientIP = auditRequestThreadLocal.getClientIP();
			   _serverName = auditRequestThreadLocal.getServerName();
			   _serverPort = auditRequestThreadLocal.getServerPort();
			   _sessionID = auditRequestThreadLocal.getSessionID();
			  }


			if (!eventType.equals(EventTypes.DELETE)) {
				  Photo photo = PhotoLocalServiceUtil.fetchPhoto(classPK);
				  Account account = AccountLocalServiceUtil.fetchAccount(photo.getClassPK());
				  additionalInfo.put("name", account.getFullName());
				  additionalInfo.put("emai", account.getEmail());
				
			}


			  //additionalInfo.put("action ", message);
			  /*return new AuditMessage(eventType, companyId, realUserId, realUserName, className, String.valueOf(classPK),
			  		null, additionalInfo);*/
			  return AuditEventLocalServiceUtil.addAuditEvent(companyId, userId, realUserName, eventType, className, String.valueOf(classPK),
			   additionalInfo.toString(), _clientHost, _clientIP, _serverName, _serverPort, _sessionID, message);
			 }

			 
			public static AuditEvent buildAuditMessageAccount(String eventType, String className, long classPK, String message,
					  List < Attribute > attributes) throws SystemException {


					  long companyId = CompanyThreadLocal.getCompanyId();

					  long userId = 0;

					  JSONObject additionalInfo = JSONFactoryUtil.createJSONObject();
					  JSONObject messageInfo = JSONFactoryUtil.createJSONObject();
					  String _clientHost = "";
					  String _clientIP = "";
					  String _serverName = "";
					  int _serverPort = 0;
					  String _sessionID = "";
					  String realUserName = "dd";
					  User updater = null;

					  if (PrincipalThreadLocal.getName() != null) {
					   userId = GetterUtil.getLong(PrincipalThreadLocal.getName());

					   realUserName = Long.toString(userId);
					   try {
					    realUserName = UserLocalServiceUtil.getUser(userId).getFullName();
					    _clientIP = UserLocalServiceUtil.getUser(userId).getLoginIP();
					    // updater = UserLocalServiceUtil.getUser(userId);
					    // userName = updater.getFullName();
					   } catch (PortalException e) {
					    e.printStackTrace();
					    realUserName = "Portail exception:" + userId;

					   } catch (SystemException e) {
					    e.printStackTrace();
					    realUserName = "SystemException:" + userId;

					   }
					  } else {

					   AuditRequestThreadLocal auditRequestThreadLocal = AuditRequestThreadLocal.getAuditThreadLocal();


					   System.out.println("auditRequestThreadLocal : " + auditRequestThreadLocal.getServerName());

					   long realUserId = auditRequestThreadLocal.getRealUserId();

					   System.out.println("PrincipalThreadLocal. realUserId" + realUserId);

					   realUserName = PortalUtil.getUserName(realUserId, StringPool.BLANK);



					   if ((realUserId > 0) && (userId != realUserId)) {
					    additionalInfo.put("doAsUserId", String.valueOf(userId));
					    additionalInfo.put("doAsUserName", PortalUtil.getUserName(userId, StringPool.BLANK));
					   }


					   _clientHost = auditRequestThreadLocal.getClientHost();
					   _clientIP = auditRequestThreadLocal.getClientIP();
					   _serverName = auditRequestThreadLocal.getServerName();
					   _serverPort = auditRequestThreadLocal.getServerPort();
					   _sessionID = auditRequestThreadLocal.getSessionID();
					  }

					  
						  Account account = AccountLocalServiceUtil.fetchAccount(classPK);
						  additionalInfo.put("name", account.getFullName());
						  additionalInfo.put("emai", account.getEmail());
						
					


					   if (attributes != null) {
						   messageInfo.put("attributes", _getAttributesJSON(attributes));
						  }


					  //additionalInfo.put("action ", message);
					  /*return new AuditMessage(eventType, companyId, realUserId, realUserName, className, String.valueOf(classPK),
					  		null, additionalInfo);*/
					  return AuditEventLocalServiceUtil.addAuditEvent(companyId, userId, realUserName, eventType, className, String.valueOf(classPK),
					   additionalInfo.toString(), _clientHost, _clientIP, _serverName, _serverPort, _sessionID, messageInfo.toString());
					 }

			 
			 private static JSONArray _getAttributesJSON(List < Attribute > attributes) {
			  JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

			  for (Attribute attribute: attributes) {
			   JSONObject attributeJSONObject = JSONFactoryUtil.createJSONObject();

			   attributeJSONObject.put("name", attribute.getName());
			   attributeJSONObject.put("newValue", attribute.getNewValue());
			   attributeJSONObject.put("oldValue", attribute.getOldValue());

			   jsonArray.put(attributeJSONObject);
			  }

			  return jsonArray;
			 }

			 public static AuditMessage buildAuditMessage(
						String eventType, String className, long classPK,
						List<Attribute> attributes) {

						long companyId = CompanyThreadLocal.getCompanyId();

						long userId = 0;

						if (PrincipalThreadLocal.getName() != null) {
							userId = GetterUtil.getLong(PrincipalThreadLocal.getName());
						}

						AuditRequestThreadLocal auditRequestThreadLocal =
							AuditRequestThreadLocal.getAuditThreadLocal();

						long realUserId = auditRequestThreadLocal.getRealUserId();
						String realUserName = PortalUtil.getUserName(
							realUserId, StringPool.BLANK);

						JSONObject additionalInfo = JSONFactoryUtil.createJSONObject();

						if ((realUserId > 0) && (userId != realUserId)) {
							additionalInfo.put("doAsUserId", String.valueOf(userId));
							additionalInfo.put(
								"doAsUserName",
								PortalUtil.getUserName(userId, StringPool.BLANK));
						}

						if (attributes != null) {
							additionalInfo.put("attributes", _getAttributesJSON(attributes));
						}

						return new AuditMessage(
							eventType, companyId, realUserId, realUserName, className,
							String.valueOf(classPK), null, additionalInfo);
					}
 
 
}