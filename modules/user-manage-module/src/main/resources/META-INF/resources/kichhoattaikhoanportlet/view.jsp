
<%@page import="dtt.vn.user.keys.DangKyTaiKhoanKeys"%>
<%@page import="dtt.vn.user.keys.KichHoatTaiKhoanKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="dtt.vn.user.utils.DangKyQuyTrinhUtil"%>
<%@ include file="/kichhoattaikhoanportlet/init.jsp" %>
<portlet:defineObjects />

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


String thongBaoTaoTaiKhoanCD = DangKyQuyTrinhUtil.getMoTaThamSo(themeDisplay.getScopeGroupId(), DangKyTaiKhoanKeys.Base.THONG_BAO_GUILAI_MAKH_CD);
String thongBaoTaoTaiKhoanDN = DangKyQuyTrinhUtil.getMoTaThamSo(themeDisplay.getScopeGroupId(), DangKyTaiKhoanKeys.Base.THONG_BAO_GUILAI_MAKH_DN);

String kichHoatThanhCong1CD = DangKyQuyTrinhUtil.getMoTaThamSo(themeDisplay.getScopeGroupId(), DangKyTaiKhoanKeys.Base.TB_KH_TK_THANHCONG_1_CD);
String kichHoatThanhCong1DN = DangKyQuyTrinhUtil.getMoTaThamSo(themeDisplay.getScopeGroupId(), DangKyTaiKhoanKeys.Base.TB_KH_TK_THANHCONG_1_DN);


String maOTP = ParamUtil.getString(request, "maOTP");
String userName = ParamUtil.getString(request, "userName");
String error = ParamUtil.getString(request, "error");

%>


 <main class="bg-page">
 	   <div class="bg-trang">
 	   		<div class="container">
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
       				<c:if test="<%=otpSucsessCD %>">
   						<div class="container">
       						<jsp:include page="/kichhoattaikhoanportlet/nhap_otp.jsp" >
       							<jsp:param value="<%=maOTP %>" name="maOTP"/>
       							<jsp:param value="<%=userName %>" name="userName"/>
       							<jsp:param value="<%=error %>" name="error"/>
       						</jsp:include>
       					</div>
   					</c:if>
   					<c:if test="<%=otpSucsessTC %>">
   						<div class="container">
       						<jsp:include page="/kichhoattaikhoanportlet/nhap_otp.jsp" >
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
        <jsp:include page="/kichhoattaikhoanportlet/guilai_makichhoat.jsp" >
        	<jsp:param value="<%=error %>" name="error"/>
       	</jsp:include>
    </div> 
   </c:if>
 
 </main>