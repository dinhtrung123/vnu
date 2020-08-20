
<%@page import="org.oep.danhmuc.portlet.quanly.keys.QuanLyKeys"%>
<%@page import="org.oep.danhmuc.service.DanhMucLocalServiceUtil"%>
<%@page import="org.oep.danhmuc.model.DanhMuc"%>
<%@page import="org.oep.danhmuc.service.NhomLocalServiceUtil"%>
<%@page import="org.oep.danhmuc.model.Nhom"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.danhmuc.util.QuanlyUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="org.oep.danhmuc.portlet.quanly.business.QuanLyBusiness"%>
<%@page import="org.oep.danhmuc.util.PortletKeys"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/quanlyaction/init.jsp" %>

<%
String curentUrl = ParamUtil.getString(request, QuanLyKeys.Base.CURENT_URL);
PortletPreferences prefs = renderRequest.getPreferences();
String groupIdDuocChon = "";
long idNhomDuocChon = ParamUtil.getLong(request, QuanLyKeys.Base.ID_NHOM_DUOC_CHON); 
List<Nhom> lstNhomDuocChon = new ArrayList<Nhom>();
 if(!prefs.getValue(QuanLyKeys.Prefs.NHOM_DANH_MUC, "").isEmpty()){
	//Already config case
		groupIdDuocChon = prefs.getValue(QuanLyKeys.Prefs.NHOM_DANH_MUC, "");
		long[] groupIdArr = QuanlyUtil.convertToLongArray(groupIdDuocChon, ",");
		for(long i: groupIdArr){
			Nhom nhom = NhomLocalServiceUtil.fetchNhom(i);
			if(nhom != null){
				lstNhomDuocChon.add(nhom);
			}
		}
	}else{
	//not config case
		lstNhomDuocChon = NhomLocalServiceUtil.getNhoms(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
long selectedId = ParamUtil.getLong(request, QuanLyKeys.Base.SELECTED_ID);
int checkAddEdit = ParamUtil.getInteger(request, QuanLyKeys.Base.CHECK_ADD_EDIT);
DanhMuc item = DanhMucLocalServiceUtil.fetchDanhMuc(selectedId);
long checkFirstTime = ParamUtil.getLong(request, QuanLyKeys.Base.CHECK_FIRST_TIME);
long parentId = 0;

String firstTimeSuaDanhMuc = (String)request.getSession().getAttribute("FirstTimeSuaDanhMuc");
String ma = "";
String ten = "";
if(checkAddEdit == 1){
	if(checkFirstTime == 1){
		ma = item.getMa();
		ten = item.getTen();
	}
	else{
		ma = ParamUtil.getString(request, QuanLyKeys.Base.MA);
		ten = ParamUtil.getString(request, QuanLyKeys.Base.TEN);
	}
}

if (item != null && item.getChaId() != 0){
	parentId = item.getChaId();
}
List<DanhMuc> listAnhChi = new ArrayList<DanhMuc>();
if (item != null){
	if(checkAddEdit ==0){
		listAnhChi = DanhMucLocalServiceUtil.getByP(item.getId());
	}
	else{
		List<DanhMuc> list = new ArrayList<DanhMuc>();
		if(item.getChaId() > 0) {
			list = DanhMucLocalServiceUtil.getByP(item.getChaId());
		} else {
			list = DanhMucLocalServiceUtil.getAllByNhomIdMuc(item.getNhomId(), item.getMuc());
		}
		for(DanhMuc i: list){
			if(i.getId() != selectedId){
				listAnhChi.add(i);
			}
		}
	}
}
else{
	listAnhChi = DanhMucLocalServiceUtil.getByMUC(0);
}
%>

<portlet:renderURL var="quayLaiUrl" >
	<portlet:param name="<%= PortletKeys.SET_VIEW_PARAMETER %>" value="/quanlyaction/view.jsp"/>
	<portlet:param name="<%=QuanLyKeys.Base.SELECTED_ID %>" value="<%=checkAddEdit ==1 ? String.valueOf(parentId) : String.valueOf(selectedId) %>"/>
</portlet:renderURL>

<portlet:renderURL var="redirectUrl" >
	<portlet:param name="<%= PortletKeys.SET_VIEW_PARAMETER %>" value="/quanlyaction/view.jsp"/>
	<portlet:param name="<%=QuanLyKeys.Base.SELECTED_ID %>" value="<%=String.valueOf(parentId) %>"/>
</portlet:renderURL>


<portlet:actionURL var = "ghiLaiItemURL" name = "ghiLaiItem">
	<portlet:param name="<%=PortletKeys.SET_VIEW_PARAMETER %>" value="/quanlyaction/them_item.jsp"/>
 	<portlet:param name="<%=PortletKeys.REDIRECT_PAGE%>" value="<%=redirectUrl %>"/>
 	<portlet:param name="<%=QuanLyKeys.Base.CHECK_ADD_EDIT %>" value="<%=String.valueOf(checkAddEdit)%>"/>
 	<portlet:param name="<%=QuanLyKeys.Base.SELECTED_ID %>" value="<%=String.valueOf(selectedId) %>"/>
 </portlet:actionURL>

 <div class = "oep-container">
	<aui:form name="fmt" method="post" action = "<%=ghiLaiItemURL %>">
		
		<table class="oep-table-form" width = "100%" align = "center">
			<tr style="display: none;">
				<td>
					<select style="display: none;"	id="oep-form-errors">
						<option value="<portlet:namespace/><%= QuanLyKeys.Base.TEN %>">
			  				<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_EMPTY_TEN %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_EMPTY_TEN %>"/>
			  			</option>
			  			<option value="<portlet:namespace/><%= QuanLyKeys.Base.TEN %>">
			  				<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_DUPLICATE_TEN %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_DUPLICATE_TEN %>"/>
			  			</option>
			  			<option value="<portlet:namespace/><%= QuanLyKeys.Base.MA %>">
			  				<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_EMPTY_MA %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_EMPTY_MA %>"/>
			  			</option>
			  			<option value="<portlet:namespace/><%= QuanLyKeys.Base.MA %>">
			  				<liferay-ui:error key="<%= QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_DUPLICATE_MA %>" message = "<%=  QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_DUPLICATE_MA %>"/>
			  			</option>
			  		</select>
			  	</td>
			</tr>
			<tr>
				<td colspan="11">
					<c:choose>
						<c:when test="<%= checkAddEdit == 1 %>">
							</br>
							<label style = "font-weight:bold; font-size:18px"><liferay-ui:message key="org.oep.portlet.quanly.label.sua"/></label>
						</c:when>
						<c:otherwise>
							</br>
							<label style = "font-weight:bold; font-size:18px"><liferay-ui:message key="org.oep.portlet.quanly.label.themmoi"/></label>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td colspan="9">
					</br>
					<label><liferay-ui:message key="org.oep.portlet.quanly.label.ten"/></label>(<label class="oep-label-red">*</label>)
				</td>
				<td colspan="2">
					</br>
					<label ><liferay-ui:message key="org.oep.portlet.quanly.label.ma"/></label>(<label class="oep-label-red">*</label>)
				</td>
			</tr>
				<td colspan="9">
					<aui:input style = "width: 98%;" type="text" cssClass="oep-inputfield"  maxlength = "<%= QuanLyKeys.Base.TEN_MAX_LENGTH %>" label = "" id = "<%=QuanLyKeys.Base.TEN %>" name = "<%=QuanLyKeys.Base.TEN %>" />
				</td>
				<td colspan="2">
					<aui:input style="width: 97%;" type="text" cssClass="oep-inputfield"  maxlength = "<%= QuanLyKeys.Base.MA_MAX_LENGTH %>" label = "" id = "<%=QuanLyKeys.Base.MA %>" name = "<%=QuanLyKeys.Base.MA %>" />
				</td>
			<tr>
				<td colspan = "3">
					<label><liferay-ui:message key="org.oep.portlet.quanly.label.mota"/></label>
				</td>
			</tr>
			<tr>
				<td colspan="11">
					<aui:input type="textarea" maxlength = "<%= QuanLyKeys.Base.MOTA_MAX_LENGTH %>" label = "" id = "<%=QuanLyKeys.Base.MOTA %>" name = "<%=QuanLyKeys.Base.MOTA %>" style = "width:98%; height:70px"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<label style="margin-right: 18% !important;"><liferay-ui:message key="org.oep.portlet.quanly.label.nhomdanhmuc"/></label>
				</td>
				<td colspan="2">
					<label style="margin-right: 12% !important;"><liferay-ui:message key="org.oep.portlet.quanly.label.trangthai"/></label>
				</td>
				<td colspan="6">
					<label><liferay-ui:message key="org.oep.portlet.quanly.label.thutu"/></label>
				</td>
			</tr>
			<tr>	
				<td colspan="3">
					<aui:select cssClass="oep-select" style="width:99%;" onChange="getThuTuHienThi();" label="" name="<%=QuanLyKeys.Base.NHOM_DANH_MUC %>" id="<%=QuanLyKeys.Base.NHOM_DANH_MUC %>">
						<%for (Nhom n : lstNhomDuocChon){%>
						<aui:option value="<%=n.getId() %>" selected="<%= idNhomDuocChon == n.getId() %>"><%=n.getTen() %></aui:option>
						<% }%>
					  </aui:select>
				</td>
				<td colspan="2">
					<aui:select cssClass="oep-select" style="width:98%;" label="" name="<%=QuanLyKeys.Base.TRANG_THAI %>" id="<%=QuanLyKeys.Base.TRANG_THAI %>">
						<aui:option value = "1"><liferay-ui:message key="org.oep.portlet.quanly.select.hoatdong"/></aui:option>
						<aui:option value = "0"><liferay-ui:message key="org.oep.portlet.quanly.select.khonghoatdong"/></aui:option>
					</aui:select>
				</td>
				<td colspan="6">
					<aui:select cssClass="oep-select" style="width:98%;" label="" name="<%=QuanLyKeys.Base.THUTU_HIENTHI %>" id="<%=QuanLyKeys.Base.THUTU_HIENTHI %>">
						<aui:option value = "0"><liferay-ui:message key="org.oep.portlet.quanly.select.thutuhienthi"/></aui:option>
						<%if(listAnhChi != null || listAnhChi.size() >0){
						for(DanhMuc i : listAnhChi){%>
							<aui:option value = "<%=i.getId() %>"><%=i.getTen() %></aui:option>
						<%}
						}%>
			  		</aui:select>
			  	</td>
			</tr>
			<tr>
				<td colspan="3">
					<label class="oep-label-note"><liferay-ui:message key="org.oep.portlet.quanly.label.ghichu1"/></label>
					<label class="oep-label-red">&nbsp*&nbsp</label>
					<label class ="oep-label-note"><liferay-ui:message key="org.oep.portlet.quanly.label.ghichu2"/></label>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<button type = "submit" class = "oep-button primary save" style = ""  >
						<liferay-ui:message key="org.oep.portlet.quanly.button.ghilai"/>
					</button>
					<button type = "button" class = "oep-button undo" style = "" onclick = 'location.href = "<%= curentUrl %>";'>
						<liferay-ui:message key="org.oep.portlet.quanly.button.quaylai"/>
					</button>
				</td>
			</tr>

		</table>
	</aui:form>
 </div>
 
<portlet:resourceURL var="resourceURL"/>
<script>
 	$( document ).ready(function() {
 		<%if(checkAddEdit == 1) {
 		DanhMuc nextItem = DanhMucLocalServiceUtil.getNextItem(item.getChaId(), item);
 		%>
 		$("#<portlet:namespace/><%=QuanLyKeys.Base.TEN%>").val("<%=HtmlUtil.escapeJS(ten)%>");
 		$("#<portlet:namespace/><%=QuanLyKeys.Base.MA%>").val("<%=HtmlUtil.escapeJS(ma)%>");
 		$("#<portlet:namespace/><%=QuanLyKeys.Base.MOTA%>").val("<%=HtmlUtil.escapeJS(item.getMoTa())%>");
		$("#<portlet:namespace/><%=QuanLyKeys.Base.NHOM_DANH_MUC%>").val("<%=item.getNhomId()%>");
 		$("#<portlet:namespace/><%=QuanLyKeys.Base.TRANG_THAI%>").val("<%=item.getTrangThai()? '1':'0'%>");
 		<%if(item.getThuTuHienThi()>0){%>
 		$("#<portlet:namespace/><%=QuanLyKeys.Base.THUTU_HIENTHI%>").val(<%=nextItem.getId()%>);
		<%}
		if (item.getChaId()!= 0){%>
 		$("#<portlet:namespace/><%=QuanLyKeys.Base.NHOM_DANH_MUC%>").attr('disabled', 'disabled');
		<%}
 		}
 		else{
 			if (item != null && selectedId != 0){%>
 			$("#<portlet:namespace/><%=QuanLyKeys.Base.NHOM_DANH_MUC%>").attr('disabled', 'disabled');
 			$("#<portlet:namespace/><%=QuanLyKeys.Base.NHOM_DANH_MUC%>").val("<%=item.getNhomId()%>");
 			<%}else{
 				
 			}
 		}%>
 		
	});
 	
 	function getThuTuHienThi() {
 		var nhomDanhMucId = $('#<portlet:namespace/><%=QuanLyKeys.Base.NHOM_DANH_MUC %>').val();  
 		var selThuTuHienThi = $('#<portlet:namespace/><%=QuanLyKeys.Base.THUTU_HIENTHI %>');
 		if(nhomDanhMucId > 0) {
 			var params = {
 					<portlet:namespace/>type: "getThuTuHienThi",
 					<portlet:namespace/>nhomDanhMucId : nhomDanhMucId
 	            };
 			$.ajax({
 				url: '<%=resourceURL %>',
 				dataType : "json",
 				data :params,
 				type : "POST",
 				success : function(data) {
 					var select = selThuTuHienThi;
 					select.find('option').remove();
 					$('#<portlet:namespace/><%=QuanLyKeys.Base.THUTU_HIENTHI %>').append($('<option>', {
 				        value: "",
 				        text: '<liferay-ui:message key="org.oep.portlet.quanly.select.thutuhienthi"/>'
			       	}));
 					$.each(data, function(idx, obj) {
 						$('<option>').val(obj.id).text(obj.name).appendTo(select);
 					});
 				}
 			});
 		}
 	}
 	
 	<%if(checkAddEdit ==0){%>
 		getThuTuHienThi();
 	<%}%>
</script>