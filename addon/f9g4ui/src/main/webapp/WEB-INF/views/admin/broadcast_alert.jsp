<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="users-viewer-header" id="broadcastAlertHeader"></div>
<div class="viewer-container" id="broadcastAlert">
	<div class="users-list" style="width:100%;">
		<div class="users-list-view" style="width:100%;">
			<div style="position:relative;">
				<form name="broadcastMessageForm" id="broadcastMsgForm">
					<table>
						<tr>
							<td class="table-header">Select Email Template</td>
							<td>
								<select name="templateCode" id="emailTemplate">
									<option value="BLANK">BLANK</option>
									<c:forEach var="item" items="${broadcastMsgTemplates}" varStatus="counter">
										<option value="<c:out value="${item.tempCode}" />">${item.tempCode}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class="table-header">Select User Group</td>
							<td>
								<select name="messageScope" id="emailUserGroup">
									<c:forEach var="item" items="${msg_scope}">
										<option value="${item.lookupValueId}">${item.description}</option>	
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class="table-header">Subject</td>
							<td>
								<input type="text" name="_messageSubject" id="_broadcastMsgSubject" maxlength="500"></input>
								<input type="hidden" name="messageSubject" id="broadcastMsgSubject"></input>
							</td>
						</tr>
					</table>
					<div style="position:relative;">
						<div class="loadingPanel">Loading...</div>
						<textarea rows="" cols="" name="_messageBody" id="_broadcastMsgBody" maxlength="4000"></textarea>
					</div>
					<input type="hidden" name="messageBody" id="broadcastMsgBody"></input>
					<div class="button disabled" button-disabled="true" id="broadcastSubmit">Broadcast</div>
				</form>
			</div>
			<div class="broadcast-msg-viewer">
				<div style="width:100%;">Previous Broadcast Messages</div>
				<table>
					<tr class="table-header">
						<td style="width:45%;">Detail</td>
						<td style="width:20%;">Scope</td>
						<td style="width:10%;">Sent Status</td>
						<td style="width:18%;">Creation Date</td>
					</tr>
					<c:forEach var="item" items="${previousBroadcastMessages}" varStatus="counter">
						<tr>
							<td>
								<c:if test="${!empty item.templateName}">
									<div class="label">Template Name:</div>
									<div style="padding-left:10px;">${item.templateName}</div>
								</c:if>
								<c:if test="${!empty item.subject}">
									<div class="label">Subject:</div>
									<div style="padding-left:10px;">${item.subject}</div>
								</c:if>
								<c:if test="${!empty item.messageText}">
									<div class="label">Body:</div>
									<div style="padding-left:10px;">${item.messageText}</div>
								</c:if>
							</td>
							<td>${item.adLookupValuesByMsgScopeId.description}</td>
							<td>${item.adLookupValuesByMsgStatusId.description}</td>
							<td><fmt:formatDate pattern="MMM-dd-yyyy" value="${previousBroadcastMessagesDate[item.broadcastId]}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<div style="clear: both;"></div>
</div>