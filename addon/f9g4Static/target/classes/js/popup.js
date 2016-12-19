// JavaScript Document
//popup controller v1.0 06/13/12
//initialization
var popupPosTop=$(window).height()/2; //get the width of window
var popupPosLeft=$(window).width()/2; //get the height of window
var isOpened=false; //flag to determine is there any popup window show up on the screen
var previousPopup="";
var isChangedWithoutSubmitOnPopup=false;
//var path="popup/"; //path for popup
//POPUP CONTROLLER=======================================================
//event handler===============================================
//resize event for popup
$(window).resize(function()
{
	centerPopup();
});
//close pupup handler--------------------------------
$(".close").live("click",function() //if user hit the X button on the popup panel, then close the popup.
{
	closepopup();
});
//adding close popups for the Error popup window
$(".error_ok").live("click",function() //if user hit the OK button on the popup panel, then close the popup.
{
	closeErrorMsg();
	//trigger the event
	var event=$(this).attr("data");
	if(event!=undefined)
	{
		logging("trigger ok event=>"+event,"#F00");
		var t_event = jQuery.Event(event);
	    t_event.trigger = "ok";
		$("body").trigger(t_event);
	}
});

$(".error_close").live("click",function() //if user hit the X button on the popup panel, then close the popup.
{
	closeErrorMsg();
	//trigger the event
	var event=$(this).attr("data");
	if(event!=undefined)
	{
		logging("trigger ok event=>"+event,"#F00");
		var t_event = jQuery.Event(event);
		t_event.trigger = "close";
		$("body").trigger(t_event);
	}
});
$(".error_cancel").live("click",function()
{
	closeErrorMsg();
	//trigger event
	var event=$(this).attr("data");
	if(event!=undefined)
	{
		logging("trigger ok event=>"+event,"#F00");
		var t_event = jQuery.Event(event);
		t_event.trigger = "cancel";
		$("body").trigger(t_event);
	}
});
//Event handler of overlay
$("#overlay").live("click",function(e)
{
	logging("close popup");
	closepopup();
});
$("#error_overlay").live("click",function(e)
{
	logging("close error popup");
	closeErrorMsg();
});
$("#session_overlay").live("click",function(e)
{
	logging("close session timeout popup");
	//closepopup("#session_expire","#session_overlay");
});


//event for terms panel===================================================================
//event handler for checking agree or decline radio button on terms panel
//if the value change on agree radio button
$("#terms_agree").live("change",function(e)
{
	logging($("#terms_agree").attr("checked"));
	//enable the button
	$("#terms_ok").css(
	{
		"background-color":"#0457A0",
		"cursor":"pointer"
	});
});
//if the value change on decline radio button
$("#terms_decline").live("change",function(e)
{
	isAgree=false;
	logging($("#terms_decline").attr("checked"));
	//enable the button 
	$("#terms_ok").css(
	{
		"background-color":"#0457A0",
		"cursor":"pointer"
	});
});


$("#terms_agree_login").live("change",function(e)
{
	logging($("#terms_agree_login").attr("checked"));
	//enable the button
	$("#terms_ok_login").css(
	{
		"background-color":"#0457A0",
		"cursor":"pointer"
	});
});
//if the value change on decline radio button
$("#terms_decline_login").live("change",function(e)
{
	logging($("#terms_decline_login").attr("checked"));
	//enable the button 
	$("#terms_decline_login").css(
	{
		"background-color":"#0457A0",
		"cursor":"pointer"
	});
});

