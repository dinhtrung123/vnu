package dtt.vn.user.keys;

public class PortletKeys {

	public static final int PAGE = 1;
	public static final int DELTA = 10;
	public static final long LONG_DEFAULT = 0;
	public static final String STRING_DEFAULT = "";
	public static final long SELECT_BOX = -1;
	public static final String TEXT_BOX = STRING_DEFAULT;
	public static final boolean CHECK_BOX = false;
	public static final long TREE_ROOT_ID = -1;
	public static final String SET_VIEW_PARAMETER = "jspPage";
	public static final String REDIRECT_PAGE = "redirectPage";
	public static final String ERROR_REDIRECT_PAGE = "errorRedirectPage";
	public static final String SUCCESS_REDIRECT_PAGE = "successRedirectPage";
	public static final String AND_PARAM = "&";
	public static final String SET_PARAM = "=";
	
	public class SearchContainer {
		public static final String CURRENT_PAGE = "cur";
		public static final String DELTA = "delta";
	}
	public static final String XML_OTPSMS = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
			"   <soapenv:Header/>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:BulkSendSms>\r\n" + 
			"         <tem:msisdn>[$msisdn$]</tem:msisdn>\r\n" + 
			"         <tem:alias>[$alias$]</tem:alias>\r\n" + 
			"         <tem:message>[$message$]</tem:message>\r\n" + 
			"         <tem:sendTime>[$sendTime$]</tem:sendTime>\r\n" + 
			"         <tem:authenticateUser>[$username$]</tem:authenticateUser>\r\n" + 
			"         <tem:authenticatePass>[$password$]</tem:authenticatePass>\r\n" + 
			"      </tem:BulkSendSms>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	public static final String END_POINT_OTP_SMS = "http://brandsms.vn:8018/VMGAPI.asmx?wsdl";
}
