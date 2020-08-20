<%@page import="org.oep.core.service.MappingVmapLocalServiceUtil"%>
<%@page import="org.oep.core.model.MappingVmap"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="org.jsoup.helper.Validate"%>
<%@page import="javax.validation.Valid"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="dtt.vn.user.common.utils.DateUtil"%>
<%@page import="dtt.vn.vnpost.service.DanhMucLocalServiceUtil"%>
<%@page import="dtt.vn.vnpost.model.Account"%>
<%@page import="dtt.vn.vnpost.model.AccountModel"%>
<%@page import="dtt.vn.vnpost.service.AccountLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="dtt.vn.vnpost.service.PhotoLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="dtt.vn.vnpost.service.DanhMucLocalServiceUtil"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil" %>
<%@page import="dtt.vn.vnpost.model.Photo"%>
<%@page import="dtt.vn.vnpost.model.DanhMuc"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="dtt.vn.user.quanly.business.MessageObject"%>
<%@page import="dtt.vn.user.keys.PortletKeysUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dtt.vn.user.keys.DanhMucKeys"%>
<%@page import="dtt.vn.user.keys.DangKyTaiKhoanKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="dtt.vn.user.common.utils.GhiChuObject" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.1.1/css/ol.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css">

<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/js/bootstrap-datetimepicker.min.js"></script>
<script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.1.1/build/ol.js"></script>

<style type="text/css">
body{
overflow-x : hidden;
}
.error-cl {
	border: 1px solid red;
}
.map {
        height: 400px;
        width: 100%;
      }
</style>
<%
User    currentUser                = null;
Account acc                        = null;
long tempId = themeDisplay.getUserId();
long userId = ParamUtil.getLong(request, "userId", PortalUtil.getUserId(request));

try{	
	currentUser                = PortalUtil.getUser(request);
	if (Validator.isNull(currentUser)) {
		currentUser = UserLocalServiceUtil.getUser(userId);
		acc = AccountLocalServiceUtil.getAccountByEmail(currentUser.getEmailAddress());	
	} else {
		currentUser = UserLocalServiceUtil.getUser(userId);
		acc = AccountLocalServiceUtil.getAccountByEmail(currentUser.getEmailAddress());
	}
} catch(Exception ex ) {
	System.err.print(ex.toString());
}

%>


<portlet:defineObjects />

<portlet:actionURL name="updateQLTK" var="updateQLTKURL">
</portlet:actionURL>

