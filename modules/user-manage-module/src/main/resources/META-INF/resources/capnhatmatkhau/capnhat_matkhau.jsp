<%@page import="dtt.vn.user.quanly.keys.CapNhatMatKhauKeys"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="/capnhatmatkhau/init.jsp" %>
<style type="text/css">
body{
overflow-x : hidden;
}
</style>
<%

long userId = themeDisplay.getUserId();

User userLogin = null;

if(userId > 0) {
	try {
		
		userLogin = UserLocalServiceUtil.getUser(userId);
		
	} catch (Exception e) {
		
	}
}
%>

<portlet:actionURL var="updatePasswordUserURL" name="updatePasswordUser">
	<portlet:param name="<%=CapNhatMatKhauKeys.Base.USER_ID%>" value="<%=String.valueOf(userLogin.getUserId())%>"/>
</portlet:actionURL>

<div class="container"> 
	<div class="row">
 
		<form  method="POST" action="<%=updatePasswordUserURL %>" id="form-updatepass" enctype="multipart/form-data">
			<div>
			<%
			boolean isdonemk = false;
			boolean iserrormk = false;
			if(request.getAttribute("isdonemk") != null){
				isdonemk = Boolean.parseBoolean(request.getAttribute("isdonemk").toString());
				if(isdonemk){
					%>
					<div class="alert alert-success" role="alert">
						<liferay-ui:message key="portlet.capnhatmatkhau.success"/>
					</div>
					<%
				}
			} else if(request.getAttribute("iserrormk") != null){
				iserrormk = Boolean.parseBoolean(request.getAttribute("iserrormk").toString());
				if(iserrormk){
					%>
					<div class="alert alert-danger" role="alert">
						<liferay-ui:message key="portlet.capnhatmatkhau.error"/>
					</div>
					<%
				}
			}
			%>
			</div>
			<table align="center" class="oep-table-form" style='border:2px;' >
				<tr>
					<td colspan="2"></td>
					<td colspan="2">
						<label class="oep-label-bold"><liferay-ui:message key="org.oep.user.portlet.updatepasssworduser.label.matkhaucu"/></label> <label class="oep-label-red">*</label>
						<br>
						<aui:input  style="width: 80%;" type="password"  maxlength="" label=""  id="" title="" name ="<%=CapNhatMatKhauKeys.Base.PASSWORD_OLD %>"
						 value=""/>
					</td>
					<td colspan="2"></td>
				</tr>
				
				<tr>
					<td colspan="2"></td>
					<td colspan="2">
						<label class="oep-label-bold"><liferay-ui:message key="org.oep.user.portlet.updatepasssworduser.label.matkhaumoi"/></label>  <label class="oep-label-note"><liferay-ui:message key="org.oep.user.portlet.updatepasssworduser.label.yeucaumatkhau"/></label> <label class="oep-label-red">*</label>
						<br>
						<aui:input  style="width: 80%;" type="password"  maxlength="" label="" title="" id="" name ="<%=CapNhatMatKhauKeys.Base.PASSWORD_NEW %>"
						 value=""/>
					</td>
					<td colspan="2"></td>
				</tr>
					
				<tr>
					<td colspan="2"></td>
					<td colspan="2">
						<label class="oep-label-bold"><liferay-ui:message key="org.oep.user.portlet.updatepasssworduser.label.golaimatkhau"/></label> <label class="oep-label-red">*</label>
						<br>
						<aui:input  style="width: 80%;" type="password" maxlength="" label="" title="" id="" name ="<%=CapNhatMatKhauKeys.Base.PASSWORD_CONFIRM %>"
						 value=""/>
					</td>
					<td colspan="2"></td>
				</tr>
				
				<tr>
					<td colspan="2"></td>
					<td colspan="2">
						<label class="oep-label-note"><liferay-ui:message key="org.oep.user.portlet.updatepasssworduser.ghichu.batbuocnhap"/></label>
					</td>
					<td colspan="2"></td>
				</tr>
				
				<tr>
				<aui:row>
					<aui:col>
						<select style="display: none;"	id="oep-form-errors">
							<option value='<portlet:namespace/><%=CapNhatMatKhauKeys.Base.PASSWORD_OLD%>'>
								<liferay-ui:error key="<%=CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_OLD %>" message="<%=CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_OLD %>"/>
							</option>
							
							<option value='<portlet:namespace/><%=CapNhatMatKhauKeys.Base.PASSWORD_OLD%>'>
								<liferay-ui:error key="<%=CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_PASSWORD_ERROR %>" message="<%=CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_PASSWORD_ERROR %>"/>
							</option>
							
							<option value='<portlet:namespace/><%=CapNhatMatKhauKeys.Base.PASSWORD_NEW%>'>
								<liferay-ui:error key="<%=CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_NEW %>" message="<%=CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_NEW %>"/>
							</option>
							
							<option value='<portlet:namespace/><%=CapNhatMatKhauKeys.Base.PASSWORD_NEW%>'>
								<liferay-ui:error key="<%=CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_VALIDATE_PASSWORD_NEW %>" message="<%=CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_VALIDATE_PASSWORD_NEW %>"/>
							</option>
							
							<option value='<portlet:namespace/><%=CapNhatMatKhauKeys.Base.PASSWORD_CONFIRM%>'>
								<liferay-ui:error key="<%=CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_CONFIRM %>" message="<%=CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_CONFIRM %>"/>
							</option>
							
							<option value='<portlet:namespace/><%=CapNhatMatKhauKeys.Base.PASSWORD_CONFIRM%>'>
								<liferay-ui:error key="<%=CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_PASSWORD_NEW_NOT_DUPLICATE_PASSWORD_CONFIRM %>" message="<%=CapNhatMatKhauKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_PASSWORD_NEW_NOT_DUPLICATE_PASSWORD_CONFIRM %>"/>
							</option>
						</select>
					</aui:col>
				</aui:row>
					<td colspan="2"></td>
					<td>
						<br/>
						<button type="submit" class="btn btn-primary" > <liferay-ui:message key="org.oep.user.portlet.updatepasssworduser.button.capnhat"/></button>
					</td>
					<td colspan="2"></td>
				</tr>
			</table>
		</form>
	</div>
</div>


<script type="text/javascript">
function updatepass(){
	$('#form-updatepass').submit();
	}
var hostname = window.location.hostname;
console.log(hostname);
if(<%=isdonemk%>){
	if(hostname == "idm.vnpost.vn"){
		window.location.href = "https://postid.vnpost.vn/auth/realms/idp/protocol/openid-connect/logout?redirect_uri=https://idm.vnpost.vn/c/portal/login";
	} else if(hostname == "idm.dtt.vn"){
		window.location.href = "https://postid.vnpost.vn/auth/realms/idm/protocol/openid-connect/logout?redirect_uri=https://idm.dtt.vn/c/portal/login";
	}
}

</script>