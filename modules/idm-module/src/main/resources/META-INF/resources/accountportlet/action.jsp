
<%@page import="dtt.vn.account.business.Constantes"%>
<%@page import="dtt.vn.vnpost.model.Account"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page	import="com.liferay.portal.kernel.bean.BeanPropertiesUtil"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<%@ include file="/accountportlet/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");

	Account acc = (Account) row.getObject();
	long groupId = scopeGroupId;
	String name = portletDisplay.getRootPortletId();
	String primKey = portletDisplay.getResourcePK();
	String actionId = "ADD_VERIFY";// 
	String action_id = "selectReOpen_"+ acc.getAccountId();		
	String action_workitem_id = "selectWorkItem_"+ acc.getAccountId();		
%>




		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" 	value="/accountportlet/editAccount.jsp" />
			<portlet:param name="redirect" 	value="redirectViewAccount" />
			<portlet:param name="accountId" value="<%=String.valueOf(acc.getAccountId())%>" />
		</portlet:renderURL>
		
		<portlet:renderURL var="xacMinhURL">
			<portlet:param name="jspPage" 	value="/accountportlet/xac_minh.jsp" />
			<portlet:param name="accountId" value="<%=String.valueOf(acc.getAccountId())%>" />
			<portlet:param name="backURL" value="<%=currentURL%>" />
		</portlet:renderURL>
		
	<% if(acc.getProcessStatus() == Constantes.XuLy.KET_THUC){ %>
				<liferay-ui:icon image="check" label="<%=false%>" message="Xem" url="<%=xacMinhURL%>" />
		<%} %>		
	
	<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId) && acc.getProcessStatus() == Constantes.XuLy.KET_THUC %>">	
    	<liferay-ui:icon	id="<%=action_id %>" label="<%=false%>" message="Yêu cầu Xác minh" method="get" 	url="javascript:;" image="undo"/>
    	<aui:script use="aui-base">
				
				var selectReOpenLink = A.one(<%=action_id %>);
				if (selectReOpenLink) {
					selectReOpenLink.on(
						'click',
						function(event) {
							Liferay.Util.selectEntity(
								{
									dialog: {
										constrain: true,
										modal: true,
										width: 420,
										height: 420
			
									},
									id: '<portlet:namespace />selectReOpen',
									title: '<liferay-ui:message key="Xác minh lại tài khoản: "  />' + ' <%= acc.getFullName()%>',
									uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/accountportlet/re_open.jsp" /><portlet:param name="accountId" value="<%=String.valueOf(acc.getAccountId())%>" /></portlet:renderURL>' 
								},
								function(event) {
									document.<portlet:namespace/>reOpenFm.<portlet:namespace/>comment.value=event.comment;	
									document.<portlet:namespace/>reOpenFm.<portlet:namespace/>accountId.value=<%=acc.getAccountId()%>;		
									submitForm(document.<portlet:namespace/>reOpenFm);						
								}
							);
						}
					);
				}
				
				
		</aui:script>	
    	
 	</c:if>

		<portlet:actionURL var="deleteURL" name="deletarAccount">
			<portlet:param name="jspPage" value="/accountportlet/view.jsp" />
			<portlet:param name="redirect" value="redirectViewAccount" />
			<portlet:param name="accountId" value="<%=String.valueOf(acc.getAccountId())%>" />
		</portlet:actionURL>

	<% if(acc.getIpLevel() == 1){ %>
		<liferay-ui:icon-delete url="<%=deleteURL%>" />
	<%} %>		

	<liferay-ui:icon
	id="<%=action_workitem_id %>" label="" message="Quá trình xử lý" method="get"
	url="javascript:;" image="view_tasks"/>
		
	<aui:script use="liferay-search-container">
		var selectWorkItemLink = A.one(<%=action_workitem_id %>);
		if (selectWorkItemLink) {
			selectWorkItemLink.on(
				'click',
				function(event) {
					Liferay.Util.selectEntity(
						{
							dialog: {
								constrain: true,
								modal: true,
								width: 1000
	
							},
							id: '<portlet:namespace />selectApprover',
							title: '<liferay-ui:message key="Quá trình xử lý " />',
							uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/accountportlet/work_item.jsp"/><portlet:param name="accountId" value="<%=String.valueOf(acc.getAccountId())%>" /></portlet:renderURL>' 
						},
						function(event) {
							document.<portlet:namespace/>phanCongFm.<portlet:namespace/>userId.value=<%=acc.getAssignUserId()%>;	
							document.<portlet:namespace/>phanCongFm.<portlet:namespace/>accountId.value=<%=acc.getAccountId()%>;		
							submitForm(document.<portlet:namespace/>phanCongFm);						
						}
					);
				}
			);
		}
		
	</aui:script>	
	
	