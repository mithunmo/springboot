// JavaScript Document
//popup controller v2.0
//initialization
var popupPosTop=$(window).height()/2; //get the width of window
var popupPosLeft=$(window).width()/2; //get the height of window
var isOpened=false; //flag to determine is there any popup window show up on the screen
var isChangedWithoutSubmitOnPopup=false;
var popupTemplate = {
	"loadingSpinner":'<div class="loading-spinner"><img src="/images/spinner_small.gif"/></div>'
}

//POPUP CONTROLLER=======================================================
$(document).ready(function() {
	popupPosTop=$(window).height()/2; //get the width of window
	popupPosLeft=$(window).width()/2; //get the height of window
});
//event handler===============================================
//resize event for popup
$(window).resize(function()
{
	centerPopup();
});

//event for terms panel===================================================================
//event handler for checking agree or decline radio button on terms panel
//if the value change on agree radio button
$(document).on("change","#terms_agree",function(e)
{
	logging($("#terms_agree").attr("checked"));
	//enable the button
	$("#terms_ok").removeClass("disabled").removeAttr('button-disabled');
	/*$("#terms_ok").css(
	{
		"background-color":"#0457A0",
		"cursor":"pointer"
	});*/
});
//if the value change on decline radio button
$(document).on("change","#terms_decline",function(e)
{
	isAgree=false;
	logging($("#terms_decline").attr("checked"));
	//enable the button 
	$("#terms_ok").removeClass("disabled").removeAttr('button-disabled');
	/*$("#terms_ok").css(
	{
		"background-color":"#0457A0",
		"cursor":"pointer"
	});*/
});


$(document).on("change","#terms_agree_login",function(e)
{
	logging($("#terms_agree_login").attr("checked"));
	//enable the button
	$("#terms_ok_login").css(
	{
		"cursor":"pointer"
	});
	$("#terms_ok_login").removeClass('disabled').removeAttr('button-disabled');
});
//if the value change on decline radio button
$(document).on("change","#terms_decline_login",function(e)
{
	logging($("#terms_decline_login").attr("checked"));
	//enable the button 
	$("#terms_decline_login").css(
	{
		"cursor":"pointer"
	});
	$("#terms_ok_login").removeClass('disabled').removeAttr('button-disabled');
});

//image zoomer enhancement
$(document).on('click','#wrap',function(e) {
	//detect browser width and height
});

//print
$(document).on('click','#print',function(e) {
	//Get the HTML of div
    var divElements = $('#termsData').html();

    var printCss = '<style>body { padding: 0 0 30pt 0;} .termsContent { width:96%; margin:0% 2%;} .termsContent .leftArea { width:70%;} .termsContent .rightArea { width:29%;} p { page-break-inside:avoid; page-break-after:avoid; }</style>';
    var css='<style type="text/css">'
    	+'#print { display:none;}'
    	+'h3 { margin: 0px;}'
    	+'.termsContent { position:relative; width:670px;}'
    	+'.termsContent .leftArea { width:500px; float:left;}'
    	+'.termsContent .rightArea { width:150px; height:100%; margin-left:5px; float:right;}'
    	+'.termsContent .rightArea .block { width:145px; padding:5px; position:absolute; border-radius:10px; background-color: #00AEEF; color:#FFF;}'
    	+'</style>';
    var script='<script type="text/javascript" src="/js/jquery/jquery-1.7.2.min.js"></script>';
    var runScript='<script type="text/javascript">'
    	+'$(".anchor").each(function(index) {$(".rightArea .block:nth-child("+(index+1)+")").animate({top:$(this).position().top});});'
    	+'</script>';
    //Reset the page's HTML with div's HTML only
    divElements = 
      '<html><head><title>Terms and Conditions</title>'+css+script+'</head><body>' + 
      divElements + runScript + "</body>";
    var newWin = window.open (""); 
    //body
    newWin.document.write (divElements);
    newWin.print(); 
    newWin.close();
});

