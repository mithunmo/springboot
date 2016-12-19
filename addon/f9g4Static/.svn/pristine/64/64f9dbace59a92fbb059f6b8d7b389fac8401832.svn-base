//apply table style if user use IE 8 or lower.
if($.browser.msie && ($.browser.version == "8.0" || $.browser.version == "7.0"))
{
	logging("layout table on IE 8","#00F");
    $(".board-approval-table .inner-table td:nth-child(1)").addClass("td1");
    $(".board-approval-table .inner-table td:nth-child(2)").addClass("td2");
    $(".board-approval-table .inner-table td:nth-child(3)").addClass("td3");
    $(".board-approval-table .inner-table td:nth-child(4)").addClass("td4");
    $('.board-approval-table .outter-row:even').addClass('odd'); 
    $('.board-approval-table .outter-row:odd').addClass('even');
    $('.board-approval-table tr:odd').addClass('even');
    $('.board-approval-table tr:even').addClass('odd');
    $(".board-approval-table td:nth-child(1)").addClass("td1");
    $(".board-approval-table td:nth-child(2)").addClass("td2");
}

$(document).on("click",".approve",function(e) {
	//submit the board
	var boardId=$(this).attr("data");
	if(/*$('.approval-comment[data="'+$(this).attr("data")+'"]').val().length>0 &&*/ $('.submitted[data="'+$(this).attr("data")+'"]').val()==0) //make sure the administrator enter the comment and the board is not being submitted
	{
		//show confirmation pop-up and se the position to fixed mode (always in the center of the window)
		showConfirmation("Are you sure you want to APPROVE this board?","Confirmation","changedWithoutSave",{
			"onOk":function() {
				closePopupMsg();
				submitApprovalBoard(boardId,1);
			}
		},{
			'position':'fixed'
		});
	}
	else if($('.submitted[data="'+$(this).attr("data")+'"]').val()==1) {
		$('.result[data="'+$(this).attr("data")+'"]').addClass("error");
		$('.result[data="'+$(this).attr("data")+'"]').html("This board has been processed");
	}
	else {
		$('.result[data="'+$(this).attr("data")+'"]').addClass("error");
		$('.result[data="'+$(this).attr("data")+'"]').html("Please enter comments");
	}
});

$(document).on("click",".reject",function(e) {
	//submit the board and assure the comment is not empty
	var boardId=$(this).attr("data");
	if($('.approval-comment[data="'+$(this).attr("data")+'"]').val().length>0 && $('.submitted[data="'+$(this).attr("data")+'"]').val()==0) //make sure the administrator enter the comment and the board is not being submitted
	{
		//show confirmation pop-up
		showConfirmation("Are you sure you want to REJECT this board?","Confirmation","changedWithoutSave",{
			"onOk":function() {
				closePopupMsg();
				submitApprovalBoard(boardId,0);
			}
		},{
			'position':'fixed'
		});
	}
	else if($('.submitted[data="'+$(this).attr("data")+'"]').val()==1) {
		$('.result[data="'+$(this).attr("data")+'"]').addClass("error");
		$('.result[data="'+$(this).attr("data")+'"]').html("This board has been processed");
	}
	else {
		$('.result[data="'+$(this).attr("data")+'"]').addClass("error");
		$('.result[data="'+$(this).attr("data")+'"]').html("Please enter comments");
	}
});

$(document).on('click','.resubmit-sample',function(e) {
	//submit the board and assure the comment is not empty
	var boardId=$(this).attr("data");
	var userId=$(this).attr("user");
	var name=$('.userName[data="'+userId+'"]').html();
	if($('.approval-comment[data="'+$(this).attr("data")+'"]').val().length>0 && $('.submitted[data="'+$(this).attr("data")+'"]').val()==0) //make sure the administrator enter the comment and the board is not being submitted
	{
		//show confirmation pop-up
		showConfirmation('Are you sure you want to ask user "'+name+'" to resubmit the example?',"Confirmation","changedWithoutSave",{
			"onOk":function() {
				closePopupMsg();
				resubmitSamples(boardId); //approve status 2. It will change the reg status to 431.
			}
		},{
			'position':'fixed'
		});
	}
	else if($('.submitted[data="'+$(this).attr("data")+'"]').val()==1) {
		$('.result[data="'+$(this).attr("data")+'"]').addClass("error");
		$('.result[data="'+$(this).attr("data")+'"]').html("This example has been asked for resubmission");
	}
	else {
		$('.result[data="'+$(this).attr("data")+'"]').addClass("error");
		$('.result[data="'+$(this).attr("data")+'"]').html("Please enter comments");
	}
});

$(document).on("keyup",".approval-comment",function(e) {
	if($(this).val().length>0) {
		//enable the button
		$('.reject[data="'+$(this).attr("data")+'"]').removeClass("disabled");
		//$('.approve[data="'+$(this).attr("data")+'"]').removeClass("disabled");
		$('.resubmit-sample[data="'+$(this).attr("data")+'"]').removeClass("disabled");
	}
	else {
		//disable the button
		$('.reject[data="'+$(this).attr("data")+'"]').addClass("disabled");
		//$('.approve[data="'+$(this).attr("data")+'"]').addClass("disabled");
		$('.resubmit-sample[data="'+$(this).attr("data")+'"]').addClass("disabled");
	}
});

