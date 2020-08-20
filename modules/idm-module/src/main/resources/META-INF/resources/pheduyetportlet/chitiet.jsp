<%@page import="dtt.vn.pheduyet.business.PheDuyetBusiness"%>
<%@page import="dtt.vn.pheduyet.business.ThuocTinhObject"%>
<%@page import="java.util.Map"%>
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
<%@page import="dtt.vn.account.util.QRUtils"%>
<%@page import="javax.xml.bind.DatatypeConverter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>	

<%@include file="/accountportlet/init.jsp" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<style type="text/css">
.error-input {
	border: 1px solid red;
}
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
Map<String,ThuocTinhObject> mapthuoctinh = PheDuyetBusiness.createObejctTT(account1,request);
byte[] qrCode = QRUtils.generateQRCodeImage(accountId+";"+account1.getAccountName(), 385, 276);
String base64qr = DatatypeConverter.printBase64Binary(qrCode);
%>

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
		<aui:form action="" method="" name="">
			
			<%
			if(account1.getAccountType() == PortletKeysUtil.LoaiDoiTuongKeys.Ca_Nhan){
			%>
				<div class="bg-trang">
			   		<div class="container">
			         	<h4 class="tle" style="font-weight: 600 !important;">
			         		<liferay-ui:message key="portlet.idmmodule.taikhoancanhancanpheduyet" />
						</h4>
			      	</div>
	   			</div>
	   			<div class="row">
					<div class="col-md-4" style="background-color: white;"> 
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.xacminh.danhsach.capdohientai"/></label>
									<input type="text" class="form-control" readonly="readonly" id="capdocanhientai" name="capdocanhientai" value="Cấp <%= account1.getIpLevel() %>">
							</div>
							<div class="form-group">
								<label  for="email"><liferay-ui:message key="portlet.quanlytaikhoan.tentaikhoan"/></label>
									<input type="text" class="form-control" id="<portlet:namespace/>tentaikhoan" name="<portlet:namespace/>tentaikhoan" readonly="readonly" value="<%= account1.getAccountName() %>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.xacminh.danhsach.sogiayto"/></label>
									<input type="text" class="form-control" readonly="readonly" id="sogiayto" name="sogiayto" value="<%= account1.getPersonalId() %>">
							</div>
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.hovaten"/></label>
									<input type="text" class="form-control" id="HoVaTen"
											name="HoVaTen" readonly="readonly" value="<%= account1.getFullName() %>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ngaysinh"/></label>
									<input type="text" class="form-control" readonly="readonly" id="ngaysinh" name="ngaysinh" value="<%=DateUtil.convertDateToString(account1.getBirthdate(),"dd/MM/yyyy")  %>">
							</div>
							<%-- <div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.quoctich"/></label>
								<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>quoctich" name="<portlet:namespace/>quoctich" value="<%=account1.getNationality()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.noicap"/></label>
								<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>noicap" name="<portlet:namespace/>noicap" value="<%=account1.getIssuedBy()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.sosohokhau"/></label>
								<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>sosohokhau" name="<portlet:namespace/>sosohokhau" value="<%=account1.getFamilyRegNo()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.hotenchuho"/></label>
								<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>hotenchuho" name="<portlet:namespace/>hotenchuho" value="<%=account1.getHeadHouseholdName()%>">
							</div> --%>
					</div>
					<div class="col-md-4" style="background-color: white;">
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.capdocanpheduyet"/></label>
									<input type="text" class="form-control" readonly="readonly" id="capdocanpheduyet" name="capdocanpheduyet" value="<liferay-ui:message key="portlet.quanlytaikhoan.cap3"/>">
							</div>
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.gioitinh"/></label>
									<input type="text" class="form-control" id="GioiTinh"
											name="GioiTinh" readonly="readonly" value='<%= (account1.getGender()== 0)?"Nữ":"Nam" %>'>
							</div>
							<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.email"/></label>
									<input type="Email" class="form-control" id="Email"
												name="Email" readonly="readonly" value="<%= account1.getEmail() %>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.sodienthoai"/></label>
									<input type="text" class="form-control" readonly="readonly" id="sodienthoai" name="sodienthoai" value="<%= account1.getTelNo() %>">
							</div>
							<%-- <div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.hotencha"/></label>
								<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>hotencha" name="<portlet:namespace/>hotencha" value="<%=account1.getFatherName()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.hotennguoigiamho"/></label>
								<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>hotennguoigiamho" name="<portlet:namespace/>hotennguoigiamho" value="<%=account1.getGuardianName()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.hotenme"/></label>
								<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>hotenme" name="<portlet:namespace/>hotenme" value="<%=account1.getMotherName()%>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.hotenvochong"/></label>
								<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>hotenvochong" name="<portlet:namespace/>hotenvochong" value="<%=account1.getSpouseName()%>">
							</div> --%>
					</div>
					<div class="col-md-4">
						<img src="data:image/png;base64, <%= base64qr %>" alt="" />
					</div>
				</div>
				
			<%		
			} else if(account1.getAccountType() == PortletKeysUtil.LoaiDoiTuongKeys.To_Chuc){
			%>
				<div class="bg-trang">
			   		<div class="container">
			         	<h4 class="tle" style="font-weight: 600 !important;">
			         		<liferay-ui:message key="portlet.idmmodule.taikhoantochuccanpheduyet" />
						</h4>
			      	</div>
	   			</div>
	   			<div class="row">
					<div class="col-md-4" style="background-color: white;">
						<div class="form-group">
							<label class="control-label" for="pwd"><liferay-ui:message key="portlet.xacminh.danhsach.capdohientai"/></label>
								<input type="text" class="form-control" readonly="readonly" id="capdocanhientai" name="capdocanhientai" value="Cấp <%= account1.getIpLevel() %>">
						</div>
						<div class="form-group">
								<label  for="email"><liferay-ui:message key="portlet.quanlytaikhoan.tentaikhoan"/></label>
									<input type="text" class="form-control" id="<portlet:namespace/>tentaikhoan" name="<portlet:namespace/>tentaikhoan" readonly="readonly" value="<%= account1.getAccountName() %>">
						</div>
						<div class="form-group">
							<label class="control-labe" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.tentochuc"/></label>
								<input type="text" class="form-control" id="hovaten" name="hovaten" readonly="readonly" value="<%= account1.getFullName() %>">
						</div>
						<div class="form-group">
							<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.cmndnguoidaidien"/></label>
								<input type="text" class="form-control" readonly="readonly" id="sogiayto" name="sogiayto" value="<%= account1.getPersonalId() %>">
						</div>
						<div class="form-group">
							<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.nguoidaidientochuc"/></label>
								<input type="text" class="form-control" readonly="readonly" id="nguoidaidien" name="nguoidaidien" value="<%= account1.getLegalDelegate() %>">
						</div>
						<%-- <div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.tochuccaptren"/></label>
								<input type="text" class="form-control" readonly="readonly" id="tochuccaptren" name="<portlet:namespace/>tochuccaptren" value="<%=account1.getSuperiorOrganization()%>">
						</div> --%>
					</div>
					<div class="col-md-4" style="background-color: white;">
						<div class="form-group">
							<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.capdocanpheduyet"/></label>
										<input type="text" class="form-control" readonly="readonly" id="capdocanpheduyet" name="capdocanpheduyet" value="<liferay-ui:message key="portlet.quanlytaikhoan.cap3"/>">
						</div>
						<div class="form-group">
							<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.email"/></label>
								<input type="Email" class="form-control" id="Email"
											name="Email" readonly="readonly" value="<%= account1.getEmail() %>">
						</div>
						<div class="form-group">
							<label for="email"><liferay-ui:message key="portlet.quanlytaikhoan.dienthoaididong"/></label>
								<input type="text" class="form-control" id="<portlet:namespace/>sodienthoai" name="<portlet:namespace/>sodienthoai" readonly="readonly" value="<%= account1.getTelNo() %>">
						</div>
						<div class="form-group">
								<label class="control-label" for="email"><liferay-ui:message key="portlet.quanlytaikhoan.masothue"/></label>
									<input type="text" class="form-control" id="masothue" name="masothue" readonly="readonly" value="<%= account1.getTaxCode() %>">
						</div>
						<%-- <div class="form-group">
							<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.sdtnguoidaidien"/></label>
								<input type="text" class="form-control" readonly="readonly" id="sodienthoai" name="sodienthoai" value="<%= account1.getRepresentativeTelNo() %>">
						</div> --%>
						<%-- <div class="form-group">
							<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.fax"/></label>
							<input type="text" class="form-control" readonly="readonly" id="fax" name="<portlet:namespace/>fax" value="<%=account1.getFax()%>">
						</div> --%>
					</div>
					<div class="col-md-4">
						<img src="data:image/png;base64, <%= base64qr %>" alt="" />
					</div>
				</div>
			<%	
			}
			%>
		</aui:form>
	</div>
