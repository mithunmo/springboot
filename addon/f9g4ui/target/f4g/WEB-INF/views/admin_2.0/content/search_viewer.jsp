<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Content -->
<div class="content content-wrapper" ng-controller="adminSearchViewer">
	<div class="content-holder">
		<div class="title">ADMINISTRATOR</div>
		<div class="date-range">
			<div class="col-md-6">
				<p class="input-group" ng-controller="datePickerController">
	              <input type="text" class="form-control" datepicker-popup="{{format}}" ng-model="$parent.dt_start" is-open="opened" max-date="$parent.dt_end" datepicker-options="dateOptions" date-disabled="disabled(date, mode)" ng-required="true" close-text="Close" ng-change="dateChange()" placeholder="Date From"/>
	              <span class="input-group-btn">
	                <button type="button" class="btn btn-default" ng-click="open($event)"><i class="glyphicon glyphicon-calendar"></i></button>
	              </span>
	            </p>
            </div>
            <div class="col-md-6">
				<p class="input-group" ng-controller="datePickerController">
	              <input type="text" class="form-control" datepicker-popup="{{format}}" ng-model="$parent.dt_end" is-open="opened" min-date="$parent.dt_start" datepicker-options="dateOptions" date-disabled="disabled(date, mode)" ng-required="true" close-text="Close" ng-change="dateChange()" placeholder="Date To"/>
	              <span class="input-group-btn">
	                <button type="button" class="btn btn-default" ng-click="open($event)"><i class="glyphicon glyphicon-calendar"></i></button>
	              </span>
	            </p>
            </div>
		</div>
		<div class="tabs">
			<div class="header">
				<a class="item" href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_SEARCH_CRITERIA%>" target="_self">Refine Search</a>
				<a class="item {{selectedTab['portfolioPages']}}" href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_SEARCH_VIEWER%>#portfolioPages">Portfolio Pages</a>
				<a class="item {{selectedTab['marketplaceSubmissions']}}" href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_SEARCH_VIEWER%>#marketplaceSubmissions" ng-click="show()" data-target="3">Marketplace</a>
				<a class="item {{selectedTab['examples']}}" href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_SEARCH_VIEWER%>#examples" ng-click="show()" data-target="3">Examples</a>
			</div>
			<div class="function">
			</div>			
		</div>
	</div>
	<c:set var="groupIndex" value="1" />
	<div class="content-holder expand imgs-container">
		<div class="cover" ng-show="isUpdating"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Updating data. Please wait...</div>
		<div class="cover" ng-show="isEmptyResult"><i class="glyphicon glyphicon-warning-sign"></i>&nbsp;&nbsp;Empty. Please refine search criteria.</div>
		<div class="img-holder {{isSelected[$index]}} {{loading[$index]}}" data-seq="{{$index}}" ng-repeat-start="item in items">
			<img class="img-nail" src="/400x400/{{item.tileImageUrl}}" data-seq="{{$index}}" ng-click="getDetail($event,item.boardId,$index)"/>
			<div class="img-info-loading"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Loading...</div>
		</div>
		<div class="img-info-holder iih-show-hide" ng-show="showImgInfo($index)" ng-if="$index%(columnsPerRow)==(columnsPerRow-1) || ($last && $index%(columnsPerRow)!=(columnsPerRow-1))" ng-repeat-end>
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
						<div class="right-panel-row mi board-price" ng-if="!hasAdditionAccess">$&nbsp;{{boardDetail.detail.totalPrice}}</div>
						<div class="right-panel-row user-type">Designer:&nbsp;{{boardDetail.designerName}}</div>
						<div class="right-panel-row">
							<ul>
								<li><a href="javascript:void(0);" class="button">View this designer's profile</a></li>
								<li ng-if="hasAdditionAccess"><a target="_BLANK" href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_RETRIEVE_FILE%>?sourcefile={{boardDetail.detail.boardImages[0].sourceFileURL}}">Download source file</a></li>
								<li ng-if="hasAdditionAccess"><a target="_BLANK" href="javascript:void(0);" ng-click="showImageWindow(boardDetail.detail.boardImages[0].mainImageUrl)">View image in new window</a></li>
							</ul>
						</div>
						<div class="right-panel-row">Description:&nbsp;{{boardDetail.detail.description}}</div>
						<div class="imgs-container larger" ng-if="hasAdditionAccess">
							<div class="right-panel-row" ng-if="filterList(boardDetail.boardsByPortfolio,boardDetail.detail.boardId).length>0">Related images:</div>
							<div class="img-holder" ng-repeat="riItem in filterList(boardDetail.boardsByPortfolio,boardDetail.detail.boardId)">
								<img class="img-nail" src="/400x400/{{riItem.boardImages[0].fileName}}" ng-click="getDetail($event,riItem.boardId,detailIndex)"/>
							</div>
						</div>
						<div class="imgs-container larger">
							<div class="right-panel-row" ng-if="boardDetail.boardsSuggestion.length>0">You Might Also Like:</div>
							<div class="img-holder" ng-repeat="bsItem in boardDetail.boardsSuggestion">
								<img class="img-nail" src="/400x400/{{bsItem.tileImageUrl}}" ng-click="getDetail($event,bsItem.boardId,detailIndex)"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="pagin-holder">
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
				<span class="form-control fh" data-total-pages="{{totalPages}}">{{lowerBound+1}} - {{upperBound}} of {{data.length}}</span>
			</div>
			<div class="col-md-1">
				<a class="btn btn-default" ng-click="prevPage()"><i class="glyphicon glyphicon-chevron-left"></i></a>
			</div>
			<div class="col-md-1">
				<a class="btn btn-default" ng-click="nextPage()"><i class="glyphicon glyphicon-chevron-right"></i></a>
			</div>
		</div>
	</div>
</div>