$(document).on("click",".approve-user",function(e) {
	//submit the board
	var userId=$(this).attr("data");
	var memPricingOption=$('.memPricingOption[data="'+$(this).attr("data")+'"]').val();
	var name=$('.userName[data='+userId+']').html();
	if($('.memPricingOption[data="'+$(this).attr("data")+'"]').val().length>0) //make sure the administrator enter the comment and the board is not being submitted
	{
		//show confirmation pop-up
		showConfirmation('Are you sure you want to APPROVE user "'+name+'" ?',"Confirmation","changedWithoutSave",{
			"onOk":function() {
				submitApprovalUser(userId,memPricingOption,1,false); //approve status 1. It will change the reg status to 432
			}
		},{
			'position':'fixed'
		});
	}
});

$(document).on("click",".reject-user",function(e) {
	//submit the board and assure the comment is not empty
	var userId=$(this).attr("data");
	var memPricingOption=$('.memPricingOption[data="'+$(this).attr("data")+'"]').val();
	var name=$('.userName[data='+userId+']').html();
	if($('.memPricingOption[data="'+$(this).attr("data")+'"]').val().length>0) //make sure the administrator enter the comment and the board is not being submitted
	{
		//show confirmation pop-up
		showConfirmation('Are you sure you want to REJECT user "'+name+'" ?',"Confirmation","changedWithoutSave",{
			"onOk":function() {
				submitApprovalUser(userId,memPricingOption,0,false); //approve status 0. It will change the reg status to 435
			}
		},{
			'position':'fixed'
		});
	}
});

$(document).on("click",".change-user-level",function(e) {
	//submit the board
	var userId=$(this).attr("data");
	var memPricingOption=$('.memPricingOption[data="'+$(this).attr("data")+'"]').val();
	var name=$('.userName[data='+userId+']').html();
	if($('.memPricingOption[data="'+$(this).attr("data")+'"]').val().length>0) //make sure the administrator enter the comment and the board is not being submitted
	{
		//show confirmation pop-up
		showConfirmation('Are you sure you want to change the membershp level for user "'+name+'" ?',"Confirmation","changedWithoutSave",{
			"onOk":function() {
				submitApprovalUser(userId,memPricingOption,1,true);
			}
		},{
			'position':'fixed'
		});
	}
});

$(document).on("click",".userLogo",function(e) {
	var userId=$(this).attr('data');
	getUserDetail(userId,function() {
		//retrieveExamplesImgs(userId);
	}); //Load users detail
});

$(document).on("click",".userName",function(e) {
	var userId=$(this).attr('data');
	getUserDetail(userId,function() {
		//retrieveExamplesImgs(userId);
	}); //Load users detail
});

$(document).on("click","#resetPassword",function(e) {
	var userName=$(this).attr("user-name");
	var userId=$(this).attr("data");
	showConfirmation('Do you want to reset the password for user "'+$(this).attr("user-name")+'" ?',"Confirmation","changedWithoutSave",{
		"onOk":function() {
			resetPassword(userId);
		}
	},{
		'position':'fixed'
	});
});

$(document).on("click","#sendMail",function(e) {
	//Load users detail
	if(($('#mailUserId').val()!='' && $('#mailUserId').val()!=undefined) && ($('#mailContent').val()!='' && $('#mailContent').val()!=undefined)) {
		if($('#mailSubject').val()==='' || $('#mailSubject').val()===undefined)
			$('#mailSubject').val("Default Subject");
		$.ajax({
			url:sendMailPath,
			data:$('#mailMessage').serialize(),
			type:'POST',
			beforeSend: function() {
				$('#sendMailStatus').html('Sending....');
			},
			error:function() {
				$('#sendMailStatus').html('Error, please send again.');
			},
			success:function(result) {
				//Put the result to user detail div
				if(result.hasError==false)
				{
					//Reset from
					$('#mailMessage')[0].reset();
					$('#sendMailStatus').html('Sent successfully.');
				}
				else
					$('#sendMailStatus').html('Error, please send again.');
			}
		});
	}
});

$(document).on("change",'.user-filter',function() {
	window.location='?usertype='+$('#userTypeFilter').val()+'&filter='+$('#userFilter').val()+"&sortoption="+$('#sortOption').val()+"&p=1";
});

$(document).on("change",'.user-filter-pagin',function() {
	var page = $('#page').val();
	if(page==undefined)
		page=-1;
	window.location='?usertype='+$('#userTypeFilter').val()+'&filter='+$('#userFilter').val()+"&sortoption="+$('#sortOption').val()+"&p="+page;
});

$(document).on('change','.board-filter',function() {
	window.location='?pmp='+$('#mpFilter').val()+'&did='+$('#designerFilter').val()+'&mode='+$('#viewMode').val()+'&ptype='+$('#pTypeFilter').val()+'&sortOption='+$('#sortOption').val();
});

$(document).on("change","#emailTemplate",function(e) {
	getEmailTemplate(e.target.selectedIndex);
});

$(document).on('change keyup','#broadcastMsgSubject, #broadcastMsgBody, #_broadcastMsgSubject, #_broadcastMsgBody',function() {
	emailContentChangedHandler();
});

$(document).on('click','#broadcastSubmit',function() {
	showConfirmation('Do you want to broadcast this alert?',"Confirmation","changedWithoutSave",{
		"onOk":function() {
			unbindPopupMsgEvent();
			submitBroadcastMessage();
		}
	},{
		'position':'fixed'
	});
});

$(document).on('click','.edit-board',function() {
	if($.url().attr('query').replace(/ /g,"")!="")
		location.href=editBoardPath+'?boardId='+$(this).attr('data')+"&"+$.url().attr('query');
	else
		location.href=editBoardPath+'?boardId='+$(this).attr('data');
});

