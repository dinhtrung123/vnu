<%@page import="dtt.vn.user.keycloak.connect.KeycloakUtils"%>
<%@page import="dtt.vn.user.keycloak.connect.ToolUtil"%>
<%@page import="dtt.vn.user.quanly.keys.CapNhatMatKhauKeys"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/capnhatmatkhau/init.jsp" %>

<%
System.out.println("test portlet.properties");
String json = ToolUtil.getMoTaThamSo(20126, "TOOL_ADD_USER");
System.out.println(json);
KeycloakUtils.addUser(json);
System.out.println("test insert thanh cong");
%>