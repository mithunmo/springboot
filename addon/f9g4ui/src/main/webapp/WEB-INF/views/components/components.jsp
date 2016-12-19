<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertAttribute name="upper_sub_comp"></tiles:insertAttribute>
<tiles:insertAttribute name="main_comp"></tiles:insertAttribute>
<tiles:insertAttribute name="lower_sub_comp"></tiles:insertAttribute>
<!-- Modal -->
<modal-dialog show='dialogShown' width="{{modalWidth}}" height="{{modalHeight}}" on-close="onDialogClose()">
	<div class="modal-wrapper">
		<div class="float-notif" ng-if="isDialogLoading"><i class="glyphicon glyphicon-cog"></i>Loading...</div>
		<div class="user-detail" ng-bind-html="dialogContent"></div>
	</div>
</modal-dialog>