$(document).on('click','#showBoardsByPortfolio',function() {
	$('#board-gallery').toggle('blind');
});

$(document).on('click','#admin_save_edit_board',function() {
	saveBoard();
});

var galleryAttr;
$(document).on('click','#board-gallery .control-prev',function () {
	galleryController('prev');	
})

$(document).on('click','#board-gallery .control-next',function () {
	galleryController('next');	
})

$(document).on('click','.view-samples',function() {
	//append hash on it.
	location.hash="#"+$(this).attr('data');
	//redirect to the view samples page
	location.href=viewBoardApprovalPath+'?mode=samples&pmp=all&did='+$(this).attr('data');
	/*
	//View examples in the right user detail area by ajax call
	var userId=$(this).attr('data');
	if($('#mailUserId').val()!=userId) {
		//if the user detail is not the same user, reload the user detail first
		getUserDetail(userId,function() {
			retrieveExamplesImgs(userId);
		}); //Load users detail
	}
	else	
		retrieveExamplesImgs(userId);
	*/
});

$(document).on('click','.hide-user',function() {
	//push user id to web storage
	if(typeof(Storage)!=="undefined") {
		//Code for localStorage/sessionStorage.
		var target = $(this).attr('data');
		var isShown = true;
		if(localStorage.getItem('hiddenUserList') != null) {
			var userListStr = localStorage.getItem('hiddenUserList');
			var userList = userListStr.split(',');
			if(userList.indexOf(target)==-1) {
				userList.push(target);
				localStorage.setItem('hiddenUserList',userList);
				isShown=false;
			}
			else {
				var patt=new RegExp(','+target+'|'+target+',|'+target,'g');
				userListStr=userListStr.replace(patt,'');
				if(userListStr.length > 0)
					localStorage.setItem('hiddenUserList',userListStr);
				else
					localStorage.removeItem('hiddenUserList');
				isShown=true;
			}
		}
		else {
			var userList = new Array();
			userList.push(target);
			localStorage.setItem('hiddenUserList',userList.join(','));
			isShown = false;
		}
		if(!isShown)
			hideHiddenUsers(target); //Hide the user directly
		updateHideButton(target); //Update the hide-user button to correspondant word (Hide/Show)
	}
	else {
		//Sorry! No Web Storage support.
		alert('Unsupported browser detected. Please use newer browser version to user hide user functionality.');
	}
});

$(document).on('click',"#enableHiddenUsers",function(e) {
	hideHiddenUsers();
	return false;
});
$(document).on('click',"#disableHiddenUsers",function(e) {
	showHiddenUsers();
	return false;
});
$(document).on('click',"#clearHiddenUsers",function(e) {
	localStorage.removeItem('hiddenUserList');
	showHiddenUsers();
	return false;
});
$(document).on('keyup','#userSearch',function(e) {
	userApprovalSearch(e,$(this).val());
});
$(document).on('keyup','.apcmmnt',function(e) {
	var uid = $(this).attr('data');
	if($(this).val().replace(/\s/g,'')=='')
		$('.apcmmnt-b[data="'+uid+'"]').attr('disabled','disabled');
	else
		$('.apcmmnt-b[data="'+uid+'"]').removeAttr('disabled');
});
$(document).on('click','.apcmmnt-b',function(e) {
	updateApproverComment($(this).attr('data'));
});
$(document).on('click','.apcmmnt-h',function(e) {
	buildPopup({
		"url":approverCommentsPath+'?uid='+$(this).attr('data')
	});
});
$(document).on('click','.ffg-rating-panel-update',function(e) {
	showAdminRatingPopup($(this).attr('data-id'));
});

$(document).ready(function() {
	//scroll to specific position if hash assigned
	var uid=parseInt(location.hash.replace("#",""));
	if(uid!='' && !isNaN(uid)) {
		var divLoc = $('.user-list-item[data='+uid+']').position();
        $('.users-list-view').animate({scrollTop: divLoc.top}, "fast");
	}
	
	/*$('.users-list-view').scroll(function () {
	    if ($(this).scrollTop() > $('.footer').offset().top) {
	       console.log($(this).scrollTop());
	    } else {
	        alert($(window).scrollTop());
	        alert("footer invisible");
	    }
	});*/
});

function submitApprovalBoard(boardId,approvalStatus)
{
	//change the approval status on the form
	$('.approval-status[data="'+boardId+'"]').val(approvalStatus);
	$.ajax({
		url:sumbitBoardApprovalPath,
		type:"POST",
		data:$('form[data="'+boardId+'"]').serialize(),
		beforeSend:function() {
			var delay=400;
			if(approvalStatus==1)
				$('.approve[data="'+boardId+'"]').addClass("gray",delay).removeClass("gray",delay).addClass("gray",delay).removeClass("gray",delay).addClass("gray",delay).removeClass("gray",delay);
			else
				$('.reject[data="'+boardId+'"]').addClass("gray",delay).removeClass("gray",delay).addClass("gray",delay).removeClass("gray",delay).addClass("gray",delay).removeClass("gray",delay);
			//$('.result[data="'+boardId+'"]').html("Submitting...");
		},
		error:function() {
			$('.result[data="'+boardId+'"]').addClass("error");
			$('.result[data="'+boardId+'"]').html("Submit failed, please submit again.");
		},
		success:function(result) {
			if(result.hasError) {
				$('.result[data="'+boardId+'"]').addClass("error");
				if(result.errorDescription==undefined)
					$('.result[data="'+boardId+'"]').html("Submit failed, please submit again.");
				else
					$('.result[data="'+boardId+'"]').html(result.errorDescription);
			}
			else {
				if(approvalStatus==1) {
					$('.result[data="'+boardId+'"]').removeClass("error");
					$('.result[data="'+boardId+'"]').addClass("approved");
					$('.result[data="'+boardId+'"]').html("Approved.");
				}
				else {
					$('.result[data="'+boardId+'"]').removeClass("error");
					$('.result[data="'+boardId+'"]').addClass("rejected");
					$('.result[data="'+boardId+'"]').html("Rejected.");
				}
				//change the submitted to 1
				$('.submitted[data="'+boardId+'"]').val(1);
			}
		}
	});
}

