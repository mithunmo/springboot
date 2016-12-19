<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<!-- Pagin -->
<div class="pagin-holder gap">
	<div class="pagin left">
		<div class="col-md-4">
			<div class="input-group">
			  	<span class="input-group-addon">Show rows</span>
			  	<select class="form-control" ng-model="rowsPerPage" ng-change="updateRows()">
			  		<option value="5">5</option>
			  		<option value="10">10</option>
			  		<option value="20">20</option>
			  		<option value="30">30</option>
			  	</select>
			</div>
		</div>
		<div class="col-md-3">
			<div class="input-group">
				<!-- <span class="input-group-addon">Go to</span> -->
			  	<input type="text" class="form-control" ng-model="itemIndex" ng-keypress="navigateHandler($event)">
			  	<span class="input-group-btn">
     					<button class="btn btn-default" type="button" ng-click="navigateHandler()">Go</button>
   				</span>
			</div>
		</div>
		<div class="col-md-3">
			<span class="form-control fh" data-total-pages="{{totalPages}}">{{lowerBound+1}} - {{upperBound}} of {{items.length}}</span>
		</div>
		<div class="col-md-1">
			<a class="btn btn-default" ng-click="prevPage()"><i class="glyphicon glyphicon-chevron-left"></i></a>
		</div>
		<div class="col-md-1">
			<a class="btn btn-default" ng-click="nextPage()"><i class="glyphicon glyphicon-chevron-right"></i></a>
		</div>
	</div>
	<div class="pagin-function right">
		<div class="cbuttons rt npad">
			<!-- <a class="cbutton pad large" href="javascript:void(0);">New collection</a> -->
			<a class="cbutton pad large" ng-href="${pageContext.request.contextPath}<%=ViewPaths.USER_PROJECTS_CREATE_BOARD%>/{{portfolioId}}">New Submission</a>
		</div>
	</div>
</div>

<!-- Board Viewer -->
<div class="content-holder expand imgs-container med">
	<div class="cover gap" ng-show="isLoading"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Loading. Please wait...</div>
	<div class="cover" ng-show="isUpdating"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Updating data. Please wait...</div>
	<div class="cover" ng-show="isEmptyResult"><i class="glyphicon glyphicon-warning-sign"></i>&nbsp;&nbsp;Empty. Please refine search criteria.</div>
	<div class="cover" ng-show="isCartSyncing"><i class="glyphicon glyphicon-warning-sign"></i>&nbsp;&nbsp;Update Shopping Cart Information.</div>
	<div class="img-holder {{isSelected[$index]}} {{loading[$index]}}" ng-class="{deleting:item.deleting}" data-seq="{{$index}}" ng-repeat-start="item in items">
		<img class="img-nail" src="/400x400/{{item.boardImages[0].fileName}}" data-seq="{{$index}}" ng-click="getDetail($event,item.boardId,$index)"/>
		<div class="img-label"><span class="glyphicon glyphicon-repeat"></span>&nbsp;<span class="glyphicon glyphicon-trash"></span>&nbsp;Deleting..</div>
		<div class="img-function-panel default">
			<a class="glyphicon glyphicon-pencil" ng-href="${pageContext.request.contextPath}<%=ViewPaths.USER_PROJECTS_EDIT_BOARD%>/{{item.boardId}}"></a>
			<a class="glyphicon glyphicon-trash" href="javascript:void(0)" ng-click="deleteBoard(item.boardId, $index)"></a>
		</div>
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
							<%-- <li><a href="javascript:void(0);" class="button">View this designer's profile</a></li> --%>
							<%-- <li ng-if="hasAdditionAccess"><a target="_BLANK" href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_RETRIEVE_FILE%>?sourcefile={{boardDetail.detail.boardImages[0].sourceFileURL}}">Download source file</a></li> --%>
							<li><a target="_BLANK" href="javascript:void(0);" ng-click="showImageWindow(boardDetail.detail.boardImages[0].mainImageUrl)">View image in new window</a></li>
						</ul>
					</div>
					<div class="right-panel-row">Status:&nbsp;{{boardDetail.detail.boardStatus}}</div>
					<div class="right-panel-row">Description:&nbsp;{{boardDetail.detail.description}}</div>
					<div class="imgs-container larger" ng-if="hasAdditionAccess">
						<div class="right-panel-row" ng-if="filterList(boardDetail.boardsByPortfolio,boardDetail.detail.boardId).length>0">Related images:</div>
						<div class="img-holder" ng-repeat="riItem in filterList(boardDetail.boardsByPortfolio,boardDetail.detail.boardId)">
							<img class="img-nail" src="/400x400/{{riItem.boardImages[0].fileName}}" ng-click="getDetail($event,riItem.boardId,detailIndex)"/>
						</div>
					</div>
					<%-- <div class="imgs-container larger">
						<div class="right-panel-row" ng-if="boardDetail.boardsSuggestion.length>0">You Might Also Like:</div>
						<div class="img-holder" ng-repeat="bsItem in boardDetail.boardsSuggestion">
							<img class="img-nail" src="/400x400/{{bsItem.tileImageUrl}}" ng-click="getDetail($event,bsItem.boardId,detailIndex)"/>
						</div>
					</div> --%>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Pagin -->
<div class="pagin-holder gap">
	<div class="pagin">
		<div class="col-md-4">
			<div class="input-group">
			  	<span class="input-group-addon">Show rows</span>
			  	<select class="form-control" ng-model="rowsPerPage" ng-change="updateRows()">
			  		<option value="5">5</option>
			  		<option value="10">10</option>
			  		<option value="20">20</option>
			  		<option value="30">30</option>
			  	</select>
			</div>
		</div>
		<div class="col-md-3">
			<div class="input-group">
				<!-- <span class="input-group-addon">Go to</span> -->
			  	<input type="text" class="form-control" ng-model="itemIndex" ng-keypress="navigateHandler($event)">
			  	<span class="input-group-btn">
     					<button class="btn btn-default" type="button" ng-click="navigateHandler()">Go</button>
   				</span>
			</div>
		</div>
		<div class="col-md-3">
			<span class="form-control fh" data-total-pages="{{totalPages}}">{{lowerBound+1}} - {{upperBound}} of {{items.length}}</span>
		</div>
		<div class="col-md-1">
			<a class="btn btn-default" ng-click="prevPage()"><i class="glyphicon glyphicon-chevron-left"></i></a>
		</div>
		<div class="col-md-1">
			<a class="btn btn-default" ng-click="nextPage()"><i class="glyphicon glyphicon-chevron-right"></i></a>
		</div>
	</div>
</div>