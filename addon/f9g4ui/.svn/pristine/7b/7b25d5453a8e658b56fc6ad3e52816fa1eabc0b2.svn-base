<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="users-viewer-header">
User Type Filter: &nbsp;
<select class="user-filter" id="userTypeFilter">
	<option value="all" ${userTypeFilter["all"]}>All User Types</option>
	<option value="designer" ${userTypeFilter["designer"]}>Designers</option>
	<option value="company" ${userTypeFilter["company"]}>Companies</option>
</select>
Register Status Filter: &nbsp;
<select class="user-filter" id="userFilter">
	<option value="all" ${filter["all"]}>All</option>
	<option value="approved" ${filter["approved"]}>Approved</option>
	<option value="waitapproval" ${filter["waitapproval"]}>Non-approved</option>
	<option value="rejected" ${filter["rejected"]}>Rejected</option>
	<option value="wc" ${filter["wc"]}>Waiting for confirmation</option>
	<option value="sbsc" ${filter["sbsc"]}>Samples submission complete</option>
	<option value="rc" ${filter["rc"]}>Registration form complete</option>
</select>
Sort By:&nbsp;
<select class="user-filter" id="sortOption">
	<option value="1" ${sortOptionHM['1']}>Last name A-Z</option>
	<option value="-1" ${sortOptionHM['-1']}>Last name Z-A</option>
	<option value="5" ${sortOptionHM['5']}>First name A-Z</option>
	<option value="-5" ${sortOptionHM['-5']}>First name Z-A</option>
	<option value="2" ${sortOptionHM['2']}>Username A-Z</option>
	<option value="-2" ${sortOptionHM['-2']}>Username Z-A</option>
	<option value="3" ${sortOptionHM['3']}>Expiration date Oldest</option>
	<option value="-3" ${sortOptionHM['-3']}>Expiration date Newest</option>
	<option value="4" ${sortOptionHM['4']}>Signed up date Oldest</option>
	<option value="-4" ${sortOptionHM['-4']}>Signed up date Newest</option>
	<option value="-6" ${sortOptionHM['-6']}>Admin rating Highest</option>
	<option value="6" ${sortOptionHM['6']}>Admin rating Lowest</option>
</select>
&nbsp;( ${usersCount} users)
</div>
<div class="pagination-panel">
	Search:&nbsp;<input type="text" id="userSearch" tabindex="1" style="width:100px;"/>
	<span id="userSerachResult" style="color:#C30;"></span>&nbsp;
	<c:choose>
		<c:when test="${showAll}">
			<a href="?usertype=${pUsertype}&filter=${pFilter}&sortoption=${pSortoption}&p=1">Pagin Mode</a>
		</c:when>
		<c:otherwise>
			&nbsp;Page:&nbsp;
			<select class="user-filter-pagin" name="p" id="page">
				<c:forEach var="item" begin="1" end="${totalPages}">
					<c:choose>
						<c:when test="${pPage==item}">
							<option selected="selected">${item}</option>
						</c:when>
						<c:otherwise>
							<option>${item}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			<a href="?usertype=${pUsertype}&filter=${pFilter}&sortoption=${pSortoption}&p=${pPrevPage}">&lt;&nbsp;Prev</a>&nbsp;&nbsp;
			<a href="?usertype=${pUsertype}&filter=${pFilter}&sortoption=${pSortoption}&p=${pNextPage}">Next&nbsp;&gt;</a>
			&nbsp;<a href="?usertype=${pUsertype}&filter=${pFilter}&sortoption=${pSortoption}&p=-1">Show all records</a>
		</c:otherwise>
	</c:choose>
	<span class="hidden-users-pannel" style="float:right;">
	<a href="jacascript:void(0);" id="enableHiddenUsers">Hide hidden users</a>&nbsp;
	<span id="hiddenUsersCount"></span>&nbsp;
	<a href="jacascript:void(0);" id="disableHiddenUsers">Show hidden users</a>&nbsp;
	<a href="jacascript:void(0);" id="clearHiddenUsers">Clear hidden users collection</a>
	</span>
