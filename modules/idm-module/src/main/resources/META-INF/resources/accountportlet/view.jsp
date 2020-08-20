<%@page import="dtt.vn.vnpost.service.AccountLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="dtt.vn.account.util.DateUtil"%>
<%@page import="dtt.vn.vnpost.model.Account"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="dtt.vn.account.util.PortletKeysUtil"%>
<%@page import="dtt.vn.account.search.AccountHelper"%>
<%@page import="dtt.vn.account.search.AccountDisplayTerms"%>
<%@page import="dtt.vn.account.search.AccountSearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="dtt.vn.account.business.Constantes"%>
<%@ include file="/accountportlet/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css">

<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/js/bootstrap-datetimepicker.min.js"></script>

<portlet:renderURL var="addURL">
	<portlet:param name="jspPage" value="/accountportlet/editAccount.jsp"/>
	<portlet:param name="redirect" value="<%=currentURL %>"/>
</portlet:renderURL>
<%
PortletURL portletURL = renderResponse.createActionURL();
int cur               = ParamUtil.getInteger(request, PortletKeysUtil.SearchContainer.CURRENT_PAGE, PortletKeysUtil.PAGE);
int delta             = ParamUtil.getInteger(request, PortletKeysUtil.SearchContainer.DELTA, PortletKeysUtil.DELTA);
String msgEmpty       = "Không có dữ liệu";
String timkiem        = ParamUtil.getString(request, "TenCaNhanToChuc","");
String keyword        = ParamUtil.getString(request, "TenCaNhanToChuc","");
int tinhtrang         = ParamUtil.getInteger(request, "TinhTrang",PortletKeysUtil.TrangThaiKeys.Tat_Ca);
int loaidoituong      = ParamUtil.getInteger(request, "LoaiDoiTuong",PortletKeysUtil.LoaiDoiTuongKeys.Tat_Ca);
String sogiayto       = ParamUtil.getString(request, "SoGiayTo", "");
String tungay         = ParamUtil.getString(request, "startDate", "");
String denngay        = ParamUtil.getString(request, "endDate", "");
String sodienthoai    = ParamUtil.getString(request, "SoDienThoai", "");
String tentaikhoan    = ParamUtil.getString(request, "TenTaiKhoan", "");
String canboxacminh   = ParamUtil.getString(request, "CanBoXacMinh", "");
int hinhthucdangky    = ParamUtil.getInteger(request, "HinhThucDangKy", -1);

portletURL.setParameter("TenCaNhanToChuc", keyword);
portletURL.setParameter("TenCaNhanToChuc", timkiem);
portletURL.setParameter("TinhTrang", String.valueOf(tinhtrang));
portletURL.setParameter("LoaiDoiTuong", String.valueOf(loaidoituong));
portletURL.setParameter("SoGiayTo", sogiayto);
portletURL.setParameter("startDate", tungay);
portletURL.setParameter("endDate", denngay);
portletURL.setParameter("SoDienThoai", sodienthoai);
portletURL.setParameter("TenTaiKhoan", tentaikhoan);
portletURL.setParameter("CanBoXacMinh", canboxacminh);
portletURL.setParameter("HinhThucDangKy", String.valueOf(hinhthucdangky));

SearchContainer searchContainer = new SearchContainer<Account>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, portletURL, null, msgEmpty);
String tungayin = DateUtil.formatDate(tungay+" 00:00:00", DateUtil.DATE_FORMAT_D_M_Y_H_M_S, DateUtil.DATE_FORMAT_D_M_Y_H_M_S_1);
String denngayin = DateUtil.formatDate(denngay+" 23:59:59", DateUtil.DATE_FORMAT_D_M_Y_H_M_S, DateUtil.DATE_FORMAT_D_M_Y_H_M_S_1);

/* System.out.println("tungay:"+tungay);
System.out.println("denngay:"+denngay); */
List<Account> resultsAccountRecords = AccountLocalServiceUtil.searchForDanhSach(timkiem, hinhthucdangky, sogiayto, tungayin, denngayin, sodienthoai,
		tentaikhoan, loaidoituong, canboxacminh, tinhtrang, searchContainer.getStart(), searchContainer.getEnd());