//popup core ver 2.0================================================================
function buildPopup(options,callback)
{
	var defaultOptions = {
		"url": null,
		"container": "#popupContainer",
		"overlay": "#overlay",
		"showPopup": true, //enable effect or not
		"showOverlay":true, //enable overlay or not
		"closeByOverlay":true, //Can close the pop-up by clicking the overlay
		"position":'absolute', //The position of the popup (absolute, relative)
		//Below is the event
		"loadComplete": undefined,
		"show": undefined,
		"onClose": undefined,
		"onLoad": $.noop
	};
	options=$.extend({},defaultOptions,options);
	//unbind the previous event in case
	$(document).off("click",options.container+" .popup .close");
	$(document).off("click",options.overlay);
	//ajax method
	$.ajax(
	{
		url:options.url,
		beforeSend: function()
		{
			options.onLoad(); //trigger onLoad event
			if(options.showOverlay)
			{
				if($(options.overlay+" .loading-spinner").length<1) //create the loading spinner div if not found
					$(options.overlay).append(popupTemplate.loadingSpinner);
				//show the spinner
				$(options.overlay+" .loading-spinner").show();
				//set the opactity value if the browser is IE 8
				if ( $.browser.msie && ($.browser.version == "8.0" || $.browser.version == "7.0")) 
				{
					$(options.overlay).css('filter', 'alpha(opacity=70)');
				}
				$(options.overlay).fadeIn("fast"); //show the overlay when loading
			}
		},
		error: function(xhr,status,error)
		{
			logging(this.url+" is "+error); //if there is arrow, close the overlay
			if(options.showOverlay)
				$(options.overlay).fadeOut("fast"); //show the overlay when loading
		},
		success: function(result)
		{
			logging("loading "+this.url+" complete");
			$(options.container).html(result); //set the result to the popupContainer
			if(options.loadComplete!=undefined && typeof(options.loadComplete)==='function')
				options.loadComplete();
		},
		complete: function(xhr,status)
		{
			//hide the spinner
			$(options.overlay+" .loading-spinner").hide();
			//callback();
			logging("popup complete"+xhr+";"+status);
			//init plugin
			logging("init term scrollbar");
			$("#termScrollbar").tinyscrollbar(); //TODO will delete, should initialize the plug-in from callback function.
			//show the popup on the screen
			if(options.showPopup)
				showPopup(options,callback); //send the callback function.
			else
			{
				//execute callback to initialize the plug-in or some actions after success. 
				if(typeof(callback)==='function')
					callback();
			}
			//bind close event on close button
			$(document).on("click",options.container+" .popup .close",function() {
				closePopup();
				if(typeof(options.onClose)==='function')
				{
					options.onClose();
				}
			});
			//bind close event on overlay if closeByOverlay==true
			if(options.closeByOverlay)
			{
				$(document).on("click",options.overlay,function() {
					closePopup();
					if(typeof(options.onClose)==='function')
						options.onClose();
				});
			}
		}
	});
}

