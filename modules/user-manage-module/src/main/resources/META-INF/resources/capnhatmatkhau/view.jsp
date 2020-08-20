<%@page import="dtt.vn.user.quanly.keys.CapNhatMatKhauKeys"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/capnhatmatkhau/init.jsp" %>

<%

long userId = themeDisplay.getUserId();

User userLogin = null;

if(userId > 0) {
	try {
		
		userLogin = UserLocalServiceUtil.getUser(userId);
		
	} catch (Exception e) {
		
	}
}

String redirectURL = "/c/portal/login";
%>

<liferay-ui:success key="<%=CapNhatMatKhauKeys.Notification.UPDATE_PASS_SUCCESS %>" message="<%=CapNhatMatKhauKeys.Notification.UPDATE_PASS_SUCCESS %>"/>


<c:choose>
	<c:when test="<%=themeDisplay.isSignedIn()%>">
		<c:if test="<%= userId > 0 &&  userLogin != null %>">
			<liferay-util:include page="/capnhatmatkhau/capnhat_matkhau.jsp" servletContext="<%= this.getServletContext() %>"/>	
		</c:if>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			window.location.href = "<%=redirectURL%>";
		</script>
	</c:otherwise>
	
	</c:choose>