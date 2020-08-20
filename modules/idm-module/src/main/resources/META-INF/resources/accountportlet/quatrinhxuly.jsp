<%@page import="dtt.vn.xacminh.business.YkienCanBoObject"%>
<%@page import="dtt.vn.account.util.PortletKeysUtil"%>
<%@page import="dtt.vn.xacminh.business.MessageObject"%>
<%@page import="dtt.vn.vnpost.service.PhotoLocalServiceUtil"%>
<%@page import="dtt.vn.vnpost.service.AccountLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="dtt.vn.account.business.Constantes"%>
<%@page import="dtt.vn.account.util.AccountEnum"%>
<%@page import="dtt.vn.account.util.DateUtil"%>
<%@page import="dtt.vn.account.business.IConstants"%>
<%@page import="dtt.vn.vnpost.model.Photo"%>
<%@page import="dtt.vn.vnpost.service.DanhMucLocalServiceUtil"%>
<%@page import="dtt.vn.vnpost.model.DanhMuc"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil" %>
<%@page import="dtt.vn.vnpost.model.Account"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.net.URL"%>
<%@page import="java.awt.Image"%>
<%@page import="javax.imageio.ImageIO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>	

<%@include file="/accountportlet/init.jsp" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style type="text/css">
body{
overflow-x : hidden;
}

.img-responsive {
  width: 600px;
  height: auto;
  cursor: pointer;
}

/* [LIGHTBOX] */
#lb-back {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  background: rgba(0, 0, 0, 0.5);
  z-index: 999;
  visibility: hidden;
  opacity: 0;
  transition: all 0.4s;
}
#lb-back.show {
  visibility: visible;
  opacity: 1;
}
#lb-img {
  text-align: center;
}

/* [DOES NOT MATTER] */
html, body {
  padding: 0;
  margin: 0;
}
</style>
<%
long accountId     = ParamUtil.getLong(request, "accountIdsend");
Account account1   = AccountLocalServiceUtil.fetchAccount(accountId);
List<Photo> listpt1 = PhotoLocalServiceUtil.getPhotosbyImageType_classPK(0, accountId, -1, -1);
List<Photo> listpt = PhotoLocalServiceUtil.getPhotosbyImageType_classPK(1, accountId, -1, -1);
List<DanhMuc> listGiayTo = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc("DMDC_LGT", 1, true);
Photo  photo       = PhotoLocalServiceUtil.createPhoto(CounterLocalServiceUtil.increment());
Image image        = null;
String urlbienban ="";
String backurl     = ParamUtil.getString(request, "backurl","");
List<Photo> photobbxn = PhotoLocalServiceUtil.getPhotosbyClassname_classPK(PortletKeysUtil.LoaiGiayToKeys.BBKXN, accountId);
if(photobbxn!=null & photobbxn.size()>0){
	urlbienban = photobbxn.get(0).getMessage();
}
String messageaccount = account1.getMessage();
YkienCanBoObject ykien = new YkienCanBoObject();
if(!messageaccount.equals("")){
	ykien = new Gson().fromJson(messageaccount, YkienCanBoObject.class);
}
%>

