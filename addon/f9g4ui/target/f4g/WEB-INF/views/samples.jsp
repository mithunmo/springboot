<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="samples-wrapper">
	
	<div class="samples-title">
		<spring:message code="examples.submission.title" />
	</div>
	<div class="samples-content">
		<%-- <spring:message code="examples.submission.subtitle" /> Will uncomment out this tag for next build and remove the next line --%>
		Please provide 3 examples of your work that best showcase your illustration and design skills.<br />We will review these examples as part of your membership approval process.<br /><span style="color:#00AEEF; font-weight:bold;">Sample work submitted will be viewed by our evaluation staff at FFG and you will have the opportunity to create your portfolio once your membership has been approved.</span>
		<spring:message code="examples.submission.supportfiletype" />
	</div>
	
	<c:choose>
		<c:when test="${hasError}">
			<div class="error">
				<div class="popup" style="margin-left:300px;">
					<div class="header"><span class="title" id="title"></span></div>
					<div class="content">
						<div id="error_content" style="width:430px;">${error.defaultMessage}</div>
						<div class="buttonPanel" style="width:430px;">
							<a href="/"><div class="button">Ok</div></a>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<form name="samples" id="samples" method="post">
				<c:forEach begin="1" end="3" varStatus="counter">
					<div class="sample-item">
						<div class="sample-item-title">EXAMPLE ${counter.index} of 3*</div>
						<div class="sample-item-preview" role="${counter.index}">
							<div class="preimg">
								<c:choose>
									<c:when test="${samples[counter.index].boardId != 0 && !empty samples[counter.index].boardId}">
										<i></i><img src="/100x100/${samples[counter.index].boardImages[0].thumbnailUrl}" />
										<c:set var="isUpdate" value="0" />
									</c:when>
									<c:otherwise>
										<c:set var="isUpdate" value="-1" />
									</c:otherwise>
								</c:choose>
							</div>
							<a href="javascript:void(0);" class="preimg-q" title="We received your file, we will provide preview once we finished processing, please continue"></a>
						</div>
						<div class="sample-item-hint" role="${counter.index}">
							<c:set var="isRejected" value="false" />
							<c:if test="${samples[counter.index].description == 'rejected'}">
								<div class="resubmit" role="${counter.index}"><spring:message code="examples.submission.resubmit" /></div>
								<c:set var="isRejected" value="true" />
							</c:if>
						</div>
						<div class="sample-item-upload" role="${counter.index}">
							<input id="uploadify${counter.index}" role="${counter.index}" type="file">
						</div>
						<input type="hidden" class="boardId" role="${counter.index}" name="boardId" value="${samples[counter.index].boardId}" />
						<input type="hidden" class="file_is_rejected" role="${counter.index}" name="isrejected" value="${isRejected}" />
						<input type="hidden" class="filestatus" role="${counter.index}" name="filestatus" value="${isUpdate}" />
						<input type="hidden" class="filename" role="${counter.index}" name="filename" value="${samples[counter.index].boardImages[0].sourceFileURL}" />
						<input type="hidden" class="filename_ext" role="${counter.index}" name="filename_ext" value="${samples[counter.index].boardImages[0].fileType}" />
						<input type="hidden" class="filename_100" role="${counter.index}" name="filename_100" value="${samples[counter.index].boardImages[0].thumbnailUrl}" />
						<input type="hidden" class="filename_400" role="${counter.index}" name="filename_400" value="${samples[counter.index].boardImages[0].fileName}" />
						<input type="hidden" class="filename_original" role="${counter.index}" name="filename_original" value="${samples[counter.index].boardImages[0].mainImageUrl}" />
					</div>
				</c:forEach>
				<div class="hint-required">
					<spring:message code="examples.submission.requiredtext" />
					<%-- <br />
					*<spring:message code="examples.submission.supportfiletype" /> --%>
				</div>
				<div class="buttons">
					<span class="button disabled" id="samplesSubmit" disabled='disabled'>Submit</span>
				</div>
			</form>
		</c:otherwise>
	</c:choose>
</div>

<script type="text/javascript">
var appPath="${pageContext.request.contextPath}";
var uploaderPath=appPath+'<%= ViewPaths.UPLOAD_JPG%>';
</script>
<script type="text/javascript" src="/js/examples.min.js?v=1.21"></script>