function buildUploadPopup(options)
{
	//address,mode,filetype,target,event)
	var defaultOptions = {
		"url": null,
		"mode": "BOARD", //Three options: LOGO | BOARD | FILES
		"filetype": "jpg",
		"previewArea": "#previewImage",
		"event": "upload_finished",
		"onUploadSuccess": $.noop,
		"isProcessErrorFiles":true
	};
	var fileTypeDesc,fileTypeExts,multi;
	//unbind the previous event in case
	$(document).off("click",".popup .close");
	$(document).off("click","#overlay");
	options=$.extend({},defaultOptions,options);
	//set the path
	options.url+="?mode="+options.mode+"&filetype="+options.filetype;
	//set the callback function of loadComplete
	options.loadComplete= function() {
		//detect client flash installation status
		if (!swfobject.hasFlashPlayerVersion("10")) {
			$("#popup_upload .upload_info .description").html('Please <a href="http://get.adobe.com/flashplayer/" target="_blank">click here to install flash</a> before you upload the file. Thanks.');
		}
		if(options.filetype=="jpg") {
			fileTypeDesc='JPEG Files';
			fileTypeExts='*.jpg; *.jpeg';
			multi=false;
		}
		else if(options.filetype=="files") {
			fileTypeDesc='Doc Files';
			fileTypeExts='*.txt; *.doc; *.docx; *.pdf';
			multi=true;
		}
		else {
			fileTypeDesc='AI, PDF or JPG Files';
			fileTypeExts='*.ai; *.pdf; *.jpg; *.jpeg';
			multi=false;
		}
		//initialize uploadify plugin
		$('#uploadify').uploadify({
		 	'swf': '/js/jquery/uploadify/uploadify.swf',
		 	'uploader': uploaderPath+"?mode="+options.mode+"&filetype="+options.filetype,
		 	'successTimeout':480,
		 	'multi': multi,
		 	'auto' : true,
		 	'fileTypeDesc': fileTypeDesc,
		 	'fileTypeExts' : fileTypeExts,
		 	'buttonText': 'Select Files',
		 	'onUploadProgress':function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
		 		$('#uploadify').uploadify('disable', true);
		 		if(totalBytesUploaded >= totalBytesTotal) {
		 			$("#popup_upload .upload_info .description").fadeOut("fast",function() {
		 				$("#popup_upload .upload_info .description").html('We are processing your image, please wait..<br /><span class="upload_loading"><img src="/images/spinner_small.gif" /></span>');
		 				$("#popup_upload .upload_info .description").fadeIn();
		 			});
		 		}
		 	},
		 	'onUploadError': function(file, errorCode, errorMsg, errorString) {
		 		$('#uploadify').uploadify('disable', false);
		 		logging('The file ' + file.name + ' could not be uploaded: ' + errorString);
		 	},
		 	'onUploadComplete' : function(file) {
		 		logging('The file ' + file.name + ' finished processing.');
	        },
	        'onUploadSuccess' : function(file, data, response) {
	            logging('The file ' + file.name + ' was successfully uploaded with a response of ' + response);
	            if(response==true) {
	            	$("#popup_upload .upload_info").html(data);
	            	data = '<div>'+data+'</div>';
	 	            logging("FileName=>"+$("#upload_filename_100x100").val());
	 	            var filestatus=$("#upload_status").val();
	 	            var isFailedProcessing=$("#upload_isFailedProcessing",data).val();
	 	            if(options.isProcessErrorFiles) {
	 	            	//allow error files
	 	            	var filename=$("#upload_filename",data).val();
	 	            	var filename_ext=$("#upload_ext",data).val();
	 	            	var filename_100=$("#upload_filename_100x100",data).val();
	 	            	var filename_400=$("#upload_filename_400x400",data).val();
	 	            	var filename_original=$("#upload_filename_original",data).val();
	 	            	var original_filename=$("#original_filename",data).val();
	 	            	var result = {
	 	            		"status":filestatus,
	 	            		"filename":filename,
	 		 	            "filename_ext":filename_ext,
	 		 	            "filename_100":filename_100,
	 		 	            "filename_400":filename_400,
	 		 	            "filename_original":filename_original,
	 		 	            "original_filename":original_filename
	 	            	};
	 	            	if(options.previewArea!=='')
	 	            		$(options.previewArea).html('<i></i><img src="/100x100/'+filename_100+'" />');
	 	            	
	 	            	//trigger the event when upload finished
		 	            var t_event = jQuery.Event(options.event);
		 	            t_event.filestatus = filestatus;
		 	            t_event.filename = filename;
		 	            t_event.filename_ext = filename_ext;
		 	            t_event.filename_100=filename_100;
		 	            t_event.filename_400=filename_400;
		 	            t_event.filename_original=filename_original;
		 	            $("body").trigger(t_event);
		 	            //$("body").trigger(event,[filename,filename_ext,filename_100,filename_400,filename_original]);
		 	            options.onUploadSuccess(result); //fire callback with json object
	 	            }
	 	            else {
	 	            	if(filestatus >= 0) {
		 	            	var filename=$("#upload_filename",data).val();
		 	            	var filename_ext=$("#upload_ext",data).val();
		 	            	var filename_100=$("#upload_filename_100x100",data).val();
		 	            	var filename_400=$("#upload_filename_400x400",data).val();
		 	            	var filename_original=$("#upload_filename_original",data).val();
		 	            	var original_filename=$("#original_filename",data).val();
		 	            	var result = {
		 	            		"status":filestatus,
		 	            		"filename":filename,
		 		 	            "filename_ext":filename_ext,
		 		 	            "filename_100":filename_100,
		 		 	            "filename_400":filename_400,
		 		 	            "filename_original":filename_original,
		 		 	            "original_filename":original_filename
		 	            	};
		 	            	if(options.previewArea!=='')
		 	            		$(options.previewArea).html('<i></i><img src="/100x100/'+filename_100+'" />');
		 	            	
		 	            	//trigger the event when upload finished
			 	            var t_event = jQuery.Event(options.event);
			 	            t_event.filestatus = filestatus;
			 	            t_event.filename = filename;
			 	            t_event.filename_ext = filename_ext;
			 	            t_event.filename_100=filename_100;
			 	            t_event.filename_400=filename_400;
			 	            t_event.filename_original=filename_original;
			 	            $("body").trigger(t_event);
			 	            //$("body").trigger(event,[filename,filename_ext,filename_100,filename_400,filename_original]);
			 	            options.onUploadSuccess(result); //fire callback with json object
		 	            }
		 	            else {
		 	            	$("#popup_upload .upload-status").html('Image failed to process.'); //Image failed to process.
		 	            }
	 	            }
	 	            //$("#uploadify").attr("style","display:none"); //hide upload button.
	 	            $('#uploadify').uploadify('destroy');
	 	            $('#uploadify').css('display','none');
	            }
	            else {
	            	$('#uploadify').uploadify('disable', true);
	            	$("#popup_upload .upload_info .description").html('The upload process timed out.');
	            }
	        },
	        'onFallback' : function() {
	        	//TODO fallback
	        }
		 });
	};
	//buildPopup
	buildPopup(options);
}

