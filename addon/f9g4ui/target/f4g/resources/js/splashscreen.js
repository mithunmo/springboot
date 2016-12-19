//splash creen main.js 06/07/2012
//All required function are defined outside the $(document).ready event
//All objects event listened are defined in the $(document).ready event

////initialization
var debugMode=false; //when this value set to true, it will show up a debug window on the left screen
var usernameValue="Please enter your email"; //text value for the username textfield on the login panel
var passwordValue="Please enter your password"; //text value for the password textfield on the login panel
var popupPosTop=$(window).height()/2; //get the width of window
var popupPosLeft=$(window).width()/2; //get the height of window
var isOpened=false; //flag to determine is there any popup window show up on the screen

//When document loading finish, it will initaite the program below
$(document).ready(function()
{
	//test
	test();	//put test data on bottomPanel
	//scrollbar====================================================
	$("#scrollbar1").tinyscrollbar(); //initialize scrollbar
	$("#scrollbar2").tinyscrollbar();
	$("#scrollbar3").tinyscrollbar();
	
	//bottom panel scrollbar listener------------------------------------------
	$(".entity").mouseenter(function(e)
	{
		logging(e.currentTarget.id);
		$("#"+e.currentTarget.id+"_entity").fadeIn(); //show the specific scroll bar
		
	});
	$(".entity").mouseleave(function(e)
	{
		logging(e.currentTarget.id);
		$("#"+e.currentTarget.id+"_entity").fadeOut(); //show the specific scroll bar
	});
		
	//submit button on login panel button event====================================
	$("#submit").click(function()
	{	
		if(checkUserInput()==true)	//check user input
		{
			doLogin();
		}

	});
	//forget link event to open popup
	$("#link_forget").click(function()
	{		
		loadPopup(forgotPwdUrl);	//load page using ajax
	});
	
	//userinput checking==========================================================================================
	//If the value of username textfiled is Username, than make text field blank
	$("#username").val(usernameValue);
	$("#password").val(passwordValue);
	
	$("#username").click(function(e)
	{
		$("#"+e.currentTarget.id).css("color","#000"); //set the color of font return to black
		if($("#"+e.currentTarget.id).val()==usernameValue) //if the data is equal to the original value, then reset the data
			$("#"+e.currentTarget.id).val("");
	});
	$("#password").click(function(e)
	{
		$("#"+e.currentTarget.id).css("color","#000"); //set the color of font return to black
		if($("#"+e.currentTarget.id).val()==passwordValue) //if the data is equal to the original value, then reset the data
			$("#"+e.currentTarget.id).val("");
	});
	
	//event handler for checking agree or decline radio button on terms panel=============
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
	
	//buttons event hadler---------------------------------------------------------
	$(".button").live("click",function(e)
	{
		logging(e.target.id);
		if(e.target.id=="gotoSecurity")	//buttons on forget panel
		{
			//check user input of email text field
			if($("#email").val()=="")
			{
				$("#nofify_email").html("Please enter your email"); //update the text on the notification div
				$("#nofify_email").fadeIn(); //show the notification
			}
			else if($("#email").val().search(" ")!=-1)
			{
				$("#nofify_email").html("It's not an invalid email format"); //update the text on the notification div
				$("#nofify_email").fadeIn(); //show the notification
			}
			else
			{
				loadSecurityQuestionsData();
/*				//user indeed input data. Proceed to next step
				//hide the current session and shows the next session
				$("#session_forget").fadeOut(function()
				{	
					$("#session_security").fadeIn(); //show up the next session
				});*/
			}
		}
		else if(e.target.id=="gotoResult") //button on security panel
		{
			submitSequrityQuestions();
			/*
			 //hide the current session and shows the next session
			$("#session_security").fadeOut("fast",function()
			{
				$("#session_success").fadeIn(); //show up the nexr session
			});*/
		}
		else if(e.target.id=="resetPwd") 
		{
			//resetPassword
			resetPassword();
		}
		else if(e.target.id=="terms_ok") //button on terms panel
		{	
			//check the raio button value to decide the functionality of the button
			if($("#terms_agree").attr("checked")=="checked") //if user check agree, then go to verification panel
			{
				subimtTermAndConditions();
			}
			else if($("#terms_decline").attr("checked")=="checked") //if user decline the term, then close the panel
			{
				closepopup();
			}
		}
/*		else if(e.target.id=="submitVerification") //button on submitVerification panel
		{
			logging("capcha submit");
		}*/
		else if(e.target.id=="close") //close button
		{
			closepopup();
		}
	});
	
	//close pupup handler--------------------------------
	$(".close").live("click",function() //if user hit the X button on the popup panel, then close the popup.
	{
		closepopup();
	});
	
	//resize event
	$(window).resize(function()
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
			//update the scrollbar
			$("#termScrollbar").tinyscrollbar('relative');
		}
	});
});
//test function, put test data on bottom panel to test each scrollbar
function test()
{
	var data="";
	for(var i=1;i<=30;i++)
		data+="this is line "+i+"<br />";
	$("#companyNews").html(data);
	$("#industyNews").html(data);
	$("#socialFeeds").html(data);
}
//close the current popup window
function closepopup()
{
	//show the effect to close the popup
	$("#popupContainer").fadeOut("fast",function()
	{
		//hide overlay
		$("#overlay").fadeOut();
	});
	//reset popup
	$(".notification").css("display","none");
	//reset style of popupContainer
	$("#popupContainer").removeAttr("style");
	//reset isOpened flag
	isOpened=false;
}
//check user input on login panel----------------------------------------------
function checkUserInput()
{
	var isCorrect=true;
	//if the input is blank, default value, or contains any space, regard it as a invalid input
	if($("#username").val()=="" || $("#username").val()==usernameValue || $("#username").val().search(" ")!=-1)
	{
		$("#username").css("color","red"); //make the text color into red to notice user.
		$("#username").val(usernameValue); //reset the text to default value
		isCorrect=false;
	}
	if($("#password").val()=="" || $("#password").val()==passwordValue || $("#password").val().search(" ")!=-1)
	{
		$("#password").css("color","red");
		$("#password").val(passwordValue);
		isCorrect=false;
	}
	return isCorrect;
}


