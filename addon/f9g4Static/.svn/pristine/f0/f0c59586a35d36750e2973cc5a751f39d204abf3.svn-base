var basicConfig = { 
	"debugMode":false, //set to true to enable debug panel
	"writeLogToConsole":false,
	"disableRightClick":false,
	"browserChecking":false,
	"mainboxSlideDuration":5000,
	"quotesSlideDuration":15000
};

var errorStyle="color:#FF0000";

$(document).ready(function() {
	$(document).on('click','#submit',function(e) {
		//remove previous high light fields
		$(".label").removeAttr("style");
		var errors= checkInput(); //check user input
		//var errors=new Array();
		var termsAccepted = $("#form_accepted_termsId");
		$('.submit-result').addClass('show-border');
		if(errors.length > 0) {	
			$('#submitResult').html("Please complete the following required fields:<br/>"+errors.join("<br/>"));
		}
		else
		{
			//check form_terms fields
			/*if(termsAccepted.val()==false || $('#regCheck').data('checked')==false || $('#regCheck').data('checked')==undefined) {
				$(".label").removeAttr("style");
				$('#submitResult').html("Please accept Terms and Conditions by checking the checkbox. Thank you.");
			}
			else*/
				submitRegForm();
		}
	});
	
	//disallow user to enter space in password field
	$(document).on("keydown",'input[type=password]',function(e) {
		if(e.which==32)
			return false;
	});
	
	//password complexity validation event
	$(document).on("keyup",'#form_password',function(e)
	{
		/*console.log("password keyup event");*/
		var result=checkStrength($('#form_password').val());
		$('#passwordRow').removeClass('hide');
		$('#result').html(result);
	});
	
	//education
	/*$(document).on('change','#form_education',function(e) {
		if($(this).val()=='-2') {
			//enable other filed
			$('#educationRow').removeClass('hide');
			$('#form_education_other').removeAttr('disabled').focus();
		}
		else {
			//disable other filed
			$('#educationRow').addClass('hide');
			$('#form_education_other').attr('disabled','disabled');
		}
	});*/
	
	//specialty
	/*$(document).on('change','#form_specialty',function(e) {
		if($(this).val()=='-2') {
			//enable other filed
			$('#specialtyRow').removeClass('hide');
			$('#form_specialty_other').removeAttr('disabled').focus();
		}
		else {
			//disable other filed
			$('#specialtyRow').addClass('hide');
			$('#form_specialty_other').attr('disabled','disabled');
		}
	});*/
	
	//username check
	$(document).on('keyup','#form_username',function(e) {
		//check the input is not empty and is the email format
		$('#usernameRow').removeClass('hide');
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
						$('#usernameCheckedMsg').css('color','blue').html('The email you provided is available');
					}
					else {
						$('#usernameChecked').removeClass('invalid').addClass('invalid');
						$('.username-check-result').removeClass('hide');
						$('#usernameCheckedMsg').css('color','#C30').html('The email you provided is already being used');
						
					}
				},
				error: function() {
					$('#usernameChecked').removeClass('loading');
					$('#usernameCheckedMsg').html('checking..');
				}
			});
		}
		else {
			$('#usernameChecked').removeClass('hide').removeClass('invalid').addClass('invalid');
			$('#usernameCheckedMsg').css('color','#C30').html('Invalid email address');
		}
	});
	$('#form_education').trigger('change');
	$('#form_specialty').trigger('change');
	
	$(document).on('focus','input, select',function(e) {
		var controller = $('.next-input-controller');
		var nextIndex=$(this).attr('tabindex')+1;
		if($(this).attr('skip-control')!=undefined)
			nextIndex+=parseInt($(this).attr('skip-control'));
		controller.attr('next-comp',nextIndex).removeClass('hide');
	});
	$(document).on('click','.next-input-controller',function(e) {
		var targetIndex=$(this).attr('next-comp');
		//check target input type
		$('*[tabindex='+targetIndex+']').focus();
	});
	$(document).on('click','#addOtherEducation',function(e) {
		addOtherToMS($(this),$('#form_education'));
	});
	$(document).on('click','#addOtherSpecialty',function(e) {
		addOtherToMS($(this),$('#form_specialty'));
	});
});