function resubmitSamples(boardId) {
	//change the approval status on the form
	$('.approval-status[data="'+boardId+'"]').val(1);
	$.ajax({
		url:resubmitSamplesPath,
		type:"POST",
		data:$('form[data="'+boardId+'"]').serialize(),
		beforeSend:function() {
			var delay=400;
			$('.resubmit-sample[data="'+boardId+'"]').addClass("gray",delay).removeClass("gray",delay).addClass("gray",delay).removeClass("gray",delay).addClass("gray",delay).removeClass("gray",delay);
		},
		error:function() {
			$('.result[data="'+boardId+'"]').addClass("error");
			$('.result[data="'+boardId+'"]').html("Submit failed, please submit again.");
		},
		success:function(result) {
			if(result.hasError) {
				$('.result[data="'+boardId+'"]').addClass("error");
				if(result.errorDescription==undefined)
					$('.result[data="'+boardId+'"]').html("Submit failed, please submit again.");
				else
					$('.result[data="'+boardId+'"]').html(result.errorDescription);
			}
			else {
				$('.result[data="'+boardId+'"]').removeClass("error");
				$('.result[data="'+boardId+'"]').addClass("rejected");
				$('.result[data="'+boardId+'"]').html("Administrator has asked user to resubmit this example.");
				//change the submitted to 1
				$('.submitted[data="'+boardId+'"]').val(1);
			}
		}
	});
}

function submitApprovalUser(userId,memPricingOption,approvalStatus,changeMode)
{
	//change the approval status on the form
	//$('.approval-status[data="'+boardId+'"]').val(approvalStatus);
	var formData;
	if(changeMode==true)
		formData=$('.membershipLevelSelect[data='+userId+']').serialize()+"&approval_status=1";
	else {
		formData=$('.membershipLevelSelect[data='+userId+']').serialize()+"&approval_status="+approvalStatus;
	}
	$.ajax({
		url:submitUserApprovalPath,
		type:"POST",
		data:formData,
		beforeSend:function() {
			buildPopupMsg({
				"content": layoutTemplate.loadingPopup,
				"title": "Loading",
				"showOk": false,
				"closeByOverlay": false,
				"effect":false
			});
		},
		error:function() {
			unbindPopupMsgEvent();
			buildPopupMsg({
				"content":"Submit error. Please try again.",
				"showOk":true,
				"position":"fixed",
				"effect":false
			});
		},
		success:function(result) {
			unbindPopupMsgEvent();
			if(result.hasError===true || result.hasError==undefined) {
				buildPopupMsg({
					"content":"Submit error. Please try again.",
					"showOk":true,
					"position":"fixed",
					"effect":false
				});
			}
			else {
				closePopupMsg();
				var message;
				//Reset class
				$('.regStatus[data="'+userId+'"]').removeClass("highlight");
				$('.current-membership[data="'+userId+'"]').removeClass("highlight");
				$('.expDate[data="'+userId+'"]').removeClass("highlight");
				if(changeMode==true) {
					message="Update successfully.";
					//Update membership level
					$('.current-membership[data="'+userId+'"]').addClass("highlight");
					$('.current-membership[data="'+userId+'"]').html(result.user.userMembership[0].memPricingOption[0].membershipType.description+" , $"+result.user.userMembership[0].memPricingOption[0].price+" , "+result.user.userMembership[0].memPricingOption[0].commission+"%");
					$('.expDate[data="'+userId+'"]').addClass("highlight");
					$('.expDate[data="'+userId+'"]').html(result.userExpDate);
					//Change button layout
					var layout='<div class="button change-user-level" data="'+userId+'">Change Level</div><div class="button view-samples" data='+userId+'>View Examples</div>';
					$('.membership-buttons-panel[data="'+userId+'"]').html(layout);
				}
				else {
					if(approvalStatus==1) {
						message="Approve successfully.";
						//Change registration status
						$('.regStatus[data="'+userId+'"]').addClass("highlight");
						$('.regStatus[data="'+userId+'"]').html(result.user.registerStatus.description);
						//Update membership level
						$('.current-membership[data="'+userId+'"]').addClass("highlight");
						$('.current-membership[data="'+userId+'"]').html(result.user.userMembership[0].memPricingOption[0].membershipType.description+" , $"+result.user.userMembership[0].memPricingOption[0].price+" , "+result.user.userMembership[0].memPricingOption[0].commission+"%");
						$('.expDate[data="'+userId+'"]').addClass("highlight");
						$('.expDate[data="'+userId+'"]').html(result.userExpDate);
						//Change membership button layout
						//show Change level button
						var layout='<div class="button change-user-level" data="'+userId+'">Change Level</div><div class="button view-samples" data='+userId+'>View Examples</div>';
						$('.membership-buttons-panel[data="'+userId+'"]').html(layout);
					}
					else if (approvalStatus==0) {
						message="You have rejected the user.";
						//Change registration status
						$('.regStatus[data="'+userId+'"]').addClass("highlight");
						$('.regStatus[data="'+userId+'"]').html(result.user.registerStatus.description);
						//Change membership button layout
						//show approve button
						var layout='<div class="button approve-user" data="'+userId+'">Approve</div>';
						$('.membership-buttons-panel[data="'+userId+'"]').html(layout);
					}
					else {
						message="You have asked the user to resubmit this example.";
						//Change registration status
						$('.regStatus[data="'+userId+'"]').addClass("highlight");
						$('.regStatus[data="'+userId+'"]').html(result.user.registerStatus.description);
						//Change membership button layout
						//delete the membership buttons area
						$('.membership-buttons-panel[data="'+userId+'"]').remove();
						//samples button layout
						//show view samples button
						var layout='<div class="button view-samples" data='+userId+'>View Examples</div>';
						$('.membership-buttons-panel[data="'+userId+'"]').append(layout);
						
					}
						
				}
				//reset the class for every items
				$('.user-list-item.selected').removeClass('selected');
				//highlight the item
				$('.user-list-item[data='+userId+']').addClass('selected');
				getUserDetail(userId); //Reload the user detail on the right area.
			}
		}
	});
}