<%
if(acc == null){
	%>
	<div class="alert alert-warning">
		<!-- <liferay-ui:message key="portlet.quanlytaikhoan.erroraccount"/> -->
		<strong class="lead"><liferay-ui:message key="portlet.quanlytaikhoan.canhbao"/></strong>: <liferay-ui:message key="portlet.quanlytaikhoan.taikhoan"/> "<%=currentUser.getEmailAddress() %>" <liferay-ui:message key="portlet.quanlytaikhoan.notification"/>
	</div>
	<!-- <liferay-ui:message key="portlet.quanlytaikhoan.erroraccount"/> -->
	<%
} else {
	List    <Photo> listpt = PhotoLocalServiceUtil.getPhotosbyImageType_classPK(0, acc.getAccountId(), -1, -1);
	String  messageaccount = acc.getNote();
	GhiChuObject ghichu    = null;	
		if(!messageaccount.equals("")){
			ghichu = new GhiChuObject();
			ghichu = new Gson().fromJson(messageaccount, GhiChuObject.class);
		}
	List    <DanhMuc> listGiayTo       = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc("DMDC_LGT", 1, true);
	List<DanhMuc> listQuocGias         = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.QUOCQIALANHTHO.MA, 1, true);
	List<DanhMuc> listGioiTinhs        = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.GIOITINH.MA, 1, true);
	List<DanhMuc> listTinhThanhs       = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.DONVIHANHCHINH.MA, 1, true);
	List<DanhMuc> listTinhThanhTRs     = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.DONVIHANHCHINH.MA, 1, true);
	List<DanhMuc> listTinhThanhHTs     = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.DONVIHANHCHINH.MA, 1, true);
	List<DanhMuc> listTinhThanhXMs     = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.DONVIHANHCHINH.MA, 1, true);
	List<DanhMuc> listHinhThucKH       = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.HINHTHUCKICHHOATTAIKHOAN.MA, 1, true);
	List<DanhMuc> listXacThucDaYeuTo   = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.HINHTHUCXACTHUCDAYEUTO.MA, 1, true);
	List<DanhMuc> listQuanHuyens       = new ArrayList<DanhMuc>();
	List<DanhMuc> listPhuongXas        = new ArrayList<DanhMuc>();
	List<DanhMuc> listQuanHuyenTRs     = new ArrayList<DanhMuc>();
	List<DanhMuc> listPhuongXaTRs      = new ArrayList<DanhMuc>();
	List<DanhMuc> listQuanHuyenHTs     = new ArrayList<DanhMuc>();
	List<DanhMuc> listPhuongXaHTs      = new ArrayList<DanhMuc>();
	List<DanhMuc> listQuanHuyenXMs     = new ArrayList<DanhMuc>();
	List<DanhMuc> listPhuongXaXMs      = new ArrayList<DanhMuc>();

	long tinhId           = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN);
	long huyenId          = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN);
	long xaId             = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN);

	long tinhThanhTR      = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_THUONG_TRU, Long.parseLong(acc.getCityCode()));
	long quanHuyenTR      = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_THUONG_TRU, Long.parseLong(acc.getDistrictCode()));	
	long phuongXaTR       = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_THUONG_TRU, Long.parseLong(acc.getWardCode()));

	long tinhThanhHT      = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_HIEN_TAI);
	long quanHuyenHT      = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_HIEN_TAI);
	long phuongXaHT       = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_HIEN_TAI);

	long tinhThanhXM      = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_XAC_MINH, Long.parseLong((acc.getCityCodeXM() == null || acc.getCityCodeXM().equals(""))?"0":acc.getCityCodeXM()));
	long quanHuyenXM      = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_XAC_MINH, Long.parseLong((acc.getDistrictCodeXM() == null || acc.getDistrictCodeXM().equals(""))?"0":acc.getDistrictCodeXM()));
	long phuongXaXM       = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_XAC_MINH, Long.parseLong((acc.getWardCodeXM() == null || acc.getWardCodeXM().equals(""))?"0":acc.getWardCodeXM()));
	
	long quocGias		  = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.QUOC_TICH_THUONG_TRU, Long.parseLong((acc.getNation() == null || acc.getNation().equals(""))?"0":acc.getNation()));
	
	long hinhThucId = ParamUtil.getLong(request, DangKyTaiKhoanKeys.DangKyCongDan.hinhThucKichHoat);
	if(tinhId !=0){
	 	listQuanHuyens = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(tinhId, true);
	 }
	if(huyenId != 0){
	 	listPhuongXas = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(huyenId, true);
	 }
	if(tinhThanhTR !=0){
	 	listQuanHuyenTRs = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(tinhThanhTR, true);
	 }
	if(quanHuyenTR != 0){
	 	listPhuongXaTRs = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(quanHuyenTR, true);
	 }
	if(tinhThanhHT !=0){
	 	listQuanHuyenHTs = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(tinhThanhHT, true);
	 }
	if(quanHuyenHT != 0){
	 	listPhuongXaHTs = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(quanHuyenHT, true);
	 }
	if(tinhThanhXM !=0){
	 	listQuanHuyenXMs = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(tinhThanhXM, true);
	 }
	if(quanHuyenXM != 0){
	 	listPhuongXaXMs = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(quanHuyenXM, true);
	 }	

	//MappingVmap vmap = MappingVmapLocalServiceUtil.getToaDo(Account.class.getName(), acc.getAccountId());
	
	%>
	<%-- <form action="<%= updateQLTKURL %>" method="POST" id="form-qltk" enctype="multipart/form-data">
	<input type="hidden" name="<portlet:namespace/>jsonthongtin" id="<portlet:namespace/>jsonthongtin" />
	<input type="hidden" name="<portlet:namespace/>longmap" id="<portlet:namespace/>longmap" />
	<input type="hidden" name="<portlet:namespace/>latmap" id="<portlet:namespace/>latmap" />
	<div class="container" style="background-color: white;">
	<div>
	<%
	boolean isdone = false;
	if(request.getAttribute("isdone") != null){
		isdone = Boolean.parseBoolean(request.getAttribute("isdone").toString());
		if(isdone){
			%>
			<div class="alert alert-success" role="alert">
				
				<liferay-ui:message key="portlet.quanlytaikhoan.success"/>
			</div>
			<%
		}
	}
	
	%>
	<script>
	if(<%= isdone %>){
		window.location.href = "/web/guest/user-profile";
	}
	</script>
	</div>
		<%
		if(acc.getAccountType() == PortletKeysUtil.LoaiDoiTuongKeys.Ca_Nhan){
		%>
		<div class="bg-trang">
			<div class="container">
				<h4 class="tle" style="font-weight: 600 !important;">
					<liferay-ui:message key="portlet.quanlytaikhoan.capnhatthongtintaikhoancanhan"/>
				</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.tentaikhoan"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" readonly="readonly" id="tentaikhoan" name="<portlet:namespace/>tentaikhoan" value="<%=acc.getAccountName()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.email"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" readonly="readonly" id="email" name="<portlet:namespace/>email" value="<%=acc.getEmail()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.hovaten"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" id="<portlet:namespace/>hovaten"  name="<portlet:namespace/>hovaten" value="<%=acc.getFullName()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ngaysinh"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" id="startDate" name="<portlet:namespace/>startDate" value="<%=DateUtil.convertDateToString(acc.getBirthdate(),"dd/MM/yyyy")%>">
				</div>
				
				<!-- <div class="form-group">
					<label><liferay-ui:message key="portlet.quanlytaikhoan.chongiayto"/></label>
					<select class="form-control">
						<option value=""><liferay-ui:message key="portlet.quanlytaikhoan.loaigiayto"/></option>
					</select>
				</div> -->
			</div>
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ngaydangky"/></label>
					<input type="text" class="form-control" readonly="readonly" id="ngaydangky" name="<portlet:namespace/>ngaydangky" value="<%=DateUtil.convertDateToString(acc.getCreateDate(),"dd/MM/yyyy")%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.dienthoaididong"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" readonly="readonly" id="dienthoaididong" name="<portlet:namespace/>dienthoaididong" value="<%=acc.getTelNo()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.gioitinh"/> <label class="oep-label-red">(*)</label></label>
					<select class="form-control" id="gioitinh" name="<portlet:namespace/>gioitinh">
						<option value="1" <%if(acc.getGender() == 1){%>selected="selected"<%}%>><liferay-ui:message key="portlet.quanlytaikhoan.gioitinhnam"/></option>
						<option value="0" <%if(acc.getGender() == 0){%>selected="selected"<%}%>><liferay-ui:message key="portlet.quanlytaikhoan.gioitinhnu"/></option>
					</select>
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.sogiayto"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" id="sogiayto" name="<portlet:namespace/>sogiayto" value="<%=acc.getPersonalId()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.quoctich"/></label>
					<input type="text" class="form-control" id="quoctich" name="<portlet:namespace/>quoctich" value="<%=acc.getNationality()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ngaycap"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" id="ngaycap" name="<portlet:namespace/>ngaycap" value="<%=DateUtil.convertDateToString(acc.getRangeDate(),"dd/MM/yyyy")%>">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.noicap"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" id="noicap" name="<portlet:namespace/>noicap" value="<%=acc.getIssuedBy()%>">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.noicap"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" id="noicap" name="<portlet:namespace/>noicap" value="<%=acc.getIssuedBy()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.hotencha"/></label>
					<input type="text" class="form-control" id="hotencha" name="<portlet:namespace/>hotencha" value="<%=acc.getFatherName()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.hotennguoigiamho"/></label>
					<input type="text" class="form-control" id="hotennguoigiamho" name="<portlet:namespace/>hotennguoigiamho" value="<%=acc.getGuardianName()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.sosohokhau"/></label>
					<input type="text" class="form-control" id="sosohokhau" name="<portlet:namespace/>sosohokhau" value="<%=acc.getFamilyRegNo()%>">
				</div>
			</div>
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.hotenme"/></label>
					<input type="text" class="form-control" id="hotenme" name="<portlet:namespace/>hotenme" value="<%=acc.getMotherName()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.hotenvochong"/></label>
					<input type="text" class="form-control" id="hotenvochong" name="<portlet:namespace/>hotenvochong" value="<%=acc.getSpouseName()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.hotenchuho"/></label>
					<input type="text" class="form-control" id="hotenchuho" name="<portlet:namespace/>hotenchuho" value="<%=acc.getHeadHouseholdName()%>">
				</div>
			</div>
		</div>
		
		<div class="row">	
			<div class="col-md-12" style="background-color: white; font-size: 18px; margin-top: 10px;">
				<label class="control-label" id="noidangkythuongtru" for="pwd" style=" border-bottom: 1px solid black; cursor: pointer; color: blue;">
				<liferay-ui:message key="portlet.quanlytaikhoan.noidangkythuongtru"/></label>
			</div>
		</div>
		<div class="row" id="diachithuongtru">
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.quocgia"/></label>
					<aui:select style="width:100% !important"  label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.QUOC_TICH_THUONG_TRU %>" 
						id="<%=DangKyTaiKhoanKeys.DangKyCongDan.QUOC_TICH_THUONG_TRU %>">
							<aui:option value=""><liferay-ui:message key="portlet.quanlytaikhoan.chonquocgia"/></aui:option>
							<% for(DanhMuc quocGia : listQuocGias){%>
									<aui:option value="<%=quocGia.getId() %>" selected="<%=quocGias==quocGia.getId() %>"><%=quocGia.getTen() %>
									</aui:option>
							<%}%>
					</aui:select>
					
					<div class="form-group">
						<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.quanhuyenthuongtru"/></label>
						<aui:select label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_THUONG_TRU %>" 
								id="<%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_THUONG_TRU %>" onChange="ThayDoiQuanHuyenThuongTru(this);" >
							<aui:option value="0"><liferay-ui:message key="portlet.quanlytaikhoan.quanhuyenthuongtru"/></aui:option>
							<% for(DanhMuc quanHuyen : listQuanHuyenTRs){ %>
						    <aui:option value="<%=quanHuyen.getId() %>" selected="<%=quanHuyenTR==quanHuyen.getId()%>"><%=quanHuyen.getTen() %></aui:option>
						    <%} %>
						</aui:select>
				</div>
				</div>
			</div>
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
						<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.tinhthanhthuongtru"/></label>
						<aui:select name="<%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_THUONG_TRU %>" 
							id="<%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_THUONG_TRU %>" onchange="ThayDoiTinhThanhThuongTru(this);" label="">
							<aui:option value="0"><liferay-ui:message key="portlet.quanlytaikhoan.tinhthanhthuongtru"/></aui:option>
							<% for(DanhMuc tinhThanh : listTinhThanhTRs){ %>
						    <aui:option value="<%=tinhThanh.getId() %>" selected="<%=tinhThanhTR==tinhThanh.getId()%>"><%=tinhThanh.getTen() %></aui:option>
						    <%} %>
						</aui:select>
				</div>
				<div class="form-group">
						<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.phuongxathuongtru"/></label>
						<aui:select label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_THUONG_TRU %>" 
							id="<%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_THUONG_TRU %>">
							<aui:option value="0"><liferay-ui:message key="portlet.quanlytaikhoan.phuongxathuongtru"/></aui:option>
							<% for(DanhMuc phuongXa : listPhuongXaTRs){ %>
						    <aui:option value="<%=phuongXa.getId() %>" selected="<%=phuongXaTR==phuongXa.getId()%>"><%=phuongXa.getTen() %></aui:option>
						    <%} %>
						</aui:select>
				</div>
			</div>
			<div class="col-md-12" style="background-color: white;">
				<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.diachithuongtru"/></label>
				<input type="text" class="form-control" id="<portlet:namespace/>diachithuongtru" name="<portlet:namespace/>diachithuongtru" value="<%= acc.getAddress()%>">
			</div>
		</div>
		
		<%		
		} else if(acc.getAccountType() == PortletKeysUtil.LoaiDoiTuongKeys.To_Chuc){
		%>
		<div class="bg-trang">
			<div class="container">
				<h4 class="tle" style="font-weight: 600 !important;">
					<liferay-ui:message key="portlet.quanlytaikhoan.capnhatthongtintaikhoantochuc"/>
				</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.tentaikhoantochuc"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" readonly="readonly" id="tentaikhoantochuc" name="<portlet:namespace/>tentaikhoantochuc" value="<%=acc.getAccountName()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.emailtochuc"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" readonly="readonly" id="emailtochuc" name="<portlet:namespace/>emailtochuc" value="<%=acc.getEmail()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.tentochuc"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" id="tentochuc" name="<portlet:namespace/>tentochuc" value="<%=acc.getFullName()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.sogiaytonguoidaidien"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" id="sogiaytonguoidaidien" name="<portlet:namespace/>sogiaytonguoidaidien" value="<%=acc.getPersonalId()%>">
				</div>
			</div>
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.sodienthoai"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" readonly="readonly" id="sodienthoai" name="<portlet:namespace/>sodienthoai" value="<%=acc.getTelNo()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ngaydangkytochuc"/></label>
					<input type="text" class="form-control" readonly="readonly" id="ngaydangkytochuc" name="<portlet:namespace/>ngaydangkytochuc" value="<%=DateUtil.convertDateToString(acc.getCreateDate(),"dd/MM/yyyy")%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.masothue"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" id="masothue" name="<portlet:namespace/>masothue" value="<%=acc.getTaxCode()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.nguoidaidien"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" id="nguoidaidien" name="<portlet:namespace/>nguoidaidien" value="<%=acc.getLegalDelegate()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.sdtnguoidaidien"/></label>
					<input type="text" class="form-control" id="sdtnguoidaidien" name="<portlet:namespace/>sdtnguoidaidien" value="<%=acc.getRepresentativeTelNo()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.tochuccaptren"/></label>
					<input type="text" class="form-control" id="tochuccaptren" name="<portlet:namespace/>tochuccaptren" value="<%=acc.getSuperiorOrganization()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.fax"/></label>
					<input type="text" class="form-control" id="fax" name="<portlet:namespace/>fax" value="<%=acc.getFax()%>">
				</div>
				<!-- <div class="form-group">
					<label><liferay-ui:message key="portlet.quanlytaikhoan.chongiayto"/></label>
					<select class="form-control">
						<option value=""><liferay-ui:message key="portlet.quanlytaikhoan.loaigiayto"/></option>
					</select>
				</div> -->
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.noicap"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" id="noicap" name="<portlet:namespace/>noicap" value="<%=acc.getIssuedBy()%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ngaycap"/> <label class="oep-label-red">(*)</label></label>
					<input type="text" class="form-control" id="startDate" name="<portlet:namespace/>startDate" value="<%=DateUtil.convertDateToString(acc.getRangeDate(),"dd/MM/yyyy")%>">
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.noicap"/></label>
					<input type="text" class="form-control" id="noicap" name="<portlet:namespace/>noicap" value="<%=acc.getIssuedBy()%>">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12" style="background-color: white; font-size: 18px; margin-top: 10px;">
				<label class="control-label" id="noidangkythuongtru" for="pwd" style=" border-bottom: 1px solid black; cursor: pointer; color: blue;">
				<liferay-ui:message key="portlet.quanlytaikhoan.diachitrusotaivietnam"/></label>
			</div>
		</div>
		<div class="row" id="diachithuongtru">
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
						<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.tinhthanhthuongtru"/></label>
						<aui:select name="<%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_THUONG_TRU %>" 
							id="<%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_THUONG_TRU %>" onchange="ThayDoiTinhThanhThuongTru(this);" label="">
							<aui:option value="0"><liferay-ui:message key="portlet.quanlytaikhoan.tinhthanhthuongtru"/></aui:option>
							<% for(DanhMuc tinhThanh : listTinhThanhTRs){ %>
						    <aui:option value="<%=tinhThanh.getId() %>" selected="<%=tinhThanhTR==tinhThanh.getId()%>"><%=tinhThanh.getTen() %></aui:option>
						    <%} %>
						</aui:select>
				</div>
				<div class="form-group">
						<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.phuongxathuongtru"/></label>
						<aui:select label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_THUONG_TRU %>" 
							id="<%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_THUONG_TRU %>">
							<aui:option value="0"><liferay-ui:message key="portlet.quanlytaikhoan.phuongxathuongtru"/></aui:option>
							<% for(DanhMuc phuongXa : listPhuongXaTRs){ %>
						    <aui:option value="<%=phuongXa.getId() %>" selected="<%=phuongXaTR==phuongXa.getId()%>"><%=phuongXa.getTen() %></aui:option>
						    <%} %>
						</aui:select>
				</div>
			</div>
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
						<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.quanhuyenthuongtru"/></label>
						<aui:select label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_THUONG_TRU %>" 
								id="<%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_THUONG_TRU %>" onChange="ThayDoiQuanHuyenThuongTru(this);" >
							<aui:option value="0"><liferay-ui:message key="portlet.quanlytaikhoan.quanhuyenthuongtru"/></aui:option>
							<% for(DanhMuc quanHuyen : listQuanHuyenTRs){ %>
						    <aui:option value="<%=quanHuyen.getId() %>" selected="<%=quanHuyenTR==quanHuyen.getId()%>"><%=quanHuyen.getTen() %></aui:option>
						    <%} %>
						</aui:select>
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.diachithuongtru"/></label>
				<input type="text" class="form-control" id="<portlet:namespace/>diachithuongtru" name="<portlet:namespace/>diachithuongtru" value="<%= acc.getAddress()%>">
				</div>
			</div>
		</div>
		<%	
		}
		%>
		
		<div class="bg-trang">
				<div class="container">
					<h4 class="tle" style="font-weight: 600 !important;">
						<input type="checkbox" id="nangcap2" <%= (listpt.size() > 0)?"checked":"" %>>
						<liferay-ui:message key="portlet.quanlytaikhoan.nangcap2"/>
					</h4>
				</div>
		</div>
		<div class="row" id="form-nangcap2">
			<div class="col-md-12" style="background-color: white; margin-top: 10px">
				<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.danhsachtailieudikiem"/></label>
			</div>
			<div class="col-md-12" style="background-color: white; margin-top: 10px">
				<div id="table-box">
					<table class="table table-bordered" id="tb-xacminh"
						style="border-collapse: inherit !important">
						<thead>
							<tr style="text-align: center;">
								<th style="text-align: center;" class="" style="font-weight: bold;"><liferay-ui:message key="portlet.quanlytaikhoan.stt"/></th>
								<th style="text-align: center;" class="" style="font-weight: bold;"><liferay-ui:message key="portlet.quanlytaikhoan.loaigiayto"/></th>
								<th style="text-align: center;" class="" style="font-weight: bold;"><liferay-ui:message key="portlet.quanlytaikhoan.ghichu"/></th>
								<th style="text-align: center;" class="" style="font-weight: bold;"><liferay-ui:message key="portlet.quanlytaikhoan.dinhkem"/></th>
								<th style="text-align: center;" class="" style="font-weight: bold;"><a onclick="addNewRow('tb-xacminh');">
										<span class="glyphicon glyphicon-plus"></span>
								</a></th>
							</tr>
						</thead>
						<tbody>
						<%
						if(listpt.size() == 0){
						%>
						<tr suffix=0 style="text-align: center">
							<td>1</td>
							<td>
							<div class="form-group">
							    <select class="form-control" onchange="changeloaigiayto(0);" id="LoaiGiayTo0" name='<portlet:namespace/>LoaiGiayTo0'>
							    <option value=""><liferay-ui:message key="portlet.quanlytaikhoan.loaigiayto"/></option>
							      <%
							      for(DanhMuc ptDanhMuc : listGiayTo){
							    	  %>
							    	 <option value="<%= ptDanhMuc.getMa() %>"><%= ptDanhMuc.getTen() %></option>
							    	  <%
							      }
							      %>
							    </select>
							  </div>
							</td>
							<td>
								<input id="ghichuupload0" type="text" name="<portlet:namespace/>ghichuupload0" class="form-control" value="" />
							</td>
							<td><input class="btn btn-default" type="file" id="filexacminhdinhkem-0" name="<portlet:namespace/>filexacminhdinhkem-0" accept="image/*,application/pdf"/>
							<input type="hidden" id="url-image-0" name="<portlet:namespace/>url-image-0" value="" />
							</td>
							<td></td>
						</tr>
						<%
						}else{
						int sttnew = 1;
							for(int i = 0 ; i <listpt.size(); i ++ ){
							Photo ptitcu = 	listpt.get(i);
							
							String messstr = ptitcu.getMessage();
							MessageObject messit = new Gson().fromJson(messstr, MessageObject.class);
							%>
							<tr suffix=<%= messit.getId() %>>
							<td><%= sttnew++ %></td>
							<td>
								 <select class="form-control" onchange="changeloaigiayto(<%= messit.getId() %>);" id="LoaiGiayTo<%= messit.getId() %>" name='<portlet:namespace/>LoaiGiayTo<%= messit.getId() %>'>
								 <option value=""><liferay-ui:message key="portlet.quanlytaikhoan.loaigiayto"/></option>
							      <%
							      for(DanhMuc ptDanhMuc : listGiayTo){
							    	 if(ptDanhMuc.getMa().equals(messit.getLoaigt())){
							    		 %>
								    	   <option selected="selected" value="<%= ptDanhMuc.getMa() %>"><%= ptDanhMuc.getTen() %></option>
								    	  <%
							    	 }else{
							    		 %>
								    	   <option value="<%= ptDanhMuc.getMa() %>"><%= ptDanhMuc.getTen() %></option>
								    	  <%
							    	 }
							      }
							      %>
							    </select>	
									
							</td>
							<td>
								<input id="ghichuupload<%= messit.getId() %>" type="text" name="<portlet:namespace/>ghichuupload<%= messit.getId() %>" class="form-control" value="<%= (ghichu==null || i >= ghichu.ghiChuUpLoad.length)?"": ghichu.ghiChuUpLoad[i] %>" />
							</td>
							<td><input onchange="changeimage(<%= messit.getId() %>);" accept="image/*,application/pdf" class="btn btn-default" type="file" id="filexacminhdinhkem-<%= messit.getId() %>" name="<portlet:namespace/>filexacminhdinhkem-<%= messit.getId() %>"/>
							<p id="image-box-<%= messit.getId() %>">
							 <img onclick="viewimagemodal('<%= messit.getId() %>','<%= messit.getUrlfile()  %>');" style="height: 60px;" src="<%= messit.getUrlfile()  %>" class="img-thumbnail" alt=""> 
							</p>
							<input type="hidden" name="<portlet:namespace/>url-image-<%= messit.getId() %>" id="url-image-<%= messit.getId() %>" value="<%= messit.getUrlfile()  %>"/>
							</td>
							<td>
							<%
							if(sttnew> 2){
								%>
								<a onclick="deleteRow('<%= messit.getId() %>');"><span class="glyphicon glyphicon-remove"></span></a>
								<%
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
		</div>
			<div class="bg-trang">
				<div class="container">
					<h4 class="tle" style="font-weight: 600 !important;">
						<input <%= (tinhThanhXM != 0)?"checked":"" %> type="checkbox" id="nangcap3">
						<liferay-ui:message key="portlet.quanlytaikhoan.nangcap3"/>
					</h4>
				</div>
			</div>
		<div class="row" id="form-nangcap3">
			<div class="col-md-6" style="background-color: white; margin-top: 10px">
				<div class="form-group">
						<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.tinhthanhxacminh"/> <label class="oep-label-red">(*)</label></label>
						<aui:select name="<%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_XAC_MINH %>" 
							id="<%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_XAC_MINH %>" onchange="ThayDoiTinhThanhXacMinh(this);" label="">
							<aui:option value="0"><liferay-ui:message key="portlet.quanlytaikhoan.tinhthanhxacminh"/></aui:option>
							<% for(DanhMuc tinhThanhXMs : listTinhThanhXMs){ %>
						    <aui:option value="<%=tinhThanhXMs.getId() %>" selected="<%=tinhThanhXM==tinhThanhXMs.getId()%>"><%=tinhThanhXMs.getTen() %></aui:option>
						    <%} %>
						</aui:select>
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.quanhuyenxacminh"/> <label class="oep-label-red">(*)</label></label>
					<aui:select style="width:100% !important"  label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_XAC_MINH%>" 
						id="<%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_XAC_MINH %>" onchange="ThayDoiQuanHuyenXacMinh(this);">
							<aui:option value="0"><liferay-ui:message key="portlet.quanlytaikhoan.quanhuyenxacminh"/></aui:option>
							<% for(DanhMuc quanHuyenXMs : listQuanHuyenXMs){ %>
						    <aui:option value="<%=quanHuyenXMs.getId() %>" selected="<%=quanHuyenXM==quanHuyenXMs.getId()%>"><%=quanHuyenXMs.getTen() %></aui:option>
						    <%} %>
					</aui:select>
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.phuongxaxacminh"/></label>
					<aui:select style="width:100% !important"  label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_XAC_MINH %>" 
						id="<%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_XAC_MINH %>">
							<aui:option value="0"><liferay-ui:message key="portlet.quanlytaikhoan.phuongxaxacminh"/></aui:option>
							<% for(DanhMuc phuongXaXMs : listPhuongXaXMs){ %>
						    <aui:option value="<%=phuongXaXMs.getId() %>" selected="<%=phuongXaXM==phuongXaXMs.getId()%>"><%=phuongXaXMs.getTen() %></aui:option>
						    <%} %>
					</aui:select>
				</div>
			</div>
			<div class="col-md-6" style="background-color: white; margin-top: 10px">
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.noixacminh"/> <label class="oep-label-red">(*)</label></label>
					<select class="form-control" id="noixacminh">
						<option value=""><liferay-ui:message key="portlet.quanlytaikhoan.taibuucuc"/></option>
						<option value=""><liferay-ui:message key="portlet.quanlytaikhoan.taidiachikhac"/></option>
					</select>
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.buucuc"/> <label class="oep-label-red">(*)</label></label>
					<select class="form-control" id="noixacminh">
						<option value=""><liferay-ui:message key="portlet.quanlytaikhoan.buucuc"/></option>
					</select>
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.diachixacminh"/></label>
					<input type="text" class="form-control" id="diachixacminh" name="<portlet:namespace/>diachixacminh" value="<%=acc.getAddressXM()%>">
				</div>
			</div>
			<!-- <div class="col-md-6" style="background-color: white; margin-top: 10px">
			 <div id="map" class="map"></div>
			</div> -->
		</div>
	</div>	
</form> --%>
<div class="container" style="background-color: white;">
	<div class="row">
		<div class="col-md-6" style="background-color: white;">
			<div class="form-group">
				<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.capdo"/></label>
				<input type="text" class="form-control" readonly="readonly" id="capdo" name="<portlet:namespace/>capdo" value="<%=acc.getIpLevel()%>">
			</div>
		</div>
		<div class="col-md-6" style="background-color: white;">
			<div class="form-group">
				<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.trangthai"/></label>
				<input type="text" style="text-align: left;" class="form-control" id="tinhtrang"
						name="tinhtrang" readonly="readonly" 
						value="<%if(acc.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cho_Phe_Duyet){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.chopheduyet'/><%
		    		}else if(acc.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cap_Chung_Nhan_Dinh_Danh){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.capchungnhandinhdanh'/><%
		    		} else if(acc.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Tu_Choi_Duyet){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.tuchoiduyet'/><%
		    		} else if(acc.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cho_Xac_Minh){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.choxacminh'/><%
		    		} else if(acc.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.dangxacminh'/><%
		    		} else if(acc.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cho_Xy_Ly){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.choxuly'/><%
		    		} else if(acc.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cho_Phan_Cong){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.chophancong'/><%
		    		} else if(acc.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cho_Tra_KQ_Khong_Hop_Le){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.chotrakqkhl'/><%
		    		} else if(acc.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cho_Tra_Chung_Nhan_DD){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.chotracndd'/><%
		    		} else if(acc.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Da_Tra_KQ_Khong_Hop_Le){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.datrakqkhl'/><%
		    		} else if(acc.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Da_Tra_Chung_Nhan_DD){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.datracndd'/><%}%>">
			</div>
		</div>
	</div>
</div>
<div class="container" style="background-color: white; font-size: 13px;">
	<div class="row">
		<div class="col-md-12" style="">
			<%
			if(acc.getIpLevel() == 3){
		    	%><i><liferay-ui:message key='portlet.quanlytaikhoan.note3'/></i><%
		    }else{
		    	%><i><liferay-ui:message key='portlet.quanlytaikhoan.note12'/></i><%
		    }
			%>
		</div>
	</div>
</div>
<%
if(acc.getIpLevel() == 3){%>
<div class="container" style="background-color: white; font-size: 13px; margin-top: 15px">
	<div class="row">
		<div class="col-md-12" style="">
			<label class="control-label" for="pwd"><liferay-ui:message key='portlet.quanlytaikhoan.dichvusanpham'/></label>
		</div>
		<table class="table table-bordered">
			<thead>
			    <tr>
				    <th scope="col" style="text-align: center"><liferay-ui:message key='portlet.quanlytaikhoan.stt'/></th>
				    <th scope="col" style="text-align: center"><liferay-ui:message key='portlet.quanlytaikhoan.tenhethong'/></th>
				    <th scope="col" style="text-align: center"><liferay-ui:message key='portlet.quanlytaikhoan.duongdan'/></th>
			    </tr>
		  </thead>
		  <tbody>
		  	<tr>
		  		<td>1</td>
			  	<td><liferay-ui:message key='portlet.quanlytaikhoan.congquocgia'/></td>
			  	<td><a href="https://dichvucong.gov.vn/">https://dichvucong.gov.vn/</a></td>
		  	</tr>
		  </tbody>
		</table>
	</div>
</div>
<%
}
%>
<%-- <div class="container" style="background-color: white;">
	<div class="row" style="margin-bottom: 10px; text-align: right; margin-top: 10px">
		<div class="col-md-12">
			<button type="button" class="btn btn-primary" onClick="submit()"><liferay-ui:message key="portlet.quanlytaikhoan.button.luulai"/></button>
			<button type="button" class="btn btn-primary" onclick="window.location ='/home'"><liferay-ui:message key="portlet.quanlytaikhoan.button.thoat"/></button>
		</div>
	</div>
</div>

<aui:row>
	<aui:col>
		<select style="display: none;"	id="oep-form-errors">
			<option value='<portlet:namespace/>hovaten'>
				<liferay-ui:error key="dtt.vn.user.qltk.canhan.hovaten.empty" message="dtt.vn.user.qltk.canhan.hovaten.empty"/>
			</option>
		</select>
	</aui:col>
</aui:row>
	
	
<portlet:resourceURL var="getQuanHuyenByTinhThanhKhaiSinhURL" id="getQuanHuyenByTinhThanhKhaiSinh" >
</portlet:resourceURL>
<portlet:resourceURL var="getPhuongXaByQuanHuyenKhaiSinhURL" id="getPhuongXaByQuanHuyenKhaiSinh" >
</portlet:resourceURL>

<portlet:resourceURL var="getQuanHuyenByTinhThanhThuongTruURL" id="getQuanHuyenByTinhThanhThuongTru" >
</portlet:resourceURL>
<portlet:resourceURL var="getPhuongXaByQuanHuyenThuongTruURL" id="getPhuongXaByQuanHuyenThuongTru" >
</portlet:resourceURL>

<portlet:resourceURL var="getQuanHuyenByTinhThanhHienTaiURL" id="getQuanHuyenByTinhThanhHienTai" >
</portlet:resourceURL>
<portlet:resourceURL var="getPhuongXaByQuanHuyenHienTaiURL" id="getPhuongXaByQuanHuyenHienTai" >
</portlet:resourceURL>

<portlet:resourceURL var="getQuanHuyenByTinhThanhXacMinhURL" id="getQuanHuyenByTinhThanhXacMinh" >
</portlet:resourceURL>
<portlet:resourceURL var="getPhuongXaByQuanHuyenXacMinhURL" id="getPhuongXaByQuanHuyenXacMinh" >
</portlet:resourceURL>


<aui:script>

var portletId = "<%=themeDisplay.getPortletDisplay().getId()%>";
var quanHuyen = $('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN%>');
var phuongXa = $('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN%>');

var quanHuyenTR = $('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_THUONG_TRU%>');
var phuongXaTR = $('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_THUONG_TRU%>');

var quanHuyenHT = $('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_HIEN_TAI%>');
var phuongXaHT = $('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_HIEN_TAI%>');

var quanHuyenXM = $('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_XAC_MINH%>');
var phuongXaXM = $('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_XAC_MINH%>');

function ThayDoiTinhThanhKhaiSinh(myObj){
	var tinhThanhId = $(myObj).val();
	var data = {<portlet:namespace/>tinhThanhId:tinhThanhId};
	cleanselect($('#<portlet:namespace/>quanHuyenIdCd'),'<option value=0><liferay-ui:message key='portlet.quanlytaikhoan.quanhuyen'/></option>');
	cleanselect($('#<portlet:namespace/>phuongXaIdCd'),'<option value=0><liferay-ui:message key='portlet.quanlytaikhoan.phuongxa'/></option>');
	//var datasend = JSON.stringify(data);
	fillDataToSelectWithAjaxJquery(data,'<%= getQuanHuyenByTinhThanhKhaiSinhURL %>',$('#<portlet:namespace/>quanHuyenIdCd'),'<option value=0><liferay-ui:message key='portlet.quanlytaikhoan.quanhuyen'/></option>');
	
}
function ThayDoiQuanHuyenKhaiSinh(myObj){
	var quanHuyenId = $(myObj).val();
	var data = {<portlet:namespace/>quanHuyenId:quanHuyenId};
	
	//var datasend = JSON.stringify(data);
	fillDataToSelectWithAjaxJquery(data,'<%= getPhuongXaByQuanHuyenKhaiSinhURL %>',$('#<portlet:namespace/>phuongXaIdCd'),'<option value=0><liferay-ui:message key='portlet.quanlytaikhoan.phuongxa'/></option>');
	
}
	function changeimage(index){
		$('#image-box-'+index).empty();
		$('#url-image-'+index).val("");
	}
function ThayDoiTinhThanhThuongTru(myObj){
	var tinhThanhTR = $(myObj).val();
	var data = {<portlet:namespace/>tinhThanhTR:tinhThanhTR};
	cleanselect($('#<portlet:namespace/>quanHuyenTR'),'<option value=0><liferay-ui:message key="portlet.quanlytaikhoan.quanhuyenthuongtru"/></option>');
	cleanselect($('#<portlet:namespace/>phuongXaTR'),'<option value=0><liferay-ui:message key="portlet.quanlytaikhoan.phuongxathuongtru"/></option>');
	//var datasend = JSON.stringify(data);
	fillDataToSelectWithAjaxJquery(data,'<%= getQuanHuyenByTinhThanhThuongTruURL %>',$('#<portlet:namespace/>quanHuyenTR'),'<option value=0><liferay-ui:message key="portlet.quanlytaikhoan.quanhuyenthuongtru"/></option>');
	
}
function ThayDoiQuanHuyenThuongTru(myObj){
	var quanHuyenTR = $(myObj).val();
	var data = {<portlet:namespace/>quanHuyenTR:quanHuyenTR};
	
	//var datasend = JSON.stringify(data);
	fillDataToSelectWithAjaxJquery(data,'<%= getPhuongXaByQuanHuyenThuongTruURL %>',$('#<portlet:namespace/>phuongXaTR'),'<option value=0><liferay-ui:message key="portlet.quanlytaikhoan.phuongxathuongtru"/></option>');
	
}


function ThayDoiTinhThanhHienTai(myObj){
	var tinhThanhHT = $(myObj).val();
	var data = {<portlet:namespace/>tinhThanhHT:tinhThanhHT};
	cleanselect($('#<portlet:namespace/>quanHuyenHT'),'<option value=0><liferay-ui:message key="portlet.quanlytaikhoan.quanhuyenhientai"/></option>');
	cleanselect($('#<portlet:namespace/>phuongXaHT'),'<option value=0><liferay-ui:message key="portlet.quanlytaikhoan.phuongxahientai"/></option>');
	//var datasend = JSON.stringify(data);
	fillDataToSelectWithAjaxJquery(data,'<%= getQuanHuyenByTinhThanhHienTaiURL %>',$('#<portlet:namespace/>quanHuyenHT'),'<option value=0><liferay-ui:message key="portlet.quanlytaikhoan.quanhuyenhientai"/></option>');
	
}
function ThayDoiQuanHuyenHienTai(myObj){
	var quanHuyenHT = $(myObj).val();
	var data = {<portlet:namespace/>quanHuyenHT:quanHuyenHT};
	
	//var datasend = JSON.stringify(data);
	fillDataToSelectWithAjaxJquery(data,'<%= getPhuongXaByQuanHuyenHienTaiURL %>',$('#<portlet:namespace/>phuongXaHT'),'<option value=0><liferay-ui:message key="portlet.quanlytaikhoan.phuongxahientai"/></option>');
	
}

function ThayDoiTinhThanhXacMinh(myObj){
	var tinhThanhXM = $(myObj).val();
	var data = {<portlet:namespace/>tinhThanhXM:tinhThanhXM};
	cleanselect($('#<portlet:namespace/>quanHuyenXM'),'<option value=0><liferay-ui:message key="portlet.quanlytaikhoan.quanhuyenxacminh"/></option>');
	cleanselect($('#<portlet:namespace/>phuongXaXM'),'<option value=0><liferay-ui:message key="portlet.quanlytaikhoan.phuongxaxacminh"/></option>');
	//var datasend = JSON.stringify(data);
	fillDataToSelectWithAjaxJquery(data,'<%= getQuanHuyenByTinhThanhXacMinhURL %>',$('#<portlet:namespace/>quanHuyenXM'),'<option value=0><liferay-ui:message key="portlet.quanlytaikhoan.quanhuyenxacminh"/></option>');
	
}
function ThayDoiQuanHuyenXacMinh(myObj){
	var quanHuyenXM = $(myObj).val();
	var data = {<portlet:namespace/>quanHuyenXM:quanHuyenXM};
	
	//var datasend = JSON.stringify(data);
	fillDataToSelectWithAjaxJquery(data,'<%= getPhuongXaByQuanHuyenXacMinhURL %>',$('#<portlet:namespace/>phuongXaXM'),'<option value=0><liferay-ui:message key="portlet.quanlytaikhoan.phuongxaxacminh"/></option>');
	
}

function cleanselect(selectobj,defaultoption){
	selectobj.empty();
	selectobj.append(defaultoption);
}

function filljsontoselectbox(json, selectobj,defaultoption){
	var jsonobj = JSON.parse(json); 
	selectobj.empty();
	selectobj.append(defaultoption);
	for(var i = 0; i < jsonobj.length; i ++){
		selectobj.append('<option class="" value="'+jsonobj[i].id+'"> '+jsonobj[i].key+'</option>');
	}
	
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
			alert('<liferay-ui:message key="portlet.quanlytaikhoan.loiserver"/>');
	    }
	});
}
</aui:script>




