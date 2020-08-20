
<%@page import="org.oep.danhmuc.portlet.quanly.keys.QuanLyKeys"%>
<%@page import="org.oep.danhmuc.service.NhomLocalServiceUtil"%>
<%@page import="org.oep.danhmuc.model.Nhom"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.danhmuc.util.PortletKeys"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ include file="/quanlyaction/init.jsp" %>

<c:if test='<%= ParamUtil.getBoolean(request, "requestSuccess") %>'>
	<script type="text/javascript">
		Liferay.Util.getOpener().reload();
	</script>
</c:if>

<% 
long selectedId = ParamUtil.getLong(request, QuanLyKeys.Base.SELECTED_ID);
List<Nhom> listNhoms = NhomLocalServiceUtil.getNhoms(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>

<portlet:resourceURL var = "exportDanhMucUrl" >
	<portlet:param name="<%=PortletKeys.SET_VIEW_PARAMETER %>" value="/html/danhmuc/portlet/quanly/export.jsp"/>
	<portlet:param name="<%=QuanLyKeys.Base.SELECTED_ID %>" value="<%=String.valueOf(selectedId) %>"/>
</portlet:resourceURL>

<div class = "oep-container">
	<aui:form name = "fmt" method = "post" >
		<table width = "100%" align= "center">
			<tr>
				<td>
					<select style="display: none;"	id="oep-form-errors">
						<option value="<portlet:namespace/><%= QuanLyKeys.Base.NHOM_DANH_MUC %>">
							<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_NO_GROUP_SELECTED %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_NO_GROUP_SELECTED %>"/>
						</option>
					</select>
				</td>
			</tr>
			<tr>
 				<td>
 					<label style = "font-weight: bold;">
						<liferay-ui:message key = "org.oep.portlet.quanly.label.choose.export.group"/>
					</label> (<label class = "oep-label-red">*</label>)
 				</td>
 			</tr>
 			<tr>
 				<td>
	 				<aui:select cssClass="oep-select" label="" name="<%=QuanLyKeys.Base.ID_NHOM %>" id="<%=QuanLyKeys.Base.ID_NHOM %>" >
						<%for (Nhom g : listNhoms){%>
						<aui:option value="<%=g.getId() %>"><%=g.getTen()%></aui:option>
						<% }%>
					</aui:select>
				</td>
 			</tr>
 			<tr>
				<td>
					<label style = "font-weight: bold;">
						<liferay-ui:message key = "org.oep.portlet.quanly.label.export.file.name"/>
					</label>
				</td>
			</tr>
			<tr>
				<td>
					<aui:input type="text" cssClass="oep-inputfield" label = "" id = "<%=QuanLyKeys.Base.FILE_NAME %>" name = "<%=QuanLyKeys.Base.FILE_NAME %>" value = "<%=QuanLyKeys.Base.FILE_NAME_VALUE %>" />
				</td>
			</tr>
			<tr>
				<td>
					<button class="oep-button" type="button" onclick = "<portlet:namespace/>submitForm()">
 						 <liferay-ui:message key="org.oep.portlet.quanly.button.export"></liferay-ui:message>
 					</button>
				</td>
			</tr>
		</table>
	</aui:form>
</div>

<script>
	function <portlet:namespace/>submitForm(){
		document.<portlet:namespace/>fmt.action = "<%=exportDanhMucUrl%>";
		document.<portlet:namespace/>fmt.submit();
	}
</script>