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
			$('#q1_val').focus();
		}, 100);
		$("#q1_val").focus(function(){
		    // Select input field contents
		    this.select();
		});
	});
	
</script>
<!---set specific id to set  popup width-------->
<div class="popup" id="setup_seq_password" style="width:600px;"> 
	<div class="header">
	Set up your <c:if test="${setupSeq}">security setting</c:if> <c:if test="${setupPwd}">and password</c:if>
	    <div class="close">X</div>
	</div>
	<div class="content">
		<!---Panel for forget password--->
		<div id="setupSeqPasswordFormPanel">
			<form:form modelAttribute="seqPasswordForm" id="seqPasswordForm">
			Your security is very important to us. Please help by providing the below information.
			<br />
			<div class="notification" id="notify_security"></div>
			<c:if test="${setupSeq}">
				<br />
				Security Question 1
				<br />
				<form:select path="securityQ1" items="${securityQestions1_List}" itemValue="lookupValueId" itemLabel="description" />
				<br />
				<div class="label" id="label_ans_q1"><spring:message code="registration.form.section.forgot_pwd.a1" /></div>
				<form:input path="securityQ1Value" id="form_ans_q1" cssClass="width_controller" maxlength="125"/>
				<br />
				<br />
				Security Question 2
				<br />
				<form:select path="securityQ2" items="${securityQestions2_List}" itemValue="lookupValueId" itemLabel="description" />
				<br />
				<div class="label" id="label_ans_q2"><spring:message code="registration.form.section.forgot_pwd.a2" /></div>
				<form:input path="securityQ2Value" id="form_ans_q2" cssClass="width_controller" maxlength="125"/>
			</c:if>
			<c:if test="${setupPwd}">
				<br />
				<hr />
				Please enter <b>NEW</b> password
				<br />
				<span style="color:#c30;">(Password should contain at least 1 capital, number, special character, 8 characters.)</span>
				<br />
				<label id="label_resetPassword">New Password:</label>
				<br/>
				<form:password path="resetPassword" id="resetPassword" cssClass="textField" cssStyle="width: 50%"  />
				<br />
				<span id="result"></span>
				<br />
				<label id="label_confirmPassword">Confirm Password:</label>
				<br />
				<form:password path="confirmPassword" id="confirmPassword" cssClass="textField"  cssStyle="width: 50%" />
				<br />
			</c:if>
			<form:hidden path="userId" />
			<div class="buttonPanel">
				<div class="button" id="submitSeqPassword">Submit</div>
				<div class="button orangeButton" id="close">Cancel</div>
			</div>
			<%-- <form:form  modelAttribute="forgotPwd" id="forgotPwd" >
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
				
				<span>Please reset your password below</span>
				<br />
				<span style="color:#c30; font-size:10px;">(Password should contain at least 1 capital, number, and special character.)</span>
				<br />
				<br />
				<label>New Password:</label>
				<br/>
				<form:password path="resetPwdForm.newPwd" id="newPwd" cssClass="textField" cssStyle="width: 50%"  />
				<span id="result"></span>
				<br />
				<label>Confirm Password:</label>
				<br />
				<form:password path="resetPwdForm.confirmPwd" id="confirmPwd" cssClass="textField"  cssStyle="width: 50%" />
				<br />
				<div class="notification" id="notify_passw_mismatch"></div>
				<div class="buttonPanel">
					<div class="button" id="resetPwd">Submit</div>
					<div class="button orangeButton" id="close">Cancel</div>
				</div>
			</form:form> --%>
			</form:form>
		</div>
	</div>
</div>