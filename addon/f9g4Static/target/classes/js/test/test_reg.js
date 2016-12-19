// JavaScript Document
var basicConfig = { 
	"debugMode":false, //set to true to enable debug panel
	"writeLogToConsole":false,
	"disableRightClick":false
};
var errorStyle="color:#FF0000";
var usernameValue="Please enter your valid email for your username"; //text value for the username textfield on the login panel
var passwordValue="Please enter your password"; //text value for the password textfield on the login panel
//bind the disabled button event
$(document).on("click",".button",function(e) {
	if($(this).attr('disabled')=="disabled" || $(this).attr('disabled')=="true" || $(this).attr('button-disabled')=="true") {
		logging("disable button event hooked!");
		e.stopImmediatePropagation(); //stop event bubble up to the document level.
	}
});
$(document).on("click",".checkbox",function(e) {
	if($(this).attr('disabled')=="disabled" || $(this).attr('disabled')=="true" || $(this).attr('button-disabled')=="true") {
		e.stopImmediatePropagation(); //stop event bubble up to the document level.
	}
});
//document event handler
$(document).ready(function()
{
	//button event==================================
	//save button on registration page
	$(document).on("click","#save",function(e)
	{
		//remove previous high light fields
		$(".label").removeAttr("style");
		var errors= checkInput(); //check user input
		//var errors=new Array();
		var termsAccepted = $("#form_terms");
		if(errors.length > 0)
		{	
			buildPopupMsg({
				"content":"Please complete the following required fields:<br/>"+errors.join("<br/>")
			});
		}
		else
		{
			//check form_terms fields
			if(termsAccepted.val()==false || $('#regCheck').data('checked')==false || $('#regCheck').data('checked')==undefined)
			{
				$(".label").removeAttr("style");
				buildPopupMsg({
					"content":"Please accept Terms and Conditions by checking the checkbox. Thank you."
				});
			}
			else
				submitRegForm();
		}
	});
	//cancel button on registration page
	$(document).on("click","#cancel",function(e)
	{
		logging("cancel");
		$("form")[0].reset();
		//reset to default avatar image
		$("#user_logo img").attr("src",'/images/avatar_default.jpg');
		$("#form_logo_image_url").val('/images/avatar_default.jpg');
		//reset username checking icon
		$('#usernameChecked').removeClass('invalid').addClass('hide');
	});
	//Ok button in terms and conditions------------
	$(document).on("click","#register",function(e)
	{
		logging("ok");
		//redirect to splash screen
		location.assign(loginPage);
	});
	//Hyperlink for read terms and conditions-------------
	$("#read_terms").click(function()
	{
		//ResgistrationTermsPath -> this loads cutomerregistrationpath for customers and designerregistrationpath for designers
		displayLatestTermAndConditions(ResgistrationTermsPath); //show terms
	});
	
	//Membership popup------------------------------------
	$("#membership_ok").click(function()
	{
		closePopup();
	});
	
	$(document).on("click",".reg_success_ok",function() //if user hit the X button on the popup panel, then close the popup.
	{
		var target="#popupContainer";
		var overlayTarget="#overlay";
		//show the effect to close the popup
		$(target).fadeOut("fast",function()
		{
//			//hide overlay
//			$(overlayTarget).fadeOut();
		});
		//reset popup
		$(".popup .notification").css("display","none");
		//reset style of popupContainer
		$(target).removeAttr("style");
		isOpened=false;
		location.assign(loginPage);
	});
	//event handler when user click the Ok on terms and conditions panel-------
	$(document).on("click","#terms_ok",function(e)
	{
		logging("click OK in terms");
		//check the raio button value to decide the functionality of the button
		if($("#terms_agree").attr("checked")=="checked") //if user check agree, then go to verification panel
		{
			// capture terms id
			var termId = $('input[name="termsId"]').val();
			closePopup();
			//check the chechbox in registration page
			$("#form_terms").val(true);
			$('#form_accepted_termsId').val(termId);
			$('#regCheck').addClass('checked');
			$('#regCheck').data('checked',true);
		}
		else if($("#terms_decline").attr("checked")=="checked") //if user decline the term, then close the panel
		{
			closePopup();
			//uncheck the chechbox in registration page
			$("#form_terms").val(false);
			$('#regCheck').removeClass('checked');
			$('#regCheck').data('checked',false);
		}
		else {
			closePopup();
		}
	});
	//Pay button in membership popup-------------------------------------------
	$(document).on("click","#pay",function(e)
	{
		logging("Pay click");
	});
	
	//Upload Image--------------------------------------------------------------
	$(document).on("click","#upload_image",function(e)
	{
		logging("Upload Image");
		buildUploadPopup({
			"url":uploadPicturesPath,
			"mode":"LOGO",
			"filetype":"ai",
			"previewArea":"user_logo"
		});
	});
	$(document).on("upload_finished","body",function(e)
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
		buildPopupMsg({
			"content":'<div style="color:#0000CC; font-size:16px; width:100%; text-align:center;">We are implementing our live chat module, please call us at 1-800-550-0802.</div>',
			"showOk":true,
			"title":"Live Chat"
		});
	});
	
	//disallow user to enter space in password field
	$(document).on("keydown",'input[type=password]',function(e) {
		if(e.which==32)
			return false;
	});
	
	//password complexity validation event
	$(document).on("keyup",'#newPwd',function()
	{
		$('#reset_password #result').html(checkStrength($('#newPwd').val(),'#reset_password #result'));
	});
	
	$(document).on("keyup",'#resetPassword',function()
	{
		$('#setupSeqPasswordFormPanel #result').html(checkStrength($('#resetPassword').val(),'#setupSeqPasswordFormPanel #result'));
	});
	
	//password complexity validation event
	$(document).on("keyup",'#form_password',function(e)
	{
		if(e.which!=32) {
			/*console.log("password keyup event");*/
			var result=checkStrength($('#form_password').val());
			$('#result').html(result);
			$('#tppwdresult').html(result);
			//trigger confirm password fields
			$('#form_confirm').trigger('keyup');
		}
	});
	
	//format the website url. If the user didn't put the http:// in front of the address, add it automatically.
	$("#form_website").change(function() 
	{
		 if (!/^http:\/\//.test(this.value)) 
		 {	 
	            this.value = "http://" + this.value;
		 }
	});
	$(document).on("submit","#form_membership_payment",function(e) {
		$("#form_membership_payment").prop("disabled",true);
		$("#membership_payment").prop("disabled",true);
		//apply the mask on the paynow button
		$('#paynowMask').css("z-index","10");
	});
	//phone formating
	$(document).on("keyup",".phoneChecking",function(e) {
		//TODO phone format
	})

	$(document).on("change","#temp_password_noused",function(e) {
		if(this.checked==true) {
			//reset the default value on security answer
			$("#form_ans_q1").val("Temp");
			$("#form_ans_q1").attr("readonly","true");
			$("#form_ans_q2").val("Temp");
			$("#form_ans_q2").attr("readonly","true");
		}
		else {
			$("#form_ans_q1").val("");
			$("#form_ans_q1").removeAttr("readonly");
			$("#form_ans_q2").val("");
			$("#form_ans_q2").removeAttr("readonly");
		}
	});
	//trigger the change event if the #temp_password is existed
	$("#temp_password_noused").trigger("change");
	
	//show invitation only popup
	$(document).on("click",".invitationOnly",function(e) {
		buildPopup({
			'url':invitationFormPath
		});
	});
	
	//
	$(document).on("click","#submitSeqPassword",function() {
		submitSeqPasswordForm();
	});
	
	//submit button on login panel button event====================================
	$("#submit").click(function()
	{	
		//if browser chacking is not passed, do not allow user to login.
		if(browserChecking())
		{
			if(checkUserInput()==true)	//check user input
			{
				doLogin();
			}
		}
	});
	
	//keyboard event
	$(document).on("keydown","#username, #password, #remember",function(e)
	{
		//when user press enter key
		if(e.which==13)
		{
			//if browser chacking is not passed, do not allow user to login.
			if(browserChecking())
			{
				if(checkUserInput()==true)	//check user input
				{
					doLogin();
				}
			}	
		}
	});
	
	//Show login panel
	$(document).on("click","#showLogin",function(e) {
		$("#loginPanel").css("display","block");
		//retrieve cookie value
		var cookieVal=getCookie('RememberMef4g');
		if(cookieVal!='') {
			$('#username').val(cookieVal);
			$('#remember').attr('checked','checked');
		}
		else {
			$('#remember').removeAttr('checked');
		}
		setFocus();
	});
	
	//close login panel
	$(document).on("click","#loginPanel .overlay",function(e) {
		$("#loginPanel").css("display","none");
	});
	$(document).on("click","#closeLoginPanel a",function(e) {
		$("#loginPanel").css("display","none");
	});
	
	//confirm password checking
	/*$(document).on('keyup','#form_confirm',function(e) {
		pwdChecker($('#form_password'),$('#form_confirm'),$('#confirmPwdHint'));
	});*/
	
	//username check
	$(document).on('keyup','#form_username',function(e) {
		//check the input is not empty and is the email format
		if($(this).val().replace(/ /g,"")!=="" && $(this).val().search(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/)!=-1) {
			$.ajax({
				url:usernameCheckPath+"?username="+$(this).val(),
				type:"GET",
				beforeSend: function() {
					$('#usernameChecked').addClass('loading');
				},
				success: function (result) {
					$('#usernameChecked').removeClass('loading');
					//remove hide css for showing up the check icon
					$('#usernameChecked').removeClass('hide');
					if(result.isAvailable===true) {
						$('#usernameChecked').removeClass('invalid');
						$('.username-check-result').removeClass('hide').addClass('hide');
					}
					else {
						$('#usernameChecked').removeClass('invalid').addClass('invalid');
						$('.username-check-result').removeClass('hide');
						$('#usernameCheckedMsg').css('color','#C30').html('The email you provided is already being used');
						
					}
				},
				error: function() {
					$('#usernameChecked').removeClass('loading');
					$('#usernameChecked').html('checking..');
				}
			});
		}
		else {
			$('.username-check-result').removeClass('hide');
			$('#usernameCheckedMsg').css('color','#C30').html('Invalid email address');
		}
	});
	
	//checkbox
	$(document).on('click','#regCheck',function(e) {
		if($(this).data('checked')==undefined || $(this).data('checked')==false) {
			$(this).addClass('checked');
			$('#regCheck').data('checked',true);
			$('#form_terms').val(true);
		}
		else {
			$(this).removeClass('checked');
			$('#regCheck').data('checked',false);
			$('#form_terms').val(false);
		}
	});
	
	$(document).on('keyup','#regCheck',function(e) {
		if(e.which==32)
			$(this).trigger('click');
	});
	
	//Handler the terms & conditions when login
	$(document).on('click','#terms_ok_login',function(e) {
		logging("vbf");
		logging($("#terms_lg").action);
		if($("#terms_agree_login").attr("checked")=="checked")
			$("#terms_lg").submit();
		else
			closePopup();
	});
	
	//qtip init
	$('.tip-left').qtip({
		position: {
			my:'top left',
			at:'bottom right',
			adjust: {
				screen:true,
				mouse:false
			}
		},
		style: {
			classes: 'qtip-light qtip-shadow'
		},
		show: {
			event: 'click focus'
		},
		hide: {
			event: 'unfocus'
		}
	});
	$('.tip-right').qtip({
		position: {
			my:'top right',
			at:'bottom left',
			adjust: {
				screen:true,
				mouse:false
			}
		},
		style: {
			classes: 'qtip-light qtip-shadow'
		},
		show: {
			event: 'click focus'
		},
		hide: {
			event: 'unfocus'
		}
	});
	$(document).on('keydown','.tip-left,.tip-right,.tip-pwd',function(e) {
		if(e.which==9) {
			$(this).trigger('unfocus');
		}	
	});
	
	//Forgot password panel related methods=========================
	//forget link event to open popup
	$("#link_forget").click(function()
	{		
		buildPopup({
			"url":forgotPwdUrl
		});	//load page using ajax
	});
	
	$(document).on('click','#gotoSecurity',function(e) {
		loadSecurityPanel();
	});
	
	$(document).on('click','#gotoResult',function(e) {
		submitSequrityQuestions();
	});
	
	$(document).on('click','#resetPwd',function(e) {
		//resetPassword
		resetPassword();
	});
	
	//To close forgot password popup.
	$(document).on('click','#close',function(e) {
		closePopup();
	});
	
	//enter key event on forget password popup
	$(document).on("keydown","#email",function(e)
	{
		//when user press enter key
		if(e.which==13)
		{
			loadSecurityPanel();
		}
	});
	$(document).on("keydown","#q1_ans",function(e)
	{
		//when user press enter key
		if(e.which==13)
		{
			submitSequrityQuestions();
		}
	});
	$(document).on("keydown","#q2_ans",function(e)
	{
		//when user press enter key
		if(e.which==13)
		{
			submitSequrityQuestions();
		}
	});
	$(document).on("keydown","#confirmPwd",function(e)
	{
		//when user press enter key
		if(e.which==13)
		{
			resetPassword();
		}
	});
	$(document).on("keydown","#close",function(e)
	{
		//when user press enter key
		if(e.which==13)
		{
			logging("close");
			closePopup();
		}	
	});
	
	//upload additional document
	/*$(document).on('click','#upload_doc',function(e) {
		buildUploadPopup({
			"url":uploadPicturesPath,
			"mode":"files",
			"filetype":"files",
			"previewArea":"",
			"onUploadSuccess":function(result) {
				$('#file_result').html(result.original_filename+'<span class="added-file-delete"></span>').addClass('added-file');
				$('#adoc_oname').val(result.original_filename);
				$('#adoc_type').val(result.filename_ext);
				$('#adoc_iname').val(result.filename);
			}
		});
	});
	$(document).on('click','.added-file-delete',function(e) {
		$('#file_result').html("").removeClass('added-file');
		$('#adoc_oname').val("");
		$('#adoc_type').val("");
		$('#adoc_iname').val("");
	});*/
	
	//contact info popup
	$(document).on('click','#showContactInfo',function() {
		buildPopupMsg({
			"content": '<img src="/images/splash/contact_info.png"/>',
			"title": "CONTACT INFO",
			"showOk": true,
			"closeByOverlay": true,
			"effect":true
		});
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
	showPopup({
		"container":"#error"
	}); //show the popup which div is id=error
}

function displayLatestTermAndConditions(address)
{
	buildPopup({
		"url": address
	},function() {
		$("#termScrollbar").tinyscrollbar(); //initiate the scroll bar in terms panel !!!important
		$(".anchor").each(function(index) {
			$(".rightArea .block:nth-child("+(index+1)+")").animate({top:$(this).position().top});
		});	
	});
	
	//ajax method
	/*$.ajax(
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
				showPopup({},function() {
					$(".anchor").each(function(index) {
						$(".rightArea .block:nth-child("+(index+1)+")").animate({top:$(this).position().top});
					});
				});
			}
		},
		complete: function(xhr,status)
		{
			$("#termScrollbar").tinyscrollbar(); //initiate the scroll bar in terms panel !!!important
		}
	});	*/
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
			showPopup();
		}
	});
}
function submitRegForm()
{
	logging("designer=>"+$('#form_reg_designer').length);
	logging("company=>"+$('#form_reg_company').length);
	//Get timezone offset
	var timezoneOffset = new Date();
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
		data: formData+"&timezoneOffset="+timezoneOffset.getTimezoneOffset(),  
		//
		beforeSend: function()
		{
			logging("loading "+address);
			//set the opactity value if the browser is IE 8
			if ( $.browser.msie && ($.browser.version == "8.0" || $.browser.version == "7.0")) 
			{
				$('#overlay').css('filter', 'alpha(opacity=70)');
			}
			//$("#overlay").fadeIn("fast"); //show the overlay when loading
			buildPopupMsg({
				"content": '<span style="color:blue;">Please wait...<span><br /><img src="/images/spinner_small.gif" style="margin-top:30px;"/>',
				"title": "Please Wait",
				"showOk": false,
				"closeByOverlay": false,
				"effect":false
			});
		},
		error: function(xhr,status,error)
		{
			logging(this.url+" is "+error); //if there is error, close the overlay
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
				buildPopupMsg({
					"content":"Please enter data in the mandatory fields as highlighted in the screen and also displayed in the list:<br/>"+errorInfo.join("<br/>"),
					"showOk":true
				});
			}
			else
			{	
				//var contextRoot='/'+location.pathname.split('/')[1]; //get context root
				var redirectTimer;
				if(isComp){
					//_gaq.push(['_trackPageview',contextRoot+'/company/register_success']);
					_gaq.push(['_trackEvent', 'registration', 'registered successfully', 'company: '+$('#form_username').val(), result.userId]);
					showCompRegMsg("Thanks for registering, we will get back to you shortly.",true, "Registration ", null);
				}else{
					$('#designer_name').text(fName + " " + lName);
					logging("Register Success UserId="+result.userId);
					logging(result);
					if(result.userId!=undefined)
					{
						$('#reg_userid').val(result.userId);
						//assign to samples submission page
						//_gaq.push(['_trackPageview',contextRoot+'/designer/register_success']);
						_gaq.push(['_set','hitCallback',function() {
							clearTimeout(redirectTimer);
							location.assign(submitSamplesPath +"?userId=" + result.userId);
						}]);
						_gaq.push(['_trackEvent', 'registration', 'registered successfully', 'designer: '+$('#form_username').val(), result.userId]);
						redirectTimer=setTimeout(function() {
							location.assign(submitSamplesPath +"?userId=" + result.userId);
						},1000);
						//assign to different page
						//location.assign(membershipUrl +"?userId=" + result.userId);
					}
					else
					{
						buildPopupMsg({
							"content":"One of our back end system is currently unavailable. Please contact us. <br /> Thank you.",
							"showOk":true
						});
					}
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
		errors = CheckforNullandSpace("#form_username",errors,"#label_username","Please enter E-mail ID");
        errors = CheckforNull("#form_password",errors,"#label_password","Please enter Password");
        errors = CheckforContainSpace("#form_password",errors,"#label_password","Please check that there are no spaces in Password");
        errors = CheckforNull("#form_confirm" ,errors,"#label_confirm" ,"Please enter Confirm Password");
        errors = CheckforContainSpace("#form_confirm" ,errors,"#label_confirm" ,"Please check that there are no spaces in Confirm Password");
	
		if($("#form_password").val()!=$("#form_confirm").val())
		{
			//loadPopup("error.html","Password and Confirm Password must be the same");
			errors.push("Password and Confirm Password must be the same");
			$("#label_password").attr("style",errorStyle);
			$("#label_confirm").attr("style",errorStyle);
		}
		//errors = CheckforNull("#form_ans_q1",errors,"#label_ans_q1","Please enter answer for Security Question 1");
		//errors = CheckforNull("#form_ans_q2",errors,"#label_ans_q2","Please enter answer for Security Question 2");
		errors = CheckforNull("#form_first_name",errors,"#label_firstname","Please enter First Name");
		errors = CheckforNull("#form_last_name" ,errors,"#label_lastname" ,"Please enter Last Name");
		//errors = CheckforNull("#form_address_1",errors,"#label_address_1","Please enter Street Address 1");
		//errors = CheckforNull("#form_city",errors,"#label_city","Please enter City");
		//errors = CheckforNull("#form_state",errors,"#label_state","Please enter State");
		//errors = CheckforNullandNumber("#form_zipcode",errors,"#label_zipcode","Please enter Zip Code")
		//errors = CheckforNull("#form_country",errors,"#label_country","Please enter Country");
		//errors = CheckforNullandPhoneNumber("#form_cell_phone",errors,"#label_cell_phone","Mobile Phone Number");
		//errors = CheckforNullinSelect("#form_languages",errors,"#label_languages","Please select at least 1 language");
		//errors = CheckforNull("#form_company_name",errors,"#label_company_name","Please enter Company Name");
		//errors = CheckforNullandPhoneNumber("#form_brand_work_phone",errors,"#label_brand_work_phone","Brand Work Phone Number");
		//errors = CheckforNullandPhoneNumber("#form_fax",errors,"#label_fax","Fax Number");
		//errors = CheckforNullinSelect("#form_skills",errors,"#label_skills","Please select at least 1 skill");
		
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
		errors = CheckforNullandPhoneNumber("#form_cell_phone",errors,"#label_cell_phone","Mobile Phone Number");
		errors = CheckforNull("#form_company_name",errors,"#label_company_name","Please enter Company Name");
		errors = CheckforNull("#form_address_1",errors,"#label_address_1","Please enter Street Address 1");
		errors = CheckforNull("#form_city",errors,"#label_city","Please enter City");
		errors = CheckforNull("#form_state",errors,"#label_state","Please enter State");
		errors = CheckforNull("#form_zip",errors,"#label_zipcode","Please enter Zip Code")
		errors = CheckforNull("#form_country",errors,"#label_country","Please enter Country");
		errors = CheckforNullandPhoneNumber("#form_phone",errors,"#label_phone","Company Phone Number");
		//errors = CheckforNullandPhoneNumber("#form_fax",errors,"#label_fax","Company Fax Number");
		errors = CheckforNullandSpace("#form_website",errors,"#label_website","Please enter Company Website");
	
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
function checkStrength(password,label)
{
	if(label==undefined)
		label='#result';
	if(password==undefined)
		password=document.getElementById("#form_password").val;
	//initial strength
    var strength = 0;
    var requirements=new Array();
    requirements[0]=false; //length
    requirements[1]=false; //Contain capital
    requirements[2]=false; //Contain number
    requirements[3]=false; //Contain special character
    
	
    //if the password length is less than 6, return message.
    if (password.length < 8) 
    { 
		$(label).removeClass();
		$(label).addClass('short');
		requirements[0]=false;
		return 'Password should be at least 8 characters long';
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
		$(label).removeClass();
		$(label).addClass('weak');
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
		$(label).removeClass();
		$(label).addClass('good');
		return 'Good';		
	} 
	else 
	{
		$(label).removeClass();
		$(label).addClass('strong');
		return 'Strong';
	}
}

//debug function, continue to record the data
function logging(data,color)
{
	if(color==undefined)
		color="#000";
	if(basicConfig.debugMode)
	{
		$("#debug").css("display","block");
		if(data==undefined || data=="")
			$("#debug").append("Undefined or blank <br />");
		$("#debug").append('<span style="color:'+color+'">'+data+'</span><br />');
		if(basicConfig.writeLogToConsole)
			console.log(data);
		$("#debug").scrollTop($("#debug")[0].scrollHeight);
	}
}

function submitSeqPasswordForm()
{
	//user input checking
	var errors = new Array();//reset css
	$('#label_resetPassword').removeAttr('style');
	$('#label_confirmPassword').removeAttr('style');
	$('#label_ans_q1').removeAttr('style');
	$('#label_ans_q2').removeAttr('style');
	if($('#form_ans_q1').length > 0)
		errors = CheckforNull("#form_ans_q1",errors,"#label_ans_q1","Please enter answer for Security Question 1");
	if($('#form_ans_q2').length > 0)
		errors = CheckforNull("#form_ans_q2",errors,"#label_ans_q2","Please enter answer for Security Question 2");
	if($('#resetPassword').length > 0) {
		 errors = CheckforNull("#resetPassword",errors,"#label_resetPassword","Please enter New Password");
		 errors = CheckforContainSpace("#resetPassword",errors,"#label_resetPassword","Please check that there are no spaces in New Password");
	}
	if($('#confirmPassword').length > 0) {
		errors = CheckforNull("#confirmPassword" ,errors,"#label_confirmPassword" ,"Please enter Confirm Password");
		errors = CheckforContainSpace("#confirmPassword" ,errors,"#label_confirmPassword" ,"Please check that there are no spaces in Confirm Password");
	}
    
	if(errors.length>0)
	{
		var errorInfo = new Array();
		for(var i=0; i<errors.length ; i++){
			errorInfo.push(errors[i]);
		}
		buildPopupMsg({
			"title":"Information <span style=\"#C30\">!</span>",
			"content":"Please enter data in the mandatory fields as highlighted in the screen and also displayed in the list:<br/>"+errorInfo.join("<br/>"),
			"showOk":true
		});
	}	
	else
	{
		$.ajax({
			url:$("#seqPasswordForm").attr("action"),
			type:"POST",
			data:$("#seqPasswordForm").serialize(),
			beforeSend: function() {
				buildPopupMsg({
					"content": '<span style="color:blue;">Please wait...<span><br /><img src="/images/spinner_small.gif" style="margin-top:30px;"/>',
					"title": "Please Wait",
					"showOk": false,
					"closeByOverlay": false,
					"effect":false
				});
			},
			success: function (result) {
				if(result.hasError){
					var errorInfo = new Array();
					for(var i=0; i<result.errors.length ; i++)
					{
						errorInfo.push(result.errors[i].defaultMessage);
						//helight area
						logging("Error field=>"+result.errors[i].field);
					}
					//hightlight error fields
					//highlightErrorFields(result);
					$("#overlay").fadeOut("fast"); //show the overlay when loading
					buildPopupMsg({
						"content":errorInfo.join("<br/>"),
						"showOk":true
					});
				}
				else {
					var content;
					if(result.setupPwd || result.setupPwd==undefined) {
						content='Password is updated successfully.<br /> Please use the new password to login. Thank you.';
						$('#loginPanel #password').val(''); //remove the old password value in login panel
					}
					else {
						content='Your security setting eastblished successfully.<br /> Thank you.';
					}
					buildPopupMsg({
						"content": '<span style="color:blue;">'+content+'<span>',
						"title": "Update successfully",
						"showOk": true,
						"closeByOverlay": true,
						"effect":true,
						"onOk":function () {
							closePopup("#popupContainer","#overlay");
							closePopupMsg();
						}
					});
				}
			},
			error: function() {
				buildPopupMsg({
					"content":"Our service is not available, please submit again. Thanks.",
					"showOk":true
				});
			}
		});
	}
}

//set focus on username or password field
function setFocus()
{
	//focus on username field
	setTimeout(function () 
	{
		if($('#username').val()!='')
			$('#password').focus();
		else
			$('#username').focus();
	}, 100);
	if($('#username').val()!='')
	{
		$("#password").focus(function(){
			// Select input field contents
			this.select();
		});
	}
	else
	{
		$("#username").focus(function(){
			// Select input field contents
			this.select();
		});
	}
}

function browserChecking()
{
	var isPassedBrowserChecking=true;
	if(basicConfig.browserChecking)
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
				buildPopupMsg({
					"content":browserCheckingMsg,
					"showOk":true,
					"title":"Browser Checking Warning",
					"showOverlay":true
				});
				isPassedBrowserChecking=false;
			}
			else if(browserVersion<=7)
			{
				browserCheckingMsg="We detect your browser is IE "+ browserVersion +" or lower. We support IE 8 and above. Thank you.";
				buildPopupMsg({
					"content":browserCheckingMsg,
					"showOk":true,
					"title":"Browser Checking Warning",
					"showOverlay":true
				});
				isPassedBrowserChecking=false;
			}
			else if(documentVersion<=7)
			{
				browserCheckingMsg="We detect the document mode of your browser is IE "+ browserVersion +" or lower. We support the document mode of IE 8 and above. Thank you.";
				buildPopupMsg({
					"content":browserCheckingMsg,
					"showOk":true,
					"title":"Browser Checking Warning",
					"showOverlay":true
				});
				isPassedBrowserChecking=false;
			}
		}
	}
	return isPassedBrowserChecking;
}

