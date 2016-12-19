<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Detect mobile browser, redirect to mobile version if mobile device detected --%>
<c:if test="${param.v!='nodetect'}">
	<script type="text/javascript">
		if(jQuery.browser.mobile) {
			location.assign(location.href.replace(/(\?|$)/,'?v=mobile&').replace(/&$/,""));
		}
	</script>
</c:if>
<script type="text/javascript">
	//var uploaderPath="${pageContext.request.contextPath}"+'/uploadPictures;jsessionid=${sessionId}';
	var uploaderPath="${pageContext.request.contextPath}"+'/uploadPictures';
	var uploadPicturesPath="${pageContext.request.contextPath}"+"<%= ViewPaths.UPLOAD_JPG%>";
	var loginPage = "${pageContext.request.contextPath}"+"<%= ViewPaths.LOGIN %>";
	var designerMemTerms = "${pageContext.request.contextPath}" + "<%= ViewPaths.DESIGNER_REGISTRATION_TERMS %>";
	var membershipUrl  = "${pageContext.request.contextPath}" + "<%= ViewPaths.MEMBERSHIP_PAY %>";
	var ResgistrationTermsPath="${pageContext.request.contextPath}"+'<%= ViewPaths.DESIGNER_REGISTRATION_TERMS_BASIC%>';
	$(document).ready(function() {
		//logging("initialize multiselect plugin");
		var size4= {
			filter: true,
			maxHeight: 150,
			width: 244,
			placeholder: "Please select"
		};
		$("#form_languages").multipleSelect(size4);
		$("#form_skills").multipleSelect(size4);
	});
