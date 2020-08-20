<%@page import="dtt.vn.xacminh.business.YkienCanBoObject"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="dtt.vn.xacminh.business.MessageObject"%>
<%@page import="dtt.vn.vnpost.service.PhotoLocalServiceUtil"%>
<%@page import="dtt.vn.vnpost.service.AccountLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="dtt.vn.account.util.PortletKeysUtil"%>
<%@page import="dtt.vn.account.business.Constantes"%>
<%@page import="dtt.vn.account.util.AccountEnum"%>
<%@page import="dtt.vn.account.util.DateUtil"%>
<%@page import="dtt.vn.account.business.IConstants"%>
<%@page import="dtt.vn.vnpost.model.Photo"%>
<%@page import="dtt.vn.vnpost.service.DanhMucLocalServiceUtil"%>
<%@page import="dtt.vn.vnpost.model.DanhMuc"%>
<%@page import="dtt.vn.vnpost.model.Account"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="dtt.vn.account.util.QRUtils"%>
<%@page import="javax.xml.bind.DatatypeConverter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>	

<%@include file="/xacminhportlet/init.jsp" %>

<%
String backurl = ParamUtil.getString(request, "backurl","");
long accountId = ParamUtil.getLong(request, "accountIdsend");
Account account1 = AccountLocalServiceUtil.fetchAccount(accountId);
List<DanhMuc> listGiayTo = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc("DMDC_LGT", 1, true);


List<Photo> listpt1 = PhotoLocalServiceUtil.getPhotosbyImageType_classPK(0, accountId, -1, -1);
List<Photo> listpt = PhotoLocalServiceUtil.getPhotosbyImageType_classPK(1, accountId, -1, -1);
YkienCanBoObject ykien = new YkienCanBoObject();
String messageykien = account1.getMessage();
if(messageykien!= null && !messageykien.equals("")){
	ykien = new Gson().fromJson(messageykien, YkienCanBoObject.class);
}
byte[] qrCode = QRUtils.generateQRCodeImage(accountId+";"+account1.getAccountName(), 385, 276);
String base64qr = DatatypeConverter.printBase64Binary(qrCode);
   
%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<!-- <script type="text/javascript" src="https://raw.githubusercontent.com/wilq32/jqueryrotate/master/jQueryRotate.js"></script> -->

<style type="text/css">
#top-box input {
	height: 28px;
}

.td-border {
	padding: 0px;
	margin: 0px;
}

/* #table-box input {
	height: 28px;
} */
.backgroud-body{
background-color: white;
}
.error-cl {
	border: 1px solid red;
}
body{
overflow-x : hidden;
}
</style>
<style>
.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 120px;
  height: 120px;
  -webkit-animation: spin 2s linear infinite; /* Safari */
  animation: spin 2s linear infinite;
  margin: 0px auto;
}

/* Safari */
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
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
<c:if test='<%= ParamUtil.getBoolean(request, "requestSuccess") %>'>
	<script type="text/javascript">	
		Liferay.Util.getOpener().reload();
	</script>
