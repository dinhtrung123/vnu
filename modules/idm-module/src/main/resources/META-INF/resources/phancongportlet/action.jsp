<%@page import="dtt.vn.vnpost.model.Account"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<%@include file="/phancongportlet/init.jsp" %>
<%
	ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");
	Account acc = (Account) row.getObject();
	
	String action_id = "selectApprover_"+ acc.getAccountId();
	
%>

<c:if test="<%=  acc.getReOpen() == false %>">	
<liferay-ui:icon
	id="<%=action_id %>" label="<%=true%>" message="assign" method="get"
	url="javascript:;" image="assign"/>
		
	<aui:script use="liferay-search-container">
		var selectApproverLink = A.one(<%=action_id %>);
		if (selectApproverLink) {
			selectApproverLink.on(
				'click',
				function(event) {
					
					alert('kkkkkkk');
					Liferay.Util.selectEntity(
						{
							dialog: {
								constrain: true,
								modal: true,
								width: 1000
	
							},
							id: '<portlet:namespace />selectApprover',
							title: '<liferay-ui:message key="select-user-title" />',
							uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/phancongportlet/assign_user.jsp" /></portlet:renderURL>' 
						},
						function(event) {
							document.<portlet:namespace/>phanCongFm.<portlet:namespace/>userId.value=event.approverId;	
							document.<portlet:namespace/>phanCongFm.<portlet:namespace/>accountId.value=<%=acc.getAccountId()%>;		
							submitForm(document.<portlet:namespace/>phanCongFm);						
						}
					);
				}
			);
		}
		
	</aui:script>	
</c:if>
<c:if test="<%=  acc.getReOpen() == true %>">	
<liferay-ui:icon
	id="<%=action_id %>" label="<%=true%>" message="assign" method="get"
	url="javascript:;" image="assign"/>
		
	<aui:script use="liferay-search-container">
		var selectApproverLink = A.one(<%=action_id %>);
		if (selectApproverLink) {
			selectApproverLink.on(
				'click',
				function(event) {
					
					alert('kkkkkkk2:<%= String.valueOf(acc.getAccountId())%>');
					alert('kkkkkkk2:<%= String.valueOf(acc.getAssignUserId())%>');
					Liferay.Util.selectEntity(
						{
							dialog: {
								constrain: true,
								modal: true,
								width: 420,
								destroyOnClose: true,
								height: 420
	
							},
							id: '<portlet:namespace />selectApprover',
							title: '<liferay-ui:message key="Phê duyệt xác minh lại " />',
							uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/phancongportlet/agree_re_open.jsp"/><portlet:param name="accountId" value="<%=String.valueOf(acc.getAccountId())%>" /><portlet:param name="assignUserId" value="<%=String.valueOf(acc.getAssignUserId())%>" /> </portlet:renderURL>' 
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
</c:if>