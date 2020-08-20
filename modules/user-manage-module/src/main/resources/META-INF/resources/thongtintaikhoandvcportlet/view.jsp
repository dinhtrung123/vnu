<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>
<%@page import="org.oep.core.model.MappingVmap"%>
<%@page import="org.oep.core.service.MappingVmapLocalServiceUtil"%>
<%@page import="org.oep.danhmuc.model.DanhMuc"%>
<%@page import="java.util.List"%>
<%@page import="dtt.vn.user.keys.DanhMucKeys"%>
<%@page import="dtt.vn.user.keys.DangKyTaiKhoanKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="dtt.vn.user.common.utils.DateUtil"%>
<%@page import="org.oep.danhmuc.service.DanhMucLocalServiceUtil"%>
<%@page import="dtt.vn.vnpost.service.AccountLocalServiceUtil"%>
<%@page import="dtt.vn.vnpost.model.Account"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ include file="/thongtintaikhoandvcportlet/init.jsp" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/css/bootstrap-select.min.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"
  integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
  crossorigin=""/>
<script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"
  integrity="sha512-gZwIG9x3wUXg2hdXF6+rVkLF/0Vi9U8D2Ntg4Ga5I5BZpVkVxlJWbSQtXPSiUTtC0TjtGOmxa1AJPuV0CPthew=="
  crossorigin=""></script>
<style>
tr,td{
border: 0px solid red;
}
#form-edit label{
text-align: left !important;
}
.error-cl{
border: 1px solid red;
}
.errortext{
color: red;
}





  .ui-tooltip, .arrow:after {
    background: white;
    border: 1px solid white;
  }
  .ui-tooltip {
   /*  padding: 10px 20px; */
    color: black;
    border-radius: 20px;
    font: bold 9px "Helvetica Neue", Sans-Serif;
    box-shadow: 0 0 7px black;
  }
  .arrow {
    width: 70px;
    height: 5px;
    overflow: hidden;
    position: absolute;
    left: 50%;
    margin-left: -35px;
    bottom: -16px;
  }
  .arrow.top {
    top: -16px;
    bottom: auto;
  }
  .arrow.left {
    left: 20%;
  }
  .arrow:after {
    content: "";
    position: absolute;
    left: 20px;
    top: -20px;
    width: 25px;
    height: 25px;
    box-shadow: 6px 5px 9px -9px black;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
  }
  .arrow.top:after {
    bottom: -20px;
    top: auto;
  }
  
  .map {
       height: 500px;
       width: 100%;
     }
</style>

