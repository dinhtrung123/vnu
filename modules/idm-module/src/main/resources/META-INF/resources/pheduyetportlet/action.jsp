<%@page import="dtt.vn.vnpost.model.Account"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="/pheduyetportlet/init.jsp" %>
<%
	ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");
	Account acc = (Account) row.getObject();
	
	String action_id = "selectApprover_"+ acc.getAccountId();
	
%>

		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" 	value="/html/pheduyet/xac_minh.jsp" />
			<portlet:param name="accountId" value="<%=String.valueOf(acc.getAccountId())%>" />
			<portlet:param name="backURL" value="<%=currentURL%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL%>" />