function showPopup(options,callback)
{
	var defaultOptions = {
		"container": "#popupContainer",
		"effect": true,
		"position":'absolute'
	};
	isOpened=true; //set the global flag
	options=$.extend({},defaultOptions,options);
	var popupWidth=$(options.container+" .popup").width(); //get the width of the popup window	
	var popupHeight=$(options.container).height();
	logging("Popup Height="+popupHeight);
	//set the popup position
	$(options.container).css(
	{
		top:(popupPosTop/2)*0.8,
		left:popupPosLeft-popupWidth/2
	});
	//Setup the container position property
	//Detect the browser height, if the popup height > browser height, force the popup with absolute position
	if($(window).height()<(popupHeight+(popupPosTop/2)*0.8)) {
		options.position='absolute';
	}
	$(options.container).css("position",options.position);
	//animation to show the popup, like scaling effect from 0 to designated width
	if(options.effect==true)
	{
		$(options.container).css("display","block");
		$(options.container).width(0);
		$(options.container).height(0);
		$(options.container).animate(
		{
			width:popupWidth,
			height:popupHeight
		},callback);
		//$(options.container).show('clip',{},300,callback);
		//$(options.container).fadeIn(500,callback);
	}
	else
	{
		$(options.container).css("display","block");
		if(typeof(callback)=="function")
			callback();
	}
}