<div class="container" style="background-color: white;">
	<div class="row">
		<div class="col-md-12">
				<%-- <div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.diachi"/></label>
					<div class="">
					<%
						String diaChiChiTiet =account1.getAddress()+"-"+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getWardCode()))
						.getTen()+"-"+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getDistrictCode())).
						getTen()+"-"+ DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getCityCode())).getTen();
					%>
						<input type="text" class="form-control" id="DiaChi"
								name="DiaChi" readonly="readonly" value="<%=diaChiChiTiet %>">
					</div>
				</div> --%>
				<div class="form-group">
						<%if(account1.getAccountType()==1){
						%>
							<label for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.diachi"/></label>
						<% 
						} else{
						%>
							<label for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.diachitrusotaivietnam"/></label>
						<%
						}
						%>
							<%
								String diaChiChiTiet =account1.getAddress()+" "+"-"+" "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getWardCode()))
								.getTen()+" "+"-"+" "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getDistrictCode())).
								getTen()+" "+"-"+" "+ DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account1.getCityCode())).getTen();
							%>
								<input type="text" class="form-control" id="<portlet:namespace/>diachitaikhoan" name="<portlet:namespace/>diachitaikhoan" readonly="readonly" value="<%=diaChiChiTiet %>">
				</div>
		</div>
	</div>