</c:if>
			<%
			if(account1.getAccountType() == PortletKeysUtil.LoaiDoiTuongKeys.Ca_Nhan){
			%>
			<div class="container backgroud-body">
				<div class="bg-trang">
			         <h4 class="tle" style="font-weight: 600 !important;">
			         	<liferay-ui:message key="portlet.idmmodule.thongtincanhancanxacminh" />
					</h4>
			    </div>
		   </div>
		   <div class="container backgroud-body">
				<div class="row">
					<div class="col-md-4">
						<form class="">
							<div class="form-group">
								<label for="email"><liferay-ui:message key="portlet.xacminh.danhsach.capdohientai"/></label>
									<input type="text" class="form-control" id="<portlet:namespace/>capdohientai"
											name="<portlet:namespace/>capdohientai" readonly="readonly" value="Cấp <%=account1.getIpLevel()%>">
							</div>
							<div class="form-group">
								<label  for="email"><liferay-ui:message key="portlet.quanlytaikhoan.tentaikhoan"/></label>
									<input type="text" class="form-control" id="<portlet:namespace/>tentaikhoan" name="<portlet:namespace/>tentaikhoan" readonly="readonly" value="<%= account1.getAccountName() %>">
							</div>
							<div class="form-group">
								<label for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.socmnd"/></label>
								<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>sogiayto" name="<portlet:namespace/>sogiayto" value="<%= account1.getPersonalId() %>">
							</div>
							<div class="form-group">
								<label  for="email"><liferay-ui:message key="portlet.quanlytaikhoan.hovaten"/></label>
									<input type="text" class="form-control" id="<portlet:namespace/>hovaten" name="<portlet:namespace/>hovaten" readonly="readonly" value="<%= account1.getFullName() %>">
							</div>
							<div class="form-group">
								<label for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ngaysinh"/></label>
									<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>ngaysinh" name="<portlet:namespace/>ngaysinh" value="<%=DateUtil.convertDateToString(account1.getBirthdate(),"dd/MM/yyyy")  %>">
							</div>
							<%-- <div class="form-group">
								<label for="email"><liferay-ui:message key="portlet.quanlytaikhoan.ngaycap"/></label>
									<input type="text" class="form-control" id="<portlet:namespace/>ngaycap"
											name="<portlet:namespace/>ngaycap" readonly="readonly" value='<%= DateUtil.convertDateToString(account1.getRangeDate(),"dd/MM/yyyy")%>'>
							</div>
							<div class="form-group">
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
						</form>
					</div>
					<div class="col-md-4">
						<form class="">
							<div class="form-group">
								<label for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.capdocanxacminh"/></label>
								<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>capdocanxacminh" name="<portlet:namespace/>capdocanxacminh" value="<liferay-ui:message key="portlet.quanlytaikhoan.cap3"/>">
							</div>
							<div class="form-group">
								<label for="email"><liferay-ui:message key="portlet.quanlytaikhoan.gioitinh"/></label>
									<input type="text" class="form-control" id="<portlet:namespace/>gioitinh"
											name="<portlet:namespace/>gioitinh" readonly="readonly" value='<%= (account1.getGender()== 0)?"Nữ":"Nam" %>'>
							</div>
							<div class="form-group">
								<label  for="email"><liferay-ui:message key="portlet.quanlytaikhoan.email"/></label>
								<input type="Email" class="form-control" id="<portlet:namespace/>email"
												name="<portlet:namespace/>email" readonly="readonly" value="<%= account1.getEmail() %>">
							</div>
							<div class="form-group">
								<label for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.sodienthoai"/></label>
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
						</form>
					</div>
					<div class="col-md-4">
						<img src="data:image/png;base64, <%= base64qr %>" alt="" />
					</div>
				</div>
			</div>
				
			<%		
			} else if(account1.getAccountType() == PortletKeysUtil.LoaiDoiTuongKeys.To_Chuc){
			%>
			<div class="container backgroud-body">
				<div class="bg-trang">
		         	<h4 class="tle" style="font-weight: 600 !important;">
		         		<liferay-ui:message key="portlet.idmmodule.thongtintochuccanxacminh" />
					</h4>
		      	</div>
		   	</div>
		   	<div class="container backgroud-body">
				<div class="row">
					<div class="col-md-4">
						<form class="">
							<div class="form-group">
								<label for="pwd"><liferay-ui:message key="portlet.xacminh.danhsach.capdohientai"/></label>
									<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>capdocanhientai" name="<portlet:namespace/>capdocanhientai" value="Cấp <%=account1.getIpLevel()%>">
							</div>
							<div class="form-group">
								<label  for="email"><liferay-ui:message key="portlet.quanlytaikhoan.tentaikhoan"/></label>
									<input type="text" class="form-control" id="<portlet:namespace/>tentaikhoan" name="<portlet:namespace/>tentaikhoan" readonly="readonly" value="<%= account1.getAccountName() %>">
							</div>
							<div class="form-group">
								<label for="email"><liferay-ui:message key="portlet.quanlytaikhoan.tentochuc"/></label>
									<input type="text" class="form-control" id="HoVaTen"
											name="HoVaTen" readonly="readonly" value="<%= account1.getFullName() %>">
							</div>
							<div class="form-group">
								<label  for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.cmndnguoidaidien"/></label>
									<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>sogiayto" name="<portlet:namespace/>sogiayto" value="<%= account1.getPersonalId() %>">
							</div>
							<div class="form-group">
								<label for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.nguoidaidientochuc"/></label>
									<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>nguoidaidien" name="<portlet:namespace/>nguoidaidien" value="<%= account1.getLegalDelegate() %>">
							</div>
							<%-- <div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.tochuccaptren"/></label>
								<input type="text" class="form-control" readonly="readonly" id="tochuccaptren" name="<portlet:namespace/>tochuccaptren" value="<%=account1.getSuperiorOrganization()%>">
							</div> --%>
						</form>
					</div>
					<div class="col-md-4">
						<form class="">
							<div class="form-group">
								<label  for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.capdocanxacminh"/></label>
									<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>capdocanxacminh" name="<portlet:namespace/>capdocanxacminh" value="<liferay-ui:message key="portlet.quanlytaikhoan.cap3"/>">
							</div>
							<div class="form-group">
								<label  for="email"><liferay-ui:message key="portlet.quanlytaikhoan.email"/></label>
									<input type="text" class="form-control" id="<portlet:namespace/>email"
												name="<portlet:namespace/>email" readonly="readonly" value="<%= account1.getEmail() %>">
							</div>
							<div class="form-group">
								<label for="email"><liferay-ui:message key="portlet.quanlytaikhoan.dienthoaididong"/></label>
									<input type="text" class="form-control" id="<portlet:namespace/>sodienthoai"
											name="<portlet:namespace/>sodienthoai" readonly="readonly" value="<%= account1.getTelNo() %>">
							</div>
							<div class="form-group">
								<label for="email"><liferay-ui:message key="portlet.quanlytaikhoan.masothue"/></label>
									<input type="GioiTinh" class="form-control" id="<portlet:namespace/>masothue"
											name="<portlet:namespace/>masothue" readonly="readonly" value="<%= account1.getTaxCode() %>">
							</div>
							<%-- <div class="form-group">
								<label  for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.sdtnguoidaidien"/></label>
									<input type="text" class="form-control" readonly="readonly" id="<portlet:namespace/>sodienthoai" name="<portlet:namespace/>sodienthoai" value="<%= account1.getRepresentativeTelNo() %>">
							</div>
							<div class="form-group">
								<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.fax"/></label>
								<input type="text" class="form-control" readonly="readonly" id="fax" name="<portlet:namespace/>fax" value="<%=account1.getFax()%>">
							</div> --%>
						</form>
					</div>
					<div class="col-md-4">
						<img src="data:image/png;base64, <%= base64qr %>" alt="" />
					</div>
				</div>
			</div>
			<%	
			}
			%>
		
		<div class="container backgroud-body">
			<div class="row">
				<div class="col-md-12">
					<form class="">
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
					</form>
				</div>
			</div>
		</div>
		<%-- <div class="container backgroud-body">
			<div class="bg-trang" style="font-weight: bold;">
				<h4 class="tle" style="font-weight: 600 !important;">
					<liferay-ui:message key="portlet.quanlytaikhoan.noixacminhthongtin"/>
				</h4>
			</div>
		</div>
		<div class="container backgroud-body">
			<div class="row">
				<div class="col-md-6">
					<form class="">
						<div class="form-group">
							<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.noixacminh"/></label>
							<input type="text" class="form-control" id="<portlet:namespace/>noixacminh" name="<portlet:namespace/>noixacminh" readonly="readonly" value="">
						</div>
					</form>
				</div>
				<div class="col-md-6">
					<form class="">
						<div class="form-group">
							<label class="control-label" for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.buucuc"/></label>
							<input type="text" class="form-control" id="<portlet:namespace/>buucuc" name="<portlet:namespace/>buucuc" readonly="readonly" value="">
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="container backgroud-body">
			<div class="row">
				<div class="col-md-12">
					<form class="">
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
								<input type="text" class="form-control" id="<portlet:namespace/>diachitaikhoanXM" name="<portlet:namespace/>diachitaikhoanXM" readonly="readonly" value="<%=diaChiChiTietXM %>">
						</div>
					</form>
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
									type="button" id="TenGiayTo" value="<%=DanhMucLocalServiceUtil.getByM(messit.getLoaigt())== null?"":DanhMucLocalServiceUtil.getByM(messit.getLoaigt()).getTen()%>"/></td>
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
		        <div id="lb-back">
      				<div id="lb-img"></div>
    			</div>
				<img style="height: 300px" onclick="viewfiledangky(this);" id="infoimage" alt="" src="" class="img-responsive" />
			</div>
		</div>
