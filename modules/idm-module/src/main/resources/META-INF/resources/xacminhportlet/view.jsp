<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.net.URL"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="dtt.vn.account.util.PortletKeysUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="dtt.vn.vnpost.service.AccountLocalServiceUtil"%>
<%@page import="dtt.vn.account.search.AccountHelper"%>
<%@page import="dtt.vn.vnpost.model.Account"%>
<%@page import="java.util.List"%>
<%@page import="dtt.vn.account.search.AccountRecordSearch"%>
<%@page import="dtt.vn.account.business.Constantes"%>
<%@page import="dtt.vn.account.search.AccountRecordSearchTerms"%>
<%@page import="dtt.vn.vnpost.service.DanhMucLocalServiceUtil"%>
<%@page import="dtt.vn.account.util.DateUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/xacminhportlet/init.jsp" %>


<style type="text/css">
/* #search-form input {
height: 28px;
}
#search-form select {
height: 28px;
padding: 0px;
} */
body{
overflow-x : hidden;
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

<c:if test='<%= ParamUtil.getBoolean(request, "requestSuccess") %>'>
	<script type="text/javascript">	
		Liferay.Util.getOpener().reload();
	</script>
</c:if>
<portlet:renderURL var="redirectURL">
	<portlet:param name="mvcPath" value="/xacminhportlet/view.jsp" />
</portlet:renderURL>
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/xacminhportlet/view.jsp" />
</liferay-portlet:renderURL>
<%
URL url = new URL( PortalUtil.getCurrentCompleteURL(request) );
String mainURL = url.getFile();
PortletURL portletURL = renderResponse.createActionURL();
int cur               = ParamUtil.getInteger(request, PortletKeysUtil.SearchContainer.CURRENT_PAGE, PortletKeysUtil.PAGE);
int delta             = ParamUtil.getInteger(request, PortletKeysUtil.SearchContainer.DELTA, PortletKeysUtil.DELTA);
String msgEmpty       = "Không có dữ liệu";
String timkiem        = ParamUtil.getString(request, "TenCaNhanToChuc","");
String keyword        = ParamUtil.getString(request, "TenCaNhanToChuc","");
int tinhtrang         = ParamUtil.getInteger(request, "TinhTrang",PortletKeysUtil.TrangThaiKeys.Cho_Xac_Minh);
int loaidoituong      = ParamUtil.getInteger(request, "LoaiDoiTuong",PortletKeysUtil.LoaiDoiTuongKeys.Tat_Ca);
String sogiayto       = ParamUtil.getString(request, "SoGiayTo", "");
String tungay         = ParamUtil.getString(request, "startDate", "");
String denngay        = ParamUtil.getString(request, "endDate", "");
String sodienthoai    = ParamUtil.getString(request, "SoDienThoai", "");
String tentaikhoan    = ParamUtil.getString(request, "TenTaiKhoan", "");
String canboxacminh   = ParamUtil.getString(request, "CanBoXacMinh", "");
int hinhthucdangky    = ParamUtil.getInteger(request, "HinhThucDangKy", -1);
String email          = ParamUtil.getString(request, "Email", "");

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
portletURL.setParameter("Email", email);

SearchContainer searchContainer = new SearchContainer<Account>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, portletURL, null, msgEmpty);
String tungayin = DateUtil.formatDate(tungay+" 00:00:00", DateUtil.DATE_FORMAT_D_M_Y_H_M_S, DateUtil.DATE_FORMAT_D_M_Y_H_M_S_1);
String denngayin = DateUtil.formatDate(denngay+" 23:59:59", DateUtil.DATE_FORMAT_D_M_Y_H_M_S, DateUtil.DATE_FORMAT_D_M_Y_H_M_S_1);
//List<Account> resultsAccountRecords = AccountLocalServiceUtil.searchForDanhSach(timkiem, hinhthucdangky, sogiayto, tungay, denngay, sodienthoai,
		//tentaikhoan, loaidoituong, canboxacminh, tinhtrang, searchContainer.getStart(), searchContainer.getEnd());
