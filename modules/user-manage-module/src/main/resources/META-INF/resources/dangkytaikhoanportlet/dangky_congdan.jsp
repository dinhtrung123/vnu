<%@page import="dtt.vn.user.utils.DangKyQuyTrinhUtil"%>
<%@page import="dtt.vn.user.keycloak.connect.KeycloakUtils"%>
<%@page import="dtt.vn.user.keys.DangKyTaiKhoanKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="dtt.vn.user.keys.DanhMucKeys"%>
<%@page import="org.oep.danhmuc.service.DanhMucLocalServiceUtil"%>
<%@page import="org.oep.danhmuc.model.DanhMuc"%>
<%@page import="java.util.List"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Date"%>
<%@page import="dtt.vn.user.common.utils.DateUtil" %>
<%@page import="dtt.vn.user.keys.Constantes"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/dangkytaikhoanportlet/init.jsp" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>


<portlet:resourceURL id="captcha" var="captchaResourceURL"/>
<portlet:defineObjects />

<portlet:actionURL name="first" var="first"/>
<%
String backURL = ParamUtil.get(request, "backURL", ""); 
String mainURL = (String)request.getAttribute("mainURL");
if(mainURL==null){
URL url = new URL( PortalUtil.getCurrentCompleteURL(request) );
 mainURL = url.getFile();
}
String ngaySinh="";
String ngayCapCMND="";
ngayCapCMND = DateUtil.parseDateToString(new Date(), DateUtil.DATE_FORMAT_D_M_Y);
ngaySinh = DateUtil.parseDateToString(new Date(), DateUtil.DATE_FORMAT_D_M_Y);
List<DanhMuc> listGioiTinhs = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.GIOITINH.MA, 1, true);
List<DanhMuc> listTinhThanhs = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.DONVIHANHCHINH.MA, 1, true);
List<DanhMuc> listHinhThucKH = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.HINHTHUCKICHHOATTAIKHOAN.MA, 1, true);
List<DanhMuc> listXacThucDaYeuTo = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.HINHTHUCXACTHUCDAYEUTO.MA, 1, true);
List<DanhMuc> listQuanHuyens = new ArrayList<DanhMuc>();
List<DanhMuc> listPhuongXas = new ArrayList<DanhMuc>();

long tinhId = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN);
long huyenId =ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN);
long xaId = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN);
long hinhThucId = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.hinhThucKichHoat);
if(tinhId !=0){
 	listQuanHuyens = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(tinhId, true);
 }
if(huyenId != 0){
 	listPhuongXas = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(huyenId, true);
 }

String maKichHoatDefault = DangKyQuyTrinhUtil.getMaKichHoat();
String maKichHoat = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.MA_KICHHOAT,maKichHoatDefault);
%>

<style type="text/css">
body{
overflow-x : hidden;
}
</style>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/css/bootstrap-select.min.css">

<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/js/bootstrap-datetimepicker.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/bootstrap-select.min.js"></script>
<!-- (Optional) Latest compiled and minified JavaScript translation files -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/i18n/defaults-*.min.js"></script>


<portlet:actionURL var="luuLaiDangKyCongDanURL" name="luuLaiDangKyCongDan">
<portlet:param name="mainURL" value="<%=mainURL %>"></portlet:param>
</portlet:actionURL>

<portlet:actionURL var="kichHoatCongDanURL" name="kichHoatCongDan" >
	<portlet:param name="javax.portlet.action" value="kichHoatCongDan"/>	
	<portlet:param name="maKichHoatMD5" value="<%=DangKyQuyTrinhUtil.getMd5Hash(maKichHoat) %>"/>	
</portlet:actionURL>

<portlet:resourceURL var="captchaURL" />

<form action="${first}" method="POST">
<div class="oep=container" >
<%
if(request.getAttribute("isSucess")!= null){
	boolean isSucess = Boolean.parseBoolean(request.getAttribute("isSucess").toString());
	if(isSucess){
		%>
		<div class="alert alert-success" role="alert">
		 <liferay-ui:message key="dtt.vn.user.dangky.success"/>
		</div>
		<%
	}else{
		%>
		<div class="alert alert-danger" role="alert">
		 <liferay-ui:message key="dtt.vn.user.dangky.error"/>
		</div>
		<%
	}
}

