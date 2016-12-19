<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Notification bar -->
<div class="sync gap" ng-show="isLoading"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Loading. Please wait...</div>
<div class="sync gap" ng-show="isStarting"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Starting Project. Please wait...</div>

<!-- Create UI -->
<a class="cbutton large" style="margin-top:10px;" href="javascript:void(0);" ng-click="startProject()" ng-show="!isStarted">START NEW PROJECT</a>
<div class="cp" ng-class="{disabled: syncIncompleted}" ng-show="isStarted">
	<div class="mask"></div>
	<div class="cbuttons pad-bottom">
		<a class="cbutton large lt" href="javascript:void(0);" ng-click="saveProject()">SAVE PROJECT</a>
		<a class="cbutton blk large rt" href="javascript:void(0);" ng-click="cancelProject()">DELETE PROJECT</a>
	</div>
 	<div class="cp-label"><span class="glyphicon glyphicon-play"></span>PROJECT ID &num;<span class="highlight"><span ng-if="form.contestType!=undefined && form.contestType!=''">0{{form.contestType}}-</span>{{data.contestPortfolioDomain.portfolioId}}@{{data.contestId}}</span></div>
 	<div class="cp-panel full">
		<table class="cp-contest">
	 		<tr>
	 			<td class="w5">
	 				<span class="cp-form-label">TITLE</span>
	 				<input type="text" class="form-control" ng-model="form.title" />
	 			</td>
	 			<td class="w5">
	 				<span class="cp-form-label">TYPE OF PROJECT</span>
	 				<select class="form-control" ng-model="form.contestType">
	 					<option value="">- Please select one option -</option>
	 					<c:forEach var="item" items="${projectTypeList}">
	 						<option value="${item.id}">${item.code}</option>
	 					</c:forEach>
	 				</select>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td>
	 				<span class="cp-form-label pad">DUE DATE</span>
	 				<div class="input-group" ng-controller="datePickerController">
		            	<input type="text" class="form-control" datepicker-popup="{{format}}" ng-model="$parent.form.dueDate" is-open="opened" min-date="$parent.minDueDate" datepicker-options="dateOptions" date-disabled="disabled(date, mode)" ng-required="false" close-text="Close" placeholder="Due Date"/>
		             	<span class="input-group-btn">
		                	<button type="button" class="btn btn-default" ng-click="open($event)"><i class="glyphicon glyphicon-calendar"></i></button>
		              	</span>
		            </div>
	 			</td>
	 			<td>
	 				<span class="cp-form-label pad"># OF WINNERS</span>
	 				<select class="form-control" ng-model="form.winners">
	 					<option value="">- Please select one option -</option>
	 					<option value="{{i}}" ng-repeat="i in [1,2,3,4,5,6,7,8,9,10]">{{i}}</option>
	 				</select>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td>
	 				<span class="cp-form-label pad">CLIENT</span>
	 				<div
	 					style="max-width:450px;"     
					    multi-select
					    input-model="buyerList"
					    output-model="selectedBuyerList"
					    button-label="firstname lastname"
					    item-label="firstname lastname companyname userName"
					    tick-property="ticked"
					    max-labels="3"
					    max-height="250px"
					    selection-mode="single"
					    helper-elements="reset filter">
					</div>
	 			</td>
	 			<td>
	 				<!-- <table class="cp-contest-awards pad">
	 					<tr>
	 						<td><span class="cp-form-label">Rewards&num;1</span></td>
	 						<td><span class="cp-form-label">Rewards&num;2</span></td>
	 						<td><span class="cp-form-label">Rewards&num;3</span></td>
	 					</tr>
	 					<tr>
	 						<td class="w3 pad">
	 							<select class="form-control" ng-model="form.awards[0]">
	 								<option value="24">24 Credits</option>
	 								<option value="12">12 Credits</option>
	 								<option value="6">6 Credits</option>
	 							</select>
	 						</td>
	 						<td class="w3 pad">
	 							<select class="form-control" ng-model="form.awards[1]">
	 								<option value="24">24 Credits</option>
	 								<option value="12">12 Credits</option>
	 								<option value="6">6 Credits</option>
	 							</select>
	 						</td>
	 						<td class="w3 pad">
	 							<select class="form-control" ng-model="form.awards[2]">
	 								<option value="24" selected="selected">24 Credits</option>
	 								<option value="12">12 Credits</option>
	 								<option value="6">6 Credits</option>
	 							</select>
	 						</td>
	 					</tr>
	 				</table> -->
	 			</td>
	 		</tr>
	 	</table>
 	</div>
 	<!-- Project Attributes -->
 	<div class="cp-label"><span class="glyphicon glyphicon-play"></span>PROJECT ATTRIBUTES</div>
 	<div class="cp-panel-group-holder-inline">
 	<div class="cp-panel-group pad w3">
 		<div class="cp-panel pad">
 			<div class="cpanel">
				<div class="cpanel-title">DIVISION</div>
				<div class="cpanel-content">
					<select name="division" class="form-control" ng-change="updateList(1)" ng-model="form.division">
						<option value="">- Please select one option -</option>
						<c:forEach var="item" items="${divisionList}">
							<option value="${item.categoryId}">${item.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="cpanel">
				<div class="cpanel-title">CATEGORY</div>
				<div class="cpanel-content">
					<!-- <select name="category" class="form-control" ng-change="updateList(2)" ng-model="criteria.category">
						<option value="">- Please select one option -</option>
						<option ng-repeat="item in boardLevelList[2]" ng-attr-value="{{item.categoryId}}">{{item.name}}</option>
					</select> -->
					<select class="form-control" ng-model="form.category"
		                ng-options="opt.categoryId as opt.name for opt in boardLevelList[2]" ng-change="updateList(2)">
		                <option value="">- Please select one option -</option>
		            </select>
				</div>
			</div>
			<div class="cpanel">
				<div class="cpanel-title">PRODUCT</div>
				<div class="cpanel-content">
					<!-- <select name="product" class="form-control" ng-change="updateList(3)" ng-model="criteria.product">
						<option value="">- Please select one option -</option>
						<option ng-repeat="item in boardLevelList[3]" ng-attr-value="{{item.categoryId}}">{{item.name}}</option>
					</select> -->
		            <select class="form-control" ng-model="form.product"
		                ng-options="opt.name as opt.name for opt in boardLevelList[3]" ng-change="updateList(3)">
		                <option value="">- Please select one option -</option>
		            </select>
				</div>
			</div>
			<div class="cpanel">
				<div class="cpanel-title">PRODUCT TYPE</div>
				<div class="cpanel-content">
					<div     
					    multi-select
					    input-model="boardLevelList[4]"
					    output-model="selectedBoardLevelList[4]"
					    button-label="name"
					    item-label="name"
					    tick-property="ticked"
					    max-labels="3"
					    max-height="250px"
					>
					</div>
					<!-- <select name="product_type" ng-change="updateList(4)" ng-model="criteria.producttype">
						<option value="">- Please select one option -</option>
						<option ng-repeat="item in boardLevelList[4]" ng-attr-value="{{item.categoryId}}">{{item.name}}</option>
					</select> -->
				</div>
			</div>
 		</div>
 	</div><!-- 
 	 --><div class="cp-panel-group pad w3">
 		<div class="cp-panel pad">
 			<div class="cpanel">
				<div class="cpanel-title">KEYWORDS&nbsp;-&nbsp;INSPIRATION/TRENDS</div>
				<div class="cpanel-content">
					<input class="form-control" type="text" ng-model="form.subKeywords1" />
				</div>
			</div>
			<div class="cpanel">
				<div class="cpanel-title">KEYWORDS&nbsp;-&nbsp;DESIGN DETAILS</div>
				<div class="cpanel-content">
					<input class="form-control" type="text" ng-model="form.subKeywords2" />
				</div>
			</div>
			<div class="cpanel">
				<div class="cpanel-title">KEYWORDS&nbsp;-&nbsp;FABRIC</div>
				<div class="cpanel-content">
					<input class="form-control" type="text" ng-model="form.subKeywords3" />
				</div>
			</div>
			<div class="cpanel">
				<div class="cpanel-title">KEYWORDS&nbsp;-&nbsp;OTHER</div>
				<div class="cpanel-content">
					<input class="form-control" type="text" ng-model="form.subKeywords4" />
				</div>
			</div>
 		</div>
 	</div><!-- 
 	--><div class="cp-panel-group pad w4">
 		<div class="cp-panel">
 			<div class="cpanel">
				<div class="cpanel-title">SEASON&nbsp;&amp;&nbsp;YEAR</div>
				<div class="cpanel-content">
					<select name="season" class="form-control" ng-model="form.season">
						<option value="">- Please select one option -</option>
						<c:forEach var="item" items="${seasonYear}">
							<option value="${item.seasonYearId}">${item.season}</option>
						</c:forEach>	
					</select>
				</div>
			</div>
 		</div>
 		<div class="cp-panel">
 			<div class="cpanel">
				<div class="cpanel-title">ASSOCIATED BRANDS&nbsp;-&nbsp;INFLUENCE</div>
				<div class="cpanel-content">
					<input class="form-control" type="text" ng-model="form.associatedBrandsInfluence" />
				</div>
			</div>
			<div class="cpanel">
				<div class="cpanel-title">ASSOCIATED BRANDS&nbsp;-&nbsp;HANG WITH</div>
				<div class="cpanel-content">
					<input class="form-control" type="text" ng-model="form.associatedBrandsHangWith" />
				</div>
			</div>
			
 		</div>
 	</div>
 	</div>
 	<!--  -->
 	<div class="cp-label"><span class="glyphicon glyphicon-play"></span>PROJECT REQUIREMENTS</div>
 	<div class="cp-panel full">
 		<div class="cpanel pad-bottom">
			<div class="cpanel-title">INTRODUCTION</div>
			<div class="cpanel-content">
				<textarea class="form-control" type="text" ng-model="form.introduction"></textarea>
			</div>
		</div>
		<div class="cpanel pad-bottom">
			<div class="cpanel-title">DESCRIPTION</div>
			<div class="cpanel-content">
				<textarea class="form-control" type="text" ng-model="form.description"></textarea>
			</div>
		</div>
		<div class="cpanel-holder pad-bottom">
			<div class="cpanel w5">
				<div class="cpanel-title">DELIVERABLES</div>
				<div class="cpanel-content">
					<textarea class="form-control" type="text" ng-model="form.deliverables"></textarea>
				</div>
			</div>
			<div class="cpanel w5">
				<div class="cpanel-title">OTHER INFORMATION</div>
				<div class="cpanel-content">
					<textarea class="form-control" type="text" ng-model="form.otherInformation"></textarea>
				</div>
			</div>
		</div>
		<div class="cpanel-holder">
			<div class="cpanel w5">
				<div class="cpanel-title">SUPPORTING DOCUMENTS</div>
				<div class="cpanel-content">
					<div class="upload-buttons">
						<div class="upload-button" ng-controller="uploadController1">
							<div class="preview-img" ng-show="!hasRemoved">
								<div class="cancel glyphicon glyphicon-remove" ng-click="removeImg()"></div>
								<img style="width:150px;" ng-src="/400x400/{{previewImg}}" />
							</div>
							<a href="javascript:void(0);" id="fileUploader1" class="upload-file-icon btn" ng-model="fileUploadResult" snail-uploadify="{auto:true,buttonText:'',mode:'BOARDS',filetype:'ai',width:150,height:150}"><span class="glyphicon glyphicon-paperclip"></span></a>
						</div>
						
						<div class="upload-button" ng-controller="uploadController2">
							<div class="preview-img" ng-show="!hasRemoved">
								<div class="cancel glyphicon glyphicon-remove" ng-click="removeImg()"></div>
								<img style="width:150px;" ng-src="/400x400/{{previewImg}}" />
							</div>
							<a href="javascript:void(0);" id="fileUploader2" class="upload-file-icon btn" ng-model="fileUploadResult" snail-uploadify="{auto:true,buttonText:'',mode:'BOARDS',filetype:'ai',width:150,height:150}"><span class="glyphicon glyphicon-paperclip"></span></a>
						</div>
					</div>
				</div>
			</div>
			<div class="cpanel w5">
				<div class="cpanel-holder">
					<div class="cpanel w5">
						<div class="cpanel-title">BOARD DIMENSIONS</div>
						<div class="cpanel-content">
							<select class="form-control" ng-model="form.dimensions">
				                <option value="">- Please select one option -</option>
				                <c:forEach var="item" items="${boardDimension}">
				                	<option value="${item.lookupValueId}">${item.description}</option>
				                </c:forEach>
				            </select>
						</div>
					</div>
					<div class="cpanel w5">
						<div class="cpanel-title">FORMAT</div>
						<div class="cpanel-content">
							<select class="form-control" ng-model="form.format">
				                <option value="">- Please select one option -</option>
				                <c:forEach var="item" items="${boardFormat}">
				                	<option value="${item.lookupValueId}">${item.description}</option>
				                </c:forEach>
				            </select>
						</div>
					</div>
				</div>
			</div>
		</div>
 	</div>
 	<div class="cbuttons">
		<a class="cbutton blk rt" href="javascript:void(0);" ng-click="publishProject()">SAVE&nbsp;&amp;&nbsp;PUBLISH</a>
		<a class="cbutton rt" href="javascript:void(0);" ng-click="saveProject()">SAVE PROJECT</a>
	</div>
</div>