//List<Account> resultsAccountRecords = AccountLocalServiceUtil.searchForXacMinh(keyword, tinhtrang, email, sogiayto, tungay,
		//denngay, sodienthoai, tentaikhoan, loaidoituong, hinhthucdangky, searchContainer.getStart(), searchContainer.getEnd());
List <Account> resultsAccountRecords = AccountLocalServiceUtil.searchForXacMinh(keyword, tinhtrang, email, sogiayto, tungayin, denngayin, sodienthoai, tentaikhoan, loaidoituong, hinhthucdangky, searchContainer.getStart(), searchContainer.getEnd());
//int totalAccountRecords = AccountLocalServiceUtil.countForDanhSach(keyword, hinhthucdangky, sogiayto, tungay, denngay, sodienthoai, tentaikhoan, loaidoituong, canboxacminh, tinhtrang);

int totalAccountRecords = AccountLocalServiceUtil.countForXacMinh(keyword, tinhtrang, email, sogiayto, tungayin, denngayin, sodienthoai, tentaikhoan, loaidoituong, hinhthucdangky);
searchContainer.setTotal(totalAccountRecords);
searchContainer.setResults( resultsAccountRecords);
%>

<div class="container" style="background-color: white;">
<%
if(request.getAttribute("isSucess")!= null){
	boolean isSucess = Boolean.parseBoolean(request.getAttribute("isSucess").toString());
	if(isSucess){

		%>
		<div class="alert alert-success" role="alert">
		 <%= request.getAttribute("message") %>
		</div>
		<%
	}else{
		%>
		<div class="alert alert-danger" role="alert">
		  <liferay-ui:message key="dtt.vn.xacminh.portlet.error"/>
		</div>
		<%
	}
}

%>
    <div class="bg-trang">
        <h4 class="tle" style="font-weight: 600 !important;">
			<liferay-ui:message key="portlet.xacminh.danhsach.dieukientruyvan" />
		</h4>
    </div>
	<aui:form action="<%= searchURL %>" method="get" name="fm">
		<liferay-portlet:renderURLParams varImpl="searchURL" />
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
						<label class="control-label" for="email">Tên cá nhân/ tổ chức</label>
							<input type="text" class="form-control" id="<portlet:namespace/>TenCaNhanToChuc"
								placeholder="" name="<portlet:namespace/>TenCaNhanToChuc" value="<%= timkiem %>">
				</div>
				
				<div class="form-group">
						<label class="control-label" for="pwd">Loại đối tượng</label>
							<select name="<portlet:namespace/>LoaiDoiTuong" class="form-control" id="sel1">
								<option value="<%= PortletKeysUtil.LoaiDoiTuongKeys.Tat_Ca %>" <%if(loaidoituong == PortletKeysUtil.LoaiDoiTuongKeys.Tat_Ca){%>selected="selected"<%}%>>
								        <liferay-ui:message key="portlet.xacminh.danhsach.tatca" /></option>
							    <option value="<%= PortletKeysUtil.LoaiDoiTuongKeys.Ca_Nhan %>" <%if(loaidoituong == PortletKeysUtil.LoaiDoiTuongKeys.Ca_Nhan){%>selected="selected"<%}%>>
								        <liferay-ui:message key="portlet.xacminh.danhsach.canhan" /></option>
							    <option value="<%= PortletKeysUtil.LoaiDoiTuongKeys.To_Chuc %>" <%if(loaidoituong == PortletKeysUtil.LoaiDoiTuongKeys.To_Chuc){%>selected="selected"<%}%>>
								        <liferay-ui:message key="portlet.xacminh.danhsach.tochuc" /></option>
						      </select>
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.xacminh.trangthai" /></label>
						<select name="<portlet:namespace/>TinhTrang" class="form-control" id="sel1">
							<option value="<%= PortletKeysUtil.TrangThaiKeys.Cho_Xac_Minh %>" <%if(tinhtrang == PortletKeysUtil.TrangThaiKeys.Cho_Xac_Minh){%>selected="selected"<%}%>>
							        <liferay-ui:message key="portlet.xacminh.tinhtrang.choxacminh" /></option>
						    <option value="<%= PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh %>" <%if(tinhtrang == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh){%>selected="selected"<%}%>>
							        <liferay-ui:message key="portlet.xacminh.tinhtrang.dangxacminh" /></option>
						    <option value="<%= PortletKeysUtil.TrangThaiKeys.Tat_Ca %>" <%if(tinhtrang == PortletKeysUtil.TrangThaiKeys.Tat_Ca){%>selected="selected"<%}%>>
							        <liferay-ui:message key="portlet.xacminh.danhsach.tatca" /></option>
						</select>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label" for="email">Tên tài khoản</label>
						<input type="text" class="form-control" id="<portlet:namespace/>TenTaiKhoan"
							placeholder="" name="<portlet:namespace/>TenTaiKhoan" value="<%=tentaikhoan%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="email">Số giấy tờ</label>
						<input type="text" class="form-control" id="<portlet:namespace/>SoGiayTo"
							placeholder="" name="<portlet:namespace/>SoGiayTo" value="<%=sogiayto%>">
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
					<label class="control-label" for="email">Số điện thoại</label>
						<input type="text" class="form-control" id="<portlet:namespace/>SoDienThoai"
							placeholder="" name="<portlet:namespace/>SoDienThoai" value="<%=sodienthoai%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd">Hình thức đăng ký</label>
						<select name="<portlet:namespace/>HinhThucDangKy" class="form-control" id="sel1">
					        <!-- <option value="">Trực tuyến</option> -->
					        <option value="">Trực tiếp</option>
					      </select>
				</div>
			</div>
			<div class="col-md-6" style="background-color: white;">
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
					<label class="control-label" for="email">Email</label>
						<input type="text" class="form-control" id="<portlet:namespace/>Email"
							placeholder="" name="<portlet:namespace/>Email" value="<%=email%>">
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


