<%@page import="org.oep.util.MyLanguageUtil"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="org.oep.core.model.ThamSoLoai"%>
<%@page import="org.oep.core.service.ThamSoLoaiLocalServiceUtil"%>
<%@page import="org.oep.core.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.core.model.ThamSo"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.util.PortletKeys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/quanlythamsoportlet/init.jsp" %>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/bootstrap-select.min.js"></script>

<!-- (Optional) Latest compiled and minified JavaScript translation files -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/i18n/defaults-*.min.js"></script>

<style type="text/css">
body{
overflow-x:hidden;
}
</style>

<portlet:renderURL var="searchThamSoURL"/>
<portlet:renderURL var="redirectURL">
 	<portlet:param name="<%= PortletKeys.SearchContainer.DELTA %>" value="<%= String.valueOf(ParamUtil.getInteger(request, PortletKeys.SearchContainer.DELTA, PortletKeys.DELTA)) %>"/>
	<portlet:param name="<%= PortletKeys.SearchContainer.CURRENT_PAGE %>" value="<%= String.valueOf(ParamUtil.getInteger(request, PortletKeys.SearchContainer.CURRENT_PAGE, PortletKeys.PAGE)) %>"/>	
	<portlet:param name="idParam" value='<%= ParamUtil.getString(request, "idParam") %>'/>
	<portlet:param name="keyword" value='<%= ParamUtil.getString(request, "keyword") %>'/>
 </portlet:renderURL>
 
 <portlet:renderURL var="themThamSoURL">
	<portlet:param name="<%=PortletKeys.SET_VIEW_PARAMETER %>" value="/quanlythamsoportlet/add_edit_param.jsp"/>
	<portlet:param name="<%= PortletKeys.REDIRECT_PAGE %>" value="<%= redirectURL %>"/>
</portlet:renderURL>

<%
long idParam = ParamUtil.getLong(request, "idParam");
String keyword = ParamUtil.getString(request, "keyword");

PortletURL renderURL = renderResponse.createRenderURL();
renderURL.setParameter("idParam", String.valueOf(idParam));
renderURL.setParameter("keyword", keyword);

int cur = ParamUtil.getInteger(request, PortletKeys.SearchContainer.CURRENT_PAGE, PortletKeys.PAGE);
int delta = ParamUtil.getInteger(request, PortletKeys.SearchContainer.DELTA, PortletKeys.DELTA);
String msgEmpty = MyLanguageUtil.get(request, request.getLocale(), "org.oep.core.portlet.thamso.message.empty.nodata"); ;//LanguageUtil.get(ResourceBundle.getBundle("content/Language", resourceRequest.getLocale()), "org.oep.core.portlet.thamso.message.empty.nodata");//"khong co du lieu";

System.out.print("msgEmpty:"+msgEmpty);
SearchContainer<ThamSo> searchContainer = new SearchContainer<ThamSo>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, renderURL, null, msgEmpty);
int total = ThamSoLocalServiceUtil.countByL_M(themeDisplay.getScopeGroupId(),idParam, keyword);
System.out.print("total:"+total);
searchContainer.setTotal(total);

List<ThamSo> listParam = new ArrayList<ThamSo>();
if(total > 0){
	 int start = searchContainer.getStart();
	 int end = searchContainer.getEnd();
	 listParam = ThamSoLocalServiceUtil.searchByL_M(themeDisplay.getScopeGroupId(), idParam, keyword, start, end);
}

List<ThamSoLoai> listTsl = ThamSoLoaiLocalServiceUtil.getAll();
ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
%>


<div class="container" style="background-color: white;">
	<div class="bg-trang">
		<h4 class="tle" style="font-weight: 600 !important;">Quản lý tham số</h4>
	</div>
	<%-- <form name="<portlet:namespace/>fmt" method="post" action="<%=searchThamSoURL%>">
		<table width = "100%" >
			<div>
				<td>
					<aui:input type="text" name="keyword" cssClass="oep-inputfield search" placeholder='org.oep.core.portlet.thamso.placeholder.id' label="" />
				</td>
				<td>
					<aui:select cssClass="oep-select" style="margin-right:8px" name="idParam" onChange = '<%= renderResponse.getNamespace() + "submitForm()"%>' label="">
						<aui:option><liferay-ui:message key="org.oep.core.portlet.thamso.text.label.typeparam"/></aui:option>
						<%for (ThamSoLoai ts : listTsl) {%>
							<aui:option value="<%=ts.getId()%>" selected="<%= ts.getId() == idParam %>"><%=ts.getTen()%></aui:option>
						<%}%>
					</aui:select>
				</td>
				<td>
					<aui:button type="submit" icon="icon-search" value="search" />
				</td>
				<td style = "padding-bottom:8px !important; float: right;">
					<input type="button" class="oep-button" value='<liferay-ui:message key="org.oep.core.portlet.thamso.button.addre"/>'  onclick='location.href = "<%=themThamSoURL %>";'/>
				</td>
			</div>		
		</table>
	</form> --%>


