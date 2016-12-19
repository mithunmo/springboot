//initialize uploadify plugin
$('#uploadifyPortfolio1, #uploadifyPortfolio2').uploadify(
{
 	'swf': '/js/jquery/uploadify/uploadify.swf',
 	'uploader': uploaderPath+"?mode=BOARD&filetype=ai",
 	'successTimeout':480,
 	'multi': false,
 	'auto' : true,
 	'fileTypeDesc': 'AI, PDF or JPG Files',
 	'fileTypeExts' : '*.ai; *.pdf; *.jpg; *.jpeg',
 	"buttonText": 'Select Files',
 	'onCancel': function() {
 		var roleId = $(this)[0].original.attr('role');
 		$(".sample-item-preview[role='"+roleId+"']").removeClass('preview-loading');
 		//$('.uploadify').uploadify('disable', false);
 		$('#save_create_portfolio').attr('button-disabled','false'); //enable the save button
 		//add the image to preview section back if user cancel uploading process and the filename_100 has value
 		if($('.filename_100[role="'+roleId+'"]').val()!='')
 			$('.sample-item-preview[role="'+roleId+'"]').html('<i></i><img src="/100x100/'+$('.filename_100[role="'+roleId+'"]').val()+'" />');
 	},
 	'onDialogOpen': function() {
 		var roleId = $(this)[0].original.attr('role');
 		//delete the orevious dialog if existed
 		$('.sample-item-upload[role="'+roleId+'"] .uploadify-queue-item').remove();
 		$('.resubmit[role="'+roleId+'"]').remove();
 	},
 	'onUploadProgress':function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
 		var roleId = $(this)[0].original.attr('role');
 		//remove the previous image
 		$('.sample-item-preview[role="'+roleId+'"]').html("");
 		//$('#uploadify'+roleId).uploadify('disable', true);
 		//$('.uploadify').uploadify('disable', true);
 		$('#save_create_portfolio').attr('button-disabled','true'); //disable the save button
 		if(totalBytesUploaded >= totalBytesTotal) {
 			$(".sample-item-preview[role='"+roleId+"']").addClass('preview-loading');
 		}
 	},
 	'onUploadError': function(file, errorCode, errorMsg, errorString) {
 		var roleId = $(this)[0].original.attr('role');
 		logging('The file ' + file.name + ' could not be uploaded: ' + errorString);
 		$(".sample-item-preview[role='"+roleId+"']").removeClass('preview-loading');
 		//$('#uploadify'+roleId).uploadify('disable', false);
 		//$('.uploadify').uploadify('disable', false);
 		$('#save_create_portfolio').attr('button-disabled','false'); //enable the save button
 	},
 	'onUploadComplete' : function(file) {
 		var roleId = $(this)[0].original.attr('role');
 		logging('The file ' + file.name + ' finished processing.');
 		//disable the cancel button
 		$('#uploadifyPortfolio'+roleId+'-queue .uploadify-queue-item .cancel').css('display','none');
    },
    'onUploadSuccess' : function(file, data, response) {
    	var roleId = $(this)[0].original.attr('role');
    	$(".sample-item-preview[role='"+roleId+"']").removeClass('preview-loading');
    	//$('#uploadify'+roleId).uploadify('disable', false);
    	//$('.uploadify').uploadify('disable', false);
    	$('#save_create_portfolio').attr('button-disabled','false'); //enable the save button
        logging('The file ' + file.name + ' was successfully uploaded with a response of ' + response);
        if(response==true) {
        	data='<div>'+data+'</data>'; //add a root node
	        logging("FileName=>"+$("#upload_filename_100x100").val());
	        var filestatus=$("#upload_status",data).val();
	        if(filestatus >= 0) {
	        	var filename=$("#upload_filename",data).val();
	            var filename_ext=$("#upload_ext",data).val();
	            var filename_100=$("#upload_filename_100x100",data).val();
	            var filename_400=$("#upload_filename_400x400",data).val();
	            var filename_original=$("#upload_filename_original",data).val();
	            $(".sample-item-preview[role='"+roleId+"']").html('<i></i><img src="/100x100/'+filename_100+'" />');
	            //place the value to the form
	            if($(".portfolio_image_id[role='"+roleId+"']").val()=='') {
	            	$(".portfolio_image_id[role='"+roleId+"']").val(0);
	         	}
	            $(".filestatus[role='"+roleId+"']").val(0);
	            $(".filename[role='"+roleId+"']").val(filename);
	            $(".filename_ext[role='"+roleId+"']").val(filename_ext);
	            $(".filename_100[role='"+roleId+"']").val(filename_100);
	            $(".filename_400[role='"+roleId+"']").val(filename_400);
	            $(".filename_original[role='"+roleId+"']").val(filename_original);
	            $(".active_status[role='"+roleId+"']").val(1);
	            //change the checkbox status
	            $('.delete-portfolio-image[role='+roleId+']').prop('checked',false);
	       	}
	        else {
	        	//show error message popup
	        	buildPopupMsg({
					"content":"Image failed to process. Please try again. Thank you.",
					"showOk":true,
					"title":"Error"
				});
	        	$(".filestatus[role='"+roleId+"']").val(-1);
	        	//add the image to preview section back if user cancel uploading process and the filename_100 has value
	     		if($('.filename_100[role="'+roleId+'"]').val()!='')
	     			$('.sample-item-preview[role="'+roleId+'"]').html('<i></i><img src="/100x100/'+$('.filename_100[role="'+roleId+'"]').val()+'" />');
	        }
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