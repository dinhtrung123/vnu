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
<%-- 	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
 --%>	


<aui:model-context bean="<%= account1 %>" model="<%= Account.class %>" />

	<aui:fieldset id='ajax-mask-holder' label="thong-tin-chung">
		<aui:col columnWidth="100">
			<aui:col columnWidth="100">
					<aui:col columnWidth="50" >
						<aui:col columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='ho-ten'/>:</div>
						</aui:col>
					
						<aui:col columnWidth="60" last="true">
							<aui:input label='' required="true"  name="fullname" type="text" style="width:95%" inlineLabel="true" maxlength="50" value="<%=account1.getFullName() %>"/>
						</aui:col>
					</aui:col>
				
				
					<aui:col columnWidth="50" >
							<aui:col columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='email'/>:</div>
						</aui:col>
						<aui:col columnWidth="60">
							<aui:input label='' required="true"  name="email" placeholder='email@sample.com' type="text" style="width:95%" inlineLabel="true" maxlength="50"  value="<%=account1.getEmail() %>">
									<aui:validator name="email"/>
									<aui:validator name="custom" errorMessage="email-already-exists">
										function() {
											return emailNotExists();					
										}
									</aui:validator>				
							</aui:input>
						</aui:col>
					</aui:col>
			</aui:col>
	
			<aui:col columnWidth="100">
					<aui:col columnWidth="50" >
						<aui:col columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='ngay-sinh'/>:</div>
						</aui:col>
					
						<aui:col columnWidth="60" last="true">
							<aui:input label='' required="true"  name="ngaySinh" type="text"  style="width:95%" inlineLabel="true"  value="<%=ngaySinh %>"/> 
						</aui:col>
					</aui:col>
				
				
					<aui:col columnWidth="50" >
							<aui:col columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='gender'/>:</div>
						</aui:col>
						<aui:col columnWidth="60">
							<aui:input inlineLabel="right" name="gender" type="radio"	id="genderMale" value="0" label="male" checked="<%= account1.getGender() ==0%>"  />
							<aui:input inlineLabel="right" name="gender" id="genderFemale"	type="radio" value="1" label="female" checked="<%= account1.getGender() ==1%>" />
						
							<%-- <aui:input label='' name="gender" type="text" style="width:95%" inlineLabel="true" maxlength="50"  value="<%=account1.getGender() %>"/> --%>
						</aui:col>
					</aui:col>
			</aui:col>
			<aui:col columnWidth="100">
					<aui:col columnWidth="50" >
						<aui:col columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='noi-sinh'/>:</div>
						</aui:col>
					
						<aui:col columnWidth="60" last="true">
							<aui:input label='' required="true"  name="nativePlace" type="text" style="width:95%" inlineLabel="true" maxlength="50" value="<%=account1.getNativePlace() %>"/>
						</aui:col>
					</aui:col>
				
				
					<aui:col columnWidth="50" >
							<aui:col columnWidth="40" first="true">
								<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='maritalStatus'/>:</div>
							</aui:col>
							<aui:col columnWidth="60">
								
							<aui:select required="true"  name="maritalStatus" label="" inlineLabel="true">
								<aui:option value="1" selected="<%= account1.getMaritalStatus()==1 %>"> <liferay-ui:message key="doc-than"/> </aui:option>
								<aui:option value="2" selected="<%= account1.getMaritalStatus()==2 %>"> <liferay-ui:message key="ket-hon"/> </aui:option>
								<aui:option value="3" selected="<%= account1.getMaritalStatus()==3 %>"> <liferay-ui:message key="khac"/> </aui:option>
							</aui:select>							
								
								
							</aui:col>
					</aui:col>
					
					
					
					
			</aui:col>			
			<aui:col columnWidth="100">
					<aui:col columnWidth="50" >
						<aui:col columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='nationality'/>:</div>
						</aui:col>
					
						<aui:col columnWidth="60" last="true">
							<aui:input label='' required="true"  name="nationality" type="text"  inlineLabel="true"  maxlength="50" style="width:95%" value="<%=account1.getNationality() %>"/>
						</aui:col>
					</aui:col>
				
				
					<aui:col columnWidth="50" >
							<aui:col columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='ethnicGroup'/>:</div>
						</aui:col>
						<aui:col columnWidth="60">
							<aui:input label='' required="true"  name="ethnicGroup" type="text" inlineLabel="true" style="width:95%" maxlength="50"  value="<%= account1.getEthnicGroup() %>"/>
							
						</aui:col>
					</aui:col>
			</aui:col>			
			<aui:col columnWidth="100">
					<aui:col columnWidth="50" >
						<aui:col columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='tel'/>:</div>
						</aui:col>
					
						<aui:col columnWidth="60" last="true">
							<aui:input label='' required="true"  name="telNo" type="text" inlineLabel="true" style="width:95%" maxlength="50" value="<%=account1.getTelNo() %>"/>
						</aui:col>
					</aui:col>
				
					<aui:col columnWidth="50" >
						<aui:col columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='personalId'/>:</div>
						</aui:col>
						<aui:col columnWidth="60" last="true">
							<aui:input label='' required="true"  name="personalId"  type="text" style="width:95%" inlineLabel="true" maxlength="50" value="<%=account1.getPersonalId() %>">
										<aui:validator name="custom" errorMessage="cmt-already-exists">
											function() {
												return personalIdNotExists();					
											}
										</aui:validator>				
							</aui:input>
	
						</aui:col>
					</aui:col>
					
			</aui:col>
 			<aui:col columnWidth="100">
					<aui:col columnWidth="50" >
							<aui:col columnWidth="40" first="true">
							<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='address'/>:</div>
						</aui:col>
						<aui:col columnWidth="60">
							<aui:input label='' required="true"  name="address" type="text" style="width:95%" inlineLabel="true" maxlength="50"  value="<%=account1.getAddress() %>"/>
							
						</aui:col>
					            
					</aui:col>
					<aui:col columnWidth="50" >
						<aui:fieldset>
							<aui:col>
								<aui:select   required="false" name="tinh" id="tinh" label="" showEmptyOption="<%= false %>" >
									<aui:option value=""><liferay-ui:message key="-chon-tinh-"></liferay-ui:message></aui:option>
									<%
										for (DanhMuc tinh : listTinh) {
									%>
										<aui:option value="<%= tinh.getMa() %>" selected="<%=tinhId == tinh.getId() %>" ><%= tinh.getTen() %></aui:option>
									<%
										}
									%>
								</aui:select>
							</aui:col>
							
							<aui:col>
							<div id="optHuyen">
								<aui:select required="false" name="huyen"  id="huyen" onChange="javascript:selectXa();"  label="" showEmptyOption="<%= false %>">
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
							</aui:col>
							
							<aui:col>
							<div id="optXa">
								<aui:select required="false" name="xa"  id="xa" label=""  showEmptyOption="<%= false %>">
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
							</aui:col>
						</aui:fieldset>	
					</aui:col>
			
			</aui:col>

		</aui:col> 
		
	</aui:fieldset>

	
	<aui:fieldset label="thong-tin-them">
		<aui:col columnWidth="100">
			<aui:col columnWidth="100">
				<aui:col columnWidth="50">
					<aui:col columnWidth="40" first="true">
						<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='taxCode'/>:</div>
					</aui:col>
					<aui:col columnWidth="60">
						<aui:input label='' name="taxCode" type="text" style="width:95%" inlineLabel="true" maxlength="50" value="<%=account1.getTaxCode() %>">
						</aui:input>
					</aui:col>
						
					<aui:col columnWidth="40" first='true'>
						<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='insuranceCode'/>:</div>
					</aui:col>
					<aui:col columnWidth="60">
						<aui:input label="" name="insuranceCode" type="text" style="width:95%" inlineLabel="true"  maxlength="50" value="<%=account1.getInsuranceCode() %>">
						</aui:input>
					</aui:col>
				</aui:col>
				
				<aui:col columnWidth="50">
					<aui:col columnWidth="40" first="true">
						<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='familyRegNo'/>:</div>
					</aui:col>
					<aui:col columnWidth="60">
						<aui:input label='' name="familyRegNo"  type="text" style="width:95%" inlineLabel="true" maxlength="50" value="<%=account1.getFamilyRegNo() %>">
						</aui:input>
					</aui:col>

					<aui:col columnWidth="40" first="true">
						<div style='font-weight:bold; margin-top: 5px;'><liferay-ui:message key='workingPlace'/>:</div>
					</aui:col>
					<aui:col columnWidth="60">
						<aui:input label='' name="workingPlace"  type="text" style="width:95%" inlineLabel="true" maxlength="50" value="<%=account1.getWorkingPlace() %>">
						</aui:input>
					</aui:col>

				</aui:col>

			</aui:col>
		</aui:col>
	
	</aui:fieldset>
	<aui:button-row >
		<aui:button name="save" type="submit" value="save" />
	</aui:button-row>




