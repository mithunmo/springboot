//route table for designer
app.config(['$routeProvider', function($routeProvider) {
	//route table place here
	var contextPath='/f4g';
	$routeProvider
		.when(ajaxPaths['viewProjectsPath'], {
			templateUrl: ajaxPaths['viewProjectsContentPath'],
			controller: 'viewDesignerProjectsController'
		})
		//view portfolio
		.when(ajaxPaths['viewProjectsPortfolioPath'], {
			templateUrl: ajaxPaths['viewProjectsPortfolioContentPath'],
			controller: 'viewProjectsPortfolioController'
		})
		//view boards
		.when(ajaxPaths['viewProjectsPortfolioPath']+"/:portfolioId/:contestId", {
			templateUrl: function(urlAttr) {
				return ajaxPaths['viewProjectBoardsContentPath']+'?portfolioId='+urlAttr.portfolioId+'&contestId='+urlAttr.contestId;
			},
			controller: 'viewProjectsBoardsController',
			resolve: {
				//determine to focus which tab header
				focusTabHeader: function() {
					return undefined;
				}
			}
		})		
		.when(ajaxPaths['viewProjectsCreativeViewPath']+"/:portfolioId/:contestId", {
			templateUrl: function(urlAttr) {
				return ajaxPaths['viewProjectsCreativeViewContentPath']+'?portfolioId='+urlAttr.portfolioId+'&contestId='+urlAttr.contestId;
			},
			controller: 'viewProjectsBriefController',
			resolve: {
				//determine to focus which tab header
				focusTabHeader: function() {
					return undefined;
				}
			}
		})				
		.when(ajaxPaths['createProjectBoardPath'], {
			templateUrl: function(urlAttr) {
				return ajaxPaths['createProjectBoardContentPath'];
			},
			controller: 'createProjectBoardController'
		})
		.when(ajaxPaths['createProjectBoardPath']+"/:portfolioId/:contestId", {
			templateUrl: function(urlAttr) {
				return ajaxPaths['createProjectBoardContentPath']+'/'+urlAttr.portfolioId+'/'+urlAttr.contestId;
			},
			controller: 'editProjectBoardController',
			resolve: {
				mode: function() {
					return 'create';
				}
			}
		})
		.when(ajaxPaths['editProjectBoardPath']+"/:boardId", {
			templateUrl: function(urlAttr) {
				return ajaxPaths['editProjectBoardContentPath']+'/'+urlAttr.boardId;
			},
			controller: 'editProjectBoardController',
			resolve: {
				mode: function() {
					return 'edit';
				}
			}
		});
}]);