</div>
<%-- <div class="container" style="background-color: white;">
	<div class="bg-trang" style="font-weight: bold;">
		<div class="container">
			<h4 class="tle" style="font-weight: 600 !important;">
				<liferay-ui:message key="portlet.quanlytaikhoan.noixacminhthongtin"/>
			</h4>
		</div>
	</div>
</div>
<div class="container" style="background-color: white;">
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.noixacminh"/></label>
				<input type="text" class="form-control" id="<portlet:namespace/>noixacminh" name="<portlet:namespace/>noixacminh" readonly="readonly" value="">
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.buucuc"/></label>
				<input type="text" class="form-control" id="<portlet:namespace/>buucuc" name="<portlet:namespace/>buucuc" readonly="readonly" value="">
			</div>
		</div>
	</div>
</div>
<div class="container" style="background-color: white;">
	<div class="row">
		<div class="col-md-12">
				<div class="form-group">
					<label for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.diachixacminh"/></label>
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
					String diaChiChiTietXM = account1.getAddressXM()+" "+"-"+" "+wardXM+" "+"-"+" "+districtXM+" "+"-"+" "+cityXM;
				    %>
					<input type="text" class="form-control" id="<portlet:namespace/>diachitaikhoan" name="<portlet:namespace/>diachitaikhoan" readonly="readonly" value="<%=diaChiChiTietXM %>">
				</div>
		</div>
	</div>
</div> --%>

<%-- <div class="container" style="background-color: white;">
	<div class="bg-trang">
		<div class="container">
			<h4 class="tle" style="font-weight: 600 !important;">
				<liferay-ui:message key="portlet.quanlytaikhoan.danhsachtailieudikemdangky"/>
			</h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6" style="height: 200px; overflow: auto; ">
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
		</div>
</div> --%>
<div class="container" style="background-color: white;">
	<div class="bg-trang">
		<div class="container">
			<h4 class="tle" style="font-weight: 600 !important;">
				Kết quả xác minh
			</h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			
		</div>
		<div class="col-md-4">
			<div>Kiểm tra CSDL xác minh:<b id="status-xm">
			<%
			if(account1.getIdDBXM() == 1){
				%>
				Đã có
				<%
			}else if(account1.getIdDBXM() == 2){
				%>
				Không có
				<%
			}
			%>
			</b></div>
		</div>
	</div>
	</div>
	<portlet:actionURL name="actionPheDuyet" var="actionPheDuyettURL">
	</portlet:actionURL>
	<form action="<%= actionPheDuyettURL %>" method="POST" id="form-pheduyet" enctype="multipart/form-data">