function submitSequrityQuestions(){
	var address = $('#forgotPwd').attr("action"); 
	$.ajax(
			{
				url: address,
				type: "POST",
				data:$('#forgotPwd').serialize(),  

				beforeSend: function()
				{
					logging("loading "+address);
				},
				error: function(xhr,status,error)
				{
					logging(this.url+" is "+error); //if there is arrow, close the overlay
					$("#overlay").fadeOut("fast"); //show the overlay when loading
				},
				success: function(result)
				{
					logging("loading "+this.url+"complete");
					$("#session_security").fadeOut(function()
					{
						$("#session_reset_password").html(result);
						$("#session_reset_password").fadeIn(); //show up the next session
					});

				}
			});
}

function resetPassword(){
	var address = $('#reset_password').attr("action"); 
	$.ajax(
			{
				url: address,
				type: "POST",
				data:$('#reset_password').serialize(),  

				beforeSend: function()
				{
					logging("loading "+address);
				},
				error: function(xhr,status,error)
				{
					logging(this.url+" is "+error); //if there is arrow, close the overlay
					$("#overlay").fadeOut("fast"); //show the overlay when loading
				},
				success: function(result)
				{
					logging("loading "+this.url+"complete");
					if(result.hasError ==="true"){
						$("#session_reset_password").fadeOut(function(){
							$("#reset_success").fadeIn(); //show up the next session
						});	
					}else{
						$("#session_reset_password").fadeOut(function(){
							$("#reset_fail").fadeIn(); //show up the next session
						});	
					}
				}
			});
}

function loadSecurityQuestionsData(){
	var address = securityQuestionsUrl + "?userName=" + $("#email").val(); 
	$.ajax(
			{
				url: address,
				beforeSend: function()
				{
					logging("loading "+address);
					//$("#overlay").fadeIn("fast"); //show the overlay when loading
				},
				error: function(xhr,status,error)
				{
					logging(this.url+" is "+error); //if there is arrow, close the overlay
					$("#overlay").fadeOut("fast"); //show the overlay when loading
				},
				success: function(result)
				{
					logging("loading "+this.url+"complete");
					var items = [];
					$.each(result, function(key, val) {
					    items.push({'key': key, 'val':val});
					});
					
					if(items[0] && items[0].val){
						$("#q1_id").val(items[0].key);
						$("#q1_val").val(items[0].val);
					}
					
					if(items[1] && items[1].val){
						$("#q2_id").val(items[1].key);
						$("#q2_val").val(items[1].val);
					}
					
					//hide the current session and shows the next session
					$("#session_forget").fadeOut(function()
					{	
						$("#session_security").fadeIn(); //show up the next session
					});					  
				}
			});
}