//check user input on login panel----------------------------------------------
function checkUserInput()
{
	var isCorrect=true;
	//if the input is blank, default value, or contains any space, regard it as a invalid input
	if($("#username").val()=="" || $("#username").val()==usernameValue || $("#username").val().search(" ")!=-1)
	{
		buildPopupMsg({
			"content":usernameValue,
			"title":"Username can not be empty",
			"onShow": function () {
				setTimeout(function () {
					$('#error_button_ok').focus();
				}, 100);
			}
		});
		isCorrect=false;
	}
	else if($("#password").val()=="" || $("#password").val()==passwordValue)
	{
		buildPopupMsg({
			"content":passwordValue,
			"title":"Password can not be empty",
			"onShow": function () {
				setTimeout(function () {
					$('#error_button_ok').focus();
				}, 100);
			}
		});
		isCorrect=false;
	}
	else if ($("#password").val().search(/\s/g)!=-1) {
		buildPopupMsg({
			"content":'Please check that there are no spaces in your password',
			"title":"No spaces in password",
			"onShow": function () {
				setTimeout(function () {
					$('#error_button_ok').focus();
				}, 100);
			}
		});
		isCorrect=false;
	}
	return isCorrect;
}

function doLogin(){
	var loginFrom = $('#form_login');
	var address = loginFrom.attr("action"); 
	logging(loginFrom.serialize());
	//Get timezone offset
	var timezoneOffset = new Date();
	//ajax method
	$.ajax({
		url:address,
		type: "POST",
		data:loginFrom.serialize()+"&timezoneOffset="+timezoneOffset.getTimezoneOffset(),
		//
		beforeSend: function()
		{
			buildPopupMsg({
				"content": '<span style="color:blue;">Please wait, we will log you in....<span><br /><img src="/images/spinner_small.gif" style="margin-top:30px;"/>',
				"title": "Please Wait",
				"showOk": false,
				"closeByOverlay": false,
				"effect":false
			});
			/*logging("loading "+address);
			if ( $.browser.msie && ($.browser.version == "8.0" || $.browser.version == "7.0")) //show the overlay when loading
			{
				$('#overlay').css('filter', 'alpha(opacity=70)');
			}
			$("#overlay").fadeIn("fast");*/
		},
		error: function(xhr,status,error)
		{
			logging(this.url+" is "+error); //if there is arrow, close the overlay
			$("#overlay").fadeOut("fast"); //show the overlay when loading
		},
		success: function(result)
		{
			logging("loading "+this.url+"complete");
			if(result.hasError==undefined) {
				$("#overlay").fadeOut(); //show the overlay when loading
				buildPopupMsg({
					"title":"Information <span style=\"#C30\">!</span>",
					"content":"Sorry, our service is not available.<br />Please try again. Thank you.",
					"showOk":true
				});
			}
			else {
				if(result && result.hasError ){
					//TODO how to show errors...
					//$("#overlay").fadeOut("fast"); 
					var errorInfo = new Array();
					for(var i=0; i<result.errors.length ; i++){
						if(result.errors[i].code=='validateUser.auth.failed')
							$('#loginPanel #password').val(''); //remove the old password value in login panel
						errorInfo.push(result.errors[i].defaultMessage);
					}
					//$("#popupContainer").html(errorInfo.join("<br/>"));
					$("#overlay").fadeOut(); //show the overlay when loading
					buildPopupMsg({
						"title":"Information <span style=\"#C30\">!</span>",
						"content":errorInfo.join("<br/>"),
						"showOk":true
					});
				}
				else
				{
					var redirectTimer;
					//var contextRoot='/'+location.pathname.split('/')[1]; //get context root
					if(result.termsExpired === true && result.membershipExpired === true)
					{
						//Gotta Desgin an alternate flow ! So that both con be done
						logging("Do nothing");
					}
					
					if(result.needSetupSeqPassword === true) {
						_gaq.push(['_trackEvent', 'login', 'setup security settings', 'setup security settings']); //push record to google analytics
						closePopupMsg();
						buildPopup({
							'url':setupSeqPasswordPath
						});
					}
					else if(result.needSetupSeq === true) {
						closePopupMsg();
						buildPopup({
							'url':setupSeqPasswordPath+'?setupSeq=true&setupPwd=false'
						});
					}
					else if(result.needSamples === true) {
						_gaq.push(['_set','hitCallback',function() {
							clearTimeout(redirectTimer);
							location.assign(submitSamplesPath+"?userId="+result.userId); //redirect to the samples page
						}]);
						_gaq.push(['_trackEvent', 'login', 'examples required', 'examples required']); //push record to google analytics
						//redirect to the samples page.
						redirectTimer=setTimeout(function() {
							location.assign(submitSamplesPath+"?userId="+result.userId); //redirect to the samples page
						},1000);
						//location.assign(submitSamplesPath+"?userId="+result.userId);
					}
					else if(result.termsExpired === true ) {
						_gaq.push(['_trackEvent', 'login', 'terms and conditions expired', 'terms and conditions expired']); //push record to google analytics
						closePopupMsg();
						displayTermAndConditions(result.termsId);
					}
					else if(result.membershipExpired === true )
					{
						_gaq.push(['_set','hitCallback',function() {
							clearTimeout(redirectTimer);
							location.assign(updateMembershipPath+"?userId="+result.userId);
						}]);
						_gaq.push(['_trackEvent', 'login', 'membership expired', 'membership expired']); //push record to google analytics
						//redirect
						redirectTimer=setTimeout(function() {
							location.assign(updateMembershipPath+"?userId="+result.userId);
						},1000);
					}
					else 
					{
						_gaq.push(['_set','hitCallback',function() {
							clearTimeout(redirectTimer);
							$(location).attr('href',redirectUrl);
						}]);
						_gaq.push(['_trackEvent', 'login', 'login to user console', 'login to user console']); //push record to google analytics
						//save hashed login id in the sessionStorage
						//sessionStorage.LI=result.loginId;
						//sessionStorage.LUUI=result.loginUUId;
						var redirectUrl = consoleHomeUrl;
						//redirect
						redirectTimer=setTimeout(function() {
							$(location).attr('href',redirectUrl);
						},1000);
					}
				}
			}		
		}
	});	
}