<div class="container" style="background-color: white;">
	<div class="bg-trang">
		<div class="container">
			<h4 class="tle" style="font-weight: 600 !important;">
				<liferay-ui:message key="portlet.quanlytaikhoan.tailieudinhkemxacminh"/>
			</h4>
		</div>
	</div>
	
	
		<input type="hidden" name="<portlet:namespace/>acid" id="<portlet:namespace/>acid" value="<%= accountId %>"/>
		<input type="hidden" name="<portlet:namespace/>pheduyet" id="<portlet:namespace/>pheduyet" value=""/>
	<div class="row">
		<div class="col-md-8" style="height: 300px; overflow: auto; ">
					<table class="table table-bordered">
							<thead>
								<tr>
									<th class="" style="text-align: center;width: 10px;"><liferay-ui:message key="portlet.quanlytaikhoan.stt"/></th>
									<th class="" style="text-align: center;width: 30px;"><liferay-ui:message key="portlet.quanlytaikhoan.tengiayto"/></th>
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
									type="button" id="TenGiayTo" value="<%=DanhMucLocalServiceUtil.getByM(messit.getLoaigt()) == null?"Loại giấy tờ đã bị xóa":DanhMucLocalServiceUtil.getByM(messit.getLoaigt()).getTen() %>"/></td>
									<td>
									<ul id="list-thuoc-tinh-xm-0" style="padding-left: 10px;">
									<%
									
									String[] listptdxm = messit.getThuoctinh();
									String[] keyAttr = messit.getAttrkey();
									for(int i = 0; i < listptdxm.length;i++){
										%>
										<li><b><%= listptdxm[i] %></b>:  <%= PheDuyetBusiness.getnameandvaluett(mapthuoctinh, keyAttr[i]).giatrithuoctinh %></li>
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
		        <div class="text-center">
		        <img style="width: 100%;" id="infoimage1" onclick="viewfiledangky(this);" alt="" src="" class="img-responsive" />
		        </div>
				
			</div>
		</div>
	
</div>
<div class="container" style="background-color: white;">
	<div class="row" style="margin-top: 10px">
			<div class="col-md-12">
					<div class="form-group">
						<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ykiencanboxacminh"/></label>
							<input type="text" class="form-control" id="ykiencanboxacminh"
										name="<portlet:namespace/>ykiencanboxacminh" value="<%=ykien.yKienCanBoXacMinh %>" readonly="readonly">
					</div>
			</div>
	</div>
	<div class="row" style="margin-top: 10px">
			<div class="col-md-12">
					<div class="form-group">
						<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ykiencanbopheduyet"/></label>
							<input type="text" class="form-control" id="ykiencanbopheduyet"
										name="<portlet:namespace/>ykiencanbopheduyet" value="<%=ykien.yKienCanBoPheDuyet %>" required="required">
					</div>
			</div>
	</div>
</div>
</form>
	<div class="container" style="background-color: white;">
		<div class="row" style="margin-bottom: 10px; text-align: right;">
			<div class="col-md-12">
			<%
			if(account1.getAccountStatus() == PortletKeysUtil.TrangThaiKeys.Cap_Chung_Nhan_Dinh_Danh){
				
			}else{
				%>
				<button type="button" class="btn btn-primary" onclick="pheduyet(0)"><liferay-ui:message key="portlet.quanlytaikhoan.tuchoi"/></button>
				<button type="button" class="btn btn-primary" onclick="pheduyet(1)"><liferay-ui:message key="portlet.quanlytaikhoan.dongy"/></button>
				<%
			}
			%>
				
				<button type=button class="btn btn-primary" onClick="javascript: window.history.go(-1)"><liferay-ui:message key="portlet.quanlytaikhoan.dong"/></button>
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
function viewfiledangky(item){
	gocquaydangky = 0;
	let src = $(item).attr("src");
	if(src != ""){
		$('#imageshowdangky').attr("src",src);
		$('#viewimagedangky').removeClass('fade').removeClass('hide').addClass('show');
	}
}

<%-- function pheduyet(index){
	var ykiencanbo = $('#ykiencanbopheduyet').val().trim();
	if(index == 0 && ykiencanbo == ''){
		$('#ykiencanbopheduyet').addClass('error-input');
		return;
	}
	
	$('#<portlet:namespace/>pheduyet').val(index);
	if(index == 1){
		if(!confirm("<liferay-ui:message key='portlet.quanlytaikhoan.dongycapchungdanh'/> : <%= account1.getAccountName() %> ?")){
			return;
		}
	}
	else if(index == 0){
		if(!confirm("<liferay-ui:message key='portlet.quanlytaikhoan.tuchoicapchungnhan'/> : <%= account1.getAccountName() %> ?")){			return;
		}

	}
	$('#form-pheduyet').submit();
} --%>
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
var gocquaydangky = 0;
$(document).ready(function(){
	 $('.showtooltip').tooltip();
	$('#xoayhinhdangky').click(function(){
		 gocquaydangky = gocquaydangky + 90;
	      $('#imageshowdangkyxoay').rotate(gocquaydangky);
	   });
});

function pheduyet(ind){
	var ykiencanbo = $('#ykiencanbopheduyet').val().trim();
	if(ind == 0 && ykiencanbo == ''){
		$('#ykiencanbopheduyet').addClass('error-input');
		return;
	}
	$('#<portlet:namespace/>pheduyet').val(ind);
	var titlecomfim = "Xác nhận";
	var content = "";
	if(ind == 0){
		content = "<liferay-ui:message key='portlet.quanlytaikhoan.tuchoicapchungnhan'/> : <%= account1.getAccountName() %> ?"
	}else if(ind == 1){
		content = "<liferay-ui:message key='portlet.quanlytaikhoan.dongycapchungdanh'/> : <%= account1.getAccountName() %> ?"
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
	            	$('#form-pheduyet').submit();
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