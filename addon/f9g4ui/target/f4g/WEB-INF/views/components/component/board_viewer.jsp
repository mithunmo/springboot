<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Board Viewer -->
<div class="content-holder expand imgs-container med">
	<div class="cover gap" ng-show="isLoading"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Loading. Please wait...</div>
	<div class="cover" ng-show="isUpdating"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Updating data. Please wait...</div>
	<div class="cover" ng-show="isEmptyResult"><i class="glyphicon glyphicon-warning-sign"></i>&nbsp;&nbsp;Empty. Please refine search criteria.</div>
	<div class="cover" ng-show="isCartSyncing"><i class="glyphicon glyphicon-warning-sign"></i>&nbsp;&nbsp;Update Shopping Cart Information.</div>
	<div class="img-holder {{isSelected[$index]}} {{loading[$index]}}" ng-class="{deleting:item.deleting}" data-seq="{{$index}}" ng-repeat-start="item in items">
		<img class="img-nail" src="/400x400/{{item.boardImages[0].fileName}}" data-seq="{{$index}}" ng-click="getDetail($event,item.boardId,$index)"/>
		<div class="img-label"><span class="glyphicon glyphicon-repeat"></span>&nbsp;<span class="glyphicon glyphicon-trash"></span>&nbsp;Deleting..</div>
		<%-- Designer Edit feature --%>
		<div class="img-function-panel default">
			<c:if test="${access.boardEditAccess}">
				<a class="glyphicon glyphicon-pencil" ng-href="${pageContext.request.contextPath}<%=ViewPaths.USER_PROJECTS_EDIT_BOARD%>/{{item.boardId}}"></a>
				<a class="glyphicon glyphicon-trash" href="javascript:void(0)" ng-click="deleteBoard(item.boardId, $index)"></a>
			</c:if>
			<c:if test="${access.approveBoard}">
				<%-- Approve board --%>
				<a class="glyphicon glyphicon-ok" ng-if="item.publishToMP==2" href="javascript:void(0);" ng-click="approveBoardHandler(item)"></a>
				<%-- Reject board --%>
				<a class="glyphicon glyphicon-remove" ng-if="item.publishToMP==2" href="javascript:void(0);" ng-click="rejectBoardHandler(item)"></a>
			</c:if>
		</div>
		<%-- Shopping Cart feature --%>
		<%-- Disable for now --%>
		<%--
		<c:if test="${access.shoppingCart}">
			<a href="javascript:void(0);" class="img-cart-function default" ng-click="processItem(item.boardId)">
				<span class="glyphicon glyphicon-plus" ng-class="{'glyphicon-minus': addedItems[item.boardId]}"></span><!--
				--><span class="glyphicon glyphicon-shopping-cart"></span><!-- 
				--><span ng-show="isAdding[item.boardId] || isRemoving[item.boardId]" class="glyphicon glyphicon-refresh"></span>
			</a>
		</c:if>
		--%>
		<div class="img-cart-status default" ng-show="addedItems[item.boardId]"><span class="glyphicon glyphicon-ok"></span>&nbsp;<span class="stat">Added</span></div>
		<div class="img-info-loading"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Loading...</div>
	</div>
	<div class="img-info-holder iih-show-hide" ng-show="showDetailInfo($index)" ng-if="$index%(columnsPerRow)==(columnsPerRow-1) || ($last && $index%(columnsPerRow)!=(columnsPerRow-1))" ng-repeat-end>
		<div class="img-info-wrapper">
			<div class="img-info-controller">
				<a href="javascript:void(0);" class="img-info-close" ng-click="closeDetail($index)">X</a>
			</div>
			<div class="img-info-content">
				<div class="left-panel">
					<div class="img-wrapper">
						<img src="/bigimage/{{boardDetail.imageurl_original}}" alt=""/>
					</div>
				</div>
				<div class="right-panel">
					<div class="right-panel-row mi board-name">{{boardDetail.detail.name}}</div>
					<%-- <div class="right-panel-row mi board-price" ng-if="!hasAdditionAccess">$&nbsp;{{boardDetail.detail.totalPrice}}</div> --%>
					<div class="right-panel-row user-type">Designer:&nbsp;{{boardDetail.designerName}}</div>
					<div class="right-panel-row">
						<ul>
							<c:if test="${access.viewProfile}">
								<li><a href="javascript:void(0);" class="button" ng-click="showUserDetail(boardDetail.detail.originalUserId)">View this designer's profile</a></li>
							</c:if>
							<c:if test="${access.fileDownload}">
								<li ng-if="hasAdditionAccess"><a target="_BLANK" href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_RETRIEVE_FILE%>?sourcefile={{boardDetail.detail.boardImages[0].sourceFileURL}}">Download source file</a></li>
							</c:if>
							<c:if test="${access.viewMainImage}">
								<li><a target="_BLANK" href="javascript:void(0);" ng-click="showImageWindow(boardDetail.detail.boardImages[0].mainImageUrl)">View image in new window</a></li>
							</c:if>
						</ul>
					</div>
					<c:if test="${access.showBoardStatus}">
						<div class="right-panel-row">Status:&nbsp;{{boardDetail.detail.boardStatus}}</div>
					</c:if>
					<div class="right-panel-row">Description:&nbsp;{{boardDetail.detail.description}}</div>
					<c:if test="${access.showRelatedBoards}">
						<div class="imgs-container larger" ng-if="hasAdditionAccess">
							<div class="right-panel-row" ng-if="filterList(boardDetail.boardsByPortfolio,boardDetail.detail.boardId).length>0">Related images:</div>
							<div class="img-holder" ng-repeat="riItem in filterList(boardDetail.boardsByPortfolio,boardDetail.detail.boardId)">
								<img class="img-nail" src="/400x400/{{riItem.boardImages[0].fileName}}" ng-click="getDetail($event,riItem.boardId,detailIndex)"/>
							</div>
						</div>
					</c:if>
					<c:if test="${access.showSuggestBoards}">
						<div class="imgs-container larger">
							<div class="right-panel-row" ng-if="boardDetail.boardsSuggestion.length>0">You Might Also Like:</div>
							<div class="img-holder" ng-repeat="bsItem in boardDetail.boardsSuggestion">
								<img class="img-nail" src="/400x400/{{bsItem.tileImageUrl}}" ng-click="getDetail($event,bsItem.boardId,detailIndex)"/>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>