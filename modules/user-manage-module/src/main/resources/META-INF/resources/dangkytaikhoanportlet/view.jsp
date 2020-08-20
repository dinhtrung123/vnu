<%@page import="dtt.vn.user.utils.DangKyQuyTrinhUtil"%>
<%@page import="dtt.vn.user.keys.PortletKeys"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="dtt.vn.user.keys.DangKyTaiKhoanKeys"%>
<%@ include file="/dangkytaikhoanportlet/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/dangkytaikhoanportlet/init.jsp" %>
<portlet:defineObjects />
<style type="text/css">
.nav-tabs>li.active>a{
	color:#000;
	background-color:#FDB913 !important;
	border-color:#FDB913 #FDB913 #FDB913;
}
</style>

<%
boolean success= 	ParamUtil.getString(request, "thongBaoTaoTaiKhoanDN").equals("success")||
					ParamUtil.getString(request, "kichHoatThanhCong1DN").equals("success")||
					ParamUtil.getString(request, "kichHoatThanhCong2DN").equals("success")||
					ParamUtil.getString(request, "daKichHoatDN").equals("success")||
					ParamUtil.getString(request, "thongBaoTaoTaiKhoanCD").equals("success")||
					ParamUtil.getString(request, "kichHoatThanhCong1CD").equals("success")||
					ParamUtil.getString(request, "kichHoatThanhCong2CD").equals("success")||
					ParamUtil.getString(request, "thongBaoOtpCD").equals("success")||
					ParamUtil.getString(request, "thongBaoOtpTC").equals("success")||
					ParamUtil.getString(request, "daKichHoatCD").equals("success");

boolean otpSucsessCD = ParamUtil.getString(request, "thongBaoOtpCD").equals("success");
boolean otpSucsessTC = ParamUtil.getString(request, "thongBaoOtpTC").equals("success");

boolean hienthongbaoCD = ParamUtil.getString(request, "hienthongbaoTTKCD").equals("success");
boolean hienthongbaoDN = ParamUtil.getString(request, "hienthongbaoTTKDN").equals("success");
boolean thongbaoKichHoatCD1 = ParamUtil.getString(request, "thongbaoKichHoatCD1").equals("success");
boolean thongbaoKichHoatCD2 = ParamUtil.getString(request, "thongbaoKichHoatCD2").equals("success");
boolean thongbaodaKichHoatCD = ParamUtil.getString(request, "thongbaodaKichHoatCD").equals("success");
boolean thongbaokichHoatThanhCong1DN = ParamUtil.getString(request, "thongbaokichHoatThanhCong1DN").equals("success");
boolean thongbaokichHoatThanhCong2DN = ParamUtil.getString(request, "thongbaokichHoatThanhCong2DN").equals("success");
boolean thongbaodaKichHoatDN = ParamUtil.getString(request, "thongbaodaKichHoatDN").equals("success");
boolean signedIn = themeDisplay.isSignedIn();
//Thong tin dang ky doanh nghiep
String emailDN = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.EMAIL);
String tenDN = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.TEN_TO_CHUC);
String maSoKD = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.MA_SO_THUE);

String thongBaoTaoTaiKhoanDN = DangKyQuyTrinhUtil.getMoTaThamSo(themeDisplay.getScopeGroupId(), DangKyTaiKhoanKeys.Base.THONG_BAO_TAO_TAI_KHOAN_DN);
thongBaoTaoTaiKhoanDN = thongBaoTaoTaiKhoanDN.replace("[$emailAddress]", emailDN).replace("[$ten]", tenDN).replace("[$maSoKinhDoanh]", maSoKD);
String kichHoatThanhCong1DN = DangKyQuyTrinhUtil.getMoTaThamSo(themeDisplay.getScopeGroupId(), DangKyTaiKhoanKeys.Base.TB_KH_TK_THANHCONG_1_DN);
String kichHoatThanhCong2DN = DangKyQuyTrinhUtil.getMoTaThamSo(themeDisplay.getScopeGroupId(), DangKyTaiKhoanKeys.Base.TB_KH_TK_THANHCONG_2_DN);
String daKichHoatDN = DangKyQuyTrinhUtil.getMoTaThamSo(themeDisplay.getScopeGroupId(), DangKyTaiKhoanKeys.Base.TB_DA_KICH_HOAT_DN);
//Thong tin dang ky cong dan
String emailCD = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.EMAIL);
String hoTen = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.HO_TEN);
String thongBaoTaoTaiKhoanCD = DangKyQuyTrinhUtil.getMoTaThamSo(themeDisplay.getScopeGroupId(), DangKyTaiKhoanKeys.Base.THONG_BAO_TAO_TAI_KHOAN_CD);
thongBaoTaoTaiKhoanCD = thongBaoTaoTaiKhoanCD.replace("[$emailAddress]", emailCD).replace("[$ten]", hoTen);
String kichHoatThanhCong1CD = DangKyQuyTrinhUtil.getMoTaThamSo(themeDisplay.getScopeGroupId(), DangKyTaiKhoanKeys.Base.TB_KH_TK_THANHCONG_1_CD);
String kichHoatThanhCong2CD = DangKyQuyTrinhUtil.getMoTaThamSo(themeDisplay.getScopeGroupId(), DangKyTaiKhoanKeys.Base.TB_KH_TK_THANHCONG_2_CD);
String daKichHoatCD = DangKyQuyTrinhUtil.getMoTaThamSo(themeDisplay.getScopeGroupId(), DangKyTaiKhoanKeys.Base.TB_DA_KICH_HOAT_CD);

