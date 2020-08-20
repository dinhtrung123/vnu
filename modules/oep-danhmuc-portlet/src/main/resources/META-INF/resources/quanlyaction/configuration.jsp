
<%@page import="org.oep.danhmuc.portlet.quanly.keys.QuanLyKeys"%>
<%@page import="com.liferay.portal.kernel.model.PortletPreferences"%>
<%@page import="org.oep.danhmuc.service.NhomLocalServiceUtil"%>
<%@page import="org.oep.danhmuc.model.Nhom"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.oep.danhmuc.util.QuanlyUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="java.util.List"%>
<%@ include file="/quanlyaction/init.jsp" %>
 
 <%
	List<Nhom> listNhoms = NhomLocalServiceUtil.getNhoms(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	PortletPreferences prefs = renderRequest.getPreferences();
	String groupIds = prefs.getValue(QuanLyKeys.Prefs.NHOM_DANH_MUC, "");
	long[] groupIdArr = QuanlyUtil.convertToLongArray(groupIds, ",");
	
	Map<String, String> mapSelected = new HashMap<String, String>();
	for(long id : groupIdArr){
		mapSelected.put(String.valueOf(id), String.valueOf(id));
	}
 %>
 <liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
 
 <aui:form name = "fmt" method = "post" action = "<%=configurationURL %>">
 
 	<aui:input type="hidden" name="<%= QuanLyKeys.Base.GROUP_IDS %>"/>
 	
	<div class = "oep-container">
		<table class="oep-table-form" border="0" align="center" width= "100%">
				<tr>
					<td colspan="11">
						<label style = "font-weight:bold; font-size:18px"><liferay-ui:message key="org.oep.portlet.quanly.label.chonnhomdanhmuchienthi"/></label>
						</br>
						</br>
					</td>
				</tr>
			<%for (Nhom nhom : listNhoms){%>
			<tr>
				<td class="text-center" colspan="1">
					<input type="checkbox" style="margin-top: -2px;" name="oep-group" value="<%= String.valueOf(nhom.getId())%>"
					 <%= mapSelected.get(String.valueOf(nhom.getId())) != null ? "checked" : "" %>	/>
				</td>
				<td class = "text-left" colspan="10"><%=nhom.getTen() %></td>
			</tr>
			<%} %>
			<tr>
				<td colspan="2">
					</br>
					<button type = "button" class = "oep-button primary save" style = ""
					 onclick = "<portlet:namespace/>SelectedGroups()">
						<liferay-ui:message key="org.oep.portlet.quanly.button.ghilai"/>
					</button>
				</td>
			</tr>
			
	
		</table>
	</div>
</aui:form>

<script>
function <portlet:namespace/>SelectedGroups(){
	var nhoms = $("input:checkbox[name=oep-group]:checked");
	var selectedGroups = new Array();
	if (nhoms){
		nhoms.each(function() {
			selectedGroups.push($(this).val());
		})
	}
	document.<portlet:namespace/>fmt.<portlet:namespace/><%= QuanLyKeys.Base.GROUP_IDS %>.value = selectedGroups.join();
	document.<portlet:namespace/>fmt.action = "<%=configurationURL %>";
	document.<portlet:namespace/>fmt.submit();
	
	
}

</script>