<div class="container" style="background-color: white;">
		<aui:form action="" method="" name="">
			
			<%
			if(account1.getAccountType() == PortletKeysUtil.LoaiDoiTuongKeys.Ca_Nhan){
			%>
				<div class="bg-trang">
			   		<div class="container">
			         	<h4 class="tle" style="font-weight: 600 !important;">
							<liferay-ui:message key="portlet.quanlytaikhoan.thongtinchitietycdk"/>
						</h4>
			      	</div>
	   			</div>
	   			<div class="row">
					<div class="col-md-6" style="background-color: white;">
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.tentaikhoan"/></label>
									<input type="text" class="form-control" id="tentaikhoan" name="tentaikhoan" readonly="readonly" value="<%=account1.getAccountName()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.xacminh.danhsach.sogiayto"/></label>
									<input type="text" class="form-control" readonly="readonly" id="sogiayto" name="sogiayto" value="<%= account1.getPersonalId()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.hovaten"/></label>
									<input type="text" class="form-control" id="HoVaTen"
											name="HoVaTen" readonly="readonly" value="<%= account1.getFullName()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ngaysinh"/></label>
									<input type="text" class="form-control" readonly="readonly" id="ngaysinh" name="ngaysinh" value="<%=DateUtil.convertDateToString(account1.getBirthdate(),"dd/MM/yyyy")%>">
							</div>
							<!-- <div class="form-group">
								<label class="control-label" for="email">Loại giấy tờ</label>
									<input type="text" class="form-control" id="LoaiGiayTo"
											name="LoaiGiayTo" readonly="readonly" value=''>
							</div> -->
							<%-- <div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.ngaycap"/></label>
									<input type="text" class="form-control" id="NgayCap"
											name="NgayCap" readonly="readonly" value="<%=DateUtil.convertDateToString(account1.getRangeDate(),"dd/MM/yyyy")%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.sosohokhau"/></label>
									<input type="text" class="form-control" id="SoSoHoKhau"
											name="SoSoHoKhau" readonly="readonly" value="<%=account1.getFamilyRegNo()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.hotencha"/></label>
									<input type="text" class="form-control" id="HoTenCha"
											name="HoTenCha" readonly="readonly" value="<%=account1.getFatherName()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.hotennguoigiamho"/></label>
									<input type="text" class="form-control" id="HoTenNguoiGiamHo"
											name="HoTenNguoiGiamHo" readonly="readonly" value="<%=account1.getGuardianName()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.noidangkythuongtru"/></label>
								<%
								String diaChiThuongTru =account1.getAddress()+" "+"-"+" "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getWardCode()))
								.getTen()+" "+"-"+" "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getDistrictCode())).
								getTen()+" "+"-"+" "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getCityCode())).getTen();
								%>
								<input type="text" class="form-control" id="DiaChi"
										name="DiaChi" readonly="readonly" value="<%=diaChiThuongTru%>">
							</div> --%>
					</div>
					<div class="col-md-6" style="background-color: white;">
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.hinhthucdangky"/></label>
									<input type="text" class="form-control" id="hinhthucdangky"
											name="hinhthucdangky" readonly="readonly" value="Trực tiếp">
							</div>
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.email"/></label>
									<input type="text" class="form-control" id="Email"
												name="Email" readonly="readonly" value="<%= account1.getEmail()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.gioitinh"/></label>
									<input type="text" class="form-control" id="GioiTinh"
											name="GioiTinh" readonly="readonly" value='<%= (account1.getGender()== 0)?"Nữ":"Nam" %>'>
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.sodienthoai"/></label>
									<input type="text" class="form-control" readonly="readonly" id="sodienthoai" name="sodienthoai" value="<%= account1.getTelNo()%>">
							</div>
							<%-- <div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.noicap"/></label>
									<input type="text" class="form-control" id="NoiCap" name="NoiCap" readonly="readonly" value="<%=account1.getIssuedBy()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.hotenchuho"/></label>
									<input type="text" class="form-control" id="HoTenChuHo" name="HoTenChuHo" readonly="readonly" value="<%=account1.getHeadHouseholdName()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.hotenme"/></label>
									<input type="text" class="form-control" id="HoTenChuHo" name="HoTenMe" readonly="readonly" value="<%=account1.getMotherName()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.hotenvochong"/></label>
									<input type="text" class="form-control" id="HoTenVoChong" name="HoTenVoChong" readonly="readonly" value="<%=account1.getSpouseName()%>">
							</div> --%>
					</div>
					<div class="col-md-12" style="background-color: white;">
						<div class="form-group">
							<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.noidangkythuongtru"/></label>
							<div class="">
							<%
								String diaChiThuongTru =account1.getAddress()+" "+"-"+" "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getWardCode()))
								.getTen()+" "+"-"+" "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getDistrictCode())).
								getTen()+" "+"-"+" "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getCityCode())).getTen();
							%>
								<input type="text" class="form-control" id="DiaChi"
										name="DiaChi" readonly="readonly" value="<%=diaChiThuongTru%>">
							</div>
						</div>
					</div>
				</div>
					<!-- <div class="bg-trang">
				   		<div class="container">
				         	<h4 class="tle" style="font-weight: 600 !important;"> 
								<strong><liferay-ui:message key="portlet.quanlytaikhoan.noixacminhthongtin"/></strong>
							</h4>
				      	</div>
		   			</div>
		   			<div class="row">
			   			<div class="col-md-6" style="background-color: white;">
			   				<div class="form-group">
									<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.noixacthuc"/></label>
										<input type="text" class="form-control" id="NoiXacThuc" name="NoiXacThuc" readonly="readonly" value="">
								</div>
			   			</div>
			   			<div class="col-md-6" style="background-color: white;">
			   				<div class="form-group">
									<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.buucuc"/></label>
										<input type="text" class="form-control" id="BuuCuc" name="BuuCuc" readonly="readonly" value="">
								</div>
			   			</div>
			   		</div> -->
			<%		
			} else if(account1.getAccountType() == PortletKeysUtil.LoaiDoiTuongKeys.To_Chuc){
			%>
				<div class="bg-trang">
			   		<div class="container">
			         	<h4 class="tle" style="font-weight: 600 !important;">
							<liferay-ui:message key="portlet.quanlytaikhoan.thongtinchitietycdk"/>
						</h4>
			      	</div>
	   			</div>
	   			<div class="row">
					<div class="col-md-6" style="background-color: white;">
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.tentaikhoan"/></label>
									<input type="text" class="form-control" readonly="readonly" id="tentaikhoan" name="tentaikhoan" value="<%= account1.getAccountName()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.cmndnguoidaidien"/></label>
									<input type="text" class="form-control" readonly="readonly" id="cmndnguoidaidien" name="cmndnguoidaidien" value="<%= account1.getPersonalId()%>">
							</div>
							<div class="form-group">
								<label class="control-labe" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.tentochuc"/></label>
									<input type="text" class="form-control" id="HoVaTen"
											name="HoVaTen" readonly="readonly" value="<%= account1.getFullName()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.nguoidaidientochuc"/></label>
									<input type="text" class="form-control" readonly="readonly" id="nguoidaidien" name="nguoidaidien" value="<%= account1.getLegalDelegate() %>">
							</div>
							<%-- <div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.socmndnguoidaidien"/></label>
									<input type="text" class="form-control" readonly="readonly" id="cmndnguoidaidien" name="cmndnguoidaidien" value="<%= account1.getPersonalId()%>">
							</div> --%>
						</div>
						<div class="col-md-6" style="background-color: white;">
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.hinhthucdangky"/></label>
									<input type="text" class="form-control" id="hinhthucdangky"
											name="hinhthucdangky" readonly="readonly" value="Trực tiếp">
							</div>
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.email"/></label>
									<input type="text" class="form-control" id="Email"
												name="Email" readonly="readonly" value="<%= account1.getEmail()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.dienthoaididong"/></label>
									<input type="text" class="form-control" readonly="readonly" id="sodienthoai" name="sodienthoai" value="<%= account1.getTelNo()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.masothue"/></label>
									<input type="text" class="form-control" id="GioiTinh"
											name="GioiTinh" readonly="readonly" value="<%= account1.getTaxCode()%>">
							</div>
							<%-- <div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.tentochuccaptren"/></label>
									<input type="text" class="form-control" readonly="readonly" id="tentochuccaptren" name="tentochuccaptren" value="<%=account1.getSuperiorOrganization()%>">
							</div>
							<div class="form-group">
									<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.fax"/></label>
										<input type="text" class="form-control" readonly="readonly" id="fax" name="fax" value="<%=account1.getFax()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.sdtnguoidaidien"/></label>
									<input type="text" class="form-control" readonly="readonly" id="sdtnguoidaidien" name="sdtnguoidaidien" value="<%= account1.getRepresentativeTelNo()%>">
							</div> --%>
							<%-- <div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.diachitruso"/></label>
								<%
									String diaChiTruSo =account1.getAddress()+" "+"-"+" "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getWardCode()))
									.getTen()+" "+"-"+" "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getDistrictCode())).
									getTen()+" "+"-"+" "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getCityCode())).getTen();
								%>
									<input type="text" class="form-control" id="DiaChi"
											name="DiaChi" readonly="readonly" value="<%=diaChiTruSo%>">
							</div> --%>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.diachitruso"/></label>
								<div class="">
								<%
									String diaChiTruSo =account1.getAddress()+" "+"-"+" "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getWardCode()))
									.getTen()+" "+"-"+" "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getDistrictCode())).
									getTen()+" "+"-"+" "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getCityCode())).getTen();
								%>
									<input type="text" class="form-control" id="DiaChi"
											name="DiaChi" readonly="readonly" value="<%=diaChiTruSo%>">
								</div>
							</div>
						</div>
					</div>
					<!-- <div class="bg-trang">
					   		<div class="container">
					         	<h4 class="tle" style="font-weight: 600 !important;">
									<liferay-ui:message key="portlet.quanlytaikhoan.noixacminhthongtin"/>
								</h4>
					      	</div>
			   		</div>
		   			<div class="row">
						<div class="col-md-6" style="background-color: white;">
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.noixacthuc"/></label>
									<input type="text" class="form-control" readonly="readonly" id="noixacminh" name="noixacminh" value="">
							</div>
						</div>
						<div class="col-md-6" style="background-color: white;">
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.buucuc"/></label>
									<input type="text" class="form-control" readonly="readonly" id="buucuc" name="buucuc" value="">
							</div>
						</div>
					</div> -->
			<%	
			}
			%>
		</aui:form>
	</div>