</div>

<div class="viewer-container">
	<div class="users-list">
		<div class="users-list-view">
			<c:forEach var="item" items="${users}" varStatus="counter">
			<c:choose>
				<c:when test="${counter.count%2==0}">
					<c:set var="styleClass" value="even" />
					<%-- <div class="user-list-item even" data="${item.userId}"> --%>
				</c:when>
				<c:otherwise>
					<c:set var="styleClass" value="odd" />
					<%-- <div class="user-list-item odd" data="${item.userId}"> --%>
				</c:otherwise>
			</c:choose>
			<div class="user-list-item ${styleClass}" data="${item.userId}">
				<div class="hide-user" data="${item.userId}">Hide</div>
				<form class="membershipLevelSelect" data="${item.userId}">
				<table>
					<tr>
						<td rowspan="3" style="width:50px;"><a class="userLogo" data="${item.userId}"><img src="${item.userLogo}" /></a></td>
						<td style="width:325px; padding-left:5px;" class="userName" data="${item.userId}"><a class="userName-content" href="javascript:void(0);">${item.name}</a></td>
					</tr>
					<tr>
						<td style="width:325px; padding-left:5px;"><span class="table-username">${item.userName}</span></td>
					</tr>
					<tr>
						<td style="width:325px; padding-left:5px;">${item.userType.description}</td>
					</tr>
					<tr>
						<td colspan="2">
							Registration Status: <span class="regStatus" data="${item.userId}">${item.regStatus.description}</span>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							Signed Up Date: <span class="effectiveDate" data="${item.userId}">${effectiveDateHM[item.userId]}<%-- <fmt:formatDate pattern="MMM-dd yyyy" value="${item.membership[0].experiationDate}" /> --%></span>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							Expiration Date: <span class="expDate" data="${item.userId}">${expDateHM[item.userId]}<%-- <fmt:formatDate pattern="MMM-dd yyyy" value="${item.membership[0].experiationDate}" /> --%></span>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							Current Membership Level: <span class="current-membership" data="${item.userId}">${item.memPricingOption.membershipType.description}&nbsp;,&nbsp;$${item.memPricingOption.price}&nbsp;,&nbsp;${item.memPricingOption.commission}%</span>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="membershipLevelInfo" data="${item.userId}">
						Select membership level:
						(Level,Price,Commission)
						<select class="memPricingOption" name="memPricingOption" data="${item.userId}" style="width:350px;">
							<c:forEach var="memItem" items="${memPricingOptions}">
								<c:if test="${memItem.userTypeId == item.userType.lookupValueId}">
									<c:choose>
										<c:when test="${memItem.memberPricingId == item.memPricingOption.memberPricingId}">
											<option value="${memItem.memberPricingId}" selected="selected">${memItem.membershipType.description},$${memItem.price},${memItem.commission}%</option>
										</c:when>
										<c:otherwise>
											<option value="${memItem.memberPricingId}">${memItem.membershipType.description},$${memItem.price},${memItem.commission}%</option>
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:forEach>
						</select>
						<input type="hidden" name="userId" value="${item.userId}">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							Membership Period:&nbsp;
							<select name="trial_period" class="trial-period" id="trialPeriod" style="width:100px;">
								<option value="0" selected="selected">0</option>
								<option value="90">90</option>
								<option value="180">180</option>
								<option value="365">365</option>
							</select>
							&nbsp;days.
						</td>
					</tr>
					<c:choose>
						<c:when test="${ item.regStatus.lookupCode == 'CF' || item.regStatus.lookupCode == 'SBSC' || item.regStatus.lookupCode == 'WC' || item.regStatus.lookupCode == 'DN'}">
							<%-- Do not show approve/reject function if the user type is designer and the reg status is CF--%>
							<tr>
								<td colspan="2" style="padding:5px 10px;" class="membership-buttons-panel" data="${item.userId}">
									<c:if test="${!(item.userType.lookupCode == 'DG' && item.regStatus.lookupCode == 'CF')}">
										<div class="button approve-user" data="${item.userId}">Approve</div>
										<c:if test="${item.regStatus.lookupCode != 'DN'}">
											<div class="button orange reject-user" data="${item.userId}">Reject</div>
										</c:if>
									</c:if>
									<c:if test="${item.userType.lookupCode == 'DG' && item.regStatus.lookupCode != 'DN'}">
										<div class="button view-samples" data="${item.userId}">Examples</div>
									</c:if>
								</td>
							</tr>
							<%-- Samples related functionality for designer and the reg status is not denied--%>
							<%-- <c:if test="${item.userType.lookupCode == 'DG' && item.regStatus.lookupCode != 'DN'}">
								<tr>
									<td colspan="2" style="padding:5px 10px;" class="samples-buttons-panel" data="${item.userId}">
										<div class="button view-samples" data="${item.userId}">Examples</div>
										Only when samples submit completed status can turn back to CF status
										<c:if test="${ item.regStatus.lookupCode == 'SBSC' || item.regStatus.lookupCode == 'WC' }">
											<a class="button resubmit-samples" data="${item.userId}">Re-submit Samples</a>
										</c:if>
									</td>
								</tr>
							</c:if> --%>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="2" style="padding:5px 10px;" class="membership-buttons-panel" data="${item.userId}">
									<div class="button change-user-level" data="${item.userId}">Change Level</div>
									<div class="button view-samples" data="${item.userId}">Examples</div>
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
					<tr>
						<td colspan="2">
							<div>
								<div>
									<c:if test="${!empty item.approverComment}">
										Comments:&nbsp;<a href="javascript:void(0);" class="apcmmnt-h" data="${item.userId}">Show History</a>
									</c:if>
								</div>
								<div>
									<textarea style="width:90%; height:45px;" class="apcmmnt" data="${item.userId}" placeholder="Put your comment here">${item.approverComment}</textarea>
								</div>
								<c:choose>
									<c:when test="${!empty item.approverComment}">
										<div style="padding-left:10px; text-align: left;"><a class="button apcmmnt-b" data="${item.userId}">UPDATE COMMENT</a></div>
									</c:when>
									<c:otherwise>
										<div style="padding-left:10px; text-align: left;"><a class="button apcmmnt-b" data="${item.userId}" disabled="disabled">UPDATE COMMENT</a></div>
									</c:otherwise>
								</c:choose>
							</div>
						</td>
					</tr>
				</table>
				</form>
			</div>
			</c:forEach>
		</div>
	</div>
	<div class="user-detail" id="userDetail">
		<div>
			<table>
				<tr>
					<td style="width:200px; font-size: 1.2em;"></td>
					<td style="width:300px; height:150px; text-align: right;"><img src="/400x400/cda98b2f-c286-4d11-9261-62b395c8545e.jpg" style="width:150px; height:150px;" /></td>
				</tr>
				<tr>
					<td>Skills</td>
					<td></td>
				</tr>
				<tr>
					<td>Contacts Number</td>
					<td></td>
				</tr>
				<tr>
					<td>Brands</td>
					<td></td>
				</tr>
				<tr>
					<td>Awards</td>
					<td></td>
				</tr>
				<tr>
					<td>About You</td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td>Membership</td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td>Languages</td>
					<td></td>
				</tr>
				<tr>
					<td>Address</td>
					<td></td>
				</tr>
			</table>
		</div>
		<div class="email-session" style="margin-top:20px;">
			Email Message
			<form id="mailMessage">
				Subject:&nbsp;<input type="text" id="mailSubject" name="mailSubject" maxlength="100" style="width:400px;"></input>
				<br />Message:
				<textarea id="mailContent" name="mailContent" rows="3" cols="70"></textarea>
				<input type="hidden" id="mailUserId" name="mailUserId" value=""/>
				<div class="button" id="sendMail" data="">Send</div>
			</form>
		</div>
	</div>
	<div style="clear: both;"></div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$('#userSearch').focus(); //focus on the userSearch input
		$('.userLogo:first').trigger('click'); //Trigger to retrieve the first user information
		updateHideButton();
		hideHiddenUsers();
	});
</script>