%>


	<aui:form name="fmt" method="post" action="<%=luuLaiDangKyCongDanURL.toString() %>" enctype="multipart/form-data">
	   <div class="box">
	   <aui:input name="<%=DangKyTaiKhoanKeys.DangKyCongDan.KICHHOAT_URL %>" id="<%=DangKyTaiKhoanKeys.DangKyCongDan.KICHHOAT_URL %>" type="hidden" value="<%=kichHoatCongDanURL %>"/>
 		<aui:input name="<%=DangKyTaiKhoanKeys.Base.COMPANY_ID %>" id="<%=DangKyTaiKhoanKeys.Base.COMPANY_ID %>" type="hidden" value="<%=String.valueOf(themeDisplay.getCompanyId()) %>"/>
 		<aui:input name="<%=DangKyTaiKhoanKeys.DangKyCongDan.MA_KICHHOAT %>" id="<%=DangKyTaiKhoanKeys.DangKyCongDan.MA_KICHHOAT %>" type="hidden" value="<%=maKichHoat %>"/>
		<div class="tle1">
						<label class="oep-label-bold" style="font-size: 16px;" id="thongTinToChucLbl"><liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.thongtintaikhoan"/></label>
					</div>
				<div class="row">
					<div class="col-lg-6">			
						<div class="form-group">
							<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.tentaikhoan"/><label class="oep-label-red">(*)</label>
								<aui:input type="text"  maxlength = "<%=DangKyTaiKhoanKeys.DangKyCongDan.USER_NAME_MAXLENGTH %>" 
								label = "" title="" id = "<%=DangKyTaiKhoanKeys.DangKyCongDan.USER_NAME %>" name = "<%=DangKyTaiKhoanKeys.DangKyCongDan.USER_NAME %>"/>
						</div>
					</div>
					<div class="col-lg-6">			
						<div class="form-group">
							<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.matkhau"/><label class="oep-label-red">(*)</label>
							<aui:input type="password"  
								label = "" title="" id = "<%=DangKyTaiKhoanKeys.DangKyCongDan.MAT_KHAU %>" name = "<%=DangKyTaiKhoanKeys.DangKyCongDan.MAT_KHAU %>"/>
						</div>
						<div class="form-group">
							<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.matkhauconfirm"/><label class="oep-label-red">(*)</label>
							<aui:input type="password" 
							label = "" title="" id = "<%=DangKyTaiKhoanKeys.DangKyCongDan.MAT_KHAU_CONFIRM %>" name = "<%=DangKyTaiKhoanKeys.DangKyCongDan.MAT_KHAU_CONFIRM %>"/>
						</div>
					</div>
				</div>
		</div>
	<div class="box">
				<div class="tle1">
					<label class="oep-label-bold" style="font-size: 16px;" id="thongTinCongDanLbl"><liferay-ui:message key="dtt.vn.user.dangky.congdan.label.thongtincanhan"/></label>
				</div>
		<div class="row">
			<div class="col-lg-6">			
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.hoten"/><label class="oep-label-red">(*)</label>
					<aui:input type="text"  maxlength = "<%=DangKyTaiKhoanKeys.DangKyCongDan.HO_TEN_MAX_LENGTH %>" 
						label = "" title="" id = "<%=DangKyTaiKhoanKeys.DangKyCongDan.HO_TEN %>" name = "<%=DangKyTaiKhoanKeys.DangKyCongDan.HO_TEN %>"/>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.email"/><label class="oep-label-red">(*)</label>
					<aui:input title="" type="text" label = "" id = "<%=DangKyTaiKhoanKeys.DangKyCongDan.EMAIL %>" maxlength = "<%=DangKyTaiKhoanKeys.DangKyCongDan.EMAIL_MAX_LENGTH %>"
						name = "<%=DangKyTaiKhoanKeys.DangKyCongDan.EMAIL %>" />
				 </div>
			 </div>
			 <div class="col-lg-6" style="margin-top:-12px;">
				<div class="form-group">
				<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.gioitinh"/><label class="oep-label-red">(*)</label>
				<aui:select title="" style="width:100% !important"  label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.GIOI_TINH %>" 
					id="<%=DangKyTaiKhoanKeys.DangKyCongDan.GIOI_TINH %>">
						<aui:option><liferay-ui:message key="dtt.vn.user.dangky.congdan.select.chongioitinh"/></aui:option>
						<%if(listGioiTinhs!=null&&listGioiTinhs.size()>0){
							for(DanhMuc gioiTinh : listGioiTinhs){%>
								<aui:option value="<%=gioiTinh.getId() %>">
									<%=gioiTinh.getTen() %>
								</aui:option>
							<%}
						}%>
					</aui:select>
				</div>
			</div>
			<div class="col-lg-6" style="margin-top:-12px;">
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.cmnd.cmt"/><label class="oep-label-red">(*)</label>
					<aui:input type="text"  maxlength = "<%=DangKyTaiKhoanKeys.DangKyCongDan.SOCMND_MAX_LENGTH %>" 
						label = "" title="" id = "<%=DangKyTaiKhoanKeys.DangKyCongDan.SO_CMND %>" name = "<%=DangKyTaiKhoanKeys.DangKyCongDan.SO_CMND %>"/>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.ngaysinh"/><label class="oep-label-red">(*)</label>
					<aui:input title="" type="text" label = "" id = "<%=DangKyTaiKhoanKeys.DangKyCongDan.NGAY_SINH %>" 
						name = "<%=DangKyTaiKhoanKeys.DangKyCongDan.NGAY_SINH %>" value="<%=ngaySinh %>"/>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="form-group">
				<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.dienthoaididong"/><label class="oep-label-red">(*)</label>
				<aui:input title="" type="text"  maxlength = "<%=DangKyTaiKhoanKeys.DangKyCongDan.DIEN_THOAI_MAX_LENGTH %>" required="true"
					label = "" id = "<%=DangKyTaiKhoanKeys.DangKyCongDan.DIEN_THOAI %>" name = "<%=DangKyTaiKhoanKeys.DangKyCongDan.DIEN_THOAI %>"/>
				</div>
			</div>
		</div>
			<p style="margin-top:15px">
					<strong><liferay-ui:message key="dtt.vn.user.dangky.congdan.label.thongtindiachi"/></strong>
			</p>
		<div class="row">
			<div class="col-lg-6">
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.tinh"/><label class="oep-label-red">(*)</label>
					<aui:select cssClass="selectpicker" data-dropup-auto="false" data-live-search="true" title=""  label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN %>" 
						id="<%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN %>" onchange="ThayDoiTinhThanhCongDan(this);" data-width="100%">
							<aui:option value="0"><liferay-ui:message key="dtt.vn.user.dangky.congdan.select.chontinhthanh"/></aui:option>
							<%if(listTinhThanhs!=null&&listTinhThanhs.size()>0){
								for(DanhMuc tinhThanh : listTinhThanhs){%>
									<aui:option value="<%=tinhThanh.getId() %>">
										<%=tinhThanh.getTen() %>
									</aui:option>
								<%}
							}%>
					</aui:select>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.quanhuyen"/><label class="oep-label-red">(*)</label>
					<aui:select data-width="100%" cssClass="selectpicker" data-dropup-auto="false" data-live-search="true" title="" style="width:100% !important" label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN %>" 
						id="<%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN %>" onChange="ThayDoiQuanHuyenCongDan(this);">
							<aui:option value="0"><liferay-ui:message key="dtt.vn.user.dangky.congdan.select.chonquanhuyen"/></aui:option>
							<%if(listQuanHuyens!=null&&listQuanHuyens.size()>0){
								for(DanhMuc quanHuyen : listQuanHuyens){%>
									<aui:option value="<%=quanHuyen.getId() %>">
										<%=quanHuyen.getTen() %>
									</aui:option>
								<%}
							}%>
						</aui:select>
					</div>		
			</div>
			<div class="col-lg-6">
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.phuongxa"/><label class="oep-label-red">(*)</label>
					<aui:select data-width="100%" cssClass="selectpicker" data-dropup-auto="false" data-live-search="true" title=""  label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN %>" 
						id="<%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN %>">
							<aui:option value="0"><liferay-ui:message key="dtt.vn.user.dangky.congdan.select.chonphuongxa"/></aui:option>
							<%if(listPhuongXas!=null&&listPhuongXas.size()>0){
								for(DanhMuc phuongXa : listPhuongXas){%>
									<aui:option value="<%=phuongXa.getId() %>">
										<%=phuongXa.getTen() %>
									</aui:option>
								<%}
							}%>
					</aui:select>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.diachichitiet"/><label class="oep-label-red">(*)</label>
					<aui:input title="" type="text"  maxlength = "<%=DangKyTaiKhoanKeys.DangKyCongDan.DIACHI_CHITIET_MAX_LENGTH %>" 
							label = "" id = "<%=DangKyTaiKhoanKeys.DangKyCongDan.DIACHI_CHITIET %>" 
							name = "<%=DangKyTaiKhoanKeys.DangKyCongDan.DIACHI_CHITIET %>"/>
				</div>
			</div>
		</div>
		<br/>
		<aui:row>
			<aui:col md="3" xs="12">
				<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.makichhoat"/><label class="oep-label-red">(*)</label>
				<aui:select title="" style="width:100% !important" label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.hinhThucKichHoat %>" 
						id="<%=DangKyTaiKhoanKeys.DangKyCongDan.hinhThucKichHoat %>">
							<aui:option><liferay-ui:message key="dtt.vn.user.dangky.congdan.select.hinhthuckichhoat"/></aui:option>
							<%if(listHinhThucKH!=null&&listHinhThucKH.size()>0){
								for(DanhMuc hinhThucKH : listHinhThucKH){%>
									<aui:option value="<%=hinhThucKH.getId() %>">
										<%=hinhThucKH.getTen() %>
									</aui:option>
								<%}
							}%>
				</aui:select>
			</aui:col>
			<aui:col md="3" xs="12">
				<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.hinhthucxacthuc"/><label class="oep-label-red">(*)</label>
				<aui:select title="" style="width:100% !important" label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.HinhThuc_XacThuc_DaYeuTo %>" 
						id="<%=DangKyTaiKhoanKeys.DangKyCongDan.HinhThuc_XacThuc_DaYeuTo %>">
							<%if(listXacThucDaYeuTo!=null&&listXacThucDaYeuTo.size()>0){
								for(DanhMuc xacThucDYT : listXacThucDaYeuTo){%>
									<aui:option value="<%=xacThucDYT.getMa() %>">
										<%=xacThucDYT.getTen() %>
									</aui:option>
								<%}
							}%>
				</aui:select>
			</aui:col>
		</aui:row>
		<br/>
		<aui:row>
			<aui:col md="3" xs="12">
				<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.captcha"/><label class="oep-label-red">(*)</label>
				<aui:input title="" type="text" maxlength = "<%=DangKyTaiKhoanKeys.DangKyCongDan.MA_XACNHAN_MAX_LENGTH %>" 
						label = "" name = "<%=DangKyTaiKhoanKeys.DangKyCongDan.MA_XACNHAN %>" />
				
			</aui:col>
			<aui:col md="3" xs="12">
				<br/>
				<img class="captchaCD" src="<%=captchaURL%>" style="height: 33px;"/>
				<a href="#" id="refreshCaptchaCD" style="padding-left: 10px"><i class="icon-refresh"></i></a>
			</aui:col>
		</aui:row>
		<%-- <liferay-ui:error exception="<%= CaptchaTextException.class %>" message="captcha-verification-failed" />
		<liferay-captcha:captcha url="<%= captchaResourceURL %>"/> --%>
		    
		<p class="text-center" style="margin-top:15px">
				<input type="checkbox" name="camKet" ng-model="hoSo.camKet" required="true" class="ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required">	
	                  <em>Bằng cách nhấp vào Đăng ký, bạn đồng ý với <a onclick="mocamket2();"><label class="oep-label-bold" id="<portlet:namespace/>camKet">Điều khoản, Chính sách chia sẻ thông tin</label></a> của chúng tôi</em>   
		</p>
	</div>
		<aui:row>
			<aui:col>
			<select style="display: none;"	id="oep-form-errors">
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.hinhThucKichHoat%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_ACTIVEMETHOD_EMPTY %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_ACTIVEMETHOD_EMPTY %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.USER_NAME%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EXISTS_USERNAME %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EXISTS_USERNAME %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.MA_XACNHAN%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_CAPTCHA_INVALID %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_CAPTCHA_INVALID %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.USER_NAME%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_USERNAME %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_USERNAME %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.USER_NAME%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_USERNAME %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_USERNAME %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.MAT_KHAU%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_PWD %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_PWD %>"/>
					</option>
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.MAT_KHAU%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_SHORT_PWD %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_SHORT_PWD %>"/>
					</option>
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.MAT_KHAU_CONFIRM%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_PWD_CONFIRM %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_PWD_CONFIRM %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN%>'>	
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_TINH %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_TINH %>"/>	
					</option>	
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN%>'>	
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_QUANHUYEN %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_QUANHUYEN %>"/>	
					</option>	
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN%>'>	
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_PHUONGXA %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_PHUONGXA %>"/>	
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.MAT_KHAU_CONFIRM%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_NOT_DUPLICATE_PWD %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_NOT_DUPLICATE_PWD %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.EMAIL%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.EMAIL%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EXISTS_EMAIL %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EXISTS_EMAIL %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.EMAIL%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_EMAIL %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_EMAIL %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.HO_TEN%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_HOTEN %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_HOTEN %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.HO_TEN%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_HOTEN %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_HOTEN %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.GIOI_TINH%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_GIOITINH %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_GIOITINH %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.NGAY_SINH%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_NGAYSINH %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_NGAYSINH %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.NGAY_SINH%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_NGAYSINH %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_NGAYSINH %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.SO_CMND%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_CMND %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_CMND %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.SO_CMND%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_CMND %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_CMND %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.SO_CMND%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EXISTS_CMND %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EXISTS_CMND %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.DIEN_THOAI%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.DIEN_THOAI%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EXISTS_DIENTHOAI %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EXISTS_DIENTHOAI %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.DIEN_THOAI%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_DIENTHOAI %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_DIENTHOAI %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.DIACHI_CHITIET%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIACHI %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIACHI %>"/>
					</option>
					
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.DIEN_THOAI%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI_SMSOTP_OTPSMS %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI_SMSOTP_OTPSMS %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.EMAIL%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL_KH %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL_KH %>"/>
					</option>
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.DIEN_THOAI%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI_OTPSMS %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI_OTPSMS %>"/>
					</option>
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.DIEN_THOAI%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI_SMSOTP %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI_SMSOTP %>"/>
					</option>
					
					
				</select>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col>
				<p class="text-center">
				<button type="submit" class = "btn btn-warning"><liferay-ui:message key="dtt.vn.user.dangky.congdan.button.dangky"/></button></p>
			</aui:col>
		</aui:row>
	</aui:form>
		
	