function doLogin(){
	
	var loginFrom = $('#form_login');
	var address = loginFrom.attr("action"); 
	//ajax method
	$.ajax(
	{
		url:address,
		type: "POST",
		data:loginFrom.serialize(),  
		//
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
			if(result && result.hasError){
				//TODO how to show errors...
				$("#overlay").fadeOut("fast"); 
				var errorInfo = new Array();
				for(var i=0; i<result.errors.length ; i++){
					errorInfo.push(result.errors[i].defaultMessage);
				}
				$("#popupContainer").html(errorInfo.join("<br/>"));
				showpopup();
			}else{
				if(result.termsExpired === true ){
					displayTermAndConditions(result.termsId);
				}else{
					var redirectUrl = consoleHomeUrl;
					$(location).attr('href',redirectUrl);
				}
				//$("#popupContainer").html("Success"); //set the result to the pupCoopntainer
				//$("#overlay").fadeOut("fast"); 
				//show the popup on the screen
				//showpopup();			
			}
		}
	});	
}

function displayTermAndConditions(termsId){
	
	//ajax method
	var address =  termsUrl + "/" + termsId;
	$.ajax(
	{
		url:address,
		type: "GET",
		//
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
			if(!(result && result.hasError)){
				//No error, show terms and conditioins popup..
				$("#popupContainer").html(result); //set the result to the popupContainer
				$("#terms_ok").css({
							"background-color":"#333",
							"cursor":"default"
							});
				//show the popup on the screen
				showpopup();
			}else{
				//error..
				//TODO .. if some error while loading t and c what should we do???
				//thinking of redirect to console home..
				$(location).attr('href',consoleHomeUrl);
			}
		}
	});	
}

function subimtTermAndConditions()
{

	var loginFrom = $('#terms_form');
	var address = loginFrom.attr("action"); 

	$.ajax(
	{
		url:address,
		type: "POST",
		data:loginFrom.serialize(),
		//
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
			if(!(result && result.hasError)){
				//no error
				//loadPopup("verification.html");	//load verification page --TODO
				$(location).attr('href',consoleHomeUrl);
			}else{
				//has errors... submitting terms
				$(location).attr('href',consoleHomeUrl);
//				closepopup();
			}
		}
	});	
}
//load ajax data---------------------------------------------------------------
function loadPopup(address)
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
			if(address=="forgot_password.html") //if the popup is the forget password panel, reset to default
			{
				//reset data
				$("#email").val(""); //clean the email text field
				//hide notification
				$(".notification").css("display","none"); //hide notification field
				//hide all panels
				$("#session_security").css("display","none");
				$("#session_success").css("display","none");
				$("#session_fail").css("display","none");
				//show the first panel
				$("#session_forget").css("display","block");
			}
			if(address=="terms.html") //if the popup is the terms panel, then disable the button first.
			{
				//disable the ok button
				$("#terms_ok").css(
				{
					"background-color":"#333",
					"cursor":"default"
				});
			}
			//show the popup on the screen
			showpopup();	
		}
	});
}
//show popup window by target===============================================================================
function showpopup()
{
	isOpened=true; //set the flag 
	var target="#popupContainer";
	var popupWidth=$(".popup").width(); //get the width of the popup window	
	//set the popup position
	$(target).css(
	{
		top:(popupPosTop/2)*0.9,
		left:popupPosLeft-popupWidth/2
	});
	//animation to show the popup, like scaling effect from 0 to designated width
	$(target).css("display","block");
	$(target).width(0);
	$(target).height(0);
	$(target).animate(
	{
		width:popupWidth,
		height:450
	});
	center(); //meke the buttons always display on the center
	$("#termScrollbar").tinyscrollbar(); //initiate the scroll bar in terms panel !!!important
}
//put the buttons on each panel to the center
function center()
{
	//get the width and height
	logging("center");
	logging($(".buttonPanel").width());
	logging($(".buttonPanel").height());
	var left=$(".popup").width()/2-$(".buttonPanel").width()/2;
	var top=$(".popup").height()-$(".buttonPanel").height()-10;
	$(".buttonPanel").css("top",top);
	$(".buttonPanel").css("left",left);
}
//show error
function showError(msg)
{
	$.ajax(
	{
		url: appPath+"error",
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
			//fill in the error message in error container
			$("#error").html(msg);
			showpopup();
		}
	});
}

//debug function, continue to record the data
function logging(data)
{
	if(debugMode)
		$("#debug").css("display","block");
	if(data==undefined || data=="")
		$("#debug").append("Undefined or blank <br />");	
	$("#debug").append(data+"<br />");
	$("#debug").scrollTop($("#debug")[0].scrollHeight);
}

