// JavaScript Document
var debugMode=true; //when this value set to true, it will show up a debug window on the left screen
var errorStyle="color:#FF0000";

//document event handler
$(document).ready(function()
{
	//button event==================================
	//save button on registration page
	$("#save").live("click",function(e)
	{
		//remove previous high light fields
		$(".label").removeAttr("style");
		var errors= checkInput(); //check user input
		//var errors=new Array();
		var termsAccepted = $("#form_terms").attr("checked");
		if(errors.length > 0)
		{	
			showErrorMsg("The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),true);
		}
		else
		{
			//check form_terms fields
			if(termsAccepted==undefined)
			{
				$(".label").removeAttr("style");
				showErrorMsg("Please Read Terms and Conditions. Thank you.");
			}
			else
				submitRegForm();
			//loadPopup("thanks.html"); //show thank you popup
		}
	});
	//cancel button on registration page
	$("#cancel").live("click",function(e)
	{
		logging("cancel");
		$("form")[0].reset();
		$("#user_logo").html("");
	});
	//Ok button in terms and conditions------------
	$("#register").live("click",function(e)
	{
		logging("ok");
		//show membership popup
		//loadPopup("membership.html");
		//displayMembership(membershipUrl +"/" + $("#reg_userid").val());
		//redirect to splash screen
		location.assign(loginPage);
	});
	//Hyperlink for read terms and conditions-------------
	$("#read_terms").click(function()
	{
		//loadPopup("terms.html"); //show terms
		//ResgistrationTermsPath -> this loads cutomerregistrationpath for customers and designerregistrationpath for designers
		displayLatestTermAndConditions(ResgistrationTermsPath); //show terms
	});
	
	//Membership popup------------------------------------
	$("#membership_ok").click(function()
	{
		closepopup();
	});
	
	$(".reg_success_ok").live("click",function() //if user hit the X button on the popup panel, then close the popup.
			{
				var target="#popupContainer";
				var overlayTarget="#overlay";
//				if(overlay!=undefined)
//					overlayTarget=overlay;
//				if(param!=undefined)
//					target=param;
				//show the effect to close the popup
				$(target).fadeOut("fast",function()
				{
//					//hide overlay
//					$(overlayTarget).fadeOut();
				});
				//reset popup
				$(".popup .notification").css("display","none");
				//reset style of popupContainer
				$(target).removeAttr("style");
				isOpened=false;
				location.assign(loginPage);
			});
	//event handler when user click OK in membership popup
	/*$("#membership_return").live("click",function(e)
	{
		logging("membership OK");
		//show thank you popup
		$("#popupContainer").html($('#verification_content').html()); //set the result to the pupCoopntainer 
		//show the popup on the screen
		showpopup();
		//closepopup();
		location.assign();
	});*/
	//event handler when user click the Ok on terms and conditions panel-------
	$("#terms_ok").live("click",function(e)
	{
		logging("click OK in terms");
		//check the raio button value to decide the functionality of the button
		if($("#terms_agree").attr("checked")=="checked") //if user check agree, then go to verification panel
		{
			// capture terms id
			var termId = $('input[name="termsId"]').val();
			closepopup();
			//check the chechbox in registration page
			$("#form_terms").attr("checked","checked");
			$('#form_accepted_termsId').val(termId);
		}
		else if($("#terms_decline").attr("checked")=="checked") //if user decline the term, then close the panel
		{
			closepopup();
			//uncheck the chechbox in registration page
			$("#form_terms").removeAttr("checked");
		}
	});
	//Pay button in membership popup-------------------------------------------
	$("#pay").live("click",function(e)
	{
		logging("Pay click");
		//save the paypal form data
		/*var membershipForm=$("#membership_form");
		var redirectContent="We will redirect you to the Paypal Website, Continue?";
		redirectContent+='<br /><div class="button" id="paypal_ok">Yes</div><div class="button orangeButton" id="paypal_no">No</div>';
		showErrorMsg(redirectContent,false,"Notice");*/
		
	});
	
	//Upload Image--------------------------------------------------------------
	$("#upload_image").live("click",function(e)
	{
		logging("Upload Image");
		loadUploadPopup(uploadPicturesPath,"LOGO","ai","user_logo");
	});
	$("body").live("upload_finished",function(e)
	{
		//console.log(e.filename);
		//fill the image url into form (for user logo, we only need the url of 400x400)
		$("#form_logo_image_url").val("/400x400/"+e.filename_400);
		$("#user_logo").html('<i></i><img src="/400x400/'+e.filename_400+'" />');
	});
	
	//disabling checkbox, as its working with spring <form:checkbox> in jsp. 
	$("#form_terms").attr("disabled","disabled");
	
	//live chat 
	$("#livechat").bind("click",function(e)
	{
		showErrorMsg('<div style="color:#0000CC; font-size:16px; width:100%; text-align:center;">We are implementing our live chat module, please call us at 1-800-550-0802.</div>',true,"Live Chat");
	});
	
	//password complexity validation event
	$('#form_password').keyup(function()
	{
		$('#result').html(checkStrength($('#form_password').val()))
	});
	
	//format the website url. If the user didn't put the http:// in front of the address, add it automatically.
	$("#form_website").change(function() 
	{
		 if (!/^http:\/\//.test(this.value)) 
		 {	 
	            this.value = "http://" + this.value;
		 }
	});
	$("#form_membership_payment").live("submit",function(e) {
		$("#form_membership_payment").prop("disabled",true);
		$("#membership_payment").prop("disabled",true);
		//apply the mask on the paynow button
		$('#paynowMask').css("z-index","10");
	});
});
//show error data=====================================================================
function showCompRegMsg(msg, showOk, title, modal)
{
	var layout="";
	layout+='<div class="popup">';
	layout+='<div class="header">';
	if(title==undefined || title=="")
		layout+='Error';
	else
		layout+=title;
	layout+='<div class="error_close">X</div>';
	layout+='</div>';
	layout+='<div class="content" id="error">';
	layout+='<div id="errorContent">';
	layout+=msg;
	layout+='</div>';
	layout+='<div class="buttonPanel" style="width:85%">';
	if(showOk==true)
		layout+='<div class="button reg_success_ok" id="reg_success_ok">Ok</div>';
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
	//show overlay
	if ( $.browser.msie && ($.browser.version == "8.0" || $.browser.version == "7.0")) 
	{
		$('#error_overlay').css('filter', 'alpha(opacity=70)');
	}
	$("#error_overlay").fadeIn();
	showpopup("#error"); //show the popup which div is id=error
}

function displayLatestTermAndConditions(address)
{
	//ajax method
	$.ajax(
	{
		url:address,
		type: "GET",
		//
		beforeSend: function()
		{
			logging("loading "+address);
			//set the opactity value if the browser is IE 8
			if ( $.browser.msie && ($.browser.version == "8.0" || $.browser.version == "7.0")) 
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
			if(!(result && result.hasError))
			{
				//No error, show terms and conditioins popup..
				$("#popupContainer").html(result); //set the result to the popupContainer
				$("#terms_ok").css({
							"background-color":"#333",
							"cursor":"default"
							});
				//show the popup on the screen
				showpopup();
			}
		},
		complete: function(xhr,status)
		{
			$("#termScrollbar").tinyscrollbar(); //initiate the scroll bar in terms panel !!!important
		}
	});	
}

function displayMembership(address)
{	
	//ajax method
	$.ajax(
	{
		url:address,
		type: "GET",
		//
		beforeSend: function()
		{
			logging("loading "+address);
			//set the opactity value if the browser is IE 8
			if ( $.browser.msie && ($.browser.version == "8.0" || $.browser.version == "7.0")) 
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
			//No error, show terms and conditioins popup..
			$("#popupContainer").html(result); //set the result to the popupContainer
			$("#terms_ok").css
			({
				"background-color":"#333",
				"cursor":"default"
			});
			showpopup();
		}
	});
}
function submitRegForm()
{
	logging("designer=>"+$('#form_reg_designer').length);
	logging("company=>"+$('#form_reg_company').length);
	var address;
	var formData;
	if($('#form_reg_designer').length>0)
	{
		address = $('#form_reg_designer').attr("action");
		formData=$('#form_reg_designer').serialize();
	}
	else if($('#form_reg_company').length>0)
	{
		address = $('#form_reg_company').attr("action");
		formData=$('#form_reg_company').serialize();
	}
	var fName = $('#form_first_name').val();
	var lName = $('#form_last_name').val();
	
	var isComp = $('#comp').val();
	
	//ajax method
	$.ajax(
	{
		url:address,
		type: "POST",
		data: formData,  
		//
		beforeSend: function()
		{
			logging("loading "+address);
			//set the opactity value if the browser is IE 8
			if ( $.browser.msie && ($.browser.version == "8.0" || $.browser.version == "7.0")) 
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
			logging("loading "+this.url+" complete");
			/*if(result)
				alert(result);
			if(result.hasError)
				alert(result.hasError);*/
			if(result && result.hasError && result.hasError == true)
			{
				var errorInfo = new Array();
				//remove previous hightlight fields
				$(".label").removeAttr("style");
				for(var i=0; i<result.errors.length ; i++)
				{
					errorInfo.push(result.errors[i].defaultMessage);
					//helight area
					logging("Error field=>"+result.errors[i].field);
				}
				//hightlight error fields
				highlightErrorFields(result);
				//$("#errorContainer").html(errorInfo.join("<br/>"));
				$("#overlay").fadeOut("fast"); //show the overlay when loading
				showErrorMsg("Please enter data in the mandatory fields as highlighted in the screen and also displayed in the list:<br/>"+errorInfo.join("<br/>"),true);
			}
			else
			{	
				if(isComp){
					showCompRegMsg("Thanks for registering, we will get back to you shortly.",true, "Registration ", null);
					
				}else{
					$('#designer_name').text(fName + " " + lName);
					logging("Register Success UserId="+result.userId);
					$('#reg_userid').val(result.userId);
					//show membership
					//displayMembership(membershipUrl +"/" + $("#reg_userid").val());
					//assign to different page
					location.assign(membershipUrl +"?userId=" + result.userId);					
				}
			}
		}
	});
}

//check user input, if there is error occured show error popup
function checkInput()
{
	//var isCorrect=false;
	var errors = new Array();
	var href=location.pathname; //get website address to determine we are in designer or company
	
	if(href.search("designer")!=-1)
	{
		//designer page
		errors = CheckforNullandSpace("#form_username",errors,"#label_username","Please enter Username");
        errors = CheckforNullandSpace("#form_password",errors,"#label_password","Please enter Password");
        errors = CheckforNullandSpace("#form_confirm" ,errors,"#label_confirm" ,"Please enter Confirm Password");
	
		if($("#form_password").val()!=$("#form_confirm").val())
		{
			//loadPopup("error.html","Password and Confirm Password must be the same");
			errors.push("Password and Confirm Password must be the same");
			$("#label_password").attr("style",errorStyle);
			$("#label_confirm").attr("style",errorStyle);
		}
		errors = CheckforNull("#form_ans_q1",errors,"#label_ans_q1","Please enter answer for Security Question 1");
		errors = CheckforNull("#form_ans_q2",errors,"#label_ans_q2","Please enter answer for Security Question 2");
		errors = CheckforNull("#form_first_name",errors,"#label_firstname","Please enter First Name");
		errors = CheckforNull("#form_last_name" ,errors,"#label_lastname" ,"Please enter Last Name");
		errors = CheckforNull("#form_address_1",errors,"#label_address_1","Please enter Street Address 1");
		errors = CheckforNull("#form_city",errors,"#label_city","Please enter City");
		errors = CheckforNull("#form_state",errors,"#label_state","Please enter State");
		errors = CheckforNullandNumber("#form_zipcode",errors,"#label_zipcode","Please enter Zip Code")
		errors = CheckforNull("#form_country",errors,"#label_country","Please enter Country");
		errors = CheckforNullandPhoneNumber("#form_cell_phone",errors,"#label_cell_phone","Cell Phone Number");
		errors = CheckforNullinSelect("#form_languages",errors,"#label_languages","Please select at least 1 language");
		errors = CheckforNull("#form_company_name",errors,"#label_company_name","Please enter Company Name");
		errors = CheckforNullandPhoneNumber("#form_brand_work_phone",errors,"#label_brand_work_phone","Brand Work Phone Number");
		//errors = CheckforNullandPhoneNumber("#form_fax",errors,"#label_fax","Fax Number");
		errors = CheckforNullinSelect("#form_skills",errors,"#label_skills","Please select at least 1 skill");
		
	}
	else
	{
		errors = CheckforNullandSpace("#form_username",errors,"#label_username","Please enter Username");
        errors = CheckforNullandSpace("#form_password",errors,"#label_password","Please enter Password");
        errors = CheckforNullandSpace("#form_confirm" ,errors,"#label_confirm" ,"Please enter Confirm Password");
        
        if($("#form_password").val()!=$("#form_confirm").val())
		{
			//loadPopup("error.html","Password and Confirm Password must be the same");
			errors.push("Password and Confirm Password must be the same");
			$("#label_password").attr("style",errorStyle);
			$("#label_confirm").attr("style",errorStyle);
		}
        
		errors = CheckforNull("#form_ans_q1",errors,"#label_ans_q1","Please enter answer for Security Question 1");
		errors = CheckforNull("#form_ans_q2",errors,"#label_ans_q2","Please enter answer for Security Question 2");
		errors = CheckforNull("#form_first_name",errors,"#label_firstname","Please enter First Name");
		errors = CheckforNull("#form_last_name" ,errors,"#label_lastname" ,"Please enter Last Name");
		errors = CheckforNullinSelect("#form_languages",errors,"#label_languages","Please select at least 1 language");
		errors = CheckforNullandPhoneNumber("#form_cell_phone",errors,"#label_cell_phone","Cell Phone Number");
		errors = CheckforNull("#form_company_name",errors,"#label_company_name","Please enter Company Name");
		errors = CheckforNull("#form_address_1",errors,"#label_address_1","Please enter Street Address 1");
		errors = CheckforNull("#form_city",errors,"#label_city","Please enter City");
		errors = CheckforNull("#form_state",errors,"#label_state","Please enter State");
		errors = CheckforNullandNumber("#form_zip",errors,"#label_zipcode","Please enter Zip Code")
		errors = CheckforNull("#form_country",errors,"#label_country","Please enter Country");
		errors = CheckforNullandPhoneNumber("#form_phone",errors,"#label_phone","Compnay Phone Number");
		//errors = CheckforNullandPhoneNumber("#form_fax",errors,"#label_fax","Company Fax Number");
		errors = CheckforNullandSpace("#form_website",errors,"#label_website","Please enter comapny Website");
	
	}
	return errors;
}

function highlightErrorFields(result)
{
	for(var i=0;i<result.errors.length;i++)
	{
		if(result.errors[i].field=="userName")
			$("#label_username").attr("style",errorStyle);
		if(result.errors[i].field=="password")
		{
			$("#label_password").attr("style",errorStyle);
			$("#label_confirm").attr("style",errorStyle);
		}
		if(result.errors[i].field=="confirmPassword")
		{
			$("#label_password").attr("style",errorStyle);
			$("#label_confirm").attr("style",errorStyle);
		}
		if(result.errors[i].field=="securityQ1Value")
		{
			$("#label_q1").attr("style",errorStyle);
			$("#label_ans_q1").attr("style",errorStyle);
		}
		if(result.errors[i].field=="securityQ2Value")
		{
			$("#label_q2").attr("style",errorStyle);
			$("#label_ans_q2").attr("style",errorStyle);
		}
		if(result.errors[i].field=="firstName")
			$("#label_firstname").attr("style",errorStyle);
		if(result.errors[i].field=="lastName")
			$("#label_lastname").attr("style",errorStyle);
		if(result.errors[i].field=="street1")
			$("#label_address_1").attr("style",errorStyle);
		if(result.errors[i].field=="city")
			$("#label_city").attr("style",errorStyle);
		if(result.errors[i].field=="state")
			$("#label_state").attr("style",errorStyle);
		if(result.errors[i].field=="zip")
			$("#label_zipcode").attr("style",errorStyle);
		if(result.errors[i].field=="country")
			$("#label_country").attr("style",errorStyle);
		if(result.errors[i].field=="cell")
			$("#label_cell_phone").attr("style",errorStyle);
		if(result.errors[i].field=="workPhone")
			$("#label_work_phone").attr("style",errorStyle);
		if(result.errors[i].field=="workPhone1")
			$("#label_brand_work_phone").attr("style",errorStyle);
		if(result.errors[i].field=="langs")
			$("#label_languages").attr("style",errorStyle);
		if(result.errors[i].field=="skills")
			$("#label_skills").attr("style",errorStyle);
		if(result.errors[i].field=="fax")
			$("#label_fax").attr("style",errorStyle);
	}
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