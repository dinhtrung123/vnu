
<%@page import="java.util.List"%>
<%@page import="dtt.vn.account.business.AccountBusiness"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/phancongportlet/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectApprover");
List<User> users = AccountBusiness.getUsers();

%>

<aui:script>

	function <portlet:namespace/>cancel(){
		var Util = Liferay.Util;
		Util.getWindow().destroy();
	}
	
	window.onload=function(){
		var buttons=parent.document.getElementsByTagName("button");
		for(var i=0;i<buttons.length;i++){		
			if(buttons[i].className!=null&&buttons[i].className.indexOf("btn close")!=-1){		
				buttons[i].onclick = function(){			
					var Util = Liferay.Util;				
					Util.getWindow().destroy();
				} 
			}
		}
	}
</aui:script>

<aui:form name="selectApproverForm">
	<aui:button cssClass="selector-button" value="Chọn" />
	<aui:button value="cancel"
		onClick='<%=renderResponse.getNamespace()+ "cancel();"%>' cssClass="btn-primary" ></aui:button>
</aui:form>


<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/idm/portlet/phancong/assign_user.jsp" />
</liferay-portlet:renderURL>


<liferay-ui:search-container
		   emptyResultsMessage="No User"
		   delta="50" iteratorURL="<%= iteratorURL %>">
			<liferay-ui:search-container-results>
				<%
				searchContainer.setResults(users);
				searchContainer.setTotal(users.size());
				%>
			</liferay-ui:search-container-results>
		
			<liferay-ui:search-container-row
				className="com.liferay.portal.kernel.model.User"
				keyProperty="userId"
				modelVar="userXL" indexVar="indx"
			>		
				<liferay-ui:search-container-column-text name="Id"><%= searchContainer.getStart()+indx+1%> </liferay-ui:search-container-column-text>
		     	<liferay-ui:search-container-column-text name="ho-ten"
		         value="<%= String.valueOf(userXL.getFullName()) %>" />
		        <liferay-ui:search-container-column-text name="Email"
		         value="<%= String.valueOf(userXL.getEmailAddress()) %>" />
				<liferay-ui:search-container-column-text>
					<input type="radio" name="radio" value="<%=userXL.getUserId()%>" />
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
		
			<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />selectApproverForm').delegate(
		'click',
		function(event) {
			var check=A.one("input[type=radio]:checked");
			if(check==null){
				alert("Vui lòng chọn cán bộ xử lý hồ sơ.");
			}else{
		
				var result={};
				var value=check.val();
				result['approverId']=value;
				Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
				Util.getWindow().destroy();
			}
		},
		'.selector-button'
	);
</aui:script>