</div>
</form>

<div class="row">
<div class="col-md-12">

<!-- Modal -->
<div class="modal fade" style="display: none;" id="viewdieukhoan2" tabindex="-1" role="dialog" aria-labelledby="viewdieukhoan2modal" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document" style="position: relative !important;">
    <div class="modal-content">
      <div class="modal-header">
      </div>
      <div class="modal-body" style="height: 500px;">
      <div class="row">
      	<div class="col-md-12 bg-trang">
			<%@ include file="/dangkytaikhoanportlet/dieukhoan.jsp" %>
      	</div>
      </div>
      </div>
      <div class="modal-footer" style="text-align: right;">
        <button type="button" id="btn-tieptucan" class="btn btn-primary" onclick="closePopupAttributecsdlxacminh2(); ">Đóng</button>
      </div>
    </div>
  </div>
</div>
</div>

</div>


<portlet:resourceURL var="getQuanHuyenByTinhThanhCongDanURL" id="getQuanHuyenByTinhThanh" >
</portlet:resourceURL>
<portlet:resourceURL var="getPhuongXaByQuanHuyenCongDanURL" id="getPhuongXaByQuanHuyen" >
</portlet:resourceURL>


<script>

$('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN %>').selectpicker('refresh');
$('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN %>').selectpicker('refresh');
$('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN %>').selectpicker('refresh');

