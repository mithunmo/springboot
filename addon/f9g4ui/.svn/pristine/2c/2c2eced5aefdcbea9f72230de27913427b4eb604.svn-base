<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="board-approval-header">
	<form id="filterForm" method="get">
		<%-- FFG Rating Above:
		<select class="board-filter" id="ffgRatingFilter">
			<c:forEach var="item" begin="0" end="5">
				<option value="${item}">${item}</option>
			</c:forEach>
		</select> --%>
		Publish To MP Filter:
		<select class="board-filter" id="mpFilter">
			<c:choose>
				<c:when test="${pmpFilter=='all'}">
					<option value="all" selected="selected">All</option>
				</c:when>
				<c:otherwise>
					<option value="all">All</option>
				</c:otherwise>
			</c:choose>
			<%-- Only boards mode can select this option below --%>
			<c:if test="${mode == 'boards'}">
				<c:choose>
					<c:when test="${pmpFilter=='1'}">
						<option value="1" selected="selected">Published</option>
					</c:when>
					<c:otherwise>
						<option value="1">Published</option>
					</c:otherwise>
				</c:choose>
			</c:if>
			<c:choose>
				<c:when test="${pmpFilter=='2'}">
					<option value="2" selected="selected">Reviewing</option>
				</c:when>
				<c:otherwise>
					<option value="2">Reviewing</option>
				</c:otherwise>
			</c:choose>
		</select>
		Portfolio Type Filter:
		<select class="board-filter" id="pTypeFilter">
			<c:choose>
				<c:when test="${pTypeFilter=='all'}">
					<option value="all" selected="selected">All</option>
				</c:when>
				<c:otherwise>
					<option value="all">All</option>
				</c:otherwise>
			</c:choose>
			<%-- Only boards mode can select this option below --%>
			<c:choose>
				<c:when test="${pTypeFilter=='1'}">
					<option value="1" selected="selected">Marketplace</option>
				</c:when>
				<c:otherwise>
					<option value="1">Marketplace</option>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pTypeFilter=='0'}">
					<option value="0" selected="selected">Portfolio</option>
				</c:when>
				<c:otherwise>
					<option value="0">Portfolio</option>
				</c:otherwise>
			</c:choose>
		</select> 
		&nbsp;&nbsp;Designer Filter:
		<select class="board-filter" id="designerFilter">
			<c:choose>
				<c:when test="${designerFilter=='all'}">
					<option value="all" selected="selected">All Designers (${fn:length(boards)})</option>
				</c:when>
				<c:otherwise>
					<option value="all">All Designers</option>
				</c:otherwise>
			</c:choose>
			<c:forEach var="item" items="${designersList}">
				<c:set var="dId">${item.key}</c:set>
				<c:choose>
					<c:when test="${designerFilter==dId}">
						<option value="${item.key}" selected="selected">${designersNameList[item.key]} (${item.value})</option>
					</c:when>
					<c:otherwise>
						<option value="${item.key}">${designersNameList[item.key]} (${item.value})</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<br />
		Sort By:
		<select class="board-filter" id="sortOption">
			<option value="1" ${sortOptionHM['1']}>Date uploaded newest</option>
			<option value="-1" ${sortOptionHM['-1']}>Date uploaded oldest</option>
			<option value="2" ${sortOptionHM['2']}>Board name A-Z</option>
			<option value="-2" ${sortOptionHM['-2']}>Board name Z-A</option>
			<option value="3" ${sortOptionHM['3']}>Last name A-Z</option>
			<option value="-3" ${sortOptionHM['-3']}>Last name Z-A</option>
			<option value="4" ${sortOptionHM['4']}>First name A-Z</option>
			<option value="-4" ${sortOptionHM['-4']}>First name Z-A</option>
			<option value="5" ${sortOptionHM['5']}>Username A-Z</option>
			<option value="-5" ${sortOptionHM['-5']}>Username Z-A</option>
			<option value="6" ${sortOptionHM['6']}>Admin rating highest</option>
			<option value="7" ${sortOptionHM['7']}>Admin rating lowest</option>
		</select>
		&nbsp;&nbsp;
		<c:choose>
			<c:when test="${mode == 'boards'}">
				<a href="?mode=samples">View Examples</a>	
			</c:when>
			<c:otherwise>
				<a href="?mode=boards">View Boards</a>
			</c:otherwise>
		</c:choose>
		<input type="hidden" id="viewMode" name="viewMode" value="${mode}" />
	</form>