int totalAccountRecords = AccountLocalServiceUtil.countForDanhSach(keyword, hinhthucdangky, sogiayto, tungayin, denngayin, sodienthoai, tentaikhoan, loaidoituong, canboxacminh, tinhtrang);
searchContainer.setTotal(totalAccountRecords);
searchContainer.setResults( resultsAccountRecords);
%>
<style type="text/css">
body{
overflow-x : hidden;
}
</style>
<portlet:renderURL var="redirectURL">
	<portlet:param name="mvcPath" value="/accountportlet/view.jsp" />
</portlet:renderURL>
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/accountportlet/view.jsp" />
</liferay-portlet:renderURL>

<div class="container" style="background-color: white;">
	<div class="bg-trang">
		<div class="container">
			<h4 class="tle" style="font-weight: 600 !important;">Điều kiện truy vấn</h4>
		</div>
	</div>
	<div >
	<aui:form action="<%= searchURL %>" method="get" name="fm">
		<liferay-portlet:renderURLParams varImpl="searchURL" />
		<div class="row">
			<div class="col-md-12">
			<div class="form-group">
					<label class="control-label" for="email">Tên cá nhân/ tổ chức</label>
						<input type="text" class="form-control" id="<portlet:namespace/>TenCaNhanToChuc"
							placeholder="" name="<portlet:namespace/>TenCaNhanToChuc" value="<%= timkiem %>">
				</div>
			</div>
		</div>
		<div class="row">
			<i class="fa fa-search" aria-hidden="true"></i>
			<div class="col-md-6" style="cursor: pointer; color: blue; ">
				<h5 id="dieukientruyvan">Tìm kiếm nâng cao</h5>
			</div>
		</div>
		<div class="row" id="box-search">
			<div class="col-md-6">
				
				<div class="form-group">
					<label class="control-label" for="email">Số giấy tờ</label>
						<input type="text" class="form-control" id="<portlet:namespace/>SoGiayTo"
							placeholder="" name="<portlet:namespace/>SoGiayTo" value="<%=sogiayto%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="email">Số điện thoại</label>
						<input type="text" class="form-control" id="<portlet:namespace/>SoDienThoai"
							placeholder="" name="<portlet:namespace/>SoDienThoai" value="<%=sodienthoai%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd">Loại đối tượng</label>
						<select name="<portlet:namespace/>LoaiDoiTuong" class="form-control" id="sel1">
					        <option value="<%=PortletKeysUtil.LoaiDoiTuongKeys.Tat_Ca  %>">Tất cả</option>
					        <option value ="<%=PortletKeysUtil.LoaiDoiTuongKeys.Ca_Nhan  %>">Cá nhân</option>
					        <option value = "<%= PortletKeysUtil.LoaiDoiTuongKeys.To_Chuc %>">Tổ chức</option>
					      </select>
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.xacminh.trangthai" /></label>
						<select name="<portlet:namespace/>TinhTrang" class="form-control" id="sel1">
							<option value="<%= PortletKeysUtil.TrangThaiKeys.Tat_Ca %>">Tất cả</option>
					        <option value="<%= PortletKeysUtil.TrangThaiKeys.Cho_Xac_Minh %>">Chờ xác minh</option>
					        <option value="<%= PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh %>">Đang xác minh</option>
					        <option value="<%= PortletKeysUtil.TrangThaiKeys.Cho_Xy_Ly %>">Chờ xử lý</option>
					        <option value="<%= PortletKeysUtil.TrangThaiKeys.Cho_Phan_Cong %>">Chờ phân công</option>
					        <option value="<%= PortletKeysUtil.TrangThaiKeys.Cho_Phe_Duyet %>">Chờ phê duyệt</option>
					        <option value="<%= PortletKeysUtil.TrangThaiKeys.Cho_Tra_KQ_Khong_Hop_Le %>">Chờ trả kết quả không hợp lệ</option>
					        <option value="<%= PortletKeysUtil.TrangThaiKeys.Cho_Tra_Chung_Nhan_DD %>">Chờ trả chứng nhận định danh</option>
					        <option value="<%= PortletKeysUtil.TrangThaiKeys.Da_Tra_KQ_Khong_Hop_Le %>">Đã trả kết quả không hợp lệ</option>
					        <option value="<%= PortletKeysUtil.TrangThaiKeys.Da_Tra_Chung_Nhan_DD %>">Đã trả chứng nhận định danh</option>
					        <option value="<%= PortletKeysUtil.TrangThaiKeys.Cap_Chung_Nhan_Dinh_Danh %>">Cấp chứng nhận định danh</option>
					        <option value="<%= PortletKeysUtil.TrangThaiKeys.Tu_Choi_Duyet %>">Từ chối duyệt</option>
					      </select>
				</div>
			</div>
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd">Hình thức đăng ký</label>
						<select name="<portlet:namespace/>HinhThucDangKy" class="form-control" id="sel1">
					        <!-- <option value="">Trực tuyến</option> -->
					        <option value="">Trực tiếp</option>
					      </select>
				</div>
				<div class="form-group">
					<label class="control-label" for="email">Ngày đăng ký</label>
						<div class="form-group" style="display: grid; grid-template-columns: auto auto">
								<div class="">
									<input id="startDate" name="<portlet:namespace/>startDate" placeholder="Từ ngày" type="text" class="form-control" value="<%=tungay%>" />
								</div>
								<div class=""  style="padding-left: 5px">
									<input id="endDate" name="<portlet:namespace/>endDate" placeholder="Đến ngày" type="text" class="form-control" value="<%=denngay%>"/>
								</div>
						</div>
				</div>
				<div class="form-group">
					<label class="control-label" for="email">Tên tài khoản</label>
						<input type="text" class="form-control" id="<portlet:namespace/>TenTaiKhoan"
							placeholder="" name="<portlet:namespace/>TenTaiKhoan" value="<%=tentaikhoan%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="email">Cán bộ xác minh</label>
						<input type="text" class="form-control" id="<portlet:namespace/>CanBoXacMinh"
							placeholder="" name="<portlet:namespace/>CanBoXacMinh" value="<%=canboxacminh%>">
				</div>
				
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 text-right">
				<div class="form-group">
					<label class="control-label" for="pwd"></label>
					<div class="text-right" style="padding: 0px;">
						<aui:button type="submit" icon="icon-search" value="search" />
					</div>
				</div>
			</div>
		</div>
	</aui:form>
	</div>
	<div class="bg-trang">
		<div class="container">
			<h4 class="tle" style="font-weight: 600 !important;">Danh sách các yêu cầu đăng ký</h4>
		</div>
	</div>
