<%@page import="dtt.vn.user.utils.DangKyQuyTrinhUtil"%>
<%@page import="dtt.vn.user.keycloak.connect.KeycloakUtils"%>
<%@page import="dtt.vn.user.keys.DangKyTaiKhoanKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
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


<style type="text/css">
body{
overflow-x : hidden;
}
.dropdown-menu.open.show{
min-width: 528px !important;
}
</style>


<portlet:actionURL name="second" var="second"/>
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
List<DanhMuc> listTinhThanhTCs = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.DONVIHANHCHINH.MA, 1, true);
List<DanhMuc> listHinhThucKHTC = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.HINHTHUCKICHHOATTAIKHOAN.MA, 1, true);
List<DanhMuc> listXacThucDaYeuToTC = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.HINHTHUCXACTHUCDAYEUTO.MA, 1, true);
List<DanhMuc> listQuanHuyenTCs = new ArrayList<DanhMuc>();
List<DanhMuc> listPhuongXaTCs = new ArrayList<DanhMuc>();

long tinhTCId = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyToChuc.TINH_THANH);
long huyenTCId =ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyToChuc.QUAN_HUYEN);
long xaTCId = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyToChuc.PHUONG_XA);
long hinhthucId = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyToChuc.hinhThucKichHoatTC);

String maKichHoatDefault = DangKyQuyTrinhUtil.getMaKichHoat();
String maKichHoat = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.MA_KICHHOAT,maKichHoatDefault);

if(tinhTCId !=0){
 	listQuanHuyenTCs = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(tinhTCId, true);
 }
if(huyenTCId != 0){
 	listPhuongXaTCs = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(huyenTCId, true);
 }
%>
<portlet:actionURL var="luuLaiDangKyToChucURL" name="luuLaiDangKyToChuc">
<portlet:param name="mainURL" value="<%=mainURL %>"></portlet:param>
</portlet:actionURL>

<portlet:actionURL var="kichHoatDoanhNghiepURL" name="kichHoatDoanhNghiep" >
	<portlet:param name="javax.portlet.action" value="kichHoatDoanhNghiep"/>	
	<portlet:param name="maKichHoatMD5" value="<%=DangKyQuyTrinhUtil.getMd5Hash(maKichHoat) %>"/>	
</portlet:actionURL>

<portlet:resourceURL var="captchaURL" />

