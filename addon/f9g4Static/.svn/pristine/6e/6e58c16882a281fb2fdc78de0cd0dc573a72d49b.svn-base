//Get timezone offset
var timezoneOffset = new Date();
checkUploadIfComplete();
if(jQuery.browser.mobile) {
	buildPopupMsg({
		"content": '<span style="color:#C30; font-size:1.5em;">Please use desktop/laptop to submit the example. Thank you.</span>',
		"title": "NOTIFICATION",
		"showOk": true,
		"closeByOverlay": false,
		"effect":false,
		"onOk":function() { location.href="/";},
		"onClose":function() { location.href="/";}
	});
}
//qtip init
$('.preimg-q').qtip({
	position: {
		my:'left center',
		at:'right center',
		adjust: {
			screen:true,
			mouse:false
		}
	},
	style: {
		classes: 'qtip-light qtip-shadow'
	}
});
//initialize uploadify plugin
$('#uploadify1, #uploadify2, #uploadify3').uploadify(
{
 	'swf': '/js/jquery/uploadify/uploadify.swf',
 	'uploader': uploaderPath+"?mode=BOARD&filetype=ai",
 	'successTimeout':480,
 	'multi': false,
 	'auto' : true,
 	'fileTypeDesc': 'JPG Files',
 	'fileTypeExts' : '*.ai; *.pdf; *.jpg; *.jpeg',
 	"buttonText": 'Select Files',
 	'onCancel': function() {
 		var roleId = $(this)[0].original.attr('role');
 		//$('.uploadify').uploadify('disable', false);
 		$('.sample-item-preview[role="'+roleId+'"] .preimg').html("");
 		//add the image to preview section back if user cancel uploading process and the filename_100 has value
 		if($('.filename_100[role="'+roleId+'"]').val()!='')
 			$('.sample-item-preview[role="'+roleId+'"] .preimg').html('<i></i><img src="/100x100/'+$('.filename_100[role="'+roleId+'"]').val()+'" />');
 	},
 	'onDialogOpen': function() {
 		var roleId = $(this)[0].original.attr('role');
 		//$('.uploadify').uploadify('disable', true);
 		//delete the previous dialog if existed
 		$('.sample-item-upload[role="'+roleId+'"] .uploadify-queue-item').remove();
 		$('.resubmit[role="'+roleId+'"]').remove();
 	},
 	'onDialogClose'  : function(queueData) {
 		//$('.uploadify').uploadify('disable', false);
    },
 	'onUploadProgress':function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
 		var roleId = $(this)[0].original.attr('role');
 		$(".sample-item-preview[role='"+roleId+"'] a").hide(); //hide the question mark image.
 		//remove the previous image
 		$('.sample-item-preview[role="'+roleId+'"] .preimg').html("");
 		//$('#uploadify'+roleId).uploadify('disable', true);
 		//$('.uploadify').uploadify('disable', true);
 		if(totalBytesUploaded >= totalBytesTotal) {
 			$(".sample-item-preview[role='"+roleId+"']").addClass('loading');
 		}
 	},
 	'onUploadError': function(file, errorCode, errorMsg, errorString) {
 		var roleId = $(this)[0].original.attr('role');
 		logging('The file ' + file.name + ' could not be uploaded: ' + errorString);
 		$(".sample-item-preview[role='"+roleId+"']").removeClass('loading');
 		//$('#uploadify'+roleId).uploadify('disable', true);
 		//$('.uploadify').uploadify('disable', false);
 		 //place the value to the form
        $(".filestatus[role='"+roleId+"']").val(-1);
 	},
 	'onUploadComplete' : function(file) {
 		var roleId = $(this)[0].original.attr('role');
 		logging('The file ' + file.name + ' finished processing.');
 		//disable the cancel button
 		$('#uploadify'+roleId+'-queue .uploadify-queue-item .cancel').css('display','none');
    },
    'onUploadSuccess' : function(file, data, response) {
    	var roleId = $(this)[0].original.attr('role');
    	$(".sample-item-preview[role='"+roleId+"']").removeClass('loading');
    	//$('#uploadify'+roleId).uploadify('disable', false);
    	//$('.uploadify').uploadify('disable', false);
        logging('The file ' + file.name + ' was successfully uploaded with a response of ' + response);
        if(response==true) {
        	data='<div>'+data+'</data>'; //add a root node
	        logging("FileName=>"+$("#upload_filename_100x100").val());
	        var filestatus=$("#upload_status",data).val();
	        var isFailedProcessing=$("#upload_isFailedProcessing",data).val();
	        var filename=$("#upload_filename",data).val();
            var filename_ext=$("#upload_ext",data).val();
            var filename_100=$("#upload_filename_100x100",data).val();
            var filename_400=$("#upload_filename_400x400",data).val();
            var filename_original=$("#upload_filename_original",data).val();
            //place the value to the form
            $(".file_is_rejected[role='"+roleId+"']").val(false);
            $(".filestatus[role='"+roleId+"']").val(filestatus);
        	$(".filename[role='"+roleId+"']").val(filename);
        	$(".filename_ext[role='"+roleId+"']").val(filename_ext);
        	$(".filename_100[role='"+roleId+"']").val(filename_100);
            $(".filename_400[role='"+roleId+"']").val(filename_400);
            $(".filename_original[role='"+roleId+"']").val(filename_original);
            $(".sample-item-preview[role='"+roleId+"'] .preimg").html('<i></i><img src="/100x100/'+filename_100+'" />');
            //show question mark image if isFailedProcessing == true
            if(isFailedProcessing == 'true')
            	$(".sample-item-preview[role='"+roleId+"'] a").fadeIn().fadeOut().fadeIn().fadeOut().fadeIn();
	     	//check if the user has uploaded 3 examples or not to determine the button status (enable/disable).
            checkUploadIfComplete();
	    }
        else {
        	buildPopupMsg({
				"content":"The upload process is timeout. Please try again. Thank you.",
				"showOk":true
			});
        	 //place the value to the form
            $(".filestatus[role='"+roleId+"']").val(-1);
        }
    },
    'onFallback' : function() {
    	//TODO need to implement
    }
 });
 $(document).on('click','#samplesSubmit',function() {
	 //send the data using ajax
	 $.ajax({
		type:'POST',
		data:$('#samples').serialize()+"&timezoneOffset="+timezoneOffset.getTimezoneOffset(),
		beforeSend: function() {
			buildPopupMsg({
				"content": layoutTemplate.loadingPopup,
				"title": "Loading",
				"showOk": false,
				"closeByOverlay": false,
				"effect":false
			});
		},
		error:function(error) {
			unbindPopupMsgEvent();
			buildPopupMsg({
				"content":"Submit error. Please try again.",
				"showOk":true,
				"position":"fixed",
				"effect":false
			});
		},
		success: function(response) {
			if(response.hasError == false) {
				var redirectURL = '//'; //homepage
				var needRedirect = false;
				if(response.samplesSubmitted>=3) {
					//The user have limited access now and no need to redirect to payment screen. 
					//redirect to the membership payment page if membership expired or redirect to the splash screen.
					/*
					if(response.membershipExpired) {
						redirectURL = membershipUrl +"?userId=" + response.userId;
						needRedirect = true;
					}
					else {
						redirectURL = splashUrl;
						needRedirect = true;
					}
					*/
					redirectURL = contextRootPath+response.redirectUrl;
					needRedirect = true;
					_gaq.push(['_trackEvent', 'registration', 'submit examples successfully', 'submit examples successfully', response.userId]);
				}
				unbindPopupMsgEvent();
				buildPopupMsg({
					"title":"Success",
					"content":"Thank you for your submission. An email will be sent to the address you provided within 5-7 business days once your registration has been reviewed and approved.",
					"showOk":true,
					"position":"fixed",
					"effect":false,
					"onOk": function() {
						if(needRedirect) {
							location.assign(redirectURL);
						}
						else
							closePopupMsg();
					},
					"onClose":function() {
						if(needRedirect) {
							location.assign(redirectURL);
						}
						else
							closePopupMsg();
					}
				});
			}
			else {
				buildPopupMsg({
					"content":"Submit error. Please try again.",
					"showOk":true,
					"position":"fixed",
					"effect":false
				});
			}
		}
	 });
 });
 function checkUploadIfComplete()
 {
	//check if the user has uploaded 3 examples or not to determine the button status (enable/disable).
	var canUpload=true;
	for(var i=0; i < $('.filename').length;i++) {
		//if one of examples has -1 filestatus. Disable the button.
		if($('.filename')[i].value == '' || $('.file_is_rejected')[i].value == 'true')
			canUpload=false;
	}
	if(canUpload) {
		$('#samplesSubmit').removeAttr('disabled');
		$('#samplesSubmit').removeClass('disabled');
		return true;
	}
	else {
		$('#samplesSubmit').attr('disabled','disabled');
		$('#samplesSubmit').addClass('disabled');
		return false;
	}
 }