function fillDataToSelect(portletId , resourceId, paramKey, paramValue, defaultText, select){
	var resourceURL= Liferay.PortletURL.createResourceURL();
	resourceURL.setWindowState("normal");
	resourceURL.setPortletMode("view");
	resourceURL.setPortletId(portletId);
	resourceURL.setResourceId(resourceId);
	resourceURL.setParameter(paramKey, paramValue);
 
	AUI().use('aui-io-request', function(A){
	   A.io.request(
	   resourceURL.toString(),
	   {
		   dataType: 'JSON',
		   on: {
			   success: function() {
				   var datas = this.get('responseData');
				   if(datas){
					   select.empty();
					   select.append($('<option>', {
						   value: "",
						   text: defaultText
					   }));
					   for(var i = 0; i < datas.length; i++){
						   select.append($('<option>', {
							   value: datas[i].id,
							   text: datas[i].key
						   }));
					   }
				   }
			   }
		   }
	   });
	}); 
}


function OEPFillSelectData(selElement, data, keyFieldName, valueFieldName, blankOptionText){
	$(selElement).empty();
	$(selElement).append($('<option>', {
		value: "",
		text: blankOptionText
	}));
	for(var i = 0; i < data.length; i++){
		$(selElement).append($('<option>', {
			value: data[i][keyFieldName],
			text: data[i][valueFieldName]
		}));
	}
}

function openDialogOEP(title, url,height,width){
	 AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated',function(A){
	    var login_popup= Liferay.Util.Window.getWindow(
	                {
	                    dialog: {
	                        centered: true,
	                        constrain2view: true,
	                        modal: true,
	                        resizable: false,
	                        width: width,
	                        height:height
	                        
	                    }
	                }).plug(A.Plugin.DialogIframe,
	                     {
	                     autoLoad: true,
	                     iframeCssClass: 'dialog-iframe',
	                     uri:url
	                     }).render();
	             login_popup.show();
	                     login_popup.titleNode.html(title);
	 
	     });
}

//added by Duongpt
//Date: 2016-08-04
//Notes: Bo sung ham close popup

function openDialogOEPAdv(popId, title, url, height, width){

AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated',function(A){
	 Liferay.Util.Window.getWindow( {
                   dialog: {
                   	centered: true,
                       constrain2view: true,
                       modal: true,
                       resizable: false,
                       width: width,
                       height: height
                       
                   },
                   id: popId,
                   title: title,
                   uri: url
               });
	 
	 	//Liferay.Util.getOpener().closePopup('dialog');
	 	Liferay.provide(
			    window,
			    'closePopup',
			        function(popupIdToClose) {

			            var popupDialog = Liferay.Util.Window.getById(popupIdToClose);

			            popupDialog.destroy();
			        },
			        ['liferay-util-window']
			    );
	 	// Liferay.Util.getOpener().refreshPortlet();
	 	Liferay.provide(window, 'refreshPortlet', function() {
	 	        var curPortlet = '#p_p_id<portlet:namespace/>';
	 		       Liferay.Portlet.refresh(curPortlet);
	 		    },
	 		    ['aui-dialog','aui-dialog-iframe']
	 	  );

    });
	
}

function moveOptions(fromId,toId){
$("#"+fromId+" option").each(function() {
	if(this.selected){			
		$('#'+toId).append($('<option>', { 
	        value: this.value,
	        text : this.text 
	    }));
		
		$(this).remove();
	}
   
});
}

function searchOptions(keyword,dataId,fromId,toId){
removeAllOptions(fromId);
$("#"+dataId+" option").each(function() {
	
	if(existOptions(toId, this.value) == false){
		if(keyword==null || keyword =='' || this.text.toUpperCase().indexOf(keyword.toUpperCase()) !=-1){
			$('#'+fromId).append($('<option>', { 
		        value: this.value,
		        text : this.text 
		    }));
		}
		
	}
   
});
}


