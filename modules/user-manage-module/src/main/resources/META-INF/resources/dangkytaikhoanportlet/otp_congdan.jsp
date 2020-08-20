<%@page import="dtt.vn.user.utils.DangKyQuyTrinhUtil"%>
<%@page import="dtt.vn.user.keycloak.connect.KeycloakUtils"%>
<%@page import="dtt.vn.user.keys.PortletKeys"%>
<%@page import="dtt.vn.user.keys.DangKyTaiKhoanKeys"%>
<%@ include file="/dangkytaikhoanportlet/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/dangkytaikhoanportlet/init.jsp" %>
<portlet:defineObjects />

<%
String userName = ParamUtil.getString(request, "userName");
String maOTP = ParamUtil.getString(request, "maOTP");
String thongBao = DangKyQuyTrinhUtil.getMoTaThamSo(themeDisplay.getScopeGroupId(), DangKyTaiKhoanKeys.Base.THONG_BAO_KICHHOAT_OTP_CD);
String error = ParamUtil.getString(request, "error","");

%>

<portlet:actionURL var="kichHoatOTPCongDanURL" name="kichHoatOTPCongDan">
	<portlet:param name="userName" value="<%=userName %>"/>
	<portlet:param name="maOTP" value="<%=maOTP %>"/>
</portlet:actionURL>
<portlet:actionURL var="guiLaiOTPURL" name="guiLaiOTP">
	<portlet:param name="userName" value="<%=userName %>"/>
</portlet:actionURL>

<div class="container">
	<form name="fmt" method="post" action="<%=kichHoatOTPCongDanURL.toString() %>">
		<table align="center" >
			<tr>
				<td colspan="12">
					<div>
						
						
						<div><%=thongBao %></div>
						
						<%if(!error.equals("")){
							%>
							<div style="color:#FF0000;font-size:18px;">
								<label class="oep-label-bold"><liferay-ui:message key="dtt.vn.user.otp.error.invalid"/></label>
							</div>
							<%
						} %>
						
						<label class="oep-label-bold"><liferay-ui:message key="dtt.vn.user.otp.congdan.nhapmaotp"/></label> <label class="oep-label-red">*</label>
						<input type="text" name="<portlet:namespace/>otpText" id="<portlet:namespace/>otpText" required/>
						<button class = "oep-button primary save" type="submit">
							<liferay-ui:message key="dtt.vn.user.otp.button.kichhoat.congdan"/>
						</button>
						
					</div>
				</td>
			</tr>
		</table>

	</form>

</div>