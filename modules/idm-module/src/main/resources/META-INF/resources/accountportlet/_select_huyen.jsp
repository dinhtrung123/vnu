
<%@page import="dtt.vn.account.business.Constantes"%>
<%@page import="dtt.vn.vnpost.service.DanhMucLocalServiceUtil"%>
<%@page import="dtt.vn.vnpost.model.DanhMuc"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.List"%>
<%@ include file="/accountportlet/init.jsp" %>

<%
	String maTinh = ParamUtil.getString(request, "capTinhId");
	String maHuyen = ParamUtil.getString(request, "capHuyenId");
	DanhMuc danhMuc = DanhMucLocalServiceUtil. getDanhMuc_By_Nhom_Muc_Ma(Constantes.MA, 1, maTinh, true);
	long tinhId = (danhMuc == null) ? 0 :danhMuc.getId();
	List<DanhMuc> lsHuyen = null;
	if(tinhId > 0) {
		lsHuyen =DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(tinhId, true);
	}
	String requiredLabel="";
	 requiredLabel ="(*)";
	 String dotLabel=":";
%>
<aui:select cssClass="input1001" required="true" showRequiredLabel="<%=false %>"  name="huyen" id="huyen" onChange="javascript:selectXa();" label="" >
	<aui:option value=""><liferay-ui:message key="-chon-huyen-"></liferay-ui:message></aui:option>
	<%
		for (DanhMuc huyen : lsHuyen) {
	%>
		<aui:option value="<%= huyen.getMa() %>"><%= huyen.getTen() %></aui:option>
	<%
		}
	%>
	

</aui:select>




