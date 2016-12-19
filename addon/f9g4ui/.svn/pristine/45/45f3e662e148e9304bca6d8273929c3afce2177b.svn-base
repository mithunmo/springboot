<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Content -->
<div class="content content-wrapper" ng-controller="buyerSearch">
	<%-- <div class="content-holder expand imgs-container smaller cart" ng-show="showCart">
		<a ng-show ="shoppingCart.cartItems.length > 0" class="cart-function" href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_CHECKOUT_TAB%>" target="_self">Checkout</a>
		<div class="cart-empty" ng-if="shoppingCart.cartItems.length <= 0">Empty Cart</div>
		<div class="img-holder" data-seq="{{$index}}" ng-repeat="item in shoppingCart.cartItems">
			<img class="img-nail" src="/400x400/{{item.tileImageUrl}}" data-seq="{{$index}}" data-bid="{{item.boardId}}" />
			<div class="cart-item-info"><span class="glyphicon glyphicon-usd"></span>&nbsp;{{item.boardprice}}</div>
			<a href="javascript:void(0);" class="img-cart-function smaller" ng-click="removeFromCart(item.boardId)"><span class="glyphicon glyphicon-minus"></span><span class="glyphicon glyphicon-shopping-cart"></span><span ng-show="isRemoving[item.boardId]" class="glyphicon glyphicon-refresh"></span></a>
			<div class="img-info-loading"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Loading...</div>
		</div>
		<div class="cart-title sub" ng-show ="shoppingCart.cartItems.length > 0">Total: $&nbsp;{{shoppingCart.total}}</div>
		<div class="cart-title" ng-click="hideCart()"><span class="glyphicon glyphicon-chevron-up"></span>&nbsp;&nbsp;Shopping Cart</div>
	</div> --%>
	<div class="content-holder">
		<div class="title" ng-class="{ng: showCart}">Search Criteria</div>
		<div class="date-range rt">
			<%-- <a href="javascript:void(0);"><img ng-click="getCartItems(true);" popover="{{cartItemsCount}} items ($ {{shoppingCart.total}}) in the cart." popover-trigger="mouseenter" popover-placement="left" popover-title="Shopping Cart" class="cart-icon" src="/images/shoppingcart.png" /></a> --%>
			<%-- <div class="col-md-6">
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
            </div> --%>
		</div>
		<div class="tabs">
			<div class="header">
				<a class="item selected" href="${pageContext.request.contextPath}<%= ViewPaths.SEARCH_CRITERIA%>" target="_self" ng-click="show()" data-target="1">Refine Search</a>
				<%-- <a class="item" href="${pageContext.request.contextPath}<%= ViewPaths.SEARCH_VIEWER%>#portfolioPages" ng-click="show()" data-target="2">Portfolio Pages</a> --%>
				<a class="item" href="${pageContext.request.contextPath}<%= ViewPaths.SEARCH_VIEWER%>#marketplaceSubmissions" ng-click="show()" data-target="3">Marketplace</a>
				<%-- <a class="item" href="${pageContext.request.contextPath}<%= ViewPaths.SEARCH_VIEWER%>#examples" ng-click="show()" data-target="3">Examples</a> --%>
			</div>
			<div class="function">
			</div>
		</div>
	</div>
	<div class="content-holder">
		<div class="sync" ng-show="syncIncompleted"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Synchronizing Search Criteria. Please wait...</div>
		<div class="sync" ng-show="isSearching"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Searching. Please wait...</div>
		<div class="sync" ng-show="isCartSyncing"><i class="glyphicon glyphicon-warning-sign"></i>&nbsp;&nbsp;Update Shopping Cart Information.</div>
		<div class="groups-holder show-all">
			<div class="groups">
				<div class="group-holder">
					<div class="group-content">
						<div class="cpanel">
							<div class="cpanel-title">BUYER RATING:&nbsp;{{buyerRatingSlider.min}} - {{buyerRatingSlider.max}}</div>
							<div class="cpanel-content">
								<rzslider
								    rz-slider-floor="buyerRatingSlider.floor"
								    rz-slider-ceil="buyerRatingSlider.ceil"
								    rz-slider-model="buyerRatingSlider.min"
								    rz-slider-high="buyerRatingSlider.max" rz-slider-step="{{buyerRatingSlider.step}}"></rzslider>
							</div>
						</div>
					</div>
				</div>
				<div class="group-holder">
					<div class="group-content">
						<div class="cpanel">
							<div class="cpanel-title">PRICE RANGE:&nbsp;$&nbsp;{{priceSlider.min}} - $&nbsp;{{priceSlider.max}}</div>
							<div class="cpanel-content">
								<rzslider
								    rz-slider-floor="priceSlider.floor"
								    rz-slider-ceil="priceSlider.ceil"
								    rz-slider-model="priceSlider.min"
								    rz-slider-high="priceSlider.max" rz-slider-step="{{priceSlider.step}}" rz-slider-translate="translate"></rzslider>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="groups">
				<div class="group-holder">
					<div class="group-content">
						<div class="cpanel">
							<div class="cpanel-title">KEYWORD SEARCH</div>
							<div class="cpanel-content">
								<input type="text" name="keywords" class="form-control" ng-model="criteria.keywords" />
							</div>
						</div>
					</div>
				</div>
				<div class="group-holder">
					<div class="group-content">
						<div class="cpanel">
							<div class="cpanel-title" ng-click="test()">DIVISION</div>
							<div class="cpanel-content">
								<select name="division" class="form-control" ng-change="updateList(1)" ng-model="criteria.division">
									<option value="">- Please select one option -</option>
									<c:forEach var="item" items="${divisionList}">
										<option value="${item.categoryId}">${item.name}</option>
									</c:forEach>
								</select>
								<!-- <select ng-model="correctlySelected"
					                ng-options="opt as opt.label for opt in options">
					            </select> -->
							</div>
						</div>
						<div class="cpanel">
							<div class="cpanel-title">CATEGORY</div>
							<div class="cpanel-content">
								<!-- <select name="category" class="form-control" ng-change="updateList(2)" ng-model="criteria.category">
									<option value="">- Please select one option -</option>
									<option ng-repeat="item in boardLevelList[2]" ng-attr-value="{{item.categoryId}}">{{item.name}}</option>
								</select> -->
								<select class="form-control" ng-model="criteria.category"
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
					            <select class="form-control" ng-model="criteria.product"
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
						<div class="cpanel">
							<div class="cpanel-title">SEASON</div>
							<div class="cpanel-content">
								<select name="season" class="form-control" ng-model="criteria.season">
									<option value="">- Please select one option -</option>
									<c:forEach var="item" items="${seasonYear}">
										<option value="${item.seasonYearId}">${item.season}</option>
									</c:forEach>	
								</select>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="groups">
				<div class="group-holder">
					<div class="group-content">
						<div class="cpanel">
							<div class="cpanel-title">DESIGNER NAME</div>
							<div class="cpanel-content">
								<input type="text" name="designer_name" class="form-control" ng-model="criteria.designerName" />
							</div>
						</div>
					</div>
				</div>
				<div class="group-holder">
					<div class="group-content">
						<div class="cpanel">
							<div class="cpanel-title">DESIGNER'S COUNTRY</div>
							<div class="cpanel-content">
								<select name="country" class="form-control" ng-model="criteria.country">
									<option value="">- Please select one option -</option>
									<c:forEach var="item" items="${countryList}">
										<option value="${item.lookupValueId}">${item.description}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="cpanel">
							<div class="cpanel-title">LANGUAGES</div>
							<div class="cpanel-content">
								<div     
								    multi-select
								    input-model="langList"
								    output-model="selectedLangList"
								    button-label="description"
								    item-label="description"
								    tick-property="ticked"
								    max-labels="3"
								    max-height="250px"
								>
								</div>
								<%-- <select name="langs" ng-model="criteria.languages">
									<option value="">- Please select one option -</option>
									<c:forEach var="item" items="${languagesList}">
										<option value="${item.lookupValueId}">${item.description}</option>
									</c:forEach>
								</select> --%>
							</div>
						</div>
						<div class="cpanel">
							<div class="cpanel-title">SKILLS</div>
							<div class="cpanel-content">
								<div     
								    multi-select
								    input-model="skillList"
								    output-model="selectedSkillList"
								    button-label="description"
								    item-label="description"
								    tick-property="ticked"
								    max-labels="1"
								    max-height="250px"
								>
								</div>
								<%-- <select name="skills" ng-model="criteria.skills">
									<option value="">- Please select one option -</option>
									<c:forEach var="item" items="${skillsList}">
										<option value="${item.lookupValueId}">${item.description}</option>
									</c:forEach>
								</select> --%>
							</div>
						</div>
						<div class="cpanel">
							<div class="cpanel-title">SPECIALTIES</div>
							<div class="cpanel-content">
								<div     
								    multi-select
								    input-model="specialtyList"
								    output-model="selectedSpecialtyList"
								    button-label="description"
								    item-label="description"
								    tick-property="ticked"
								    max-labels="3"
								    max-height="250px"
								>
								</div>
							</div>
						</div>
						<div class="cpanel">
							<div class="cpanel-title">EXPERTISE</div>
							<div class="cpanel-content">
								<div     
								    multi-select
								    input-model="expertiseList"
								    output-model="selectedExpertiseList"
								    button-label="description"
								    item-label="description"
								    tick-property="ticked"
								    max-labels="3"
								    max-height="250px"
								>
								</div>
							</div>
						</div>
						<div class="cpanel">
							<div class="cpanel-title">EDUCATION</div>
							<div class="cpanel-content">
								<div     
								    multi-select
								    input-model="educationList"
								    output-model="selectedEducationList"
								    button-label="description"
								    item-label="description"
								    tick-property="ticked"
								    max-labels="3"
								    max-height="250px"
								>
								</div>
							</div>
						</div>
						<div class="cpanel">
							<div class="cpanel-title">SCHOOLS, AWARD, EVENTS</div>
							<div class="cpanel-content"><input type="text" name="schools" class="form-control" ng-model="criteria.misc" /></div>
						</div>
					</div>
				</div>
			</div>
			<div class="groups">
				<%-- <div class="tile">
					<div class="upper">{{portfolioPagesCount}}</div>
					<div class="lower bb">Portfolio Pages</div>
				</div> --%>
				<div class="tile">
					<div class="upper">{{marketplaceSubmissionCount}}</div>
					<div class="lower bb">Marketplace</div>
				</div>
				<%-- <div class="tile">
					<div class="upper">0</div>
					<div class="lower bb">Project Submission</div>
				</div> --%>
				<%-- <div class="tile">
					<div class="upper">{{examplesCount}}</div>
					<div class="lower bb">Examples</div>
				</div> --%>
				<%-- <div class="tile">
					<div class="upper">{{profilesCount}}</div>
					<div class="lower bb">Profiles</div>
				</div> --%>
			</div>
		</div>
		<div class="groups-holder">
			<div class="cbuttons rt">
				<a class="cbutton pad" href="javascript:void(0);" ng-click="search()">Search</a>
				<a class="cbutton pad r" href="javascript:void(0);" ng-click="clear()">Clear</a>
			</div>
		</div>
	</div>
</div>