</div> --%>
<div class="container backgroud-body">
	<div class="row">
		<div class="col-md-12">
		<div class="bg-trang" style="font-weight: bold;">
			<h4 class="tle" style="font-weight: 600 !important;">
					Kết quả xác minh
			</h4>
		</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<button class="btn btn-info" onclick="openmodalcsdlxacminh();">Kiểm tra CSDL xác minh</button>
		</div>
		<div class="col-md-4">
			<div>Kết quả kiểm tra trong CSDL xác minh:<b id="status-xm">
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
<div class="container backgroud-body">
		<div class="bg-trang" style="font-weight: bold;">
			<h4 class="tle" style="font-weight: 600 !important;">
				<liferay-ui:message key="portlet.quanlytaikhoan.tailieudinhkemxacminh"/>
			</h4>
		</div>
	<portlet:actionURL name="actionMethodXacminh" var="actionMethodXacminhURL">
	<portlet:param name="returnpath" value="<%=backurl%>" />
	</portlet:actionURL>
	<portlet:actionURL name="actionMethodInBienban" var="actionMethodInBienbanURL">
	</portlet:actionURL>
	<div class="row">
	<div class="col-md-12">
	<form action="<%= actionMethodXacminhURL %>" method="POST" id="form-xacminh" enctype="multipart/form-data">
		<input type="hidden" name="<portlet:namespace/>jsonthongtin" id="<portlet:namespace/>jsonthongtin" />
		<input type="hidden" name="<portlet:namespace/>acid" id="<portlet:namespace/>acid" value="<%= accountId %>"/>
		<input type="hidden" name="<portlet:namespace/>luutam" id="<portlet:namespace/>luutam" value=""/>
		<%
		long idcsxm = account1.getIdDBXM() < 0?0:account1.getIdDBXM();
		%>
		<input type="hidden" name="<portlet:namespace/>cocsxm" id="<portlet:namespace/>cocsxm" value="<%=idcsxm %>"/>
		<div id="table-box">
			<table class="table table-bordered" id="tb-xacminh"
				style="border-collapse: inherit !important">
				<thead>
					<tr style="text-align: center;">
						<th style="text-align: center;" class="" style="font-weight: bold;"><liferay-ui:message key="portlet.quanlytaikhoan.stt"/></th>
						<th style="text-align: center;" class="" style="font-weight: bold;"><liferay-ui:message key="portlet.quanlytaikhoan.loaigiayto"/></th>
						<th style="text-align: center;" class="" style="font-weight: bold;"><liferay-ui:message key="portlet.quanlytaikhoan.thuoctinhxacminh"/></th>
						<th style="text-align: center;" class="" style="font-weight: bold;"><liferay-ui:message key="portlet.quanlytaikhoan.teptindinhkem"/></th>
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
						    <select class="form-control" onchange="changeloaigiayto(0);" id="LoaiGiayTo0">
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
						
						<input id="thuoctinh0" type="button" class="btn btn-primary"  onclick="openThuocTinh(0)" value="<liferay-ui:message key="portlet.quanlytaikhoan.thuoctinh"/>" />
						<ul id="list-thuoc-tinh-xm-0" style="text-align: left;">
						</ul>
						</td>
						<td><input class="btn btn-default" type="file" id="filexacminhdinhkem-0" name="filexacminhdinhkem-0" accept="image/*,application/pdf"/>
						<input type="hidden" id="url-image-0" name="<portlet:namespace/>url-image-0" value="" />
						</td>
						<td></td>
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
						<td>
							 <select class="form-control" onchange="changeloaigiayto(<%= messit.getId() %>);" id="LoaiGiayTo<%= messit.getId() %>">
							 <option value=""><liferay-ui:message key="portlet.quanlytaikhoan.chongiayto"/></option>
						      <%
						      for(DanhMuc ptDanhMuc : listGiayTo){
						    	 if(ptDanhMuc.getMa().equals(messit.getLoaigt()) ){
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
						<td style="text-align: center;">
							
							<input type="button" id="thuoctinh<%= messit.getId() %>" class="btn btn-primary" onclick="openThuocTinh(<%= messit.getId() %>)" value="<liferay-ui:message key="portlet.quanlytaikhoan.thuoctinh"/>" />
						<ul id="list-thuoc-tinh-xm-<%= messit.getId() %>" style="text-align: left;">
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
						<td><input onchange="changeimage(<%= messit.getId() %>);" accept="image/*,application/pdf" class="btn btn-default" type="file" id="filexacminhdinhkem-<%= messit.getId() %>" name="filexacminhdinhkem-<%= messit.getId() %>"/>
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
		<div style="margin-top: 15px">
			<div >
					<div class="form-group">
						<label for="pwd"><liferay-ui:message key="portlet.quanlytaikhoan.ykiencanboxacminh"/></label>
							<input type="text" class="form-control" id="<portlet:namespace/>ykiencanboxacminh"
										name="<portlet:namespace/>ykiencanboxacminh" value="<%= ykien.yKienCanBoXacMinh %>">
					</div>
			</div>
		</div>
		
		<div class="row" style="margin-top: 15px">
			<div class="col-md-12 text-right">
				<input type="button" class="btn btn-primary" onclick="downloadBienban();" value="<liferay-ui:message key="portlet.quanlytaikhoan.inphieudangky"/>"/>
				<button type="button" class="btn btn-primary" onclick="luutam(0);"><liferay-ui:message key="portlet.quanlytaikhoan.tamluu"/></button>
				<button type="button" class="btn btn-primary" onclick="luutam(1);"><liferay-ui:message key="portlet.quanlytaikhoan.xacminhdung"/></button>
				<button type="button" class="btn btn-primary" onclick="luutam(2);"><liferay-ui:message key="portlet.quanlytaikhoan.xacminhsai"/></button>
				<button type="button" class="btn btn-primary" onclick="window.history.back();"><liferay-ui:message key="portlet.quanlytaikhoan.dong"/></button>
			</div>
		</div>
	</form>
	</div>
	</div>
</div>
<div class="row">
<div class="col-md-12">

<!-- Modal -->
<div class="modal fade" style="display: none;" id="thuoctinhmodel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document" style="position: relative !important;">
    <div class="modal-content" style="width: 500px;">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><liferay-ui:message key="portlet.quanlytaikhoan.cacthuoctinhxacminh"/></h5>
        <button type="button" class="close" data-dismiss="modal" onclick="closePopupAttribute();" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="row">
        	<div class="col-md-5">
        	<input type="hidden" id="suffopen" value="" />
        	<div class="checkbox">
			  <label><input name="listthuoctinh" dataatr="hoten" type="checkbox" value="<liferay-ui:message key="portlet.quanlytaikhoan.hovaten"/>"><liferay-ui:message key="portlet.quanlytaikhoan.hovaten"/></label>
			</div>
			<div class="checkbox">
			  <label><input name="listthuoctinh" dataatr="ngaysinh" type="checkbox" value="<liferay-ui:message key="portlet.quanlytaikhoan.ngaysinh"/>"><liferay-ui:message key="portlet.quanlytaikhoan.ngaysinh"/></label>
			</div>
			<div class="checkbox ">
			  <label><input name="listthuoctinh" dataatr="gioitinh" type="checkbox" value="<liferay-ui:message key="portlet.quanlytaikhoan.gioitinh"/>" ><liferay-ui:message key="portlet.quanlytaikhoan.gioitinh"/></label>
			</div>
			<div class="checkbox ">
			  <label><input name="listthuoctinh" dataatr="cmnd" type="checkbox" value="<liferay-ui:message key="portlet.quanlytaikhoan.socmndtt"/>"><liferay-ui:message key="portlet.quanlytaikhoan.socmndtt"/></label>
			</div>
			<div class="checkbox ">
			  <label><input name="listthuoctinh" dataatr="cccd" type="checkbox" value="<liferay-ui:message key="portlet.quanlytaikhoan.socccd"/>"><liferay-ui:message key="portlet.quanlytaikhoan.socccd"/></label>
			</div>
			<div class="checkbox ">
			  <label><input name="listthuoctinh" dataatr="sohochieu" type="checkbox" value="<liferay-ui:message key="portlet.quanlytaikhoan.sohochieu"/>"><liferay-ui:message key="portlet.quanlytaikhoan.sohochieu"/></label>
			</div>
			<div class="checkbox ">
			  <label><input name="listthuoctinh" dataatr="tentochuc" type="checkbox" value="<liferay-ui:message key="portlet.quanlytaikhoan.tentochuc"/>"><liferay-ui:message key="portlet.quanlytaikhoan.tentochuc"/></label>
			</div>
        	</div>
        	<div class="col-md-7">
        	<div class="checkbox">
			  <label><input name="listthuoctinh" dataatr="diachithuongtru" type="checkbox" value="<liferay-ui:message key="portlet.quanlytaikhoan.diachithuongtru"/>"><liferay-ui:message key="portlet.quanlytaikhoan.diachithuongtru"/></label>
			</div>
			<div class="checkbox">
			  <label><input name="listthuoctinh" dataatr="diachihientai" type="checkbox" value="<liferay-ui:message key="portlet.quanlytaikhoan.diachihientai"/>"><liferay-ui:message key="portlet.quanlytaikhoan.diachihientai"/></label>
			</div>
			<div class="checkbox ">
			  <label><input name="listthuoctinh" dataatr="masothuetochuc" type="checkbox" value="<liferay-ui:message key="portlet.quanlytaikhoan.masothuetochuc"/>"><liferay-ui:message key="portlet.quanlytaikhoan.masothuetochuc"/></label>
			</div>
			<div class="checkbox ">
			  <label><input name="listthuoctinh" dataatr="nguoidaidientochuc" type="checkbox" value="<liferay-ui:message key="portlet.quanlytaikhoan.nguoidaidientochuc"/>"><liferay-ui:message key="portlet.quanlytaikhoan.nguoidaidientochuc"/></label>
			</div>
			<div class="checkbox ">
			  <label><input name="listthuoctinh" dataatr="cmndnguoidaidien" type="checkbox" value="<liferay-ui:message key="portlet.quanlytaikhoan.socmndnguoidaidien"/>"><liferay-ui:message key="portlet.quanlytaikhoan.socmndnguoidaidien"/></label>
			</div>
			<div class="checkbox ">
			  <label><input name="listthuoctinh" dataatr="cccdnguoidaidien" type="checkbox" value="<liferay-ui:message key="portlet.quanlytaikhoan.socccdnguoidaidien"/>"><liferay-ui:message key="portlet.quanlytaikhoan.socccdnguoidaidien"/></label>
			</div>
        	</div>
        </div> 
      </div>
      <div class="modal-footer" style="text-align: right;">
       <button type="button" class="btn btn-primary" onclick="luuthuoctinhxacminh();"><liferay-ui:message key="portlet.quanlytaikhoan.dongy"/></button>
        <button type="button" class="btn btn-primary" onclick="closePopupAttribute();"><liferay-ui:message key="portlet.quanlytaikhoan.dong"/></button>
       
      </div>
    </div>
  </div>
</div>
</div>
</div>
<div class="row">
<div class="col-md-12">

<!-- Modal -->
<div class="modal fade" style="display: none;" id="viewimage" tabindex="-1" role="dialog" aria-labelledby="viewimagemodal" aria-hidden="true">
  <div class="modal-dialog" role="document" style="position: relative !important;">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id=""></h5>
        <button type="button" class="close" data-dismiss="modal" onclick="closePopupAttributeimage();" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="imageshowxoay">
        <div class="row">
        	<div class="col-md-12">
        	<input type="hidden" id="indeximage" />
        	 <img style="height: 500px" id="imageshow" class="img-responsive" src="" /> 
        	</div>
        </div> 
      </div>
      <div class="modal-footer" style="text-align: right;">
      <button type="button" class="btn btn-primary" id="xoayhinh">Xoay hình</button>
       <button type="button" class="btn btn-primary" onclick="removeimage();"><liferay-ui:message key="portlet.quanlytaikhoan.xoa"/></button>
        <button type="button" class="btn btn-primary" onclick="closePopupAttributeimage();"><liferay-ui:message key="portlet.quanlytaikhoan.dong"/></button>
       
      </div>
    </div>
  </div>
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


<div class="row">
<div class="col-md-12">

<!-- Modal -->
<div class="modal fade" style="display: none;" id="viewcsdlxacminh" tabindex="-1" role="dialog" aria-labelledby="viewcsdlxacminhmodal" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document" style="position: relative !important;">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id=""><b>KẾT QUẢ KIỂM TRA CƠ SỞ DỮ LIỆU XÁC MINH</b></h4>
       <!--  <button type="button" class="close" data-dismiss="modal" onclick="closePopupAttributeimage();" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button> -->
      </div>
      <div class="modal-body">
      <div class="row">
      	<div class="col-md-12 bg-trang">
			<h4>Thông tin kiểm tra</h4>
      	</div>
      </div>
        <div class="row">
        	<div class="col-md-6">
        		<div class="form-group">
				    <label for="email">Họ tên</label>
				    <input readonly="readonly" type="text" class="form-control" value="<%= account1.getFullName() %>" id="hotenxm">
				  </div>
				  <div class="form-group">
				    <label for="email">Hộ chiếu</label>
				    <input readonly="readonly" type="text" class="form-control" id="hochieuxm">
				  </div>
				  <div class="form-group">
				    <label for="email">Mã số thuế</label>
				    <input readonly="readonly" type="text" class="form-control" value="<%= account1.getTaxCode() %>" id="masothuexm">
				  </div>
				  <div class="form-group">
				    <label for="email">Điện thoại</label>
				    <input readonly="readonly" type="text" class="form-control" value="<%= account1.getTelNo() %>" id="dienthoaixm">
				  </div>
        	
        	</div>
        	<div class="col-md-6">
        	<div class="form-group">
				    <label for="email">Chứng minh nhân dân</label>
				    <input readonly="readonly" type="text" class="form-control" value="<%= account1.getPersonalId() %>" id="cmndxm">
				  </div>
				  <div class="form-group">
				    <label for="email">Căn cước công dân</label>
				    <input readonly="readonly" type="text" class="form-control" id="cccdxm">
				  </div>
				  <div class="form-group">
				    <label for="email">Số bằng lái xe</label>
				    <input readonly="readonly" type="text" class="form-control" id="soblxxm">
				  </div>
				  <div class="form-group">
				    <label for="email">Mã số bảo hiểm</label>
				    <input readonly="readonly" type="text" class="form-control" id="msbhxm">
				  </div>
        	
        	</div>
        </div> 
        <div class="row">
      	<div class="col-md-12 bg-trang">
			<h4>Thông tin tìm được trong CSDL xác minh</h4>
      	</div>
      </div>
        <div class="row">
        	<div class="col-md-12">
        		<table id="table-xacminh" class="table table-bordered">
				  <thead>
				    <tr>
				      <th scope="col">STT</th>
				      <th scope="col">Chọn</th>
				      <th scope="col">Họ tên</th>
				      <th scope="col">CMND/CCCD</th>
				       <th scope="col">Hộ chiếu</th>
				      <th scope="col">Giấy phép lái xe</th>
				      <th scope="col">Mã số thuế</th>
				      <th scope="col">Số bảo hiểm</th>
				      <th scope="col">Số điện thoại</th>
				    </tr>
				  </thead>
				  <tbody>
				  </tbody>
				</table>
        	</div>
        </div>
        <div class="row" id="process-id">
        	<div class="col-md-12">
        	<div style="text-align: center;font-size: 16px;">Đang kiểm tra trong CSDL xác minh. Vui lòng đợi.</div>
        	<div class="loading-icon linear loading-icon-lg"></div>
        	</div>
        </div>
      </div>
      <div class="modal-footer" style="text-align: right;">
      <button id="btn-co" type="button" class="btn btn-primary">Có</button>
        <button id="btn-khong" type="button" class="btn btn-primary">Không</button>
        <button type="button" id="btn-tieptucan" class="btn btn-primary" onclick="closePopupAttributecsdlxacminh();">Tiếp tục chạy ẩn</button>
      </div>
    </div>
  </div>
</div>
</div>

</div>

<div class="row">
<div class="col-md-12">

<!-- Modal -->
<div class="modal fade" style="display: none;" id="viewpdf" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="" role="document" style="margin-left: 250px;">
    <div class="modal-content modal-lg" style="position: relative !important;">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><liferay-ui:message key="portlet.quanlytaikhoan.phieudangky"/></h5>
        <button type="button" class="close" data-dismiss="modal" onclick="closePopupPdf();" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="row">
        	<div id="loader-id" class="loader"></div>
        	<div id="xemTruocVanBan" style="width: 100%;">
			<iframe style=" margin: 0px; padding: 0px; border: 0px" width="100%" height="500px" id="if" src=""></iframe>
		</div>
        </div> 
      </div>
      <div class="modal-footer" style="text-align: right;">
        <button type="button" class="btn btn-primary" onclick="closePopupPdf()"><liferay-ui:message key="portlet.quanlytaikhoan.dong"/></button>
      </div>
    </div>
  </div>
</div>
</div>

</div>
<portlet:resourceURL var="xembienbanUrl" id="xemtruocbienban" >
</portlet:resourceURL>
<liferay-portlet:resourceURL var="getDataXacMinhUrl" id="getDataXacMinh" copyCurrentRenderParameters="<%=false %>">
</liferay-portlet:resourceURL>
<aui:script>
AUI().use('aui-datepicker', function(A) {
	new A.DatePicker({
		trigger : '#HieuLuc0',
		popover : {
		zIndex : 1
	},
	 mask: '%d/%m/%Y'
	});
});	

</aui:script>

<script type="text/javascript">

$('#delete-image').hide();
$('#table-xacminh').hide();
$('#btn-co').hide();
$('#btn-khong').hide();
var gocquay = 0;
var gocquaydangky = 0;
$(document).ready(function(){
	
	
	$('#btn-co').click(function(){
		var cocheck = $('input[name="optradio"]:checked').val();
		if(typeof(cocheck) != "undefined"){
			$('#<portlet:namespace/>cocsxm').val('1');
			$('#status-xm').html('Đã có');
			$('#viewcsdlxacminh').removeClass('show').addClass('hide');
		}else{
		    $.confirm({
		        title: 'Lỗi',
		        content: 'Vui lòng chọn tài khoản trên CSDL xác minh',
		        type: 'red',
		        typeAnimated: true,
		        buttons: {
		            tryAgain: {
		                text: 'Đóng',
		                btnClass: 'btn-red',
		                action: function(){
		                }
		            }
		        }
		    });
		}
	});
	$('#btn-khong').click(function(){
		$('#<portlet:namespace/>cocsxm').val('2');
		$('#status-xm').html('Không có');
		$('#viewcsdlxacminh').removeClass('show').addClass('hide');
	});
	
	 $('#xoayhinh').click(function(){
		 gocquay = gocquay + 90;
	      $('#imageshowxoay').rotate(gocquay);
	   });
	 $('#xoayhinhdangky').click(function(){
		 gocquaydangky = gocquaydangky + 90;
	      $('#imageshowdangkyxoay').rotate(gocquaydangky);
	   });
	
});
function viewfiledangky(item){
	gocquaydangky = 0;
	gocquay = 0;
	let src = $(item).attr("src");
	if(src != ""){
		$('#imageshowdangky').attr("src",src);
		$('#viewimagedangky').removeClass('fade').removeClass('hide').addClass('show');
	}
}
function viewimage(url){
	$('#delete-image').show();
	$('#infoimage').attr("src",url);
	
}
function deleteimagef(){
	$('#delete-image').hide();
	$('#infoimage').attr("src",'');
}

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
$(document).ready(function(){
});
function changeimage(index){
	$('#image-box-'+index).empty();
	$('#url-image-'+index).val("");
}
function viewimagemodal(index,url){
	$('#indeximage').val(index);
	$('#imageshow').attr('src',url);
	$('#viewimage').removeClass('fade').removeClass('hide').addClass('show');
	
}
function removeimage(){
	var indeximage = $('#indeximage').val();
	$('#image-box-'+indeximage).empty();
	$('#url-image-'+indeximage).val("");
	$('#viewimage').removeClass('show').addClass('hide');
}
function createdateinput(id){
	AUI().use('aui-datepicker', function(A) {
		new A.DatePicker({
			trigger : '#'+id,
			popover : {
			zIndex : 1
		},
		 mask: '%d/%m/%Y'
		});
	});	
}
function changeloaigiayto(index){
	var lgt = $('#LoaiGiayTo'+index).val();
	
	if(lgt == 'BBKXN' || lgt =='GTXMACD'){
		var listxm = [];
	    var listxmattr = [];
		var id = index+"";
	    var thuoctinh = listxm;
	    var attrkey = listxmattr;
	    var loaigt = "";
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
	
}
function downloadBienban(){
	$('#loader-id').show();
	$('#xemTruocVanBan').hide();
	$('#viewpdf').removeClass('fade').removeClass('hide').addClass('show');
	var iscanhan = <%= account1.getAccountType() %>;
	if(iscanhan == 1){
		var tentaikhoan = "<%=account1.getAccountName()%>";
		var emailtaikhoan = "<%=account1.getEmail()%>";
		var noixacthuc = $('#diachitaikhoan').val();
		var hoten = "<%=account1.getFullName()%>";
		var gioitinh = "<%= (account1.getGender()== 0)?"Nữ":"Nam" %>";
		var loaigiayto = "<%=account1.getPersonalId()%>";
		var ngaycap = "";
		var ngaydangky = "<%= account1.getCreateDate()%>";
		var dienthoai = "<%= account1.getTelNo() %>";
		var ngaysinh = "<%= DateUtil.convertDateToString(account1.getBirthdate(),"dd/MM/yyyy") %>";
		var quoctich = "";
		var sogiayto = "<%=account1.getPersonalId()%>";
		var noicap = "<%=diaChiChiTiet%>";
		var tennguoixacminh = "";
		var accountId= "<%= account1.getAccountId() %>;<%= account1.getAccountName() %>";
		var tenkhachhang = "";
		var diachi = "<%=diaChiChiTiet%>";
		var giaytolienquan = "";
		$('#tb-xacminh').find('tbody > tr').each(function() {
			 var oldSuffix = parseInt($(this).attr('suffix'));
			var tengtitem = "-"+$('#LoaiGiayTo'+oldSuffix+' option:selected').text();
			
			giaytolienquan += (tengtitem+'<br>');
			
		});
		var datasend = {accountId,diachi,tentaikhoan,emailtaikhoan,noixacthuc,hoten,gioitinh,loaigiayto,ngaycap,ngaydangky,dienthoai,ngaysinh,quoctich,sogiayto,noicap,tennguoixacminh,tenkhachhang,giaytolienquan};
		var strdata = JSON.stringify(datasend);
		var base64data = Base64.encode(strdata);
		$.ajax({
			type:'POST',
			data:{"<portlet:namespace/>datasend":base64data,"<portlet:namespace/>iscanhan":true},
			url:'<%=xembienbanUrl%>',
			beforeSend: function (xhr) {
		      
		    },
			success:function(result){
				console.log("data:application/pdf;base64," + result);
				
				$("#if").attr('src', "data:application/pdf;base64," + result);
				$('#loader-id').hide();
				$('#xemTruocVanBan').show();
				//$('#viewpdf').removeClass('fade').removeClass('hide').addClass('show');
			},
			error: function (request, status, error) {
				alert('<liferay-ui:message key="portlet.quanlytaikhoan.loiserver"/>');
		    }
		});	
	}else{
		var tentaikhoan = "<%=account1.getAccountName()%>";
		var emailtaikhoan = "<%=account1.getEmail()%>";
		var noixacthuc = $('#diachitaikhoan').val();
		var hoten = "<%=account1.getFullName()%>";
		var gioitinh = "<%= account1.getPersonalId() %>";
		var loaigiayto = "<%=account1.getPersonalId()%>";
		var ngaycap = "";
		var ngaydangky = "<%= account1.getCreateDate()%>";
		var dienthoai = "<%= account1.getTelNo() %>";
		var ngaysinh = "<%= account1.getLegalDelegate() %>";
		var quoctich = "";
		var sogiayto = "<%=account1.getTaxCode()%>";
		var noicap = "<%=diaChiChiTiet%>";
		var tennguoixacminh = "";
		var accountId= "<%= account1.getAccountId() %>;<%= account1.getAccountName() %>";
		var tenkhachhang = "";
		var diachi = "<%=diaChiChiTiet%>";
		var giaytolienquan = "";
		$('#tb-xacminh').find('tbody > tr').each(function() {
			 var oldSuffix = parseInt($(this).attr('suffix'));
			var tengtitem = "-"+$('#LoaiGiayTo'+oldSuffix+' option:selected').text();
			
			giaytolienquan += (tengtitem+'<br>');
			
		});
		var datasend = {accountId,diachi,tentaikhoan,emailtaikhoan,noixacthuc,hoten,gioitinh,loaigiayto,ngaycap,ngaydangky,dienthoai,ngaysinh,quoctich,sogiayto,noicap,tennguoixacminh,tenkhachhang,giaytolienquan};
		var strdata = JSON.stringify(datasend);
		var base64data = Base64.encode(strdata);
		$.ajax({
			type:'POST',
			data:{"<portlet:namespace/>datasend":base64data,"<portlet:namespace/>iscanhan":false},
			url:'<%=xembienbanUrl%>',
			beforeSend: function (xhr) {
		      
		    },
			success:function(result){
				console.log("data:application/pdf;base64," + result);
				$("#if").attr('src', "data:application/pdf;base64," + result);
				$('#loader-id').hide();
				$('#xemTruocVanBan').show();
			},
			error: function (request, status, error) {
				alert('<liferay-ui:message key="portlet.quanlytaikhoan.loiserver"/>');
		    }
		});	
	}
	
	
}
function luutam(ind){
	var titlecomfim = "<liferay-ui:message key="portlet.quanlytaikhoan.xacnhan"/>";
	var content = "";
	if(ind == 0){
		content = "<liferay-ui:message key="portlet.quanlytaikhoan.luutam"/> : <%= account1.getAccountName() %> ?"
	}else if(ind == 1){
		content = "<liferay-ui:message key="portlet.quanlytaikhoan.xacminhdungtk"/> : <%= account1.getAccountName() %> ?"
	}else if(ind == 2){
		var ykiencanbo = $('#<portlet:namespace/>ykiencanboxacminh').val().trim();
		if(ykiencanbo == ''){
			$('#<portlet:namespace/>ykiencanboxacminh').addClass('error-cl');
			return;
		}
		content = "<liferay-ui:message key="portlet.quanlytaikhoan.xacminhsaitk"/> : <%= account1.getAccountName() %> ?"
	}else{
		
	}
	$.confirm({
	    title: titlecomfim,
	    content: content,
	    autoClose: 'dong|8000',
	    buttons: {
	        somethingElse: {
	            text: '<liferay-ui:message key="portlet.quanlytaikhoan.tieptuc"/>',
	            btnClass: 'btn-blue',
	            keys: ['enter', 'shift'],
	            action: function(){
	            	luutamold(ind);
	            }
	        },
	        dong: {
	            text: '<liferay-ui:message key="portlet.quanlytaikhoan.dong"/>',
	            btnClass: 'btn-default',
	            keys: ['esc'],
	            action: function(){
	               
	            }
	        }
	    }
	});
}
function luutamold(ind){
	$('#<portlet:namespace/>luutam').val(ind);
	var arrsuff = [];
	var iserror = false;
	$('#tb-xacminh').find('tbody > tr').each(function() {
		 var oldSuffix = parseInt($(this).attr('suffix'));
		 var tengtcheck = $('#LoaiGiayTo'+oldSuffix).val();
		if($('#LoaiGiayTo'+oldSuffix).val().trim() ==''){
			$('#LoaiGiayTo'+oldSuffix).addClass('error-cl');	
			iserror = true;
		}else{
			$('#LoaiGiayTo'+oldSuffix).removeClass('error-cl');
		}
		console.log('#filexacminhdinhkem-'+oldSuffix);
		if($('#filexacminhdinhkem-'+oldSuffix).val().trim() ==''){
			if($('#url-image-'+oldSuffix).val() == ""){
				$('#filexacminhdinhkem-'+oldSuffix).addClass('error-cl');
				iserror = true;
			}
			
		}else{
			$('#filexacminhdinhkem-'+oldSuffix).removeClass('error-cl');
		}
		var iserrorthuoctinh = true;
		for( var i = 0; i < arrayxacminh.length; i++){
		   if ( arrayxacminh[i].id == oldSuffix ) {
			   if($('#LoaiGiayTo'+oldSuffix).val() != 'BBKXN' && $('#LoaiGiayTo'+oldSuffix).val() != 'GTXMACD'){
				   if(arrayxacminh[i].thuoctinh.length > 0){
					   iserrorthuoctinh = false;
				   }else{
					   iserrorthuoctinh = true; 
				   }
				   
			   }else{
				   iserrorthuoctinh = false;
			   }
		   } else{
			   
		   }
	    }
		 if(iserrorthuoctinh){
  		   $('#thuoctinh'+oldSuffix).addClass('error-cl');
  		 iserror = true;
  	   }else{
  		 $('#thuoctinh'+oldSuffix).removeClass('error-cl');
  	   }
	});
	if(iserror == true){
		return;
	} 
	$('#tb-xacminh').find('tbody > tr').each(function() {
		var oldSuffix = parseInt($(this).attr('suffix'));
		 for( var i = 0; i < arrayxacminh.length; i++){ 
	    	   if ( arrayxacminh[i].id == oldSuffix) {
	    		   arrayxacminh[i].loaigt = $('#LoaiGiayTo'+oldSuffix).val();
	    	   }
	    	}
	});
	var jsontt = JSON.stringify(arrayxacminh);
	$('#<portlet:namespace/>jsonthongtin').val(Base64.encode(jsontt));
	console.log($('#<portlet:namespace/>jsonthongtin').val());
	$('#form-xacminh').submit();
}
function luuthuoctinhxacminh(){
	var indexsave = $('#suffopen').val();
	$('#list-thuoc-tinh-xm-'+indexsave).empty();
    var listxm = [];
    var listxmattr = [];
    $.each($("input[name='listthuoctinh']:checked"), function(){
    	listxm.push($(this).val());
    	listxmattr.push($(this).attr('dataatr'));
        $('#list-thuoc-tinh-xm-'+indexsave).append('<li>'+$(this).val()+'</li>');
    });
    var id = indexsave;
    var thuoctinh = listxm;
    var attrkey = listxmattr;
    var loaigt = "";
    var urlfile = "";
    var itemxacminh = {id,thuoctinh,attrkey,loaigt,urlfile};
    
    
    for( var i = 0; i < arrayxacminh.length; i++){ 
    	   if ( arrayxacminh[i].id === id) {
    		   arrayxacminh.splice(i, 1); 
    	   }
    	}
    
    arrayxacminh.push(itemxacminh);
    console.log(arrayxacminh);
    $('#thuoctinhmodel').removeClass('show').addClass('hide');
}

function closePopupAttribute() {
	$('#thuoctinhmodel').removeClass('show').addClass('hide');
}
function closePopupAttributecsdlxacminh() {
	$('#viewcsdlxacminh').removeClass('show').addClass('hide');
}
function openmodalcsdlxacminh(){
	 
	let hoTen = "<%= account1.getFullName()==null?"":account1.getFullName()%>";
	 let cmnd = "<%= account1.getPersonalId()==null ? "":account1.getPersonalId() %>";
	 let cccd = "";
	 let soDienThoai = "<%= account1.getTelNo()==null?"":account1.getTelNo() %>";
	 let soHoChieu = "";
	 let soBangLaiXe = "";
	 let maSoThue = "<%= account1.getTaxCode()==null?"": account1.getTaxCode()%>";
	 let maSoBaoHiem = "";
	
	 let datesend = {hoTen,cmnd,cccd,soDienThoai,soHoChieu,soBangLaiXe,maSoThue,maSoBaoHiem};
	 let strjson = JSON.stringify(datesend);
	 let base64data = Base64.encode(strjson);
	$.ajax({
		type:'POST',
		data:{"<portlet:namespace/>databasesend":base64data},
		url:'<%=getDataXacMinhUrl%>',
		beforeSend: function (xhr) {
	      
	    },
		success:function(result){
			console.log(result);
			if(result == ''){
				$('#process-id').hide();
			}else{
				let objectjson = JSON.parse(result);
				let strrow = "";
				for(var i = 0; i < objectjson.length; i++){
					let hotenout = objectjson[i]["khach_hang.ho_va_ten"]== null?"":objectjson[i]["khach_hang.ho_va_ten"];
					let cmndout = objectjson[i]["khach_hang.so_cmt"]== null?"":objectjson[i]["khach_hang.so_cmt"];
					let sohochieuout = objectjson[i]["khach_hang.so_ho_chieu"] == null?"":objectjson[i]["khach_hang.so_ho_chieu"];
					let banglaixeout = objectjson[i]["khach_hang.so_bang_lai_xe"]== null?"":objectjson[i]["khach_hang.so_bang_lai_xe"];
					let masothueout = objectjson[i]["khach_hang.ma_so_thue"]== null?"":objectjson[i]["khach_hang.ma_so_thue"];
					let sobaohiemout = objectjson[i]["khach_hang.ma_so_bao_hiem"]== null?"":objectjson[i]["khach_hang.ma_so_bao_hiem"];
					let sodienthoaiout = objectjson[i]["khach_hang.so_dien_thoai"]== null?"":objectjson[i]["khach_hang.so_dien_thoai"];
					strrow += "<tr><th scope='row'>"+(i+1)+"</th><td><input type='radio' name='optradio'></td><td>"+hotenout+"</td><td>"+cmndout+"</td><td>"+sohochieuout+"</td><td>"+banglaixeout+"</td><td>"+masothueout+"</td><td>"+sobaohiemout+"</td><td>"+sodienthoaiout+"</td></tr>";
				}
				console.log(objectjson);
				
				$('#table-xacminh tbody').append(strrow);
				$('#table-xacminh').show();
				$('#process-id').hide();
				$('#btn-tieptucan').hide();
				$('#btn-co').show();
				$('#btn-khong').show();
			}
			
			
		},
		error: function (request, status, error) {
			alert('<liferay-ui:message key="portlet.quanlytaikhoan.loiserver"/>');
	    }
	});
	
	
	
	$('#viewcsdlxacminh').removeClass('fade').removeClass('hide').addClass('show');
	
	
}
function closePopupAttributeimage() {
	$('#viewimage').removeClass('show').addClass('hide');
}
function closePopupAttributeimagedangky() {
	$('#viewimagedangky').removeClass('show').addClass('hide');
}
function closePopupPdf() {
	$('#viewpdf').removeClass('show').addClass('hide');
}


function openThuocTinh(index){
	$("#thuoctinhmodel input[type=checkbox]").prop('checked', false);
	$('#suffopen').val(index);
	console.log(index);
	console.log("lenght:" + arrayxacminh.length);
	for( var i = 0; i < arrayxacminh.length; i++){ 
		console.log(arrayxacminh[i].id);
 	   if ( arrayxacminh[i].id == index) {
 		  
 		   var oldxacminh = arrayxacminh[i].thuoctinh;
 		   console.log(oldxacminh);
 		   for(var j = 0; j < oldxacminh.length;j++){
 			  $("input[type=checkbox][value='"+oldxacminh[j]+"']").prop("checked",true); 
 		   }
 	   }
 	}
	$('#thuoctinhmodel').removeClass('fade').removeClass('hide').addClass('show');
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
	var thuocTinhCol = '<td><input id="thuoctinh'+newSuffix+'" type="button" class="btn btn-primary" onclick="openThuocTinh('+newSuffix+')" value="Thuộc tính"><ul style="text-align: left;" id="list-thuoc-tinh-xm-'+newSuffix+'"></ul></td>';
	var dinhKemCol = '<td><input type="hidden" name="<portlet:namespace/>url-image-'+newSuffix+'"  id="url-image-'+newSuffix+'" value=""/><input class="btn btn-default" accept="image/*,application/pdf" type="file" id="filexacminhdinhkem-'+newSuffix+'" name="filexacminhdinhkem-'+newSuffix+'"></td>';
	var deleteCol = '<td><a onclick="deleteRow('+newSuffix+');"><span class="glyphicon glyphicon-remove"></span></a></td>';
	
	$('#' + tableID + ' tr:last').after("<tr suffix='" + newSuffix + "' style='text-align: center;'>"
			   + sttcol
			   +loaiGiayToCol
			   + thuocTinhCol
			   + dinhKemCol
			   + deleteCol
        + "</tr>");
	$('#LoaiGiayTo'+newSuffix).val("");
}
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

//This function will show the image in the lightbox
/* var zoomImg = function () {
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
}; */

/* window.addEventListener("load", function(){
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