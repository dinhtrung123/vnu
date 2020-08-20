<%@page import="org.oep.danhmuc.model.DanhMuc"%>
<%@page import="dtt.vn.account.util.DanhMucKeys"%>
<%@page import="org.oep.danhmuc.service.DanhMucLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="dtt.vn.account.util.DateUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="dtt.vn.audit.model.AuditEvent"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="dtt.vn.audit.service.AuditEventLocalServiceUtil"%>
<%@ include file="/auditportlet/init.jsp" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css">

<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/js/bootstrap-datetimepicker.min.js"></script>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/phancongportlet/phancong.jsp" />
</liferay-portlet:renderURL>
<%

List<DanhMuc> listTinhThanhs = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.DONVIHANHCHINH.MA, 1, true);

long auditEventId = ParamUtil.getLong(request, "auditEventId");
String usSearch = ParamUtil.getString(request, "tukhoa","").trim();
String fullname = ParamUtil.getString(request, "fullname","").trim();
System.out.print("usSearch:------:"+usSearch);
String tungay = ParamUtil.getString(request, "tungay","").trim();
String denngay = ParamUtil.getString(request, "denngay","").trim();


int index = 1;
int cur = ParamUtil.getInteger(request, "cur", 1);
int delta = ParamUtil.getInteger(request, "delta", 10);
PortletURL renderURL= renderResponse.createRenderURL();

SearchContainer<AuditEvent> searchContainer = new SearchContainer<AuditEvent>(renderRequest, null, null, 
		SearchContainer.DEFAULT_CUR_PARAM,
		cur, delta, renderURL, null, "Không có dữ liệu");
int start = searchContainer.getStart();
int end = searchContainer.getEnd();
String tungayin = DateUtil.formatDate(tungay+" 00:00:00", DateUtil.DATE_FORMAT_D_M_Y_H_M_S, DateUtil.DATE_FORMAT_D_M_Y_H_M_S_1);
String denngayin = DateUtil.formatDate(denngay+" 23:59:59", DateUtil.DATE_FORMAT_D_M_Y_H_M_S, DateUtil.DATE_FORMAT_D_M_Y_H_M_S_1);
int total = AuditEventLocalServiceUtil.countcustom(usSearch, tungayin, denngayin,fullname);
List<AuditEvent> listEvent = null;
if(total > 0){
	listEvent = AuditEventLocalServiceUtil.searchcustom(usSearch, tungayin, denngayin, start, end,fullname);
}
searchContainer.setTotal(total);
renderURL.setParameter("tungay", tungay);
renderURL.setParameter("denngay", denngay);
renderURL.setParameter("tukhoa", usSearch);
renderURL.setParameter("fullname", fullname);
%>
<style type="text/css">
body{
overflow-x:hidden;
}
</style>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/auditportlet/view.jsp" />
</liferay-portlet:renderURL>
<div class="container" style="background-color: white;">
<div class="row">
	<div class="col-md-12">
	<div class="bg-trang">
   		
         	<h4 class="tle" style="font-weight: 600 !important;">
			Điều kiện truy vấn
		</h4>
    </div>
	<aui:form action="<%= searchURL %>" method="get" name="fm">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
			<%-- <div class="form-inline">
	 
  <div class="form-group">
    <input type="text" class="form-control" id="<portlet:namespace/>tukhoa" name="<portlet:namespace/>tukhoa" value="<%= usSearch %>" placeholder="Tên tài khoản" />
  </div>
  <div class="form-group">
    <label for="pwd">Từ ngày</label>
    <input type="text" class="form-control" id="startDate" name="<portlet:namespace/>tungay" value="<%= tungay %>">
  </div>
  <div class="form-group">
    <label for="pwd">Đến ngày</label>
    <input type="text" class="form-control" id="endDate" name="<portlet:namespace/>denngay" value="<%= denngay %>">
  </div>
  <input type="submit" class="btn btn-primary" value="Tìm kiếm" />
