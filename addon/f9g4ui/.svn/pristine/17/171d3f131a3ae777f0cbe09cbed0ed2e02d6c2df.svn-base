<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="users-viewer-header" id="referralsViewerHeader">
${referralsCount} referrals
<table>
	<tr>
		<td class="td1">Name</td>
		<td class="td2">Detail</td>
	</tr>
</table>
</div>
<div class="viewer-container" id="referralsViewer">
	<div class="users-list">
		<div class="users-list-view">
			<table>
				<c:forEach var="item" items="${referrlas}" varStatus="counter">
					<c:set var="rowStyle" value="even"></c:set>
					<c:if test="${counter.count%2==1}">
						<c:set var="rowStyle" value="odd"></c:set>
					</c:if>
					<tr class="${rowStyle}">
						<td class="td1"><c:out value="${item.firstName}"/>&nbsp;<c:out value="${item.lastName}"/></td>
						<td class="td2">
							<table class="inner-table">
								<tr>
									<td class="table-header">Email</td>
									<td class="table-content"><c:out value="${item.email}"/></td>
								</tr>
								<tr>
									<td class="table-header">Phone</td>
									<td class="table-content"><c:out value="${item.phone}"/></td>
								</tr>
								<tr>
									<td class="table-header">Date Sent / Referred By</td>
									<td class="table-content">
										<fmt:formatDate pattern="MMM dd,yyyy" value="${item.dateSent}" />
										&nbsp;/&nbsp;
										${item.referredBy}
									</td>
								</tr>
								<tr>
									<td class="table-header">Status</td>
									<td class="table-content"><c:out value="${item.status}"/></td>
								</tr>
								<tr>
									<td class="table-header">Why</td>
									<td class="table-content"><c:out value="${item.reason}"/></td>
								</tr>
								<tr>
									<td class="table-header">How</td>
									<td class="table-content"><c:out value="${item.background}"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div style="clear: both;"></div>
</div>