//close the current popup window------------------------
function closePopup(container,overlay,cleanContainer,options)
{
	var defaultOptions = {	
		"forceToClose":false
	};
	//var layout=msgLayout;
	options=$.extend({},defaultOptions,options);
	if(isChangedWithoutSubmitOnPopup && options.forceToClose!=true)
	{
		//show confirmation window to make sure the user want to close the pop-up without submit
		showConfirmation("Do you want to close with unsaved data?","Confirmation","changedWithoutSubmitOnPopup",{
			"onOk":function() {
				//set the flag false;
				isChangedWithoutSubmitOnPopup=false;
				//close popup
				closePopup(container,overlay);
				//close own window
				closePopupMsg();
			}
		});
		/*$("body").bind("changedWithoutSubmitOnPopup",function(changeEvent)
		{	
			if(changeEvent.trigger=="ok")
			{
				//set the flag false;
				isChangedWithoutSubmitOnPopup=false;
				//close popup
				closePopup(container,overlay);
			}
			else
			{
				//close error popup
				closePopupMsg();
			}
			$("body").off("changedWithoutSubmitOnPopup");
		});*/
	}
	else
	{
		var target="#popupContainer";
		var overlayTarget="#overlay";
		if(overlay!=undefined)
			overlayTarget=overlay;
		if(container!=undefined)
			target=container;
		//show the effect to close the popup
		$(target).fadeOut("fast",function()
		{
			//hide overlay
			$(overlayTarget).fadeOut(200);
		});
		//reset popup
		$(".popup .notification").css("display","none");
		//reset style of popupContainer
		$(target).removeAttr("style");
		//clean the popupContainer
		if(cleanContainer==undefined || cleanContainer==true)
			$(target).html("");
		//clear the hash
		//location.hash="";
		//reset isOpened flag
		isOpened=false;
		//remove the binding evevnt on close and overlay
		$(document).off("click",target+" .popup .close");
		$(document).off("click",overlayTarget);
	}
}

//change the popup location when resizeing the window=========================================
function centerPopup()
{
	popupPosTop=$(window).height()/2; //get the width of window
	popupPosLeft=$(window).width()/2; //get the height of window
	//logging("center popup");
	//logging("currentWidth/2="+popupPosLeft);
	//logging("currentHeight/2="+popupPosTop);
	if(isOpened==true) //if there is any popup shows up on the window, then we realocate the position of the popup
	{
		var popupWidth=$(".popup").width(); //get the width of the popup window
		logging("POPUP W="+popupWidth);
		//set position
		$(".popupContainer").css(
		{
			top:(popupPosTop/2)*0.9,
			left:popupPosLeft-popupWidth/2
		});
	}
}
//END OF POPUP CONTROLLER=======================================================================

//Show message window core ver 2.0====================================================
function buildPopupMsg(options)
{
	var defaultOptions = {	
		"content": null,
		"title": "Error",
		"event": null,
		"closeByOverlay":true,
		"noCloseWhenOk":false,
		"effect":true,
		//Button layout
		"showOk": true,
		"showOverlay": true,
		"showCancel": false,
		//event
		"onClose": undefined,
		"onOk": closePopupMsg,
		"onCancel": undefined,
		"onShow":undefined,
		"position":"absolute"
	};
	//var layout=msgLayout;
	options=$.extend({},defaultOptions,options);
	//append the container if not existed in the DOM.
	if($("#error").length<=0)
	{
		//create the container
		$("body").append('<div class="popupContainer" id="error"></div>');
	}	
	if($("#error_overlay").length<=0)
	{
		//create the container
		$("body").append('<div class="overlay" id="error_overlay"></div>');
	}
	//render layout
	$("#error").html(renderLayout(options));
	//show overlay
	if ( $.browser.msie && ($.browser.version == "8.0" || $.browser.version == "7.0")) 
	{
		$('#error_overlay').css('filter', 'alpha(opacity=70)');
	}
	if(options.showOverlay)
		$("#error_overlay").fadeIn();

	showPopup({
		"container":"#error",
		"effect":options.effect,
		"position":options.position
	},options.onShow); //show the popup which div is id=error
	//bind close event on close button
	$(document).on("click",".error_close",function()
	{
		closePopupMsg("#error","#error_overlay");
		if(typeof(options.onClose)==='function')
			options.onClose();
	});
	//bind close event on overlay if closeByOverlay is true
	if(options.closeByOverlay)
	{
		$(document).on("click","#error_overlay",function()
		{
			closePopupMsg("#error","#error_overlay");
			if(typeof(options.onClose)==='function')
				options.onClose();
		});
	}
	//bind OK event on OK button if showOk is true
	if(options.showOk)
	{
		$(document).on("click",".error_ok",function() //if user hit the OK button on the popup panel, then close the popup.
		{
			//closePopupMsg();
			//trigger event
			if(typeof(options.onOk)==='function')
			{
				logging("Trigger ok");
				options.onOk();
			}
		});
		$(document).on("keypress",".error_ok",function(e) //if user hit the OK button on the popup panel, then close the popup.
		{
			if(e.which==13)
			{
				//closePopupMsg();
				//trigger event
				if(typeof(options.onOk)==='function')
					options.onOk();
				//closePopupMsg();
				/*//trigger the event
				var event=$(this).attr("data");
				if(event!=undefined)
				{
					logging("trigger ok event=>"+event,"#F00");
					var t_event = jQuery.Event(event);
					t_event.trigger = "ok";
					$("body").trigger(t_event);
				}*/
			}
		});
	}
	//bind cancel event if showCancel is true
	if(options.showCancel)
	{
		$(document).on("click",".error_cancel",function()
		{
			closePopupMsg("#error","#error_overlay");
			//trigger event
			if(typeof(options.onCancel)==='function')
				options.onCancel();
		});
	}
}