<script type="text/javascript">

var arrayxacminh = [];
<%
if(listpt.size()>0){
	for(Photo ptjs : listpt){
		%>
		var dataolditem = JSON.parse('<%= ptjs.getMessage() %>');
		arrayxacminh.push(dataolditem);
		
		<%
	}
}
%>
console.log(arrayxacminh.length);


function changeloaigiayto(index){
	var lgt = $('#LoaiGiayTo'+index).val();
		var listxm = [];
	    var listxmattr = [];
		var id = index+"";
	    var thuoctinh = listxm;
	    var attrkey = listxmattr;
	    var loaigt = lgt;
	    var urlfile = "";
	    var itemxacminh = {id,thuoctinh,attrkey,loaigt,urlfile};
	    for( var i = 0; i < arrayxacminh.length; i++){ 
	    	   if ( arrayxacminh[i].id === id) {
	    		   arrayxacminh.splice(i, 1); 
	    	   }
	    	}
	    
	    arrayxacminh.push(itemxacminh);
	    console.log(arrayxacminh);
	   $('#list-thuoc-tinh-xm-'+index).empty();
}


function submit(){
	var iserror = false;
	$('#tb-xacminh').find('tbody > tr').each(function() {
		 /* var oldSuffix = parseInt($(this).attr('suffix'));
		 var tengtcheck = $('#LoaiGiayTo'+oldSuffix).val();
		if($('#LoaiGiayTo'+oldSuffix).val().trim() ==''){
			 alert('#LoaiGiayTo'+oldSuffix);
			$('#LoaiGiayTo'+oldSuffix).addClass('error-cl');	
			iserror = true;
		}else{
			$('#LoaiGiayTo'+oldSuffix).removeClass('error-cl');
		}
		if($('#filexacminhdinhkem-'+oldSuffix).val().trim() ==''){
			if($('#url-image-'+oldSuffix).val() == ""){
				$('#filexacminhdinhkem-'+oldSuffix).addClass('error-cl');
				iserror = true;
			}
			
		}else{
			$('#filexacminhdinhkem-'+oldSuffix).removeClass('error-cl');
		} */
		
	});
	if(iserror == true){
		return;
	} 
	
	var jsontt = JSON.stringify(arrayxacminh);
	$('#<portlet:namespace/>jsonthongtin').val(Base64.encode(jsontt));
	console.log($('#<portlet:namespace/>jsonthongtin').val());
	$('#form-qltk').submit();
}






