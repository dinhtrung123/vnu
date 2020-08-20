<%@page import="javax.xml.crypto.Data"%>
<%@page import="dtt.vn.user.keys.QuanLyImportUserKeys"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="dtt.vn.user.service.service.DataImportLocalServiceUtil"%>
<%@page import="dtt.vn.user.service.model.DataImport"%>
<%@page import="java.util.List"%>
<%@page import="dtt.vn.user.keys.PortletKeysUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.net.URL"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.util.Date"%>
<%@page import="dtt.vn.user.common.utils.DateUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/init.jsp"%>
<style type="text/css">
body {
	overflow-x: hidden;
}
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css">

<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/js/bootstrap-datetimepicker.min.js"></script>

<%
	PortletURL portletURL = renderResponse.createActionURL();
	int cur               = ParamUtil.getInteger(request, PortletKeysUtil.SearchContainer.CURRENT_PAGE, PortletKeysUtil.PAGE);
	int delta             = ParamUtil.getInteger(request, PortletKeysUtil.SearchContainer.DELTA, PortletKeysUtil.DELTA);
	String msgEmpty       = "Không có dữ liệu";
	
	int hasImport = ParamUtil.getInteger(request, "hasImport", QuanLyImportUserKeys.Base.TAT_CA);
	String hovaten = ParamUtil.getString(request, "hovaten","");
	String tentaikhoan = ParamUtil.getString(request, "tentaikhoan","");
	String email = ParamUtil.getString(request, "email","");
	String vaitro = ParamUtil.getString(request, "vaitro","");
	String startDate = ParamUtil.getString(request, "startDate","");
	String endDate = ParamUtil.getString(request, "endDate","");
	
	portletURL.setParameter("hasImport", String.valueOf(hasImport));
	portletURL.setParameter("hovaten", hovaten);
	portletURL.setParameter("tentaikhoan", tentaikhoan);
	portletURL.setParameter("email", email);
	portletURL.setParameter("vaitro", vaitro);
	portletURL.setParameter("startDate", startDate);
	portletURL.setParameter("endDate", endDate);

	SearchContainer searchContainer = new SearchContainer<DataImport>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, portletURL, null, msgEmpty);
	String tungayin = DateUtil.formatDate(startDate+" 00:00:00", DateUtil.DATE_FORMAT_D_M_Y_H_M_S, DateUtil.DATE_FORMAT_D_M_Y_H_M_S_1);
	String denngayin = DateUtil.formatDate(endDate+" 23:59:59", DateUtil.DATE_FORMAT_D_M_Y_H_M_S, DateUtil.DATE_FORMAT_D_M_Y_H_M_S_1);
	
	List<DataImport> resultsAccountRecords = DataImportLocalServiceUtil.searchForImport(hasImport, tentaikhoan, hovaten, email, vaitro, tungayin, denngayin, searchContainer.getStart(), searchContainer.getEnd());
	int totalAccountRecords = DataImportLocalServiceUtil.countForImport(hasImport, tentaikhoan, hovaten, email, vaitro, tungayin, denngayin);
	searchContainer.setTotal(totalAccountRecords);
	searchContainer.setResults(resultsAccountRecords);

	User currentUser = PortalUtil.getUser(request);
	boolean isadmin = false;
	if (currentUser != null) {
		List<Role> roles = currentUser.getRoles();

		for (Role role : roles) {
			if (role.getName().equals("Administrator") || role.getName().equals("Site Administrator")) {
				isadmin = true;
				break;
			}
		}
	}
%>
<%
	
if(request.getAttribute("isSuccess")!= null){
	
	boolean isSucess = Boolean.parseBoolean(request.getAttribute("isSuccess").toString());
	if(isSucess){

		%>
	<div class="alert alert-success" role="alert">Yêu cầu của bạn đã được xử lý thành công</div>
	<%
	}else{
		%>
	<div class="alert alert-danger" role="alert">Yêu cầu xử lý của bạn thất bại</div>
	<%
	}
}

%>
<portlet:actionURL name="export" var="exportURL">
</portlet:actionURL>
<portlet:actionURL name="uploadexport" var="uploadURL">
</portlet:actionURL>
 <portlet:actionURL name="importData" var="importURL" /> 

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/quanlyimportuser/view.jsp" />
</liferay-portlet:renderURL>

