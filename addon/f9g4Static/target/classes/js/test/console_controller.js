app.controller('buyerSearch', ['$scope', '$http', '$filter', function($scope,$http,$filter) {
	$scope.asyncCompCount=0;
	$scope.syncIncompleted=true;
	//shopping cart
	$scope.showCart=false;
	$scope.isAdding={};
	$scope.isRemoving={};
	$scope.addedItems={};
	$scope.isCartSyncing=false;
	//
	$scope.clear = function(isInit) {
		//Initialization
		$scope.boardLevelList={};
		$scope.boardLevelList[4]={};
		$scope.selectedBoardLevelList={};
		$scope.portfolioCount=0;
		$scope.criteria={};
		if(isInit) {
			$scope.langList={};
			$scope.skillList={};
			$scope.specialtyList={};
			$scope.expertiseList={};
			$scope.educationList={};
		}
		$scope.criteria.designerName='';
		$scope.criteria.ratings=0;
		$scope.criteria.country='';
		$scope.criteria.priceRange=0;
		$scope.criteria.langs=null;
		$scope.criteria.selectItemlangs=null;
		$scope.criteria.misc='';
		$scope.criteria.keywords='';
		//slider initialization
		/*$scope.adminRatingSlider = {
		   	min: 0,
		   	max: 5,
		   	ceil: 5,
		   	floor: 0,
		   	step: 1	
		};*/
		$scope.buyerRatingSlider = {
		   	min: 0,
		   	max: 5,
		   	ceil: 5,
		   	floor: 0,
		   	step: 1	
		};
		$scope.priceSlider = {
		   	min: 0,
		   	max: 20000,
		   	ceil: 20000,
		   	floor: 0,
		   	step: 25	
		};
		//date picker initialization
		$scope.dt_start=null;
		$scope.dt_end=new Date();
		//
		$scope.clearMultiSelect($scope.langList);
		$scope.clearMultiSelect($scope.skillList);
		$scope.clearMultiSelect($scope.specialtyList);
		$scope.clearMultiSelect($scope.expertiseList);
		$scope.clearMultiSelect($scope.educationList);
	},
	$scope.updateList = function(level,callback) {
		var path;
		if(level<4) {   			
    		if(level==1) {
    			path=ajaxPaths['categoryListPath']+'/'+$scope.criteria.division;
    			$scope.boardLevelList[2]={};
    			$scope.boardLevelList[3]={};
    			$scope.boardLevelList[4]={};
    			$scope.criteria.category=null; //reset to default
    			$scope.criteria.product=null; //reset to default
    			$scope.criteria.productType=null; //reset to default
    		}
    		else if(level==2) {
    			path=ajaxPaths['productListPath']+'/'+$scope.criteria.category;
    			$scope.boardLevelList[3]={};
    			$scope.boardLevelList[4]={};
    			$scope.criteria.product=null; //reset to default
    			$scope.criteria.productType=null; //reset to default
    		}
    		else {
    			path=ajaxPaths['productTypeListPath']+'?level1='+$scope.criteria.division+'&level2='+$scope.criteria.category+'&productTags='+encodeURIComponent($scope.criteria.product);
    			$scope.boardLevelList[4]="";
    			$scope.criteria.productType=null; //reset to default
    		}
    		$http({method: 'GET', url: path})
			.success(function(data, status, headers, config) {
				// this callback will be called asynchronously when the response is available
				$scope.boardLevelList[level+1]=data.list; //assign the list to the next level container
				if(typeof(callback)=='function')
					callback();
		    })
		    .error(function(data, status, headers, config) {
		    	// called asynchronously if an error occurs or server returns response with an error status.
		    });
		}
	},
	$scope.syncMultiSelect = function(source, selected, mode) {
		for(var id in source) {
			for(var sid in selected) {
				if(mode==1) {
					if(source[id].name == selected[sid])
						source[id].ticked=true;
				}
				if(mode==2) {
					if(source[id].lookupValueId == selected[sid])
						source[id].ticked=true;
				}
			}
		}
		if(selected !=null && selected.length > 0)
			$scope.updateAsyncCompCount();
	},
	$scope.clearMultiSelect = function(source) {
		for(var id in source) {
			source[id].ticked=false;
		}
	},
	$scope.updateAsyncCompCount = function() {
		$scope.asyncCompCount--;
		if($scope.asyncCompCount==0)
			$scope.syncIncompleted=false;
	},
	$scope.syncCriteria = function(form) {
		if(form.division == null)
			form.division=undefined;
		else {
			$scope.criteria.division=form.division;
			$scope.updateList(1);
		}
		if(form.category == null)
			form.category=undefined;
		else {
			$scope.asyncCompCount++;
			$scope.criteria.category=form.category;
			$scope.updateList(2, function() {
				$scope.updateAsyncCompCount();
				if(form.product != null && form.product !='')
					$scope.criteria.product = form.product;
			});
		}
		if(form.product == null || form.product == "")
			form.product=undefined;
		else {
			$scope.asyncCompCount++;
			$scope.criteria.product=form.product;
			$scope.updateList(3, function() {
				$scope.updateAsyncCompCount();
				if(form.productType != null && form.productType.length > 0) {
					$scope.syncMultiSelect($scope.boardLevelList[4], form.productType, 1);
				}
			});
		}
		if(form.productType != null && form.productType.length > 0)
			$scope.asyncCompCount++;
		if(form.langs != null && form.langs.length > 0)
			$scope.asyncCompCount++;
		if(form.skills != null && form.skills.length > 0)
			$scope.asyncCompCount++;
		if(form.splId != null && form.splId.length > 0)
			$scope.asyncCompCount++;
		if(form.expId != null && form.expId.length > 0)
			$scope.asyncCompCount++;
		if(form.eduId != null && form.eduId.length > 0)
			$scope.asyncCompCount++;
		if(form.season == null)
			form.season=undefined;
		if(form.country == null)
			form.country=undefined;
		//assign admin rating
		//$scope.adminRatingSlider.min=form.minAdminRating;
		//$scope.adminRatingSlider.max=form.maxAdminRating;
		//assign buyer rating
		$scope.buyerRatingSlider.min=form.minBuyerRating;
		$scope.buyerRatingSlider.max=form.maxBuyerRating;
		//assign price range
		$scope.priceSlider.min=form.minPrice;
		$scope.priceSlider.max=form.maxPrice;
		$scope.criteria=form;
		//sync the date range
		if(form.portfolioSearchStartDate != null) {
			var temp = $filter('date')(form.portfolioSearchStartDate,'yyyy-MM-dd');
			$scope.dt_start=new Date(temp);
		}
		if(form.portfolioSearchEndDate != null) {
			var temp = $filter('date')(form.portfolioSearchEndDate,'yyyy-MM-dd');
			$scope.dt_end=new Date(temp);
		}
		if($scope.asyncCompCount<=0)
			$scope.syncIncompleted=false;
	};
	//initialization
	$scope.clear(true);
   
    $scope.portfolioPagesCount='---';
    $scope.marketplaceSubmissionCount='---';
    $scope.profilesCount='---';
    $scope.examplesCount='---';
	//Sync data from session
	$http({method: 'POST', url: ajaxPaths['searchCriteriaPath']})
	.success(function(data, status, headers, config) {
		// this callback will be called asynchronously when the response is available
		if(data.finalSearchResult==0) {
			$scope.portfolioPagesCount=0;
		    $scope.marketplaceSubmissionCount=0;
		    $scope.profilesCount=0;
		    $scope.examplesCount=0;
		    $scope.syncIncompleted=false;
		}
		else {
			//sync criteria
			$scope.syncCriteria(data.finalSearchResult.form);
			//sync the result count
			if(data.finalSearchResult.portfolioPages.data!=undefined)
				$scope.portfolioPagesCount=data.finalSearchResult.portfolioPages.data.length;
			if(data.finalSearchResult.marketplaceSubmission.data!=undefined)
				$scope.marketplaceSubmissionCount=data.finalSearchResult.marketplaceSubmission.data.length;
			if(data.finalSearchResult.profiles.data!=undefined)
				$scope.profilesCount=data.finalSearchResult.profiles.data.length;
			if(data.finalSearchResult.examples.data!=undefined)
				$scope.examplesCount=data.finalSearchResult.examples.data.length;
		}
    })
    .error(function(data, status, headers, config) {
    	// called asynchronously if an error occurs or server returns response with an error status.
    });
	
	// Value to dollar amount
	$scope.translate = function(value) {
	    return "$ "+value;
	}
	
	//get language list
	$http({method: 'GET', url: ajaxPaths['langListPath']})
	.success(function(data, status, headers, config) {
		// this callback will be called asynchronously when the response is available
		$scope.langList=data.list;
		$scope.syncMultiSelect(data.list, $scope.criteria.langs, 2); //sync search criteria
    })
    .error(function(data, status, headers, config) {
    	// called asynchronously if an error occurs or server returns response with an error status.
    });
	
	//get skill list
	$http({method: 'GET', url: ajaxPaths['skillListPath']})
	.success(function(data, status, headers, config) {
		// this callback will be called asynchronously when the response is available
		$scope.skillList=data.list;
		$scope.syncMultiSelect(data.list, $scope.criteria.skills, 2); //sync search criteria
    })
    .error(function(data, status, headers, config) {
    	// called asynchronously if an error occurs or server returns response with an error status.
    });
	
	//get specialty list
	$http({method: 'GET', url: ajaxPaths['specialtyListPath']})
	.success(function(data, status, headers, config) {
		// this callback will be called asynchronously when the response is available
		$scope.specialtyList=data.list;
		$scope.syncMultiSelect(data.list, $scope.criteria.splId, 2); //sync search criteria
    })
    .error(function(data, status, headers, config) {
    	// called asynchronously if an error occurs or server returns response with an error status.
    });
	
	//get expertise list
	$http({method: 'GET', url: ajaxPaths['expertiseListPath']})
	.success(function(data, status, headers, config) {
		// this callback will be called asynchronously when the response is available
		$scope.expertiseList=data.list;
		$scope.syncMultiSelect(data.list, $scope.criteria.expId, 2); //sync search criteria
    })
    .error(function(data, status, headers, config) {
    	// called asynchronously if an error occurs or server returns response with an error status.
    });
	
	//get education list
	$http({method: 'GET', url: ajaxPaths['educationListPath']})
	.success(function(data, status, headers, config) {
		// this callback will be called asynchronously when the response is available
		$scope.educationList=data.list;
		$scope.syncMultiSelect(data.list, $scope.criteria.eduId, 2); //sync search criteria
    })
    .error(function(data, status, headers, config) {
    	// called asynchronously if an error occurs or server returns response with an error status.
    });
		
	//search click event handler
	//, params: $scope.criteria
	$scope.search = function() {
		$scope.portfolioPagesCount='---';
	    $scope.marketplaceSubmissionCount='---';
	    $scope.profilesCount='---';
	    $scope.examplesCount='---';
		//+'?designerName=&ratings=0&country=238&langs=277&selectItemlangs=277&_langs=1&_skills=1&misc=&_productType=1&keywords=&_saleTypes=on&priceRange=0&timestamp=1404773671964'
		//append portfolio search date range
		if($scope.dt_start != null) {
			$scope.criteria.portfolioSearchStartDate = $scope.dt_start.toDateString();
		}
		else
			$scope.criteria.portfolioSearchStartDate = null;
		if($scope.dt_end != null) {
			$scope.criteria.portfolioSearchEndDate = $scope.dt_end.toDateString();
		}
		else
			$scope.criteria.portfolioSearchEndDate = null;
		//assign admin rating
		//$scope.criteria.minAdminRating=$scope.adminRatingSlider.min;
		//$scope.criteria.maxAdminRating=$scope.adminRatingSlider.max;
		//assign buyer rating
		$scope.criteria.minBuyerRating=$scope.buyerRatingSlider.min;
		$scope.criteria.maxBuyerRating=$scope.buyerRatingSlider.max;
		//assign price range
		$scope.criteria.minPrice=$scope.priceSlider.min;
		$scope.criteria.maxPrice=$scope.priceSlider.max;
		//assign product type
		var pTypeArray=new Array();
		for(var i=0;i<$scope.selectedBoardLevelList[4].length;i++)
			pTypeArray.push($scope.selectedBoardLevelList[4][i].name);
		$scope.criteria.productType=pTypeArray;
		//assign language
		var langArray=new Array();
		for(var i=0;i<$scope.selectedLangList.length;i++)
			langArray.push($scope.selectedLangList[i].lookupValueId);
		$scope.criteria.langs=langArray;
		//assign skill
		var skillArray=new Array();
		for(var i=0;i<$scope.selectedSkillList.length;i++)
			skillArray.push($scope.selectedSkillList[i].lookupValueId);
		$scope.criteria.skills=skillArray;
		//assign expertise
		var expertiseArray=new Array();
		for(var i=0;i<$scope.selectedExpertiseList.length;i++)
			expertiseArray.push($scope.selectedExpertiseList[i].lookupValueId);
		$scope.criteria.expId=expertiseArray;
		//assign specialty
		var specialtyArray=new Array();
		for(var i=0;i<$scope.selectedSpecialtyList.length;i++)
			specialtyArray.push($scope.selectedSpecialtyList[i].lookupValueId);
		$scope.criteria.splId=specialtyArray;
		//assign education
		var educationArray=new Array();
		for(var i=0;i<$scope.selectedEducationList.length;i++)
			educationArray.push($scope.selectedEducationList[i].lookupValueId);
		$scope.criteria.eduId=educationArray;
		
		$scope.isSearching=true;
		$http({method: 'GET', url: ajaxPaths['searchResultPath'], params: $scope.criteria})
		.success(function(data, status, headers, config) {
			$scope.isSearching=false;
			// this callback will be called asynchronously when the response is available
			//$scope.portfolioPagesCount=data.result.portfolioPages.data.length;
			$scope.marketplaceSubmissionCount=data.result.marketplaceSubmission.data.length;
			//$scope.profilesCount=data.result.profiles.data.length;
			//$scope.examplesCount=data.result.examples.data.length;
			//location.href=ajaxPaths['searchViewerPath']+'#marketplaceSubmissions';
	    })
	    .error(function(data, status, headers, config) {
	    	// called asynchronously if an error occurs or server returns response with an error status.
	    	$scope.isSearching=false;
	    });
	};
	//shopping cart
	$scope.getCartItems = function(showCart) {
		console.log('get cart items');
		$scope.isCartSyncing=true;
		if(showCart)
			$scope.showCart=true;
		$http({method: 'GET', url: ajaxPaths['cartPath']})
		.success(function(data, status, headers, config) {
			// this callback will be called asynchronously when the response is available
			$scope.shoppingCart=data;
			$scope.cartItemsCount=data.count;
			$scope.mapCartAddedItems(data.boardIdList);
			$scope.isCartSyncing=false;
	    })
	    .error(function(data, status, headers, config) {
	    	// called asynchronously if an error occurs or server returns response with an error status.
	    	$scope.isCartSyncing=false;
	    });
	}
	$scope.addToCart = function(boardId) {
		console.log(boardId);
		var paramsVal={
			'boardId':boardId
		};
		$scope.isAdding[boardId]=true;
		$http({method: 'POST', url: ajaxPaths['addCartItemPath'], params: paramsVal})
		.success(function(data, status, headers, config) {
			// this callback will be called asynchronously when the response is available
			console.log(data);
			$scope.isAdding[boardId]=false;
			$scope.shoppingCart=data;
			$scope.cartItemsCount=data.count;
			$scope.mapCartAddedItems(data.boardIdList);
	    })
	    .error(function(data, status, headers, config) {
	    	// called asynchronously if an error occurs or server returns response with an error status.
	    	$scope.isAdding[boardId]=false;
	    });
	}
	$scope.removeFromCart = function(boardId) {
		var paramsVal={
			'boardId':boardId
		};
		$scope.isRemoving[boardId]=true;
		$http({method: 'POST', url: ajaxPaths['deleteCartItemPath'], params: paramsVal})
		.success(function(data, status, headers, config) {
			// this callback will be called asynchronously when the response is available
			console.log(data);
			$scope.isRemoving[boardId]=false;
			$scope.shoppingCart=data;
			$scope.cartItemsCount=data.count;
			$scope.mapCartAddedItems(data.boardIdList);
	    })
	    .error(function(data, status, headers, config) {
	    	// called asynchronously if an error occurs or server returns response with an error status.
	    	$scope.isRemoving[boardId]=false;
	    });
	}
	$scope.processItem = function(boardId) {
		if($scope.addedItems[boardId]) {
			//remove item
			$scope.removeFromCart(boardId);
		}
		else {
			//add item
			$scope.addToCart(boardId);
		}
	}
	$scope.mapCartAddedItems = function(data) {
		$scope.addedItems={};
		for(var index in data) {
			$scope.addedItems[data[index]]=true;
		}
	}
	$scope.hideCart = function() {
		$scope.showCart=false;
	}
	
	$scope.cartItemsCount='---';
	$scope.getCartItems(false); //retrieve cart items when page load
}]);

