<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.danhmuc.model.DanhMuc"%>
<%@page import="org.oep.danhmuc.service.DanhMucLocalServiceUtil"%>
<%@page import="org.oep.danhmuc.service.NhomLocalServiceUtil"%>
<%@page import="org.oep.danhmuc.portlet.quanly.keys.QuanLyKeys"%>
<%@page import="org.oep.danhmuc.model.Nhom"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="org.oep.danhmuc.util.QuanlyUtil"%>
<%@page import="org.oep.danhmuc.util.PortletKeys"%>
<%@page import="org.oep.danhmuc.portlet.quanly.business.QuanLyBusiness"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/quanlyaction/init.jsp" %>


<%
String curentUrl = themeDisplay.getURLCurrent();
PortletPreferences prefs = renderRequest.getPreferences();
String groupIdString = "";
String groupIdDuocChon = "";
List<Nhom> lstNhomDuocChon = new ArrayList<Nhom>();
String maNhomDuocChon = ParamUtil.getString(request, QuanLyKeys.Base.NHOM_DANH_MUC);

lstNhomDuocChon = NhomLocalServiceUtil.getNhoms(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
if(ParamUtil.getString(request, QuanLyKeys.Base.NHOM_DANH_MUC).isEmpty()){
	groupIdString = "";
}else{
	groupIdString = ParamUtil.getString(request, QuanLyKeys.Base.NHOM_DANH_MUC);
}

List<Nhom> listNhoms = NhomLocalServiceUtil.getNhoms(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
String selectedName = ParamUtil.getString(request, QuanLyKeys.Base.SELECTED_NAME);
long selectedId = ParamUtil.getLong(request, QuanLyKeys.Base.SELECTED_ID);
long chaId = 0;
if(DanhMucLocalServiceUtil.fetchDanhMuc(selectedId) != null){
	chaId = DanhMucLocalServiceUtil.fetchDanhMuc(selectedId).getId();
}
String genHtml = QuanlyUtil.genHtmlString(selectedId, renderResponse.getNamespace());
String ma = ParamUtil.getString(request, QuanLyKeys.Base.MA);		 
String ten = ParamUtil.getString(request, QuanLyKeys.Base.TEN);

int cur = ParamUtil.getInteger(request, PortletKeys.SearchContainer.CURRENT_PAGE, PortletKeys.PAGE);
int delta = ParamUtil.getInteger(request, PortletKeys.SearchContainer.DELTA, PortletKeys.DELTA);

PortletURL renderURL= renderResponse.createRenderURL();
//renderURL.setParameter("mvcPath", "/html/danhmuc/portlet/quanly/view.jsp");
renderURL.setParameter(QuanLyKeys.Base.NHOM_DANH_MUC, groupIdString);
renderURL.setParameter(QuanLyKeys.Base.SELECTED_ID, String.valueOf(selectedId));
renderURL.setParameter(QuanLyKeys.Base.MA, ma);
renderURL.setParameter(QuanLyKeys.Base.TEN, ten);

// renderURL.setParameter(PortletKeys.SearchContainer.CURRENT_PAGE, GetterUtil.getString(cur));
// renderURL.setParameter(PortletKeys.SearchContainer.DELTA, GetterUtil.getString(delta));
// renderURL.setParameter(QuanLyKeys.Base.TEN, ten);
/* renderURL.setParameter(QuanLyKeys.Base.ID_NHOM, String.valueOf(groupId));
renderURL.setParameter(QuanLyKeys.Base.NHOM_DANH_MUC, String.valueOf(groupId)); */

int index = 1;
String msgEmpty = LanguageUtil.get(request, "org.oep.portlet.quanly.message.no.data");
SearchContainer<DanhMuc> searchContainer = new SearchContainer<DanhMuc>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, renderURL, null, msgEmpty);
int start = searchContainer.getStart();
int end = searchContainer.getEnd();
int total = DanhMucLocalServiceUtil.countByTimKiem(chaId,ten, groupIdString, "");

List<DanhMuc> listItems = null;
if(total >0){
	listItems = DanhMucLocalServiceUtil.searchItem(chaId,ten, groupIdString,"", start, end);
}
searchContainer.setTotal(total);
%>
<portlet:renderURL var="redirectURL">
	<portlet:param name="<%= PortletKeys.SET_VIEW_PARAMETER %>" value="/quanlyaction/view.jsp"/>
	<portlet:param name="<%=QuanLyKeys.Base.SELECTED_ID %>" value="<%=String.valueOf(selectedId) %>"/>
</portlet:renderURL>

<portlet:renderURL var="themItemUrl" >
	<portlet:param name="<%= PortletKeys.SET_VIEW_PARAMETER %>" value="/quanlyaction/them_item.jsp"/>
	<portlet:param name="<%=QuanLyKeys.Base.SELECTED_ID %>" value="<%=String.valueOf(selectedId) %>"/>
	<portlet:param name="<%=QuanLyKeys.Base.CHECK_ADD_EDIT %>" value="0"/>
	<portlet:param name="<%=QuanLyKeys.Base.ID_NHOM_DUOC_CHON %>" value="<%=maNhomDuocChon %>"/>
	<portlet:param name="<%=QuanLyKeys.Base.CURENT_URL %>" value="<%=curentUrl%>" />
</portlet:renderURL>

<portlet:renderURL var = "searchItemUrl" >
	<portlet:param name="<%= PortletKeys.SET_VIEW_PARAMETER %>" value="/quanlyaction/view.jsp"/>
	<portlet:param name="<%= PortletKeys.SearchContainer.DELTA %>" value="<%= String.valueOf(delta) %>"/>
	<portlet:param name="<%=QuanLyKeys.Base.ID_CHA %>" value="<%=String.valueOf(chaId)%>"/>
</portlet:renderURL>

<portlet:actionURL var = "xoaItemDuocChonUrl" name = "xoaItemDuocChon">
	<portlet:param name="<%= PortletKeys.REDIRECT_PAGE %>" value="<%= redirectURL %>"/>
</portlet:actionURL>

<portlet:actionURL var = "xoaTatItemUrl" name = "xoaTatItem">
	<portlet:param name="<%= PortletKeys.REDIRECT_PAGE %>" value="<%= redirectURL %>"/>
	<portlet:param name="<%=QuanLyKeys.Base.SELECTED_ID %>" value="<%=String.valueOf(selectedId) %>"/>
</portlet:actionURL>

<portlet:renderURL var = "importDanhMucUrl" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="<%=PortletKeys.SET_VIEW_PARAMETER %>" value="/quanlyaction/import.jsp"/>
	<portlet:param name="<%=QuanLyKeys.Base.SELECTED_ID %>" value="<%=String.valueOf(selectedId) %>"/>
</portlet:renderURL>

<portlet:renderURL var = "exportDanhMucUrl" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="<%=PortletKeys.SET_VIEW_PARAMETER %>" value="/quanlyaction/export.jsp"/>
	<portlet:param name="<%=QuanLyKeys.Base.SELECTED_ID %>" value="<%=String.valueOf(selectedId) %>"/>
</portlet:renderURL>
<div class="container" style="background-color: white;">
	<div class="bg-trang">
		<h4 class="tle" style="font-weight: 600 !important;">
			Quản lý danh mục
		</h4>
	</div>
<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_ITEM_HAS_CHILD %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_ITEM_HAS_CHILD %>"/>
	<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_NO_ITEM_SELECTED %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_NO_ITEM_SELECTED %>"/>
	<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_ITEMS_HAS_NO_CHILD %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_ITEMS_HAS_NO_CHILD %>"/>
	<div id = "genHtml">
		<a href = "#" style = "font-weight:bold;"" onclick ="<portlet:namespace/>xemCap(0)">Danh mục tổng</a><%=genHtml %><br><br>
	</div>
	<aui:form name="fmt" method="post" action = "<%=searchItemUrl %>">
		<aui:input type = "hidden" name="<%=QuanLyKeys.Base.SELECTED_ID %>" id = "<%=QuanLyKeys.Base.SELECTED_ID %>" ></aui:input>
		<aui:input type = "hidden" name="<%=QuanLyKeys.Base.SELECTED_NAME %>" id = "<%=QuanLyKeys.Base.SELECTED_NAME %>" ></aui:input>
		
		<aui:input type="hidden" name="<%= QuanLyKeys.Base.ITEM_IDS %>"/>
	
	<div class="row">
		<form name="<portlet:namespace/>fmt" method="post" action="<%=searchItemUrl%>">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<aui:input type="text" cssClass="oep-inputfield search" style = "width:99%" placeholder = '<%= LanguageUtil.get(request, "org.oep.portlet.quanly.input.timkiem")%>'
					 maxlength = "<%=QuanLyKeys.Base.TEN_MAX_LENGTH %>" label = "" id = "<%=QuanLyKeys.Base.TEN %>" 
					 name = "<%=QuanLyKeys.Base.TEN %>"/>
				</div>
			</div>
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<aui:select style="float:right" name="<%=QuanLyKeys.Base.NHOM_DANH_MUC %>" 
					id="<%=QuanLyKeys.Base.NHOM_DANH_MUC %>" onchange="submitFmtForm();" label="">
						<aui:option><liferay-ui:message key="org.oep.portlet.quanly.select.nhomdanhmuchienthi"/></aui:option>
					<%for (Nhom nhomDuocChon : lstNhomDuocChon){%>
						<aui:option value="<%=nhomDuocChon.getId()%>"><%=nhomDuocChon.getTen() %></aui:option>
					<%} %>
					</aui:select>
				</div>
			</div>
			<div class="col-md-12">
				<label class="control-label"></label>
				<div class="text-right" style="padding: 0px;margin-top: 10px;">
					<aui:button type="submit" icon="icon-search" style="margin-right: 5px;" value="search" onclick = "<portlet:namespace/>searchItem()" />
					<button style="float:right;margin-bottom: 7px !important;" type = "button" class = "oep-button" onclick = 'location.href = "<%= themItemUrl %>";'>
						<liferay-ui:message key="org.oep.portlet.quanly.button.themmoi"/>
					</button>
				</div>
			</div>
		</form>
	</div>
<div class="bg-trang">
		<h4 class="tle" style="font-weight: 600 !important;">
			Danh sách danh mục
		</h4>
	</div>
	<div class="row">
		<div class="col-md-12">
		<table class="table table-bordered">
		<tr style="text-align: center;">
			<th style="text-align: center;"><liferay-ui:message key="org.oep.portlet.quanly.table.header.index"/>
			<th style="text-align: center;"><input id="<portlet:namespace/>selectAllChkbox" type="checkbox" onclick="<portlet:namespace/>selectAll();"/>
			<th style="text-align: center;"><liferay-ui:message key="org.oep.portlet.quanly.table.header.ma"/>
			<th style="text-align: center;" colspan="8"><liferay-ui:message key="org.oep.portlet.quanly.table.header.ten"/>
			<th  colspan="2"><liferay-ui:message key="org.oep.portlet.quanly.table.header.trangthai"/>
			<th style="text-align: center;" colspan="3"><liferay-ui:message key="org.oep.portlet.quanly.table.header.tinhnang"/>
			
		</tr>
		<% 
		if (Validator.isNotNull(listItems)){
		for (DanhMuc item:listItems){ %>
		<portlet:renderURL var="suaItemUrl" >
			<portlet:param name="<%= QuanLyKeys.Base.SELECTED_ID %>" value="<%= String.valueOf(item.getId()) %>"/>
			<portlet:param name="<%=PortletKeys.SET_VIEW_PARAMETER %>" value="/quanlyaction/them_item.jsp"/>
			<portlet:param name="<%=QuanLyKeys.Base.CHECK_ADD_EDIT %>" value="1"/>
			<portlet:param name="<%=QuanLyKeys.Base.CHECK_FIRST_TIME %>" value="1"/>
			<portlet:param name="<%=QuanLyKeys.Base.CURENT_URL %>" value="<%=curentUrl%>" />
			
		</portlet:renderURL>
		<portlet:actionURL var="xoaItemUrl" name = "xoaItem">
			<portlet:param name="<%= QuanLyKeys.Base.SELECTED_ID %>" value="<%=String.valueOf(item.getId()) %>"/>
			<portlet:param name="<%= PortletKeys.REDIRECT_PAGE %>" value="<%= redirectURL %>"/>
		</portlet:actionURL>
		
		<portlet:renderURL var = "xemCapConURL" >
			<portlet:param name="<%= PortletKeys.SET_VIEW_PARAMETER %>" value="/quanlyaction/view.jsp"/>
			<portlet:param name="<%= QuanLyKeys.Base.SELECTED_ID %>" value="<%= String.valueOf(item.getId()) %>"/>
			<portlet:param name="<%=QuanLyKeys.Base.ID_CHA %>" value="<%=String.valueOf(item.getChaId())%>"/>
		</portlet:renderURL>
				
		
		<tr>
			<td style="text-align: center;"><%= searchContainer.getStart() + index++ %></td>
			<td style="text-align: center;"><input type="checkbox" name="oep-item" value="<%= String.valueOf(item.getId())%>"/></td>
			<td class = "text-center"><%= item.getMa() %></td>
			<td colspan="8" class = "text-left"><a href="#" onclick = "<portlet:namespace/>xemCap(<%=item.getId()%>)"><%=item.getTen() %></a></td>
			<td colspan="2" class = "text-center"><%=item.getTrangThai()? LanguageUtil.get(request, "org.oep.portlet.quanly.select.hoatdong") : LanguageUtil.get(request, "org.oep.portlet.quanly.select.khonghoatdong") %></td>
			<td colspan="3" class = "text-center">
				<a class = "oep-icon-edit" title="<liferay-ui:message key="org.oep.portlet.quanly.link.sua" />" href = "#" style = "margin-left:0px; margin-right:5px" onclick = "location.href = '<%= suaItemUrl%>'"></a>
				<a class = "oep-icon-delete"  title="<liferay-ui:message key="org.oep.portlet.quanly.link.xoa" />" href = "#" style = "margin-left:0px; margin-right:5px" onclick = "if (confirm('<%=LanguageUtil.get(request, "org.oep.portlet.item.confirm.delete.item")%>')){location.href = '<%= xoaItemUrl%>'}"></a> 
				<a class = "oep-icon-sitemap" title="<liferay-ui:message key="org.oep.portlet.quanly.link.xemcapcon" />"  href = "<%=xemCapConURL.toString() %>" style = "margin-left:0px; margin-right:5px" ></a>
			</td>	
		</tr>
		<%} 
		}%>
		</table>
		
		<c:if test="<%= searchContainer != null %>">
			<div id = "pagination">
				<br/>
				<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
			</div>
		</c:if>
		<table width = "100%" style="white-space: nowrap;margin-bottom: 20px;" class="oep-table-form">
			<tr>
				<td width="85px">
					<button class = "oep-button" style="width: 92%;" type = "button" onclick = "<portlet:namespace/>deleteSelectedItems()">
						<liferay-ui:message key="org.oep.portlet.quanly.button.xoa"/>
					</button>
				</td>
				<td width="85px">
					<button class = "oep-button" style="width: 85px;" type = "button" width = "100%" onclick = "if (confirm('<%=LanguageUtil.get(request, "org.oep.portlet.item.confirm.delete.all.item")%>')){location.href = '<%= xoaTatItemUrl%>';return false;}">
						<liferay-ui:message key="org.oep.portlet.quanly.button.xoatat"/>
					</button>
				</td>
				<td width="68%">
				</td>
				<td width="85px">
					
				</td>
				<td width="85px">
					<%-- <button class = "oep-button" style="width: 85px;" type = "button" onclick = "javascript:openDialogOEP('<liferay-ui:message key="org.oep.portlet.rule.dialog.title.import"/>', '<%= importDanhMucUrl %>', '300', '600');">
						<liferay-ui:message key="org.oep.portlet.quanly.button.import"/>
					</button> --%>
					<button class = "oep-button" style="width: 92%;" type = "button" onclick = "javascript:openDialogOEP('<liferay-ui:message key="org.oep.portlet.rule.dialog.title.export"/>', '<%= exportDanhMucUrl %>', '300', '600');">
						<liferay-ui:message key="org.oep.portlet.quanly.button.export"/>
					</button>
				</td>
				
			</tr>
		</table>
		</div>
		</div>
		</aui:form>
		
</div>
<script>

function <portlet:namespace/>searchItem(){
	$("#<portlet:namespace/><%=QuanLyKeys.Base.SELECTED_ID%>").val('<%=selectedId%>');
	document.<portlet:namespace/>fmt.action = "<%=searchItemUrl%>"; 
	document.<portlet:namespace/>fmt.submit();
}

function reload() {
	location.href= "<%= redirectURL %>";	
}


function <portlet:namespace/>deleteSelectedItems(){
	var items = $("input:checkbox[name=oep-item]:checked");
	var selectedItems = new Array();
	if (items) {
		items.each(function() {
			selectedItems.push($(this).val());
		});
	}
	document.<portlet:namespace/>fmt.<portlet:namespace/><%= QuanLyKeys.Base.ITEM_IDS %>.value = selectedItems.join();
	if (confirm('<%=LanguageUtil.get(request, "org.oep.portlet.item.confirm.delete.selected.item")%>')){
		document.<portlet:namespace/>fmt.action = "<%=xoaItemDuocChonUrl%>";
		document.<portlet:namespace/>fmt.submit();
	}
}


function <portlet:namespace/>xemCap(selectedId){
	$("#<portlet:namespace/><%=QuanLyKeys.Base.SELECTED_ID%>").val(selectedId);
	$("#<portlet:namespace/><%=QuanLyKeys.Base.MA%>").val("");
	$("#<portlet:namespace/><%=QuanLyKeys.Base.TEN%>").val("");
	$("#<portlet:namespace/><%=QuanLyKeys.Base.NHOM_DANH_MUC%>").val("");
	document.<portlet:namespace/>fmt.submit();
}

function <portlet:namespace/>selectAll(){
	var checked = $("#<portlet:namespace/>selectAllChkbox").prop('checked');	
	var areas = $("input:checkbox[name=oep-item]");
	if(areas){
		areas.each(function() {
			$(this).prop('checked', checked);
		});
	}
}
function submitFmtForm(){
	document.<portlet:namespace/>fmt.submit();
}

$( document ).ready(function(){
	<%if(selectedId != 0){
	DanhMuc item = DanhMucLocalServiceUtil.fetchDanhMuc(selectedId);
	%>
		$("#<portlet:namespace/><%=QuanLyKeys.Base.NHOM_DANH_MUC%>").val("<%=item.getNhomId()%>");
		$("#<portlet:namespace/><%=QuanLyKeys.Base.NHOM_DANH_MUC%>").attr('disabled','disabled');
	<%}%>
});
</script>


