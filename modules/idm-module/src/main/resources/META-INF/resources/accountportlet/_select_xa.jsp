
<%@page import="dtt.vn.account.business.Constantes"%>
<%@page import="dtt.vn.vnpost.service.DanhMucLocalServiceUtil"%>
<%@page import="dtt.vn.vnpost.model.DanhMuc"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@ include file="/accountportlet/init.jsp" %>

<%
	String maTinh = ParamUtil.getString(request, "capTinhId");
	String maHuyen = ParamUtil.getString(request, "capHuyenId");
	
	DanhMuc danhMuc = DanhMucLocalServiceUtil. getDanhMuc_By_Nhom_Muc_Ma(Constantes.MA, 2, maHuyen, true);
	long huyenId = (danhMuc == null) ? 0 :danhMuc.getId();
	List<DanhMuc> lsXa = null;
	if(huyenId > 0){
	 lsXa =DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(huyenId, true);
	}
	 String requiredLabel="";
	 requiredLabel ="(*)";
	 String dotLabel=":";
%>

<aui:select cssClass="input1001" required="true" showRequiredLabel="<%=false %>"  name="xa" id="xa %>" label="">
	<aui:option value=""><liferay-ui:message key="-chon-xa-"></liferay-ui:message></aui:option>
	<%
		if (huyenId > 0) {
		for (DanhMuc xa : lsXa) {
	%>
		<aui:option value="<%= xa.getMa() %>"><%= xa.getTen() %></aui:option>
	<%
		}}
	%>
</aui:select>