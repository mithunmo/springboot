<script>
	$(document).ready(function() {
		$(document).off("click","#feedback_submit");
		$(document).on("click","#feedback_submit",function(e) {
			$.ajax({
				url:feedbackPath,
				type:'POST',
				data:$("#feedback_form").serialize(),
				beforeSend: function()
				{
					buildPopupMsg({
						"content": '<span style="color:blue;">Please wait....<span><br /><img src="/images/spinner_small.gif" style="margin-top:30px;"/>',
						"title": "Please Wait",
						"showOk": false,
						"closeByOverlay": false
					});
				},
				error: function(xhr,status,error)
				{
					closePopupMsg(function() {
						buildPopupMsg({
							"content": 'Sorry, our server is unavailable. Please try again. Thank you.',
							"title": "Error"
						});
					},{
						"closeOverlay":false
					});
				},
				success: function(result)
				{
					if(result.hasError){
						var errorInfo = new Array();
						//remove previous hightlight fields
						for(var i=0; i<result.errorDetail.length ; i++)
							errorInfo.push(result.errorDetail[i].defaultMessage);
						
						closePopupMsg(function() {
							buildPopupMsg({
								"content": '<span style="color:#C30;">'+errorInfo.join("<br/>")+'</span>',
								"title": "Errors occurred",
								"showOk": true
							});
						},{
							"closeOverlay":false
						});
					}
					else{
						closePopupMsg(function() {
							isChangedWithoutSubmitOnPopup=false; //reset the flag
							buildPopupMsg({
								"content": '<span style="color:blue;">Thank you,'+result.firstname+" "+result.lastname+'. We will review it and get back to you soon.</span>',
								"title": "Thank you",
								"showOk": true,
								"onClose":function() {
									closePopupMsg();
									closePopup();
								},
								"onOk":function() {
									closePopupMsg();
									closePopup();
								}
							});
						},{
							"closeOverlay":false
						});
					}
				}
			});
		});
	});
</script>
<!---set specific id to set  popup width-------->
<div class="popup" id="invitation"> 

<div class="header">
Feedback
    <div class="close">X</div>
</div>
<!---Set id to fill in data--->
<div class="content" id="popup_invitation">
	<div style="color:blue;">Please fill in the following information and we will get in touch with you. Thank you.</div>
	<form name="feedbackForm" id="feedback_form">
		<div class="invitation-left-panel">
			<span>FIRST NAME</span>
			<br />
			<input type="text" name="firstname" style="width:200px;" value="${user.firstname}" readonly="readonly"/>
			<br />
			<span>LAST NAME</span>
			<br />
			<input type="text" name="lastname" style="width:200px;" value="${user.lastname}" readonly="readonly"/>
			<br />
			<!-- <span>PHONE</span> -->
			<!-- <br /> -->
			<input type="hidden" name="phone" style="width:200px;"/>
		</div>
		<div class="invitation-right-panel">
			<span style="width:60px; display:inline-block;">E-MAIL</span>
			<br />
			<input type="text" name="email" style="width:350px;" value="${user.userName}" readonly="readonly"/>
			<span style="display:block;">Feedback</span>
			<textarea name="feedback" style="clear:both; width:350px; height:100px;"></textarea>
		</div>
	</form>
	<div class="buttonPanel" style="margin-top:10px; clear:both;">
		<div class="button center" id="feedback_submit">Submit</div>
	</div>
</div>
</div>