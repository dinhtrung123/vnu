<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>


<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page	import="com.liferay.portal.kernel.bean.BeanPropertiesUtil"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
//PortletURL currentURLObj = PortletURLUtil.getCurrent(renderRequest,renderResponse);
PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest,liferayPortletResponse);
String currentURL = currentURLObj.toString();
String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL");
SimpleDateFormat sdf_dmy = new SimpleDateFormat("dd-MM-yyyy HH:mm");
%>