// JavaScript Document
// JavaScript Document
var debugMode=true; //when this value set to true, it will show up a debug window on the left screen
var appPath="/webapp-1.0.0-BUILD-SNAPSHOT/";
var termsUrl ='terms';

//document event handler
$(document).ready(function()
{
	//button event==================================
	//save button on registration page
	$("#save").live("click",function(e)
	{
		var errors= checkInput(); //check user input
		var termsAccepted = $("#form_terms").val();
		if(errors.length > 0){	
			$("#errorContainer").html(errors.join("<br/>"));
		}else{
			$("#errorContainer").html("");
			submitRegForm();
			//loadPopup("thanks.html"); //show thank you popup
		}
	});
	//cancel button on registration page
	$("#cancel").live("click",function(e)
	{
		logging("cancel");
	});
	//Ok button in terms and conditions------------
	$("#register").live("click",function(e)
	{
		logging("ok");
		//show membership popup
		//loadPopup("membership.html");
		displayMembership(membershipUrl +"/" + $("#reg_userid").val());
	});
	//Hyperlink for read terms and conditions-------------
	$("#read_terms").click(function()
	{
		//loadPopup("terms.html"); //show terms
		displayLatestTermAndConditions(designerMemTerms); //show terms
	});
	
	
	$("#membership_ok").click(function()
	{
		closepopup();
	});
	
	//event handler when user click the Ok on terms and conditions panel-------
	$("#terms_ok").live("click",function(e)
	{
		logging("click OK in terms");
		//check the raio button value to decide the functionality of the button
		if($("#terms_agree").attr("checked")=="checked") //if user check agree, then go to verification panel
		{
			closepopup();
			//check the chechbox in registration page
			$("#form_terms").attr("checked","checked");
		
			// capture terms id
			var termId = $('input[name="termsId"]').val();
			$('#form_accepted_termsId').val(termId);

		}
		else if($("#terms_decline").attr("checked")=="checked") //if user decline the term, then close the panel
		{
			closepopup();
			//uncheck the chechbox in registration page
			$("#form_terms").removeAttr("checked");
		}
	});
	//Upload Image--------------------------------------------------------------
	$("#upload_image").live("click",function(e)
	{
		logging("Upload Image");
		loadPopup(appPath+"uploadPictures");
	});
	
	//disabling checkbox, as its working with spring <form:checkbox> in jsp. 
	$("#form_terms").attr("disabled","disabled");
});

function displayLatestTermAndConditions(address){
	
	//ajax method
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
				$("#termScrollbar").tinyscrollbar(); //initiate the scroll bar in terms panel !!!important
				//show the popup on the screen
				showpopup();
			}
		}
	});	
}