function getUserDetail(userId,callback)
{
	var path=usersViewerDetailPath+'?userId='+userId;
	$.ajax({
		url:path,
		type:'GET',
		beforeSend: function() {
			//reset the class for every items
			$('.user-list-item.selected').removeClass('selected');
			//highlight the item
			$('.user-list-item[data='+userId+']').addClass('selected');
			$('#userDetail').html('Loading....');
		},
		error:function() {
			$('#userDetail').html('Please click user logo again, thanks....');
		},
		success:function(result) {
			//Put the result to user detail div
			$('#userDetail').html(result);
			initAdminRaty();
			if(typeof(callback) == 'function')
				callback();
		}
	});
}

function resetPassword(userId)
{
	var path=resetTempPasswordPath+'?userId='+userId;
	$.ajax({
		url:path,
		type:'GET',
		beforeSend: function() {
			buildPopupMsg({
				"content": '<span style="color:blue;">Please wait...<span><br /><img src="/images/spinner_small.gif" style="margin-top:30px;"/>',
				"title": "Please Wait...",
				"showOk": false,
				"closeByOverlay": false,
				"effect":false
			});
		},
		error:function() {
			unbindPopupMsgEvent();
			buildPopupMsg({
				"content":"Submit error. Please try again.",
				"showOk":true,
				"position":"fixed",
				"effect":false
			});
		},
		success:function(result) {
			//Put the result to user detail div
			if(result.hasError || result.hasError==undefined) {
				unbindPopupMsgEvent();
				buildPopupMsg({
					"content":result.errorDescription,
					"showOk":true,
					"position":"fixed",
					"effect":false
				});
			}
			else {
				unbindPopupMsgEvent();
				buildPopupMsg({
					"title":"Success",
					"content":"The system has sent the temp password email to the user.",
					"showOk":true,
					"position":"fixed",
					"effect":false
				});
			}
		}
	});
}

function getEmailTemplate(index) {
	if(index>0) {
		$.ajax({
			url:getTemplateContentPath+'?index='+index,
			beforeSend: function() {
				$('#broadcastMsgForm .loadingPanel').show();
			},
			error: function() {
				$('#broadcastMsgForm .loadingPanel').hide();
				buildPopupMsg({
					"content":"Services unavailable. Please try again.",
					"showOk":true,
					"position":"fixed",
					"effect":false
				});
			},
			success: function(result) {
				//Update subject
				$('#_broadcastMsgSubject').val(result.subject);
				$('#_broadcastMsgSubject').attr('disabled','disabled'); //Disable the textarea
				$('#broadcastMsgSubject').val(result.subject);
				//Update body
				$('#broadcastMsgForm .loadingPanel').hide();
				$('#_broadcastMsgBody').val(result.body);
				$('#_broadcastMsgBody').attr('disabled','disabled'); //Disable the textarea
				$('#broadcastMsgBody').val(result.body);
				$('#broadcastMsgBody').trigger('change');
			}
		});
	}
	else {
		$('#_broadcastMsgSubject').removeAttr('disabled'); //Enable the textarea
		$('#_broadcastMsgSubject').val("");
		$('#broadcastMsgSubject').val("");
		$('#_broadcastMsgBody').removeAttr('disabled'); //Enable the textarea
		$('#_broadcastMsgBody').val("");
		$('#broadcastMsgBody').val("");
		$('#broadcastMsgBody').trigger('change');
	}
}

function emailContentChangedHandler() {
	//Detect the content
	if(($('#_broadcastMsgSubject').val().replace(/ /g,"")!="" || $('#_broadcastMsgSubject').val().replace(/ /g,"").length>0)
			&& ($('#_broadcastMsgBody').val().replace(/ /g,"")!="" || $('#_broadcastMsgBody').val().replace(/ /g,"").length>0)) {
		$('#broadcastSubmit').removeClass('disabled'); //enable the send button
		$('#broadcastSubmit').removeAttr('button-disabled'); //enable the send button
	}
	else {
		$('#broadcastSubmit').addClass('disabled'); //disable the send button
		$('#broadcastSubmit').attr('button-disabled','true'); //disable the send button
	}
}