function existOptions(selectId,optionValue){
var result = false;
$("#"+selectId+" option").each(function() {		
	if(this.value == optionValue){			
		result =true;
	}
   
});
return result;
}
function removeAllOptions(selectId){

$("#"+selectId+" option").each(function() {
	$(this).remove();
   
});

}

function showTooltipByElementType(){
	$('input[type="text"],input[type="password"],input[type="checkbox"],input[type="file"],select').tooltip({
		 position: {
		 my: "center bottom-1",
		 at: "center top",
		 using: function( position, feedback ) {
		 $( this ).css( position );
		 $( "<div>" )		 
		 
		 .addClass( feedback.horizontal )
		 .appendTo( this );
		 }
		 }
		 });
	
}

function enterErrorToInputField(){
var exist = false;
$("#oep-form-errors option").each(function() {		
	if(this.text != null && this.text !="" && this.text != " "){
		var obj = document.getElementById(this.value);		
		if(obj != null){
			var style = obj.getAttribute("style");		
			obj.setAttribute("style",style+";background-color:rgb(254,243,244);border: 1px solid red;");
			var title = obj.getAttribute("title");
			if(title == null){
				var tooltip = "+ "+this.text;
			}else{
				var tooltip = title+"<br>+ "+this.text;
			}
			exist = true;
			obj.setAttribute("title",tooltip);
		}else{
			window.setTimeout(showErrorByElementId, 3000,this.value);
			
		}
	}
	
});

if(exist){
	showTooltipByElementType();

		 
	
}
}

function showErrorByElementId(elementId){
//alert(elementId);
		var exist = false;	
		var obj = document.getElementById(elementId);		
		if(obj != null){
			var style = obj.getAttribute("style");		
			obj.setAttribute("style",style+";background-color:rgb(254,243,244);border: 1px solid red;");
			var title = obj.getAttribute("title");
			if(title == null){
				var tooltip = "+ "+obj.text;
			}else{
				var tooltip = title+"<br>+ "+obj.text;
			}
			exist = true;
			obj.setAttribute("title",tooltip);
		}else{
			alert("Not found element by id ="+elementId+",Please send this bug to developer !");
		}
	

if(exist){
	showTooltipByElementType();

		 
	
}
}






enterErrorToInputField();

function deleteSelectedInputFile(id,showfilename){

var obj= document.getElementById(id);
obj.value="";
$("#"+showfilename).html(" Chưa chọn file");
}



$( ".oep-uploadfile" ).change(function() {
var showfilename =$(this).attr("showfilename");	
var fileId=$(this).find("input").attr("id");

var text =$(this).find("input").val()+"<a  href='javascript:deleteSelectedInputFile(\""+fileId+"\",\""+showfilename+"\");' class='oep-icon-delete'></a>"
$("#"+showfilename).html(text);


});


function oepPreviewImage(input,imgId) {
if (input.files && input.files[0]) {
   var reader = new FileReader();
   reader.onload = function (e) {
       $('#'+imgId).prop('src', e.target.result);               
   };
   reader.readAsDataURL(input.files[0]);
   }
}



$(".oep-calendar").datepicker({
numberOfMonths: 1,
changeMonth: true,
dateFormat:"dd/mm/yy",
yearRange:"-80:+80",
monthNamesShort:["Th&#225;ng 1","Th&#225;ng 2","Th&#225;ng 3","Th&#225;ng 4","Th&#225;ng 5","Th&#225;ng 6","Th&#225;ng 7","Th&#225;ng 8","Th&#225;ng 9","Th&#225;ng 10"
                ,"Th&#225;ng 11","Th&#225;ng 12"],
dayNamesMin:["CN","T2","T3","T4","T5","T6","T7"],
changeYear: true,
beforeShow: function (input, inst) { 
   if($(input).hasClass('readonly')) {
   	  inst.dpDiv.style.display = 'none';
   
  }
}
});


function convertToUpperCase(source) {
if (source) {
 return source.toUpperCase();
}
}