function displayMembership(address){
	
	//ajax method
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
			//No error, show terms and conditioins popup..
				$("#popupContainer").html(result); //set the result to the popupContainer
				$("#terms_ok").css({
							"background-color":"#333",
							"cursor":"default"
							});
				//$("#termScrollbar").tinyscrollbar(); //initiate the scroll bar in terms panel !!!important
				//show the popup on the screen
				showpopup();
		}
	});	
}
function submitRegForm(){
	var address = $('#form_reg_designer').attr("action");
	var fName = $('#form_first_name').val();
	var lName = $('#form_last_name').val();
	
	//ajax method
	$.ajax(
	{
		url:address,
		type: "POST",
		data:$('#form_reg_designer').serialize(),  
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
			/*if(result)
				alert(result);
			if(result.hasError)
				alert(result.hasError);*/
			if(result && result.hasError && result.hasError === true){
				$("#overlay").fadeOut("fast"); 
				var errorInfo = new Array();
				for(var i=0; i<result.errors.length ; i++){
					errorInfo.push(result.errors[i].defaultMessage);
				}
				$("#errorContainer").html(errorInfo.join("<br/>"));
				
			}else{
				
				$('#designer_name').text(fName + " " + lName);
				alert(result.userId);
				$('#reg_userid').val(result.userId);
				$("#popupContainer").html($('#verification_content').html()); //set the result to the pupCoopntainer
				$("#overlay").fadeOut("fast"); 
				//show the popup on the screen
				showpopup();		
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
		if($("#form_username").val()=="" || $("#form_username").val().search(" ")!=-1)
			//loadPopup("error.html","please enter Username");
			errors.push("please enter Username");
		if($("#form_password").val()=="" || $("#form_password").val().search(" ")!=-1)
			//loadPopup("error.html","please enter Password");
			errors.push("please enter Password");
		if($("#form_confirm").val()=="" || $("#form_confirm").val().search(" ")!=-1)
			//loadPopup("error.html","please enter Confirm Password");
			errors.push("please enter Confirm Password");
		if($("#form_password").val()!=$("#form_confirm").val())
			//loadPopup("error.html","Password and Confirm Password must be the same");
			errors.push("Password and Confirm Password must be the same");
		if($("#form_ans_q1").val()=="")
			//loadPopup("error.html","please enter answer for Security Question 1");
			errors.push("please enter answer for Security Question 1");
		if($("#form_ans_q2").val()=="")
			//loadPopup("error.html","please enter answer for Security Question 2");
			errors.push("please enter answer for Security Question 2");
		if($("#form_first_name").val()=="" || $("#form_first_name").val().search(" ")!=-1)
			//loadPopup("error.html","please enter First Name");
			errors.push("please enter First Name");
		if($("#form_last_name").val()=="" || $("#form_last_name").val().search(" ")!=-1)
			//loadPopup("error.html","please enter Last Name");
			errors.push("please enter Last Name");
		if($("#form_cell_phone").val()=="" || $("#form_cell_phone").val().search(" ")!=-1)
			//loadPopup("error.html","please enter Cell Phone Number");
			errors.push("please enter Cell Phone Number");
		if($("#form_address_1").val()=="")
			//loadPopup("error.html","please enter Street Address 1");
			errors.push("please enter Street Address 1");
		if($("#form_city").val()=="")
			//loadPopup("error.html","please enter City");
			errors.push("please enter City");
		if($("#form_country").val()=="")
			//loadPopup("error.html","please enter Country");
			errors.push("please enter Country");
		if($("#form_phone").val()=="")
			//loadPopup("error.html","please enter Phone Number");
			errors.push("please enter Phone Number");
		if($("#form_fax").val()=="")
			//loadPopup("error.html","please enter Fax Number");
			errors.push("please enter Fax Number");
		if($("#form_zipcode").val()=="" || $("#form_zipcode").val().search(" ")!=-1)
			//loadPopup("error.html","Please enter Zip Code");
			errors.push("Please enter Zip Code");
		if($("#form_work_phone").val()=="" || $("#form_work_phone").val().search(" ")!=-1)
			//loadPopup("error.html","Please enter Work Phone Number");
			errors.push("Please enter Work Phone Number");
		
	}
	else
	{
		//company page
		if($("#form_username").val()=="" || $("#form_username").val().search(" ")!=-1)
			errors.push("please enter Username");
		if($("#form_password").val()=="" || $("#form_password").val().search(" ")!=-1)
			errors.push("please enter Password");
		if($("#form_confirm").val()=="" || $("#form_confirm").val().search(" ")!=-1)
			errors.push("please enter Confirm Password");
		if($("#form_password").val()!=$("#form_confirm").val())
			errors.push("Password and Confirm Password must be the same");
		if($("#form_ans_q1").val()=="")
			errors.push("please enter answer for Security Question 1");
		if($("#form_ans_q2").val()=="")
			errors.push("please enter answer for Security Question 2");
		if($("#form_first_name").val()=="" || $("#form_first_name").val().search(" ")!=-1)
			errors.push("please enter First Name");
		if($("#form_last_name").val()=="" || $("#form_last_name").val().search(" ")!=-1)
			errors.push("please enter Last Name");
		if($("#form_cell_phone").val()=="" || $("#form_cell_phone").val().search(" ")!=-1)
			errors.push("please enter Cell Phone Number");
		if($("#form_address_1").val()=="")
			errors.push("please enter Street Address 1");
		if($("#form_city").val()=="")
			errors.push("please enter City");
		if($("#form_country").val()=="")
			errors.push("please enter Country");
		if($("#form_phone").val()=="")
			errors.push("please enter Phone Number");
		if($("#form_fax").val()=="")
			errors.push("please enter Fax Number");
		if($("#form_company_name").val()=="")
			errors.push("please enter Compay Name");
		if($("#form_website").val()=="")
			errors.push("please enter Website");
//		else
			//isCorrect=true;
	}
	return errors;
}