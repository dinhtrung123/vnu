package dtt.vn.user.keycloak.connect;

import java.util.Arrays;
import java.util.List;

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

import dtt.vn.user.service.model.DataImport;
import dtt.vn.user.service.model.ThongTinCanBo;
import dtt.vn.user.utils.DangKyQuyTrinhUtil;

public class KeycloakUtilTemp {
	private static Log log = LogFactoryUtil.getLog(KeycloakUtilTemp.class.getName()); 
	private static String master_url = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_URL_MASTER_REALM");
	private static String idp_url = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_URL_IDP_REALM");
	private static String master_realm = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_REALM_MASTER_REALM");
	private static String master_username = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_MASTER_USERNAME");
	private static String master_pwd = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_MASTER_PASSWORD");
	private static String master_client_secret = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_MASTER_CLIENT_SECRET");
	private static String master_clientID = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_MASTER_CLIENTID");
	private static String idp_realm = DangKyQuyTrinhUtil.getGiaTriThamSo("KEYCLOAK_IDP_REALM");
	
	
	
	public static String getBarCode (String userName){
		
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
		  String accessToken = keycloak.tokenManager().getAccessTokenString();
		  
		  try {
			  String accessToken1 = keycloak.tokenManager().getAccessTokenString();
				Keycloak keycloakMof1 = KeycloakBuilder.builder() //
						.serverUrl(idp_url)
						.realm(idp_realm)
						.authorization(accessToken1)
						.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build()).build();
				
				List<UserRepresentation> listUserRepresentations = keycloakMof1.realm(idp_realm).users().search(userName);
				userId = listUserRepresentations.get(0).getId();
				resource = keycloakMof1.realm(idp_realm).users().get(userId);
				ur = resource.toRepresentation();
				 List<String> listRequrieActions = ur.getRequiredActions();
				 log.info(listRequrieActions.toString());
			  
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return null;
		
	}
	
	
	public static void importCanBoKC (DataImport data){
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
					credential.setValue("123456");
					credential.setTemporary(false);
					UserRepresentation user = new UserRepresentation();
					user.setUsername(data.getScreenName());
					user.setFirstName(data.getFirstName());
					user.setLastName(data.getLastName());
					user.setEmail(data.getEmailAddress());
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
					boolean isSucess = KeycloakUtilTemp.importRoleUser(data.getScreenName(), data.getNameRole());
					if(isSucess){
						log.info("set role user kc thanh cong ");
					}

				} catch (Exception e) {
					log.error("xay ra loi trong qua trinh adduser tren KC "+e.getMessage());
				}
		
	}
	
	public static boolean importRoleUser (String screenName,  String nameRole){
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
		  String accessToken = keycloak.tokenManager().getAccessTokenString();
		
		  try {
			  String accessToken1 = keycloak.tokenManager().getAccessTokenString();
				Keycloak keycloakMof1 = KeycloakBuilder.builder() //
						.serverUrl(idp_url)
						.realm(idp_realm)
						.authorization(accessToken1)
						.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build()).build();
				
				List<UserRepresentation> listUserRepresentations = keycloakMof1.realm(idp_realm).users().search(screenName);
				userId = listUserRepresentations.get(0).getId();
				resource = keycloakMof1.realm(idp_realm).users().get(userId);
				ur = resource.toRepresentation();
				
				String roleName = nameRole.trim();
				if (roleName.startsWith("4")) {
					roleName = "CanBoPheDuyet";
				} else if (roleName.startsWith("3")) {
					roleName = "CanBoXacMinh";
				}
				
				RealmResource realmResource = keycloak.realm(idp_realm);
				RoleRepresentation testerRealmRole = realmResource.roles()//
						.get(roleName).toRepresentation();
				resource.roles().realmLevel().add(Arrays.asList(testerRealmRole));
				resource.update(ur);
				log.info("update user keycloak thanh cong");
		} catch (Exception e) {
			log.info("loi trong qua trinh update user keycloak");
		}
		
		return issucess;
	}
}