<%-- <div class="container" style="background-color: white;">
	<div class="row" style="background-color: white;">
		<div class="col-md-12">
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.diachixacminh"/></label>
					<div class="">
					<%
			    		String wardXM = "";
			    		String districtXM = "";
			    		String cityXM = "";
			    		try{
			    			wardXM =DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getWardCodeXM()))==null?"": DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getWardCodeXM()))
									.getTen();
			    			districtXM =DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getDistrictCodeXM()))==null?"": DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getDistrictCodeXM())).
									getTen();
			    			cityXM = DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getCityCodeXM()))==null?"": DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getCityCodeXM())).getTen();
			    		}catch(Exception e){
			    			
			    		}
			    		
			    		String diaChiXacMinh =account1.getAddressXM()+" "+"-"+" "+wardXM+" "+"-"+" "+districtXM+" "+"-"+" "+ cityXM;
			    		%>
						<input type="text" class="form-control" id="DiaChi"
								name="DiaChi" readonly="readonly" value="<%=diaChiXacMinh%>">
					</div>
				</div>
		</div>
	</div>
</div> --%>
<div class="container" style="background-color: white;">
	<!-- <div class="bg-trang">
		<div class="container">
			<h4 class="tle" style="font-weight: 600 !important;"><liferay-ui:message key="portlet.quanlytaikhoan.danhsachtailieudikemdangky"/></h4>
		</div>
	</div> -->
	
	<portlet:actionURL name="actionPheDuyet" var="actionPheDuyettURL">
	</portlet:actionURL>

	<form action="<%= actionPheDuyettURL %>" method="POST" id="form-pheduyet" enctype="multipart/form-data">
		<input type="hidden" name="<portlet:namespace/>acid" id="<portlet:namespace/>acid" value="<%= accountId %>"/>
		<input type="hidden" name="<portlet:namespace/>pheduyet" id="<portlet:namespace/>pheduyet" value=""/>
	<!-- <div class="row"> -->
		<%-- <div class="col-md-6" style="height: 200px; overflow: auto; ">
					<table class="table table-bordered">
							<thead>
								<tr>
									<th class="" style="text-align: center;"><liferay-ui:message key="portlet.quanlytaikhoan.stt"/></th>
									<th class="" style="text-align: center;"><liferay-ui:message key="portlet.quanlytaikhoan.tengiayto"/></th>
								</tr>
							</thead>
							<tbody>
							<%
							if(listpt1.size() == 0){
								%>
								<tr suffix=0>
									<td>1</td>
									<td></td>
								</tr>
								<%
							}else{
								int sttnew = 1;
								for(Photo ptitcu:listpt1){
									String messstr = ptitcu.getMessage();
									MessageObject messit = new Gson().fromJson(messstr, MessageObject.class);
									%>
									<tr suffix=<%= messit.getId() %>>
									<td><%= sttnew++ %></td>
									<td><input class="btn btn-link" onclick="viewimage('<%=messit.getUrlfile() %>')" 
									type="button" id="TenGiayTo" value="<%=DanhMucLocalServiceUtil.getByM(messit.getLoaigt()).getTen()%>"/></td>
								</tr>
									<%
								}
							}
							%>
						</tbody>
					</table>
			</div>
			<div class="col-md-6" id="images" style="padding-left: 5px">
				<div class="text-right">
					<button type="button" class="btn btn-info" id="delete-image" onclick="deleteimagef();" style="cursor: pointer;">
			          <span class="glyphicon glyphicon-remove"></span><liferay-ui:message key="portlet.quanlytaikhoan.dong"/>
			        </button>
		        </div>
				<img style="height: 300px" id="infoimage" alt="" onclick="viewfiledangky(this);" src="" class="img-responsive" />
			</div>
		</div> --%>
		
		<div class="bg-trang">
			<div class="container">
				<h4 class="tle" style="font-weight: 600 !important;"><liferay-ui:message key="portlet.quanlytaikhoan.ketquaxacminh"/></h4>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6" style="background-color: white;">
					<div class="form-group">
						<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.hinhthucxacminh"/></label>
						<input type="text" class="form-control" readonly="readonly" id="hinhthucxacminh" name="hinhthucxacminh" value="Trực tiếp">
					</div>
					<div class="form-group">
						<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.anhchandung"/></label><br>
						<button type="button" class="btn btn-primary" onClick=""><liferay-ui:message key="portlet.quanlytaikhoan.xem"/></button>
					</div>
			</div>
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.tinhtrang"/></label>
					<input type="text" style="text-align: left;" class="form-control" id="tinhtrang"
						name="tinhtrang" readonly="readonly" 
						value="<%if(account1.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cho_Phe_Duyet){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.chopheduyet'/><%
		    		}else if(account1.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cap_Chung_Nhan_Dinh_Danh){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.capchungnhandinhdanh'/><%
		    		} else if(account1.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Tu_Choi_Duyet){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.tuchoiduyet'/><%
		    		} else if(account1.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cho_Xac_Minh){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.choxacminh'/><%
		    		} else if(account1.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.dangxacminh'/><%
		    		} else if(account1.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cho_Xy_Ly){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.choxuly'/><%
		    		} else if(account1.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cho_Phan_Cong){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.chophancong'/><%
		    		} else if(account1.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cho_Tra_KQ_Khong_Hop_Le){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.chotrakqkhl'/><%
		    		} else if(account1.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cho_Tra_Chung_Nhan_DD){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.chotracndd'/><%
		    		} else if(account1.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Da_Tra_KQ_Khong_Hop_Le){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.datrakqkhl'/><%
		    		} else if(account1.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Da_Tra_Chung_Nhan_DD){
		    			%><liferay-ui:message key='portlet.quanlytaikhoan.datracndd'/><%}%>">
				</div>
				<div class="form-group">
					<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.capdohientai"/></label>
					<input type="text" class="form-control" id="capdohientai"
						name="capdohientai" readonly="readonly" value="<%= account1.getIpLevel()%>">
				</div>
			</div>
		</div>
	</form>