<div class="row">
	<div class="col-md-12">
		<div class="">
			   <div class="container" id="dieukientruyvan">
			   		<h5 class="">
			   			<i>Tổng số bản ghi: <%=totalAccountRecords %></i>
			   		</h5>
			   </div>
		</div>
	<table class="table table-bordered">
	  <thead>
	    <tr>
	      <th scope="col" style="text-align: center;" >STT</th>
	      <th style="text-align: center;" scope="col">Tên Tài khoản</th>
	      <th scope="col" style="text-align: center;" >Tên cá nhân/ tổ chức</th>
	      <th style="text-align: center;" scope="col">Loại ĐT</th>
	      <th scope="col" style="text-align: center;" >Email</th>
	      <th scope="col" style="text-align: center;" >Số giấy tờ</th>
	      <th scope="col" style="text-align: center;" >Điện thoại</th>
	      <th scope="col" style="text-align: center">Ngày đăng ký</th>
	      <th scope="col" style="text-align: center;" ><liferay-ui:message key="portlet.xacminh.trangthai" /></th>
	      <th scope="col" style="text-align: center;" >Cấp độ</th>
	      <th scope="col" style="text-align: center;" >Hành động</th>
	    </tr>
	  </thead>
	  <tbody>
	  <%
	  int stt = searchContainer.getStart()+1;
	  for(Account ac : resultsAccountRecords){
		  int status = ac.getAccountStatus();
		  String textStatus ="";
		 switch(status){
		 case 0:
			 textStatus ="Chờ xử lý";
			 break;
		 case 1:
			 textStatus ="Chờ phân công";
			 break;
		 case 2:
			 textStatus ="Chờ xác minh";
			 break;
		 case 3:
			 textStatus ="Đang xác minh";
			 break;
		 case 4:
			 textStatus ="Chờ phê duyệt";
			 break;
		 case 5:
			 textStatus ="Chờ trả kết quả không hợp lệ";
			 break;
		 case 6:
			 textStatus ="Chờ trả chứng nhận định danh";
			 break;
		 case 7:
			 textStatus ="Đã trả kết quả không hợp lệ";
			 break;
		 case 8:
			 textStatus ="Đã trả chứng nhận định danh";
			 break;
		 case 9:
			 textStatus ="Cấp chứng nhận định danh";
			 break;
		 case 10:
			 textStatus ="Từ chối duyệt";
			 break;
		 default:
			 textStatus ="Chưa xác định";
		 }
		  %>
		    <portlet:renderURL var="editurl">
				<portlet:param name="jspPage" value="/accountportlet/chitiet.jsp"/>
				<portlet:param name="accountIdsend" value="<%=String.valueOf(ac.getAccountId())%>" /> 
			</portlet:renderURL>
		  <tr>
		  	<td style="padding-top: 23px;"><%= stt++ %></td>
		  	<td style="padding-top: 23px;"><%= ac.getAccountName() %></td>
		  	<td style="padding-top: 23px;"><%= ac.getFullName() %></td>
		  	<td style="padding-top: 23px;"><% 
			    if(ac.getAccountType() == PortletKeysUtil.LoaiDoiTuongKeys.Ca_Nhan){
			    %>
			    Cá nhân
			    <%
			    }else if(ac.getAccountType() == PortletKeysUtil.LoaiDoiTuongKeys.To_Chuc){
			    %>
			    Tổ chức
			    <%
			    }
			    %></td>
		  	<td style="padding-top: 23px;"><%= ac.getEmail() %></td>
		  	<td style="padding-top: 23px;"><%= ac.getPersonalId()  %></td>
		  	<td style="padding-top: 23px;"><%= ac.getTelNo() %></td>
		  	<td style="padding-top: 23px;"><p style="text-align: center;" id="ngayDangKy"><%= DateUtil.convertDateToString(ac.getCreateDate(),"dd/MM/yyyy") %></p></td>
		  	<td style="padding-top: 23px;"><%=textStatus %></td>
		  	<td style="padding-top: 23px;"><%= ac.getIpLevel() %></td>
		  	<td style="padding-top: 23px; text-align: center;">
		    	<a title="Chi tiết" href="<%=editurl%>"><span class="glyphicon glyphicon-edit" style="color: #337ab7 "></span></a>
		        <a title="Mã QR" onclick="openQrcode('<%=ac.getAccountId()%>;<%= ac.getAccountName() %>');" style="color:#075d9a;cursor: pointer; "><span class="glyphicon glyphicon-qrcode"></span></a>
		   	</td>
		  </tr>
		  <%
	  }
	  %>
	  </tbody>
	  </table>
  </div>
 </div>
  <c:if test="<%= searchContainer != null %>">
	<div id = "pagination">
		<br/>
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
</c:if>
</div>
<portlet:resourceURL var="viewqrcodeUrl" id="viewqrcode" >
</portlet:resourceURL>
<div class="row">
<div class="col-md-12">