<form action="${second}" method="POST">
	<div class="oep=container">
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
<aui:form name="fmt" method="post" action="<%=luuLaiDangKyToChucURL.toString() %>" enctype="multipart/form-data">
	<div class="box">
	
	<aui:input title="" name="<%=DangKyTaiKhoanKeys.DangKyToChuc.KICHHOAT_URL %>" id="<%=DangKyTaiKhoanKeys.DangKyToChuc.KICHHOAT_URL %>" type="hidden" value="<%=kichHoatDoanhNghiepURL %>"/>
 		<aui:input name="<%=DangKyTaiKhoanKeys.Base.COMPANY_ID %>" id="<%=DangKyTaiKhoanKeys.Base.COMPANY_ID %>" type="hidden" value="<%=String.valueOf(themeDisplay.getCompanyId()) %>"/>
 		<aui:input name="<%=DangKyTaiKhoanKeys.DangKyToChuc.MA_KICHHOAT %>" id="<%=DangKyTaiKhoanKeys.DangKyToChuc.MA_KICHHOAT %>" type="hidden" value="<%=maKichHoat %>"/>
	
		<div class="tle1">
					<label class="oep-label-bold" style="font-size: 16px;"
						id="thongTinToChucLbl"> <liferay-ui:message
							key="dtt.vn.user.dangky.tochuc.label.thongtintaikhoan" /></label>
		</div>
		<div class="row">
			<div class="col-lg-6">			
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.tentaikhoan"/><label class="oep-label-red">(*)</label>
					<aui:input title="" type="text" cssClass="oep-inputfield" maxlength = "<%=DangKyTaiKhoanKeys.DangKyToChuc.USER_NAME_MAXLENGTH %>" 
							label = "" id = "<%=DangKyTaiKhoanKeys.DangKyToChuc.USER_NAME %>" name = "<%=DangKyTaiKhoanKeys.DangKyToChuc.USER_NAME %>"/>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.matkhau"/><label class="oep-label-red">(*)</label>
					<aui:input title="" type="password" cssClass="oep-inputfield name" 
							label = "" id = "<%=DangKyTaiKhoanKeys.DangKyToChuc.MAT_KHAU %>" name = "<%=DangKyTaiKhoanKeys.DangKyToChuc.MAT_KHAU %>"/>
				</div>
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.matkhauconfirm"/><label class="oep-label-red">(*)</label>
					<aui:input title="" type="password" cssClass="oep-inputfield name"   
							label = "" id = "<%=DangKyTaiKhoanKeys.DangKyToChuc.MAT_KHAU_CONFIRM %>" name = "<%=DangKyTaiKhoanKeys.DangKyToChuc.MAT_KHAU_CONFIRM %>"/>
				</div>
			</div>
	  	</div>
	</div> 
	
	<div class="box">
				<div class="tle1">
					<label class="oep-label-bold" style="font-size: 16px;"
						id="thongTinToChucLbl"><liferay-ui:message
							key="dtt.vn.user.dangky.tochuc.label.thongtintochuc" /></label>
				</div>
		<div class="row">
		 	<div class="col-lg-6">
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.tentochuc"/><label class="oep-label-red">(*)</label></label>
							<aui:input title="" type="text"  
							label = "" id = "<%=DangKyTaiKhoanKeys.DangKyToChuc.TEN_TO_CHUC %>" name = "<%=DangKyTaiKhoanKeys.DangKyToChuc.TEN_TO_CHUC %>"/>
				</div>
			<!-- </div>
			<div class="col-lg-6"> -->
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.masothue"/><label class="oep-label-red">(*)</label></label>
							<aui:input title="" type="text" 
							label = "" id = "<%=DangKyTaiKhoanKeys.DangKyToChuc.MA_SO_THUE %>" name = "<%=DangKyTaiKhoanKeys.DangKyToChuc.MA_SO_THUE %>"/>
				</div>
		<!-- 	</div>
			<div class="col-lg-6"> -->
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.email"/><label class="oep-label-red">(*)</label></label>
							<aui:input title="" type="text"   
							label = "" id = "<%=DangKyTaiKhoanKeys.DangKyToChuc.EMAIL %>" name = "<%=DangKyTaiKhoanKeys.DangKyToChuc.EMAIL %>"/>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.nguoidaidien"/><label class="oep-label-red">(*)</label></label>
					<aui:input title="" type="text"   
							label = "" id = "<%=DangKyTaiKhoanKeys.DangKyToChuc.NGUOI_DAI_DIEN %>" name = "<%=DangKyTaiKhoanKeys.DangKyToChuc.NGUOI_DAI_DIEN %>"/>
				</div>
			<!-- </div>
			<div class="col-lg-6"> -->
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.sodienthoai"/><label class="oep-label-red">(*)</label></label>
					<aui:input title="" type="text"  
							label = "" id = "<%=DangKyTaiKhoanKeys.DangKyToChuc.DIEN_THOAI %>" name = "<%=DangKyTaiKhoanKeys.DangKyToChuc.DIEN_THOAI %>"/>
				</div>
			<!-- </div>
			<div class="col-lg-6"> -->
				<div class="form-group">
					<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.socmnd"/><label class="oep-label-red">(*)</label></label>
					<aui:input title="" type="text"   
							label = "" id = "<%=DangKyTaiKhoanKeys.DangKyToChuc.SO_CMND %>" name = "<%=DangKyTaiKhoanKeys.DangKyToChuc.SO_CMND %>"/>
				</div>
			</div>
		</div>
			<p style="margin-top:15px">
			<strong><liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.diachitochuc"/></strong>
			</p>
		<div class="row">
			<div class="col-lg-6">
				<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.tinh"/><label class="oep-label-red">(*)</label>
				<aui:select data-width="100%" cssClass="selectpicker" data-dropup-auto="false" data-live-search="true" title="" onChange="ThayDoiTinhThanh(this);"  label="" name="<%=DangKyTaiKhoanKeys.DangKyToChuc.TINH_THANH %>" 
						id="<%=DangKyTaiKhoanKeys.DangKyToChuc.TINH_THANH %>">
							<aui:option value="0"><liferay-ui:message key="dtt.vn.user.dangky.tochuc.select.chontinhthanh"/></aui:option>
							<%if(listTinhThanhTCs!=null&&listTinhThanhTCs.size()>0){
								for(DanhMuc tinhThanh : listTinhThanhTCs){%>
									<aui:option value="<%=tinhThanh.getId() %>">
										<%=tinhThanh.getTen() %>
									</aui:option>
								<%}
							}%>
				</aui:select>
			</div>
			<div class="col-lg-6">
				<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.quanhuyen"/><label class="oep-label-red">(*)</label>
				<aui:select data-dropup-auto="false" data-width="100%" cssClass="selectpicker" data-live-search="true" title="" onChange="ThayDoiQuanHuyen(this);" label="" name="<%=DangKyTaiKhoanKeys.DangKyToChuc.QUAN_HUYEN %>" 
						id="<%=DangKyTaiKhoanKeys.DangKyToChuc.QUAN_HUYEN %>">
							<aui:option value="0"><liferay-ui:message key="dtt.vn.user.dangky.tochuc.select.chonquanhuyen"/></aui:option>
							<%if(listQuanHuyenTCs!=null&&listQuanHuyenTCs.size()>0){
								for(DanhMuc quanHuyen : listQuanHuyenTCs){%>
									<aui:option value="<%=quanHuyen.getId() %>">
										<%=quanHuyen.getTen() %>
									</aui:option>
								<%}
							}%>
				</aui:select>
			</div>
			<div class="col-lg-6">
				<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.phuongxa"/><label class="oep-label-red">(*)</label>
				<aui:select data-dropup-auto="false" data-width="100%" cssClass="selectpicker" data-live-search="true" title=""  label="" name="<%=DangKyTaiKhoanKeys.DangKyToChuc.PHUONG_XA %>" 
						id="<%=DangKyTaiKhoanKeys.DangKyToChuc.PHUONG_XA %>">
							<aui:option value="0"><liferay-ui:message key="dtt.vn.user.dangky.tochuc.select.chonphuongxa"/></aui:option>
							<%if(listPhuongXaTCs!=null&&listPhuongXaTCs.size()>0){
								for(DanhMuc phuongXa : listPhuongXaTCs){%>
									<aui:option value="<%=phuongXa.getId() %>">
										<%=phuongXa.getTen() %>
									</aui:option>
								<%}
							}%>
				</aui:select>
			</div>
			<div class="col-lg-6">
				<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.diachichitiet"/><label class="oep-label-red">(*)</label>
				<aui:input title="" type="text"  maxlength = "<%=DangKyTaiKhoanKeys.DangKyToChuc.DIACHI_CHITIET_MAX_LENGTH %>" 
							label = "" id = "<%=DangKyTaiKhoanKeys.DangKyToChuc.DIACHI_CHITIET %>" 
							name = "<%=DangKyTaiKhoanKeys.DangKyToChuc.DIACHI_CHITIET %>"/>
			</div>
		</div>
		<br/>
		<aui:row>
			<aui:col md="3" xs="12">
				<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.hinhthuckichhoat"/><label class="oep-label-red">(*)</label>
				<aui:select title="" style="width:100% !important"  label="" name="<%=DangKyTaiKhoanKeys.DangKyToChuc.hinhThucKichHoatTC %>" 
						id="<%=DangKyTaiKhoanKeys.DangKyToChuc.hinhThucKichHoatTC %>">
							<aui:option><liferay-ui:message key="dtt.vn.user.dangky.tochuc.select.hinhthuckichhoat"/></aui:option>
							<%if(listHinhThucKHTC!=null&&listHinhThucKHTC.size()>0){
								for(DanhMuc hinhthuc : listHinhThucKHTC){%>
									<aui:option value="<%=hinhthuc.getId() %>">
										<%=hinhthuc.getTen() %>
									</aui:option>
								<%}
							}%>
				</aui:select>
			</aui:col>
			<aui:col md="3" xs="12">
				<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.hinhthucxacthuc"/><label class="oep-label-red">(*)</label>
				<aui:select title="" style="width:100% !important"  label="" name="<%=DangKyTaiKhoanKeys.DangKyToChuc.HinhThuc_XacThuc_DaYeuToTC %>" 
						id="<%=DangKyTaiKhoanKeys.DangKyToChuc.HinhThuc_XacThuc_DaYeuToTC %>">
							<%if(listXacThucDaYeuToTC!=null&&listXacThucDaYeuToTC.size()>0){
								for(DanhMuc xacThucTC : listXacThucDaYeuToTC){%>
									<aui:option value="<%=xacThucTC.getMa() %>">
										<%=xacThucTC.getTen() %>
									</aui:option>
								<%}
							}%>
				</aui:select>
			</aui:col>
		</aui:row>
		<br/>
		<aui:row>
			<aui:col md="3" xs="12">
				<liferay-ui:message key="dtt.vn.user.dangky.tochuc.label.captcha"/><label class="oep-label-red">(*)</label>
				<aui:input title="" type="text"  maxlength = "<%=DangKyTaiKhoanKeys.DangKyToChuc.MA_XACNHAN_MAX_LENGTH %>" 
						label = "" name = "<%=DangKyTaiKhoanKeys.DangKyToChuc.MA_XACNHAN %>" />
				
			</aui:col>
			<aui:col md="3" xs="12">
				<br/>
				<img class="captchaTC" src="<%=captchaURL%>" style="height: 33px;"/>
				<a href="#" id="refreshCaptchaTC" style="padding-left: 10px"><i class="icon-refresh"></i></a>
			</aui:col>
		</aui:row>
		<%-- <liferay-ui:error exception="<%= CaptchaTextException.class %>" message="captcha-verification-failed" />
		<liferay-captcha:captcha url="<%= captchaResourceURL %>"/> --%>
		<p class="text-center" style="margin-top:15px">
				<input type="checkbox" name="camKet" ng-model="hoSo.camKet" required="true" class="ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required">	
	                 <em>Bằng cách nhấp vào Đăng ký, bạn đồng ý với <a onclick="mocamket();"><label class="oep-label-bold" id="<portlet:namespace/>camKet">Điều khoản, Chính sách chia sẻ thông tin</label></a> của chúng tôi</em>  
			</p>
		<aui:row>
			<aui:col>
			<select style="display: none;"	id="oep-form-errors">
			
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.hinhThucKichHoatTC%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_ACTIVEMETHOD_EMPTY %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_ACTIVEMETHOD_EMPTY %>"/>
					</option>
			
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.MA_XACNHAN%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_CAPTCHA_INVALID %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_CAPTCHA_INVALID %>"/>
					</option>
			
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.USER_NAME%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_USERNAME_EMPTY %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_USERNAME_EMPTY %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.USER_NAME%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_USERNAME_EXISTS %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_USERNAME_EXISTS %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.USER_NAME%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_USERNAME_INVALID %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_USERNAME_INVALID %>"/>
					</option>
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.MAT_KHAU%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMPTY_PWD %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMPTY_PWD %>"/>
					</option>
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.MAT_KHAU%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SHORT_PWD %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SHORT_PWD %>"/>
					</option>
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.MAT_KHAU_CONFIRM%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMPTY_PWD_CONFIRM %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMPTY_PWD_CONFIRM %>"/>
					</option>
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.MAT_KHAU_CONFIRM%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_NOT_DUPLICATE_PWD %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_NOT_DUPLICATE_PWD %>"/>
					</option>
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.EMAIL%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.EMAIL%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_INVALID %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_INVALID %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.EMAIL%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EXISTS %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EXISTS %>"/>
					</option>
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.TEN_TO_CHUC%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_TEN_TOCHUC_EMPTY %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_TEN_TOCHUC_EMPTY %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.TEN_TO_CHUC%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_TEN_TOCHUC_INVALID %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_TEN_TOCHUC_INVALID %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.MA_SO_THUE%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_MST_EMPTY %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_MST_EMPTY %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.MA_SO_THUE%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_MST_INVALID %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_MST_INVALID %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.MA_SO_THUE%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_MST_EXISTS %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_MST_EXISTS %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.SO_CMND%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_CMND_EMPTY %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_CMND_EMPTY %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.SO_CMND%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EXISTS_CMND %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EXISTS_CMND %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.SO_CMND%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_CMND_INVALID %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_CMND_INVALID %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.DIEN_THOAI%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.DIEN_THOAI%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_INVALID %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_INVALID %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.DIEN_THOAI%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EXISTS_DIENTHOAI %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EXISTS_DIENTHOAI %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.TINH_THANH%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_TINH_EMPTY %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_TINH_EMPTY %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.QUAN_HUYEN%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_QUANHUYEN_EMPTY %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_QUANHUYEN_EMPTY %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.PHUONG_XA%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_PHUONGXA_EMPTY %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_PHUONGXA_EMPTY %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.DIACHI_CHITIET%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_DIACHI_EMPTY %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_DIACHI_EMPTY %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.NGUOI_DAI_DIEN%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_NGUOIDAIDIEN_EMPTY %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_NGUOIDAIDIEN_EMPTY %>"/>
					</option>
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.NGUOI_DAI_DIEN%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_NGUOIDAIDIEN_INVALID %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_NGUOIDAIDIEN_INVALID %>"/>
					</option>
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.EMAIL%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY_KH %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY_KH %>"/>
					</option>
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.DIEN_THOAI%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_OTPSMS %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_OTPSMS %>"/>
					</option>
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.DIEN_THOAI%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_SMSOTP %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_SMSOTP %>"/>
					</option>
					
					<option value='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.DIEN_THOAI%>'>
						<liferay-ui:error key="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_SMSOTP_OTPSMS %>" message="<%=DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_SMSOTP_OTPSMS %>"/>
					</option>
				</select>
			</aui:col>
		</aui:row>
	</div>
		<aui:row>
			<aui:col>
				<p style="text-align: center">
						<button type="submit" class = "btn btn-warning"><liferay-ui:message key="dtt.vn.user.dangky.tochuc.button.dangky"/></button>
					</p>
			</aui:col>
		</aui:row>
	</aui:form>
		