</div>
<div class="container" style="background-color: white;">
	<div class="bg-trang">
		<div class="container">
			<h4 class="tle" style="font-weight: 600 !important;"><liferay-ui:message key="portlet.quanlytaikhoan.tailieudinhkemxacminh"/></h4>
		</div>
	</div>
	
	<portlet:actionURL name="actionPheDuyet" var="actionPheDuyettURL">
	</portlet:actionURL>

	<form action="<%= actionPheDuyettURL %>" method="POST" id="form-pheduyet" enctype="multipart/form-data">
		<input type="hidden" name="<portlet:namespace/>acid" id="<portlet:namespace/>acid" value="<%= accountId %>"/>
		<input type="hidden" name="<portlet:namespace/>pheduyet" id="<portlet:namespace/>pheduyet" value=""/>
	<div class="row">
		<div class="col-md-8" style="height: 300px; overflow: auto; ">
					<table class="table table-bordered">
							<thead>
								<tr>
									<th class="" style="text-align: center;"><liferay-ui:message key="portlet.quanlytaikhoan.stt"/></th>
									<th class="" style="text-align: center;"><liferay-ui:message key="portlet.quanlytaikhoan.tengiayto"/></th>
									<th class="" style="text-align: center;"><liferay-ui:message key="portlet.quanlytaikhoan.thuoctinhxacminh"/></th>
								</tr>
							</thead>
							<tbody>
							<%
							if(listpt.size() == 0){
								%>
								<tr suffix=0>
									<td>1</td>
									<td></td>
									<td>
									<ul id="list-thuoc-tinh-xm-0">
									</ul>
									</td>
								</tr>
								<%
							}else{
								int sttnew = 1;
								for(Photo ptitcu:listpt){
									String messstr = ptitcu.getMessage();
									MessageObject messit = new Gson().fromJson(messstr, MessageObject.class);
									%>
									<tr suffix=<%= messit.getId() %>>
									<td><%= sttnew++ %></td>
									<td><input class="btn btn-link" onclick="viewimage1('<%=messit.getUrlfile() %>')" 
									type="button" id="TenGiayTo" value="<%=DanhMucLocalServiceUtil.getByM(messit.getLoaigt()).getTen()  %>"/></td>
									<td>
									<ul id="list-thuoc-tinh-xm-0">
									<%
									
									String[] listptdxm = messit.getThuoctinh();
									for(String pttt : listptdxm){
										%>
										<li><%= pttt %></li>
										<%
										
									}
									%>
									</ul>
									</td>
								</tr>
									<%
								}
							}
							%>
						</tbody>
					</table>
			</div>
				<div class="col-md-4" id="images" style="padding-left: 5px">
					<div class="text-right">
						<button type="button" class="btn btn-info" id="delete-image1" onclick="deleteimagef1();" style="cursor: pointer;">
				          <span class="glyphicon glyphicon-remove"></span><liferay-ui:message key="portlet.quanlytaikhoan.dong"/>
				        </button>
			        </div>
					<img onclick="viewfiledangky(this);" style="height: 100%;" id="infoimage1" alt="" src="" class="img-responsive" />
				</div>
		</div>