<!-- Modal -->
<div class="modal fade" style="display: none;" id="viewimage" tabindex="-1" role="dialog" aria-labelledby="viewimagemodal" aria-hidden="true">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="qrmodaltitle"></h5>
      </div>
      <div class="modal-body">
        <img id="imageshow" class="img-responsive" src="" /> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="closePopupAttributeimage();">Đóng</button>
      </div>
    </div>
  </div>
</div>
</div>
</div>
<portlet:actionURL name="reOpen" var="reOpenURL" windowState="normal"></portlet:actionURL>

<aui:form name="reOpenFm" action="<%=reOpenURL %>" method="post">
	<input type="hidden" name="<portlet:namespace/>accountId" />
	<input type="hidden" name="<portlet:namespace/>userId" />
	<input type="hidden" name="<portlet:namespace/>comment" />
</aui:form>	
<script type="text/javascript">

//QR code 

function closePopupAttributeimage() {
	$('#viewimage').removeClass('show').addClass('hide');
}

function openQrcode(str){
	$.ajax({
		type:'POST',
		data:{"<portlet:namespace/>dataqr":str},
		url:'<%=viewqrcodeUrl%>',
		beforeSend: function (xhr) {
	      
	    },
		success:function(result){
			console.log(result);
			$('#qrmodaltitle').html("<b>" + str.split(';')[1]+"</b>");
			$("#imageshow").attr('src', 'data:image/png;base64,'+result);
			$('#viewimage').removeClass('fade').removeClass('hide').addClass('show');
		},
		error: function (request, status, error) {
			alert('không thể kết nối với server. Vui lòng liên hệ với quản trị viên');
	    }
	});
}


$(document).ready(function(){
	/* alert('12121212'); */
	$('#box-search').hide();
});
$('#dieukientruyvan').click(function(){
	$( "#box-search" ).toggle(1000);
});

// check Date Range

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