//close the current popup window------------------------
function closepopup(container,overlay)
{
	if(isChangedWithoutSubmitOnPopup)
	{
		//show confirmation window to make sure the user want to close the pop-up without submit
		showConfirmation("Do you want to close with unsaved data?","Confirmation","changedWithoutSubmitOnPopup");
		$("body").bind("changedWithoutSubmitOnPopup",function(changeEvent)
		{	
			console.log(container+";"+overlay);
			if(changeEvent.trigger=="ok")
			{
				//set the flag false;
				isChangedWithoutSubmitOnPopup=false;
				//close popup
				closepopup(container,overlay);
			}
			else
			{
				//close error popup
				closeErrorMsg();
			}
			$("body").off("changedWithoutSubmitOnPopup");
		});
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
			$(overlayTarget).fadeOut();
		});
		//reset popup
		$(".popup .notification").css("display","none");
		//reset style of popupContainer
		$(target).removeAttr("style");
		//clean the popupContainer
		$(target).html("");
		//clear the hash
		//location.hash="";
		//reset isOpened flag
		isOpened=false;
	}
}
//load ajax data---------------------------------------------------------------
function loadPopup(address,setting) //setting is json structure
{
	if(setting==undefined) //the flag to set the showpopup call or not.
		setting=true;
	//ajax method
	$.ajax(
	{
		url:address,
		beforeSend: function()
		{
			logging("loading "+address);
			//set the opactity value if the browser is IE 8
			if ( $.browser.msie && $.browser.version == "8.0") 
			{
				$('#overlay').css('filter', 'alpha(opacity=70)');
			}
			$("#overlay").fadeIn("fast"); //show the overlay when loading
			//hide the popupContainer
		},
		error: function(xhr,status,error)
		{
			logging(this.url+" is "+error); //if there is arrow, close the overlay
			$("#overlay").fadeOut("fast"); //show the overlay when loading
		},
		success: function(result)
		{
			logging("loading "+this.url+" complete");
			$("#popupContainer").html(result); //set the result to the popupContainer	
		},
		complete: function(xhr,status)
		{
			logging("popup complete"+xhr+";"+status);
			//init plugin
			logging("init term scrollbar");
			$("#termScrollbar").tinyscrollbar(); //initiate the scroll bar in terms panel !!!important
			//show the popup on the screen
			if(setting)
				showpopup();
			else
			{
				//update the scroll bar
				$(".popup .entity").tinyscrollbar();
			}
		}
	});
}
//load Upload popup========================================================================================
//mode: jpg or ai
//target: the id for putting preview images.
function loadUploadPopup(address,mode,filetype,target,event)
{
	var fileTypeExts="";
	var fileTypeDesc="";
	if(event==undefined)
		event="upload_finished";
	//ajax method
	$.ajax(
	{
		url:address+"?mode="+mode+"&filetype="+filetype,
		beforeSend: function()
		{
			if ( $.browser.msie && $.browser.version == "8.0") 
			{
				$('#overlay').css('filter', 'alpha(opacity=70)');
			}
			$("#overlay").fadeIn("fast"); //show the overlay when loading
		},
		error: function(xhr,status,error)
		{
			logging(this.url+" is "+error); //if there is arrow, close the overlay
			$("#overlay").fadeOut("fast"); //show the overlay when loading
		},
		success: function(result)
		{
			logging("loading "+this.url+"complete");
			$("#popupContainer").html(result); //set the result to the popupContainer
			//show the popup on the screen
			showpopup();			
			//initialize uploadify plugin
			if(filetype=="jpg")
			{
				fileTypeDesc='JPEG Files';
				fileTypeExts='*.jpg; *.jpeg';
			}
			else
			{
				fileTypeDesc='AI or JPG Files';
				fileTypeExts='*.ai; *.jpg; *.jpeg';
			}
			//initialize uploadify plugin
			$('#uploadify').uploadify(
			{
			 	'swf': '/js/jquery/uploadify/uploadify.swf',
			 	'uploader': uploaderPath+"?mode="+mode+"&filetype="+filetype,
			 	'multi': false,
			 	'auto' : true,
			 	'fileTypeDesc': fileTypeDesc,
			 	'fileTypeExts' : fileTypeExts,
			 	'onUploadError': function(file, errorCode, errorMsg, errorString)
			 	{
			 		logging('The file ' + file.name + ' could not be uploaded: ' + errorString);
			 	},
			 	'onUploadComplete' : function(file) 
			 	{
			 		logging('The file ' + file.name + ' finished processing.');
		        },
		        'onUploadSuccess' : function(file, data, response) 
		        {
		            logging('The file ' + file.name + ' was successfully uploaded with a response of ' + response);
		            $("#popup_upload .upload_info").html(data);
		            logging("FileName=>"+$("#upload_filename_100x100").val());
		            var filename=$("#upload_filename").val();
		            var filename_ext=$("#upload_ext").val();
		            var filename_100=$("#upload_filename_100x100").val();
		            var filename_400=$("#upload_filename_400x400").val();
		            var filename_original=$("#upload_filename_original").val();
		            
		            $("#"+target).html('<i></i><img src="/100x100/'+filename_100+'" />');
		            //trigger the event when upload finished
		            var t_event = jQuery.Event(event);
		            t_event.filename = filename;
		            t_event.filename_ext = filename_ext;
		            t_event.filename_100=filename_100;
		            t_event.filename_400=filename_400;
		            t_event.filename_original=filename_original;
		            $("body").trigger(t_event);
		            //$("body").trigger(event,[filename,filename_ext,filename_100,filename_400,filename_original]);
		            $("#uploadify").attr("style","display:none"); //hide upload button.
		        }
			 });
		}
	});
}
//show popup window by target===============================================================================
function showpopup(param)
{
	logging("OVERLAY="+$('#overlay').css("display"));
	isOpened=true; //set the flag
	var target="#popupContainer";
	//
	if(param!=undefined)
		target=param;
	logging("popup container id=>"+target);
	var popupWidth=$(target+" .popup").width(); //get the width of the popup window	
	var popupHeight=$(target).height();
	logging("Popup Height="+popupHeight);
	//set the popup position
	$(target).css(
	{
		top:(popupPosTop/2)*0.8,
		left:popupPosLeft-popupWidth/2
	});
	//animation to show the popup, like scaling effect from 0 to designated width
	$(target).css("display","block");
	$(target).width(0);
	$(target).height(0);
	$(target).animate(
	{
		width:popupWidth,
		height:popupHeight
	});
	//center(); //meke the buttons always display on the center
	$(".popup .entity").tinyscrollbar();
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

//show error data=====================================================================
function showErrorMsg(msg,showOk,title,modal,event,showCancel)
{
	var layout="";
	layout+='<div class="popup">';
	layout+='<div class="header">';
	if(title==undefined || title=="")
		layout+='Error';
	else
		layout+=title;
	if(modal==undefined)
		modal=true;
	layout+='<div class="error_close" data="'+event+'">X</div>';
	layout+='</div>';
	layout+='<div class="content" id="error">';
	layout+='<div id="errorContent">';
	layout+=msg;
	layout+='</div>';
	layout+='<div class="buttonPanel" style="width:85%">';
	if(showOk==true)
		layout+='<div class="button error_ok" id="error_button_ok" data="'+event+'">Ok</div>';
	if(showCancel==true)
		layout+='<div class="button orangeButton error_cancel" id="error_button_cancel" data="'+event+'">Cancel</div>';
	layout+='</div>';
	layout+='</div>';
	layout+='</div>';
	logging("Error DIV=>"+$("#error").length);
	//if the container for error popup is not exist, append a new one in body.
	if($("#error").length<=0)
	{
		//create the container
		$("body").append('<div class="popupContainer" id="error"></div>');
	}
	//put error msg
	$("#error").html(layout);
	if($("#error_overlay").length<=0)
	{
		//create the container
		$("body").append('<div class="overlay" id="error_overlay"></div>');
	}
	//show overlay
	if ( $.browser.msie && $.browser.version == "8.0") 
	{
		$('#error_overlay').css('filter', 'alpha(opacity=70)');
	}
	if(modal)
		$("#error_overlay").fadeIn();
	showpopup("#error"); //show the popup which div is id=error
}

//Close error msg====================================================
function closeErrorMsg()
{
	//closepopup("#error","#error_overlay"); //popup container, popup overlay
	var target="#error";
	var overlayTarget="#error_overlay";
	//show the effect to close the popup
	$(target).fadeOut("fast",function()
	{
		//hide overlay
		$(overlayTarget).fadeOut();
	});
	//reset popup
	$(".popup .notification").css("display","none");
	//reset style of popupContainer
	$(target).removeAttr("style");
	//clean the popupContainer
	$(target).html("");
	//closeAllOverlay();
	//trigger the event when upload finished
    var t_event = jQuery.Event("close_error");
    $("body").trigger(t_event);
}

//confirmation popup
function showConfirmation(content,title,event)
{
	showErrorMsg('<span style="color:#00F">'+content+'</span>',true,title,true,event,true);
}
//close all overlay
function closeAllOverlay()
{
	$(".overlay").fadeOut();
}

//
//debug function, continue to record the data
function logging(data)
{
	if(debugMode)
		$("#debug").css("display","block");
	//if(data==undefined || data=="")
	//	$("#debug").append("Undefined or blank <br />");	
	$("#debug").append(data+"<br />");
	$("#debug").scrollTop($("#debug")[0].scrollHeight);
}