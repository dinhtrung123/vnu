<%@page import="java.util.Date"%>
<%@page import="dtt.vn.user.common.utils.DateUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="dtt.vn.user.keys.PortletKeysUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.net.URL"%>
<%@page import="dtt.vn.user.service.model.ThongTinDangKy"%>
<%@page import="dtt.vn.user.service.service.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/init.jsp"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>

<style type="text/css">
body {
	overflow-x: hidden;
}
</style>
<%

PortletURL portletURL = renderResponse.createActionURL();
int cur               = ParamUtil.getInteger(request, PortletKeysUtil.SearchContainer.CURRENT_PAGE, PortletKeysUtil.PAGE);
int delta             = ParamUtil.getInteger(request, PortletKeysUtil.SearchContainer.DELTA, PortletKeysUtil.DELTA);
String msgEmpty       = "Không có dữ liệu";
String tukhoa =       ParamUtil.getString(request, "tukhoa","");
String tungay =ParamUtil.getString(request, "tungay",DateUtil.parseDateToString(DateUtil.getBeginOfMonth(new Date()), DateUtil.DATE_FORMAT_D_M_Y)).trim();
String denngay = ParamUtil.getString(request, "denngay",DateUtil.parseDateToString(DateUtil.getCurrentDateTime(), DateUtil.DATE_FORMAT_D_M_Y)).trim();
String tungayin = "";
String denngayin = "";
if(!tungay.equals("")){
	tungayin = DateUtil.formatDate(tungay+" 00:00:00", DateUtil.DATE_FORMAT_D_M_Y_H_M_S, DateUtil.DATE_FORMAT_D_M_Y_H_M_S_1);
}
if(!denngay.equals("")){
	denngayin = DateUtil.formatDate(denngay+" 23:59:59", DateUtil.DATE_FORMAT_D_M_Y_H_M_S, DateUtil.DATE_FORMAT_D_M_Y_H_M_S_1);
}

SearchContainer searchContainer = new SearchContainer<ThongTinDangKy>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, portletURL, null, msgEmpty);
List<ThongTinDangKy> resultsAccountRecords = ThongTinDangKyLocalServiceUtil.searchByEmailOrUsername(tukhoa,tungayin,denngayin, searchContainer.getStart(), searchContainer.getEnd());

int totalAccountRecords = ThongTinDangKyLocalServiceUtil.countByEmailOrUsername(tukhoa,tungayin,denngayin);
searchContainer.setTotal(totalAccountRecords);
searchContainer.setResults( resultsAccountRecords);

User currentUser = null;
boolean isadmin = false;
try {
	currentUser = PortalUtil.getUser(request);
	if(currentUser!= null){
		List<Role> roles = currentUser.getRoles();
		for(Role role:roles){
			if(role.getName().equals("Administrator") || role.getName().equals("Site Administrator")){
				isadmin = true;
				break;
			}
		}
	}
} catch (Exception ex) {
	
}

%>

<portlet:actionURL name="importData" var="importURL" />

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/quanlydangky/view.jsp" />
</liferay-portlet:renderURL>
<div class="container" style="background-color: white;">

	<%
	
if(request.getAttribute("isSuccess")!= null){
	
	boolean isSucess = Boolean.parseBoolean(request.getAttribute("isSuccess").toString());
	if(isSucess){

		%>
	<div class="alert alert-success" role="alert">Thành công</div>
	<%
	}else{
		%>
	<div class="alert alert-danger" role="alert">Thất bại</div>
	<%
	}
}