function deleteRow(suffi){
	console.log(arrayxacminh);
	console.log("suffi:"+suffi);
	 for( var i = 0; i < arrayxacminh.length; i++){ 
  	   if ( arrayxacminh[i].id == suffi) {
  		   arrayxacminh.splice(i, 1); 
  	   }
  	}
	$("[suffix="+suffi+"]").remove();
}
function addNewRow(tableID){
	var table = document.getElementById(tableID);
	var rowCount = table.rows.length;
	var arrrow = [];
	for(var i = 0; i < rowCount; i++){
		if(!isNaN(parseInt(table.rows[i].getAttribute('suffix')))){
			arrrow.push(table.rows[i].getAttribute('suffix'));
		}
		
	}
	arrrow.sort();
	console.log(arrrow);
	var oldSuffix = parseInt(arrrow[arrrow.length -1]);
	var newSuffix = oldSuffix + 1;
	
	var sttcol = "<td>"+rowCount+"</td>";
	var tenGiayToCol = '<td><input type="text" class="form-control" id="TenGiayTo'+newSuffix+'"/></td>';
	var loaiGiayToCol = '<td><select onchange="changeloaigiayto('+newSuffix+');" class="form-control" id="LoaiGiayTo'+newSuffix+'">'+$('#LoaiGiayTo0').html()+'</select></td>';
	var coQuanChungThucCol = '<td><input type="text" class="form-control" id="CoQuanChungThuc'+newSuffix+'"/></td>';
	var hieuLucCol = '<td><input type="text" id="HieuLuc'+newSuffix+'"/></td>';
	var thuocTinhCol = '<td><input id="thuoctinh'+newSuffix+'" type="button" class="btn btn-primary" onclick="openThuocTinh('+newSuffix+')" value="Thuá»c tÃ­nh"><ul style="text-align: left;" id="list-thuoc-tinh-xm-'+newSuffix+'"></ul></td>';
	var dinhKemCol = '<td><input type="hidden" name="<portlet:namespace/>url-image-'+newSuffix+'"  id="url-image-'+newSuffix+'" value=""/><input class="btn btn-default" accept="image/*,application/pdf" type="file" id="filexacminhdinhkem-'+newSuffix+'" name="filexacminhdinhkem-'+newSuffix+'"></td>';
	var deleteCol = '<td><a onclick="deleteRow('+newSuffix+');"><span class="glyphicon glyphicon-remove"></span></a></td>';
	var ghichuCol = '<td><input id="ghichuupload'+newSuffix+'" name="<portlet:namespace/>ghichuupload'+newSuffix+'" type="text" class="form-control" value="" /></td>';
	
	$('#' + tableID + ' tr:last').after("<tr suffix='" + newSuffix + "' style='text-align: center;'>"
			   + sttcol
			   +loaiGiayToCol
			   + ghichuCol
			   + dinhKemCol
			   + deleteCol
        + "</tr>");
	$('#LoaiGiayTo'+newSuffix).val("");
}
</script>



