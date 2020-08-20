package dtt.vn.account.util;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import dtt.vn.account.business.Constantes;
import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;


public class KeycloakUtils {
	private static Log log = LogFactoryUtil.getLog(KeycloakUtils.class.getName()); 
	private static final Configuration _configuration = ConfigurationFactoryUtil
		    .getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	private static String master_url = AccountUtil.getGiaTriThamSo("KEYCLOAK_URL_MASTER_REALM");
	private static String idp_url = AccountUtil.getGiaTriThamSo("KEYCLOAK_URL_IDP_REALM");
	private static String master_realm = AccountUtil.getGiaTriThamSo("KEYCLOAK_REALM_MASTER_REALM");
	private static String master_username = AccountUtil.getGiaTriThamSo("KEYCLOAK_MASTER_USERNAME");
	private static String master_pwd = AccountUtil.getGiaTriThamSo("KEYCLOAK_MASTER_PASSWORD");
	private static String master_client_secret = AccountUtil.getGiaTriThamSo("KEYCLOAK_MASTER_CLIENT_SECRET");
	private static String master_clientID = AccountUtil.getGiaTriThamSo("KEYCLOAK_MASTER_CLIENTID");
	private static String idp_realm = AccountUtil.getGiaTriThamSo("KEYCLOAK_IDP_REALM");
	
	public static boolean addUser (String userName, String email,String pwd,String cmnd, String fullName, Map<String,List<String>> attribute ){
		boolean issucess = false;
		 Keycloak keycloak = KeycloakBuilder.builder() //
				 .serverUrl(master_url)
					.realm(master_realm)
					.grantType(OAuth2Constants.PASSWORD)
					.username(master_username)
					.password(master_pwd)
					.clientId(master_clientID)
					.clientSecret(master_client_secret)
					.build();
			  String accessToken = keycloak.tokenManager().getAccessTokenString();
		try {
			CredentialRepresentation credential = new CredentialRepresentation();
			credential.setType(CredentialRepresentation.PASSWORD);
			credential.setValue(pwd);
			credential.setTemporary(false);
			UserRepresentation user = new UserRepresentation();
			user.setUsername(userName);
			user.setFirstName(cmnd);
			user.setLastName(fullName);
			user.setEmail(email);
			user.setCredentials(Arrays.asList(credential));
			user.setEnabled(true);
			user.setAttributes(attribute);
			String accessToken1 = keycloak.tokenManager().getAccessTokenString();
			Keycloak keycloakMof1 = KeycloakBuilder.builder() //
					.serverUrl(idp_url)
					.realm(idp_realm)
					.authorization(accessToken1)
					.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build()).build();
			
			Response result = keycloakMof1.realm(idp_realm).users().create(user);
			log.info("result keycloak : "+result.getStatusInfo());
			
			System.out.println("da vao realm idp, clientid");
			

		} catch (Exception e) {
			System.out.println("loi khi create");
		}
		return issucess;
	}
	public static boolean updateUser(long accountId, int ipLevel){
		boolean isSucess = false;
		String userId = null;
		UserRepresentation ur = null;
		UserResource resource = null;
		String validDate = "";
		String expiredDate ="";
		Calendar c1 = Calendar.getInstance();
		
		Account account = AccountLocalServiceUtil.fetchAccount(accountId);
		 Keycloak keycloak = KeycloakBuilder.builder() //
				 .serverUrl(master_url)
					.realm(master_realm)
					.grantType(OAuth2Constants.PASSWORD)
					.username(master_username)
					.password(master_pwd)
					.clientId(master_clientID)
					.clientSecret(master_client_secret)
					.build();
			  String accessToken = keycloak.tokenManager().getAccessTokenString();
			  if(account != null){
				  try {
					  String accessToken1 = keycloak.tokenManager().getAccessTokenString();
						Keycloak keycloakMof1 = KeycloakBuilder.builder() //
								.serverUrl(idp_url)
								.realm(idp_realm)
								.authorization(accessToken1)
								.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build()).build();
						
						List<UserRepresentation> listUserRepresentations = keycloakMof1.realm(idp_realm).users().search(account.getAccountName());
						userId = listUserRepresentations.get(0).getId();
						resource = keycloakMof1.realm(idp_realm).users().get(userId);
						ur = resource.toRepresentation();
						log.info("user KC : "+ur.getId());

//						Map<String, List<String>> attributes = null;
//						if(account.getAccountType()==Constantes.AccountType.CONG_DAN){
//							 attributes =ConvertAttributes._Convert_CD(account);
//						}else {
//							attributes = ConvertAttributes._Convert_TC(account);
//						}
//						ur.setAttributes(attributes);
						validDate = DateUtil.parseDateToString(account.getCreateDate(), DateUtil.DATE_FORMAT_Y_M_D_H);
						c1.roll(Calendar.YEAR, 1);
						expiredDate = DateUtil.parseDateToString(c1.getTime(), DateUtil.DATE_FORMAT_Y_M_D_KEYCLOAK);
						JSONObject loAs = new JSONFactoryUtil().createJSONObject();
					 	loAs.put("claim","SoCMND");
					 	loAs.put("level", String.valueOf(account.getIpLevel()));
					 	loAs.put("src", "VNPOST");
					 	loAs.put("validDate", validDate);
					 	loAs.put("expired_date", expiredDate);
					 	
					 	
						ur.getAttributes().get("loAs").set(0, loAs.toJSONString());
						resource.update(ur);
						log.info("update user keycloak thanh cong");
				} catch (Exception e) {
					log.info("loi trong qua trinh update user keycloak");
				}
					
			  }else {
				log.error("account Null");
			}
		return isSucess;
		
	}
	public static boolean deleteUserByUseNameKC (String userName){
		boolean result = false;
		String userId = null;
		UserResource resource = null;
		Keycloak keycloak = KeycloakBuilder.builder() //
				.serverUrl(master_url)
				.realm(master_realm)
				.grantType(OAuth2Constants.PASSWORD)
				.username(master_username)
				.password(master_pwd)
				.clientId(master_clientID)
				.clientSecret(master_client_secret)
				.build();
		if(!userName.equals("")){
			try {
				  String accessToken1 = keycloak.tokenManager().getAccessTokenString();
					Keycloak keycloakMof1 = KeycloakBuilder.builder() //
							.serverUrl(idp_url)
							.realm(idp_realm)
							.authorization(accessToken1)
							.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build()).build();
					
					List<UserRepresentation> listUserRepresentations = keycloakMof1.realm(idp_realm).users().search(userName);
					userId = listUserRepresentations.get(0).getId();
					if(!userId.equals("")){
						resource = keycloakMof1.realm(idp_realm).users().get(userId);
						if(resource != null){
							log.info("In KeycloakUtil remove User with userID :"+userId);
							resource.remove();
							log.info("In KeycloakUtil remove USer success");
						}
					}else {
						log.info("In KeycloakUtil method deleteUser Exception.....UserId null");
					}
					
			} catch (Exception e) {
				log.info("loi trong qua trinh update user keycloak");
			}
		}
		
		return result;
		
	}
	
	
}