function submitBroadcastMessage() {
	$('#broadcastMsgBody').val($('#_broadcastMsgBody').val()); //copy content
	$('#broadcastMsgSubject').val($('#_broadcastMsgSubject').val()); //copy content
	$.ajax({
		url:submitBroadcastMsgPath,
		type:'POST',
		data:$('#broadcastMsgForm').serialize(),
		beforeSend: function() {
			buildPopupMsg({
				"content": layoutTemplate.loadingPopup,
				"title": "Loading",
				"showOk": false,
				"closeByOverlay": false,
				"effect":false
			});
		},
		error: function() {
			buildPopupMsg({
				"content":"Submit error. Please try again.",
				"showOk":true,
				"position":"fixed",
				"effect":false
			});
		},
		success: function(result) {
			buildPopupMsg({
				"title":"Success",
				"content":"The broadcast message has been submitted.",
				"showOk":true,
				"position":"fixed",
				"effect":false
			});
			$('#broadcastMsgForm')[0].reset();
			$('#emailTemplate').trigger('change');
			$('#broadcastSubmit').addClass('disabled'); //disable the send button
			$('#broadcastSubmit').attr('button-disabled','true'); //disable the send button
		}
	});
}

function saveBoard() {
	//Inout checking
	var errors=new Array();
	errors=CheckforNullinSelect('#product',errors,'#label_product',"Please select product.");
	errors=CheckforNullinSelect('#productType',errors,'#label_product_type',"Please select product type.");
	errors=CheckforNumberRange('#form_board_price',errors,'#form_board_price','The price should be between '+minimunBoardPrice+' and '+maximunBoardPrice,minimunBoardPrice,maximunBoardPrice);
	if(errors.length>0) {
		buildPopupMsg({
			"title":"Success",
			"content":errors.join('<br />'),
			"showOk":true,
			"position":"fixed",
			"effect":false
		});
	}
	else {
		$.ajax({
			url:$('#form_create_board').attr('action'),
			type:'POST',
			data:$('#form_create_board').serialize(),
			beforeSend: function () {
				buildPopupMsg({
					"content": layoutTemplate.loadingPopup,
					"title": "Loading",
					"showOk": false,
					"closeByOverlay": false,
					"effect":false
				});
			},
			error: function() {
				buildPopupMsg({
					"content":"Submit error. Please try again.",
					"showOk":true,
					"position":"fixed",
					"effect":false
				});
			},
			success: function (result) {
				if(result.hasError) {
					var errorInfo = new Array();
					for(var i=0; i<result.errors.length ; i++)
						errorInfo.push(result.errors[i].defaultMessage);
					buildPopupMsg({
						"title":"Success",
						"content":errorInfo.join('<br />'),
						"showOk":true,
						"position":"fixed",
						"effect":false
					});
				}
				else {
					globalVars.isChangedWithoutSubmit=false;
					buildPopupMsg({
						"title":"Success",
						"content":"Update successfully.",
						"showOk":true,
						"position":"fixed",
						"effect":false
					});
				}
			}
		});
	}
}

function galleryInit() {
	var attributes={
		'wrapperWidth': $('#board-gallery .board-gallery-wrapper').width(),
		'viewerWidth': $('#board-gallery .board-gallery-wrapper ul').width(),
		'itemWidth': $('#board-gallery .board-gallery-wrapper ul li').width()
	};
	attributes.transitionWidth = attributes.itemWidth*Math.floor(attributes.wrapperWidth/attributes.itemWidth)
	return attributes;
}

function galleryController(mode,callback) {
	if(galleryAttr==undefined)
		galleryAttr=galleryInit();
	//Detect the width of wrapper
	/*var wrapperWidth=$('#board-gallery .board-gallery-wrapper').width();
	var viewerWidth=$('#board-gallery .board-gallery-wrapper ul').width();
	var itemWidth=$('#board-gallery .board-gallery-wrapper ul li').width();
	var transitionWidth=itemWidth*Math.floor(wrapperWidth/itemWidth);*/
	var viewerPos=$('#board-gallery .board-gallery-wrapper ul').position();
	if(mode=='prev') {
		if(viewerPos.left<0) {
			$('#board-gallery .board-gallery-wrapper ul').animate({
				left:'+='+galleryAttr.transitionWidth
			});
		}
	}
	else {
		if(viewerPos.left-galleryAttr.transitionWidth>(0-galleryAttr.viewerWidth)) {
			$('#board-gallery .board-gallery-wrapper ul').animate({
				left:'-='+galleryAttr.transitionWidth
			});
		}
	}
}

function updateHideButton(id) {
	if(typeof(Storage)==="undefined") {
		$('.hidden-users-pannel').hide();
		$('.user-list-item .hide-user').remove();
	}
	else {
		if(localStorage.getItem('hiddenUserList')!=null) {
			var userList = localStorage.getItem('hiddenUserList').split(',');
			$('#hiddenUsersCount').html('('+userList.length+' hidden)');
			if(id==undefined) {
				if(userList.length > 0) {
					$('.user-list-item').each(function() {
						var target = $(this).attr('data');
						if(userList.indexOf(target)!=-1)
							$(this).find('.hide-user').html('Show');
						else
							$(this).find('.hide-user').html('Hide');
					});
				}
			}
			else {
				if(userList.indexOf(id)!=-1)
					$('.user-list-item[data="'+id+'"] .hide-user').html('Show');
				else
					$('.user-list-item[data="'+id+'"] .hide-user').html('Hide');
			}
		}
		else {
			$('#hiddenUsersCount').html('');
			$('.user-list-item .hide-user').html('Hide');
		}
	}
}

