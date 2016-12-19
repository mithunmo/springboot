//route table for buyer
app.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
	var contextPath='/f4g';
	$routeProvider
		.when(ajaxPaths['viewProjectsPath'], {
			templateUrl: ajaxPaths['viewProjectsContentPath'],
			controller: 'viewBuyerProjectsController',
			resolve: {
				//determine to focus which tab header
				focusTabHeader: function() {
					return 'viewProjectsSubmissions';
				}
			}
		})
		.when(ajaxPaths['manageBuyerProjectsPath'], {
			templateUrl: ajaxPaths['manageBuyerProjectsContentPath'],
			controller: 'manageBuyerProjectsController'
		})
		.when(ajaxPaths['createBuyerProjectPath'], {
		    templateUrl: ajaxPaths['createBuyerProjectContentPath'],
		    controller: 'createBuyerProjectController',
		    resolve: {
		    	// I will cause a 1 second delay
		    	/*delay: function($q, $timeout) {
		    		var delay = $q.defer();
		    		$timeout(delay.resolve, 300);
		    		return delay.promise;
		    	}*/
		    }
		})
		.when(ajaxPaths['viewProjectsPortfolioPath']+"/:portfolioId/:conetstId", {
			templateUrl: function(urlAttr) {
				return ajaxPaths['viewProjectBoardsContentPath']+'?portfolioId='+urlAttr.portfolioId+'&contestId='+urlAttr.conetstId;
			},
			controller: 'viewProjectsBoardsController',
			resolve: {
				//determine to focus which tab header
				focusTabHeader: function() {
					return 'viewProjectsSubmissions'; 
				}
			}
		});
}]);