%>
	<div class="bg-trang">
		<h4 class="tle" style="font-weight: 600 !important;">Quản lý
			thông tin đăng ký</h4>
	</div>
	<div class="row">
		<aui:form action="<%= searchURL %>" method="get" name="fm">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label" for="exampleInputEmail1">Tìm
						kiếm</label> <input type="text" class="form-control"
						placeholder="Tìm kiếm theo username hoặc email"
						name="<portlet:namespace/>tukhoa" value="<%= tukhoa %>" />
				</div>
			</div>
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd">Từ ngày</label> <input
						type="text" class="form-control" id="startDate"
						name="<portlet:namespace/>tungay" value="<%= tungay %>">
				</div>
			</div>
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd">Đến ngày</label> <input
						type="text" class="form-control" id="endDate"
						name="<portlet:namespace/>denngay" value="<%= denngay %>">
				</div>
			</div>
			<div class="col-md-12">
				<label class="control-label"></label>
				<div class="text-right" style="padding: 0px;">
					<aui:button type="submit" icon="icon-search" value="search" />
				</div>
			</div>
		</aui:form>
	</div>
	<div class="bg-trang">
		<h4 class="tle" style="font-weight: 600 !important;">Danh sách
			tài khoản đăng ký</h4>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-bordered">
				<thead>
					<tr style="text-align: center;">
						<th style="text-align: center;" scope="col"><liferay-ui:message
								key="portlet.quanlydangky.danhsach.stt" /></th>
						<th style="text-align: center;" scope="col"><liferay-ui:message
								key="portlet.quanlydangky.danhsach.id" /></th>
						<th style="text-align: center;" scope="col"><liferay-ui:message
								key="portlet.quanlydangky.danhsach.username" /></th>
						<th style="text-align: center;" scope="col">Ngày tạo</th>
						<th style="text-align: center;" scope="col"><liferay-ui:message
								key="portlet.quanlydangky.danhsach.makichkoat" /></th>
						<th style="text-align: center;" scope="col"><liferay-ui:message
								key="portlet.quanlydangky.danhsach.activetype" /></th>
						<th style="text-align: center;" scope="col"><liferay-ui:message
								key="portlet.quanlydangky.danhsach.action" /></th>
					</tr>
				</thead>
				<tbody>
					<%
		   if(resultsAccountRecords!= null){
			   int stt = searchContainer.getStart()+1;
			   for(ThongTinDangKy ttdk : resultsAccountRecords){
				   %>

					<portlet:actionURL name="kichhoat" var="kichhoatURL">
						<portlet:param name="ttdkId"
							value="<%=String.valueOf(ttdk.getId())%>" />

					</portlet:actionURL>
					<portlet:actionURL var="deleteURL" name="delete">
						<portlet:param name="ttdkId"
							value="<%=String.valueOf(ttdk.getId())%>" />
					</portlet:actionURL>

					<tr>
						<td style="text-align: center;"><%= stt ++ %></td>
						<td style="text-align: center;"><%= ttdk.getId() %></td>
						<td><%= ttdk.getUserName() %></td>
						<td style="text-align: center;"><%= DateUtil.parseDateToString(ttdk.getNgayTao(), DateUtil.DATE_FORMAT_D_M_Y)  %></td>
						<td style="text-align: center;"><%= ttdk.getMaKichHoat() %></td>
						<td><%= ttdk.getActiveType() %></td>
						<td style="text-align: center;">
							<%
				   	if(isadmin){
				   		%> <a onclick="luutam(0,'<%=kichhoatURL %>');"> <span
								class="glyphicon glyphicon-sort" style="color: blue;"></span>
						</a> <a onclick="luutam(1,'<%=deleteURL %>');"> <span
								class="glyphicon glyphicon-remove" style="color: red;"></span>
						</a> <%
				   	}
				   	%>

						</td>
					</tr>
					<%
			   }
		   }
		   %>
				</tbody>
			</table>
		</div>
	</div>
	<c:if test="<%= searchContainer != null %>">
		<div id="pagination">
			<br />
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
		</div>
	</c:if>
</div>
<script type="text/javascript">


$(function () {
    var sd = null, ed = null;
  
    $('#startDate').datetimepicker({ 
      pickTime: false, 
      format: "DD/MM/YYYY", 
      defaultDate: sd, 
      maxDate: ed 
    });
  
    $('#endDate').datetimepicker({ 
      pickTime: false, 
      format: "DD/MM/YYYY", 
      defaultDate: ed, 
      minDate: sd 
    });

    //passing 1.jquery form object, 2.start date dom Id, 3.end date dom Id
    bindDateRangeValidation($("#form"), 'startDate', 'endDate');
});
function confim(url){
	
}
function luutam(ind,url){
	
	var titlecomfim = "Xác nhận";
	var content = "";
	if(ind == 0){
		content = "Bạn có muốn kích hoạt tài khoản này?"
	}else if(ind == 1){
		content = "Bạn có muốn xóa tài khoản này?"
	}else{
		
	}
	$.confirm({
	    title: titlecomfim,
	    content: content,
	    autoClose: 'dong|8000',
	    buttons: {
	        somethingElse: {
	            text: 'Tiếp tục',
	            btnClass: 'btn-blue',
	            keys: ['enter', 'shift'],
	            action: function(){
	            	var atag = document.createElement("a");
	            	atag.href = url;
	            	atag.click();
	            }
	        },
	        dong: {
	            text: 'Đóng',
	            btnClass: 'btn-default',
	            keys: ['esc'],
	            action: function(){
	               
	            }
	        }
	    }
	});
}
</script>
