<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose >
	<c:when test="${isSecQsMatched eq 'true'}">
		<form action="${pageContext.request.contextPath}/user/resetpwd" method="post" id="reset_password"> 
		<%-- <form:form modelAttribute="resetPwdForm" method="post" id="reset_password"> --%> 
			<p>Now you can reset your Password</p>
			<label id="label_new_pwd">New Password:</label>
			<br/>
			<form:password path="resetPwdForm.newPwd" id="newPwd" cssClass="textField" cssStyle="width: 80%"  /><br />
			<label id="label_confirm_pwd" >Confirm Password:</label>
			<br />
			<form:password path="resetPwdForm.confirmPwd" id="confirmPwd" cssClass="textField"  cssStyle="width: 80%" /><br />
			<div class="buttonPanel">
				<div class="button" id="resetPwd">Submit</div>
				<div class="button" id="close">Cancel</div>
			</div>
		<%-- </form:form> --%>
		</form>
	</c:when>
	<c:otherwise>
		<!---Panel for asking security answer--->
		<span style="color:#FF0000">Sorry, your response not matched with our records.</span>
		<div class="buttonPanel">
			<div class="button" id="close">Ok</div>
		</div>
	</c:otherwise>
</c:choose>
