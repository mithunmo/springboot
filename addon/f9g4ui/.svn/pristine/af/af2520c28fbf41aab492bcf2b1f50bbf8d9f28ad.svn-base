<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<%-- Project list viewer component --%>
<!-- Notification bar -->
<div class="sync gap" ng-show="isLoading"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Loading. Please wait...</div>
<!-- Data Table -->
<table class="projects-viewer pv-a">
	<thead>
		<tr>
			<%--
				Type 
				Title
				Status
				Submissions
				Ends
				Docs
				Actions
			--%>
			<th><a href="javascript:void(0);" class="glyphicon {{sortIcon[1]}}" ng-click="sort(1)"></a>Type</th>
			<th><a href="javascript:void(0);" class="glyphicon {{sortIcon[7]}}" ng-click="sort(7)"></a>Project ID</th>
			<th><a href="javascript:void(0);" class="glyphicon {{sortIcon[2]}}" ng-click="sort(2)"></a>Title</th>
			<th><a href="javascript:void(0);" class="glyphicon {{sortIcon[3]}}" ng-click="sort(3)"></a>Status</th>
			<th><%-- <a href="javascript:void(0);" class="glyphicon {{sortIcon[4]}}" ng-click="sort(4)"></a> --%>Submissions</th>
			<th><a href="javascript:void(0);" class="glyphicon {{sortIcon[5]}}" ng-click="sort(5)"></a>Ends</th>
			<th><a href="javascript:void(0);" class="glyphicon {{sortIcon[6]}}" ng-click="sort(6)"></a>Docs</th>
			<th><a href="javascript:void(0);" class="glyphicon {{sortIcon[8]}}" ng-click="sort(8)" tooltip-placement="top" tooltip="Sort by passDue status"></a>Actions</th>
			<!-- <th><a href="javascript:void(0);" class="glyphicon {{sortIcon[8]}}" ng-click="sort(8)"></a>Ends</th> -->
		</tr>
	</thead>
	<tbody>
		<%--
			item.contestStatusMap['id']
			0: suspended
			1: published
			2: cancelled
			3: Completed
			4: Running
			5: Pending
			6: Unknown
		--%>
		<tr class="proj-nav" ng-repeat="item in displayData" ng-click="boardsView(item.originalData.contestPortfolioDomain.portfolioId)">
			<td><span class="proj-label t" ng-class="{tg: item.contestTypeMap['4'], tr: item.contestTypeMap['1'] || item.contestTypeMap['3'] , tb: item.contestTypeMap['2'] || item.contestTypeMap['0']}">{{item.contestType}}</span></td>
			<td><span class="proj-label tt">{{item.projectId}}</span></td>
			<td><span class="proj-label tt">{{item.originalData.contestPortfolioDomain.name}}</span></td>
			<td><span class="proj-status" ng-class="{r: item.contestStatusMap['0'] || item.contestStatusMap['2'] || item.contestStatusMap['6'], g: item.contestStatusMap['1'] || item.contestStatusMap['4'], b: item.contestStatusMap['5'], gr: item.contestStatusMap['3']}">{{item.contestStatus}}</span></td>
			<td>
				<span class="proj-rem-days"><span class="glyphicon glyphicon-time"></span>{{item.remainingDays}} days</span>
				<span class="proj-subs"><span class="glyphicon glyphicon-picture"></span><span class="glyphicon glyphicon-refresh" ng-if="item.boards == -1 || item.boards == undefined"></span><span ng-if="item.boards != -1 && item.boards != undefined">{{item.boards.length}}</span> submissions</span>
			</td>
			<td><div class="proj-end"><span class="month">{{item.endDateInMonth}}</span><span class="day">{{item.endDateInDay}}</span></div></td>
			<td class="proj-docs">
				<span ng-repeat="imgItem in item.originalData.contestPortfolioDomain.portfolioImages">
					<a ng-if="imgItem.fileType != 'jpg'" href="${pageContext.request.contextPath}/file?sourcefile={{imgItem.sourceFileURL}}" ng-click="$event.stopPropagation();" target="_blank"><img ng-src="/100x100/{{imgItem.thumbnailUrl}}" /></a>
					<a ng-if="imgItem.fileType == 'jpg'" href="javascript:void(0);" ng-click="showImageWindow(imgItem.mainImageUrl); $event.stopPropagation();" target="_blank"><img ng-src="/100x100/{{imgItem.thumbnailUrl}}" /></a>
				</span>
			</td>
			<td class="proj-acts" ng-click="$event.stopPropagation()">
				<div class="acts-panel">
					<%-- PassDue  --%><span ng-if="item.passDue && !item.contestStatusMap['3'] && !item.contestStatusMap['5'] && !item.contestStatusMap['6']" class="act-label"><span class="act-icon glyphicon glyphicon-exclamation-sign" tooltip-placement="bottom" tooltip="Due Date has passed today. Please perform any action ASAP."></span></span>
					<%-- Edit     --%><a ng-if="!item.contestStatusMap['3']" class="act-label" ng-href="${pageContext.request.contextPath}<%=ViewPaths.ADMIN_PROJECTS_UPDATE_PROJECT%>/{{item.originalData.contestPortfolioDomain.portfolioId}}/{{item.originalData.contestId}}" ng-click="$event.stopPropagation();"><span class="act-icon glyphicon glyphicon-pencil" tooltip-placement="bottom" tooltip="Edit Porject"></span></a>
					<a class="act-label" href="${pageContext.request.contextPath}<%=ViewPaths.ADMIN_PROJECTS_VIEW_CREATIVE_BRIEF_DETAIL%>?portfolioId={{item.originalData.portfolioId}}&contestId={{item.originalData.contestId}}" target="_self" ng-click="$event.stopPropagation();"><span class="act-icon glyphicon glyphicon-file" tooltip-placement="bottom" tooltip="View Creative Brief"></span></a>
					<%-- PAUSE    --%><a ng-if="item.contestStatusMap['4'] && !item.passDue" class="act-label" href="javascript:void(0);" ng-click="$event.stopPropagation(); pauseProject(item.originalData.portfolioId,item.originalData.contestId,$index)"><span class="act-icon glyphicon glyphicon-pause" tooltip-placement="bottom" tooltip="Pause Porject"></span></a>
					<%-- RESUME   --%><a ng-if="(item.contestStatusMap['0'] || item.contestStatusMap['1']) && !item.passDue" class="act-label" href="javascript:void(0);" ng-click="$event.stopPropagation(); resumeProject(item.originalData.portfolioId,item.originalData.contestId,$index)"><span class="act-icon glyphicon glyphicon-play" tooltip-placement="bottom" tooltip="Resume Porject"></span></a>
					<%-- COMPLETE --%><a ng-if="item.contestStatusMap['4']" class="act-label" href="javascript:void(0);" ng-click="$event.stopPropagation(); completeProject(item.originalData.portfolioId,item.originalData.contestId,$index)"><span class="act-icon glyphicon glyphicon-ok" tooltip-placement="bottom" tooltip="Close Porject"></span></a>
					<%-- DELETE   --%><a ng-if="!item.contestStatusMap['3']" class="act-label" href="javascript:void(0);" ng-click="$event.stopPropagation(); cancelProject(item.originalData.portfolioId,item.originalData.contestId,$index);"><span class="act-icon glyphicon glyphicon-trash" tooltip-placement="bottom" tooltip="Delete Porject"></span></a>
				</div>
			</td>
		</tr>
	</tbody>
</table>