String thongBao = DangKyQuyTrinhUtil.getMoTaThamSo(themeDisplay.getScopeGroupId(), DangKyTaiKhoanKeys.Base.THONG_BAO_KICHHOAT_OTP_CD);

String maOTP = ParamUtil.getString(request, "maOTP");
String userName = ParamUtil.getString(request, "userName");
String error = ParamUtil.getString(request, "error");

%>

 <main class="bg-page">
   <div class="bg-trang">
      <div class="container">
         <h4 class="tle" style="font-weight: 600 !important;"><liferay-ui:message key="dtt.vn.user.dangky.congdan.title"/></h4>
         	
         		<c:if test="<%=success %>">
         		<div class="alert alert-success" role="alert">
       				<c:if test="<%=hienthongbaoCD %>">
       					<div><%=thongBaoTaoTaiKhoanCD %></div>
       				</c:if>
       				<c:if test="<%=hienthongbaoDN %>">
       					<div><%=thongBaoTaoTaiKhoanDN %></div>
       				</c:if>
       				<c:if test="<%=thongbaoKichHoatCD1 %>">
       					<div><%=kichHoatThanhCong1CD %></div>
       				</c:if>
       				<c:if test="<%=thongbaokichHoatThanhCong1DN %>">
       					<div><%=kichHoatThanhCong1DN %></div>
       				</c:if>
       				<c:if test="<%=thongbaodaKichHoatCD %>">
       					<div><%=daKichHoatCD %></div>
       				</c:if>
       				<c:if test="<%=thongbaodaKichHoatDN %>">
       					<div><%=daKichHoatDN %></div>
       				</c:if>
       				<c:if test="<%=otpSucsessCD %>">
   						<div class="container">
       						<jsp:include page="/dangkytaikhoanportlet/otp_congdan.jsp" >
       							<jsp:param value="<%=maOTP %>" name="maOTP"/>
       							<jsp:param value="<%=userName %>" name="userName"/>
       							<jsp:param value="<%=error %>" name="error"/>
       						</jsp:include>
       					</div>
   					</c:if>
   					<c:if test="<%=otpSucsessTC %>">
   						<div class="container">
       						<jsp:include page="/dangkytaikhoanportlet/otp_tochuc.jsp" >
       							<jsp:param value="<%=maOTP %>" name="maOTP"/>
       							<jsp:param value="<%=userName %>" name="userName"/>
       							<jsp:param value="<%=error %>" name="error"/>
       						</jsp:include>
       					</div>
   					</c:if>
       			</div>
        		 </c:if>
         	
      </div>
   </div>
   
   <c:if test="<%=!success %>">
   	<div class="container">
        <liferay-ui:tabs names="taikhoan.per,taikhoan.or"
						refresh="false" value="${selectedTab}"
						type="nav nav-tabs vnpost">
    		<liferay-ui:section>
        		<%@ include file="/dangkytaikhoanportlet/dangky_congdan.jsp" %>
    		</liferay-ui:section>
   			 <liferay-ui:section>
        		<%@ include file="/dangkytaikhoanportlet/dangky_tochuc.jsp" %>
    		</liferay-ui:section>
		</liferay-ui:tabs>
    </div> 
   </c:if>
</main> 











