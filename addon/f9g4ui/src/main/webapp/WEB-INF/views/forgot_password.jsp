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
			$('#email').focus();
		}, 100);
		$("#email").focus(function(){
		    // Select input field contents
		    this.select();
		});
	});
</script>
<div class="content">
	<!---Panel for forget password--->
	<div class="forgetPanel" id="session_forget">
		Please Enter your email address 
		<br />
		<input name="" type="text" class="textField" id="email" style="width: 60%" />
		<br />
		<div class="notification" id="nofify_email"></div>
		<div class="buttonPanel">
			<div class="button" id="gotoSecurity">Submit</div>
		</div>
	</div>
	<!---Panel for asking security answer--->
	<div class="forgetPanel" id="session_security">
		For additional security please answer the following questions:
		<div class="notification" id="notify_security"></div>
		<br />
		<form:form  modelAttribute="forgotPwd" id="forgotPwd" >
			<form:hidden path="secQ1id" id="q1_id"  value=""  />
			<input type="text" id="q1_val" style="width: 100%" disabled="disabled" /><br /> 
			<form:input path="secQ1Ans" id="q1_ans" cssClass="textField"  cssStyle="width: 100%" /> <br />
			 
			<form:hidden path="secQ2id" id="q2_id"  value=""  />
			<input name="q2_val" type="text" id="q2_val" style="width: 100%" disabled="disabled" /><br /> 
			<form:input path="secQ2Ans" id="q2_ans" cssClass="textField" cssStyle="width: 100%" /> <br />
			<div class="notification" id="notify_questions"></div>
			<div class="buttonPanel">
				<div class="button" id="gotoResult">Submit</div>
				<div class="button orangeButton" id="close">Cancel</div>
			</div>
		</form:form>
	</div>
	<div class="forgetPanel" id="session_reset_password">
		<form action="${pageContext.request.contextPath}/user/resetpwd" method="post" id="reset_password"> 
				<span>Please reset your password below</span>
				<br />
				<span style="color:#c30;"><spring:message code="user.password.strength.hint" /></span>
				<br />
				<br />
				<label id="label_new_pwd">New Password:</label>
				<br/>
				<form:password path="resetPwdForm.newPwd" id="newPwd" cssClass="textField" cssStyle="width: 50%"  />
				<br />
				<span id="result"></span>
				<br />
				<label id="label_confirm_pwd">Confirm Password:</label>
				<br />
				<form:password path="resetPwdForm.confirmPwd" id="confirmPwd" cssClass="textField"  cssStyle="width: 50%" />
				<br />
				<div class="notification" id="notify_passw_mismatch"></div>
				<div class="buttonPanel">
					<div class="button" id="resetPwd">Submit</div>
					<div class="button orangeButton" id="close">Cancel</div>
				</div>
		</form>
	</div>
	<!---Panel for the result is success--->
	<div class="forgetPanel" id="reset_success">
		Your password has been reset successfully.
		<div class="buttonPanel">
			<div class="button" id="close" tabindex="0">Close</div>
		</div>
	</div>
	<!---Panel for the result is failed--->
	<div class="forgetPanel" id="reset_fail">
		Your passwords do not match. Please try again.
		<div class="buttonPanel">
			<div class="button" id="close">Close</div>
		</div>
	</div>
	<!---Panel for reset the user password successfully--->
	<div class="forgetPanel" id="reset_temp_password">
		<spring:message code="forgotpwd.reset.temppwd.successfully" />
		<div class="buttonPanel">
			<div class="button" id="close">Close</div>
		</div>
	</div>
	<!---Panel for reset the user password failed--->
	<div class="forgetPanel" id="reset_temp_password_failed">
		<spring:message code="forgotpwd.reset.temppwd.failed" />
		<div class="buttonPanel">
			<div class="button" id="close">Close</div>
		</div>
	</div>
	<!-- <div class="forgetPanel" id="reset_fail_Mismatch">
		<span style="color:#FF0000">Your passwords </span>
	</div> -->
</div>