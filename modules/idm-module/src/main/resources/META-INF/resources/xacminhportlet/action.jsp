<%@page import="dtt.vn.vnpost.service.AccountLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="dtt.vn.vnpost.model.Account"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="/xacminhportlet/init.jsp" %>
<%
	/* ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");
	Account acc = (Account) row.getObject(); */
	
	long accId = ParamUtil.getLong(request, "accountId",0);
	Account acc = AccountLocalServiceUtil.getAccount(accId);
	String action_id = "selectApprover_"+ acc.getAccountId();
	
%>

		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" 	value="/xacminhportlet/xac_minh_new.jsp" />
			<portlet:param name="accountId" value="<%=String.valueOf(acc.getAccountId())%>" />
			<portlet:param name="backURL" value="<%=currentURL%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL%>" />