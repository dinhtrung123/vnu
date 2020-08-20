<%@page import="dtt.vn.account.util.AccountEnum"%>
<%@page import="dtt.vn.account.business.IConstants"%>
<%@page import="dtt.vn.vnpost.model.Photo"%>
<%@page import="dtt.vn.vnpost.service.AccountLocalServiceUtil"%>
<%@page import="dtt.vn.vnpost.model.Account"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="org.apache.commons.lang3.EnumUtils" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DatabaseMetaData"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="com.liferay.portal.kernel.bean.PortalBeanLocatorUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/pheduyetportlet/init.jsp" %>
<%
   long accountId = ParamUtil.getLong(request, "accountId");
   Account acc = AccountLocalServiceUtil.fetchAccount(accountId);
   JSONObject additionalInfo = JSONFactoryUtil.createJSONObject(acc.getMessage());
   List<Photo> photos = acc.getPhotos(IConstants.CMT);
   int i=0;
   String cmd = Constants.ADD;
   if(Validator.isNotNull(photos)){
   		cmd = Constants.UPDATE;
   }
   String json_XM = additionalInfo.toString();
   int _message = 0 ;
   %>
<portlet:actionURL var="verifyCMTURL" name="verifyCMT"/>


<aui:form  action="<%=verifyCMTURL %>" enctype="multipart/form-data" method="post" name="fm" id="fm">
   <aui:input name="cmd" type="hidden" value="<%=cmd %>" />
   <fieldset class="group"> 
   <ul class="checkbox"> 
   <%
      ArrayList<String> al = new ArrayList<String>();
      try {
          DataSource dataSource = (DataSource) PortalBeanLocatorUtil.locate("liferayDataSource");
          Connection connection =  dataSource.getConnection();
          DatabaseMetaData md = connection.getMetaData();
          ResultSet rs = md.getTables(null, null, "%", null);
          while (rs.next()) {
             //System.out.println("Table : "+rs.getString(3));
             String tableVal = rs.getString(3);
             if(tableVal.equalsIgnoreCase("idm_account"))
             {
                 ResultSet cols = md.getColumns(null, null, rs.getString(3), null);
                 while(cols.next()){
                   
                     String str = cols.getString(4);
                     if( EnumUtils.isValidEnum(AccountEnum.class, str) ){

                        al.add(str);
                     }   
                 }  
             }
         }
      } catch (SQLException e) {
          System.out.println("SQLException: "+ e.getMessage());
      }
      
      		Iterator<String> itr = al.iterator();

          for (String str : al) {
    	  %>
   			
   			 <li><aui:input name="<%= str %>" type="checkbox" disabled="<%=additionalInfo.getBoolean(str)  %>"  checked="<%=additionalInfo.getBoolean(str)  %>"  /></li>
   <%
      }
      
      %>
      <style>
			fieldset.group  { 
			  margin: 0; 
			  padding: 0; 
			  margin-bottom: 1.25em; 
			  padding: .125em; 
			} 
			
			fieldset.group legend { 
			  margin: 0; 
			  padding: 0; 
			  font-weight: bold; 
			  margin-left: 20px; 
			  font-size: 100%; 
			  color: black; 
			} 
			
			
			ul.checkbox  { 
			  margin: 0; 
			  padding: 0; 
			  margin-left: 20px; 
			  list-style: none; 
			} 
			
			ul.checkbox li input { 
			  margin-right: .25em; 
			} 
			
			ul.checkbox li { 
			  border: 1px transparent solid; 
			  display:inline-block;
			  width:12em;
			} 
			
			ul.checkbox li label { 
			  margin-left: ; 
			} 
			ul.checkbox li:hover, 
			ul.checkbox li.focus  { 
			  background-color: lightyellow; 
			  border: 1px gray solid; 
			  width: 12em; 
			} 
 		     .aui .control-group {
    			/* margin-bottom: 30px; */
			}
      </style>
      </ul>
      </fieldset>
   <aui:input type="hidden" name="accountId" value="<%= acc.getAccountId() %>"/>
   <div id="new-fields">
      <%if(Validator.isNull(photos) || photos.size() == 0){ %>
      
      		<div class="lfr-form-row lfr-form-row-inline">     
            <aui:input type="hidden" name="imageId_0" value='0'/>
            <aui:fieldset >
               <aui:column columnWidth="25">
                  <a href="" target="_blank" title=""> 
                  <img src="" class="thumbnail" />
                  </a>
               </aui:column>
               <aui:column columnWidth="75">
                  <aui:input  type="file" name="profilePhoto_0" label="" required="true">
                     <aui:validator name="acceptFiles">
                        'jpg, png, jpeg, tif, gif'
                     </aui:validator>
                  </aui:input>
                  <aui:input name="description_0" label="description" />
               </aui:column>
            </aui:fieldset>
            </div>
            <%}else{
               for (Photo photo: photos) {
               	long imageId = photo.getImageId();
               	long thumbnailId = photo.getThumbnailId();
               	String fldName0 = "imageId_" + i;
               	String fldName1 = "profilePhoto_" + i;
               	String fldName2 = "description_" + i;
               	
               	String thumbnailURL = acc.getThumbnailURL(themeDisplay, photo.getThumbnailId());
               	String phototURL = acc.getPhotoURL(themeDisplay, imageId);
               	
               	%>	
             <div class="lfr-form-row lfr-form-row-inline">  	
            <aui:input type="hidden" name="<%= fldName0 %>" value="<%= imageId %>"/>
            <aui:fieldset >
               <aui:column columnWidth="25">
                  <a href="<%= phototURL %>" target="_blank" title="<%= photo.getDescription() %>"> 
                  <img src="<%= thumbnailURL %>" class="thumbnail" /> 
                  </a>
               </aui:column>
               <aui:column columnWidth="75">
                  <aui:input disabled="<%= photo.isApproved() %>" type="file" name="<%= fldName1 %>" label="" required="<%= ((i==0) && (imageId == 0l)) %>">
                     <aui:validator name="acceptFiles">
                        'jpg, png, jpeg, tif, gif'
                     </aui:validator>
                  </aui:input>
                  <aui:input name="<%= fldName2 %>" label="description" value="<%= photo.getDescription() %>"/>
               </aui:column>
            </aui:fieldset>
            </div>
            <%i++;
               }
               } %>
         
      
   </div>
   <aui:button-row>
      <aui:button name="save" type="submit"  value="save" />
      <aui:button type="button" onClick="javascript:closePopup();" value="close" cssClass="btn-primary"/>
   </aui:button-row>

	<aui:script use="liferay-auto-fields">
	   new Liferay.AutoFields(
	   {
		   contentBox: '#new-fields',
		   fieldIndexes: '<portlet:namespace />responseIndexes'
	   }
	   ).render();
	</aui:script>	

</aui:form>

<aui:script>
   function closePopup() {
	   Liferay.Util.getOpener().updateDataFromPopUp(<%= additionalInfo.toString()%>);
	   Liferay.Util.getOpener().closePopup("popup-cmt-verify");
   }
</aui:script>
