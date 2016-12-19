<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	$(document).ready(function()
	{
		//set focus
		//focus on email field
		setTimeout(function () 
		{
			$('#currentPassword').focus();
		}, 100);
		$("#currentPassword").focus(function(){
		    // Select input field contents
		    this.select();
		});
	});
</script>
<!---set specific id to set  popup width-------->
<div class="popup" id="change_password_popup" style="width:550px;"> 
	<div class="header">
	CHANGE PASSWORD
	    <div class="close">X</div>
	</div>
	<div class="content">
		<!---Panel for forget password--->
		<div id="setupSeqPasswordFormPanel">
			<form:form modelAttribute="changePasswordForm" id="changePasswordForm">
			<label id="label_currentPassowrd">Please enter your current password:</label>
			<br />
			<form:password path="currentPassword" id="currentPassword" cssClass="textField" cssStyle="width: 50%"  />
			<!-- &nbsp;&nbsp;<a href="javascript:void(0)" id="forgot_password" style="color:blue">Forgot password?</a> -->
			<br />
			<label id="label_newPwd">New Password:</label>
			<br />
			<span style="color:#c30;"><spring:message code="user.password.strength.hint" /></span>
			<br/>
			<form:password path="newPwd" id="newPwd" cssClass="textField" cssStyle="width: 50%"  />
			<br />
			<span id="result"></span>
			<br />
			<label id="label_confirmPwd">Confirm Password:</label>
			<br />
			<form:password path="confirmPwd" id="confirmPwd" cssClass="textField"  cssStyle="width: 50%" />
			<br />
			<div class="buttonPanel">
				<div class="button" id="submitChangePassword">Submit</div>
				<div class="button orangeButton close" id="close">Cancel</div>
			</div>
			</form:form>
		</div>
	</div>
</div>