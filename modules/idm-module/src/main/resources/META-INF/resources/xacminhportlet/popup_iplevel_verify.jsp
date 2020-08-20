<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="org.apache.commons.lang3.EnumUtils" %>

<%@page import="java.util.Iterator"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DatabaseMetaData"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="com.liferay.portal.kernel.bean.PortalBeanLocatorUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/xacminhportlet/init.jsp" %>
<%
   	long accountId = ParamUtil.getLong(request, "accountId");
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectIpLevel");  
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
   
<aui:select  required="true" showRequiredLabel="<%=false %>"  name="ipLevel" id="ipLevel"  label="Mức xác thực" >
	<aui:option value="2"> Mức 2</aui:option>
	<aui:option value="3"> Mức 3</aui:option>
	<aui:option value="4"> Mức 4</aui:option>
</aui:select>

   
<aui:form name="selectIpLevelForm">
		<aui:button-row>
			<aui:button cssClass="selector-button" value="save" />
			<aui:button value="cancel" 	onClick='<%=renderResponse.getNamespace()+ "cancel();"%>' cssClass="btn-primary" ></aui:button>
		</aui:button-row>	
</aui:form>



<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />selectIpLevelForm').delegate(
		'click',
		function(event) {
				var result={};
				result['ipLevel']=A.one('#<portlet:namespace />ipLevel').get('value');
				Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
				Util.getWindow().destroy();
		},
		'.selector-button'
	);
</aui:script>
