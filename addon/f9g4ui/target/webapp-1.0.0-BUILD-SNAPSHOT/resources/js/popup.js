// JavaScript Document
//popup controller v1.0 06/13/12
//initialization
var popupPosTop=$(window).height()/2; //get the width of window
var popupPosLeft=$(window).width()/2; //get the height of window
var isOpened=false; //flag to determine is there any popup window show up on the screen
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


//change the popup location when resizeing the window=========================================
function centerPopup()
{
	popupPosTop=$(window).height()/2; //get the width of window
	popupPosLeft=$(window).width()/2; //get the height of window
	logging("resize");
	logging("currentWidth/2="+popupPosTop);
	logging("currentHeight/2="+popupPosLeft);
	if(isOpened==true) //if there is any popup shows up on the window, then we realocate the position of the popup
	{
		var popupWidth=$(".popup .header").width(); //get the width of the popup window	
		//set position
		$("#popupContainer").css(
		{
			top:(popupPosTop/2)*0.9,
			left:popupPosLeft-popupWidth/2
		});
	}
}
//close the current popup window------------------------
function closepopup()
{
	//show the effect to close the popup
	$("#popupContainer").fadeOut("fast",function()
	{
		//hide overlay
		$("#overlay").fadeOut();
	});
	//reset popup
	$(".popup .notification").css("display","none");
	//reset style of popupContainer
	$("#popupContainer").removeAttr("style");
	//clear the hash
	location.hash="";
	//reset isOpened flag
	isOpened=false;
}
//load ajax data---------------------------------------------------------------
function loadPopup(address,msg) //msg for error only
{
	//ajax method
	$.ajax(
	{
		url:address,
		beforeSend: function()
		{
			logging("loading "+address);
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
			/*if(msg!="")
			{
				//set msg
				setData(msg);
			}*/		
			//initialize the plugin
			//if(address=="terms.html")
			//{
				logging("init term scrollbar");
				$("#termScrollbar").tinyscrollbar(); //initiate the scroll bar in terms panel !!!important
			//}
		},
		complete: function(xhr,status)
		{
			logging("popup complete"+xhr+";"+status);
			//show the popup on the screen
			showpopup();	
		}
	});
}
//load Upload popup========================================================================================
function loadUploadPopup(address,mode)
{
	var fileTypeExts="";
	var fileTypeDesc="";
	//ajax method
	$.ajax(
	{
		url:address+"/"+mode,
		beforeSend: function()
		{
			logging("loading "+address);
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
			if(mode=="jpg")
			{
				fileTypeDesc='JPEG Files';
				fileTypeExts='*.jpg; *.jpeg';
			}
			else
			{
				fileTypeDesc='AI Files';
				fileTypeExts='*.ai';
			}
			$('#uploadify').uploadify(
			{
			 	'swf': appPath+'/resources/js/jquery/uploadify/uploadify.swf',
			 	'uploader': appPath+'/uploadPictures?jsessionid=${sessionId}',
			 	'multi': false,
			 	'auto' : true,
			 	'fileTypeDesc': fileTypeDesc,
			 	'fileTypeExts' : fileTypeExts,
			 	'cancelImg': appPath+'/resources/js/jquery/uploadify/cancel.png',
			 	'onUploadComplete' : function(file) 
			 	{
			 		logging('The file ' + file.name + ' finished processing.');
		        },
		        'onUploadSuccess' : function(file, data, response) 
		        {
		            logging('The file ' + file.name + ' was successfully uploaded with a response of ' + response + ':' + data);
		            $("#popup_upload").html(data);
		        }
			 });
		}
	});
}
//show popup window by target===============================================================================
function showpopup()
{
	isOpened=true; //set the flag
	//
	var target="#popupContainer";
	var popupWidth=$(".popup").width(); //get the width of the popup window	
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
}

//change the popup location when resizeing the window=========================================
function centerPopup()
{
	popupPosTop=$(window).height()/2; //get the width of window
	popupPosLeft=$(window).width()/2; //get the height of window
	logging("resize");
	logging("currentWidth/2="+popupPosLeft);
	logging("currentHeight/2="+popupPosTop);
	if(isOpened==true) //if there is any popup shows up on the window, then we realocate the position of the popup
	{
		var popupWidth=$(".popup").width(); //get the width of the popup window
		logging("POPUP W="+popupWidth);
		//set position
		$("#popupContainer").css(
		{
			top:(popupPosTop/2)*0.9,
			left:popupPosLeft-popupWidth/2
		});
	}
}
//put the buttons on each panel to the center
/*function centerPopup()
{
	//get the width and height
	logging("center");
	logging($(".buttonPanel").width());
	logging($(".buttonPanel").height());
	var left=$(".popup").width()/2-$(".buttonPanel").width()/2;
	var top=$(".popup").height()-$(".buttonPanel").height()-8;
	$(".buttonPanel").css("top",top);
	$(".buttonPanel").css("left",left);
}*/
//END OF POPUP CONTROLLER=======================================================================

//set error data=========================================
function setData(data)
{
	logging("set data");
	$("#errorContent").html(data);
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