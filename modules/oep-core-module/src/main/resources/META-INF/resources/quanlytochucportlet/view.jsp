

<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.util.CayToChucUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="org.oep.core.quanlytochuc.keys.QuanLyToChucKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.util.PortletKeys"%>
<%@ include file="/quanlytochucportlet/init.jsp" %>

<%
long userId = themeDisplay.getUserId();
System.out.println("userID : "+userId);
long parentOrgId = 0L;
if(userId != 0){
	user = UserLocalServiceUtil.getUser(userId);
	parentOrgId = CayToChucUtil.getOrganizationId(user);
	System.out.println("parentOrgId : "+parentOrgId);
}

int index = 1;
int cur = ParamUtil.getInteger(request, "cur", 1);
int delta = ParamUtil.getInteger(request, "delta", 10);
PortletURL renderURL= renderResponse.createRenderURL();
	SearchContainer<Organization> searchContainer = new SearchContainer<Organization>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, renderURL, null, QuanLyToChucKeys.NO_DATA);
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	
	List<Organization> listCayToChuc = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), parentOrgId, start, end);
	int total = listCayToChuc.size();
	if(total > 0){
		searchContainer.setTotal(total);
	}

%>

<div class="oep-container">	
	<table class="oep-table">
		<thead>
				<tr>
					<th style="width: 5%;" class="text-center"><liferay-ui:message key="oep.dvc.portlet.trungtamhanhchinh.table.stt"/></th>
					<th style="width: 10%" class="text-center"><liferay-ui:message key="oep.dvc.portlet.trungtamhanhchinh.table.ma"/></th>
					<th style="width: 25%" class="text-center"><liferay-ui:message key="oep.dvc.portlet.trungtamhanhchinh.table.ten"/></th>
					<th style="width: 35%" class="text-center"><liferay-ui:message key="oep.dvc.portlet.trungtamhanhchinh.table.coquanquanly"/></th>
					<th style="width: 10%" class="text-center"><liferay-ui:message key="oep.dvc.portlet.trungtamhanhchinh.table.trangthai"/></th>
					<th style="width: 10%" class="text-center"><liferay-ui:message key="oep.dvc.portlet.trungtamhanhchinh.table.thaotac"/></th>
				</tr>
		</thead>
		<tbody>
		<%
			if(listCayToChuc != null && listCayToChuc.size() > 0){
				for(Organization org : listCayToChuc){
					
				%>
				<portlet:renderURL var="chinhSuaURL">
					<portlet:param name="mvcPath" value="/quanlytochuc/them_moi.jsp"/>
				</portlet:renderURL>
				<tr>
					<td class="text-center"><%= searchContainer.getStart() + index++ %></td>
					<td><%=org != null ? org.getOrganizationId() : "" %></td>
					<td><%=org != null ? org.getName() : "" %></td>
					<td><%=org != null ? org.getParentOrganizationName() : "" %></td>
					<td><%=org != null ? org.getRecursable() :"" %></td>
					<td>
						<a class = "oep-icon-edit" href="<%=chinhSuaURL%>" title="<liferay-ui:message key="oep.dvc.portlet.trungtamhanhchinh.title.chinhsua" />"></a>
					</td>
					
				</tr>
				
				<%
				}
			}
		%>
		</tbody>
	
	</table>


</div>