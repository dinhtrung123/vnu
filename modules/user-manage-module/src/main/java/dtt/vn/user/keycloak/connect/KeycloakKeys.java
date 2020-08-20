package dtt.vn.user.keycloak.connect;

public class KeycloakKeys {
	
	public class Connection {
		public class Realm {
			public class Master {
				public static final String SERVER_URL ="https://postid.vnpost.vn/auth";
				public static final String REALM = "master";
				public static final String USER_NAME ="admin";
				public static final String PASSWORD = "abc@123";
				public static final String CLIENT_ID = "admin-cli";
				
			}
			public class IDP {
				public static final String SERVER_URL = "https://postid.vnpost.vn/auth";
				public static final String REALM = "idp";
				public static final String USER_NAME = "admin";
				public static final String CLIENT_ID = "idp-realm";
		}

		}
	}
	
	public class Notifications{
		public static final String CREATE_KEYCLOAK_USER_SUCCESS = "create keycloak user success";
		public static final String CREATE_KEYCLOAK_USER_ERROR = "create keycloak user error";
	}
	
}


