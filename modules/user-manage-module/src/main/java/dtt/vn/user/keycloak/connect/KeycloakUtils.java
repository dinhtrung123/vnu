package dtt.vn.user.keycloak.connect;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import dtt.vn.user.keys.Constantes;
import dtt.vn.user.service.model.ThongTinCanBo;
import dtt.vn.user.utils.DangKyQuyTrinhUtil;
import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;


public class KeycloakUtils {
	private static Log log = LogFactoryUtil.getLog(KeycloakUtils.class.getName()); 
	private static String master_url = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_URL_MASTER_REALM");
	private static String idp_url = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_URL_IDP_REALM");
	private static String master_realm = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_REALM_MASTER_REALM");
	private static String master_username = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_MASTER_USERNAME");
	private static String master_pwd = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_MASTER_PASSWORD");
	private static String master_client_secret = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_MASTER_CLIENT_SECRET");
	private static String master_clientID = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_MASTER_CLIENTID");
	private static String idp_realm = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_IDP_REALM");
	
	
	
	public static boolean changeUserPassword (String userName , String password){
		boolean result = false;
		String userId = null;
		UserRepresentation ur = null;
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
			  try {
				  String accessToken = keycloak.tokenManager().getAccessTokenString();
					Keycloak keycloakIDP = KeycloakBuilder.builder() //
							.serverUrl(idp_url)
							.realm(idp_realm)
							.authorization(accessToken)
							.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build()).build();
					
					List<UserRepresentation> listUserRepresentations = keycloakIDP.realm(idp_realm).users().search(userName);
					userId = listUserRepresentations.get(0).getId();
					resource = keycloakIDP.realm(idp_realm).users().get(userId);
					ur = resource.toRepresentation();
					CredentialRepresentation credential = new CredentialRepresentation();
		            credential.setType(CredentialRepresentation.PASSWORD);
		            credential.setValue(password);
		            credential.setTemporary(false);
		            resource.resetPassword(credential);
		            ur.getRequiredActions().remove("UPDATE_PASSWORD");
					resource.update(ur);
					log.info("Cap nhat password tren PostId thanh cong");
					result = true;
			} catch (Exception e) {
				log.error(e.getMessage());
				log.info("Cap nhat password tren PostId that bai");
			}
		return result;
	}
	
	public static boolean addUser (String userName, String email,String pwd,String fisrtName, String fullName, Map<String,List<String>> attribute, String authType ){
		boolean issucess = false;
		 Keycloak keycloak = KeycloakBuilder.builder()
					.serverUrl(master_url)
					.realm(master_realm)
					.grantType(OAuth2Constants.PASSWORD)
					.username(master_username)
					.password(master_pwd)
					.clientId(master_clientID)
					.clientSecret(master_client_secret)
					.build();
		try {
			CredentialRepresentation credential = new CredentialRepresentation();
			credential.setType(CredentialRepresentation.PASSWORD);
			credential.setValue(pwd);
			credential.setTemporary(false);
			UserRepresentation user = new UserRepresentation();
			user.setUsername(userName);
			user.setFirstName(fisrtName);
			user.setLastName(fullName);
			user.setEmail(email);
			user.setCredentials(Arrays.asList(credential));
			user.setEnabled(true);
			user.setAttributes(attribute);
			if(authType.equals("XTSMARTOTP")){
				List<String> listRequired = Collections.singletonList("CONFIGURE_TOTP");
				user.setRequiredActions(listRequired);
			}
			
			String accessToken1 = keycloak.tokenManager().getAccessTokenString();
			Keycloak keycloakMof1 = KeycloakBuilder.builder()
					.serverUrl(idp_url)
					.realm(idp_realm)
					.authorization(accessToken1)
					.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build()).build();
			
			Response result = keycloakMof1.realm(idp_realm).users().create(user);
			log.info("result keycloak : "+result.getStatusInfo());
			issucess = true;

		} catch (Exception e) {
			log.error("xay ra loi trong qua trinh adduser tren PostId "+e.getMessage());
		}
		return issucess;
	}
	public static boolean updateUser(long accountId, int ipLevel, String authType){
		boolean isSucess = false;
		String userId = null;
		UserRepresentation ur = null;
		UserResource resource = null;
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
			  if(account != null){
				  try {
					  String accessToken = keycloak.tokenManager().getAccessTokenString();
						Keycloak keycloakIDP = KeycloakBuilder.builder() //
								.serverUrl(idp_url)
								.realm(idp_realm)
								.authorization(accessToken)
								.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build()).build();
						
						List<UserRepresentation> listUserRepresentations = keycloakIDP.realm(idp_realm).users().search(account.getAccountName());
						userId = listUserRepresentations.get(0).getId();
						resource = keycloakIDP.realm(idp_realm).users().get(userId);
						ur = resource.toRepresentation();
						Map<String, List<String>> attributes = null;
						if(account.getAccountType()==Constantes.AccountType.CONG_DAN){
							 attributes = ConvertAttributes._Convert_CD(account, 1, authType);
						}else {
							 attributes = ConvertAttributes._Convert_TC(account, 1, authType);
						}
						ur.setAttributes(attributes);
						resource.update(ur);
						log.info("update user PostId thanh cong");
				} catch (Exception e) {
					log.info("loi trong qua trinh update user PostId");
				}
					
			  }log.info("account update PostId null");
		return isSucess;
		
	}
	
	public static boolean importUser (ThongTinCanBo thongTinCanBo){
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
			  
		try {
			CredentialRepresentation credential = new CredentialRepresentation();
			credential.setType(CredentialRepresentation.PASSWORD);
			credential.setValue("1");
			credential.setTemporary(false);
			UserRepresentation user = new UserRepresentation();
			user.setUsername(thongTinCanBo.getUserName());
			user.setFirstName("Can bo");
			user.setLastName("Phe Duyet");
			user.setEmail(thongTinCanBo.getEmailAddress());
			user.setCredentials(Arrays.asList(credential));
			user.setEnabled(true);
			String accessToken1 = keycloak.tokenManager().getAccessTokenString();
			Keycloak keycloakMof1 = KeycloakBuilder.builder() //
					.serverUrl(idp_url)
					.realm(idp_realm)
					.authorization(accessToken1)
					.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build()).build();
			
			Response result = keycloakMof1.realm(idp_realm).users().create(user);
			log.info("result keycloak : "+result.getStatusInfo());
			issucess = true;

		} catch (Exception e) {
			log.error("xay ra loi trong qua trinh adduser tren PostId "+e.getMessage());
		}
		return issucess;
	}
	
	public static boolean importRoleUser (ThongTinCanBo model){
		boolean issucess = false;
		String userId = null;
		UserRepresentation ur = null;
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
		
		  try {
			  String accessToken1 = keycloak.tokenManager().getAccessTokenString();
				Keycloak keycloakMof1 = KeycloakBuilder.builder() //
						.serverUrl(idp_url)
						.realm(idp_realm)
						.authorization(accessToken1)
						.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build()).build();
				
				List<UserRepresentation> listUserRepresentations = keycloakMof1.realm(idp_realm).users().search(model.getUserName());
				userId = listUserRepresentations.get(0).getId();
				resource = keycloakMof1.realm(idp_realm).users().get(userId);
				ur = resource.toRepresentation();
				RealmResource realmResource = keycloak.realm(idp_realm);
				RoleRepresentation testerRealmRole = realmResource.roles()//
						.get("CanBoPheDuyet").toRepresentation();
				resource.roles().realmLevel().add(Arrays.asList(testerRealmRole));
				resource.update(ur);
				log.info("update user PostId thanh cong");
		} catch (Exception e) {
			log.info("loi trong qua trinh update user PostId");
		}
		
		return issucess;
	}
}