</form>
			<div class="row" style="margin-top: 10px">
						<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.tencanboxacminh"/></label>
						<input type="text" class="form-control" readonly="readonly" id="tencanboxacminh" name="tencanboxacminh" value="">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ngayxacminh"/></label>
						<input type="text" class="form-control" readonly="readonly" id="ngayxacminh" name="ngayxacminh" value="">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.tencanbopheduyet"/></label>
						<input type="text" class="form-control" readonly="readonly" id="tencanboxacminh" name="tencanboxacminh" value="">
				</div>
			</div>
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.lanxacminhthu"/></label>
						<input type="text" class="form-control" readonly="readonly" id="lanxacminh" name="lanxacminh" value="">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ngaypheduyet"/></label>
						<input type="text" class="form-control" readonly="readonly" id="ngaypheduyet" name="ngaypheduyet" value="">
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ykiencanboxacminh"/></label>
					<input type="text" class="form-control" id="ykiencanboxacminh"
										name="ykiencanboxacminh" value="<%=ykien.yKienCanBoXacMinh %>" readonly="readonly">
				</div>
			</div>
			<%-- <div class="col-md-12">
					<div class="form-group">
						<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ykiencanboxacminh"/></label>
							<input type="text" class="form-control" id="ykiencanboxacminh"
										name="ykiencanboxacminh" value="<%=ykien.yKienCanBoXacMinh %>" readonly="readonly">
					</div>
			</div> --%>
			<div class="col-md-12">
					<div class="form-group">
						<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ykiencanbopheduyet"/></label>
							<input type="text" class="form-control" id="ykiencanbopheduyet"
										name="ykiencanbopheduyet" value="<%=ykien.yKienCanBoPheDuyet %>" readonly="readonly">
					</div>
			</div>
	</div>