</div> --%>
		<div class="row">
			<div class="col-md-6">
			<div class="form-group">
			    <label class="control-label" for="exampleInputEmail1">Tên đăng nhập</label>
			    <input type="text" class="form-control" id="<portlet:namespace/>tukhoa"
							placeholder="" name="<portlet:namespace/>tukhoa" value="<%= usSearch %>" />
			  	</div>
			  	<div class="form-group">
			    <label class="control-label" for="exampleInputEmail1">Ngày thao tác từ</label>
			    <input type="text" class="form-control" id="startDate"
							placeholder="" name="<portlet:namespace/>tungay" value="<%=tungay %>" />
			  	</div>
			  	<div class="form-group">
			    <label class="control-label" for="exampleInputEmail1">Tỉnh/ thành phố</label>
						<select class="form-control" name="<portlet:namespace/>tinhThanhIdCd" 
						id="<portlet:namespace/>tinhThanhIdCd" onchange="ThayDoiTinhThanhCongDan(this);">
					      <option value="0">Chọn tỉnh thành</option>
					      <%if(listTinhThanhs!=null&&listTinhThanhs.size()>0){
								for(DanhMuc tinhThanh : listTinhThanhs){%>
									<aui:option value="<%=tinhThanh.getId() %>">
										<%=tinhThanh.getTen() %>
									</aui:option>
								<%}
							}%>
					    </select>
			  	</div>
			  	<div class="form-group">
			    <label class="control-label" for="exampleInputEmail1">Phường/ xã</label>
			   <select class="form-control" name="<portlet:namespace/>phuongXaIdCd" 
						id="<portlet:namespace/>phuongXaIdCd" >
							<option value="0">Chọn phường xã</option>
							
						</select>
			  	</div>
			</div>
			<div class="col-md-6">
			<div class="form-group">
			    <label class="control-label" for="exampleInputEmail1">Tên người dùng</label>
			    <input type="text" class="form-control" id="<portlet:namespace/>fullname"
							placeholder="" name="<portlet:namespace/>fullname" value="<%= fullname %>" />
			  	</div>
			  	<div class="form-group">
			    <label class="control-label" for="exampleInputEmail1">Ngày thao tác đến</label>
			    <input type="text" class="form-control" id="endDate"
							placeholder="" name="<portlet:namespace/>denngay" value="<%= denngay %>" />
			  	</div>
			  	<div class="form-group">
			    <label class="control-label" for="exampleInputEmail1">Quận/ huyện</label>
						<select class="form-control" name="<portlet:namespace/>quanHuyenIdCd" 
						id="<portlet:namespace/>quanHuyenIdCd" onChange="ThayDoiQuanHuyenCongDan(this);">
							<option value="0">Chọn quận huyện</option>
							
						</select>
			  	</div>
			  	<div class="form-group">
			    <label class="control-label" for="exampleInputEmail1">Bưu cục</label>
			    <input type="text" class="form-control" id="<portlet:namespace/>buucuc"
							placeholder="" name="<portlet:namespace/>buucuc" value="" />
			  	</div>
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
</div>
<div class="row">
	<div class="col-md-12">
	<div class="bg-trang">
   		<div class="row">
   		<div class="col-md-6">
   		<h4 class="tle" style="font-weight: 600 !important;">
			Nhật ký người dùng
		</h4>
   		</div>
   		<div class="col-md-6 text-right" style="padding-top: 12px;">
   		<button onclick="downloadCSV();" type="button" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-cloud-download"></span> Tải về
        </button>
   		</div>
   		</div>
         	
    </div>
	</div>
</div>

<div class="row">
	<div class="col-md-12">
	 
    
	<table class="table table-bordered">
	<thead>
		<tr>
			<th style="text-align: center;" class="text-center">STT</th>
			<th style="text-align: center;" class="text-center"><liferay-ui:message key="portlet.audit.table.username"/></th>
			<th style="text-align: center;" class="text-center">Tên người dùng</th>
			<th style="text-align: center;" class="text-center">Đơn vị công tác</th>
			<th style="text-align: center;" class="text-center">Chức danh</th>
			<th style="text-align: center;" class="text-center">Nội dung Thao tác</th>
			<th style="text-align: center;" class="text-center">Thời điểm thao tác</th>
			<!-- <th style="width: 25%;text-align: center;" class="text-center"><liferay-ui:message key="portlet.audit.table.additionalinfo"/></th> -->
		</tr>
	</thead>
	<tbody>
		<%
		if(listEvent != null && listEvent.size() > 0){
			int stt = searchContainer.getStart() + 1;
			for(AuditEvent auditEvent : listEvent){
			
		%>
		<tr>
		<td><%= stt ++ %></td>
			<td><%=auditEvent != null ? auditEvent.getUserName(): "" %></td>
			<td><%=auditEvent != null ? auditEvent.getMessage(): "" %></td>
			<td></td>
			<td></td>
			<td ><%=auditEvent != null ? auditEvent.getAdditionalInfo(): "" %></td>
			<td ><%=auditEvent != null ? DateUtil.parseDateToString(auditEvent.getCreateDate(), "dd/MM/yyyy HH:mm:ss"): "" %></td>
			<%-- <td><%=auditEvent != null ? auditEvent.getAdditionalInfo(): "" %></td> --%>
		</tr>
				<% }}%>
	</tbody>