app.controller('buyerSearchViewer', ['$scope', '$http', '$filter', '$location', '$rootScope', function($scope,$http,$filter,$location,$rootScope) {
	//initialization
	$scope.columnNumber=10;
	$scope.showPanel={};
	$scope.loading={};
	$scope.boardDetail={};
	$scope.dt_start=null;
	$scope.dt_end=new Date();
	//pagin
	$scope.columnsPerRow=10;
	$scope.currentPage=0;
	$scope.totalPages=0;
	$scope.rowsPerPage=10;
	//Param for identify hash URL for different tabs
	$scope.containerType={};
	$scope.selectedTab={};
	//addition access for downloading the source file. Update the value when inject the board data.
	$scope.hasAdditionAccess=false;
	//
	$scope.isEmptyResult=false;
	//shopping cart
	$scope.showCart=false;
	$scope.isAdding={};
	$scope.isRemoving={};
	$scope.addedItems={};
	$scope.isCartSyncing=false;
	
	$scope.render = function() {
		var upperBound=($scope.currentPage+1)*$scope.rowsPerPage*$scope.columnsPerRow,
			lowerBound=$scope.currentPage*$scope.rowsPerPage*$scope.columnsPerRow;
		if(upperBound>=$scope.data.length)
			upperBound=$scope.data.length;
		$scope.upperBound=upperBound;
		$scope.lowerBound=lowerBound;
		$scope.items=$scope.data.slice(lowerBound,upperBound);
	},
	$scope.updateRows = function() {
		$scope.totalPages=Math.floor($scope.data.length/($scope.rowsPerPage*$scope.columnsPerRow)); //update total pages
		if($scope.data.length%($scope.rowsPerPage*$scope.columnsPerRow)==0)
			$scope.totalPages-=1;
		$scope.render();
	},
	$scope.nextPage = function() {
		if($scope.currentPage + 1 > $scope.totalPages)
			$scope.currentPage = 0;
		else
			$scope.currentPage += 1;
		$scope.render();
	},
	$scope.prevPage = function() {
		if($scope.currentPage -1 < 0)
			$scope.currentPage = $scope.totalPages;
		else
			$scope.currentPage -= 1;
		$scope.render();
	},
	$scope.syncCriteria = function(form) {
		if(form.productType != null && form.productType.length > 0)
			$scope.asyncCompCount++;
		if(form.langs != null && form.langs.length > 0)
			$scope.asyncCompCount++;
		if(form.skills != null && form.skills.length > 0)
			$scope.asyncCompCount++;
		if(form.splId != null && form.splId.length > 0)
			$scope.asyncCompCount++;
		if(form.expId != null && form.expId.length > 0)
			$scope.asyncCompCount++;
		if(form.eduId != null && form.eduId.length > 0)
			$scope.asyncCompCount++;
		if(form.season == null)
			form.season=undefined;
		if(form.country == null)
			form.country=undefined;
		$scope.criteria=form;
		//sync the date range
		if(form.portfolioSearchStartDate != null) {
			var temp = $filter('date')(form.portfolioSearchStartDate,'yyyy-MM-dd');
			$scope.dt_start=new Date(temp);
		}
		if(form.portfolioSearchEndDate != null) {
			var temp = $filter('date')(form.portfolioSearchEndDate,'yyyy-MM-dd');
			$scope.dt_end=new Date(temp);
		}
		if($scope.asyncCompCount<=0)
			$scope.syncIncompleted=false;
	},
	$scope.search = function() {
		$scope.isUpdating=true;
		//append portfolio search date range
		if($scope.dt_start != null) {
			$scope.criteria.portfolioSearchStartDate = $scope.dt_start.toDateString();
		}
		else
			$scope.criteria.portfolioSearchStartDate = null;
		if($scope.dt_end != null) {
			$scope.criteria.portfolioSearchEndDate = $scope.dt_end.toDateString();
		}
		else
			$scope.criteria.portfolioSearchEndDate = null;
		
		$http({method: 'GET', url: ajaxPaths['searchResultPath'], params: $scope.criteria})
		.success(function(data, status, headers, config) {
			// this callback will be called asynchronously when the response is available
			$scope.injectData(data.result);
			$scope.updateRows();
			$scope.isUpdating=false;
	    })
	    .error(function(data, status, headers, config) {
	    	// called asynchronously if an error occurs or server returns response with an error status.
	    });
	},
	$scope.dateChange = function() {
		$scope.search();
	},
	$scope.updateData = function(type) {
		console.log('update data: '+ajaxPaths['searchViewerPath']);
		//get search result
		$scope.isUpdating=true; //show data updating panel
		$scope.isEmptyResult=false;
		$http({method: 'POST', url: ajaxPaths['searchViewerPath']})
		.success(function(data, status, headers, config) {
			console.log(data);
			// this callback will be called asynchronously when the response is available
			if(data.finalSearchResult != 0 && data.finalSearchResult != undefined) {
				$scope.injectData(data.finalSearchResult);
				$scope.syncCriteria(data.finalSearchResult.form);
				$scope.updateRows();
			}
			else {
				$scope.isEmptyResult=true;
			}
			$scope.isUpdating=false; //hide data updating panel
	    })
	    .error(function(data, status, headers, config) {
	    	// called asynchronously if an error occurs or server returns response with an error status.
	    });
	},
	$scope.injectData = function(data) {
		if($scope.containerType=='portfolioPages') {
			$scope.data=data.portfolioPages.data;
			$scope.hasAdditionAccess=true;
		}
		else if($scope.containerType=='marketplaceSubmissions') {
			$scope.data=data.marketplaceSubmission.data;
			$scope.hasAdditionAccess=false;
		}
		else if($scope.containerType=='examples') {
			$scope.data=data.examples.data;
			$scope.hasAdditionAccess=true;
		}
	},
	$scope.navigate = function(index) {
		if(index!='' 
			&& index!=undefined 
			&& !isNaN(parseInt(index))
			&& index < $scope.data.length
			&& index > 0 ) {
			$scope.currentPage=Math.floor(index/($scope.rowsPerPage*$scope.columnsPerRow));
			if(index%$scope.rowsPerPage == 0)
				$scope.currentPage--;
			$scope.render();
		}
	},
	$scope.navigateHandler = function($event) {
		if($event == undefined || $event.keyCode == 13 ) {
			$scope.navigate($scope.itemIndex);
		}
	}; 
	
	//event
	//url hash change event
	$rootScope.$on('$locationChangeStart', function(event, newUrl, oldUrl) {
		$scope.containerType=$location.hash();
		$scope.selectedTab={};
		$scope.selectedTab[$location.hash()]='selected';
		$scope.updateData($scope.containerType);
		$scope.currentPage=0;
		$scope.closeDetail();
		$scope.itemIndex=null;
	});
	//Show board detail window
	$scope.getDetail = function(obj,boardId,index) {
		//load board detail
		$scope.loading[index]='loading';
		$scope.detailIndex=index;
		$scope.isSelected={};
		$http({method: 'GET', url: ajaxPaths['boardDetailPath']+"/"+boardId})
		.success(function(data, status, headers, config) {
			// this callback will be called asynchronously when the response is available
			var groupIndex=Math.floor(index/$scope.columnsPerRow);
			$scope.boardDetail = data;
			$scope.showPanel={}; //reset all panel
			$scope.showPanel[groupIndex]=true; //show detail panel
			$scope.loading={}; //hide loading label	
			$scope.isSelected[index]='selected'; //set selected index
	    })
	    .error(function(data, status, headers, config) {
	    	// called asynchronously if an error occurs or server returns response with an error status.
	    });
	};
	$scope.closeDetail = function(index) {
		//hide detail panel
		if(index!=undefined)
			$scope.showPanel[Math.floor(index/$scope.columnsPerRow)]='';
		else
			$scope.showPanel={}; //reset all
		$scope.isSelected={}; //reset
	};
	$scope.showImageWindow = function(imgPath) {
		//retrieve image size
		$http({method: 'GET', url: ajaxPaths['imageSizeRetrieverPath']+'?img='+imgPath})
		.success(function(data, status, headers, config) {
			// this callback will be called asynchronously when the response is available
			//get screen size, and determine the size of image viewer.
			var screenWidth=screen.width
				,screenHeight=screen.height
				,imageWidth=data.imageWidth
				,imageHeight=data.imageHeight;
			
			if(imageWidth>=screenWidth*0.9)
				imageWidth=screenWidth*0.9;
			if(imageHeight>=screenHeight*0.85)
				imageHeight=screenHeight*0.85;
			//open the new window with scrollbar and without toolbar.
			window.open(ajaxPaths['imageViewerPath']+"?img="+imgPath,"_blank",'width='+imageWidth+',height='+imageHeight+',scrollbars=yes,toolbar=no,location=0');
	    })
	    .error(function(data, status, headers, config) {
	    	// called asynchronously if an error occurs or server returns response with an error status.
	    });
	};
	//Board list filter
	$scope.filterList = function(source,selfBoardId) {
		var result=new Array();
		if(source!=undefined) {
			for(var i=0;i<source.length;i++) {
				if(source[i].publishToMP == 1 && source[i].activeStatus == 1 && source[i].boardId != selfBoardId)
					result.push(source[i]);
			}
		}
		return result;
	}
	$scope.showImgInfo = function(index) {
		return $scope.showPanel[Math.floor(index/$scope.columnsPerRow)];
	};
	//shopping cart
	$scope.getCartItems = function(showCart) {
		console.log('get cart items');
		$scope.isCartSyncing=true;
		if(showCart)
			$scope.showCart=true;
		$http({method: 'GET', url: ajaxPaths['cartPath']})
		.success(function(data, status, headers, config) {
			// this callback will be called asynchronously when the response is available
			$scope.shoppingCart=data;
			$scope.cartItemsCount=data.count;
			$scope.mapCartAddedItems(data.boardIdList);
			$scope.isCartSyncing=false;
	    })
	    .error(function(data, status, headers, config) {
	    	// called asynchronously if an error occurs or server returns response with an error status.
	    	$scope.isCartSyncing=false;
	    });
	}
	$scope.addToCart = function(boardId) {
		console.log(boardId);
		var paramsVal={
			'boardId':boardId
		};
		$scope.isAdding[boardId]=true;
		$http({method: 'POST', url: ajaxPaths['addCartItemPath'], params: paramsVal})
		.success(function(data, status, headers, config) {
			// this callback will be called asynchronously when the response is available
			console.log(data);
			$scope.isAdding[boardId]=false;
			$scope.shoppingCart=data;
			$scope.cartItemsCount=data.count;
			$scope.mapCartAddedItems(data.boardIdList);
	    })
	    .error(function(data, status, headers, config) {
	    	// called asynchronously if an error occurs or server returns response with an error status.
	    	$scope.isAdding[boardId]=false;
	    });
	}
	$scope.removeFromCart = function(boardId) {
		var paramsVal={
			'boardId':boardId
		};
		$scope.isRemoving[boardId]=true;
		$http({method: 'POST', url: ajaxPaths['deleteCartItemPath'], params: paramsVal})
		.success(function(data, status, headers, config) {
			// this callback will be called asynchronously when the response is available
			console.log(data);
			$scope.isRemoving[boardId]=false;
			$scope.shoppingCart=data;
			$scope.cartItemsCount=data.count;
			$scope.mapCartAddedItems(data.boardIdList);
	    })
	    .error(function(data, status, headers, config) {
	    	// called asynchronously if an error occurs or server returns response with an error status.
	    	$scope.isRemoving[boardId]=false;
	    });
	}
	$scope.processItem = function(boardId) {
		if($scope.addedItems[boardId]) {
			//remove item
			$scope.removeFromCart(boardId);
		}
		else {
			//add item
			$scope.addToCart(boardId);
		}
	}
	$scope.mapCartAddedItems = function(data) {
		$scope.addedItems={};
		for(var index in data) {
			$scope.addedItems[data[index]]=true;
		}
	}
	$scope.hideCart = function() {
		$scope.showCart=false;
	}
	
	$scope.cartItemsCount='---';
	$scope.getCartItems(false); //retrieve cart items when page load
}]);

app.controller('datePickerController', ['$scope', function($scope) {
	$scope.open = function($event) {
	    $event.preventDefault();
	    $event.stopPropagation();
	    $scope.opened = true;
	};
}]);
    
    