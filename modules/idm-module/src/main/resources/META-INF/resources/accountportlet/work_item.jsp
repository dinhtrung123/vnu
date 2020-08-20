<%@page import="dtt.vn.vnpost.service.WorkItemLocalServiceUtil"%>
<%@page import="dtt.vn.account.business.AccountBusiness"%>
<%@page import="dtt.vn.vnpost.model.WorkItem"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page	import="com.liferay.portal.kernel.bean.BeanPropertiesUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="javax.portlet.PortletMode"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletResponse" %>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@page import="java.util.List"%>
<%@ include file="/accountportlet/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%

long accountId = ParamUtil.getLong(request, "accountId");
String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectApprover");
int index = 1;
int cur = ParamUtil.getInteger(request, "cur", 1);
int delta = ParamUtil.getInteger(request, "delta", 10);
PortletURL renderURL= renderResponse.createRenderURL();
SearchContainer<WorkItem> searchContainer = new SearchContainer<WorkItem>(renderRequest, null, null, 
		SearchContainer.DEFAULT_CUR_PARAM,
		cur, delta, renderURL, null, "Khong co du lieu");
int start = searchContainer.getStart();
int end = searchContainer.getEnd();
int total = WorkItemLocalServiceUtil.getQuaTrinhXuLy(accountId).size();
List<WorkItem> workItems = null;
if(total > 0){
	listEvent = WorkItemLocalServiceUtil.getQuaTrinhXuLy(accountId);
}
searchContainer.setTotal(total);

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
	<%-- <aui:button cssClass="selector-button" value="Chọn" /> --%>
	<aui:button value="close"
		onClick='<%=liferayPortletResponse.getNamespace()+ "cancel();"%>' cssClass="btn-primary" ></aui:button>
</aui:form>


<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/account/work_item.jsp" />
</liferay-portlet:renderURL>

<div class="oep-container">
	<table class="oep-table">
		<thead>
		<tr>
			<th style="width: 5%;" class="text-center"><liferay-ui:message key="portlet.danhsach.table.stt"/></th>
			<th style="width: 10%;" class="text-center"><liferay-ui:message key="portlet.danhsach.table.title"/></th>
			<th style="width: 8%;" class="text-center"><liferay-ui:message key="portlet.danhsach.table.canboxuly"/></th>
			<th style="width: 9%;" class="text-center"><liferay-ui:message key="portlet.audit.table.classname"/></th>
			<th style="width: 10%;" class="text-center"><liferay-ui:message key="portlet.audit.table.clientip"/></th>
			<th style="width: 10%;" class="text-center"><liferay-ui:message key="portlet.audit.table.createdate"/></th>
			<th style="width: 20%;" class="text-center"><liferay-ui:message key="portlet.audit.table.name"/></th>
			<th style="width: 25%;" class="text-center"><liferay-ui:message key="portlet.audit.table.additionalinfo"/></th>
		</tr>
	</thead>
	</table>
</div>


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