function showAdvanceSearch(){
var objShow = document.getElementById("oep-advance-search");
if(objShow != null){
	if(objShow.style.display=""){
		objShow.style.display="none";
	}else{
		objShow.style.display="";
	}
}
}

$(document).ready(function(){

$('.oep-accordion').accordion({
	autoHeight  : true,
	navigation  : true
});

});

$(function() {	
$(".oep-table-accordion-content ").hide();
$(".oep-table-accordion .show").find("div:eq(0)").show();	
$(".oep-table-accordion th a").click(function(event) {    	
   event.stopPropagation();
   var $target = $(event.target);
   if ( $target.closest("th").attr("colspan") >= 1 ) {
       $target.slideUp();
   } else {
       $target.closest("tr").next().find("div.oep-table-accordion-content").slideToggle();
   }                    
});



});


$(function() {
$('.oep-select-multi').change(function() {
  
}).multipleSelect({
   width: '100%'
});
});

$('.oep-timepicker').timepicker({

// trigger options
showOn: 'focus',              // Define when the timepicker is shown.
                             // 'focus': when the input gets focus, 'button' when the button trigger element is clicked,
                             // 'both': when the input gets focus and when the button is clicked.
button: null,                 // jQuery selector that acts as button trigger. ex: '#trigger_button'

// Localization
hourText: 'Giờ',             // Define the locale text for "Hours"
minuteText: 'Phút',         // Define the locale text for "Minute"
amPmText: ['Sáng', 'Chiều'],       // Define the locale text for periods
hours: {
   starts: 7,                // First displayed hour
   ends: 17                  // Last displayed hour
},

minutes: {
   starts: 0,                // First displayed minute
   ends: 55,                 // Last displayed minute
   interval: 5,              // Interval of displayed minutes
   manual: []                // Optional extra entries for minutes
},
rows: 2,       

// Position
myPosition: 'left top',       // Corner of the dialog to position, used with the jQuery UI Position utility if present.
atPosition: 'left bottom',    // Corner of the input to position



});

function isEFormSubmitError(frmObjectId){
var objForm = document.getElementById(frmObjectId);
var es =objForm.elements;	
var result =false;
if(es != null && es.length>0){
	for(var i=0;i<es.length;i++){
		var e =es[i];
		var req =e.getAttribute("required");
		var readonly =e.getAttribute("readonly");
		if(req != null && readonly==null){
			//alert(req)
		//check required
			if(req =="" ||req=="yes"){
				if(e.value==null || e.value.trim()==""){
					eformShowErrorByElementId(e,'Vui lòng nhập thông tin vào trường này',';background-color:rgb(254,243,244); border-bottom:1px dotted red;');
					result=true;
				}
			}
			//check email	
			
			if(req=="email"){
				if(e.value==null || e.value.indexOf("@")==-1 || e.value.indexOf(".")==-1){
					eformShowErrorByElementId(e,'Vui lòng nhập đúng định dạng là Email',';background-color:rgb(254,243,244); border-bottom:1px dotted red;');
					result=true;
				}
			}
			//check number
			if(req=="number"){
				
				if(e.value==null ||e.value==""|| isNaN(e.value)){
					eformShowErrorByElementId(e,'Vui lòng nhập đúng định dạng là Số',';background-color:rgb(254,243,244); border-bottom:1px dotted red;');
					result=true;
				}
				
			}
		}
		//alert(req);
	}
}
//alert(es[0].name);
return result;
}

function eformShowErrorByElementId(obj,errors,styleAdd){
//alert(elementId);
		var exist = false;				
		if(obj != null){
			var style = obj.getAttribute("style");		
			obj.setAttribute("style",style+styleAdd);
			var title = obj.getAttribute("title");
			if(title == null){
				var tooltip = "+ "+errors;
			}else{
				var tooltip = title+"<br>+ "+errors;
			}
			exist = true;
			obj.setAttribute("title",errors);
		}else{
			alert("Not found element by id ="+elementId+",Please send this bug to developer !");
		}
	

if(exist){
	showTooltipByElementType();

		 
	
}
}