function hideHiddenUsers(id) {
	if(typeof(Storage)==="undefined") {
		$('.hidden-users-pannel').hide();
		$('.user-list-item .hide-user').remove();
		$('.userLogo:first').trigger('click'); //Trigger to retrieve the first user information
	}
	else {
		if(localStorage.getItem('hiddenUserList')!=null) {
			var userList = localStorage.getItem('hiddenUserList').split(',');
			if(userList.length > 0) {
				$('.user-list-item').each(function() {
					var target = $(this).attr('data');
					$(this).removeClass('removed').removeClass('active');
					if(userList.indexOf(target)!=-1)
						$(this).addClass('removed');
					else
						$(this).addClass('active');
				});
			}	
		}
		//render the layout
		$('.user-list-item.active').removeClass('odd').removeClass('even');
		$('.user-list-item.active:even').addClass('odd');
		$('.user-list-item.active:odd').addClass('even');
		/*var userId = $('.user-list-item.active:first').attr('data'); //get first not hidden user
		if(userId == undefined)
			userId = $('.user-list-item:first').attr('data');
		getUserDetail(userId);*/
	}
}

function showHiddenUsers() {
	updateHideButton();
	//read hiddenUserList and remove the DOM
	$('.user-list-item').removeClass('removed').removeClass('active').removeClass('even').removeClass('odd');
	//render the layout
	$('.user-list-item:even').addClass('odd');
	$('.user-list-item:odd').addClass('even');
}

function userApprovalSearch(event,pattern) {
	var container='.membershipLevelSelect';
	if(pattern!='') {
		//new search
		if(event.which != 13) {
			$('.user-list-item .highlight-text').removeClass('highlight-text');
			$('#userSearch').data('pattern',pattern);
			var rc = new Array();
			$(container).each(function (index) {
				var uid=$(this).find('.userName').attr('data');
				var childName=$(this).find('.table-username');
				var childUsername=$(this).find('.userName-content');
				var childExpDate=$(this).find('.expDate');
				var childEffectiveDate=$(this).find('.effectiveDate');
				var childRegStatus=$(this).find('.regStatus');
				var root = '.membershipLevelSelect';
				var pos=-1,posCN=-1,posCU=-1,posCED=-1,posCEFF,posRC=-1;
				try {
					var upperCasedPat = pattern.toUpperCase();
					posCN = childName.html().toUpperCase().search(upperCasedPat);
					posCU = childUsername.html().toUpperCase().search(upperCasedPat);
					posRC = childRegStatus.html().toUpperCase().search(upperCasedPat);
					posCED = childExpDate.html().toUpperCase().search(upperCasedPat);
					posCEFF = childEffectiveDate.html().toUpperCase().search(upperCasedPat);
					if(posCU!=-1) {
						childUsername.addClass('highlight-text');
						var element = new Array();
						element.push(uid);
						element.push(root+'[data="'+uid+'"] .userName-content');
						rc.push(element);
					}
					if(posCN!=-1) {
						childName.addClass('highlight-text');
						var element = new Array();
						element.push(uid);
						element.push(root+'[data="'+uid+'"] .table-username');
						rc.push(element);
					}
					if(posRC!=-1) {
						childRegStatus.addClass('highlight-text');
						var element = new Array();
						element.push(uid);
						element.push(root+'[data="'+uid+'"] .regStatus');
						rc.push(element);
					}
					if(posCEFF!=-1) {
						childEffectiveDate.addClass('highlight-text');
						var element = new Array();
						element.push(uid);
						element.push(root+'[data="'+uid+'"] .effectiveDate');
						rc.push(element);
					}
					if(posCED!=-1) {
						childExpDate.addClass('highlight-text');
						var element = new Array();
						element.push(uid);
						element.push(root+'[data="'+uid+'"] .expDate');
						rc.push(element);
					}
				}
				catch(e) {}
			});
			if(rc.length > 0) {
				var divLoc = $('.user-list-item[data='+rc[0][0]+']').position();
				$('.users-list-view').animate({scrollTop: $('.users-list-view').scrollTop()+divLoc.top}, "fast"); //move to first result
				$(rc[0][1]).addClass('currentTarget'); //highlight the target
				//Store the container
				$('#userSearch').data('searchResult',rc);
				$('#userSearch').data('currentIndex',0);
			}
			else {
				$('#userSerachResult').html('Not found');
				//reset all highlight class
				$('.highlight-text').removeClass('highlight-text');
				$('.currentTarget').removeClass('currentTarget');
			}
		}
		else {
			//current search result traverse
			var rc = $('#userSearch').data('searchResult');
			if(rc.length > 0) {
				var currentIndex = $('#userSearch').data('currentIndex');
				var nextIndex = (currentIndex+1)%rc.length;
				var divLoc = $('.user-list-item[data='+rc[nextIndex][0]+']').position();
				$('.currentTarget').removeClass('currentTarget');
				$('#userSearch').data('currentIndex',nextIndex);
				$('.users-list-view').animate({scrollTop: $('.users-list-view').scrollTop()+divLoc.top}, "fast");
				$(rc[nextIndex][1]).addClass('currentTarget'); //highlight the target
				if(nextIndex==rc.length-1)
					$('#userSerachResult').html('End');
				else
					$('#userSerachResult').html('');
			}
		}
	}
	else {
		//reset all highlight class
		$('.highlight-text').removeClass('highlight-text');
		$('.currentTarget').removeClass('currentTarget');
	}
}