function pwdChecker(pwd,confirmPwd,container)
{
	if(pwd.val().replace(/ /g,'')==='' && confirmPwd.val().replace(/ /g,'')==='') {
		container.removeClass('good');
		container.html('Should match your password');
	}
	else if(pwd.val()===confirmPwd.val()) {
		container.addClass('good');
		container.html('Matched');
	}
	else {
		container.removeClass('good');
		container.html('Not matched');
	}
}

function displayTermAndConditions (termsId) {
	//ajax method
	var address =  termsUrl + "?termId=" + termsId;
	$.ajax({
		url:address,
		type: "GET",
		//
		beforeSend: function()
		{
			logging("loading "+address);
			if ( $.browser.msie && ($.browser.version == "8.0" || $.browser.version == "7.0")) //show the overlay when loading
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
				showPopup({},function() {
					$("#termScrollbar").tinyscrollbar();
					$(".anchor").each(function(index) {
						$(".rightArea .block:nth-child("+(index+1)+")").animate({top:$(this).position().top});
					});
				});
			}
			else
			{
				//error..
				//TODO .. if some error while loading t and c what should we do???
				//thinking of redirect to console home..
				$(location).attr('href',consoleHomeUrl);
			}
		}
	});	
}

//Load subpanelof forget password 
function loadSecurityPanel() {
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
	}
}

