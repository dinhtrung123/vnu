
<%@page import="org.oep.danhmuc.portlet.quanly.keys.QuanLyKeys"%>
<%@page import="org.oep.danhmuc.service.NhomLocalServiceUtil"%>
<%@page import="org.oep.danhmuc.model.Nhom"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
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
 
 <portlet:actionURL var = "importDanhMucUrl" name = "importDanhMuc">
 	<portlet:param name = "<%=PortletKeys.SET_VIEW_PARAMETER %>" value = "/quanlyaction/import.jsp"/>
 	<portlet:param name = "<%=QuanLyKeys.Base.SELECTED_ID %>" value = "<%=String.valueOf(selectedId) %>"/>
 </portlet:actionURL>
 
 <div class = "oep-container">
 	<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_IMPORT_DUPLICATE_CODE %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_IMPORT_DUPLICATE_CODE %>"/>
 	<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_IMPORT_DUPLICATE_NAME %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_IMPORT_DUPLICATE_NAME %>"/>
 	<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_INVALID_IMPORT_CONTENT %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_INVALID_IMPORT_CONTENT %>"/>
 	<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_FILE_NOT_FOUND %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_FILE_NOT_FOUND %>"/>
 	<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_INVALID_FILE_FORMAT %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_INVALID_FILE_FORMAT %>"/>
 	<aui:form method="post" action="<%= importDanhMucUrl %>" enctype="multipart/form-data">
 		<table width = "100%" align= "center">
 			<tr>
				<td>
					<select style="display: none;"	id="oep-form-errors">
						<option value="<portlet:namespace/><%= QuanLyKeys.Base.NHOM_DANH_MUC %>">
							<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_NO_GROUP_SELECTED %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_NO_GROUP_SELECTED %>"/>
						</option>
						<option value="<portlet:namespace/><%= QuanLyKeys.Base.LABEL_INPUT_FILE %>">
							<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_FILE_NOT_FOUND %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_FILE_NOT_FOUND %>"/>
						</option>
						<option value="<portlet:namespace/><%= QuanLyKeys.Base.LABEL_INPUT_FILE %>">
							<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_INVALID_FILE_FORMAT %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_INVALID_FILE_FORMAT %>"/>
						</option>
					</select>
				</td>
			</tr>
 			<tr>
 				<td>
 					<label style = "font-weight: bold;">
						<liferay-ui:message key = "org.oep.portlet.quanly.label.choose.import.group"/>
					</label> (<label class = "oep-label-red">*</label>)
 				</td>
 			</tr>
 			<tr>
 				<td>
	 				<aui:select cssClass="oep-select" label="" name="<%=QuanLyKeys.Base.NHOM_DANH_MUC %>" id="<%=QuanLyKeys.Base.NHOM_DANH_MUC %>" >
						<aui:option value = "0"><liferay-ui:message key="org.oep.portlet.quanly.select.nhomdanhmuc"/></aui:option>
						<%for (Nhom g : listNhoms){%>
						<aui:option value="<%=g.getId() %>"><%=g.getTen()%></aui:option>
						<% }%>
					</aui:select>
				</td>
 			</tr>
 			<tr>
 				<td style = "padding-bottom:6px">
 					<label style = "font-weight: bold;">
						<liferay-ui:message key = "org.oep.portlet.quanly.label.choose.file"/>
					</label> (<label class = "oep-label-red"><liferay-ui:message key = "org.oep.portlet.quanly.label.file.format"/></label>)
 				</td>
 			</tr>
 			<tr>
 				<td>
 					<label id = "<portlet:namespace/><%=QuanLyKeys.Base.LABEL_INPUT_FILE %>" for="<%=QuanLyKeys.Base.IMPORT_FILE %>" style = " border: 1px solid #ccc;display: inline-block; padding: 6px 7px;cursor: pointer;">
					    <liferay-ui:message key="org.oep.portlet.quanly.input.file"></liferay-ui:message>
					</label> <label id = "fileName" style = "font-style:italic; padding-left:7px"></label>
					<input type="file"  style = "display:none" name = "<%=QuanLyKeys.Base.IMPORT_FILE %>" id="<%=QuanLyKeys.Base.IMPORT_FILE %>" label="" />
 				</td>
 			</tr>
 			<tr>
 				<td>
 					</br>
 					<button class = "oep-button" type = "submit">
 						 <liferay-ui:message key="org.oep.portlet.quanly.button.import"></liferay-ui:message>
 					</button>
 				</td>
 			</tr>
 		</table>
 	</aui:form>
 </div>
 

					
<script>
$('#<portlet:namespace/><%=QuanLyKeys.Base.LABEL_INPUT_FILE%>').click(function(){
    $('input[type="file"]').change(function(e){
        var fileName = e.target.files[0].name;
        $('#fileName').text(fileName);

    });
});
</script>