<div class="container" style="background-color: white;">
	<div class="bg-trang">
		<h4 class="tle" style="font-weight: 600 !important;">Quản lý
			Import User</h4>
	</div>
	<div class="row">
		<aui:form action="<%=searchURL%>" method="get" name="fm">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
			<div class="col-md-6">
				<div class="form-group">
					<%-- <aui:select label="Tìm kiếm theo trạng thái" id="<portlet:namespace/>hasImport" name="<portlet:namespace/>hasImport"  >
			            <option value="<%=QuanLyImportUserKeys.Base.TAT_CA %>" <%= hasImport == QuanLyImportUserKeys.Base.TAT_CA?"selected":"" %>>Tất cả</option>
			            <option value="<%=QuanLyImportUserKeys.Base.LOI %>" <%= hasImport == QuanLyImportUserKeys.Base.LOI?"selected":"" %>>Lỗi</option>
			            <option value="<%=QuanLyImportUserKeys.Base.CHUA_DONG_BO %>" <%= hasImport == QuanLyImportUserKeys.Base.CHUA_DONG_BO?"selected":"" %>>Chưa đồng bộ</option>
			            <option value="<%=QuanLyImportUserKeys.Base.DONG_BO_THANH_CONG %>" <%= hasImport == QuanLyImportUserKeys.Base.DONG_BO_THANH_CONG?"selected":"" %>>Đồng bộ thành công</option>
			        </aui:select> --%>
			        <label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.trangthaidongbo"/></label>
			        <select name="<portlet:namespace/>hasImport" class="form-control" id="sel1">
						<option value="<%=QuanLyImportUserKeys.Base.TAT_CA%>" <%if(hasImport == QuanLyImportUserKeys.Base.TAT_CA){%>selected="selected"<%}%>>
							<liferay-ui:message key="portlet.tinhtrang.tatca" /></option>
						<option value="<%=QuanLyImportUserKeys.Base.LOI%>" <%if(hasImport == QuanLyImportUserKeys.Base.LOI){%>selected="selected"<%}%>>
							<liferay-ui:message key="portlet.tinhtrang.loi" /></option>
						<option value="<%=QuanLyImportUserKeys.Base.CHUA_DONG_BO%>" <%if(hasImport == QuanLyImportUserKeys.Base.CHUA_DONG_BO){%>selected="selected"<%}%>>
							<liferay-ui:message key="portlet.tinhtrang.chuadongbo" /></option>
						<option value="<%=QuanLyImportUserKeys.Base.DONG_BO_THANH_CONG%>" <%if(hasImport == QuanLyImportUserKeys.Base.DONG_BO_THANH_CONG){%>selected="selected"<%}%>>
							<liferay-ui:message key="portlet.tinhtrang.dongbothanhcong" /></option>
					</select>
		        </div>
		        <div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.hovaten"/></label>
					<input type="text" class="form-control" id="<portlet:namespace/>hovaten" name="<portlet:namespace/>hovaten" value="<%=hovaten%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.email"/></label>
					<input type="text" class="form-control" id="<portlet:namespace/>email" name="<portlet:namespace/>email" value="<%=email%>">
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.tentaikhoan"/></label>
					<input type="text" class="form-control" id="<portlet:namespace/>tentaikhoan" name="<portlet:namespace/>tentaikhoan" value="<%=tentaikhoan%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.ngaydongbo"/></label>
						<div class="form-group" style="display: grid; grid-template-columns: auto auto">
								<div class="">
									<input id="startDate" name="<portlet:namespace/>startDate" placeholder="Từ ngày" type="text" class="form-control" value="<%=startDate %>" />
								</div>
								<div class=""  style="padding-left: 5px">
									<input id="endDate" name="<portlet:namespace/>endDate" placeholder="Đến ngày" type="text" class="form-control" value="<%=endDate%>"/>
								</div>
						</div>
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.vaitro"/></label>
					<input type="text" class="form-control" id="<portlet:namespace/>vaitro" name="<portlet:namespace/>vaitro" value="<%=vaitro%>">
				</div>
			</div>
			<div class="col-md-12">
				<label class="control-label"></label>
				<div class="text-right" style="padding: 0px;">
					<aui:button type="submit" icon="icon-search" value="search" />
					<%
							 if(currentUser != null){
								 if (PortalUtil.isOmniadmin(currentUser.getUserId())) { %>
									<% 
										if(hasImport!= 0 && hasImport!= 2 ){
									%>
									<input value="Thêm" type="button" onclick = 'themfunction();' class="btn btn-primary" />
										
									<%} else{ %>
										<input value="Thêm" type="button" onclick = 'themfunction();' class="btn btn-primary" />
									<%} %>
					<% } 
							 }
							 %>
				</div>
			</div>
		</aui:form>
		<aui:form action="<%=importURL%>" method="post" name="inportform">
		</aui:form>
	</div>
	<div class="bg-trang">
		<div class="row">
			<div class="col-md-6">
				<h4 class="tle" style="font-weight: 600 !important;">Danh sách
			đồng bộ tài khoản (VNPOST)</h4>
			</div>
			<div class="col-md-6 text-right" style="padding-top: 12px;">
				<button onclick="openExport();" type="button"
					class="btn btn-default btn-sm">
					<span class="glyphicon glyphicon-cloud-download"></span> Tải về
				</button>
				<button onclick="openUpload();" type="button"
					class="btn btn-default btn-sm">
					<span class="glyphicon glyphicon-upload"></span> Upload
				</button>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="">
			   <div class="container" id="dieukientruyvan">
			   		<h5 class="">
			   			<i><liferay-ui:message key="portlet.import.tongsobanghi" />: <%=totalAccountRecords %></i>
			   		</h5>
			   </div>
			</div>
			<div class="table-responsive">
				<table class="table table-bordered table-hover">
					<thead>
						<tr style="text-align: center;">
							<th style="text-align: center;" scope="col">STT</th>
							<th style="text-align: center;" scope="col">Tên tài khoản</th>
							<th style="text-align: center;" scope="col">Họ tên</th>
							<th style="text-align: center;" scope="col">Email</th>
							<th style="text-align: center;" scope="col">Vai trò</th>
							<th style="text-align: center;" scope="col">Trạng thái</th>
							<th style="text-align: center;" scope="col">Ngày đồng bộ</th>
							<th style="text-align: center;" scope="col">Lỗi</th>
							<th style="text-align: center;" scope="col">Hoạt động</th>
						</tr>
					</thead>
					<tbody>
						<%
								if (resultsAccountRecords != null) {
									int stt = searchContainer.getStart() + 1;
									for (DataImport dataimport : resultsAccountRecords) {
							%>
						<tr>
							<td style="text-align: center;"><%=stt++%></td>
							<td><%=dataimport.getScreenName()%></td>
							<td><%=dataimport.getLastName()%></td>
							<td><%=dataimport.getEmailAddress()%></td>
							<td><%=dataimport.getNameRole()%></td>
							<td style="text-align: center;"><%=dataimport.getHasImport()%></td>
							<td style="text-align: center;"><%=DateUtil.convertDateToString(dataimport.getInsertDate(),"dd/MM/yyyy")%></td>
							<td style="overflow-x:auto !important; "><%=dataimport.getErrorMsg()%></td>
							<td colspan="3" class = "text-center">
							<%
								 if(currentUser != null){
									 if (PortalUtil.isOmniadmin(currentUser.getUserId())) { %>
							
								<a  title="Sửa"  style = "margin-left:0px; margin-right:5px; cursor: pointer"><span style="color: #337ab7 " onclick="edit(<%= dataimport.getId() %>);" class="glyphicon glyphicon-edit"></span></a>
							
							<% } 
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
		<c:if test="<%=searchContainer != null%>">
			<div id="pagination">
				<br />
				<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
			</div>
		</c:if>
	</div>
</div>
<portlet:actionURL name="edit" var="edithURL">
	</portlet:actionURL>
<div class="row">
	<div class="col-md-12">

		<!-- Modal -->
		<div class="modal fade" style="display: none;" id="edit-modal"
			tabindex="-1" role="dialog" aria-labelledby="edit-modalmodal"
			aria-hidden="true">
			<div class="modal-dialog" role="document"
				style="position: relative !important;">
				<div class="modal-content" style="width: 500px;">
					<div class="modal-header">
						<h5 class="modal-title" id=""></h5>
						<button type="button" class="close" data-dismiss="modal"
							onclick="closePopupAttributeimage();" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12 bg-trang">
								<h4>Thông tin thay đổi</h4>
							</div>
						</div>
						<div class="row">
							 <form id="form-edit" method="POST" action="<%=edithURL%>"> 
								<div class="col-md-12">
									<div class="form-group">
										<label for="email">Họ tên</label> <input type="text"
											class="form-control" value=""
											id="<portlet:namespace/>lastName"
											name="<portlet:namespace/>lastName"> <input
											type="hidden" id="<portlet:namespace/>idedit"
											name="<portlet:namespace/>idedit" />
									</div>
									<div class="form-group">
										<label for="email">Tên tài khoản</label> <input type="text"
											class="form-control" id="<portlet:namespace/>ScreenName"
											name="<portlet:namespace/>ScreenName" value="">
									</div>
									<div class="form-group">
										<label for="email">Email</label> <input type="text"
											class="form-control" value="" id="<portlet:namespace/>Email"
											name="<portlet:namespace/>Email">
									</div>
									<div class="form-group">
										<label for="email">Vai trò</label> <input type="text"
											class="form-control" value="" id="<portlet:namespace/>Vaitro"
											name="<portlet:namespace/>Vaitro">
									</div>
									<div class="form-group">
										<label for="email">Lỗi</label> <input readonly type="text"
											class="form-control" id="<portlet:namespace/>Error"
											name="<portlet:namespace/>Error" value="">
									</div>
								</div>
							 </form> 
						</div>
					</div>
					<div class="modal-footer" style="text-align: right;">
						<button type="button" class="btn btn-primary"
							onclick="actionedit();">Lưu lại</button>
						<button type="button" class="btn btn-primary"
							onclick="closePopupAttributeimage();">Đóng</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- Modal -->
<div class="row">
	<div class="col-md-12">
		<div class="modal fade" style="display: none;" id="myModal"
			tabindex="-1" role="dialog" aria-labelledby="edit-modalmodal"
			aria-hidden="true">
			<div class="modal-dialog" role="document"
				style="position: relative !important;">
					<div class="modal-content" style="width: 500px;">
						<div class="modal-header">
						<h5 class="modal-title" id=""></h5>
						<button type="button" class="close" data-dismiss="modal"
							onclick="closeExport();" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form id="exportCSV" method="POST" action="<%=exportURL%>">
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12 bg-trang">
								<h4>Export dữ liệu</h4>
							</div>
						</div>
						<div class="modal-body">
							
							<div class="form-group">
								<aui:select label="Chọn trạng thái cần Export" id="hasImport3"
									name="hasImport3">
									<option value="<%=QuanLyImportUserKeys.Base.TAT_CA%>"
										<%=hasImport == QuanLyImportUserKeys.Base.TAT_CA ? "selected" : ""%>>Tất
										cả</option>
									<option value="<%=QuanLyImportUserKeys.Base.LOI%>"
										<%=hasImport == QuanLyImportUserKeys.Base.LOI ? "selected" : ""%>>Lỗi</option>
									<option value="<%=QuanLyImportUserKeys.Base.CHUA_DONG_BO%>"
										<%=hasImport == QuanLyImportUserKeys.Base.CHUA_DONG_BO ? "selected" : ""%>>Chưa
										đồng bộ</option>
									<option
										value="<%=QuanLyImportUserKeys.Base.DONG_BO_THANH_CONG%>"
										<%=hasImport == QuanLyImportUserKeys.Base.DONG_BO_THANH_CONG ? "selected" : ""%>>Đồng
										bộ thành công</option>
								</aui:select>
							</div>
						</div>
						<div class="modal-footer" style="text-align: right;">
						<button type="button" class="btn btn-primary"
							onclick="actionExport();">Export</button>
						<button type="button" class="btn btn-primary"
							onclick="closeExport();">Đóng</button>

					</div>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="row">
	<div class="col-md-12">
		<div class="modal fade" style="display: none;" id="uploadexport"
			tabindex="-1" role="dialog" aria-labelledby="edit-modalmodal"
			aria-hidden="true">
			<div class="modal-dialog" role="document"
				style="position: relative !important;">
					<div class="modal-content" style="width: 500px;">
						<div class="modal-header">
						<h5 class="modal-title" id=""></h5>
						<button type="button" class="close" data-dismiss="modal"
							onclick="closeUpload();" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
					<form id="upload-form" method="POST" action="<%=uploadURL%>" enctype="multipart/form-data">
						<div class="row">
							<div class="col-md-12 bg-trang">
								<h4>Upload dữ liệu</h4>
							</div>
						</div>
						<div class="modal-body">
							<input  type="file" name="file-import"
								class="btn btn-default btn-sm">
						</div>
						<div class="modal-footer" style="text-align: right;">
						<button type="button" class="btn btn-primary"
							onclick="actionUpload();">Upload</button>
						<button type="button" class="btn btn-primary"
							onclick="closeUpload();">Đóng</button>

					</div>
					</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<portlet:resourceURL var="vieweditURL" id="viewedit">
</portlet:resourceURL>
<script type="text/javascript">
function themfunction(){
	$('#<portlet:namespace/>inportform').submit();
}
function actionedit(){
	if (confirm("Bạn chắc chắn muốn cập nhật lại thông tin và đồng bộ lại tài khoản?")){
	$('#form-edit').submit();
} else{
	return;
	}
}
function edit(id){
	//ajax
	
	$.ajax({
		type:'POST',
		data:{"<portlet:namespace/>idedit":id},
		url:'<%=vieweditURL%>',
		beforeSend: function (xhr) {
	      
	    },
		success:function(result){
			if(result != ''){
				var obj = JSON.parse(result);
				$('#<portlet:namespace/>lastName').val(obj._lastName);
				$('#<portlet:namespace/>hasImport2').val(obj._hasImport);
				$('#<portlet:namespace/>ScreenName').val(obj._screenName);
				$('#<portlet:namespace/>Error').val(obj._errorMsg);
				$('#<portlet:namespace/>Email').val(obj._emailAddress);
				$('#<portlet:namespace/>Vaitro').val(obj._nameRole);
				$('#<portlet:namespace/>idedit').val(obj._id);
				$('#edit-modal').removeClass('fade').removeClass('hide').addClass('show');
			}else{
				alert("Không thể chỉnh sửa");
			}
			
			
		},
		error: function (request, status, error) {
			alert('<liferay-ui:message key="portlet.quanlytaikhoan.loiserver"/>');
	    }
	});
	
	
	
	
}
function closePopupAttributeimage() {
	$('#edit-modal').removeClass('show').addClass('hide');
}
function closeExport() {
	$('#myModal').removeClass('show').addClass('hide');
}
function openExport() {
	$('#myModal').removeClass('fade').removeClass('hide').addClass('show');
}
function openUpload() {
	$('#uploadexport').removeClass('fade').removeClass('hide').addClass('show');
}
function closeUpload() {
	$('#uploadexport').removeClass('show').addClass('hide');
}
function actionExport(){
	$('#exportCSV').submit();
}
function actionUpload(){
	$('#upload-form').submit();
}


//check Date Range

var bindDateRangeValidation = function (f, s, e) {
    if(!(f instanceof jQuery)){
			console.log("Not passing a jQuery object");
    }
  
    var jqForm = f,
        startDateId = s,
        endDateId = e;
  
    var checkDateRange = function (startDate, endDate) {
        var isValid = (startDate != "" && endDate != "") ? startDate <= endDate : true;
        return isValid;
    }

    var bindValidator = function () {
        var bstpValidate = jqForm.data('bootstrapValidator');
        var validateFields = {
            startDate: {
                validators: {
                    notEmpty: { message: 'This field is required.' },
                    callback: {
                        message: 'Start Date must less than or equal to End Date.',
                        callback: function (startDate, validator, $field) {
                            return checkDateRange(startDate, $('#' + endDateId).val())
                        }
                    }
                }
            },
            endDate: {
                validators: {
                    notEmpty: { message: 'This field is required.' },
                    callback: {
                        message: 'End Date must greater than or equal to Start Date.',
                        callback: function (endDate, validator, $field) {
                            return checkDateRange($('#' + startDateId).val(), endDate);
                        }
                    }
                }
            },
          	customize: {
                validators: {
                    customize: { message: 'customize.' }
                }
            }
        }
        if (!bstpValidate) {
            jqForm.bootstrapValidator({
                excluded: [':disabled'], 
            })
        }
      
        jqForm.bootstrapValidator('addField', startDateId, validateFields.startDate);
        jqForm.bootstrapValidator('addField', endDateId, validateFields.endDate);
      
    };

    var hookValidatorEvt = function () {
        var dateBlur = function (e, bundleDateId, action) {
            jqForm.bootstrapValidator('revalidateField', e.target.id);
        }

        $('#' + startDateId).on("dp.change dp.update blur", function (e) {
            $('#' + endDateId).data("DateTimePicker").setMinDate(e.date);
            dateBlur(e, endDateId);
        });

        $('#' + endDateId).on("dp.change dp.update blur", function (e) {
            $('#' + startDateId).data("DateTimePicker").setMaxDate(e.date);
            dateBlur(e, startDateId);
        });
    }

    bindValidator();
    hookValidatorEvt();
};


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

 
</script>