</div>
<c:if test="${empty boards}">
	<div class="board-approval-viewport">
		<div style="text-align:center; margin-top:300px; color:#C30; font-weight: bold;">Empty. Please redefine the sort by options. Thank you.</div>
	</div>
</c:if>
<c:if test="${!empty boards}">
	<div class="board-approval-viewport">
		<c:choose>
			<c:when test="${mode == 'Boards'}">
				Please Approve/Reject following boards:
			</c:when>
			<c:otherwise>
				Please review following examples:
			</c:otherwise>
		</c:choose>
		<table class="board-approval-table">
			<tr>
				<td></td>
				<td></td>
				<!-- <td>Designer</td>
				<td>Category</td>
				<td>Approve?</td>
				<td>Comment</td> -->
			</tr>
			<c:forEach items="${boards}" var="item" varStatus="counter">
			<tr class="outter-row">
				<td>
					<div style="position:relative">
						<c:choose>
							<c:when test="${mode == 'boards' && item.hasSellablePortfolio == 1}">
								<div class="img-flag">Marketplace Submission</div>
							</c:when>
							<c:when test="${mode == 'boards' && item.hasSellablePortfolio == 0}">
								<div class="img-flag pb">Portfolio Page</div>
							</c:when>
							<c:otherwise>
								<div class="img-flag exp">Example</div>
							</c:otherwise>
						</c:choose>
						<a class="viewBigImage" image-data="${item.boardImages[0].mainImageUrl}"><img src="/400x400/${item.boardImages[0].fileName}" /></a>
						<c:forEach var="portfolioImageItem" items="${item.portfolioImages}">
							<c:if test="${portfolioImageItem.activeStatus == 1}">
								<a class="viewBigImage thumbnail" image-data="${portfolioImageItem.mainImageUrl}"><img src="/100x100/${portfolioImageItem.thumbnailUrl}" /></a>
							</c:if>	
						</c:forEach>
					</div>
				</td>
				<td>
					<table class="inner-table upper">
						<tr><td>Date Uploaded</td><td class="upper-content"><c:out value="${boardsTimeHashMap[item.boardId]}" /></td></tr>
						<tr><td>Board Name</td><td class="upper-content"><c:out value="${item.name}" /></td></tr>
						<tr><td>Designer</td><td class="upper-content"><span class="userName" data="${item.originalUser.userId}">${item.originalUser.firstname}&nbsp;${item.originalUser.lastname}</span>&nbsp;&nbsp;(&nbsp;${item.originalUser.userName}&nbsp;)</td></tr>
						<tr><td>Price</td>
							<td class="upper-content">
								$&nbsp;${item.boardPrice}
								<span class="ffg-rating-panel">Admin Rating:&nbsp;
									<b class="ffg-rating-panel-value" data-id="${item.originalUser.userId}">
										<c:choose>
											<c:when test="${item.originalUser.adminRating == -1}">Unrated</c:when>
											<c:otherwise>${item.originalUser.adminRating}</c:otherwise>
										</c:choose>
									</b>&nbsp;
									<a href="javascript:void(0);" class="ffg-rating-panel-update" data-id="${item.originalUser.userId}">(Update)</a>
								</span>
							</td>
						</tr>
						<tr><td>Source file URL</td><td class="upper-content">${item.boardImages[0].sourceFileURL}&nbsp;<a class="error-file" target="_BLANK" href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_RETRIEVE_ERROR_FILE%>?sourcefile=${item.boardImages[0].sourceFileURL}" style="float:right;">See image "File is being processed"?</a></td></tr>
						<tr><td>Image URL</td><td class="upper-content">${item.boardImages[0].mainImageUrl}</td></tr>
						<tr><td>key words</td><td class="upper-content">${item.keyword}</td></tr>
						<tr><td colspan="2" class="upper-header">Category</td></tr>
						<tr>
							<td>Division</td>
							<td class="upper-content"><c:out value="${item.category.categoryLevel1Value}" /></td>
						</tr>
						<tr>
							<td>Category</td>
							<td class="upper-content"><c:out value="${item.category.categoryLevel2Value}" /></td>
						</tr>
						<tr>
							<td>Product</td>
							<td class="upper-content">
								<div style="min-width:200px; word-wrap:break-word;"><c:out value="${productHashMap[item.boardId]}" /></div>
							</td>
						</tr>
						<tr>
							<td>Product Type</td>
							<td class="upper-content">
								<div style="min-width:200px; word-wrap:break-word;"><c:out value="${productTypeHashMap[item.boardId]}" /></div>
							</td>
						</tr>
					</table>
					
					<table class="inner-table lower">
					<%-- Only boards mode can have the option to approve the board --%>
					<c:if test="${mode == 'boards'}">
						<tr>
							<c:choose>
								<c:when test="${item.publishToMP==2}">
									<td class="td1">
										<form data="${item.boardId}">
											<textarea name="comments" class="approval-comment" rows="8" cols="25" data="${item.boardId}" placeholder="Please enter comments so you can Approve/Reject the board."></textarea>
											<input type="hidden" class="main-image-url" name="main_image_url" data="${item.boardId}" value="${item.boardImages[0].mainImageUrl}" />
											<input type="hidden" class="approval-status" name="approval_status" data="${item.boardId}" value="0" />
											<input type="hidden" class="board-id" name="board_id" data="${item.boardId}" value="${item.boardId}" />
										</form>
										<input type="hidden" class="submitted" name="submitted" data="${item.boardId}" value="0" />
									</td>
									<td class="td2">
										<div class="button approve" data="${item.boardId}">Approve</div>
										<div class="button orange reject disabled" data="${item.boardId}">Reject</div>
										<c:if test="${item.hasSellablePortfolio==1}">
											<div class="button edit-board" data="${item.boardId}">Edit Board</div>
										</c:if>
										<div style="position:relative; clear:both; margin-top:5px;">
											<span class="result" data="${item.boardId}"></span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<c:if test="${item.hasSellablePortfolio==1}">
										<td colspan="2" class="single-edit">
											<div class="button edit-board" data="${item.boardId}">Edit Board</div>
										</td>
									</c:if>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:if>
					<c:if test="${mode == 'samples'}">
						<c:choose>
							<c:when test="${item.description != 'rejected'}">
								<tr>
									<td class="td1">
										<form data="${item.boardId}">
											<textarea name="comments" class="approval-comment" rows="8" cols="25" data="${item.boardId}" placeholder="Please enter comments so you can ask the designer to RESUBMIT the example."></textarea>
											<input type="hidden" class="main-image-url" name="main_image_url" data="${item.boardId}" value="${item.boardImages[0].mainImageUrl}" />
											<input type="hidden" class="approval-status" name="approval_status" data="${item.boardId}" value="0" />
											<input type="hidden" class="board-id" name="board_id" data="${item.boardId}" value="${item.boardId}" />
										</form>
										<input type="hidden" class="submitted" name="submitted" data="${item.boardId}" value="0" />
									</td>
									<td class="td2">
										<div class="button orange resubmit-sample disabled" data="${item.boardId}" user="${item.originalUser.userId}">Resubmit Example</div>
										<div style="position:relative; clear:both; margin-top:5px;">
											<span class="result" data="${item.boardId}"></span>
										</div>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="2" class="single-edit">
										<span style="color:#C30;">Administrator has asked user to resubmit this example.</span>
									</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:if>
					</table>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</c:if>