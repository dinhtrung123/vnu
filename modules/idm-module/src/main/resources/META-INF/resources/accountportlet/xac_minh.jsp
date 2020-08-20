<%@page import="dtt.vn.account.business.IConstants"%>
<%@page import="dtt.vn.account.business.Constantes"%>
<%@page import="dtt.vn.account.util.AccountEnum"%>
<%@page import="dtt.vn.account.util.DateUtil"%>
<%@page import="dtt.vn.vnpost.model.Photo"%>
<%@page import="dtt.vn.vnpost.service.DanhMucLocalServiceUtil"%>
<%@page import="dtt.vn.vnpost.model.DanhMuc"%>
<%@page import="dtt.vn.vnpost.model.Account"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/accountportlet/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>



<%
long accountId = ParamUtil.getLong(request, "accountId");
Account account1 = (Account)request.getAttribute("account");
//long accountId = BeanParamUtil.getLong(account1, request, "accountId");
long tinhId = (Long)request.getAttribute("tinhId");
long huyenId =(Long)request.getAttribute("huyenId");
long xaId = (Long)request.getAttribute("xaId");


List<DanhMuc> listTinh = DanhMucLocalServiceUtil.getDanhMuc_By_Nhom_Muc(Constantes.MA, Constantes.MUC_TINH, true);
List<DanhMuc> listXa = new ArrayList<DanhMuc>();
List<DanhMuc> listHuyen = new ArrayList<DanhMuc>();

if(tinhId!=0){
	listHuyen = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(tinhId, true);
	
}
if(huyenId!=0){
	listXa = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(huyenId, true);
}



	 JSONObject additionalInfo = JSONFactoryUtil.createJSONObject(account1.getMessage());
	
	List<Photo> photos = account1.getPhotos(IConstants.CMT);

	String ngaySinh = account1.getBirthdate() !=null ? DateUtil.parseDateToString(account1.getBirthdate(), DateUtil.DATE_FORMAT_D_M_Y)  : StringPool.BLANK; 

	
	
	int i=0;
	
	int _message = 0 ;
/* 	if(photos.get(0).getImageId() > 0) {
		_message  = 1 ;
	}
 */		
	
	
	PortletURL cmtVerifyURL = liferayPortletResponse.createRenderURL();
	cmtVerifyURL.setWindowState(LiferayWindowState.POP_UP); 
	cmtVerifyURL.setParameter("jspPage", "/xacminhportlet/popup-cmt-verify.jsp");
	cmtVerifyURL.setParameter("accountId",Long.toString(account1.getAccountId()));
	
	
	String popup_cmt_verify = "javascript:popup_cmt_verify('"+ cmtVerifyURL.toString()+"');";
	String back_URL = ParamUtil.getString(request, "backURL", "");


	PortletURL levelVerifyURL = renderResponse.createRenderURL();
	levelVerifyURL.setWindowState(LiferayWindowState.POP_UP); 
	levelVerifyURL.setParameter("jspPage", "/xacminhportlet/popup-cmt-verify.jsp");
	levelVerifyURL.setParameter("accountId",Long.toString(account1.getAccountId()));
	
	
	String popup_level_verify = "javascript:popup_level_verify('"+ levelVerifyURL.toString()+"');";
	
		
%>



<portlet:actionURL var="saveAccountURL" name="saveAccount"/>


<portlet:actionURL name="pheDuyet" var="pheDuyetURL">	
	<portlet:param name="accountId" value="<%=String.valueOf(accountId)%>" />
</portlet:actionURL>

	
<aui:input name="accountId" type="hidden" value="<%= account1.getAccountId() %>" />