AUI().use('aui-datepicker', function(A) {
	new A.DatePicker({
		trigger : '#<portlet:namespace/>ngayCapCMND',
		popover : {
		zIndex : 1
	},
	 mask: '%d/%m/%Y'
	});
});	
var portletId = "<%=themeDisplay.getPortletDisplay().getId()%>";
var quanHuyen = $('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN%>');
var phuongXa = $('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA%>');

function ThayDoiQuanHuyenCongDan(myObj){
	var quanHuyenId = $(myObj).val();
	var data = {<portlet:namespace/>quanHuyenId:quanHuyenId};
	
	//var datasend = JSON.stringify(data);
	fillDataToSelectWithAjaxJquery(data,'<%= getPhuongXaByQuanHuyenCongDanURL %>',$('#<portlet:namespace/>phuongXaIdCd'),'<option value=0>Chọn Phường Xã</option>');
	
}
function cleanselect(selectobj,defaultoption){
	selectobj.empty();
	selectobj.append(defaultoption);
}
function ThayDoiTinhThanhCongDan(myObj){
	var tinhThanhId = $(myObj).val();
	var data = {<portlet:namespace/>tinhThanhId:tinhThanhId};
	cleanselect($('#<portlet:namespace/>quanHuyenIdCd'),'<option value=0>Chọn Quận Huyện</option>');
	cleanselect($('#<portlet:namespace/>phuongXaIdCd'),'<option value=0>Chọn Phường Xã</option>');
	//var datasend = JSON.stringify(data);
	fillDataToSelectWithAjaxJquery(data,'<%= getQuanHuyenByTinhThanhCongDanURL %>',$('#<portlet:namespace/>quanHuyenIdCd'),'<option value=0>Chọn Quận Huyện</option>');
	
}
function filljsontoselectbox(json, selectobj,defaultoption){
	var jsonobj = JSON.parse(json); 
	selectobj.empty();
	selectobj.append(defaultoption);
	for(var i = 0; i < jsonobj.length; i ++){
		selectobj.append('<option class="" value="'+jsonobj[i].id+'"> '+jsonobj[i].key+'</option>');
	}
	selectobj.selectpicker('refresh');
}
function fillDataToSelectWithAjaxJquery(data,urlajax,objfill,defaultoption){
	console.log('2');
		$.ajax({
		
		type:'POST',
		data:data,
		url:urlajax,
		beforeSend: function (xhr) {
	      
	    },
		success:function(result){
			//fill data to select box
			filljsontoselectbox(result,objfill,defaultoption);

		},
		error: function (request, status, error) {
			alert('không thể kết nối với server. Vui lòng liên hệ với quản trị viên');
	    }
	});
}
</script>
<script type="text/javascript">
function closePopupAttributecsdlxacminh2() {
	$('#viewdieukhoan2').removeClass('show').addClass('hide');
}
function mocamket2(){
	$('#viewdieukhoan2').removeClass('fade').removeClass('hide').addClass('show');
}

