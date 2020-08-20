<%@page import="org.oep.util.PortletKeys"%>
<%@page import="org.oep.util.DateUtil"%>
<%@page import="org.oep.core.logsms.bussiness.QuanLyLogSmsBussiness"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="org.oep.core.service.LogSMSLocalServiceUtil"%>
<%@page import="org.oep.core.model.LogSMS"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/init.jsp" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css">

<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/js/bootstrap-datetimepicker.min.js"></script>
<style type="text/css">
body{
overflow-x:hidden;
}
</style>
<%
PortletURL portletURL = renderResponse.createActionURL();
int cur               = ParamUtil.getInteger(request, PortletKeys.SearchContainer.CURRENT_PAGE, PortletKeys.PAGE);
int delta             = ParamUtil.getInteger(request, PortletKeys.SearchContainer.DELTA, PortletKeys.DELTA);
String msgEmpty       = "Không có dữ liệu";
SearchContainer searchContainer = new SearchContainer<LogSMS>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, portletURL, null, msgEmpty);
String tungay =ParamUtil.getString(request, "tungay",DateUtil.parseDateToString(DateUtil.getBeginOfMonth(new Date()), DateUtil.DATE_FORMAT_D_M_Y)).trim();
String denngay = ParamUtil.getString(request, "denngay",DateUtil.parseDateToString(DateUtil.getCurrentDateTime(), DateUtil.DATE_FORMAT_D_M_Y)).trim();
String keyword =       ParamUtil.getString(request, "keyword","");
String phone = ParamUtil.getString(request, "phone","").trim();
String tungayin = "";
String denngayin = "";
if(!tungay.equals("")){
	tungayin = DateUtil.formatDate(tungay+" 00:00:00", DateUtil.DATE_FORMAT_D_M_Y_H_M_S, DateUtil.DATE_FORMAT_D_M_Y_H_M_S_1);
}
if(!denngay.equals("")){
	denngayin = DateUtil.formatDate(denngay+" 23:59:59", DateUtil.DATE_FORMAT_D_M_Y_H_M_S, DateUtil.DATE_FORMAT_D_M_Y_H_M_S_1);
}
List<LogSMS> resultsAccountRecords = LogSMSLocalServiceUtil.searchByPhone(keyword, tungayin, denngayin, searchContainer.getStart(), searchContainer.getEnd());
int totalAccountRecords = LogSMSLocalServiceUtil.countByPhone(keyword, tungayin, denngayin);
/* if(totalAccountRecords > 0 ){
	resultsAccountRecords = LogSMSLocalServiceUtil.getAll(searchContainer.getStart(), searchContainer.getEnd());
} */

searchContainer.setTotal(totalAccountRecords);
searchContainer.setResults( resultsAccountRecords);
boolean isadmin = false;
//List<LogSMS> resultsAccountRecords = LogSMSLocalServiceUtil.getLogSMSs(-1, -1);
/* SearchContainer searchContainer = new SearchContainer<LogSMS>(RenderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, null, msgEmpty);
 */