<div class="row">
<div class="col-md-12">

<!-- Modal -->
<div class="modal fade" style="display: none;" id="viewdieukhoan" tabindex="-1" role="dialog" aria-labelledby="viewdieukhoanmodal" aria-hidden="true">
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
        <button type="button" id="btn-tieptucan" class="btn btn-primary" onclick="closePopupAttributecsdlxacminh();">Đóng</button>
      </div>
    </div>
  </div>
</div>
</div>

</div>
<portlet:resourceURL var="getQuanHuyenByTinhThanhURL" id="getQuanHuyenByTinhThanh" >
</portlet:resourceURL>
<portlet:resourceURL var="getPhuongXaByQuanHuyenURL" id="getPhuongXaByQuanHuyen" >
</portlet:resourceURL>
<aui:script>
var portletId = "<%=themeDisplay.getPortletDisplay().getId()%>";
var quanHuyen = $('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.QUAN_HUYEN%>');
var phuongXa = $('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.PHUONG_XA%>');
function getQuanHuyenByTinhThanh(thanhPhoId){
	alert("abc");
	fillDataToSelect(portletId ,"getQuanHuyenByTinhThanh", "<%=DangKyTaiKhoanKeys.DangKyToChuc.TINH_THANH%>", thanhPhoId, "<liferay-ui:message key='dtt.vn.user.dangky.tochuc.select.chonquanhuyen'/>", quanHuyen);
}
function getPhuongXaByQuanHuyen(quanHuyenId){
	fillDataToSelect(portletId ,"getPhuongXaByQuanHuyen", "<%=DangKyTaiKhoanKeys.DangKyToChuc.QUAN_HUYEN%>", quanHuyenId, "<liferay-ui:message key='dtt.vn.user.dangky.tochuc.select.chonphuongxa'/>", phuongXa);
}
function cleanselect(selectobj,defaultoption){
	selectobj.empty();
	selectobj.append(defaultoption);
}

