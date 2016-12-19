<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="com.f9g4.web.utils.ViewPaths" %>

<!---Content------------------>
<div class="contentFrame" id="home">
	<div class="content background-white">
		<div class="row background-blue" id="company-profile-header">
			<div class="homeImage"><i></i><img src="${compProfile.logoImageUrl}" /></div>
			<table>
				<tr>
					<td><span class="profileHeader">${compProfile.firstName}  ${compProfile.lastName}</span></td>
				</tr>
			</table>
		</div>
		<div class="row">
			<div class="column oneThird" id="company-info-holder">
				<div class="info_block">
					<div class="head">Company</div>
					<div class="context">
						${compProfile.companyName}
						<br />
						<a href="${compProfile.website}" target="_blank">${compProfile.website}</a>
					</div>
				</div>
			</div>
			<div class="column oneThird">
				<div class="info_block">
					<div class="head">Contact</div>
					<div class="context">
						${compProfile.cellPhone}
						<br />
						${compProfile.phone}#${compProfile.ext}
						<br />
						${compProfile.fax}
					</div>
				</div>
			</div>
			<div class="column oneThird">
				<div class="info_block">
					<div class="head">Address</div>
					<div class="context">
						${compProfile.address1}
						<br />
						<c:if test="${!empty compProfile.address2}">${compProfile.address2}<br /></c:if>
						${compProfile.city}, ${compProfile.state}
						<br />
						${compProfile.zip}
						<br />
						${compProfile.countryName}
					</div>
				</div>
			</div>
		</div>
		
			
		<div class="membershipDetail">
			<div class="row">
				<span class="textLeft">Member Since</span> <span class="textRight"><fmt:formatDate pattern="MMM-dd-yyyy" value="${compProfile.memberSince}" /></span>
			</div>
			<!-- <div class="line"></div> -->
			<div class="row">
				<span class="textLeft">Membership Expires On</span><span class="textRight orangeText"><fmt:formatDate pattern="MMM-dd-yyyy" value="${compProfile.memberExpires}" /></span>
			</div>
			<div class="row">
				<span class="textLeft">Next Payment Due Date</span><span class="textRight"><fmt:formatDate pattern="MMM-dd-yyyy" value="${compProfile.due}" /></span> <br /> 
				<!-- <span class="textRight"><a href="#payment">(Make a Payment)</a></span> -->
			</div>
			<!-- <div class="line"></div> -->
			<%-- <div class="row space textCenter" style="height:10px;">
				<a href="${pageContext.request.contextPath}<%= ViewPaths.UPDATE_MEMBERSHIP_PAY %>?userId=${userId}" id="update_membership">Update Membership</a>
			</div> --%>
		</div>

		<div class="buttons-holder">
			<div class="buttons">
				<a href="#edit_company_profile" id="edit_profile_company" style="text-decoration: none;"><div class="button">Edit Profile</div></a>
				<a id="manage_referrals"><div class="button">Manage Referrals</div></a>
				<a id="change_password" style="text-decoration: none;"><div class="button">Change Password</div></a>
				<a id="view_terms" style="text-decoration: none;"><div class="button">TERMS & CONDITIONS</div></a>
			</div>
		</div>
		<c:if test="${hasAdminMode}">
			<a href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_BOARDS_APPROVAL%>" style="position:absolute; bottom:10px; right:10px;">Administrator Console</a>
		</c:if>
	</div>
</div>
<!---end of content----------->