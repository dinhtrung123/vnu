
<%@page import="dtt.vn.account.search.AccountDisplayTerms"%>
<%@page import="dtt.vn.account.search.AccountSearchContainer"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="javax.portlet.PortletMode"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/accountportlet/init.jsp" %>

<%
	AccountSearchContainer searchContainer = (AccountSearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	AccountDisplayTerms displayTerms = (AccountDisplayTerms)searchContainer.getDisplayTerms();
%>
<liferay-ui:search-toggle buttonLabel="Account Search" displayTerms="<%= displayTerms %>" id="toggle_id_employee_search">
	<aui:input label="fullname" name="fullname" value="<%=displayTerms.getFullName() %>"/>
	<aui:input label="email" name="email" value="<%=displayTerms.getEmail() %>"/>
	<aui:input label="telNo" name="telNo" value="<%=displayTerms.getTelNo() %>"/>
	<aui:input label="personalId" name="personalId" value="<%=displayTerms.getPersonalId() %>"/>
	<aui:input label="address" name="address" value="<%=displayTerms.getAddress() %>"/>
</liferay-ui:search-toggle>