</script>
<spring:message code="registration.hint.firstname" var="firstnameHint"/>
<spring:message code="registration.hint.username" var="usernameHint"/>
<spring:message code="registration.hint.pwd" var="pwdHint"/>
<spring:message code="registration.hint.lastname" var="lastnameHint"/>
<spring:message code="registration.hint.mobilephone" var="mobileHint"/>
<spring:message code="registration.hint.confirmpwd" var="confirmPwdHint"/>
<!---Main---------------------------------------------------------------->
<div class="designerContainer" id="container">
    <!---Content------------------>
	<div class="contentFrame">
		<form:form method="post" modelAttribute="registrationForm" id="form_reg_designer" >
			<div class="regPanel">
				<!-- We could put some text here. -->
				<%-- <div class="row">
					<div class="column half orangeText">
						<spring:message code="registration.form.fileds_req_msg" />
					</div>
					<div class="column half redText">
						<!---Put Error Message here------>
						<div id="errorContainer" >
						</div>
					</div>
				</div> --%>
			</div>
			<div class="row form-holder">
				<div class="form-holder-title">Designer Sign Up<!-- &nbsp;/&nbsp;Retailer Sign Up --></div>
				<div class="form-holder-sub-title">For Retailer/Buyer sign up, please call us at 1-800-550-0802</div>
				<div class="form-holder-content">
				<%-- <div class="form-holder-adj">
					<!-- <div class="button" style="background-color:#3b5998; border:0px; line-height: 20px;">
						<img src="http://static.ak.fbcdn.net/rsrc.php/v2/yE/r/pO2d5bFWS8j.png" width="20" height="20" />
						<span style="line-height: 20px;">Sign Up With Facebook</span>
					</div> -->
					<div class="fb-login-button" data-max-rows="1" data-size="large" data-show-faces="false" data-auto-logout-link="false" data-scope="email"></div>
				</div>
				<div class="form-holder-adj">
					<a href="javascript:void(0);" class="button" id="bLinkedIn">Sign In With Linked In</a>
					<script type="in/Login">
						Hello, <?js= firstName ?> <?js= lastName ?>.
					</script>
				</div> --%>
				<!---Left part------------------------------------------------->
				<div class="column form-holder-content-left">
					<%-- <div class="row separateLine header">
						<spring:message code="registration.form.section.secure.title" />
					</div> --%>
					<div class="row">
						<div class="label" id="label_firstname"><spring:message code="registration.form.section.your_info.first_name" />&nbsp;<span class="require_field">*</span></div>
						<form:input path="firstName" id="form_first_name" cssClass="width_controller tip-left" maxlength="60" tabindex="1" title="${firstnameHint}" />
					</div>
					<div class="row">
						<div class="label" id="label_username"><spring:message code="registration.form.section.secure.username" />&nbsp;<span class="require_field">*</span></div>
						<!-- <input name="username" id="form_username" type="text" class="width_controller"/> -->
						<form:input path="userName" id="form_username" cssClass="width_controller tip-left tip-html" maxlength="200" tabindex="3" title="${usernameHint}"/><div id="usernameChecked" class="invalid hide"></div>
						<div class="username-check-result hide" id="usernameCheckedMsg"></div>
					</div>
					<div class="row" id="passwordField">
						<div class="label" id="label_password"><spring:message code="registration.form.section.secure.password" />&nbsp;<span class="require_field">*</span></div>
						<!---<span style="color:#C30;font-size:10px">(Must be contain at least 7 Alplanumeric val characters)</span>--->
						<!-- <input name="password" id="form_password" type="password" class="width_controller"/> -->
						<form:password path="password" id="form_password" cssClass="width_controller tip-left tip-html" maxlength="125" tabindex="5" title="${pwdHint}"/>
						<div id="result" class="init">${pwdHint}</div>
					</div>
					<%-- <div class="line"></div>
					<div class="row space">
						<div class="banner">
                			<div class="bannerLogo" id="user_logo"><i></i><img src="/images/avatar_default.jpg" /></div>
               		 		<div class="link"><a href="javascript:void(0)" id="upload_image"><spring:message code="registration.header.uploadImg" /></a></div>
            			</div>
					</div> --%>
					<%-- <div class="line"></div>
					<div class="row space">
						<spring:message code="registration.form.section.forgot_pwd.msg1" />
					</div>
					<div class="row">
						<div class="label" id="label_q1"><spring:message code="registration.form.section.forgot_pwd.q1" /></div>
						<br />
						<form:select path="securityQ1" items="${securityQestions1_List}" itemValue="lookupValueId" itemLabel="description" cssClass="dropdown" />
						<br />
						<div class="label" id="label_ans_q1"><spring:message code="registration.form.section.forgot_pwd.a1" /></div>&nbsp;<span class="require_field">*</span>
						<br />
						<!-- <input name="ans_q1" id="form_ans_q1" type="text" class="width_controller"/> -->
						<form:input path="securityQ1Value" id="form_ans_q1" cssClass="width_controller" maxlength="125" />
					</div>
					<div class="row space">
						<div class="label" id="label_q2"><spring:message code="registration.form.section.forgot_pwd.q2" /></div>
						<br />
						<form:select path="securityQ2" items="${securityQestions2_List}" itemValue="lookupValueId" itemLabel="description" cssClass="dropdown" />
						<br />
						<div class="label" id="label_ans_q2"><spring:message code="registration.form.section.forgot_pwd.a2" /></div>&nbsp;<span class="require_field">*</span>
						<br />
						<!-- <input name="ans_q2" id="form_ans_q2" type="text" class="width_controller"/> -->
						<form:input path="securityQ2Value" id="form_ans_q2" cssClass="width_controller" maxlength="125"/>
					</div> --%>
				</div>
				<!---end of Left part------------------------------------------------->
				<!---Middle part------------------------------------------------->
				<div class="column">
					<%-- <div class="row separateLine header">
						<spring:message code="registration.form.section.your_info.title" />
					</div> --%>
					<div class="row">
						<div class="label" id="label_lastname"><spring:message code="registration.form.section.your_info.last_name" />&nbsp;<span class="require_field">*</span></div>
						<form:input path="lastName" id="form_last_name" cssClass="width_controller tip-right" maxlength="60" tabindex="2" title="${lastnameHint}" />
					</div>
					<div class="row">
               			<div class="label" id="label_cell_phone"><spring:message code="registration.form.section.your_info.cell_phone_num"/></div><!-- &nbsp;<span class="require_field">*</span> -->
                   		<!-- <input name="cell_phone" id="form_cell_phone" type="text" class="width_controller"/> -->
                   		<form:input path="cell" id="form_cell_phone"  cssClass="width_controller tip-right phoneChecking" maxlength="13" tabindex="4" title="${mobileHint}" />
                   		<div class="username-check-result hide"></div>
               		</div>
               		<div class="row" id="confirmedPasswordField">
						<div class="label" id="label_confirm"><spring:message code="registration.form.section.secure.confirm_password" />&nbsp;<span class="require_field">*</span></div>
						<!-- <input name="confirm" id="form_confirm" type="password" class="width_controller"/> -->
						<form:password path="confirmPassword" id="form_confirm" cssClass="width_controller tip-right" maxlength="125" tabindex="6" title="${confirmPwdHint}" />
						<div id="confirmPwdHint" class="init hide"><!-- Should match your password --></div>
					</div>
               		<%-- 
               		<div class="row">
               			<div class="label" id="label_address_1"><spring:message code="registration.form.section.your_info.street_1" /></div>&nbsp;<span class="require_field">*</span>
                   		<br />
                     	<!-- <input name="address_1" id="form_address_1" type="text" class="width_controller"/> -->
						<form:input path="street1" id="form_address_1" cssClass="width_controller" maxlength="125"/>
               		</div>
               		<div class="row">
               			<div class="label" id="label_address_2"><spring:message code="registration.form.section.your_info.street_2" /></div>
                   		<br />
                   		<!-- <input name="address_2" id="form_address_2" type="text" class="width_controller"/> -->
                   		<form:input path="street2" id="form_address_2" cssClass="width_controller" maxlength="125"/>
               		</div>
               		<div class="row">
		               	<div class="column half">	
		               		<div class="label" id="label_city"><spring:message code="registration.form.section.your_info.city" /></div>&nbsp;<span class="require_field">*</span>
                    		<br />
                    		<!-- <input name="city" id="form_city" type="text" class="width_controller"/> -->
                    		<form:input path="city" id="form_city" cssClass="width_controller" maxlength="60"/>
                    	</div>
                    	<div class="column half">
                    		<div class="label" id="label_state"><spring:message code="registration.form.section.your_info.state" /></div>&nbsp;<span class="require_field">*</span>
                        	<br />
                    		<form:select path="state" id="form_state" cssClass="dropdown">
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
               		--%>
               		<%--
               		<div class="row">
               			<div class="column oneThird">
							<div class="label" id="label_zipcode"><spring:message code="registration.form.section.your_info.zip" /></div>&nbsp;<span class="require_field">*</span>
                       		<br />
                       		<!-- <input name="zipcode" id="form_zipcode" type="text" class="width_controller"/> -->
                       		<form:input path="zip" id="form_zipcode" cssClass="width_controller" maxlength="5"/>
                   		</div>
                   		<div class="column twoThird">          		
                   			<div class="label" id="label_country"><spring:message code="registration.form.section.your_info.country"/></div>&nbsp;<span class="require_field">*</span>
                   			<br />
                   			<!-- <input name="country" type="text" class="width_controller" id="form_country"/> -->
                   			<!-- <form:input path="country" id="form_country" cssClass="width_controller" /> -->
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
               		</div>
               		--%>
               		<%-- 
               		<div class="row">
               			<div class="column threeFifth">
               				<div class="label" id="label_work_phone"><spring:message code="registration.form.section.your_info.work_phone" /></div>&nbsp;<span class="require_field">*</span>
                   			<br />
                   			<!-- <input name="work_phone" id="form_work_phone" type="text" class="width_controller" /> -->
                   			<form:input path="workPhone" id="form_work_phone"  cssClass="width_controller" />
                   		</div>
                   		<div class="column thirtyPercent">
                   			<spring:message code="registration.form.section.your_info.work_phone_ext" />
                       		<br />
                       		<!-- <input name="ext" id="form_ext" type="text" class="width_controller"/> -->
                       		<form:input path="ext1" id="form_ext"  cssClass="width_controller" />
                   		</div>
               		</div> 
               		--%>
               		<%-- 
					<div class="row">
						<div class="label" id="label_languages"><spring:message code="registration.form.section.your_info.languages" /></div>&nbsp;<span class="require_field">*</span>
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
					--%>
				</div>
				<%-- <div class="row terms">
					<div class="label">Additional document:&nbsp;<span id="file_result"></span></div>
					<div class="button" id="upload_doc">Upload</div>
					<input type="hidden" name="adoc_oname" id="adoc_oname" />
					<input type="hidden" name="adoc_type" id="adoc_type" />
					<input type="hidden" name="adoc_iname" id="adoc_iname" />
				</div> --%>
				<div class="row terms">
					<div class="label" id="label_hdyhau"><spring:message code="registration.form.section.your_info.how_did_you_hear_about_us" /></div>
					<textarea name="howDidYouHearAboutUs" id="form_hdyhau" tabindex="7" maxlength="2000">${schoolName}</textarea>
				</div>
				<div class="row terms">
					<!-- <input name="terms" id="form_terms" type="checkbox" value="" disabled="disabled"> -->
					<div id="regCheck" class="checkbox" tabindex="8"></div>
					<input type="hidden" name="termsAccepted" id="form_terms" />
					<form:hidden path="acceptedTermsId" id="form_accepted_termsId" value="${termsId}" />
					<form:hidden path="logoImageUrl" id="form_logo_image_url" value="/images/avatar_default.jpg" />
					<%-- <form:checkbox path="termsAccepted" id="form_terms" disabled="true" /> --%>
					<spring:message code="registration.form.read_terms" />&nbsp;<a href="#" id="read_terms"><spring:message code="registration.form.read_terms.link" /></a>
					<div class="row orangeText" style="margin-bottom:0px;">
						<spring:message code="registration.form.fileds_req_msg" />
					</div>
				</div>
				</div>
				<!---end of Middle part------------------------------------------------->
				<%--
				<!---Right part------------------------------------------------->
				<div class="column oneThird" style="width:320px;">
					<div class="row separateLine header">
						<spring:message code="registration.form.section.your_brand.title" />
					</div>
					<div class="row space">
               			<spring:message code="registration.form.section.your_brand.about_you" />&nbsp;&nbsp;<span style="color:#C30;">(1000 characters long)</span>
                   		<br>
                   		<form:textarea path="aboutYou" id="form_about_you" cols="32" rows="4" cssClass="nonresizeable" maxlength="1000"/>
               		</div>
					<div class="row">
						<div class="label" id="label_company_name"><spring:message code="registration.form.section.your_brand.comp_name" /></div>&nbsp;<span class="require_field">*</span>
						<br />
						<!-- <input name="company_name" id="form_company_name" type="text" class="width_controller"/> -->
						<form:input path="companyName" id="form_company_name" cssClass="width_controller" maxlength="125"/>
					</div>
					<div class="row">
						<spring:message code="registration.form.section.your_brand.website" />
						<br>
						<!-- <input name="website" id="form_website" type="text" class="width_controller"> -->
						<form:input path="website" id="form_website" cssClass="width_controller" maxlength="125"/>
					</div>
					<div class="row">
						<div class="column threeFifth">
						<div class="label" id="label_brand_work_phone"><spring:message code="registration.form.section.your_brand.work_phone" /></div>&nbsp;<span class="require_field">*</span>
						<br>
						<!-- <input name="brand_work_phone" id="form_brand_work_phone" type="text" class="width_controller"> -->
						<form:input path="workPhone" id="form_brand_work_phone" cssClass="width_controller phoneChecking" maxlength="13"/>
					</div>
					<div class="column thirtyPercent">
						<spring:message code="registration.form.section.your_brand.work_phone.ext" />
						<br>
						<!-- <input name="brand_ext" id="form_brand_ext" type="text" class="width_controller"> -->
						<form:input path="ext" id="form_brand_ext" cssClass="width_controller" maxlength="5"/>
					</div>
					</div>
					<div class="row">
						<div class="label" id="label_fax"><spring:message code="registration.form.section.your_brand.fax" /></div>&nbsp;
						<br>
						<!-- <input name="fax" id="form_fax" type="text" class="width_controller"> -->
						<form:input path="fax" id="form_fax" cssClass="width_controller phoneChecking" maxlength="13"/>
					</div>
					<div class="row">
						<div class="label" id="label_skills"><spring:message code="registration.form.section.your_brand.skills" /></div>&nbsp;<span class="require_field">*</span>
						<br>
						<form:select path="skills" id="form_skills" items="${skillsList}" itemValue="lookupValueId" itemLabel="description" multiple="true" cssClass="dropdown" />						
					</div>
					<div class="row">
               			<spring:message code="registration.form.section.your_brand.schools_awards" />
               			<br>
						<!-- <textarea name="misc" id="form_misc" cols="32" rows="4" class="nonresizeable"></textarea> -->
						<form:textarea path="schools" id="form_misc" cols="32" rows="4" cssClass="nonresizeable" maxlength="1000" />
					</div>
					<div class="row space">
						<input name="terms" id="form_terms" type="checkbox" value="" disabled="disabled"> 
						<form:hidden path="acceptedTermsId" id="form_accepted_termsId" />
						<form:hidden path="logoImageUrl" id="form_logo_image_url" value="/images/avatar_default.jpg" />
						<form:checkbox path="termsAccepted" id="form_terms" disabled="true" /><a href="#" id="read_terms"><spring:message code="registration.form.read_terms" /></a>
					</div>
				</div>
				<!---end of Right part------------------------------------------------->
				--%>
			</div>
		</form:form>
	</div>
</div>
<div class="regButtons">
	<c:if test="${!hasError}">
   		Please review information then click save
   		<div class="button" id="save">Save</div>
   	</c:if>
   	<div class="orangeButton" id="cancel">Clear</div>
</div>
<div  id="verification_content" style="display:none">
	<div class="popup">
		<div class="header">
			<spring:message code="registration.success.thank_you"/> 
		</div>
		<div class="content" id="thanks">
			<p>
				<spring:message code="registration.success.dear"/>&nbsp;&nbsp;<span id="designer_name">:</span>,
	    		<br><br>
				<spring:message code="registration.success.thank_you.line_1" />    
	    		<br>
	    		<spring:message code="registration.success.thank_you.line_2" />
	    		<input type="hidden" name="userId" value="" id="reg_userid">
    		</p>
    		<div class="button" id="register"><spring:message code="registration.success.button.ok" /></div>
		</div>
	</div>
</div>
<%-- <!-- FB root -->
<div id="fb-root"></div> --%>
<!---end of content----------->
<!---end of main---------------------------------------------------------->
<script type="text/javascript">
_gaq.push(['_trackPageview']);
</script>