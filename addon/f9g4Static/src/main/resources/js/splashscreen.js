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
var disableRightClick=false;
var isPassedBrowserChecking=true;
//When document loading finish, it will initaite the program below
$(document).ready(function()
{
	//browser checking
	browserChecking();
		
	//focus on username field
	setTimeout(function () 
	{
		$('#username').focus();
	}, 100);
	$("#username").focus(function(){
	    // Select input field contents
	    this.select();
	});
	
	//init place holder plugin if the browser doesn't support placeholder attribute
	$("input").placeholder();
	
	//scrollbar====================================================
	$("#scrollbar1").tinyscrollbar(); //initialize scrollbar
	$("#scrollbar2").tinyscrollbar();
	$("#scrollbar3").tinyscrollbar();
	$("#scrollbarFooter").tinyscrollbar();
	
	//disable mouse right click==================================================
	if(disableRightClick)
	{
		$(document).bind("contextmenu",function(e)
		{
			return false;
		});
	}
	//bottom panel scrollbar listener------------------------------------------
	/*$(".entity").mouseenter(function(e)
	{
		//logging(e.currentTarget.id);
		if ( $.browser.msie && $.browser.version == "8.0") //show the overlay when loading
		{
			$("#"+e.currentTarget.id+"_entity").css('filter', 'alpha(opacity=70)');
		}
		$("#"+e.currentTarget.id+"_entity").fadeIn(); //show the specific scroll bar
		
	});
	$(".entity").mouseleave(function(e)
	{
		//logging(e.currentTarget.id);
		$("#"+e.currentTarget.id+"_entity").fadeOut(); //show the specific scroll bar
	});*/
		
	//submit button on login panel button event====================================
	$("#submit").click(function()
	{	
		//if browser chacking is not passed, do not allow user to login.
		logging("browser checking=>"+isPassedBrowserChecking);
		if(isPassedBrowserChecking)
		{
			if(checkUserInput()==true)	//check user input
			{
				doLogin();
			}
		}
		else
			browserChecking();
	});
	//forget link event to open popup
	$("#link_forget").click(function()
	{		
		loadPopup(forgotPwdUrl);	//load page using ajax
	});
	
	/*$("#username").click(function(e)
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
	});*/
	//keyboard event
	$("#username").live("keydown",function(e)
	{
		//when user press enter key
		if(e.which==13)
		{
			//if browser chacking is not passed, do not allow user to login.
			logging("browser checking=>"+isPassedBrowserChecking);
			if(isPassedBrowserChecking)
			{
				if(checkUserInput()==true)	//check user input
				{
					doLogin();
				}
			}
			else
				browserChecking();
		}
	});
	$("#password").live("keydown",function(e)
	{
		//when user press enter key
		if(e.which==13)
		{
			//if browser chacking is not passed, do not allow user to login.
			logging("browser checking=>"+isPassedBrowserChecking);
			if(isPassedBrowserChecking)
			{
				if(checkUserInput()==true)	//check user input
				{
					doLogin();
				}
			}
			else
				browserChecking();
		}
	});
	
	$("#remember").live("keydown",function(e)
	{
		//when user press enter key
		if(e.which==13)
		{
			//if browser chacking is not passed, do not allow user to login.
			logging("browser checking=>"+isPassedBrowserChecking);
			if(isPassedBrowserChecking)
			{
				if(checkUserInput()==true)	//check user input
				{
					doLogin();
				}
			}
			else
				browserChecking();
		}
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
			loadSecurityPanel();
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
		else if(e.target.id=="terms_ok_login")
		{
			logging("vbf");
			logging($("#terms_lg").action);
			if($("#terms_agree_login").attr("checked")=="checked")
				$("#terms_lg").submit();
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
	
	//enter key event on forget password popup
	$("#email").live("keydown",function(e)
	{
		//when user press enter key
		if(e.which==13)
		{
			loadSecurityPanel();
		}
	});
	$("#q1_ans").live("keydown",function(e)
	{
		//when user press enter key
		if(e.which==13)
		{
			submitSequrityQuestions();
		}
	});
	$("#q2_ans").live("keydown",function(e)
	{
		//when user press enter key
		if(e.which==13)
		{
			submitSequrityQuestions();
		}
	});
	$("#confirmPwd").live("keydown",function(e)
	{
		//when user press enter key
		if(e.which==13)
		{
			resetPassword();
		}
	});
	$("#close").live("keydown",function(e)
	{
		//when user press enter key
		if(e.which==13)
		{
			logging("close");
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
	
	//password complexity validation event
	$('#newPwd').live("keyup",function()
	{
		$('#result').html(checkStrength($('#newPwd').val()))
	});
	
	//close error popup event handler
	$("body").live("close_error",function()
	{
		logging("Receive error close information");
		//clear the password field
		$("#password").val("");
		//focus on the password field
		$("#password").focus();
	});
});

//Load subpanelof forget password 
function loadSecurityPanel()
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
	logging("SUBMIT SEQ Q=>"+address);
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
					if(result.hasError == true)
						{
							$("#notify_questions").html("Security answers entered do not match. Please try again."); //update the text on the notification div
							$("#notify_questions").fadeIn();
						}
					else
						{
								$("#session_security").fadeOut(function()
								{
									//$("#session_reset_password").html(result);
									$("#session_reset_password").fadeIn(function()
									{
										//focus on username field
										setTimeout(function () 
										{
											$('#newPwd').focus();
										}, 100);
										$("#newPwd").focus(function(){
										    // Select input field contents
										    this.select();
										});
									}); //show up the next session
								});

						}
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
					if(result.hasError == false){
						$("#session_reset_password").fadeOut(function(){
							$("#reset_success").fadeIn(function()
							{
								//set focus on the button
								setTimeout(function () 
								{
									$('#close').focus();
								}, 100);
							}); //show up the next session
						});	
					}else{			
							$("#notify_passw_mismatch").html("Your passwords do not match. Please try again.");  //show up the next session
							$("#notify_passw_mismatch").fadeIn();
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
					//console.log(result);
					if(result)
					{
						logging("result.hasError ->"+result.hasError);
						if(result.hasError===true)
						{
							$("#nofify_email").html("Email ID entered is invalid. Please try again."); //update the text on the notification div
							$("#nofify_email").fadeIn();
						}
						else
						{
							$("#q1_id").attr("value",result.Q1Id);
							$("#q1_val").attr("value",result.Q1val);
							$("#q2_id").attr("value",result.Q2Id);
							$("#q2_val").attr("value",result.Q2val);
							
							$("#session_forget").fadeOut(function()
							{	
								$("#session_security").fadeIn(function()
								{
									//focus on q1_ans field
									setTimeout(function () 
									{
										$('#q1_ans').focus();
									}, 100);
									$("#q1_ans").focus(function(){
									    // Select input field contents
									    this.select();
									});
								}); //show up the next session
							});	
						}
					}
					//hide the current session and shows the next session
									  
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
			if ( $.browser.msie && $.browser.version == "8.0") //show the overlay when loading
			{
				$('#overlay').css('filter', 'alpha(opacity=70)');
			}
			$("#overlay").fadeIn("fast");
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
				//$("#overlay").fadeOut("fast"); 
				var errorInfo = new Array();
				for(var i=0; i<result.errors.length ; i++){
					errorInfo.push(result.errors[i].defaultMessage);
				}
				//$("#popupContainer").html(errorInfo.join("<br/>"));
				$("#overlay").fadeOut(); //show the overlay when loading
				showErrorMsg(errorInfo.join("<br/>"),true);
			}else{
				
					if(result.termsExpired === true && result.membershipExpired === true)
					{
						//Gotta Desgin an alternate flow ! So that both con be done
					}
					
					if(result.termsExpired === true )
					{
						displayTermAndConditions(result.termsId);
					}
					
					else if(result.membershipExpired === true )
					{
						location.assign(updateMembershipPath+"?userId="+result.userId);
					}
					
					else 
					{
						var redirectUrl = consoleHomeUrl;
						$(location).attr('href',redirectUrl);
					}
				}
				//$("#popupContainer").html("Success"); //set the result to the pupCoopntainer
				//$("#overlay").fadeOut("fast"); 
				//show the popup on the screen
				//showpopup();			
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
			if ( $.browser.msie && $.browser.version == "8.0") //show the overlay when loading
			{
				$('#overlay').css('filter', 'alpha(opacity=70)');
			}
			$("#overlay").fadeIn("fast");
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
				$("#termScrollbar").tinyscrollbar(); 
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

function subimtTermAndConditions(){

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
			if ( $.browser.msie && $.browser.version == "8.0") //show the overlay when loading
			{
				$('#overlay').css('filter', 'alpha(opacity=70)');
			}
			$("#overlay").fadeIn("fast");
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
/*function loadPopup(address)
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
}*/
//show popup window by target===============================================================================
/*function showpopup()
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
}*/
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
function checkStrength(password)
{
	//initial strength
    var strength = 0;
    var requirements=new Array();
    requirements[0]=false; //length
    requirements[1]=false; //Contain capital
    requirements[2]=false; //Contain number
    requirements[3]=false; //Contain special character
    
	
    //if the password length is less than 6, return message.
    if (password.length < 6) 
    { 
		$('#result').removeClass();
		$('#result').addClass('short');
		requirements[0]=false;
		return 'Password needs to contain at least 6 amount of characters';
	}
    
    //length is ok, lets continue.
	
	//if length is 8 characters or more, increase strength value
	if (password.length > 7)
	{
		requirements[0]=true;
		strength += 1;
	}
	
	//if password contains both lower and uppercase characters, increase strength value
	if (password.match(/([A-Z])/))
	//if (password.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/))
	{
		requirements[1]=true;
		strength += 1;
	}
	
	//if it has numbers and characters, increase strength value
	if (password.match(/([a-zA-Z])/) && password.match(/([0-9])/))
	{
		requirements[2]=true;
		strength += 1;
	}
	
	//if it has one special character, increase strength value
    if (password.match(/([!,%,&,@,#,$,^,*,?,_,~,-])/)) 
    {
    	requirements[3]=true;
    	strength += 1;
    }
	
	//if it has two special characters, increase strength value
    if (password.match(/(.*[!,%,&,@,#,$,^,*,?,_,~,-].*[!,%,&,@,#,$,^,*,?,_,~,-])/)) 
    {
    	requirements[3]=true;
    	strength += 1;
    }
	
	//now we have calculated strength value, we can return messages
	
	//if value is less than 2
	if (strength < 4 ) 
	{
		var result="";
		$('#result').removeClass();
		$('#result').addClass('weak');
		if(!requirements[1])
			result+=" 1 capital.";
		else if(!requirements[2])
			result+=" 1 number";
		else if(!requirements[3])
			result+=" 1 special character";
		if(result!="")
			return "Weak. Should contain "+result;
		else
			return "Weak.";		
	} 
	else if (strength == 4 ) 
	{
		$('#result').removeClass();
		$('#result').addClass('good');
		return 'Good';		
	} 
	else 
	{
		$('#result').removeClass();
		$('#result').addClass('strong');
		return 'Strong';
	}
}
function browserChecking()
{
	/* detect usage of IE Developer Tools using different Mode for Browser and Document */
	var browserCheckingMsg="";
	//detect IE version
	if($.browser.msie) 
	{
		var browserVersion = $.browser.version.slice(0,$.browser.version.indexOf("."));
		var documentVersion = document.documentMode;
		logging("document mode=>"+documentVersion);
		if(browserVersion != documentVersion) 
		{
			browserCheckingMsg="ERROR:\nBrowser Mode and Document Mode do not match!\n\nBrowser Mode: IE"+ browserVersion +".0\nDocument Mode: IE"+ documentVersion +".0";
			showErrorMsg(browserCheckingMsg,true,"Browser Checking Warning",true);
			isPassedBrowserChecking=false;
		}
		else if(browserVersion<=7)
		{
			browserCheckingMsg="We detect your browser is IE "+ browserVersion +" or lower. We support IE 8 and above. Thank you.";
			showErrorMsg(browserCheckingMsg,true,"Browser Checking Warning",true);
			isPassedBrowserChecking=false;
		}
		else if(documentVersion<=7)
		{
			browserCheckingMsg="We detect the document mode of your browser is IE "+ browserVersion +" or lower. We support the document mode of IE 8 and above. Thank you.";
			showErrorMsg(browserCheckingMsg,true,"Browser Checking Warning",true);
			isPassedBrowserChecking=false;
		}
	}
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