<aui:model-context bean="<%= account1 %>" model="<%= Account.class %>" />

	<aui:fieldset id='ajax-mask-holder' label="thong-tin-chung">
		<aui:column columnWidth="100">
			<aui:column columnWidth="100">
					<aui:column columnWidth="50" >
						<aui:column columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='ho-ten'/>:</div>
							<label id="verifiaction_hoten"  style="color: maroon;">
							
								<% if(additionalInfo.getBoolean("fullname") ) {%>
									<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
									<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
								<%}%>
							</label>
							
						</aui:column>
					
						<aui:column columnWidth="60" last="true">
							<aui:input label='' name="fullname" type="text"  disabled="true" style="width:95%" inlineLabel="true" maxlength="50" value="<%=account1.getFullName() %>"/>
						</aui:column>
					</aui:column>
				
				
					<aui:column columnWidth="50" >
							<aui:column columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='email'/>:</div>
						<label id="verifiaction_email"  style="color: maroon;">
							<% if(additionalInfo.getBoolean("email")) {%>
									<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
									<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
							<%}%>
						</label>
							
						</aui:column>
						<aui:column columnWidth="60">
							<aui:input label='' name="email" placeholder='usuario@ejemplo.com' type="text"  disabled="true" style="width:95%" inlineLabel="true" maxlength="50"  value="<%=account1.getEmail() %>"/>
							
						</aui:column>
					</aui:column>
			</aui:column>
	
			<aui:column columnWidth="100">
					<aui:column columnWidth="50" >
						<aui:column columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='ngay-sinh'/>:</div>
						<label id="verifiaction_ngaysinh"  style="color: maroon;">
							<% if(additionalInfo.getBoolean("birthdate")) {%>
									<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
									<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
							<%}%>
						</label>
							
						</aui:column>
					
						<aui:column columnWidth="60" last="true">

							<aui:input label='' name="birthdate" type="text"  disabled="true"  style="width:95%" inlineLabel="true"  value="<%=ngaySinh %>"/> 
						</aui:column>
					</aui:column>
				
				
					<aui:column columnWidth="50" >
							<aui:column columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='gender'/>:</div>
						<label id="verifiaction_gender"  style="color: maroon;">
							<% if(additionalInfo.getBoolean("gender")) {%>
									<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
									<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
							<%}%>
						</label>
							
						</aui:column>
						<aui:column columnWidth="60">
							<aui:input inlineLabel="right" name="gender" type="radio"	disabled="true" id="genderMale" value="0" label="male" checked="<%= account1.getGender() ==0%>"  />
							<aui:input inlineLabel="right" name="gender" id="genderFemale"	type="radio"  disabled="true" value="1" label="female" checked="<%= account1.getGender() ==1%>" />
						
							<%-- <aui:input label='' name="gender" type="text"  disabled="true" style="width:95%" inlineLabel="true" maxlength="50"  value="<%=account1.getGender() %>"/> --%>
						</aui:column>
					</aui:column>
			</aui:column>
			<aui:column columnWidth="100">
					<aui:column columnWidth="50" >
						<aui:column columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='noi-sinh'/>:</div>
						<label id="verifiaction_nativePlace"  style="color: maroon;">
							<% if(additionalInfo.getBoolean("nativePlace")) {%>
									<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
									<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
							<%}%>
						</label>
							
						</aui:column>
					
						<aui:column columnWidth="60" last="true">
							<aui:input label='' name="nativePlace" type="text"  disabled="true" style="width:95%" inlineLabel="true" maxlength="50" value="<%=account1.getNativePlace() %>"/>
						</aui:column>
					</aui:column>
				
				
					<aui:column columnWidth="50" >
							<aui:column columnWidth="40" first="true">
								<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='maritalStatus'/>:</div>
						<label id="verifiaction_maritalStatus"  style="color: maroon;">
							<% if(additionalInfo.getBoolean("maritalStatus")) {%>
									<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
									<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
							<%}%>
						</label>
								
							</aui:column>
							<aui:column columnWidth="60">
								
							<aui:select name="maritalStatus" label="" inlineLabel="true" disabled="true">
								<aui:option value="1" selected="<%= account1.getMaritalStatus()==1 %>"> <liferay-ui:message key="doc-than"/> </aui:option>
								<aui:option value="2" selected="<%= account1.getMaritalStatus()==2 %>"> <liferay-ui:message key="ket-hon"/> </aui:option>
								<aui:option value="3" selected="<%= account1.getMaritalStatus()==3 %>"> <liferay-ui:message key="khac"/> </aui:option>
							</aui:select>							
								
								
							</aui:column>
					</aui:column>
					
					
					
					
			</aui:column>			
			<aui:column columnWidth="100">
					<aui:column columnWidth="50" >
						<aui:column columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='nationality'/>:</div>
						<label id="verifiaction_nationality"  style="color: maroon;">
							<% if(additionalInfo.getBoolean("nationality")) {%>
									<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
									<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
							<%}%>
						</label>
							
						</aui:column>
					
						<aui:column columnWidth="60" last="true">
							<aui:input label='' name="nationality" type="text"  disabled="true"  inlineLabel="true"  maxlength="50" style="width:95%" value="<%=account1.getNationality() %>"/>
						</aui:column>
					</aui:column>
				
				
					<aui:column columnWidth="50" >
							<aui:column columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='ethnicGroup'/>:</div>
						<label id="verifiaction_ethnicGroup"  style="color: maroon;">
							<% if(additionalInfo.getBoolean("ethnicGroup")) {%>
									<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
									<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
							<%}%>
						</label>
							
						</aui:column>
						<aui:column columnWidth="60">
							<aui:input label='' name="ethnicGroup" type="text"  disabled="true" inlineLabel="true" style="width:95%" maxlength="50"  value="<%= account1.getEthnicGroup() %>"/>
							
						</aui:column>
					</aui:column>
			</aui:column>			
			<aui:column columnWidth="100">
					<aui:column columnWidth="50" >
						<aui:column columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='tel'/>:</div>
						<label id="verifiaction_telNo"  style="color: maroon;">
							<% if(additionalInfo.getBoolean("telNo")) {%>
									<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
									<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
							<%}%>
						</label>
							
						</aui:column>
					
						<aui:column columnWidth="60" last="true">
							<aui:input label='' name="telNo" type="text"  disabled="true" inlineLabel="true" style="width:95%" maxlength="50" value="<%=account1.getTelNo() %>"/>
						</aui:column>
					</aui:column>
				
				
					<aui:column columnWidth="50" >
					<aui:column columnWidth="40" first="true">
						<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='personalId'/>:</div>
						<label id="verifiaction_personalId"  style="color: maroon;">
							<% if(additionalInfo.getBoolean("personalId")) {%>
									<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
									<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
							<%}%>
						</label>
					</aui:column>
					<aui:column columnWidth="60">
							<aui:input label='' name="personalId"  type="text"  disabled="true" style="width:100%" inlineLabel="true" maxlength="50" value="<%=account1.getPersonalId() %>"/>
					</aui:column>
					</aui:column>
			</aui:column>
			<aui:column columnWidth="100">
					<aui:column columnWidth="50" >
						<aui:column columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='address'/>:</div>
							<label id="verifiaction_address"  style="color: maroon;">
								<% if(additionalInfo.getBoolean("address")) {%>
										<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
										<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
								<%}%>
							</label>
							
						</aui:column>
						<aui:column columnWidth="60">
							<aui:input label='' name="address" type="text"  disabled="true" style="width:95%" inlineLabel="true" maxlength="50"  value="<%=account1.getAddress() %>"/>
							
						</aui:column>
					</aui:column>
					<aui:column columnWidth="50" >
						<aui:fieldset>
							<aui:column>
								<aui:select disabled="true"  required="true" name="tinh" id="tinh" label="" showEmptyOption="<%= false %>" >
									<aui:option value=""><liferay-ui:message key="-chon-tinh-"></liferay-ui:message></aui:option>
									<%
										for (DanhMuc tinh : listTinh) {
									%>
										<aui:option value="<%= tinh.getMa() %>" selected="<%=tinhId == tinh.getId() %>" ><%= tinh.getTen() %></aui:option>
									<%
										}
									%>
								</aui:select>
							</aui:column>
							
							<aui:column>
							<div id="optHuyen">
								<aui:select disabled="true" required="true" name="huyen"  id="huyen" onChange="javascript:selectXa();"  label="" showEmptyOption="<%= false %>">
												<aui:option value=""><liferay-ui:message key="-chon-huyen-"></liferay-ui:message></aui:option>
											<%
												for (DanhMuc huyen : listHuyen) {
											%>
												<aui:option value="<%= huyen.getMa() %>" selected="<%=huyenId == huyen.getId() %>"><%= huyen.getTen() %></aui:option>
											<%
												}
											%>
								</aui:select>
							</div>
							</aui:column>
							
							<aui:column>
							<div id="optXa">
								<aui:select disabled="true" required="true" name="xa"  id="xa" label=""  showEmptyOption="<%= false %>">
												<aui:option value=""><liferay-ui:message key="-chon-xa-"></liferay-ui:message></aui:option>
											<%
												for (DanhMuc xa : listXa) {
											%>
												<aui:option value="<%= xa.getMa() %>" selected="<%=xaId == xa.getId() %>" ><%= xa.getTen() %></aui:option>
											<%
												}
											%>
								</aui:select>
							</div>
							</aui:column>
						</aui:fieldset>	
					</aui:column>
			
			</aui:column>
			
		</aui:column>
	</aui:fieldset>
	<aui:fieldset label="thong-tin-them">
		<aui:column columnWidth="100">
			<aui:column columnWidth="100">
				<aui:column columnWidth="50">
					<aui:column columnWidth="40" first="true">
						<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='taxCode'/>:</div>
						<label id="verifiaction_taxCode"  style="color: maroon;">
							<% if(additionalInfo.getBoolean("taxCode")) {%>
									<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
									<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
							<%}%>
						</label>
						
					</aui:column>
					<aui:column columnWidth="60">
						<aui:input label='' name="taxCode" type="text"  disabled="true" style="width:95%" inlineLabel="true" maxlength="50" value="<%=account1.getTaxCode() %>">
						</aui:input>
					</aui:column>
						
					<aui:column columnWidth="40" first='true'>
						<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='insuranceCode'/>:</div>
						<label id="verifiaction_insuranceCode"  style="color: maroon;">
							<% if(additionalInfo.getBoolean("insuranceCode")) {%>
									<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
									<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
							<%}%>
						</label>
						
					</aui:column>
					<aui:column columnWidth="60">
						<aui:input label="" name="insuranceCode" type="text"  disabled="true" style="width:95%" inlineLabel="true"  maxlength="50" value="<%=account1.getInsuranceCode() %>">
						</aui:input>
					</aui:column>
				</aui:column>
				
				<aui:column columnWidth="50">
					<aui:column columnWidth="40" first="true">
						<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='familyRegNo'/>:</div>
						<label id="verifiaction_familyRegNo"  style="color: maroon;">
							<% if(additionalInfo.getBoolean("familyRegNo")) {%>
									<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
									<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
							<%}%>
						</label>
						
					</aui:column>
					<aui:column columnWidth="60">
						<aui:input label='' name="familyRegNo"  type="text"  disabled="true" style="width:95%" inlineLabel="true" maxlength="50" value="<%=account1.getFamilyRegNo() %>">
						</aui:input>
					</aui:column>
 
					<aui:column columnWidth="40" first="true">
						<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='workingPlace'/>:</div>
						<label id="verifiaction_workingPlace"  style="color: maroon;">
							<% if(additionalInfo.getBoolean("workingPlace")) {%>
									<liferay-ui:icon image="check" url="" message=""/>Đã xác minh <% } else {%>
									<liferay-ui:icon image="close" url="" message=""/>Chưa xác minh
							<%}%>
						</label>
						
					</aui:column>
					<aui:column columnWidth="60">
						<aui:input label='' name="workingPlace"  type="text"  disabled="true" style="width:95%" inlineLabel="true" maxlength="50" value="<%=account1.getWorkingPlace() %>">
						</aui:input>
					</aui:column>
				</aui:column>
			</aui:column>
		</aui:column>
	
	</aui:fieldset>

	<aui:fieldset label="xac-minh">
	
	<fieldset>
		<div id="myGallery">
			<%
				for (Photo photo: photos) {
					long imageId = photo.getImageId();
					long thumbnailId = photo.getThumbnailId();
					String thumbnailURL = account1.getThumbnailURL(themeDisplay, photo.getThumbnailId());
					String phototURL = account1.getPhotoURL(themeDisplay, imageId);
					 JSONObject doVerify = JSONFactoryUtil.createJSONObject(photo.getMessage());
					  String verifyField = "Xác minh các trường:  ";
					  for(AccountEnum env : AccountEnum.values()) {
				    	if(doVerify.getBoolean(env.name()) ) {
				    	    	verifyField = verifyField + LanguageUtil.get(pageContext, env.name()) + ", "; 
				    	    	
				      	}
				    }

					
		 			%>
		 				<aui:column>
							<a href="<%= phototURL %>" title="<%= verifyField %>"> 
								<img src="<%= thumbnailURL %>" class="thumbnail"  />    
							</a>		 				
		 				</aui:column>
					<%
		  		}
		  	%>
		</div>
	</fieldset>
	</aui:fieldset>
	<script>
		YUI().use(
	 		'aui-image-viewer-gallery',
	 		function(Y) {
	   			new Y.ImageViewer({
	       			anim: true,
	       			caption: '',
	       			captionFromTitle: true,
	       			imageAnim: {
	        			duration: 1,
	        			easing: 'easeIn'
	       			},
	       			centered: false,
	       			links: '#myGallery a',
	       			preloadAllImages: false,
	       			showInfo: true,
	     		}).render();
	 		}
		);
	</script>
	
	
	<aui:form name="fm" action="<%=pheDuyetURL %>" method="post">
		<input type="hidden" name="<portlet:namespace/>accountId" />
		<aui:input name="<%=Constants.CMD%>" type="hidden" />
			<aui:button-row >
					
					<aui:button type="cancel" onClick="<%= backURL %>" cssClass="btn-primary"></aui:button>
		
			</aui:button-row>

	</aui:form>	
	 
	

