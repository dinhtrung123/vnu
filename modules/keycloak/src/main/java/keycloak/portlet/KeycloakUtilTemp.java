package keycloak.portlet;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.AuthenticationFlowRepresentation;
import org.keycloak.representations.idm.AuthenticatorConfigRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.oep.core.service.ThamSoLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class KeycloakUtilTemp {
	private static Log log = LogFactoryUtil.getLog(KeycloakUtilTemp.class.getName()); 
	private static String master_url = KeycloakUtilTemp.getGiaTriThamSo("KEYCLOAK_URL_MASTER_REALM");
	private static String idp_url = KeycloakUtilTemp.getGiaTriThamSo("KEYCLOAK_URL_IDP_REALM");
	private static String master_realm = KeycloakUtilTemp.getGiaTriThamSo("KEYCLOAK_REALM_MASTER_REALM");
	private static String master_username = KeycloakUtilTemp.getGiaTriThamSo("KEYCLOAK_MASTER_USERNAME");
	private static String master_pwd = KeycloakUtilTemp.getGiaTriThamSo("KEYCLOAK_MASTER_PASSWORD");
	private static String master_client_secret = KeycloakUtilTemp.getGiaTriThamSo("KEYCLOAK_MASTER_CLIENT_SECRET");
	private static String master_clientID = KeycloakUtilTemp.getGiaTriThamSo("KEYCLOAK_MASTER_CLIENTID");
	private static String idp_realm = KeycloakUtilTemp.getGiaTriThamSo("KEYCLOAK_IDP_REALM");
	
	
	
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
				
				List<String> listValue = ur.getAttributes().get("loAs");
				log.info(listValue.toString());
				ur.getAttributes().get("loAs").set(0, "test update");
				resource.update(ur);
				
//				List<AuthenticationFlowRepresentation> listAuthFlow = keycloakMof1.realm(idp_realm).flows().getFlows();
//				for(AuthenticationFlowRepresentation auth : listAuthFlow){
//					auth.getAuthenticationExecutions()
//				}
//				keycloakMof1.realm(idp_realm).
//				
//				ur.setRequiredActions(requiredActions);
//				 List<String> listRequrieActions = ur.getRequiredActions();
//				 log.info(listRequrieActions.toString());
			  
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return null;
		
	}
	public static String getGiaTriThamSo(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}
	
	
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
			user.getAttributes().get("TechID").set(0, user.getId());
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
			log.error("xay ra loi trong qua trinh adduser tren KC "+e.getMessage());
		}
		return issucess;
	}
	
	
}
