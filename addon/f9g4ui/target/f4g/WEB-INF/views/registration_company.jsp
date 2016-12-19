<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="com.f9g4.web.utils.ViewPaths" %>
 
<script type="text/javascript">
	//var uploaderPath="${pageContext.request.contextPath}"+'/uploadPictures;jsessionid=${sessionId}';
	var uploaderPath="${pageContext.request.contextPath}"+'/uploadPictures';
	var uploadPicturesPath="${pageContext.request.contextPath}"+"<%= ViewPaths.UPLOAD_JPG%>";
	var loginPage = "${pageContext.request.contextPath}"+"<%= ViewPaths.LOGIN %>";
	var ResgistrationTermsPath="${pageContext.request.contextPath}"+'<%= ViewPaths.CUSTOMER_REGISTRATION_TERMS%>';
	$(document).ready(function()
	{
		//logging("initialize multiselect plugin");
		var size7=
		{
			size: 7, 
			addText: '', 
			toggleAddButton: false	
		};
		$("#form_languages").multiselect(size7);
	});
</script>

<!---Main---------------------------------------------------------------->
<div class="regContainer" id="container">
	<!---Content------------------>
	<div class="contentFrame">
		<form:form method="post" modelAttribute="registrationForm" id="form_reg_company">
			<input type="hidden" id="comp" name="comp" value=true />
			<div class="regPanel">
				<div class="row">
					<div class="column half orangeText">
						<spring:message code="registration.form.fileds_req_msg" />
					</div>
					<div class="column half redText">
						<!---Put Error Message here------>
					</div>
				</div>
			</div>
			<div class="row separateLine">
				<!---Left part------------------------------------------------->
				<div class="column oneThird">
					<div class="row separateLine header">
						<spring:message code="registration.form.section.secure.title" />
					</div>
					<div class="row space">
						<div class="label" id="label_username"><spring:message code="registration.form.section.secure.username" /></div>
						<br />
						<span style="color:#c30;">(Valid email address)</span>
						<br />
						<!-- <input name="username" id="form_username" type="text" class="width_controller"/> -->
						<form:input path="userName" id="form_username" cssClass="width_controller" maxlength="60" />
					</div>
					<div class="row" id="passwordField">
						<div class="label" id="label_password"><spring:message code="registration.form.section.secure.password" /></div>
						<!---<span style="color:#C30;font-size:10px">(Must be contain at least 7 Alplanumeric val characters)</span>--->
						<c:if test="${adminMode == true}">
							&nbsp;&nbsp;&nbsp;
							<input type="checkbox" name="isTempPassword_noused" id="temp_password_noused" checked="checked" disabled="disabled">It is temporary password</input>
							<input type="hidden" name="isTempPassword" id="temp_password" value="1" />
						</c:if>
						<br />
						<span style="color:#c30;">(Should contain at least 1 capital, number, and special character.)</span>
						<br />
						<!-- <input name="password" id="form_password" type="password" class="width_controller"/> -->
						<c:choose>
							<c:when test="${adminMode == true}">
								<input type="password" name="password_noused" class="width_controller" maxlength="125" value="${tempPassword}" disabled="disabled"/>
								<form:hidden path="password" id="form_password" cssClass="width_controller" maxlength="125" value="${tempPassword}"/>
							</c:when>
							<c:otherwise>
								<form:password path="password" id="form_password" cssClass="width_controller" maxlength="125" value="${tempPassword}"/>
							</c:otherwise>
						</c:choose>
						<br />
						<span id="result"></span>
					</div>
					<div class="row">
						<div class="label" id="label_confirm"><spring:message code="registration.form.section.secure.confirm_password" /></div>
						<br />
						<!-- <input name="confirm" id="form_confirm" type="password" class="width_controller"/> -->
						<c:choose>
							<c:when test="${adminMode == true}">
								<input type="password" name="confirmPassword_noused" class="width_controller" maxlength="125" value="${tempPassword}" disabled="disabled"/>
								<form:hidden path="confirmPassword" id="form_confirm" cssClass="width_controller" maxlength="125" value="${tempPassword}"/>
							</c:when>
							<c:otherwise>
								<form:password path="confirmPassword" id="form_confirm" cssClass="width_controller" maxlength="125" value="${tempPassword}"/>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="line"></div>
					<div class="row space">
						<div class="banner">
                			<div class="bannerLogo" id="user_logo"><i></i><img src="/images/avatar_default.jpg" /></div>
               		 		<div class="link"><a href="javascript:void(0)" id="upload_image"><spring:message code="registration.header.uploadImg" /></a></div>
            			</div>
					</div>
					<div class="line"></div>
					<div class="row space">
						<spring:message code="registration.form.section.forgot_pwd.msg1" />
					</div>
					<div class="row">
						<spring:message code="registration.form.section.forgot_pwd.q1" />
						<br />
						<c:choose>
							<c:when test="${adminMode == true}">
								<form:select path="securityQ1" items="${securityQestions1_List}" itemValue="lookupValueId" itemLabel="description" cssClass="dropdown" disabled="true"/>
								<br />
								<div class="label" id="label_ans_q1"><spring:message code="registration.form.section.forgot_pwd.a1" /></div>
								<br />
								<!-- <input name="ans_q1" id="form_ans_q1" type="text" class="width_controller"/> -->
								<input type="password" name="securityQ1Value_noused" class="width_controller" maxlength="125" disabled="disabled"/>
								<input type="hidden" name="securityQ1Value" id="form_ans_q1" value="Temp" />
							</c:when>
							<c:otherwise>
								<form:select path="securityQ1" items="${securityQestions1_List}" itemValue="lookupValueId" itemLabel="description" cssClass="dropdown" />
								<br />
								<div class="label" id="label_ans_q1"><spring:message code="registration.form.section.forgot_pwd.a1" /></div>
								<br />
								<!-- <input name="ans_q1" id="form_ans_q1" type="text" class="width_controller"/> -->
								<form:input path="securityQ1Value" id="form_ans_q1" cssClass="width_controller" maxlength="125"/>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="row space">
						<spring:message code="registration.form.section.forgot_pwd.q2" />
						<br />
						<c:choose>
							<c:when test="${adminMode == true}">
								<form:select path="securityQ2" items="${securityQestions2_List}" itemValue="lookupValueId" itemLabel="description" cssClass="dropdown" disabled="true" />
								<br />
								<div class="label" id="label_ans_q2"><spring:message code="registration.form.section.forgot_pwd.a2" /></div>
								<br />
								<!-- <input name="ans_q2" id="form_ans_q2" type="text" class="width_controller"/> -->
								<input type="password" name="securityQ2Value_noused" class="width_controller" maxlength="125" disabled="disabled"/>
								<input type="hidden" name="securityQ2Value" id="form_ans_q2" value="Temp" />
							</c:when>
							<c:otherwise>
								<form:select path="securityQ2" items="${securityQestions2_List}" itemValue="lookupValueId" itemLabel="description" cssClass="dropdown" />
								<br />
								<div class="label" id="label_ans_q2"><spring:message code="registration.form.section.forgot_pwd.a2" /></div>
								<br />
								<!-- <input name="ans_q2" id="form_ans_q2" type="text" class="width_controller"/> -->
								<form:input path="securityQ2Value" id="form_ans_q2" cssClass="width_controller" maxlength="125"/>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<!---end of Left part------------------------------------------------->
				<!---Middle part------------------------------------------------->
				<div class="column oneThird">
					<div class="row separateLine header">
						<spring:message code="registration.form.section.your_info.title" />
					</div>
					<div class="row space">
						<div class="label" id="label_firstname"><spring:message code="registration.form.section.your_info.first_name" /></div>
						<br />
						<form:input path="firstName" id="form_first_name" cssClass="width_controller" maxlength="60"/>
					</div>
					<div class="row">
						<div class="label" id="label_lastname"><spring:message code="registration.form.section.your_info.last_name" /></div>
						<br />
						<form:input path="lastName" id="form_last_name" cssClass="width_controller" maxlength="60"/>
					</div>
					<div class="row">
						<div class="label" id="label_cell_phone">
							<spring:message	code="registration.form.section.your_info.cell_phone_num" />
						</div>
						<br />
						<!-- <input name="cell_phone" id="form_cell_phone" type="text" class="width_controller"/> -->
						<form:input path="cell" id="form_cell_phone" cssClass="width_controller phoneChecking" maxlength="13"/>
					</div>
					<div class="row">
						<div class="label" id="label_languages"><spring:message code="registration.form.section.your_info.languages" /></div>
						<br />
						<form:select path="langs" id="form_languages" multiple="true" cssClass="dropdown">
							<c:forEach var="item" items="${languagesList}">
									<c:choose>
										<c:when
											test="${item.lookupCode == 'en2'}">
											<form:option selected="true" value="${item.lookupValueId}">
												<c:out value="${item.description}" />
											</form:option>
										</c:when>
										<c:otherwise>
											<form:option value="${item.lookupValueId}">
												<c:out value="${item.description}" />
											</form:option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</form:select>
					</div>
				</div>
				<!---end of Middle part------------------------------------------------->
				<!---Right part------------------------------------------------->
				<div class="column oneThird">
					<div class="row separateLine header">
						<spring:message
							code="registration.form.section.company_info.title" />
					</div>
					<div class="row space">
						<div class="label" id="label_company_name">
							<spring:message	code="registration.form.section.company_info.name" />
						</div>
						<br />
						<!-- <input name="company_name" id="form_company_name" type="text" class="width_controller"/> -->
						<form:input path="companyName" id="form_company_name" cssClass="width_controller" maxlength="125"/>
					</div>
					<div class="row">
						<div class="label" id="label_address_1">
							<spring:message code="registration.form.section.company_info.street_add_1" />
						</div>
						<br />
						<!-- <input name="address_1" id="form_address_1" type="text" class="width_controller"/> -->
						<form:input path="street1" id="form_address_1" cssClass="width_controller" maxlength="125"/>
					</div>
					<div class="row">
						<spring:message
							code="registration.form.section.company_info.street_add_2" />
						<br />
						<!-- <input name="address_2" id="form_address_2" type="text" class="width_controller"/> -->
						<form:input path="street2" id="form_address_2" cssClass="width_controller" maxlength="125"/>
					</div>
					<div class="row">
						<div class="column threeFifth">
							<div class="label" id="label_city">
								<spring:message code="registration.form.section.company_info.city" />
							</div>
							<br />
							<!-- <input name="city" id="form_city" type="text" class="width_controller"/> -->
							<form:input path="city" id="form_city" cssClass="width_controller" maxlength="60"/>
						</div>
						<div class="column thirtyPercent">
							<div class="label" id="label_state">
								<spring:message code="registration.form.section.company_info.state" />
							</div>
							<br />
							<form:select path="state" id="form_state" cssClass="dropdown" > 
								<!-- <form:option value="0" lable="Select" /> -->
								<c:forEach var="item" items="${statesList}">
									<c:choose>
										<c:when
											test="${registrationForm.state == item.lookupValueId}">
											<form:option selected="true" value="${item.lookupValueId}">
												<c:out value="${item.description}" />
											</form:option>
										</c:when>
										<c:otherwise>
											<form:option value="${item.lookupValueId}">
												<c:out value="${item.description}" />
											</form:option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="label" id="label_zipcode">Zip</div>
						<br/>
						<form:input path="zip" id="form_zip" cssClass="width_controller" maxlength="10"/>
					</div>
					<div class="row">
						<div class="label" id="label_country">
							<spring:message	code="registration.form.section.company_info.country" />
						</div>
						<br />
						<!-- <input name="country" id="form_country" type="text" class="width_controller"/> -->
						<!--<form:input path="country" id="form_country"
							cssClass="width_controller" />-->
							
							<form:select path="country" id="form_country" multiple="false" cssClass="dropdown">
                   				<c:forEach var="item" items="${countriesList}">
									<c:choose>
										<c:when
											test="${item.lookupCode == 'US1'}">
											<form:option selected="true" value="${item.lookupValueId}">
												<c:out value="${item.description}" />
											</form:option>
										</c:when>
										<c:otherwise>
											<form:option value="${item.lookupValueId}">
												<c:out value="${item.description}" />
											</form:option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
                   			</form:select>    	
					</div>
					<div class="row space">
					<div class="label" id="label_website">
						<spring:message code="registration.form.section.company_info.website" />
					</div>
						<br />
						<form:input path="website" id="form_website" cssClass="width_controller" maxlength="125"/>
					</div>
					<div class="row">
						<div class="column threeFifth">
							<div class="label" id="label_phone">
								<spring:message code="registration.form.section.company_info.phone_num" />
							</div>
							<br />
							<!-- <input name="phone" id="form_phone" type="text" class="width_controller"/> -->
							<form:input path="workPhone" id="form_phone" cssClass="width_controller phoneChecking" maxlength="13"/>
						</div>
						<div class="column thirtyPercent">
								<spring:message code="registration.form.section.company_info.ext" />
							<br />
							<!-- <input name="ext" id="form_ext" type="text" class="width_controller"/> -->
							<form:input path="ext" id="form_ext" cssClass="width_controller" maxlength="5" />
						</div>
					</div>
					<div class="row">
						<div class="label" id="label_fax">
							<spring:message code="registration.form.section.company_info.fax" />
						</div>
						<br />
						<!-- <input name="fax" id="form_fax" type="text" class="width_controller"/> -->
						<form:input path="fax" id="form_fax" cssClass="width_controller phoneChecking" maxlength="13" />
					</div>
					<div class="row space">
						<div id="regCheck" disabled="disabled" class="checkbox"></div>
						<input type="hidden" name="termsAccepted" id="form_terms" />
						<!-- <input name="terms" id="form_terms" type="checkbox" value="" disabled="disabled"/> -->
						<%-- <form:checkbox path="termsAccepted" id="form_terms" disabled="disabled" /> --%>
						<a href="#" id="read_terms"><spring:message code="registration.form.read_terms.link" /></a>
					</div>
				</div>
				<!---end of Right part------------------------------------------------->
			</div>
			<form:hidden path="acceptedTermsId" id="form_accepted_termsId" />
			<form:hidden path="logoImageUrl" id="form_logo_image_url" value="/images/avatar_default.jpg" />
		</form:form>
	</div>
</div>
<div class="regButtons">
   	Please review information then click save
   	<div class="button" id="save">Save</div>
   	<div class="orangeButton" id="cancel">Clear</div>
</div>
<!---end of content----------->
<!---end of main---------------------------------------------------------->