</aui:form>


<aui:script>

		
AUI().use('aui-datepicker', function(A) {
	new A.DatePicker({
		trigger : '#<portlet:namespace/>ngaySinh',
		popover : {
		zIndex : 1
	},
	 mask: '%d/%m/%Y'
	});
});	

function emailNotExists() {
	var frm = document.<portlet:namespace/>fm;
	var ele = frm.<portlet:namespace/>email;

	var ajaxURL = Liferay.PortletURL.createResourceURL();
	ajaxURL.setPortletId('account_WAR_idm1portlet');
	ajaxURL.setParameter('<%= Constants.CMD %>', '<%= "checkDuplicate" %>');
	ajaxURL.setParameter('emailAddress', ele.value);
	ajaxURL.setParameter('accountId',  '<%= accountId %>');
	ajaxURL.setWindowState('<%= LiferayWindowState.EXCLUSIVE.toString() %>');
	
	var notExists = true;
	AUI().io.request('<%= themeDisplay.getURLPortal() %>' + ajaxURL, {
		sync: true,
		on: {
			success: function() {
				notExists = (!(eval(this.get('responseData'))));
			}
		}
	});
	
	return notExists;
}

function personalIdNotExists() {
	var frm = document.<portlet:namespace/>fm;
	var ele = frm.<portlet:namespace/>personalId;

	var ajaxURL = Liferay.PortletURL.createResourceURL();
	ajaxURL.setPortletId('account_WAR_idm1portlet');
	ajaxURL.setParameter('<%= Constants.CMD %>', '<%= "personalIdcheckDuplicate" %>');
	ajaxURL.setParameter('personalId', ele.value);
	ajaxURL.setParameter('accountId',  '<%= accountId %>');
	ajaxURL.setWindowState('<%= LiferayWindowState.EXCLUSIVE.toString() %>');
	
	var notExists = true;
	AUI().io.request('<%= themeDisplay.getURLPortal() %>' + ajaxURL, {
		sync: true,
		on: {
			success: function() {
				notExists = (!(eval(this.get('responseData'))));
			}
		}
	});
	
	return notExists;
}