<script type="text/javascript">
      var Markers = 
[
    
{lat: 21.0277644, lng: 105.83415979},
{lat: 10.687211, lng: 106.636429}
    
];
var myMap ;
function initmap(){
	var toadoinit = [];
	<%
	if(vmap == null){
		%>
		toadoinit = [105.83415979, 21.0277644];
		<%
	}else{
		%>
		toadoinit = [<%= vmap.getLongitude() %>, <%= vmap.getLatitude() %>];
		<%
	}
	%>
   myMap = new ol.Map({
   target: 'map',
    layers: [
        new ol.layer.Tile({
            source: new ol.source.OSM()
        })
    ],
    view: new ol.View({
        center: ol.proj.fromLonLat(toadoinit),
        zoom: 12
    })
});

   <%
	if(vmap == null){
		
	}else{
		%>
		chonvitri(<%= vmap.getLongitude() %>, <%= vmap.getLatitude() %>);
		<%
	}
	%>

  }


initmap();
function chonvitri(longstr,latstr){
	myMap.getLayers().forEach(function(layer) {
	    //If this is actually a group, we need to create an inner loop to go through its individual layers
	    console.log(layer);
	    if(layer.className_ =='thai'){
	      myMap.removeLayer(layer);
	      }

	});
	 var features = [];
	var longitude = longstr;
    var latitude = latstr;

    var iconFeature = new ol.Feature({
        geometry: new ol.geom.Point(ol.proj.transform([longitude, latitude], 'EPSG:4326', 'EPSG:3857'))
    });

    var iconStyle = new ol.style.Style({
        image: new ol.style.Icon(({
            anchor: [0.5, 1],
            src: "https://cdn.mapmarker.io/api/v1/pin?text=P&size=50&hoffset=1"
        }))
    });

    iconFeature.setStyle(iconStyle);
    features.push(iconFeature);
    var vectorSource = new ol.source.Vector({
        features: features
    });

    var vectorLayer = new ol.layer.Vector({
        source: vectorSource,
        className:"thai"
    });
    myMap.addLayer(vectorLayer);
}
function changeview(){
myMap.getLayers().forEach(function(layer) {
    //If this is actually a group, we need to create an inner loop to go through its individual layers
    console.log(layer);
    if(layer.className_ =='thai'){
      myMap.removeLayer(layer);
      }

});
  //     

  var features = [];


for (var i = 0; i < Markers.length; i++) {
    var item = Markers[i];
    var longitude = item.lng;
    var latitude = item.lat;

    var iconFeature = new ol.Feature({
        geometry: new ol.geom.Point(ol.proj.transform([longitude, latitude], 'EPSG:4326', 'EPSG:3857'))
    });

    var iconStyle = new ol.style.Style({
        image: new ol.style.Icon(({
            anchor: [0.5, 1],
            src: "https://cdn.mapmarker.io/api/v1/pin?text=P&size=50&hoffset=1"
        }))
    });

    iconFeature.setStyle(iconStyle);
    features.push(iconFeature);

}

var vectorSource = new ol.source.Vector({
    features: features
});

var vectorLayer = new ol.layer.Vector({
    source: vectorSource,
    className:"thai"
});
myMap.addLayer(vectorLayer);
myMap.getView().setCenter(ol.proj.transform([77.216574, 28.627671], 'EPSG:4326', 'EPSG:3857'));

  }
  myMap.on('click', function(evt){
    console.info(evt.pixel);
    console.info(myMap.getPixelFromCoordinate(evt.coordinate));
    console.info(ol.proj.toLonLat(evt.coordinate));
    var coords = ol.proj.toLonLat(evt.coordinate);
    var lat = coords[1];
    var lon = coords[0];
   // var locTxt = "Latitude: " + lat + " Longitude: " + lon;
    // coords is a div in HTML below the map to display
   // alert(locTxt);
    $('#<portlet:namespace/>latmap').val(lat);
    $('#<portlet:namespace/>longmap').val(lon);
    chonvitri(lon,lat);
});
    </script>