%>
<portlet:actionURL name="downloadcsv" var="downloadcsvURL">
</portlet:actionURL>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/quanlylogsms/view.jsp" />
</liferay-portlet:renderURL>
<div class="container" style="background-color: white;">
	<div class="bg-trang">
		<h4 class="tle" style="font-weight: 600 !important;">Quản lý Log
			SMS</h4>
	</div>
	<div class="row">
		<aui:form action="<%=searchURL%>" method="get" name="fm">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label" for="exampleInputEmail1">Tìm
						kiếm</label> <input type="text" class="form-control"
						placeholder="Tìm kiếm theo số điện thoại"
						name="<portlet:namespace/>keyword" value="<%=keyword%>" />
				</div>
			</div>
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd">Từ ngày</label> <input
						type="text" class="form-control" id="startDate"
						name="<portlet:namespace/>tungay" value="<%=tungay%>">
				</div>
			</div>
			<div class="col-md-6" style="background-color: white;">
				<div class="form-group">
					<label class="control-label" for="pwd">Đến ngày</label> <input
						type="text" class="form-control" id="endDate"
						name="<portlet:namespace/>denngay" value="<%=denngay%>">
				</div>
			</div>
			<div class="col-md-12">
				<label class="control-label"></label>
				<div class="text-right" style="padding: 0px;">
					<aui:button type="submit" icon="icon-search" value="search" />
				</div>
			</div>
		</aui:form>
	</div>
	<div class="bg-trang">
		<div class="row">
			<div class="col-md-6">
				<h4 class="tle" style="font-weight: 600 !important;">Danh sách Log SMS</h4>
			</div>
			<div class="col-md-6 text-right" style="padding-top: 12px;">
				<button onclick="downloadCSV();" type="button"
					class="btn btn-default btn-sm">
					<span class="glyphicon glyphicon-cloud-download"></span> Tải về
				</button>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-bordered">
				<thead>
					<tr style="text-align: center;">
						<th style="text-align: center;" scope="col">STT</th>
						<th style="text-align: center;" scope="col">Số điện thoại</th>
						<th style="text-align: center;" scope="col">Thời gian gửi</th>
						<th style="text-align: center;" scope="col">MessageID</th>
						<th style="text-align: center;" scope="col">Mã lỗi</th>
						<th style="text-align: center;" scope="col">Mô tả lỗi</th>
						<th style="text-align: center;" scope="col">Thời gian trả</th>
					</tr>
				</thead>
				<tbody>
					<%
						int stt = searchContainer.getStart() + 1;
						for (LogSMS logsms : resultsAccountRecords) {
					%>

					<tr>
						<td style="text-align: center;"><%=stt++%></td>
						<td style="text-align: center;"><%=logsms.getPhone() != null ? logsms.getPhone() : ""%></td>
						<td style="text-align: center;"><%=DateUtil.parseDateToString(logsms.getSentDateTime(), DateUtil.DATE_FORMAT_D_M_Y_H_M_S)%></td>
						<td style="text-align: center;"><%=logsms.getMessageId()%></td>
						<td style="text-align: center;"><%=logsms.getErrorCode()%></td>
						<td><%=new QuanLyLogSmsBussiness().getErrorFromCode(logsms.getErrorCode())%></td>
						<td style="text-align: center;"><%=DateUtil.parseDateToString(logsms.getSentDateTime(), DateUtil.DATE_FORMAT_D_M_Y_H_M_S)%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<c:if test="<%=searchContainer != null%>">
				<div id="pagination">
					<br />
					<liferay-ui:search-paginator
						searchContainer="<%=searchContainer%>" />
				</div>
			</c:if>
		</div>
	</div>

	<script type="text/javascript">
	
	function downloadCSV(){
		var form = document.createElement('form')
		form.action = "<%= downloadcsvURL %>"
			form.method = "POST"
					var inputfullname = document.createElement('input')
					inputfullname.name="<portlet:namespace/>phone"
					inputfullname.value = "<%=phone%>"
					form.appendChild(inputphone)
					
					var inputtungay = document.createElement('input')
					inputtungay.name="<portlet:namespace/>tungaycsv"
					inputtungay.value = "<%=tungayin%>"
					form.appendChild(inputtungay)
					
					var inputdenngay = document.createElement('input')
					inputdenngay.name="<portlet:namespace/>denngaycsv"
					inputdenngay.value = "<%=denngayin%>"
					form.appendChild(inputdenngay)
					document.body.append(form);
		form.submit()
		document.body.removeChild(form);
	}
	
	//check Date Range

	var bindDateRangeValidation = function (f, s, e) {
	    if(!(f instanceof jQuery)){
				console.log("Not passing a jQuery object");
	    }
	  
	    var jqForm = f,
	        startDateId = s,
	        endDateId = e;
	  
	    var checkDateRange = function (startDate, endDate) {
	        var isValid = (startDate != "" && endDate != "") ? startDate <= endDate : true;
	        return isValid;
	    }

	    var bindValidator = function () {
	        var bstpValidate = jqForm.data('bootstrapValidator');
	        var validateFields = {
	            startDate: {
	                validators: {
	                    notEmpty: { message: 'This field is required.' },
	                    callback: {
	                        message: 'Start Date must less than or equal to End Date.',
	                        callback: function (startDate, validator, $field) {
	                            return checkDateRange(startDate, $('#' + endDateId).val())
	                        }
	                    }
	                }
	            },
	            endDate: {
	                validators: {
	                    notEmpty: { message: 'This field is required.' },
	                    callback: {
	                        message: 'End Date must greater than or equal to Start Date.',
	                        callback: function (endDate, validator, $field) {
	                            return checkDateRange($('#' + startDateId).val(), endDate);
	                        }
	                    }
	                }
	            },
	          	customize: {
	                validators: {
	                    customize: { message: 'customize.' }
	                }
	            }
	        }
	        if (!bstpValidate) {
	            jqForm.bootstrapValidator({
	                excluded: [':disabled'], 
	            })
	        }
	      
	        jqForm.bootstrapValidator('addField', startDateId, validateFields.startDate);
	        jqForm.bootstrapValidator('addField', endDateId, validateFields.endDate);
	      
	    };

	    var hookValidatorEvt = function () {
	        var dateBlur = function (e, bundleDateId, action) {
	            jqForm.bootstrapValidator('revalidateField', e.target.id);
	        }

	        $('#' + startDateId).on("dp.change dp.update blur", function (e) {
	            $('#' + endDateId).data("DateTimePicker").setMinDate(e.date);
	            dateBlur(e, endDateId);
	        });

	        $('#' + endDateId).on("dp.change dp.update blur", function (e) {
	            $('#' + startDateId).data("DateTimePicker").setMaxDate(e.date);
	            dateBlur(e, startDateId);
	        });
	    }

	    bindValidator();
	    hookValidatorEvt();
	};


	$(function () {
	    var sd = null, ed = null;
	  
	    $('#startDate').datetimepicker({ 
	      pickTime: false, 
	      format: "DD/MM/YYYY", 
	      defaultDate: sd, 
	      maxDate: ed 
	    });
	  
	    $('#endDate').datetimepicker({ 
	      pickTime: false, 
	      format: "DD/MM/YYYY", 
	      defaultDate: ed, 
	      minDate: sd 
	    });

	    //passing 1.jquery form object, 2.start date dom Id, 3.end date dom Id
	    bindDateRangeValidation($("#form"), 'startDate', 'endDate');
	});
	</script>