<%@page import="dtt.vn.vnpost.service.AccountLocalServiceUtil"%>
<%@page import="dtt.vn.vnpost.service.WorkItemLocalServiceUtil"%>
<%@page import="dtt.vn.vnpost.model.WorkItem"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="org.apache.commons.lang3.EnumUtils" %>
<%@page import="com.liferay.portal.kernel.bean.PortalBeanLocatorUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/phancongportlet/init.jsp" %>








<%
   	long accountId = ParamUtil.getLong(request, "accountId");
   	long assignUserId = ParamUtil.getLong(request, "assignUserId");
   	
	WorkItem workItem = WorkItemLocalServiceUtil.getWorkItemByAccountIdLastComplete(accountId);
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectApprover");  
%>


<!-- <aui:script>

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
	
	function validateByNameLabel(inputName, inputLabel) {
		var portletNamespace = '<portlet:namespace/>';
		var inputElement = document.getElementsByName(portletNamespace + inputName)
				.item(0)
		inputLabel = inputLabel.indexOf('*')<0?inputLabel:inputLabel.substring(0, inputLabel.lastIndexOf('*'));
		var prefix = '';
		if (inputElement.value == null || inputElement.value == '') {
			alert(prefix +" "+ inputLabel+"!");
			inputElement.focus();
			return false;
		} else {
			return true;
		}
	}	
</aui:script> -->
   <%
   System.out.print(accountId);
   String tenNguoiGhiChu = AccountLocalServiceUtil.getAccount(accountId).getFullName();
   %>
<div id="body-content" style="text-align: center;">
<aui:form name="reOpenForm"  method="post">
	<aui:input type="hidden" name="accountId" value="<%=accountId %>" />
	<aui:input type="hidden" name="assignUserId" value="<%=assignUserId %>" />
	<label class="oep-label bold"><liferay-ui:message key="Ghi chú của " /> <b> <%= tenNguoiGhiChu %> </b></label>
	<aui:input name="comment"  style="border-radius: 0px; height: 91px; margin: 0px 0px 7px; width: 332px;" disabled="true" label=""  value="111111111111" type ="textarea" maxLength="200"/>
	<aui:button-row>
		<aui:button cssClass="selector-button " value="Đồng ý" />
		<aui:button value="cancel" 	onClick='<%=renderResponse.getNamespace()+ "cancel();"%>' cssClass="btn-primary" ></aui:button>
	</aui:button-row>		
</aui:form>	
</div>


<!-- <aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />reOpenForm').delegate(
		'click',
		function(event) {
			if(!validateByNameLabel('comment','<liferay-ui:message key="Ghi chú không được bỏ trống !"/>')){
					return false;
				}				
				var result={};
				result['assignUserId']=A.one('#<portlet:namespace />assignUserId').get('value');
				Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
				Util.getWindow().destroy();
		},
		'.selector-button'
	);
</aui:script> -->