<script>
var Base64 = {
	    _keyStr: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",
	    encode: function(input) {
	        var output = "";
	        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
	        var i = 0;
	        input = Base64._utf8_encode(input);
	        while (i < input.length) {
	            chr1 = input.charCodeAt(i++);
	            chr2 = input.charCodeAt(i++);
	            chr3 = input.charCodeAt(i++);
	            enc1 = chr1 >> 2;
	            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
	            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
	            enc4 = chr3 & 63;
	            if (isNaN(chr2)) {
	                enc3 = enc4 = 64;
	            } else if (isNaN(chr3)) {
	                enc4 = 64;
	            }
	            output = output + this._keyStr.charAt(enc1) + this._keyStr.charAt(enc2) + this._keyStr.charAt(enc3) + this._keyStr.charAt(enc4);
	        }
	        return output;
	    },
	    decode: function(input) {
	        var output = "";
	        var chr1, chr2, chr3;
	        var enc1, enc2, enc3, enc4;
	        var i = 0;
	        input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");
	        while (i < input.length) {
	            enc1 = this._keyStr.indexOf(input.charAt(i++));
	            enc2 = this._keyStr.indexOf(input.charAt(i++));
	            enc3 = this._keyStr.indexOf(input.charAt(i++));
	            enc4 = this._keyStr.indexOf(input.charAt(i++));
	            chr1 = (enc1 << 2) | (enc2 >> 4);
	            chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
	            chr3 = ((enc3 & 3) << 6) | enc4;
	            output = output + String.fromCharCode(chr1);
	            if (enc3 != 64) {
	                output = output + String.fromCharCode(chr2);
	            }
	            if (enc4 != 64) {
	                output = output + String.fromCharCode(chr3);
	            }
	        }
	        output = Base64._utf8_decode(output);
	        return output;
	    },
	    _utf8_encode: function(string) {
	        string = string.replace(/\r\n/g, "\n");
	        var utftext = "";
	        for (var n = 0; n < string.length; n++) {
	            var c = string.charCodeAt(n);
	            if (c < 128) {
	                utftext += String.fromCharCode(c);
	            }
	            else if ((c > 127) && (c < 2048)) {
	                utftext += String.fromCharCode((c >> 6) | 192);
	                utftext += String.fromCharCode((c & 63) | 128);
	            }
	            else {
	                utftext += String.fromCharCode((c >> 12) | 224);
	                utftext += String.fromCharCode(((c >> 6) & 63) | 128);
	                utftext += String.fromCharCode((c & 63) | 128);
	            }
	        }
	        return utftext;
	    },
	    _utf8_decode: function(utftext) {
	        var string = "";
	        var i = 0;
	        var c = c1 = c2 = 0;
	        while (i < utftext.length) {
	            c = utftext.charCodeAt(i);
	            if (c < 128) {
	                string += String.fromCharCode(c);
	                i++;
	            }
	            else if ((c > 191) && (c < 224)) {
	                c2 = utftext.charCodeAt(i + 1);
	                string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
	                i += 2;
	            }
	            else {
	                c2 = utftext.charCodeAt(i + 1);
	                c3 = utftext.charCodeAt(i + 2);
	                string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
	                i += 3;
	            }
	        }
	        return string;
	    }
	}

$(document).ready(function(){
	$('#diachikhaisinh').hide();
	$('#diachithuongtru').hide();
	$('#diachihientai').hide();
	$('#form-nangcap2').hide();
	$('#form-nangcap3').hide();
 	
	
	if(<%= listpt.size() > 0?true:false%>){
		$( "#form-nangcap2" ).show();
	}
	if(<%= tinhThanhXM != 0%>){
		$( "#form-nangcap3" ).show();
	}
});
$('#noidangkykhaisinh').click(function(){
	$( "#diachikhaisinh" ).toggle(1000);
});

$('#noidangkythuongtru').click(function(){
	$( "#diachithuongtru" ).toggle(1000);
});


$('#noiohientai').click(function(){
	$( "#diachihientai" ).toggle(1000);
});

$('#nangcap2').change(function(){
	$( "#form-nangcap2" ).toggle(1000);
});


$('#nangcap3').change(function(){
	$( "#form-nangcap3" ).toggle(1000);
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
  
    $('#ngaycap').datetimepicker({ 
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
    bindDateRangeValidation($("#form"), 'ngaycap', 'endDate');
});
</script> --%>
<%
}
%>


