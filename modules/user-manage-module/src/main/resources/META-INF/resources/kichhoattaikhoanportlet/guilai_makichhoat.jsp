
<%@page import="org.oep.danhmuc.model.DanhMuc"%>
<%@page import="org.oep.danhmuc.service.DanhMucLocalServiceUtil"%>

<%@page import="java.util.List"%>
<%@page import="dtt.vn.user.keys.DanhMucKeys"%>
<%@page import="dtt.vn.user.keys.KichHoatTaiKhoanKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="dtt.vn.user.utils.DangKyQuyTrinhUtil"%>
<%@ include file="/kichhoattaikhoanportlet/init.jsp" %>
<portlet:defineObjects />

<%
String error = ParamUtil.getString(request, "error","");

String maKichHoatEMAILDefault = DangKyQuyTrinhUtil.getMaKichHoat();
String maKichHoat = ParamUtil.getString(request, KichHoatTaiKhoanKeys.KichHoat.MA_KICHHOAT,maKichHoatEMAILDefault);
List<DanhMuc> listHinhThucKH = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(DanhMucKeys.HINHTHUCKICHHOATTAIKHOAN.MA, 1, true);

%>

<portlet:actionURL var="guiLaiMaKichHoatURL" name="guiLaiMaKichHoat">
</portlet:actionURL>

<portlet:actionURL var="kichHoatTaiKhoanCDURL" name="kichHoatTaiKhoanCD" >
	<portlet:param name="javax.portlet.action" value="kichHoatTaiKhoanCD"/>	
	<portlet:param name="maKichHoatMD5" value="<%=DangKyQuyTrinhUtil.getMd5Hash(maKichHoat) %>"/>	
</portlet:actionURL>

<portlet:actionURL var="kichHoatTaiKhoanTCURL" name="kichHoatTaiKhoanTC" >
	<portlet:param name="javax.portlet.action" value="kichHoatTaiKhoanTC"/>	
	<portlet:param name="maKichHoatMD5" value="<%=DangKyQuyTrinhUtil.getMd5Hash(maKichHoat) %>"/>	
</portlet:actionURL>


<div class="container">
	<form name="fmt" method="post" action="<%=guiLaiMaKichHoatURL.toString() %>" enctype="multipart/form-data">
	<aui:input name="<%=KichHoatTaiKhoanKeys.KichHoat.MA_KICHHOAT %>" id="<%=KichHoatTaiKhoanKeys.KichHoat.MA_KICHHOAT %>" type="hidden" value="<%=maKichHoat %>"/>
	<aui:input name="<%=KichHoatTaiKhoanKeys.KichHoat.KICHHOAT_CD_URL %>" id="<%=KichHoatTaiKhoanKeys.KichHoat.KICHHOAT_CD_URL %>" type="hidden" value="<%=kichHoatTaiKhoanCDURL %>"/>
	<aui:input name="<%=KichHoatTaiKhoanKeys.KichHoat.KICHHOAT_TC_URL %>" id="<%=KichHoatTaiKhoanKeys.KichHoat.KICHHOAT_TC_URL %>" type="hidden" value="<%=kichHoatTaiKhoanTCURL %>"/>
		
		<div class="form-group">
			<h4 class="tle1" style="font-weight: 600 !important;"><liferay-ui:message key="dtt.vn.user.guilaimakichhoat.title"/></h4>
		</div>
		<table align="center" >
			
			<tr>
			<%if(!error.equals("")){
							%>
							<div style="color:#FF0000;font-size:18px;">
								<label class="oep-label-bold"><liferay-ui:message key="dtt.vn.user.dangky.kichhoatlai.validate.error"/></label>
							</div>
							<%
						} %>
			</tr>
			<tr>
				<td colspan="12">
				<div class="form-group">
					<label class="control-label"><liferay-ui:message key="dtt.user.dangky.kichhoatlai.tentaikhoan"/></label><label class="oep-label-red">*</label>
					<input  style="width: 30%;" type="text" class="form-control"  maxlength="" label=""  id="<portlet:namespace/>userName" name ="<portlet:namespace/>userName"
						 required/>
				</div>
				<div class="form-group">
					<label class="control-label"><liferay-ui:message key="dtt.user.dangky.kichhoatlai.matkhau"/></label><label class="oep-label-red">*</label>
					<input  style="width: 30%;" type="password" class="form-control"  maxlength="" label=""  id="<portlet:namespace/>matKhau" name ="<portlet:namespace/>matKhau"
						 required/>
				</div>
				<div class="form-group">
					<label class="control-label" for="pwd"><liferay-ui:message key="dtt.vn.user.dangky.kichhoatlai.hinhthucnhanmakh"/></label>
					<select style="width: 30%;" name="<portlet:namespace/>HinhThucKichHoat" id ="<portlet:namespace/>HinhThucKichHoat" class="form-control" id="sel1">
					    <%if(listHinhThucKH!=null&&listHinhThucKH.size()>0){
					    	for(DanhMuc hinhThucKH : listHinhThucKH){%>
					    	<option value="<%=hinhThucKH.getMa() %>">
					    		<%=hinhThucKH.getTen() %>
					    	</option>
					    	<%}
					    } %>
					</select>
					      
				</div>
				</td>
				<td colspan="12">
					
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<button type="submit" class="btn btn-primary"><liferay-ui:message key="dtt.vn.user.dangky.kichhoatlai.button.guimakh"/></button>
					</div>
				</td>
			</tr>
		</table>
	</form>
</div>