function loadSecurityQuestionsData(){
	var address = securityQuestionsUrl + "?userName=" + $("#email").val(); 
	$.ajax({
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
			if(result)
			{
				logging("result.hasError ->"+result.hasError);
				if(result.hasError===true)
				{
					if(result.noSeqSettings) {
						//Show error without security settings.
						$("#session_forget").fadeOut(function() {
							$('#reset_temp_password_failed').fadeIn();
						});
					}
					else {
						//Show error with security settings.
						$("#nofify_email").html("Email address entered is invalid. Please try again."); //update the text on the notification div
						$("#nofify_email").fadeIn();
					}
				}
				else
				{
					if(result.noSeqSettings) {
						//no security setting for the user, so we setup the temp password and sent the email to the user.
						$("#session_forget").fadeOut(function() {
							$('#reset_temp_password').fadeIn();
						});
					}
					else {
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
			}
			//hide the current session and shows the next session		  
		}
	});
}

function submitSequrityQuestions() {
	var address = $('#forgotPwd').attr("action"); 
	logging("SUBMIT SEQ Q=>"+address);
	$.ajax({
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

function resetPassword() {
	var address = $('#reset_password').attr("action");
	//check reset passowrd input
	var errors=new Array();
	$('#label_new_pwd').removeAttr('style');
	$('#label_confirm_pwd').removeAttr('style');
	errors = CheckforNull('#newPwd',errors,'#label_new_pwd','New Password can not be empty.');
	errors = CheckforContainSpace('#newPwd',errors,'#label_new_pwd','Please check that there are no spaces in New Password.');
	errors = CheckforNull('#confirmPwd',errors,'#label_confirm_pwd','Confirm Password can not be empty.');
	errors = CheckforContainSpace('#confirmPwd',errors,'#label_confirm_pwd','Please check that there are no spaces in Confirm Password.');
	if(errors.length > 0) {
		$('#notify_passw_mismatch').css('color','#000000').show().html(errors.join('<br />'));
	}
	else {
		$('#notify_passw_mismatch').removeAttr('style').html('');
		$.ajax({
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
						$('#loginPanel #password').val(''); //remove the old password value in login panel
					});	
				}else{
						$("#notify_passw_mismatch").html("Your passwords do not match. Please try again.");  //show up the next session
						$("#notify_passw_mismatch").fadeIn();
				}
			}
		});
	}
}

function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for(var i=0; i<ca.length; i++)  {
		var c = ca[i].trim();
		if (c.indexOf(name)==0) 
			return c.substring(name.length,c.length).replace(/"/g,'');
	}
	return "";
}