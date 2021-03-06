<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<!-- Pagin -->
<div class="pagin-holder nogap">
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
			<span class="form-control fh" data-total-pages="{{totalPages}}">{{lowerBound+1}} - {{upperBound}} of {{contests.length}}</span>
		</div>
		<div class="col-md-1">
			<a class="btn btn-default" ng-click="prevPage()"><i class="glyphicon glyphicon-chevron-left"></i></a>
		</div>
		<div class="col-md-1">
			<a class="btn btn-default" ng-click="nextPage()"><i class="glyphicon glyphicon-chevron-right"></i></a>
		</div>
	</div>
</div>
<!-- Notification bar -->
<div class="sync gap" ng-show="isLoading"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Loading. Please wait...</div>
<!-- Data Table -->
<table class="projects-viewer pv-d">
	<thead>
		<tr>
			<th>Buyer</th>
			<th><a href="javascript:void(0);" class="glyphicon {{sortIcon[2]}}" ng-click="sort(2)"></a>Type</th>
			<th><a href="javascript:void(0);" class="glyphicon {{sortIcon[3]}}" ng-click="sort(3)"></a>Title</th>
			<th><a href="javascript:void(0);" class="glyphicon {{sortIcon[4]}}" ng-click="sort(4)"></a>Season</th>
			<th><a href="javascript:void(0);" class="glyphicon {{sortIcon[5]}}" ng-click="sort(5)"></a>Docs</th>
			<th><a href="javascript:void(0);" class="glyphicon {{sortIcon[6]}}" ng-click="sort(6)"></a>Award</th>
			<th><%--<a href="javascript:void(0);" class="glyphicon {{sortIcon[7]}}" ng-click="sort(7)"></a>--%>Submissions</th>
			<th><a href="javascript:void(0);" class="glyphicon {{sortIcon[8]}}" ng-click="sort(8)"></a>Ends</th>
		</tr>
	</thead>
	<tbody>
		<tr class="proj-nav" ng-repeat="item in displayData" ng-click="creativeBriefView(item.originalData.contestPortfolioDomain.portfolioId,item.originalData.contestId)">
			<td><img class="proj-user-logo" ng-src="{{item.originalData.contestPortfolioDomain.user.logoimageurl}}" /></td>
			<td><span class="proj-label t" ng-class="{tg: item.contestTypeMap['4'], tr: item.contestTypeMap['1'] || item.contestTypeMap['3'] , tb: item.contestTypeMap['2']}">{{item.contestType}}</span></td>
			<td><span class="proj-label tt">{{item.originalData.contestPortfolioDomain.name}}</span></td>
			<td><span class="proj-label s" ng-class="{'s-spring': item.seasonYearMap['isSpring'], 's-summer': item.seasonYearMap['isSummer'], 's-fall': item.seasonYearMap['isFall'], 's-winter': item.seasonYearMap['isWinter'], 's-other': item.seasonYearMap['isOther']}">{{item.seasonYear.season}}</span></td>
			<td class="proj-docs">
				<span ng-repeat="imgItem in item.originalData.contestPortfolioDomain.portfolioImages">
					<a ng-if="imgItem.fileType != 'jpg'" href="${pageContext.request.contextPath}/file?sourcefile={{imgItem.sourceFileURL}}" ng-click="$event.stopPropagation();" target="_blank"><img ng-src="/100x100/{{imgItem.thumbnailUrl}}" /></a>
					<a ng-if="imgItem.fileType == 'jpg'" href="javascript:void(0);" ng-click="$event.stopPropagation();showImageWindow(imgItem.mainImageUrl);" target="_blank"><img ng-src="/100x100/{{imgItem.thumbnailUrl}}" /></a>
				</span>
			</td>
			<td class="proj-award">{{item.originalData.numberOfWinners}}</td>
			<td>
				<span class="proj-rem-days"><span class="glyphicon glyphicon-time"></span>{{item.remainingDays}} days</span>
				<span class="proj-subs"><span class="glyphicon glyphicon-picture"></span><span class="glyphicon glyphicon-refresh" ng-if="item.boards == -1 || item.boards == undefined"></span><span ng-if="item.boards != -1 && item.boards != undefined">{{item.boards.length}}</span> submissions</span>
			</td>
			<td><div class="proj-end"><span class="month">{{item.endDateInMonth}}</span><span class="day">{{item.endDateInDay}}</span></div></td>
		</tr>
	</tbody>
</table>

<!-- Pagin -->
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
			<span class="form-control fh" data-total-pages="{{totalPages}}">{{lowerBound+1}} - {{upperBound}} of {{contests.length}}</span>
		</div>
		<div class="col-md-1">
			<a class="btn btn-default" ng-click="prevPage()"><i class="glyphicon glyphicon-chevron-left"></i></a>
		</div>
		<div class="col-md-1">
			<a class="btn btn-default" ng-click="nextPage()"><i class="glyphicon glyphicon-chevron-right"></i></a>
		</div>
	</div>
</div>