function updateApproverComment(uid) {
	$.ajax({
		url:approverCommentsPath,
		type:"POST",
		data:'uid='+uid+'&comment='+$('.apcmmnt[data="'+uid+'"]').val(),
		beforeSend: function() {
			buildPopupMsg({
				"content": layoutTemplate.loadingPopup,
				"title": "Loading",
				"showOk": false,
				"position":"fixed",
				"closeByOverlay": false,
				"effect":false
			});
		},
		error: function() {
			unbindPopupMsgEvent();
			buildPopupMsg({
				"content":"Submit error. Please try again.",
				"showOk":true,
				"position":"fixed",
				"effect":false
			});
		},
		success: function(result) {
			if(result.hasError==false) {
				unbindPopupMsgEvent();
				buildPopupMsg({
					"title":"Success",
					"content":"Update successfully.",
					"showOk":true,
					"position":"fixed",
					"effect":false
				});
			}
			else {
				unbindPopupMsgEvent();
				buildPopupMsg({
					"content":"Submit error. Please try again.",
					"showOk":true,
					"position":"fixed",
					"position":"fixed",
					"effect":false
				});
			}
		}
	});
}

function initAdminRaty() {
	//init rating plugin
	$(".ffg-rating").raty({
		path: appConfig.ratyImgPath,
		cancel: true,
		cancelHint: 'Reset to 0',
		space: true,
		width: "150px",
		score:$('#form_ffgRating').val(),
		half:false,
		click: function(score,e) {
			updateAdminRating($(this).attr('data-id'),$('#form_ffgRating').val(),score);
		},
		mouseover: function(score,e) {
			if($(".ffg-rating").data('updatingVal')!=undefined) {
				$('#ffgRatingValue').html($(".ffg-rating").data('updatingVal'));
			}
			else
				$('#ffgRatingValue').html(score);
		},
		mouseout: function(score,e) {
			if($(".ffg-rating").data('updatingVal')!=undefined) {
				$('#ffgRatingValue').html($(".ffg-rating").data('updatingVal'));
			}
			else {
				if($('#form_ffgRating').val()==-1)
					$('#ffgRatingValue').html('Unrated');
				else
					$('#ffgRatingValue').html($('#form_ffgRating').val());
			}
		}
	});
}

function showAdminRatingPopup(uid) {
	buildPopup({
		"url":adminRatingPath+'?uid='+uid
	},function() {
		initAdminRaty();
	});
}

function updateAdminRating(uid,oldScore,score) {
	if(score == null)
		score = 0;
	var target=$(this).attr('id');
	$("#ffgRatingValue").html(score);
	//$('[name="ffgRating"]').val(score); //set the value to the hidden area
	$.ajax({
		url:adminRatingPath,
		type:"POST",
		data:'uid='+uid+'&score='+score,
		beforeSend: function() {
			$('#ffgRatingValue').css('color','#C30');
			$('.ffg-rating-spinner').show();
			$(".ffg-rating").data('updatingVal',score); //add updating value
		},
		error: function() {
			$('#ffgRatingValue').removeAttr('style');
			$('.ffg-rating-spinner').hide();
			$(".ffg-rating").removeData('updatingVal'); //reset updating value
			buildPopupMsg({
				"content":"Submit error. Please try again.",
				"showOk":true,
				"position":"fixed",
				"effect":false
			});
		},
		success: function(result) {
			$('#ffgRatingValue').removeAttr('style');
			$('.ffg-rating-spinner').hide();
			$(".ffg-rating").removeData('updatingVal'); //reset updating value
			if(result.hasError==false) {
				$('[name="ffgRating"]').val(score); //update the input value
				$('#ffgRatingValue').html(score);
				//Update the value in boards approval
				$('.ffg-rating-panel-value[data-id="'+uid+'"]').html(score);
			}
			else {
				$('#ffgRating').raty('score',oldScore);
				if(oldScore==-1)
					$('#ffgRatingValue').html('Unrated');
				else
					$('#ffgRatingValue').html(oldScore);
				buildPopupMsg({
					"content":result.errorDescription,
					"showOk":true,
					"position":"fixed",
					"position":"fixed",
					"effect":true
				});
			}
		}
	});
}

function retrieveExamplesImgs(uid) {
	var userType=$('.membershipLevelSelect[data="'+uid+'"] tr:eq(2) td').html(),
		regStatus=$('.regStatus[data="'+uid+'"]').html(),
		content='';
	if(userType=='Designer' && (regStatus=='Registration Confirmed' || regStatus=='Sample boards submission completed' || regStatus=='Example board submission completed')) {
		$.ajax({
			url: viewBoardApprovalPath+'?mode=samples&pmp=all&did='+uid,
			type:'GET',
			beforeSend:function() {
				if($('#userDetail .examples-area').length<=0)
					$('#userDetail').prepend('<div>Examples</div><div class="examples-area">Loading...</div>');
				else
					$('#userDetail .examples-area').html('Loading...');
			},
			error: function() {
				content='Service unavailable. Please click examples to reload again.';
				$('#userDetail .examples-area').html(content);
			},
			success: function(result) {
				var exps=$('.viewBigImage',result);
				var sourceFiles=$('.error-file',result);
				if(exps.length<=0)
					content='Cannot find examples';
				else {
					for(var i=0;i< exps.length;i++) {
						content+='<div style="display:table-cell">'+exps[i].outerHTML+'<a href='+$(sourceFiles[i]).attr('href')+' target="_BLANK" style="display:block;">Processed File?</a></div>';
					}
				}
				$('#userDetail .examples-area').html(content);
			}
		});
	}
}