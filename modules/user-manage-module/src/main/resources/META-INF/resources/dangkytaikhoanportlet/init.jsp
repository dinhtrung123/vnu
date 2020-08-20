<%@page import="java.util.List"%>
<%@page import="dtt.vn.user.keys.Constantes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@ page import="javax.portlet.PortletPreferences" %>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page	import="com.liferay.portal.kernel.bean.BeanPropertiesUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<portlet:defineObjects />

<liferay-theme:defineObjects />
<%-- <%
SimpleDateFormat formatNgay = new SimpleDateFormat("dd-MM-yyyy HH:mm");
%> --%>