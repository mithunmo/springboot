<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Notification bar -->
<div class="sync gap" ng-show="isLoading"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Loading. Please wait...</div>
<div class="sync gap" ng-show="isBoardSyncing"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Retrieving board data. Please wait...</div>

<!-- Board Editor -->
<div class="cbuttons lt">
	<a class="cbutton r rt" href="${pageContext.request.contextPath}<%=ViewPaths.USER_PROJECTS_PORTFOLIO%>/{{portfolioId}}">CANCEL</a>
	<a class="cbutton r rt" href="javascript:void(0);" ng-click="clear(true)">CLEAR ALL</a>
	<a class="cbutton rt" href="javascript:void(0);" ng-click="publishBoard()">SAVE&nbsp;&amp;&nbsp;PUBLISH</a>
	<a class="cbutton rt" href="javascript:void(0);" ng-click="saveBoard()">SAVE</a>
</div>
<div class="cp">
	<div class="cp-label"><span class="glyphicon glyphicon-circle-arrow-down"></span>SUBMISSION INFO</div>
	<div class="cp-panel full">
		<div class="cpanel-holder">
			<div class="cpanel w5">
				<div class="cpanel-title">BOARD IMAGES</div>
				<div class="cpanel-content">
					<div class="preview-img" ng-show="!hasRemoved">
						<div class="cancel glyphicon glyphicon-remove" ng-click="removeImg()"></div>
						<img style="width:200px;" ng-src="/400x400/{{previewImg}}" />
					</div>
					<div id="boardUploader" class="btn" ng-model="uploaderResult" snail-uploadify="{auto:true,buttonText:'',mode:'BOARDS',filetype:'ai'}"></div>
				</div>
			</div>
			<div class="cpanel w5">
		 		<div class="cpanel full">
					<div class="cpanel-title">BOARD NAME</div>
					<div class="cpanel-content">
						<input type="text" class="form-control" type="text" ng-model="form.boardName"/>
					</div>
				</div>
				<div class="cpanel full">
					<div class="cpanel-title">DESCRIPTION</div>
					<div class="cpanel-content">
						<input type="text" class="form-control" type="text" ng-model="form.boardDescription"/>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="cp-label"><span class="glyphicon glyphicon-circle-arrow-down"></span>SUBMISSION ATTRIBUTES</div>
	<div class="cp-panel-group-holder">
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
		</div>
		<div class="cp-panel-group pad w3">
			<div class="cp-panel pad">
	 			<div class="cpanel">
					<div class="cpanel-title">KEYWORDS&nbsp;-&nbsp;INSPIRATION/TRENDS</div>
					<div class="cpanel-content">
						<input class="form-control" type="text" ng-model="form.subKeywords_1" />
					</div>
				</div>
				<div class="cpanel">
					<div class="cpanel-title">KEYWORDS&nbsp;-&nbsp;DESIGN DETAILS</div>
					<div class="cpanel-content">
						<input class="form-control" type="text" ng-model="form.subKeywords_2" />
					</div>
				</div>
				<div class="cpanel">
					<div class="cpanel-title">KEYWORDS&nbsp;-&nbsp;FABRIC</div>
					<div class="cpanel-content">
						<input class="form-control" type="text" ng-model="form.subKeywords_3" />
					</div>
				</div>
				<div class="cpanel">
					<div class="cpanel-title">KEYWORDS&nbsp;-&nbsp;OTHER</div>
					<div class="cpanel-content">
						<input class="form-control" type="text" ng-model="form.subKeywords_4" />
					</div>
				</div>
	 		</div>
		</div>
		<div class="cp-panel-group pad w4">
			<div class="cp-panel">
	 			<div class="cpanel">
					<div class="cpanel-title">SEASON&nbsp;&amp;&nbsp;YEAR</div>
					<div class="cpanel-content">
						<%-- <select name="season" class="form-control" ng-model="form.season">
							<option value="">- Please select one option -</option>
							<c:forEach var="item" items="${seasonYear}">
								<option value="${item.seasonYearId}">${item.season}</option>
							</c:forEach>	
						</select> --%>
						<!-- Show pre-defined data -->
					</div>
				</div>
	 		</div>
	 		<!-- <div class="cp-panel">
	 			<div class="cpanel">
					<div class="cpanel-title">BOARD PRICE</div>
					<div class="cpanel-title">(1) Single Looks</div>
					<div class="cpanel-content">
						<input class="form-control" type="text" ng-model="form.price" />
					</div>
				</div>
				<div class="cpanel">
					<div class="cpanel-title">(2+) Multiple Looks</div>
					<div class="cpanel-content">
						<input class="form-control" type="text" ng-model="form.price" />
					</div>
				</div>
				
	 		</div> -->
		</div>
	</div>
	
	<div class="cp-label"><span class="glyphicon glyphicon-circle-arrow-down"></span>TERMS &amp; CONDITIONS</div>
	<div class="cp-panel full">
		<label><input type="checkbox" ng-model="form.hasAgreedTerms">&nbsp;I agree that I have the legal rights to distribute and sell this work, that it is not displayed on any other websites and that it is my original work.</label>
	</div>
	
	<div class="cbuttons">
		<a class="cbutton r rt" href="${pageContext.request.contextPath}<%=ViewPaths.USER_PROJECTS_PORTFOLIO%>/{{form.portfolioId}}/{{form.contestId}}">CANCEL</a>
		<a class="cbutton r rt" href="javascript:void(0);" ng-click="clear(true)">CLEAR ALL</a>
		<a class="cbutton rt" href="javascript:void(0);" ng-click="publishBoard()">SAVE&nbsp;&amp;&nbsp;PUBLISH</a>
		<a class="cbutton rt" href="javascript:void(0);" ng-click="saveBoard()">SAVE</a>
	</div>
</div>