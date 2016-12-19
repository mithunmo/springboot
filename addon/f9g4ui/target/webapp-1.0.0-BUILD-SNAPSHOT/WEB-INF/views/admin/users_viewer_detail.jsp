<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:if test="${!empty examples}">
	<div>Examples</div>
	<div class="examples-area">
		<c:forEach var="item" items="${examples}">
			<div style="display:table-cell">
				<c:if test="${!empty item.boardImages}">
					<a class="viewBigImage" image-data="${item.boardImages[0].mainImageUrl}"><img src="/400x400/${item.boardImages[0].fileName}"></a>
					<a href="/f4g/admin/file?sourcefile=${item.boardImages[0].sourceFileURL}" target="_BLANK" style="display:block;">Download</a>
				</c:if>
			</div>
		</c:forEach>
	</div>
</c:if>
<div>
	<table>		
		<tr>
			<td style="width:200px; font-size: 1.2em;">${viewUserDetail.firstname} ${viewUserDetail.lastname}</td>
			<td style="width:300px; height:150px; text-align: right;"><span class="profile-progress-score">${score}%</span><img src="${viewUserDetail.logoimageurl}" style="width:150px; height:150px;" /></td>
		</tr>
		<tr>
			<td colspan="2" class="user-type">
				<spring:message code="${viewUserDetail.userType}" />
			</td>
		</tr>
		<%-- <tr>
			<td>Security Question 1</td>
			<td>
				<c:forEach items="${securityQestions1_List}" var="item" varStatus="counter">
					<c:if test="${item.lookupValueId == viewUserDetail.securityQuestion1}">
						${item.description}
					</c:if>
				</c:forEach>
				<br />
				Answer:&nbsp;${viewUserDetail.securityAnswer1}
			</td>
		</tr>
		<tr>
			<td>Security Question 2</td>
			<td>
				<c:forEach items="${securityQestions2_List}" var="item" varStatus="counter">
					<c:if test="${item.lookupValueId == viewUserDetail.securityQuestion2}">
						${item.description}
					</c:if>
				</c:forEach>
				<br />
				Answer:&nbsp;${viewUserDetail.securityAnswer2}
			</td>
		</tr> --%>
		<tr>
			<td>Admin Rating</td>
			<td>
				<div class="ffg-rating" id="ffgRating" data-id="${viewUserDetail.userId}"></div>
				<div class="ffg-rating-value" id="ffgRatingValue" data-id="${viewUserDetail.userId}">
					<c:choose>
						<c:when test="${viewUserDetail.adminRating == -1}">
							Unrated	
						</c:when>
						<c:otherwise>
							${viewUserDetail.adminRating}
						</c:otherwise>
					</c:choose>
				</div>
				<input name="ffgRating" id="form_ffgRating" type="hidden" data-id="${viewUserDetail.userId}" value="${viewUserDetail.adminRating}" />
				<img class="ffg-rating-spinner" src="/images/spinner_min.gif" />
			</td>
		</tr>
		<tr>
			<td>Contacts Number</td>
			<td>
				Cell phone:&nbsp;${viewUserDetail.contacts[0].cellphone} <br />
				<c:if test="${ not empty viewUserDetail.contacts[0].fax}">
		    		Fax:&nbsp;${viewUserDetail.contacts[0].fax}
		    	</c:if>
			</td>
		</tr>
		<c:if test="${viewUserDetail.userType == 'DG'}">
			<tr>
				<td>Skills</td>
				<td>
					<c:forEach var="item" items="${viewUserDetail.useSkills}" varStatus="counter">
						${item.skillName} <br />
					</c:forEach>
				</td>
			</tr>
		</c:if>
		<tr>
			<td>Brands</td>
			<td>
				${viewUserDetail.companyname} <br />
				<c:if test="${ not empty viewUserDetail.companywebsite}">
					${viewUserDetail.companywebsite} <br />
				</c:if>
				${viewUserDetail.contacts[0].workphone}
		    	<c:if test="${ not empty viewUserDetail.contacts[0].workext}">#${viewUserDetail.contacts[0].workext}</c:if>
		    	<br />
			</td>
		</tr>
		<c:if test="${viewUserDetail.userType == 'DG'}">
			<tr>
				<td>Awards</td>
				<td>${viewUserDetail.schoolawards}</td>
			</tr>
			<tr>
				<td>About You</td>
				<td>${viewUserDetail.aboutYou}</td>
			</tr>
		</c:if>
		<tr>
			<td>Membership</td>
			<c:choose>
				<c:when test="${hasError}">
					<td style="color:#C30;">Can't find membership record.</td>
				</c:when>
				<c:otherwise>
					<td>
						Since: <fmt:formatDate pattern="MMM-dd-yyyy hh:mm a" value="${memEffectiveDate}" />
						<br />
						Expire: <fmt:formatDate pattern="MMM-dd-yyyy hh:mm a" value="${memExpDate}" />
					</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td>Languages</td>
			<td>
				<c:forEach var="item" items="${viewUserDetail.userLangs}" varStatus="counter">
					${item.langName} <br />
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>Address</td>
			<td style="border:thin solid #000;">
			${viewUserDetail.address[0].addressLine1} <br />
			<c:if test="${!empty viewUserDetail.address[0].addressLine2}">${viewUserDetail.address[0].addressLine2} <br /></c:if>
			${viewUserDetail.address[0].city},${viewUserDetail.address[0].state},${viewUserDetail.address[0].countryName} <br />
			${viewUserDetail.address[0].postalcode}
			</td>
		</tr>
		<tr>
			<td>Additional document</td>
			<td>
				<c:forEach var="item" items="${viewUserDetail.userDocuments}">
					<a href="/files/${item.fileName}" target="_BLANK">${item.sourceFileURL}</a>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>How did you hear about us</td>
			<td>
				${viewUserDetail.howDidYouHearAboutUs}
			</td>
		</tr>
		<tr>
			<td>Education</td>
			<td>
				<c:if test="${!empty viewUserDetail.education}">
					<ul>
						<c:forEach var="item" items="${viewUserDetail.education}">
							<li>${item.educationName}</li>
						</c:forEach>
					</ul> 
				</c:if>
			</td>
		</tr>
		<tr>
			<td>Area of Specialty</td>
			<td>
				<c:if test="${!empty viewUserDetail.specialty}">
					<ul>
						<c:forEach var="item" items="${viewUserDetail.specialty}">
							<li>${item.specialitiesName}</li>
						</c:forEach>
					</ul>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>Area of Expertise</td>
			<td>
				<c:if test="${!empty viewUserDetail.expertise}">
					<ul>
						<c:forEach var="item" items="${viewUserDetail.expertise}">
							<li>${item.expertiseName}</li>
						</c:forEach>
					</ul>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>Degrees and Accreditations</td>
			<td>
				<c:if test="${!empty viewUserDetail.degAcc}">
					<ul>
						<c:forEach var="item" items="${viewUserDetail.degAcc}">
							<li>${item.degaccsName}</li>
						</c:forEach>
					</ul>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>Years of Experience</td>
			<td>
				${viewUserDetail.yrsExp.description}
			</td>
		</tr>
		<tr>
			<td>Name the companies you have worked-for in the past</td>
			<td>
				${viewUserDetail.companiesWorked}
			</td>
		</tr>
	</table>
</div>
<c:if test="${hasEnableMessage}">
	<div class="reset-session">
		<div class="button" id="resetPassword" data="${viewUserDetail.userId}" user-name="${viewUserDetail.firstname} ${viewUserDetail.lastname}">Reset Password</div>
	</div>
	<div class="email-session">
		Email Message
		<form id="mailMessage">
			Subject:&nbsp;<input type="text" class="mailSubject" id="mailSubject" name="mailSubject" maxlength="100"></input>
			<br />
			<textarea id="mailContent" name="mailContent" rows="5" cols="60"></textarea>
			<input type="hidden" id="mailUserId" name="mailUserId" value="${viewUserDetail.userId}"/>
			<br />
			<div class="button" id="sendMail" data="${viewUserDetail.userId}">Send</div>
			<span id="sendMailStatus"></span>
		</form>
	</div>
</c:if>