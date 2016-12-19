<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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