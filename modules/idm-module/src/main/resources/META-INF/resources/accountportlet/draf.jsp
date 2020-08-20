<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page import="dtt.vn.account.business.Constantes"%>
<%@page import="dtt.vn.vnpost.service.DanhMucLocalServiceUtil"%>
<%@page import="dtt.vn.vnpost.model.DanhMuc"%>
<%@page import="dtt.vn.account.util.DateUtil"%>
<%@page import="dtt.vn.vnpost.model.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/accountportlet/init.jsp" %>

<%
ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
Account account1 = (Account)request.getAttribute("account");
long accountId = BeanParamUtil.getLong(account1, request, "accountId");
long tinhId = (Long)request.getAttribute("tinhId");
long huyenId =(Long)request.getAttribute("huyenId");
long xaId = (Long)request.getAttribute("xaId");


String ngaySinh="";
if(accountId > 0) {
	ngaySinh = account1.getBirthdate() !=null ? DateUtil.convertDateToString(account1.getBirthdate(), DateUtil.DATE_FORMAT_D_M_Y)  : StringPool.BLANK;

}else {
	ngaySinh = DateUtil.parseDateToString(new Date(), DateUtil.DATE_FORMAT_D_M_Y);
}



List<DanhMuc> listTinh = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(Constantes.MA, Constantes.MUC_TINH, true);
List<DanhMuc> listXa = new ArrayList<DanhMuc>();
List<DanhMuc> listHuyen = new ArrayList<DanhMuc>();

if(tinhId!=0){
	listHuyen = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(tinhId, true);
	
}
if(huyenId!=0){
	listXa = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(huyenId, true);
}
String requiredLabel="";
requiredLabel ="(*)";
String dotLabel=":";

%>
<portlet:renderURL var="selectHuyen" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/accountportlet/_select_huyen.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="selectXa" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/accountportlet/_select_xa.jsp"/>
</portlet:renderURL>


<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/accountportlet/view.jsp"/>
</portlet:renderURL>
<liferay-ui:header backURL="<%=viewURL%>" escapeXml="<%=false%>"
	title='<%= (accountId==0) ? "add" : "modify"  %>' />

<portlet:actionURL var="saveAccountURL" name="saveAccount"/>

<aui:form action="<%= saveAccountURL %>" method="post" name="fm">
	<aui:input name="cmd" type="hidden" value='<%= (accountId==0) ? "ADD" : "UPDATE"  %>'></aui:input>
	<aui:input name="accountId" type="hidden" value="<%= accountId %>" />
	<aui:input name="ipLevel" type="hidden" value="<%= account1.getIpLevel() %>" />
	<aui:input name="accountStatus" type="hidden" value="<%= account1.getAccountStatus() %>" />
	<aui:input name="processStatus" type="hidden" value="<%= account1.getProcessStatus() %>" />
	<aui:input name="message" type="hidden" value="<%= account1.getMessage() %>" />
	<aui:input name="reopen" type="hidden" value="<%= account1.getReOpen() %>" />
</aui:form>