<aui:script>
 
    function popup_cmt_verify1(url) {

        var url = url;

            Liferay.Util.openWindow(
                {
                    dialog: {
                    	
                        cache: false,
                        width: 800,
                   		height: 400,
                        modal: true,
                        centered: true
                    },
                    title: "CMT",
                    id: 'popup-cmt-verify',                
                    uri: url
                }
            );
    }
    
    function popup_cmt_verify(url){
    	
    	openDialogOEPAdv('popup-cmt-verify', 'Xác minh', url, '400', '800');
    }
   
    
    
    function popup_level_verify(url){
    	
    	openDialogOEPAdv('popup-level-verify', 'Mức độ xác minh', url, '400', '800');
    }
    
    
	function closePopup() {
    	Liferay.Util.getOpener().reloadMainPage();
    	Liferay.Util.getOpener().location.reload();
	}
	
	function <portlet:namespace />saveXacMinh() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constantes.XuLy.PHE_DUYET %>";
		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />saveKhongXacMinh() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constantes.XuLy.XULY %>";
		submitForm(document.<portlet:namespace />fm);
	}	
</aui:script>

<aui:script>
     Liferay.provide(window, 'updateDataFromPopUp', function(_message) {
    	 
    	  
    		var json =  JSON.parse(JSON.stringify(_message)) ;
    	 
    		if (json.birthdate=="true"){
    			AUI().one('#verifiaction_ngaysinh').html('Đã xác minh!');
    		}
    		if (json.email=="true"){
    			AUI().one('#verifiaction_email').html('Đã xác minh!');
    		}
    	 
    		if (json.telNo=="true"){
    			AUI().one('#verifiaction_telNo').html('Đã xác minh!');
    		}

    		if (json.personalId=="true"){
    			AUI().one('#verifiaction_personalId').html('Đã xác minh!');
    		}
    		if (json.gender=="true"){
    			AUI().one('#verifiaction_gender').html('Đã xác minh!');
    		}
	    		
    		if (json.address=="true"){
    			AUI().one('#verifiaction_address').html('Đã xác minh!');
    		}
    		if (json.taxCode=="true"){
    			AUI().one('#verifiaction_taxCode').html('Đã xác minh!');
    		}
    		if (json.insuranceCode=="true"){
    			AUI().one('#verifiaction_insuranceCode').html('Đã xác minh!');
    		}
    		if (json.nationality=="true"){
    			AUI().one('#verifiaction_nationality').html('Đã xác minh!');
    		}
    		if (json.ethnicGroup=="true"){
    			AUI().one('#verifiaction_ethnicGroup').html('Đã xác minh!');
    		}
    		if (json.familyRegNo=="true"){
    			AUI().one('#verifiaction_familyRegNo').html('Đã xác minh!');
    		}
    		if (json.maritalStatus=="true"){
    			AUI().one('#verifiaction_maritalStatus').html('Đã xác minh!');
    		}
    		if (json.nativePlace=="true"){
    			AUI().one('#verifiaction_nativePlace').html('Đã xác minh!');
    		}
    		if (json.workingPlace=="true"){
    			AUI().one('#verifiaction_workingPlace').html('Đã xác minh!');
    		}

        }
     );
 </aui:script>