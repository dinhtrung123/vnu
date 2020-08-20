
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="dtt.vn.account.util.PortletKeysUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="dtt.vn.vnpost.service.AccountLocalServiceUtil"%>
<%@page import="dtt.vn.account.search.AccountHelper"%>
<%@page import="dtt.vn.account.business.Constantes"%>
<%@page import="dtt.vn.vnpost.model.Account"%>
<%@page import="java.util.List"%>
<%@page import="dtt.vn.account.search.AccountRecordSearchTerms"%>
<%@page import="dtt.vn.account.search.AccountRecordSearch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/phancongportlet/init.jsp" %>


<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/phancongportlet/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<liferay-ui:search-form
		page="/phancongportlet/account_search.jsp"
		servletContext="<%= application %>"
	/>
</aui:form>
<button class="btn btn-info" onclick="functiontestajax();"> Test ajax </button>
<div class="separator"></div>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/phancongportlet/view.jsp" />
</liferay-portlet:renderURL>

<portlet:actionURL name="phanCongXuLy" var="phanCongXuLyURL" windowState="normal"></portlet:actionURL>

<aui:form name="phanCongFm" action="<%=phanCongXuLyURL %>" method="post">
	<input type="hidden" name="<portlet:namespace/>accountId" />
	<input type="hidden" name="<portlet:namespace/>userId" />
</aui:form>	

<%
String tuKhoa = ParamUtil.getString(request, DisplayTerms.KEYWORDS,"").trim();
PortletURL portletURL = renderResponse.createActionURL();
portletURL.setParameter(DisplayTerms.KEYWORDS, tuKhoa);
int cur = ParamUtil.getInteger(request, PortletKeysUtil.SearchContainer.CURRENT_PAGE, PortletKeysUtil.PAGE);
int delta = ParamUtil.getInteger(request, PortletKeysUtil.SearchContainer.DELTA, PortletKeysUtil.DELTA);
String msgEmpty = "Không có dữ liệu";
SearchContainer searchContainer = new SearchContainer<Account>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, portletURL, null, msgEmpty);

List<Account> resultsAccountRecords = AccountLocalServiceUtil.getAccountByStatus(tuKhoa, Constantes.XuLy.DOI_PHAN_CONG, Constantes.ALL_USER, searchContainer.getStart(), searchContainer.getEnd());
int totalAccountRecords = AccountLocalServiceUtil.getTotalAccountCountByStatus(tuKhoa, Constantes.XuLy.DOI_PHAN_CONG, Constantes.ALL_USER, searchContainer.getStart(), searchContainer.getEnd());
 searchContainer.setTotal(totalAccountRecords);
 searchContainer.setResults( resultsAccountRecords);
 System.out.print("so luong :" + totalAccountRecords);
 
 
%>
<table class="table table-border">
<thead>
	<tr>
		<td>STT</td>
		<td>Họ và tên</td>
		<td>Thư điện tử</td>
		<td>NGười dùng ID</td>
		<td>Số điện thoại</td>
		<td>Cấp bậc</td>
		<td>Hành động</td>
	</tr>
</thead>
<tbody>
<%
int index = searchContainer.getStart();
for(Account account1 : resultsAccountRecords){
	index ++;
	%>
	<portlet:renderURL var="xacminhlaiURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="jspPage" value="/phancongportlet/agree_re_open.jsp"/>
	<portlet:param name="accountId" value="<%=String.valueOf(account1.getAccountId())%>" />
	<portlet:param name="assignUserId" value="<%=String.valueOf(account1.getAssignUserId())%>" />
	 </portlet:renderURL>
	<tr>
	<td><%= index %></td>
		<td><%= account1.getFullName() %></td>
		<td><%= account1.getEmail() %></td>
		<td><%= account1.getPersonalId() %></td>
		<td><%= account1.getTelNo() %></td>
		<td><%= account1.getIpLevel() %></td>
		<td><button
		onclick="javascript:openDialogOEPAdv('themMoiCauHinhPopup', '121212', '<%= xacminhlaiURL %>', '420', '420');"
		>xác minh lại</button></td>
		
	</tr>
	<%
}
%>
</tbody>
</table>
<portlet:resourceURL var="testURL" id="testttttt">
</portlet:resourceURL>
<script type="text/javascript">
function functiontestajax(){
	$.ajax({
		
		type:'POST',
		url:'<%= testURL %>',
		beforeSend: function (xhr) {
	      
	    },
		success:function(result){
			alert(result);

		},
		error: function (request, status, error) {
			alert('loi');
	    }
	});
}
</script>



  <%-- <liferay-ui:search-container 
	emptyResultsMessage="auditingrecord-empty-results-message">

	<liferay-ui:search-container-results>

	<%
	String tuKhoa = ParamUtil.getString(request, DisplayTerms.KEYWORDS,"").trim();
	System.out.print("Từ khóa :" + tuKhoa);
	Long groupId = themeDisplay.getLayout().getGroupId();
	AccountRecordSearchTerms searchTerms = (AccountRecordSearchTerms)searchContainer.getSearchTerms();
	
	List<Account> resultsAccountRecords = AccountLocalServiceUtil.getAccountByStatus(tuKhoa, Constantes.XuLy.DOI_PHAN_CONG, Constantes.ALL_USER, searchContainer.getStart(), searchContainer.getEnd());
	int totalAccountRecords = AccountLocalServiceUtil.getTotalAccountCountByStatus(tuKhoa, Constantes.XuLy.DOI_PHAN_CONG, Constantes.ALL_USER, searchContainer.getStart(), searchContainer.getEnd());
	 searchContainer.setTotal(totalAccountRecords);
	 searchContainer.setResults( resultsAccountRecords);
	%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
			className="dtt.vn.vnpost.model.Account"
			modelVar="aAccount" indexVar="indx">
			<liferay-ui:search-container-column-text name="Id"><%= searchContainer.getStart()+indx+1%> </liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text property="fullName" />
	
			<liferay-ui:search-container-column-text property="email" />
			<liferay-ui:search-container-column-text property="personalId" />
			<liferay-ui:search-container-column-text property="telNo" />
			<liferay-ui:search-container-column-text name="ipLevel" >
					Mức  <%=aAccount.getIpLevel() %>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-jsp name="Thao tác" cssClass="entry-action"
				path="/phancongportlet/action.jsp" />
			
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container> --%>