<%
try{
	//User userlogin = (User) request.getAttribute(WebKeys.USER);
	User userlogin = PortalUtil.getUser(request);
	System.out.print("userlogin:"+userlogin);
	if(userlogin != null){
		Account accountlogin = AccountLocalServiceUtil.getAccountByEmail(userlogin.getEmailAddress());
		if(accountlogin != null){
			String hoTen = accountlogin.getFullName()==null?"":accountlogin.getFullName();
			String gioiTinh = accountlogin.getGender()==0?"Nữ":"Nam";
			String cmt = accountlogin.getPersonalId() == null?"":accountlogin.getPersonalId();
			String cmtcccd = accountlogin.getPersonalId() == null?"":accountlogin.getPersonalId();
			String taxcode = accountlogin.getTaxCode() == null?"":accountlogin.getTaxCode();
			String tennguoidaidien = accountlogin.getLegalDelegate()==null?"":accountlogin.getLegalDelegate();
			
			MappingVmap vmaptodo =  MappingVmapLocalServiceUtil.getToaDo(Account.class.getName(), accountlogin.getAccountId());
			String longdaluu = "";
			String latdaluu = "";
			if(vmaptodo != null){
				longdaluu = vmaptodo.getLongitude();
				latdaluu = vmaptodo.getLatitude();
			}
			
			String ngaysinh = accountlogin.getBirthdate() == null?"":DateUtil.convertDateToString(accountlogin.getBirthdate(), DateUtil.DATE_FORMAT_D_M_Y);
			String diaChiChiTiet = "";
			try{
				String cityname = (accountlogin.getCityCode()==null||accountlogin.getCityCode().trim().equals("0"))?"": DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(accountlogin.getCityCode())).getTen();
				String districtCode = (accountlogin.getDistrictCode() == null||accountlogin.getDistrictCode().trim().equals("0"))?"":DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(accountlogin.getDistrictCode())).getTen();
				String wardCode = (accountlogin.getWardCode()==null||accountlogin.getWardCode().trim().equals("0"))?"":DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(accountlogin.getWardCode())).getTen();
				 diaChiChiTiet =accountlogin.getAddress()
						 +"-"+wardCode
						 +"-"+districtCode
						 +"-"+ cityname;
			}catch(Exception e){
				diaChiChiTiet = "";
			}
			
			
			String noisinh = diaChiChiTiet;
			String quequan = diaChiChiTiet;
			String diachithuongtru = "";
			String sdt = accountlogin.getTelNo() == null?"":accountlogin.getTelNo();
			String email = accountlogin.getEmail() == null?"":accountlogin.getEmail();
			List<DanhMuc> listGioiTinhs = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.GIOITINH.MA, 1, true);
			List<DanhMuc> listTinhThanhs = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.DONVIHANHCHINH.MA, 1, true);
			%>
			<div class="container">
				<div class="row">
					<div class="col-md-12">
					<div class="bs-example" data-example-id="simple-table">
						<div class="row">
							<div class="col-xs-6"><h3><b>Thông tin định danh</b></h3></div>
							<!-- <div class="col-xs-6 text-right"><h3><button onclick="openEdit();" class="btn btn-link">Sửa</button></h3></div> -->
						</div>
					
					    <table class="table" style="border: none;">
					        
					       
					       
					            <tr>
					                <td><%= accountlogin.getAccountType()==1?"Họ tên":"Tên tổ chức" %></td>
					                <td><%= hoTen %></td>
					                <td>
					                <i style="color: <%= hoTen.equals("")?"red":"#28a745" %>;" title="<%= hoTen.equals("")?"":"Xác thực bởi VNPOST" %>" class="<%= hoTen.equals("")?"fa fa-arrow-circle-right": "fa fa-check-circle"%>"></i>
					                </td>
					            </tr>
					            <%
					            if(accountlogin.getAccountType()==1){
					            	%>
					            	 <tr>
					                <td>Giới tính</td>
					                <td><%= gioiTinh %></td>
					                <td> 
					                <i style="color: #28a745;" title="Xác thực bởi VNPOST" class="fa fa-check-circle">
					                </i>
					               
					                </td>
					            </tr>
					            	<%
					            }else{
					            	%>
					            	<tr>
					                <td>Người đại diện</td>
					                <td><%= tennguoidaidien %></td>
					                <td> 
					                <i style="color: <%= tennguoidaidien.equals("")?"red":"#28a745" %>;" title="Xác thực bởi VNPOST" class="<%= tennguoidaidien.equals("")?"fa fa-arrow-circle-right": "fa fa-check-circle"%>">
					                </i>
					               
					                </td>
					            </tr>
					            	<%
					            }
					            %>
					           
					            <tr>
					                <td>Số CMT (9 số)</td>
					                <td><%= cmt.length() == 9?cmt:"" %></td>
					                <td> <i title="<%= cmt.length() != 9 ?"":"Xác thực bởi VNPOST" %>" style="color: <%= cmt.length() != 9?"red":"#28a745" %>;" class="<%= cmt.length() != 9?"fa fa-arrow-circle-right": "fa fa-check-circle"%>"></i></td>
					            </tr>
					            <tr>
					                <td>Số CMT/CCCD (12 số)</td>
					                <td><%= cmtcccd.length() > 9?cmtcccd:"" %></td>
					                <td> <i title="<%= cmtcccd.length() <= 9?"":"Xác thực bởi VNPOST" %>" style="color: <%= cmtcccd.length() <= 9?"red":"#28a745" %>;" class="<%= cmtcccd.length() <= 9?"fa fa-arrow-circle-right": "fa fa-check-circle"%>"></i></td>
					            </tr>
					            <tr>
					                <td><%= accountlogin.getAccountType()==1?"Ngày sinh":"Mã số thuế" %></td>
					                <td><%= accountlogin.getAccountType()==1?ngaysinh:taxcode %></td>
					                <td> <i title="<%= ((ngaysinh.equals("") && accountlogin.getAccountType()==1)||(taxcode.equals("") && accountlogin.getAccountType()==2))?"":"Xác thực bởi VNPOST" %>" style="color: <%= ((ngaysinh.equals("") && accountlogin.getAccountType()==1)||(taxcode.equals("") && accountlogin.getAccountType()==2))?"red":"#28a745" %>;" class="<%= ((ngaysinh.equals("") && accountlogin.getAccountType()==1)||(taxcode.equals("") && accountlogin.getAccountType()==2))?"fa fa-arrow-circle-right": "fa fa-check-circle"%>"></i></td>
					            </tr>
					           <%--  <tr>
					                <td>Nơi sinh</td>
					                <td><%= diaChiChiTiet %></td>
					                <td> <i style="color: #28a745;" class="fa fa-check-circle"></i></td>
					            </tr>
					            <tr>
					                <td>Quê quán</td>
					                <td><%= quequan %></td>
					                <td> <i style="color: #28a745;" class="fa fa-check-circle"></i></td>
					            </tr> --%>
					            <tr>
					                <td><%= accountlogin.getAccountType()==1?"Địa chỉ thường trú":"Địa chỉ trụ sở" %></td>
					                <td><a onclick="openMap();" style="cursor: pointer;" title="Xem bản đồ" id="diachichitietid"><%= diaChiChiTiet %></a></td>
					                <td> <i title="<%= diaChiChiTiet.equals("")?"":"Xác thực bởi VNPOST" %>" style="color: <%= diaChiChiTiet.equals("")?"red":"#28a745" %>;" class="<%= diaChiChiTiet.equals("")?"fa fa-arrow-circle-right": "fa fa-check-circle"%>"></i></td>
					            </tr>
					            <tr>
					                <td>Số điện thoại</td>
					                <td><%= sdt %></td>
					                <td> <i title="<%= sdt.equals("")?"":"Xác thực bởi VNPOST" %>" style="color: <%= sdt.equals("")?"red":"#28a745" %>;" class="<%= sdt.equals("")?"fa fa-arrow-circle-right": "fa fa-check-circle"%>"></i></td>
					            </tr>
					       		<tr>
					                <td>Email</td>
					                <td><%= email %></td>
					                <td> <i title="<%= email.equals("")?"":"Xác thực bởi VNPOST" %>" style="color: <%= email.equals("")?"red":"#28a745" %>;" class="<%= email.equals("")?"fa fa-arrow-circle-right": "fa fa-check-circle"%>"></i></td>
					            </tr>
					    </table>
					</div>
					</div>
				</div>
				<div class="row" style="margin-bottom: 15px;">
					<div class="col-xs-6">
						<h3><b>Các phương thức xác thực</b></h3>
					</div>
					<div class="col-xs-6 text-right">
						<!-- <h3 style="color: orange;">+ Thêm mới</h3> -->
					</div>
				</div>
				<div class="row">
					<div class="col-xs-2 text-center">
						<span style="color: orange;font-size: 40px;" class="glyphicon glyphicon-user"></span>
					</div>
					<div class="col-xs-8">
						<b style="font-size: 18px;">Xác thực bằng mật khẩu, tin nhắn SMS</b>
					</div>
					<div class="col-xs-2 text-center">
						<!-- <b><span style="color: orange;font-size: 18px;" class="glyphicon glyphicon-trash"></span></b> -->
					</div>
				</div>
				<div class="row">
					<div class="col-xs-2">
						
					</div>
					<div class="col-xs-8">
						<p style="font-size: 18px;">Xác thực bằng mật khẩu</p>
						<div class="progress" style="width: 50%;">
						  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="20"
						  aria-valuemin="0" aria-valuemax="100" style="width:20%">
						   
						  </div>
						</div>
					</div>
					<div class="col-xs-2 text-center">
						<!-- <span style="color: orange;font-size: 18px;" class="glyphicon glyphicon-pencil"></span> <b style="color: orange;font-size: 18px;">Sửa</b> -->
					</div>
				</div>
				<div class="row">
					<div class="col-xs-2">
						
					</div>
					<div class="col-xs-8">
						<p style="font-size: 18px;">Xác thực bằng tin nhắn SMS</p>
						<p style="color: gray;"><%= sdt.equals("")?"": sdt+" - Mặc định" %></p>
						<div class="progress" style="width: 50%;">
						  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40"
						  aria-valuemin="0" aria-valuemax="100" style="width:40%">
						   
						  </div>
						</div>
					</div>
					<div class="col-xs-2 text-center">
						<!-- <span style="color: orange;font-size: 18px;" class="glyphicon glyphicon-user"></span><b style="color: orange;font-size: 18px;">xóa</b> -->
					</div>
				</div>
			</div>
			
			<portlet:actionURL name="actionMethodSave" var="actionMethodSaveURL">
			</portlet:actionURL>
			<portlet:actionURL name="actionMethodSaveViTri" var="actionMethodSaveViTriURL">
			</portlet:actionURL>
			<%-- <div class="row">
			<div class="col-md-12">
			
			<!-- Modal -->
			<div class="modal fade" style="display: none;" id="editinfo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="" role="document">
			    <div class="modal-content " style="position: relative !important;margin: 10px auto;width: 600px;min-height: 500px;">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel"><b>Thông tin định danh</b></h5>
			        <button type="button" class="close" data-dismiss="modal" onclick="closePopupPdf();" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        <div class="row">
			        	<div class="col-md-12">
			        	   <form id="form-edit" method="POST" id="form-save-edit" class="form-horizontal" action="<%= actionMethodSaveURL%>">
			        	   <input type="hidden" id="matinh" name="<portlet:namespace/>matinh"/>
			        	   <input type="hidden" id="mahuyen" name="<portlet:namespace/>mahuyen"/>
			        	   <input type="hidden" id="maxa" name="<portlet:namespace/>maxa"/>
			        	   <input type="hidden" id="machitiet" name="<portlet:namespace/>machitiet"/>
			        	   <input type="hidden" id="accountidedit" name="<portlet:namespace/>accountidedit" value="<%= accountlogin.getAccountId() %>"/>
			        	   	<input type="hidden" id="useridedit" name="<portlet:namespace/>useridedit" value="<%= userlogin.getUserId() %>"/>	
			        	   		<div id="group-edit">
								  <div class="form-group">
								    <label class="control-label col-sm-4 text-left" for="email">Họ tên</label>
								    <div class="col-sm-8">
								      <input type="text"  class="form-control" id="hoten" name="<portlet:namespace/>hoten" value="<%= hoTen %>">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="pwd">Giới tính</label>
								    <div class="col-sm-8">
								     <select class="form-control" id="gioitinh" name="<portlet:namespace/>gioitinh">
									        <option value="1" <%= accountlogin.getGender() == 1?"selected":"" %>>Nam</option>
									        <option value="0" <%= accountlogin.getGender() == 0?"selected":"" %>>Nữ</option>
									        
									      </select>
								    </div>
								  </div>
								   <div class="form-group">
								    <label class="control-label col-sm-4" for="pwd">Số CMT (9 số)</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cmt" value="<%= cmt %>">
								    </div>
								  </div>
								   <div class="form-group">
								    <label class="control-label col-sm-4" for="pwd">Số CMT/CCCD</label>
								    <div class="col-sm-8">
								      <input readonly="readonly" type="text" class="form-control" id="cccd" name="<portlet:namespace/>cccd" value="<%= cmtcccd %>">
								    </div>
								  </div>
								   <div class="form-group">
								    <label class="control-label col-sm-4" for="pwd">Ngày sinh</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="ngaysinh" name="<portlet:namespace/>ngaysinh" value="<%= ngaysinh %>">
								    </div>
								  </div>
								   <div class="form-group">
								    <label class="control-label col-sm-4" for="pwd">Số điện thoại</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" name="<portlet:namespace/>sdt" id="sdt" value="<%= sdt %>">
								    </div>
								  </div>
								   <div class="form-group">
								    <label class="control-label col-sm-4" for="pwd">Email</label>
								    <div class="col-sm-8">
								      <input readonly="readonly" type="text" class="form-control" name="<portlet:namespace/>email" id="email" value="<%= email %>">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="pwd">Địa chỉ thường trú</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" onclick="showDiaChi();" name="<portlet:namespace/>diachi" id="diachi" value="<%= diaChiChiTiet %>">
								    </div>
								  </div>
								  <div class="form-group">
								    <div class="col-sm-offset-4 col-sm-8">
								      <input type="button" onclick="saveEdit();" class="btn btn-default" value="Lưu lại" />
								    </div>
								  </div>
								  </div>
								  
								</form> 
								
								<div id="group-diachi" style="display: none;">
								 		<div class="row">
								 		<div class="col-md-6">
								 		<div class="form-group" style="margin-left: 0px !important;margin-right: 0px !important;">
													<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.tinh"/><label class="oep-label-red">(*)</label>
													<aui:select style="margin-left: 0px !important;margin-right: 0px !important;" cssClass="selectpicker" data-dropup-auto="false" data-live-search="true" title=""  label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN %>" 
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
								 		<div class="col-md-6">
								 		<div class="form-group" style="margin-left: 0px !important;margin-right: 0px !important;">
													<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.quanhuyen"/><label class="oep-label-red">(*)</label>
													<aui:select data-width="100%" cssClass="selectpicker" data-dropup-auto="false" data-live-search="true" title="" style="width:100% !important" label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN %>" 
														id="<%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN %>" onChange="ThayDoiQuanHuyenCongDan(this);">
															<aui:option value="0"><liferay-ui:message key="dtt.vn.user.dangky.congdan.select.chonquanhuyen"/></aui:option>
															
														</aui:select>
													</div>	
								 		</div>
										</div>
										<div class="row">
								 		<div class="col-md-6">
												<div class="form-group">
													<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.phuongxa"/><label class="oep-label-red">(*)</label>
													<aui:select data-width="100%" cssClass="selectpicker" data-dropup-auto="false" data-live-search="true" title=""  label="" name="<%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN %>" 
														id="<%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN %>">
															<aui:option value="0"><liferay-ui:message key="dtt.vn.user.dangky.congdan.select.chonphuongxa"/></aui:option>
															
													</aui:select>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<liferay-ui:message key="dtt.vn.user.dangky.congdan.label.diachichitiet"/><label class="oep-label-red">(*)</label>
													<aui:input title="" type="text"  maxlength = "<%=DangKyTaiKhoanKeys.DangKyCongDan.DIACHI_CHITIET_MAX_LENGTH %>" 
															label = "" id = "<%=DangKyTaiKhoanKeys.DangKyCongDan.DIACHI_CHITIET %>" 
															name = "<%=DangKyTaiKhoanKeys.DangKyCongDan.DIACHI_CHITIET %>"/>
												</div>
											</div>
								 		</div>
								 		<div class="row">
								 			<div class="col-md-6">
								 			<input type="button" value="Đồng ý" onclick="chondiachi();" class="btn btn-success"/>
								 			</div>
								 			<div class="col-md-6">
								 			<input type="button" value="Quay lại" onclick="quaylaidiachi();" class="btn btn-success"/>
								 			</div>
								 		</div>
								  </div>
								
			        	</div>
			        </div> 
			      </div>
			      <div class="modal-footer" style="text-align: right;">
			        <button type="button" class="btn btn-primary" onclick="closePopupPdf()">Đóng</button>
			      </div>
			    </div>
			  </div>
			</div>
			</div>
			
			</div> --%>
			<div class="row">
			<div class="col-md-12">
			 <form id="form-luulaivitri" method="POST" action="<%= actionMethodSaveViTriURL %>">
			 <input type="hidden" id="longvitri" name="<portlet:namespace/>longvitri" />
			 <input type="hidden" id="latvitri" name="<portlet:namespace/>latvitri" />
			 <input type="hidden" name="<portlet:namespace/>accountidvitri" value="<%= accountlogin.getAccountId() %>" />
			 </form>
			</div>
			</div>
			<div class="row">
			<div class="col-md-12">
			
			<!-- Modal -->
			<div class="modal fade" style="display: none;" id="openviewmap" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog modal-lg" role="document">
			    <div class="modal-content " style="position: relative !important;margin: 10px auto;width: 100%;min-height: 500px;">
			      <!-- <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel"><b></b></h5>
			        <button type="button" class="close" data-dismiss="modal" onclick="closePopupmap();" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div> -->
			      <div class="modal-body" style="margin: 0px !important;padding: 0px !important;">
			        <div class="row">
			        	<div class="col-md-12" style="margin: 0px !important;padding: 0px !important;">
			        	   <div id="mapid" class="map"></div>
								
								
								
			        	</div>
			        </div> 
			      </div>
			      <div class="modal-footer" style="text-align: right;">
			        <button type="button" class="btn btn-primary" onclick="timvitri()">Tìm vị trí</button>
			       	<button type="button" class="btn btn-primary" onclick="luulaivitri()">Lưu lại vị trí</button>
			        <button type="button" class="btn btn-primary" onclick="closePopupmap()">Đóng</button>
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
			
			<!-- Latest compiled and minified JavaScript -->
			<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/bootstrap-select.min.js"></script>
			<!-- (Optional) Latest compiled and minified JavaScript translation files -->
			<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/i18n/defaults-*.min.js"></script>
			<script type="text/javascript">
			$('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN %>').selectpicker('refresh');
			$('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN %>').selectpicker('refresh');
			$('#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN %>').selectpicker('refresh');
			function saveEdit(){
				removeerrormessage();
				let iserror = false;
				let hoten = $('#hoten').val().trim();
				let ngaysinh = $('#ngaysinh').val();
				let sdt = $('#sdt').val();
				let diachi = $('#diachi').val();
				if(hoten == ''){
					iserror = true;
					adderror('hoten','Vui lòng nhập họ tên');
				}
				if(ngaysinh == ''){
				iserror = true;
				adderror('ngaysinh','Vui lòng nhập ngày sinh');
				}
				if(sdt == ''){
				iserror = true;
				adderror('sdt','Vui lòng nhập số điện thoại');
				}
				if(diachi == ''){
				iserror = true;
				adderror('diachi','Vui lòng nhập địa chỉ');
				}
				if(!iserror){
					$('#form-edit').submit();	
				}
				
			}
			
			function removeerrormessage(){
				$('.errortext').remove();
				$('.error-cl').removeClass('error-cl');
			}
			function adderror(idelement,text){
				$('#'+idelement).addClass('error-cl');
				$('#'+idelement).parent().append('<p class="errortext">'+text+'</p>')
			}
			function openEdit(){
				$('#editinfo').removeClass('fade').removeClass('hide').addClass('show');
				
			}
			function quaylaidiachi(){
				$('#group-edit').show(500);
				$('#group-diachi').hide(1000);
			}
			function chondiachi(){
				
				var tinh = $( "#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN %> option:selected" ).text().trim();
				var huyen = $( "#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN %> option:selected" ).text().trim();
				var xa = $( "#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN %> option:selected" ).text().trim();
				var dcchitiet = $( "#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.DIACHI_CHITIET %>" ).val().trim();
				$('#matinh').val($( "#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN %>" ).val());
				$('#mahuyen').val($( "#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN %>" ).val());
				$('#maxa').val($( "#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN %>" ).val());
				$('#machitiet').val($( "#<portlet:namespace/><%=DangKyTaiKhoanKeys.DangKyCongDan.DIACHI_CHITIET %>" ).val());
				$('#diachi').val(dcchitiet+"-"+xa+"-"+huyen+"-"+tinh);
				$('#group-edit').show(500);
				$('#group-diachi').hide(1000);
			}
			function showDiaChi(){
				$('#group-edit').hide(1000);
				$('#group-diachi').show(500);
			}
			function closePopupPdf() {
				$('#editinfo').removeClass('show').addClass('hide');
			}
			
			function closePopupmap() {
				mymap1.remove()
				$('#openviewmap').removeClass('show').addClass('hide');
			}
			
			
			
			
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
				var thai = {};
				function timvitri(){
					var diachisearch = "<%= diaChiChiTiet %>".trim();
					if(diachisearch != ""){
						var arrdiachisplit = diachisearch.split("-");
						var lengtharr = arrdiachisplit.length;
						var cityname = arrdiachisplit[lengtharr - 1];
						var urlvmap = "https://maps.vnpost.vn/api/search?api-version=1.1&apikey=7cb80a390b89d5fefae75fc58b01d01dd04a15bb62b3b141&text="+cityname;
						var urlencode = encodeURI(urlvmap);
						$.get(urlencode, function( data ) {
							  var text = data;
							  var longsearch = text.data.features[0].geometry.coordinates[0];
							  var latsearch = text.data.features[0].geometry.coordinates[1];
							  $('#longvitri').val(longsearch);
								$('#latvitri').val(latsearch);
							  mymap1.panTo(new L.LatLng(latsearch, longsearch));
							  var myicon = L.icon({
					        	    iconUrl: '<%= request.getContextPath() %>/img/point.png',
					        	    iconSize:     [32, 32] // size of the icon
					        	});
						
					              mymap1.removeLayer(thai);
					              thai = {};
					        
					        
					             
					       
						 thai = L.marker([latsearch, longsearch], {icon: myicon}).addTo(mymap1);
					           	thai.bindPopup("<b>Vị trí của bạn</b>").closePopup();
							});
						
					}
					
					/* $.get( "https://maps.vnpost.vn/api/autocomplete?focus.point.lat=20.99856&focus.point.lon=105.70023&api-version=1.1&apikey=7cb80a390b89d5fefae75fc58b01d01dd04a15bb62b3b141&text=X%C3%A3%20Chu%20Phan,Huy%E1%BB%87n%20M%C3%AA%20Linh,Th%C3%A0nh%20Ph%E1%BB%91%20H%C3%A0%20N%E1%BB%99i", function( data ) {
						  var text = data;
						  console.log(text);
						}); */
					
				}
				
						function openMap(){
							<%-- if(<%= longdaluu.equals("")?false:true%>){
								initMap();
							}else{
								showPosition();
							} --%>
							showPosition();
							$('#openviewmap').removeClass('fade').removeClass('hide').addClass('show');
						}
						var mymap1 = null;
						var markers = null;
						
				function initMap() {
					
					 mymap1 = L.map('mapid').setView([<%= longdaluu.equals("")?"21.028462,105.825460":(latdaluu+","+longdaluu) %>], 13);
				   	L.tileLayer('https://maps.vnpost.vn/api/tm/{z}/{x}/{y}@@2x.png?apikey={accessToken}', {
				   		attribution: 'Map data &copy; <a href="https://vmap.vn">Vmap</a>, <a href="http://openstreetmap.org">OSM Contributors</a>',
				   		maxZoom: 18,
				   		id: 'Vmap.streets',
				   		accessToken: '7cb80a390b89d5fefae75fc58b01d01dd04a15bb62b3b141'
				   		}).addTo(mymap1);
				   	var bvIcon = L.icon({
				   	    iconUrl: '<%= request.getContextPath() %>/img/pointdefault.png',
				   	    iconSize:     [32, 32] // size of the icon
				   	});
					
				    	
					
					 <%
					if(!longdaluu.equals("")){
						%>
						var vitriluu = L.marker([<%= latdaluu %>, <%= longdaluu %>], {icon: bvIcon}).addTo(mymap1);
						vitriluu.bindPopup("<b>Vị trí đã lưu</b>").closePopup();
						<%
					}
					%> 
				   	
					mymap1.on('click', function(e){
					console.log(e);
					let longclick = e.latlng.lng;
					let latclick = e.latlng.lat;
					
					$('#longvitri').val(longclick);
					$('#latvitri').val(latclick);
					var myicon = L.icon({
				        	    iconUrl: '<%= request.getContextPath() %>/img/point.png',
				        	    iconSize:     [32, 32] // size of the icon
				        	});
					 if (thai != undefined) {
				              mymap1.removeLayer(thai);
				              thai = {};
				        };
					 thai = L.marker([e.latlng.lat, e.latlng.lng], {icon: myicon}).addTo(mymap1);
				           	thai.bindPopup("<b>Vị trí của bạn</b>").closePopup();
					});
				}
				var marker ={};
				function showPosition() {
					
					var lat,lng;
				    if(navigator.geolocation) {
						navigator.geolocation.getCurrentPosition(function(position) {
							lat = position.coords.latitude;
				        	lng = position.coords.longitude;
				        	 mymap1 = L.map('mapid').setView([lat, lng], 13);
				        	L.tileLayer('https://maps.vnpost.vn/api/tm/{z}/{x}/{y}@@2x.png?apikey={accessToken}', {
				        		/* attribution: 'Map data &copy; <a href="https://vmap.vn">Vmap</a>, <a href="http://openstreetmap.org">OSM Contributors</a>', */
				        		attribution: '',
				        		maxZoom: 18,
				        		id: 'Vmap.streets',
				        		accessToken: '7cb80a390b89d5fefae75fc58b01d01dd04a15bb62b3b141'
				        		}).addTo(mymap1);
				        	var bvIcon = L.icon({
				        	    iconUrl: '<%= request.getContextPath() %>/img/pointdefault.png',
				        	    iconSize:     [32, 32] // size of the icon
				        	});
				        	var myicon = L.icon({
				        	    iconUrl: '<%= request.getContextPath() %>/img/point.png',
				        	    iconSize:     [32, 32] // size of the icon
				        	});
				        	//var bvBachMai = L.marker([21.000964, 105.840685], {icon: bvIcon});
				           //	bvBachMai.bindPopup("<b>Bệnh viện Bạch Mai</b><br>0969851616<br>78 Đường Giải Phóng, Phương Đình, Đống Đa, Hà Nội, Việt Nam.").closePopup();
				        	<%
							if(!longdaluu.equals("")){
								%>
								var vitriluu = L.marker([<%= latdaluu %>, <%= longdaluu %>], {icon: bvIcon}).addTo(mymap1);
								vitriluu.bindPopup("<b>Vị trí đã lưu</b>").closePopup();
								<%
							}
							%> 
							$('#longvitri').val(lng);
							$('#latvitri').val(lat);
				        	/*  marker = L.marker([lat, lng],{icon: myicon}).addTo(mymap1);
				        	marker.bindPopup("<b>Vị trí của bạn</b>").openPopup();
				        	var thai = {}; */
				        	if (thai != undefined) {
					              mymap1.removeLayer(thai);
					              thai = {};
					        };
						 thai = L.marker([lat, lng], {icon: myicon}).addTo(mymap1);
					           	thai.bindPopup("<b>Vị trí của bạn</b>").closePopup();
				        	mymap1.on('click', function(e){
							console.log(e);
							let longclick = e.latlng.lng;
							let latclick = e.latlng.lat;
							
							$('#longvitri').val(longclick);
							$('#latvitri').val(latclick);
							
							var myicon = L.icon({
						        	    iconUrl: '<%= request.getContextPath() %>/img/point.png',
						        	    iconSize:     [32, 32] // size of the icon
						        	});
							  if (thai != undefined) {
								 mymap1.removeLayer(thai);
								 thai = {};
						        };
							 thai = L.marker([e.latlng.lat, e.latlng.lng], {icon: myicon}).addTo(mymap1);
						           	thai.bindPopup("<b>Vị trí của bạn</b>").closePopup();
							});
						}, function() {
							initMap();
						});
				    }else{
						console.log("Browser doesn't support geolocation!");
					}
				}
				function luulaivitri(){
					let longvt = $('#longvitri').val();
					let latvt = $('#latvitri').val();
					if(longvt =='' || latvt == ''){
						alert('Chưa chọn vị trí');
					}else{
						$('#form-luulaivitri').submit();
					}
					
				}
				
				$(function () {
					
					//map start
					
					
					
					
					//end map
					
					
					
				    $( ".fa-check-circle" ).tooltip({
				    	show: "slideDown",
				        position: {
				             my: "center bottom-20",
				            at: "center top", 
				           /*  my: "left+15 center", at: "right center", */
				            using: function( position, feedback ) {
				              $( this ).css( position );
				              $( "<div>" )
				                .addClass( "arrow" )
				                .addClass( feedback.vertical )
				                .addClass( feedback.horizontal )
				                .appendTo( this );
				            }
				          }
				      });
					 $( "#diachichitietid" ).tooltip({
					    	show: "slideDown",
					        position: {
					             my: "center bottom-20",
					            at: "center top", 
					           /*  my: "left+15 center", at: "right center", */
					            using: function( position, feedback ) {
					              $( this ).css( position );
					              $( "<div>" )
					                .addClass( "arrow" )
					                .addClass( feedback.vertical )
					                .addClass( feedback.horizontal )
					                .appendTo( this );
					            }
					          }
					      });
					
				    var sd = null, ed = new Date();
				  
				    $('#ngaysinh').datetimepicker({ 
				      pickTime: false, 
				      format: "DD/MM/YYYY", 
				      defaultDate: sd, 
				      maxDate: ed 
				    });
				  
				});
			</script>
			
			
			
			<%
		}else{
			%>
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="alert alert-warning">
							<strong class="lead"><liferay-ui:message key="portlet.quanlytaikhoan.canhbao"/></strong>: <liferay-ui:message key="portlet.quanlytaikhoan.taikhoan"/> "<%=userlogin.getEmailAddress() %>" <liferay-ui:message key="portlet.quanlytaikhoan.notification"/>
						</div>
					</div>
				</div>
			</div>
			<%
		}
	}else{
		%>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="alert alert-warning">
						<strong class="lead"><liferay-ui:message key="portlet.quanlytaikhoan.canhbao"/></strong>: <liferay-ui:message key="portlet.quanlytaikhoan.taikhoan"/> "<%=userlogin.getEmailAddress() %>" <liferay-ui:message key="portlet.quanlytaikhoan.notification"/>
					</div>
				</div>
			</div>
		</div>
		<%
	}
}catch(Exception e){
	e.printStackTrace();
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-danger">
					<strong class="lead"><liferay-ui:message key="portlet.quanlytaikhoan.loi"/></strong>: <liferay-ui:message key="portlet.quanlytaikhoan.loihethong"/>
				</div>
			</div>
		</div>
	</div>
	<%
}

%>