function renderLayout(options)
{
	var layout=
		'<div class="popup">'+
			'<div class="header"><span id="title">'+options.title+'</span>'+
				'<div class="error_close" data="'+options.event+'">X</div>'+
			'</div>'+
			'<div class="content" id="error_content">'+
				'<div id="errorContent">'+options.content+'</div>'+
				'<div class="buttonPanel" style="width:85%">';
	if(options.showOk)
		layout+='<div class="button error_ok" id="error_button_ok" tabindex="0" data="'+options.event+'">Ok</div>';
	if(options.showCancel)
		layout+='<div class="button orangeButton error_cancel" id="error_button_cancel" data="'+options.event+'">Cancel</div>';
	layout+='</div></div></div>';
	return layout;
}

//Close error msg====================================================
function closePopupMsg(callback,options)
{
	var defaultOptions = {	
		"closeOverlay":true
	};
	//var layout=msgLayout;
	options=$.extend({},defaultOptions,options);
	var target="#error";
	var overlayTarget="#error_overlay";
	//unbind all event
	$(document).off("click",".error_close");
	$(document).off("click","#error_overlay");
	$(document).off("click",".error_ok");
	$(document).off("keypress",".error_ok");
	$(document).off("click",".error_cancel");
	//show the effect to close the popup
	$(target).fadeOut("fast",function()
	{
		//hide overlay
		if(options.closeOverlay)
			$(overlayTarget).fadeOut(200);
		//reset popup
		$(".popup .notification").css("display","none");
		//reset style of popupContainer
		$(target).removeAttr("style");
		//clean the popupContainer
		$(target).html("");
		if(typeof(callback)==='function')
			callback();
	});
}

//confirmation popup
function showConfirmation(content,title,event,eventHandler,options)
{
	if(options==undefined)
		options={};
	var defaultOptions = {	
		"position":'absolute'
	};
	//var layout=msgLayout;
	options=$.extend({},defaultOptions,options);
	buildPopupMsg({
		"content":'<span style="color:#00F">'+content+'</span>',
		"showOk":true,
		"title":title,
		"showOverlay":true,
		"event":event,
		"showCancel":true,
		"onOk":eventHandler.onOk,
		"onCancel":eventHandler.onCancel,
		"onClose":eventHandler.onClose,
		'position':options.position
	});
}
//close all overlay
function closeAllOverlay()
{
	$(".overlay").fadeOut();
}

//unbind event
function unbindPopupMsgEvent()
{
	//unbind all event
	$(document).off("click",".error_close");
	$(document).off("click","#error_overlay");
	$(document).off("click",".error_ok");
	$(document).off("keypress",".error_ok");
	$(document).off("click",".error_cancel");
}