</table>

	<c:if test="<%= searchContainer != null %>">     
		  <div id = "pagination">
		   	<br/>
		   	<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
		  </div>
 	</c:if>
	</div>
</div>
</div>
<liferay-portlet:resourceURL var="getQuanHuyenByTinhThanhCongDanURL" id="getQuanHuyenByTinhThanh" copyCurrentRenderParameters="<%=false %>">
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="getPhuongXaByQuanHuyenCongDanURL" id="getPhuongXaByQuanHuyen" copyCurrentRenderParameters="<%=false %>">
</liferay-portlet:resourceURL>
<portlet:actionURL name="downloadcsv" var="downloadcsvURL">
</portlet:actionURL>
<script type="text/javascript">
/* AUI().use('aui-datepicker', function(A) {
	new A.DatePicker({
		trigger : '#<portlet:namespace/>tungay',
		popover : {
		zIndex : 1
	},
	 mask: '%d/%m/%Y'
	});
});	
AUI().use('aui-datepicker', function(A) {
	new A.DatePicker({
		trigger : '#<portlet:namespace/>denngay',
		popover : {
		zIndex : 1
	},
	 mask: '%d/%m/%Y'
	});
});	 */
function downloadCSV(){
	var form = document.createElement('form')
	form.action = "<%= downloadcsvURL %>"
		form.method = "POST"
				var inputtendangnhapcsv = document.createElement('input')
				inputtendangnhapcsv.name="<portlet:namespace/>tendangnhapcsv"
				inputtendangnhapcsv.value = "<%=usSearch%>"
				form.appendChild(inputtendangnhapcsv)
				
				var inputfullname = document.createElement('input')
				inputfullname.name="<portlet:namespace/>fullnamecsv"
				inputfullname.value = "<%=fullname%>"
				form.appendChild(inputfullname)
				
				var inputtungay = document.createElement('input')
				inputtungay.name="<portlet:namespace/>tungaycsv"
				inputtungay.value = "<%=tungayin%>"
				form.appendChild(inputtungay)
				
				var inputdenngay = document.createElement('input')
				inputdenngay.name="<portlet:namespace/>denngaycsv"
				inputdenngay.value = "<%=denngayin%>"
				form.appendChild(inputdenngay)
				document.body.append(form);
	form.submit()
	document.body.removeChild(form);
}
function ThayDoiTinhThanhCongDan(myObj){
	var tinhThanhId = $(myObj).val();
	var data = {<portlet:namespace/>tinhThanhIdCd:tinhThanhId};
	cleanselect($('#<portlet:namespace/>quanHuyenIdCd'),'<option value=0>Chọn Quận Huyện</option>');
	cleanselect($('#<portlet:namespace/>phuongXaIdCd'),'<option value=0>Chọn Phường Xã</option>');
	//var datasend = JSON.stringify(data);
	fillDataToSelectWithAjaxJquery(data,'<%= getQuanHuyenByTinhThanhCongDanURL %>',$('#<portlet:namespace/>quanHuyenIdCd'),'<option value=0>Chọn Quận Huyện</option>');
	
}
function ThayDoiQuanHuyenCongDan(myObj){
	var quanHuyenId = $(myObj).val();
	var data = {<portlet:namespace/>quanHuyenIdCd:quanHuyenId};
	
	//var datasend = JSON.stringify(data);
	fillDataToSelectWithAjaxJquery(data,'<%= getPhuongXaByQuanHuyenCongDanURL %>',$('#<portlet:namespace/>phuongXaIdCd'),'<option value=0>Chọn Phường Xã</option>');
	
}
function filljsontoselectbox(json, selectobj,defaultoption){
	var jsonobj = JSON.parse(json); 
	selectobj.empty();
	selectobj.append(defaultoption);
	for(var i = 0; i < jsonobj.length; i ++){
		selectobj.append('<option class="" value="'+jsonobj[i].id+'"> '+jsonobj[i].key+'</option>');
	}
	
}
function cleanselect(selectobj,defaultoption){
	selectobj.empty();
	selectobj.append(defaultoption);
}
function fillDataToSelectWithAjaxJquery(data,urlajax,objfill,defaultoption){
	$.ajax({
	
	type:'POST',
	data:data,
	url:urlajax,
	beforeSend: function (xhr) {
      
    },
	success:function(result){
		//alert(result);
		//fill data to select box
		filljsontoselectbox(result,objfill,defaultoption);

	},
	error: function (request, status, error) {
		alert('không thể kết nối với server. Vui lòng liên hệ với quản trị viên');
    }
});
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