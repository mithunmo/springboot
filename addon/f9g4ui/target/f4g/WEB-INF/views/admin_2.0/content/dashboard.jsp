<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<!-- Content -->
<div class="content content-wrapper" ng-controller="dashboard">
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
		<div class="tiles">
			<div class="tile">
				<div class="upper" data-count="{{signups}}">{{signupsDisplay | upperBound:100000}}</div>
				<div class="lower">Sign Ups</div>
			</div>
			<div class="tile">
				<div class="upper">{{examplesCount | upperBound: 1000000}}</div>
				<div class="lower g">Examples</div>
			</div>
			<div class="tile">
				<div class="upper">{{boardsCount | upperBound: 1000000}}</div>
				<div class="lower b">Boards</div>
			</div>
		</div>
		<div class="tabs">
			<div class="header">
				<a class="item selected">Sign Ups</a>
				<a class="item">Marketplace</a>
				<a class="item">Project Submissions</a>
				<a class="item">Messages</a>
			</div>
			<div class="function">
				<div class="item lf lh">Viewing:&nbsp;{{filteredUsers.length || 0}}</div>
				<div class="item lf lh">Search:<input type="text" ng-keyup="userSearch($event)" ng-model="keyword" /></div>
				<div class="item lf lh" ng-show="!loadCompleted"><span class="glyphicon glyphicon-cog"></span>&nbsp;Loading {{loadingProgress}}%...&nbsp;<a href="javascript:void(0);" class="glyphicon glyphicon-refresh" ng-click="reload()"></a></div>
				<div class="item rf icon pt" ng-click="hide()" tooltip-placement="top" tooltip="Hide Users"><i class="glyphicon glyphicon-eye-close"></i>&nbsp;<span>---</span></div>
				<div class="item rf icon pt" ng-click="archived()" tooltip-placement="top" tooltip="Archive Users"><i class="glyphicon glyphicon-briefcase"></i>&nbsp;<span>---</span></div>
				<div class="item rf icon pt" ng-click="sendMsg()" tooltip-placement="top" tooltip="Send Message"><i class="glyphicon glyphicon-envelope"></i>&nbsp;<span>{{selectedUsersCount}}</span></div>
				<div class="item rf icon pt" ng-click="assignProjectUtil()" tooltip-placement="top" tooltip="Assign Project"><i class="glyphicon glyphicon-file"></i>&nbsp;<span>{{selectedUsersCount}}</span></div>
				<div class="item rf icon pt" ng-click="userAdvanceSearch()" tooltip-placement="top" tooltip="User Advance Search"><i class="glyphicon glyphicon-search"></i></div>
			</div>
			<%-- User Advance Search --%>
			<div class="body box-container" ng-show="showAdvanceUserSearchUtil">
				<div class="box-wrapper">
					<div class="box-panel">
						<div class="box-panel-title">Send Message</div>
						<div>To:(Click the label to delete from the list)</div>
						<div class="user-label-panel">
							<span class="user-label {{usersName[key].status}}" ng-repeat="(key,value) in selectedUsers" ng-if="value==true" ng-click="deleteRecipient(key)">{{usersName[key].name}}</span>
						</div>
						<div class="msg-editor">
							<div class="msg-editor-element">
								Subject: <input ng-model="mailEntry.mailSubject" />
							</div>
							<div class="msg-editor-element">
								<textarea rows="" cols="" ng-model="mailEntry.mailContent"></textarea>
							</div>
						</div>
						<div>
							<div class="cbuttons">
								<a href="javascript:void(0)" class="cbutton pad" ng-click="sendMessageHandler()">Send</a>
								<a href="javascript:void(0)" class="cbutton pad r" ng-click="clearMessageHandler('all')">Clear All</a>
								<a href="javascript:void(0)" class="cbutton pad r" ng-click="clearMessageHandler('recp')">Clear Recipient</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%-- Assign Project --%>
			<div class="body box-container" ng-show="showAssignProjectUtil" ng-controller="assignProjController">
				<div class="box-wrapper">
					<div class="box-tray">
						<a href="javascript:void(0);" class="glyphicon glyphicon-th-large" ng-click="changeMode()"></a>
						<a href="javascript:void(0);" class="glyphicon glyphicon-remove" ng-click="assignProjectUtil()"></a>
					</div>
					<div class="box-panel">
						<div class="box-comp-holder">
							<div class="box-comp">
								<div class="box-panel-title">Assign Projects</div>
								<div class="box-label">Please select the project you would like to assign:</div>
								<div
			 						style="max-width:450px;"     
							    	multi-select
							    	input-model="projectList"
							    	output-model="selectedProjectList"
							    	button-label="projectId title"
							    	item-label="projectId title"
							    	tick-property="ticked"
							    	max-labels="3"
							    	max-height="250px"
							    	selection-mode="single"
							    	helper-elements="reset filter"
							    	on-item-click="selectProjectItem(data)">
								</div>
							</div>
						</div>
						<div class="box-comp-holder" ng-class="{vertical: verticalMode}">
							<div class="box-comp">
								<div class="box-label">Current project members:</div>
								<div class="user-label-panel">
									<div class="panel-label loading" ng-if="isLoadingProjectMembers"><span class="glyphicon glyphicon-cog"></span>&nbsp;Loading...</div>
									<div class="panel-label empty" ng-if="(isLoadingProjectMembers==false || isLoadingProjectMembers==undefined) && (hasEmptyMembers==true || hasEmptyMembers==undefined)">Empty</div>
									<span class="user-label {{obj.status}}" ng-class="{delete: !obj.value}" ng-repeat="(key,obj) in projectMembers" ng-click="toggleMember(key)">{{obj.name}}</span>
								</div>
							</div><!--
							--><div class="box-comp">
								<div class="box-label">Selected users:(Click the label to delete from the list)</div>
								<div class="user-label-panel">
									<div class="panel-label empty" ng-if="selectedUsersCount<=0 || selectedUsersCount==undefined">Empty</div>
									<span class="user-label {{usersName[key].status}}" ng-repeat="(key,value) in selectedUsers" ng-if="value==true" ng-click="deleteRecipient(key)">{{usersName[key].name}}</span>
								</div>
							</div><!--
							--><div class="box-comp">
								<div class="box-label">Project members after assigned:</div>
								<div class="user-label-panel">
									<div class="panel-label loading" ng-if="isLoadingProjectMembers"><span class="glyphicon glyphicon-cog"></span>&nbsp;Loading...</div>
									<div class="panel-label empty" ng-if="!isLoadingProjectMembers && countUsers(assignUsers)<=0">Empty</div>
									<span class="user-label {{obj.status}}" ng-repeat="(key,obj) in assignUsers" ng-if="!isLoadingProjectMembers && obj.value==true" ng-click="deleteMember(key)">{{obj.name}}</span>
								</div>
							</div>
						</div>
						<div>
							<div class="cbuttons">
								<a href="javascript:void(0)" class="cbutton pad" ng-click="assignProject()">Assign</a>
								<%-- <a href="javascript:void(0)" class="cbutton pad r" ng-click="clearProjectMembers({all:true})">Clear All</a> --%>
								<a href="javascript:void(0)" class="cbutton pad r" ng-click="clearProjectMembers({recp:true})">Clear Selected Users</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%-- Message Box --%>
			<div class="body box-container" ng-show="showMsgBox">
				<div class="box-wrapper">
					<div class="box-tray">
						<a href="javascript:void(0);" class="glyphicon glyphicon-remove" ng-click="sendMsg()"></a>
					</div>
					<div class="box-panel">
						<div class="box-panel-title">Send Message</div>
						<div>To:(Click the label to delete from the list)</div>
						<div class="user-label-panel">
							<span class="user-label {{usersName[key].status}}" ng-repeat="(key,value) in selectedUsers" ng-if="value==true" ng-click="deleteRecipient(key)">{{usersName[key].name}}</span>
						</div>
						<div class="msg-editor">
							<div class="msg-editor-element">
								Subject: <input ng-model="mailEntry.mailSubject" />
							</div>
							<div class="msg-editor-element">
								<textarea rows="" cols="" ng-model="mailEntry.mailContent"></textarea>
							</div>
						</div>
						<div>
							<div class="cbuttons">
								<a href="javascript:void(0)" class="cbutton pad" ng-click="sendMessageHandler()">Send</a>
								<a href="javascript:void(0)" class="cbutton pad r" ng-click="clearMessageHandler('all')">Clear All</a>
								<a href="javascript:void(0)" class="cbutton pad r" ng-click="clearMessageHandler('recp')">Clear Recipient</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="pagin-holder gap">
				<div class="pagin">
					<div class="col-md-4">
						<div class="input-group">
						  	<span class="input-group-addon">Show rows</span>
						  	<select class="form-control" ng-model="rowsPerPage" ng-change="updateRows()">
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
						<span class="form-control fh" data-total-pages="{{totalPages}}">{{lowerBound+1}} - {{upperBound}} of {{data.usersCount}} ({{data.users.length}})</span>
					</div>
					<div class="col-md-1">
						<a class="btn btn-default" ng-click="prevPage()"><i class="glyphicon glyphicon-chevron-left"></i></a>
					</div>
					<div class="col-md-1">
						<a class="btn btn-default" ng-click="nextPage()"><i class="glyphicon glyphicon-chevron-right"></i></a>
					</div>
				</div>
			</div>
			<div class="body">
				<table class="users-viewer">
					<thead>
						<tr>
							<th></th>
							<th></th>
							<th>Name&nbsp;<a href="javascript:void(0);" class="glyphicon {{sortIcon[1]}}" ng-click="sort(1)"></a></th>
							<th>Email&nbsp;<a href="javascript:void(0);" class="glyphicon {{sortIcon[2]}}" ng-click="sort(2)"></a></th>
							<th>Signup Date&nbsp;<a href="javascript:void(0);" class="glyphicon {{sortIcon[3]}}" ng-click="sort(3)"></a></th>
							<th>Rating&nbsp;<a href="javascript:void(0);" class="glyphicon {{sortIcon[4]}}" ng-click="sort(4)"></a></th>
							<th>Status&nbsp;<a href="javascript:void(0);" class="glyphicon {{sortIcon[5]}}" ng-click="sort(5)"></a></th>
							<th>Profile&nbsp;<a href="javascript:void(0);" class="glyphicon {{sortIcon[6]}}" ng-click="sort(6)"></a></th>
							<th>Source&nbsp;<a href="javascript:void(0);" class="glyphicon {{sortIcon[7]}}" ng-click="sort(7)"></a></th>
							<th>Messages&nbsp;<a href="javascript:void(0);" class="glyphicon {{sortIcon[8]}}" ng-click="sort(8)"></a></th>
							<th>Portfolio&nbsp;<a href="javascript:void(0);" class="glyphicon {{sortIcon[9]}}" ng-click="sort(9)"></a></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in users">
							<td><input class="" type="checkbox" ng-value="{{item.userId}}" ng-change="updateUserCount(item)" ng-model="selectedUsers[item.userId]" /></td>
							<td><a href="javascript:void(0)" user-profile ng-click="showUserDetail(item.userId)"><img class="user-logo" src="{{item.logoimageurl}}" /></a></td>
							<td><a href="javascript:void(0)" user-profile ng-click="showUserDetail(item.userId)">{{item.firstname}}&nbsp;{{item.lastname}}</a></td>
							<td>{{item.userName}}</td>
							<td>{{signupdate[item.userId]}}</td>
							<td data-uid="{{item.userId}}">{{item.adminRating | rating:false}}</td>
							<td>{{item.registerStatus.description}}</td>
							<td><span class="user-profile-score">{{item.profileScore}}%</span></td>
							<td>{{item.howDidYouHearAboutUs}}</td>
							<td><span class="user-message none">0</span></td>
							<td><a href="javascript:void(0);"><img ng-if="item.portfolio[0].boards[0].boardImages[0].thumbnailUrl != null" ng-src="/100x100/{{item.portfolio[0].boards[0].boardImages[0].thumbnailUrl}}" style="width:75px; height:auto;"/></a></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="pagin-holder">
				<div class="pagin">
					<div class="col-md-4">
						<div class="input-group">
						  	<span class="input-group-addon">Show rows</span>
						  	<select class="form-control" ng-model="rowsPerPage" ng-change="updateRows()">
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
						<span class="form-control fh" data-total-pages="{{totalPages}}">{{lowerBound+1}} - {{upperBound}} of {{data.usersCount}} ({{data.users.length}})</span>
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
	</div>
	<!-- Modal -->
	<modal-dialog show='dialogShown' width="{{modalWidth}}" height="{{modalHeight}}" on-close="onDialogClose()">
		<div class="modal-wrapper">
			<div class="float-notif" ng-if="isDialogLoading"><i class="glyphicon glyphicon-cog"></i>Loading...</div>
			<div class="user-detail" ng-bind-html="dialogContent"></div>
		</div>
	</modal-dialog>
</div>