function addOtherToMS(obj,container){
	var $select = container,
		$input = obj.siblings('.ms-add-other-value'),
		value = $.trim($input.val()),
		$opt = $("<option />", {
			value: '0{'+value+'}',
			text: value,
			'data-text':value,
			'data-is-others':true
		});
	if (!value) {
	    $input.focus();
	    return;
	}
	$opt.prop("selected", true);
	$input.val("");
	//$select.children('option[value="-1"]').after($opt);
	$select.prepend($opt);
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
		var educations=$('#form_education option[data-is-others="true"]:selected'),
		specialty=$('#form_specialty option[data-is-others="true"]:selected'),
		serialData=new Array();
		//add others values
		for(var i=0;i<educations.length;i++) {
			//reset the option value to integer
			$(educations[i]).val(0);
			serialData.push('otherEducation='+encodeURI($(educations[i]).attr('data-text')));
		}
		for(var i=0;i<specialty.length;i++) {
			$(specialty[i]).val(0);
			serialData.push('otherSpecialty='+encodeURI($(specialty[i]).attr('data-text')));
		}
		formData=$("#form_reg_designer").serialize()+'&'+serialData.join('&');
		//formData=$('#form_reg_designer').serialize();
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
			$('#submitResult').html('please wait <img src="/images/spinner_small_wbg.gif" />');
		},
		error: function(xhr,status,error)
		{
			logging(this.url+" is "+error); //if there is error, close the overlay
			$("#overlay").fadeOut("fast"); //show the overlay when loading
		},
		success: function(result)
		{
			logging("loading "+this.url+" complete");
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
				$('#submitResult').html("Please enter data in the mandatory fields as highlighted in the screen and also displayed in the list:<br/>"+errorInfo.join("<br/>"));
			}
			else
			{	
				//var contextRoot='/'+location.pathname.split('/')[1]; //get context root
				var redirectTimer;
				if(isComp){
					//_gaq.push(['_trackPageview',contextRoot+'/company/register_success']);
					if(_gaq!=undefined)
						_gaq.push(['_trackEvent', 'registration', 'registered successfully from mobile', 'company: '+$('#form_username').val(), result.userId]);
					$('#submitResult').html("Thanks for registering, we will get back to you shortly.");
				}else{
					$('#designer_name').text(fName + " " + lName);
					logging("Register Success UserId="+result.userId);
					logging(result);
					if(result.userId!=undefined)
					{
						$('#reg_userid').val(result.userId);
						//assign to samples submission page
						//_gaq.push(['_trackPageview',contextRoot+'/designer/register_success']);
						if(_gaq!=undefined) {
							_gaq.push(['_set','hitCallback',function() {
								clearTimeout(redirectTimer);
								location.assign(registrationResult);
							}]);
							_gaq.push(['_trackEvent', 'registration', 'registered successfully from mobile', 'designer: '+$('#form_username').val(), result.userId]);
						}
						redirectTimer=setTimeout(function() {
							$('#submitResult').html("Registered successfully.");
							location.assign(registrationResult);
						},1000);
						//assign to different page
						//location.assign(membershipUrl +"?userId=" + result.userId);
					}
					else
					{
						$('#submitResult').html("One of our back end system is currently unavailable. Please contact us. <br /> Thank you.");
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
	
	/*if(href.search("designer")!=-1)
	{*/
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
		if($('#form_education').val()==-2 && $('#form_education_other').val().replace(/ /g,'')==='') {
			$('#label_education').attr("style",errorStyle);
			errors.push("Please enter your education detail.");
		}
		if($('#form_specialty').val()==-2 && $('#form_specialty_other').val().replace(/ /g,'')==='') {
			$('#label_specialty').attr("style",errorStyle);
			errors.push("Please enter your area of specialty detail.");
		}
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
		
	/*}
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
		errors = CheckforNullandNumber("#form_zip",errors,"#label_zipcode","Please enter Zip Code")
		errors = CheckforNull("#form_country",errors,"#label_country","Please enter Country");
		errors = CheckforNullandPhoneNumber("#form_phone",errors,"#label_phone","Company Phone Number");
		//errors = CheckforNullandPhoneNumber("#form_fax",errors,"#label_fax","Company Fax Number");
		errors = CheckforNullandSpace("#form_website",errors,"#label_website","Please enter Company Website");
	
	}*/
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