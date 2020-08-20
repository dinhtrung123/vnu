<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="org.apache.commons.lang3.EnumUtils" %>
<%@page import="com.liferay.portal.kernel.bean.PortalBeanLocatorUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="javax.portlet.PortletMode"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/accountportlet/init.jsp" %>
<%
   	long accountId = ParamUtil.getLong(request, "accountId");
	
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectReOpen");  
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
</aui:script>
   
<aui:form name="reOpenForm"  method="post">
	<aui:input type="hidden" name="accountId" value="<%=accountId %>" />
	<label class="oep-label bold"><liferay-ui:message key="Ghi chú" />:</label>
	<aui:input name="comment"  style="border-radius: 0px; height: 91px; margin: 0px 0px 7px; width: 332px;" autoFocus="true" label="" type ="textarea" maxLength="200"/>
	<aui:button-row>
		<aui:button cssClass="selector-button" value="save" />
		<aui:button value="cancel" 	onClick='<%=liferayPortletResponse.getNamespace()+ "cancel();"%>' cssClass="btn-primary" ></aui:button>
	</aui:button-row>		
</aui:form>	


<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />reOpenForm').delegate(
		'click',
		function(event) {
			if(!validateByNameLabel('comment','<liferay-ui:message key="Ghi chú không được bỏ trống !"/>')){
					return false;
				}				
				var result={};
				result['comment']=A.one('#<portlet:namespace />comment').get('value');
				Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
				Util.getWindow().destroy();
		},
		'.selector-button'
	);
</aui:script>
