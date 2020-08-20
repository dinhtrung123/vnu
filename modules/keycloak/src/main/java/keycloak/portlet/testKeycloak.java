package keycloak.portlet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RequiredActionProviderRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import com.google.gson.Gson;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;



public class testKeycloak {
	private static final Configuration _configuration = ConfigurationFactoryUtil
		    .getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	
	private static Log log = LogFactoryUtil.getLog(testKeycloak.class.getName()); 
	public static boolean addUser (String json){
		
		boolean issucess = false;
		 Keycloak keycloak = KeycloakBuilder.builder() //
					.serverUrl(_configuration.get("connect.keycloak.master.serverurl"))
					.realm(_configuration.get("connect.keycloak.master.realm"))
					.grantType(OAuth2Constants.PASSWORD)
					.username(_configuration.get("connect.keycloak.master.username"))
					.password(_configuration.get("connect.keycloak.master.password"))
					.clientId(_configuration.get("connect.keycloak.master.clientid"))
					.clientSecret(_configuration.get("connect.keycloak.master.clientsecret"))
					.build();
			  String accessToken = keycloak.tokenManager().getAccessTokenString();
			  ToolModel[] modelarr = ToolUtil.getModelFromJsonNoiDung(json);
			  for(ToolModel model : modelarr){
				  try {
						
						CredentialRepresentation credential = new CredentialRepresentation();
						credential.setType(CredentialRepresentation.PASSWORD);
						credential.setValue("1");
						credential.setTemporary(false);
						UserRepresentation user = new UserRepresentation();
						user.setUsername(model.getUserNameXM());
						user.setFirstName("Can Bo");
						user.setLastName(model.getFullName());
						user.setEmail(model.getEmailXM());
						user.setCredentials(Arrays.asList(credential));
						user.setEnabled(true);
						String accessToken1 = keycloak.tokenManager().getAccessTokenString();
						Keycloak keycloakMof1 = KeycloakBuilder.builder() //
								.serverUrl(_configuration.get("connect.keycloak.idp.serverurl"))
								.realm(_configuration.get("connect.keycloak.idp.realm"))
								.authorization(accessToken1)
								.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build()).build();
						
						Response result = keycloakMof1.realm(_configuration.get("connect.keycloak.idp.realm")).users().create(user);
						log.info("result keycloak : "+result.getStatusInfo());
						issucess = true;

					} catch (Exception e) {
						log.error("xay ra loi trong qua trinh adduser tren KC "+e.getMessage());
					}
			  }
		
		return issucess;
	}
	public static boolean updateUser(String email, String userName){
		boolean isSucess = false;
		String userId = null;
		UserRepresentation ur = null;
		UserResource resource = null;
		 Keycloak keycloak = KeycloakBuilder.builder() //
					.serverUrl(_configuration.get("connect.keycloak.master.serverurl"))
					.realm(_configuration.get("connect.keycloak.master.realm"))
					.grantType(OAuth2Constants.PASSWORD)
					.username(_configuration.get("connect.keycloak.master.username"))
					.password(_configuration.get("connect.keycloak.master.password"))
					.clientId(_configuration.get("connect.keycloak.master.clientid"))
					.clientSecret(_configuration.get("connect.keycloak.master.clientsecret"))
					.build();
			  String accessToken = keycloak.tokenManager().getAccessTokenString();
		try {

			String accessToken1 = keycloak.tokenManager().getAccessTokenString();
			Keycloak keycloakMof1 = KeycloakBuilder.builder() //
					.serverUrl(_configuration.get("connect.keycloak.idp.serverurl"))
					.realm(_configuration.get("connect.keycloak.idp.realm"))
					.authorization(accessToken1)
					.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build()).build();
			
			List<UserRepresentation> listUserRepresentations = keycloakMof1.realm(_configuration.get("connect.keycloak.idp.realm")).users().search(userName);
			userId = listUserRepresentations.get(0).getId();
			resource = keycloakMof1.realm(_configuration.get("connect.keycloak.idp.realm")).users().get(userId);
			ur = resource.toRepresentation();
			List<String> listRequireAction = ur.getRequiredActions();
			keycloakMof1.realm(_configuration.get("connect.keycloak.idp.realm")).users().get(userId).removeTotp();
			
			RequiredActionProviderRepresentation requiredActionProviderRepresentation = keycloakMof1.realm(_configuration.get("connect.keycloak.idp.realm")).flows().getRequiredAction("Configure OTP");
			requiredActionProviderRepresentation.getPriority();
			System.out.println(listRequireAction.toString());
			

		} catch (Exception e) {
			System.out.println("loi khi get require ");
		}
		
		return isSucess;
		
	}
	
	
	public static boolean updateAuthType (String userName, String authType){
		boolean result = false;
		String userId = null;
		UserRepresentation ur = null;
		UserResource resource = null;
		Keycloak keycloak = KeycloakBuilder.builder() //
				.serverUrl(_configuration.get("connect.keycloak.master.serverurl"))
				.realm(_configuration.get("connect.keycloak.master.realm"))
				.grantType(OAuth2Constants.PASSWORD)
				.username(_configuration.get("connect.keycloak.master.username"))
				.password(_configuration.get("connect.keycloak.master.password"))
				.clientId(_configuration.get("connect.keycloak.master.clientid"))
				.clientSecret(_configuration.get("connect.keycloak.master.clientsecret"))
					.build();
			  String accessToken = keycloak.tokenManager().getAccessTokenString();
		try {
			String accessToken1 = keycloak.tokenManager().getAccessTokenString();
			Keycloak keycloakMof1 = KeycloakBuilder.builder() //
					.serverUrl(_configuration.get("connect.keycloak.idp.serverurl"))
					.realm("idp")
					.authorization(accessToken1)
					.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build()).build();
			
			List<UserRepresentation> listUserRepresentations = keycloakMof1.realm("idp").users().search(userName);
			userId = listUserRepresentations.get(0).getId();
			resource = keycloakMof1.realm("idp").users().get(userId);
			resource.disableCredentialType(Arrays.asList(""));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return result;
	}
}