</div>
	<div class="container" style="background-color: white;">
		<div class="row" style="margin-bottom: 10px; text-align: right;">
			<div class="col-md-12">
				<button type="button" class="btn btn-primary" onClick="javascript: window.history.go(-1)"><liferay-ui:message key="portlet.quanlytaikhoan.dong"/></button>
			</div>
		</div>
	</div>
	
<div class="row">
<div class="col-md-12">

<!-- Modal -->
<div class="modal fade" style="display: none;" id="viewimagedangky" tabindex="-1" role="dialog" aria-labelledby="viewimagedangkymodal" aria-hidden="true">
  <div class="modal-dialog" role="document" style="position: relative !important;">
    <div class="modal-content">
      <div class="modal-header">
      </div>
      <div class="modal-body" id="imageshowdangkyxoay">
        <div class="row">
        	<div class="col-md-12">
        	 <img style="height: 500px" id="imageshowdangky" class="img-responsive" src="" /> 
        	</div>
        </div> 
      </div>
      <div class="modal-footer" style="text-align: right;">
      <button type="button" class="btn btn-primary" id="xoayhinhdangky">Xoay hình</button>
        <button type="button" class="btn btn-primary" onclick="closePopupAttributeimagedangky();"><liferay-ui:message key="portlet.quanlytaikhoan.dong"/></button>
       
      </div>
    </div>
  </div>
