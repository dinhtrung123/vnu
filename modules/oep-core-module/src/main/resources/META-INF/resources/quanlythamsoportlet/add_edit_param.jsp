


<%@page import="org.oep.util.MyLanguageUtil"%>
<%@page import="org.oep.core.keys.ThamSoKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.core.model.ThamSoLoai"%>
<%@page import="org.oep.core.service.ThamSoLoaiLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.core.thamso.action.ThamSoForm"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="org.oep.util.PortletKeys"%>

<%@ include file="/quanlythamsoportlet/init.jsp" %>


<%
ThamSoForm form = (ThamSoForm) request.getAttribute("thamSoForm");
if(form == null){
	form = new ThamSoForm(request);
}
List<ThamSoLoai> lsttsl = ThamSoLoaiLocalServiceUtil.getAll();
List<String[]> plainErrorList = (List<String[]>) request.getAttribute("plainErrorList");
List<String[]> htmlErrorList = (List<String[]>) request.getAttribute("htmlErrorList");
%>

<portlet:actionURL var="addParamURL" name = "addParam">	
	<portlet:param name="thamSoId" value='<%= ParamUtil.getString(request, "thamSoId")  %>'/>
	<portlet:param name="<%= PortletKeys.SET_VIEW_PARAMETER %>" value='/quanlythamsoportlet/add_edit_param.jsp'/>	
	<portlet:param name="<%= PortletKeys.REDIRECT_PAGE %>" value='<%= ParamUtil.getString(request, PortletKeys.REDIRECT_PAGE) %>'/>
</portlet:actionURL>

<div class = "oep-container">
 	 <c:if test="<%= plainErrorList != null %>">
		<%for(String[] errorInfo : plainErrorList){%>
			 <liferay-ui:error key="<%= errorInfo[0] %>" message = "<%= MyLanguageUtil.get(request,request.getLocale(), errorInfo[1]) %>"/> 
			<%-- <liferay-ui:error key="<%= errorInfo[0] %>" message = "Loi"/> --%>
		<%}%>
	</c:if>
	
	<c:if test="<%= htmlErrorList != null %>">
		<select id="oep-form-errors" style="display: none;">
			<%for(String[] errorInfo : htmlErrorList){%>
				<option value="<portlet:namespace/><%= errorInfo[0] %>">
		  			<%-- <liferay-ui:error key="<%= errorInfo[1] %>" message = "<%= LanguageUtil.get(pageContext, errorInfo[2]) %>"/> --%>
		  			<liferay-ui:error key="<%= errorInfo[1] %>" message = "loi"/>
				</option>
			<%}%>
		</select>
	</c:if> 
 	
 	<aui:form name="fmt" action="<%= addParamURL %>" method="post">
 		<table width = "90%" align = "center" > 			
 			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="<%= form.thamSoId == 0 %>">
							</br>
							<label style = "font-weight:bold; font-size:18px"><liferay-ui:message key="org.oep.core.portlet.thamso.detailpage.addparam"/></label>
						</c:when>
						<c:otherwise>
							</br>
							<label style = "font-weight:bold; font-size:18px"><liferay-ui:message key="org.oep.core.portlet.thamso.detailpage.editparam"/></label>
						</c:otherwise>
					</c:choose>
 				</td>
 			</tr>

 			<tr>
 				<td width= 25%>
 					</br>
 					<label class="oep-label-bold"><liferay-ui:message key="org.oep.core.portlet.thamso.text.label.type"/>
 				</td>
 				</br>
 				<td width= 80%>
 					<label class="oep-label-bold"><liferay-ui:message key="org.oep.core.portlet.thamso.text.label.ma"/></label>(<label class="oep-label-red">*</label>)
 				</td>
 			</tr>
 			<tr>
 				<td>
 					 <aui:select cssClass="oep-select" label="" name="loaiId">
						<%for (ThamSoLoai n : lsttsl){%>
							<aui:option value="<%=n.getId()%>" selected="<%= n.getId() == form.loaiId %>"  ><%=n.getTen() %></aui:option>
						<% }%>
					  </aui:select>
 				</td>
 				<td >
 					<aui:input type="text" name="ma" value="<%= form.ma %>" cssClass="oep-inputfield"  maxlength="<%= ThamSoKeys.Base.MA_MAX_LENGTH %>" label="" />
 				</td>
 			</tr>
 			
 			<!-- value - status-->
 			<tr>
 				<td width= 25%>
 					<label class="oep-label-bold"><liferay-ui:message key="org.oep.core.portlet.thamso.text.label.value"/></label>
 				</td>
 				<td width= 75%>
 					<label class="oep-label-bold"><liferay-ui:message key="org.oep.core.portlet.thamso.text.label.status"/></label>
 				</td>
 			</tr>
 			<tr>
 				<td >
 					<aui:input type="text" name="giaTri" value="<%= form.giaTri %>" cssClass="oep-inputfield"  label=""/>
 				</td>
 				<td>
 					 <aui:select name="trangThai" cssClass="oep-select" style="width:100%;" label="">
						<aui:option value="1" selected="<%= form.trangThai %>"><liferay-ui:message key="org.oep.core.portlet.thamso.select.active"/></aui:option>
						<aui:option value="0" selected="<%= !form.trangThai %>"><liferay-ui:message key="org.oep.core.portlet.thamso.select.inactive"/></aui:option>
					  </aui:select>
 				</td>
 			</tr>
			<!--description -->
 			<tr>
 				<td colspan="2" >
 					<label class="oep-label-bold"><liferay-ui:message key="org.oep.core.portlet.thamso.text.label.description"/></label>
 				</td>
 			</tr>
 			<tr>
 				<td colspan="2">
	 				<div>
	 					<liferay-ui:input-editor height="100" name="descriptionEditor" toolbarSet="liferay-article" initMethod="initDescription" />
						<aui:input type="hidden" name="moTa" value="<%= form.moTa %>" style="width: 100%;height:150px" label=""/>
	 				</div>
 				</td>
 			</tr>
 			<tr>
				<td colspan="2">
					<label class="oep-label-note"><liferay-ui:message key="org.oep.core.portlet.thamso.label.ghichu1"/></label>
					<label class="oep-label-red">&nbsp;*&nbsp;</label>
					<label class ="oep-label-note"><liferay-ui:message key="org.oep.core.portlet.thamso.label.ghichu2"/></label>
				</td>
			</tr> 			
 		</table>
 		<input type="submit" class="oep-button primary save" onclick="<portlet:namespace />submitForm()" value='<liferay-ui:message key="org.oep.core.portlet.thamso.button.save" />' />
		<input type="button" class = "oep-button undo" onclick='location.href="<%= ParamUtil.getString(request, PortletKeys.REDIRECT_PAGE)%>";' value='<liferay-ui:message key="org.oep.core.portlet.thamso.button.back"/>'/>
 	</aui:form>
 </div>
<script>
	
	function <portlet:namespace/>initDescription() {
		return "<%= UnicodeFormatter.toString(form.moTa)%>";
	}
	
	function <portlet:namespace/>submitForm(){
		document.<portlet:namespace/>fmt.<portlet:namespace/>moTa.value = window.<portlet:namespace/>descriptionEditor.getHTML();
	}
</script>