<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/xacminhportlet/view.jsp" />
</liferay-portlet:renderURL>


<portlet:actionURL name="phanCongXuLy" var="phanCongXuLyURL" windowState="normal"></portlet:actionURL>

<aui:form name="phanCongFm" action="<%=phanCongXuLyURL %>" method="post">
	<input type="hidden" name="<portlet:namespace/>accountIdpc" />
	<input type="hidden" name="<portlet:namespace/>userIdpc" />
</aui:form>	

<div class="container" style="background-color: white;">
	<div class="bg-trang">
		<div class="container">
			<h4 class="tle" style="font-weight: 600 !important;"><liferay-ui:message key="portlet.xacminh.danhsach.danhsachyeucau" /></h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="">
			   <div class="container" id="dieukientruyvan">
			   		<h5 class="">
			   			<i><liferay-ui:message key="portlet.xacminh.danhsach.tongsobanghi" />: <%=totalAccountRecords %></i>
			   		</h5>
			   </div>
			</div>
			<table class="table table-bordered">
			  <thead>
			    <tr style="text-align: center;">
			      <th style="text-align: center;"  scope="col"><liferay-ui:message key="portlet.xacminh.chitiet.tochuc.stt" /></th>
			      <th style="text-align: center;" scope="col"><liferay-ui:message key="portlet.xacminh.danhsach.loaidoituong" /></th>
			      <th style="text-align: center;" scope="col"><liferay-ui:message key="portlet.xacminh.danhsach.tentaikhoan" /></th>
			      <th style="text-align: center;" scope="col"><liferay-ui:message key="portlet.xacminh.danhsach.tencanhantochuc" /></th>
			      <th style="text-align: center;" scope="col"><liferay-ui:message key="portlet.xacminh.danhsach.sogiayto" /></th>
			      <th style="text-align: center;" scope="col"><liferay-ui:message key="portlet.xacminh.danhsach.capdohientai" /></th>
			      <th style="text-align: center;" scope="col"><liferay-ui:message key="portlet.xacminh.danhsach.diachixacminh" /></th>
			      <th style="text-align: center;" scope="col"><liferay-ui:message key="portlet.xacminh.trangthai" /></th>
			      <th style="text-align: center;" scope="col"><liferay-ui:message key="portlet.xacminh.danhsach.hanhdong" /></th>
			    </tr>
			  </thead>
			  <tbody>
			    <%
			    int stt = searchContainer.getStart()+1;
			    for(Account pt : resultsAccountRecords){
			    	
			    	%>
			    	<portlet:renderURL var="editurl">
						<portlet:param name="jspPage" value="/xacminhportlet/xac_minh_new.jsp"/>
						 <portlet:param name="accountIdsend" value="<%=String.valueOf(pt.getAccountId())%>" /> 
						<portlet:param name="backurl" value="<%=mainURL%>" /> 
				    </portlet:renderURL>
			    	<tr>
			    		<td><%= stt ++ %></td>
			    		<td><% 
			    		if(pt.getAccountType() == PortletKeysUtil.LoaiDoiTuongKeys.Ca_Nhan){
			    			%>
			    			<liferay-ui:message key='portlet.quanlytaikhoan.canhan'/>
			    			<%
			    		}else if(pt.getAccountType() == PortletKeysUtil.LoaiDoiTuongKeys.To_Chuc){
			    			%>
			    			<liferay-ui:message key='portlet.quanlytaikhoan.tochuc'/>
			    			<%
			    		}
			    		
			    		%></td>
			    		<td><%= pt.getAccountName() %></td>
			    		<td><%= pt.getFullName() %></td>
			    		<td><%= pt.getPersonalId() %></td>
			    		<td><%= pt.getIpLevel() %></td>
			    		<%
			    		String wardXM = "";
			    		String districtXM = "";
			    		String cityXM = "";
			    		try{
			    			wardXM =DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(pt.getWardCode()))==null?"": DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(pt.getWardCode()))
									.getTen();
			    			districtXM =DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(pt.getDistrictCode()))==null?"": DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(pt.getDistrictCode())).
									getTen();
			    			cityXM = DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(pt.getCityCode()))==null?"": DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(pt.getCityCode())).getTen();
			    		}catch(Exception e){
			    			
			    		}
			    		
			    		String diaChiChiTiet =pt.getAddress()+"-"+wardXM+"-"+districtXM+"-"+ cityXM;
			    		%>
			    		<td><%=diaChiChiTiet %></td>
			    		<td>
			    		<%
			    		if(pt.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cho_Xac_Minh){
			    			%>
			    			<liferay-ui:message key='portlet.quanlytaikhoan.choxacminh'/>
			    			<%
			    		}else if(pt.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh){
			    			%>
			    			<liferay-ui:message key='portlet.quanlytaikhoan.dangxacminh'/>
			    			<%
			    		}
			    		%>
			    		</td>
			    		<td style="text-align: center;"><a title="Chi tiết" href="<%=editurl%>"><span class="glyphicon glyphicon-edit"></span></a>
			           <a title="Mã QR" onclick="openQrcode('<%=pt.getAccountId()%>;<%= pt.getAccountName() %>');" style="color:#075d9a;cursor: pointer; "><span class="glyphicon glyphicon-qrcode"></span></a>
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
  <div class="modal-dialog modal-sm" role="document" style="position: relative !important;">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="qrmodaltitle"></h5>
      </div>
      <div class="modal-body">
        <img id="imageshow" class="img-responsive" src="" /> 
      </div>
      <div class="modal-footer" style="text-align: right;">
        <button type="button" class="btn btn-primary" onclick="closePopupAttributeimage();"><liferay-ui:message key="portlet.xacminh.button.dong" /></button>
      </div>
    </div>
  </div>
</div>
</div>

</div>

<script type="text/javascript">
$(document).ready(function(){
});
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
			$('#qrmodaltitle').html("<b>" + str.split(';')[1]+"</b>");
			$("#imageshow").attr('src', 'data:image/png;base64,'+result);
			$('#viewimage').removeClass('fade').removeClass('hide').addClass('show');
		},
		error: function (request, status, error) {
			alert('<liferay-ui:message key="portlet.xacminh.thongbaoqrcode" />');
	    }
	});
	
}
function reload() {
	location.href= "<%= redirectURL %>";	
}

$(document).ready(function(){
	/* alert('12121212'); */
	$('#box-search').hide();
});
$('#dieukientruyvan').click(function(){
	$( "#box-search" ).toggle(1000);
});


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