function ThayDoiQuanHuyen(myObj){
	var quanHuyenId = $(myObj).val();
	var data = {<portlet:namespace/>quanHuyenId:quanHuyenId};
	
	//var datasend = JSON.stringify(data);
	fillDataToSelectWithAjaxJquery(data,'<%= getPhuongXaByQuanHuyenURL %>',$('#<portlet:namespace/>phuongXa_TCId'),'<option value=0>Chọn Phường Xã</option>');
	
}
function ThayDoiTinhThanh(myObj){
	var tinhThanhId = $(myObj).val();
	var data = {<portlet:namespace/>tinhThanhId:tinhThanhId};
	cleanselect($('#<portlet:namespace/>quanHuyen_TCId'),'<option value=0>Chọn Quận Huyện</option>');
	cleanselect($('#<portlet:namespace/>phuongXa_TCId'),'<option value=0>Chọn Phường Xã</option>');
	//var datasend = JSON.stringify(data);
	fillDataToSelectWithAjaxJquery(data,'<%= getQuanHuyenByTinhThanhURL %>',$('#<portlet:namespace/>quanHuyen_TCId'),'<option value=0>Chọn Quận Huyện</option>');
	
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
</aui:script>

<script type="text/javascript">

$('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.TINH_THANH %>').selectpicker('refresh');
$('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.QUAN_HUYEN %>').selectpicker('refresh');
$('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.PHUONG_XA %>').selectpicker('refresh');


function closePopupAttributecsdlxacminh() {
	$('#viewdieukhoan').removeClass('show').addClass('hide');
}
function mocamket(){
	$('#viewdieukhoan').removeClass('fade').removeClass('hide').addClass('show');
}

$("#refreshCaptchaTC").click(function() {
	$(".captchaTC").attr("src", $(".captchaTC").attr("src") + "&force="+ new Date().getMilliseconds());
	return false;
});

$(document).ready(function(){
	setTimeout(function(){
		var tinhThanhStyle = $("#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.TINH_THANH %>").attr("style");
		var huyenStyle     = $("#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.QUAN_HUYEN %>").attr("style");
		var xaStyle        = $("#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.PHUONG_XA %>").attr("style");
		
		var tinhThanhTitle = $("#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.TINH_THANH %>").attr("data-original-title");
		var huyenTitle     = $("#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.QUAN_HUYEN %>").attr("data-original-title");
		var xaTitle        = $("#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.PHUONG_XA %>").attr("data-original-title");
		
		$("button[data-id='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.TINH_THANH %>']").attr("style",tinhThanhStyle);
		$("button[data-id='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.QUAN_HUYEN %>']").attr("style",huyenStyle);
		$("button[data-id='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.PHUONG_XA %>']").attr("style",xaStyle);
		
		$("button[data-id='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.TINH_THANH %>']").attr("title",tinhThanhTitle);
		$("button[data-id='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.QUAN_HUYEN %>']").attr("title",huyenTitle);
		$("button[data-id='<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyToChuc.PHUONG_XA %>']").attr("title",xaTitle);
		
	},200);
	
});
</script>