<div class="row">
		<form name="<portlet:namespace/>fmt" method="post" action="<%=searchThamSoURL%>">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<aui:input type="text" name="keyword" cssClass="oep-inputfield search" placeholder='org.oep.core.portlet.thamso.placeholder.id' label="" />
				</div>
			</div>
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<aui:select class="selectpicker" data-live-search="true" cssClass="oep-select" style="margin-right:8px" name="idParam" onChange = '<%= renderResponse.getNamespace() + "submitForm()"%>' label="">
						<aui:option><liferay-ui:message key="org.oep.core.portlet.thamso.text.label.typeparam"/></aui:option>
						<%for (ThamSoLoai ts : listTsl) {%>
							<aui:option value="<%=ts.getId()%>" selected="<%= ts.getId() == idParam %>"><%=ts.getTen()%></aui:option>
						<%}%>
					</aui:select>
				</div>
			</div>
			<div class="col-md-12">
				<label class="control-label"></label>
				<div class="text-right" style="padding: 0px;margin-top: 10px;">
					<aui:button type="submit" icon="icon-search" value="search" />
					<input type="button" class="oep-button" value='<liferay-ui:message key="org.oep.core.portlet.thamso.button.addre"/>'  onclick='location.href = "<%=themThamSoURL %>";'/>
				</div>
			</div>
		</form>
	</div>

<div class="bg-trang">
		<h4 class="tle" style="font-weight: 600 !important;">
			Danh sách tham số
		</h4>
	</div>
<div class="row">
	<div class="col-md-12">
		<table class="table table-bordered">
			<thead>
			<tr style="text-align: center;">
				<th style="text-align: center;" width="4%"><liferay-ui:message
						key="org.oep.core.portlet.thamso.text.label.stt" /></th>
				<th style="text-align: center;" width="16%"><liferay-ui:message
						key="org.oep.core.portlet.thamso.text.label.ma" /></th>
				<th style="text-align: center;" width="30%"><liferay-ui:message
						key="org.oep.core.portlet.thamso.text.label.value" /></th>
				<th style="text-align: center;" width="15%"><liferay-ui:message
						key="org.oep.core.portlet.thamso.text.label.type" /></th>
				<th style="text-align: center;" width="10%"><liferay-ui:message
						key="org.oep.core.portlet.thamso.text.label.status" /></th>
				<th style="text-align: center;" width="8%"><liferay-ui:message
						key="org.oep.core.portlet.thamso.text.label.action" /></th>
			</tr>
			</thead>
				<tbody>
			<%
				int index = 1;
				for (ThamSo param : listParam) {
					ThamSoLoai tsl = ThamSoLoaiLocalServiceUtil.getThamSoLoai(param.getLoaiId());
			%>
			<portlet:actionURL var="deleteParamURL" name="deleteParam">
				<portlet:param name="thamSoId"
					value="<%=String.valueOf(param.getId())%>" />
				<portlet:param name="<%=PortletKeys.SET_VIEW_PARAMETER%>"
					value="/quanlythamsoportlet/view.jsp" />
			</portlet:actionURL>

			<portlet:renderURL var="editParamURL">
				<portlet:param name="thamSoId"
					value="<%=String.valueOf(param.getId())%>" />
				<portlet:param name="<%=PortletKeys.SET_VIEW_PARAMETER%>"
					value="/quanlythamsoportlet/add_edit_param.jsp" />
				<portlet:param name="<%=PortletKeys.REDIRECT_PAGE%>"
					value="<%=redirectURL%>" />
			</portlet:renderURL>

			<tr>
				<td class="text-center"><%=searchContainer.getStart() + index%></td>
				<td class="text-left"><%=param.getMa()%></td>
				<td class="text-left"><%=param.getGiaTri()%></td>
				<td class="text-center"><%=tsl.getTen()%></td>
				<td class="text-center"><%=param.getTrangThai()
						? MyLanguageUtil.get(request, request.getLocale(), "org.oep.core.portlet.thamso.select.active")
						: MyLanguageUtil.get(request, request.getLocale(),
								"org.oep.core.portlet.thamso.select.inactive")%></td>
				<td class="text-center"><a href="#"
					title='<liferay-ui:message key="org.oep.core.portlet.thamso.label.edit"/>'
					class="oep-icon-edit" style="margin-left: 0px; margin-right: 0px"
					onclick="location.href = '<%=editParamURL%>'"> </a> <a href="#"
					title='<liferay-ui:message key="org.oep.core.portlet.thamso.label.delete"/>'
					class="oep-icon-delete" style="margin-left: 0px; margin-right: 0px"
					onclick="if (confirm('<liferay-ui:message key="org.oep.core.portlet.thamso.confirm.delete"/>'))
				 {location.href = '<%=deleteParamURL%>';return false;}">
				</a></td>
			</tr>
			
			<%
		index++;
		} 
	%>
	</tbody>
		</table>
	</div>
</div>

<c:if test="<%= searchContainer != null %>">
		<div id = "pagination">
			<br/>
			<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
		</div>
	</c:if>
</div>
<script>
function <portlet:namespace/>submitForm(){
	document.<portlet:namespace/>fmt.submit();
}
</script>