$("#refreshCaptchaCD").click(function() {
	$(".captchaCD").attr("src", $(".captchaCD").attr("src") + "&force="+ new Date().getMilliseconds());
	return false;
});

$(document).ready(function(){
	setTimeout(function(){
		var tinhThanhStyle = $("#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN %>").attr("style");
		var huyenStyle     = $("#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN %>").attr("style");
		var xaStyle        = $("#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN %>").attr("style");
		
		var tinhThanhTitle = $("#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN %>").attr("data-original-title");
		var huyenTitle     = $("#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN %>").attr("data-original-title");
		var xaTitle        = $("#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN %>").attr("data-original-title");
		
		$("button[data-id='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN %>']").attr("style",tinhThanhStyle);
		$("button[data-id='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN %>']").attr("style",huyenStyle);
		$("button[data-id='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN %>']").attr("style",xaStyle);
		
		$("button[data-id='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN %>']").attr("title",tinhThanhTitle);
		$("button[data-id='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN %>']").attr("title",huyenTitle);
		$("button[data-id='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN %>']").attr("title",xaTitle);
	},200);
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
    var sd = null, ed = new Date();
  
    $('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.NGAY_SINH %>').datetimepicker({ 
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
    bindDateRangeValidation($("#form"), '<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.NGAY_SINH %>', 'endDate');
});


</script>
