<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="dtt.vn.account.search.AccountDisplayTerms"%>
<%@include file="/phancongportlet/init.jsp" %>


<%
AccountDisplayTerms displayTerms = new AccountDisplayTerms(renderRequest);
%>
<aui:fieldset>
 	<aui:input name="<%= displayTerms.KEYWORDS %>"  type="text" value='<%= displayTerms.getKeywords() %>' /> 
 </aui:fieldset> 
 <aui:button type="submit" value="Tìm Kiếm" /> 


