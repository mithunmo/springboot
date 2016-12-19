<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="title-wrapper"> <!-- Put banner here -->
	<div class="welcome-info" >
		<c:choose>
			<c:when test="${empty schoolBannerFile}">
				Welcome ${schoolName}!
			</c:when>
			<c:otherwise>
				<img src="/images/school_banner/${schoolBannerFile}" style="background-color: #000;" />
			</c:otherwise>
		</c:choose>
		<%-- Welcome Art Institute of California, Los Angeles!<img src="/images/school_banner/${schoolBannerCode}.gif" style="background-color: #000;" /> --%>
	</div>
	<div class="title">SO YOU WANT TO BE PART OF OUR TEAM?</div>
	<div class="subtitle">JUST FILL OUT THE FOLLOWING INFORMATION TO GET STARTED.</div>
</div>
<div class="content">
	<form method="post" id="form_reg_designer" action="/f4g/register/designer">
		<div class="row">
			<div class="row-left" id="label_firstname"><spring:message code="registration.form.section.your_info.first_name" /></div><div class="row-right">
				<input name="firstName" id="form_first_name" type="text" tabindex="1" maxlength="60" placeholder="<spring:message code="registration.form.section.your_info.first_name" />" />
			</div>
		</div>
		<div class="row">
			<div class="row-left" id="label_lastname"><spring:message code="registration.form.section.your_info.last_name" /></div><div class="row-right">
				<input name="lastName" id="form_last_name" type="text" tabindex="2" maxlength="60" placeholder="<spring:message code="registration.form.section.your_info.last_name" />" />
			</div>
		</div>
		<div class="row">
			<div class="row-left" id="label_username">EMAIL ADDRESS</div><div class="row-right">
				<input name="userName" id="form_username" type="text" tabindex="3" maxlength="200" placeholder="EMAIL ADDRESS" />
			</div>
		</div>
		<div class="row bind hide" id="usernameRow">
			<div class="row-left"></div><div class="row-right">
				<div id="usernameChecked" class="invalid hide"></div><div class="username-check-result hide" id="usernameCheckedMsg"></div>
			</div>
		</div>
		<div class="row">
			<div class="row-left" id="label_password"><spring:message code="registration.form.section.secure.password" /></div><div class="row-right">
				<input name="password" id="form_password" type="password" tabindex="4" maxlength="125" placeholder="<spring:message code="registration.form.section.secure.password" />" />
			</div>
		</div>
		<div class="row bind hide" id="passwordRow">
			<div class="row-left"></div><div class="row-right">
				<span class="" id="result"><spring:message code="registration.hint.pwd" /></span>
			</div>
		</div>
		<div class="row">
			<div class="row-left" id="label_confirm"><spring:message code="registration.form.section.secure.confirm_password" /></div><div class="row-right">
				<input name="confirmPassword" id="form_confirm" type="password" tabindex="5" maxlength="125" placeholder="<spring:message code="registration.form.section.secure.confirm_password" />" />
			</div>
		</div>
		<div class="row">
			<div class="row-left">PHONE NUMBER</div><div class="row-right">
				<input name="cell" id="form_cell_phone" type="text" tabindex="6" placeholder="PHONE NUMBER" />
			</div>
		</div>
		<div class="row">
			<div class="row-left" id="label_education"><spring:message code="registration.form.section.your_info.education"/></div><div class="row-right">
				<select name="education" id="form_education" tabindex="7" multiple="multiple" placeholder="Please select">
					<%-- <option value="-1" disabled="disabled" selected="selected"><spring:message code="registration.hint.select.education" /></option> --%>
					<!-- <option value="-2">Others</option> -->
					<c:forEach var="item" items="${educationsList}">
						<c:choose>
							<c:when test="${schoolId == item.lookupValueId}">
								<option value="${item.lookupValueId}" selected="selected">${item.description}</option>
							</c:when>
							<c:otherwise>
								<option value="${item.lookupValueId}">${item.description}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row" id="educationRow">
			<div class="row-left"></div><div class="row-right">
				<b>Other:</b>&nbsp;<input type="text" name="_otherEducation" id="form_education_other" value="" class="inline-controller ms-add-other-value" tabindex="8"/>&nbsp;<div class="ms-add-other-button" id="addOtherEducation">Add</div>
			</div>
		</div>
		<div class="row">
			<div class="row-left" id="label_specialty"><spring:message code="registration.form.section.your_info.area_of_specialty"/></div><div class="row-right">
				<select name="specialty" id="form_specialty" tabindex="9" multiple="multiple" placeholder="Please select">
					<%-- <option value="-1" disabled="disabled" selected="selected"><spring:message code="registration.hint.select.specialty" /></option> --%>
					<!-- <option value="-2">Others</option> -->
					<c:forEach var="item" items="${specialtiesList}">
						<option value="${item.lookupValueId}">${item.description}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row" id="specialtyRow">
			<div class="row-left"></div><div class="row-right">
				<b>Other:</b>&nbsp;<input type="text" name="_otherSpecialty" id="form_specialty_other" value="" class="inline-controller ms-add-other-value" tabindex="10"/>&nbsp;<div class="ms-add-other-button" id="addOtherSpecialty">Add</div>
			</div>
		</div>
		<div class="row">
			<div class="row-left" id="label_hdyhau"><spring:message code="registration.form.section.your_info.how_did_you_hear_about_us.noexample"/></div><div class="row-right">
				<input name="howDidYouHearAboutUs" id="form_hdyhas" type="text" tabindex="11" maxlength="2000" value="${schoolName}" placeholder="<spring:message code="registration.form.section.your_info.how_did_you_hear_about_us"/>" />
			</div>
		</div>
		<input type="hidden" name="acceptedTermsId" id="form_accepted_termsId" value="${termsId}" />
		<input type="hidden" name="logoImageUrl" id="form_logo_image_url" value="/images/avatar_default.jpg" />
		<div class="submit-result" style="text-align: center;">
			<span id="submitResult"></span>
		</div>
		<div class="row button-panel">
			<a href="javascript:void(0);" id="submit" class="button" tabindex="12">SUBMIT</a>
		</div>
	</form>
</div>
<div class="next-input-controller hide">NEXT INPUT</div>
<script type="text/javascript">
_gaq.push(['_trackPageview']);
</script>