</div>
</div>

</div>

<script type="text/javascript">
function closePopupAttributeimagedangky() {
	$('#viewimagedangky').removeClass('show').addClass('hide');
}


$('#delete-image').hide();
$('#delete-image1').hide();

function viewimage(url){
	$('#delete-image').show();
	$('#infoimage').attr("src",url);
	
}
function viewimage1(url){
	$('#delete-image1').show();
	$('#infoimage1').attr("src",url);
	
}

function deleteimagef(){
	$('#delete-image').hide();
	$('#infoimage').attr("src",'');
}
function deleteimagef1(){
	$('#delete-image1').hide();
	$('#infoimage1').attr("src",'');
}
function viewfiledangky(item){
	gocquaydangky = 0;
	let src = $(item).attr("src");
	if(src != ""){
		$('#imageshowdangky').attr("src",src);
		$('#viewimagedangky').removeClass('fade').removeClass('hide').addClass('show');
	}
}

var gocquaydangky = 0;
$(document).ready(function(){
	 $('.showtooltip').tooltip();
	$('#xoayhinhdangky').click(function(){
		 gocquaydangky = gocquaydangky + 90;
	      $('#imageshowdangkyxoay').rotate(gocquaydangky);
	   });
});

/* //This function will show the image in the lightbox
var zoomImg = function () {
// Create evil image clone
var clone = this.cloneNode();
$(clone).attr("id","");
$(clone).attr("style","");
clone.classList.remove("img-responsive");

// Put evil clone into lightbox
var lb = document.getElementById("lb-img");
lb.innerHTML = "";
lb.appendChild(clone);

// Show lightbox
lb = document.getElementById("lb-back");
lb.classList.add("show");
};

window.addEventListener("load", function(){
// Attach on click events to all .zoomD images
var images = document.getElementsByClassName("img-responsive");
if (images.length>0) {
  for (var img of images) {
    img.addEventListener("click", zoomImg);
  }
}

// Click event to hide the lightbox
document.getElementById("lb-back").addEventListener("click", function(){
  this.classList.remove("show");
})
}); */

</script>