</aui:script>


<script type="text/javascript">
	AUI().ready(function(A){
		var capTinhInput = A.one("#<portlet:namespace/>tinh");
		var capHuyenInput = A.one("#<portlet:namespace/>huyen");
		
		capTinhInput.on('change', function(){
			var capHuyenId = capHuyenInput.val();
			var capTinhId = capTinhInput.val();
			selectHuyen(capTinhId, capHuyenId);
			selectXaId(capHuyenId);
		});
		
		
	 	capHuyenInput.on('change', function(){
			var capTinhId = capTinhInput.val();
			var capHuyenId = capHuyenInput.val();
			selectXa(capHuyenId);
		});		 
	});
	
	function selectHuyen(capTinhId, capHuyenId){
		AUI().use('aui-base','aui-io-request', function(A){
			
	
			//aui ajax call to get updated content
			A.io.request('<%= selectHuyen %>',
			{
				dataType: 'text/html',
				method: 'GET',
				data: { 
					"<portlet:namespace />capTinhId": capTinhId,
					"<portlet:namespace />capHuyenId": capHuyenId
				},
				on: {
					success: function() {
						var optHuyen = A.one("#optHuyen");
						optHuyen.set("innerHTML", this.get('responseData'));
					} 
				}
			});
		});	
	}
	
	function selectXa(){
		AUI().use('aui-base','aui-io-request', function(A){
			//aui ajax call to get updated content
			var capTinhInput = A.one("#<portlet:namespace/>tinh");
			var capHuyenInput = A.one("#<portlet:namespace/>huyen");
			
	
			A.io.request('<%= selectXa %>',
			{
				dataType: 'text/html',
				method: 'GET',
				data: { 
					"<portlet:namespace />capTinhId": capTinhInput.val(),
					"<portlet:namespace />capHuyenId": capHuyenInput.val()
				},
				on: {
					success: function() {
						var optXa = A.one("#optXa");
						optXa.set("innerHTML", this.get('responseData'));
					} 
				}
			});
		});	
	}
	
	function selectXaId(capHuyenId){
		AUI().use('aui-base','aui-io-request', function(A){
			//aui ajax call to get updated content
			var capTinhInput = A.one("#<portlet:namespace/>tinh");
			var capHuyenInput = A.one("#<portlet:namespace/>huyen");
			
	
			A.io.request('<%= selectXa %>',
			{
				dataType: 'text/html',
				method: 'GET',
				data: { 
					"<portlet:namespace />capTinhId": capTinhInput.val(),
					"<portlet:namespace />capHuyenId": capHuyenId
				},
				on: {
					success: function() {
						var optXa = A.one("#optXa");
						optXa.set("innerHTML", this.get('responseData'));
					} 
				}
			});
		});	
	}
</script>
