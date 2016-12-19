app.controller('adminProjects', ['$scope', '$http', function($scope, $http) {
	console.log('Project Controller');
}]);

app.controller('uploadController1', ['$scope','$http','$rootScope', function($scope,$http,$rootScope) {
	$scope.hasRemoved=true;
	$scope.$watch('fileUploadResult', function(newValue, oldValue) {
		if(newValue!=undefined) {
			if($scope.$parent.files[1]!=undefined && $scope.$parent.files[1].portfolio_image_id!=undefined)
				$scope.fileUploadResult.portfolio_image_id=$scope.$parent.files[1].portfolio_image_id; //keep portfolio image id
			else
				$scope.fileUploadResult.portfolio_image_id=0;
			$scope.fileUploadResult.active_status=1;
			$scope.$parent.files[1]=$scope.fileUploadResult;
		}
	});
	//watch rootScope
	$scope.$watch('files[1]', function(newValue, oldValue) {
		if(newValue!=undefined) {
			if(newValue.active_status==1) {
				$scope.hasRemoved=false;
				$scope.previewImg=newValue.upload_filename_400x400;
			}
		}
	},true);
	$scope.removeImg=function() {
		$scope.hasRemoved=true;
		$scope.fileUploadResult=undefined;
		//update parent model
		if($scope.$parent.files[1]!=undefined)
			$scope.$parent.files[1].active_status=0;
	};
}]);

app.controller('uploadController2', ['$scope','$http','$rootScope', function($scope,$http,$rootScope) {
	$scope.hasRemoved=true;
	$scope.$watch('fileUploadResult', function(newValue, oldValue) {
		if(newValue!=undefined) {
			if($scope.$parent.files[2]!=undefined && $scope.$parent.files[2].portfolio_image_id!=undefined)
				$scope.fileUploadResult.portfolio_image_id=$scope.$parent.files[2].portfolio_image_id; //keep portfolio image id
			else 
				$scope.fileUploadResult.portfolio_image_id=0;
			$scope.fileUploadResult.active_status=1;
			$scope.$parent.files[2]=$scope.fileUploadResult;
		}
	},true);
	//watch rootScope
	$scope.$watch('files[2]', function(newValue, oldValue) {
		if(newValue!=undefined) {
			if(newValue.active_status==1) {
				$scope.hasRemoved=false;
				$scope.previewImg=newValue.upload_filename_400x400;
			}
		}
	});
	$scope.removeImg=function() {
		$scope.hasRemoved=true;
		$scope.fileUploadResult=undefined;
		//update parent model
		if($scope.$parent.files[2]!=undefined)
			$scope.$parent.files[2].active_status=0;
	};
}]);

app.controller('editProjectController', ['$scope','$http','$rootScope','$log','FormValidator','dialogs','mode','$routeParams','$filter','ProjectService','$location','$window', function($scope,$http,$rootScope,$log,formValidator,dialogs,mode,$routeParams,$filter,projectService,$location,$window) {
	$log.log('edit project controller for '+mode+' action by '+$routeParams.portfolioId);
	$rootScope.tab={
		'createProject':true
	};
	//dialog options setup
	var dialogOpt={
		size: 'md'
	}
	//flag
	$scope.isStarted=false;
	$scope.isStarting=false;
	//board level list
	$scope.boardLevelList={};
	$scope.boardLevelList[4]={};
	$scope.selectedBoardLevelList={};
	//buyer list
	$scope.buyerList={};
	$scope.selectedBuyerList={};
	//form
	$scope.form={};
	//min due date
	$scope.minDueDate=new Date();
	//async
	$scope.syncIncompleted=false;
	$scope.asyncCompCount=0;
	//
	$scope.files=new Array();
	
	$scope.updateList = function(level,callback) {
		var path;
		if(level<4) {   			
    		if(level==1) {
    			path=ajaxPaths['categoryListPath']+'/'+$scope.form.division;
    			$scope.boardLevelList[2]={};
    			$scope.boardLevelList[3]={};
    			$scope.boardLevelList[4]={};
    			$scope.form.category=null; //reset to default
    			$scope.form.product=null; //reset to default
    			$scope.form.productType=null; //reset to default
    		}
    		else if(level==2) {
    			path=ajaxPaths['productListPath']+'/'+$scope.form.category;
    			$scope.boardLevelList[3]={};
    			$scope.boardLevelList[4]={};
    			$scope.form.product=null; //reset to default
    			$scope.form.productType=null; //reset to default
    		}
    		else {
    			path=ajaxPaths['productTypeListPath']+'?level1='+$scope.form.division+'&level2='+$scope.form.category+'&productTags='+encodeURIComponent($scope.form.product);
    			$scope.boardLevelList[4]="";
    			$scope.form.productType=null; //reset to default
    		}
    		$http({method: 'GET', url: path})
			.success(function(data, status, headers, config) {
				$scope.boardLevelList[level+1]=data.list; //assign the list to the next level container
				if(typeof(callback)=='function')
					callback();
		    })
		    .error(function(data, status, headers, config) {
		    });
		}
	};
	//Form manipulation
	$scope.startProject = function() {
		$scope.isStarting=true;
		$http({method: 'GET', url: ajaxPaths['startProjectPath']})
		.success(function(data, status, headers, config) {
			$scope.isStarting=false;
			if(data!=undefined && data.hasError==false) {
				$scope.data=data.result; //inject data to scope
				$scope.isStarted=true; //show project creation form.
			}
			else {
				var err=dialogs.error('Error','Service unavailable. Please click START NEW PROJECT again. Thank you.',dialogOpt);
			}
	    })
	    .error(function(data, status, headers, config) {
	    	$scope.isStarting=false;
	    });
	},
	$scope.fillForm=function(data) {
		//start syncing dynamic load components.
		$scope.syncIncompleted=true;
		$scope.data={
			contestPortfolioDomain: {
				portfolioId: {}
			}
		};
		//get buyer list with pre-selected user
		$scope.asyncCompCount++; //add one async component to wait for sync.
		$scope.getBuyerList(data.originalData.contestPortfolioDomain.userId);
		//fill form
		$scope.data.portfolioId=data.originalData.portfolioId;
		$scope.data.contestId=data.originalData.contestId;
		$scope.data.contestPortfolioDomain.portfolioId=data.originalData.portfolioId;
		$scope.form.title=data.title;
		if(data.originalData.projectType==0)
			$scope.form.contestType='';
		else
			$scope.form.contestType=data.originalData.projectType;
		if(data.originalData.numberOfWinners!=0)
			$scope.form.winners=data.originalData.numberOfWinners;
		var temp = $filter('date')(data.endDate,'yyyy-MM-dd');
		$scope.form.dueDate=new Date(temp);
		$scope.form.subKeywords1=data.subKeywords.skw1;
		$scope.form.subKeywords2=data.subKeywords.skw2;
		$scope.form.subKeywords3=data.subKeywords.skw3;
		$scope.form.subKeywords4=data.subKeywords.skw4;
		$scope.form.season=data.originalData.contestPortfolioDomain.seasonYearId;
		$scope.form.associatedBrandsInfluence=data.originalData.associatedBrandsInfluence;
		$scope.form.associatedBrandsHangWith=data.originalData.associatedBrandsHangWith;
		$scope.form.introduction=data.originalData.introduction;
		$scope.form.description=data.originalData.contestPortfolioDomain.description;
		$scope.form.deliverables=data.originalData.deliverable;
		$scope.form.otherInformation=data.originalData.otherInformation;
		$scope.form.dimensions=data.originalData.boardDimension;
		$scope.form.format=data.originalData.boardFormat;
		//board category
		/*
		$scope.form.division
		$scope.form.category
		$scope.form.product
		$scope.boardLevelList[4]
		*/
		//level1
		if(data.originalData.contestPortfolioDomain.categoryLevel1Id == null || data.originalData.contestPortfolioDomain.categoryLevel1Id == undefined)
			$scope.form.division=undefined;
		else {
			$scope.form.division=data.originalData.contestPortfolioDomain.categoryLevel1Id;
			//get level 2 list
			$scope.updateList(1);
		}
		//level2
		if(data.originalData.contestPortfolioDomain.categoryLevel2Id == null || data.originalData.contestPortfolioDomain.categoryLevel2Id == undefined)
			$scope.form.category=undefined;
		else {
			$scope.asyncCompCount++; //async comp for level 2 list
			$scope.form.category=data.originalData.contestPortfolioDomain.categoryLevel2Id;
			//get level 3 list
			$scope.updateList(2, function() {
				$scope.updateAsyncCompCount('level 2');
				if(data.product != null && data.product.length > 0)
					$scope.form.product = data.product[0];
			});
		}
		//level3
		if(data.product == null || data.product.length <= 0)
			$scope.form.product=undefined;
		else {
			if(data.product != null && data.product.length > 0) {
				$scope.asyncCompCount++; //async comp for level 3 list
				$scope.form.product = data.product[0];
			}
			$scope.updateList(3, function() {
				$scope.updateAsyncCompCount('level 3');
				//level4
				if(data.productType != null && data.productType.length > 0) {
					$scope.syncMultiSelect($scope.boardLevelList[4], data.productType, 1);
				}
			});
		}
		//attach image to the preview area and files container 
		//initialize variables in the form
		for(var id in data.originalData.contestPortfolioDomain.portfolioImages) {
			$scope.files[parseInt(id)+1]={
				portfolio_image_id:data.originalData.contestPortfolioDomain.portfolioImages[id].portfolioImageId,
				upload_ext:data.originalData.contestPortfolioDomain.portfolioImages[id].fileType,
				upload_filename:data.originalData.contestPortfolioDomain.portfolioImages[id].sourceFileURL,
				upload_filename_100x100:data.originalData.contestPortfolioDomain.portfolioImages[id].thumbnailUrl,
				upload_filename_400x400:data.originalData.contestPortfolioDomain.portfolioImages[id].fileName,
				upload_filename_original:data.originalData.contestPortfolioDomain.portfolioImages[id].mainImageUrl,
				active_status:data.originalData.contestPortfolioDomain.portfolioImages[id].activeStatus
			};
		}
	},
	$scope.updateAsyncCompCount = function(where) {
		console.log('Update aync count from: '+where);
		$scope.asyncCompCount--;
		if($scope.asyncCompCount==0) {
			$scope.syncIncompleted=false;
			$scope.isLoading=false;
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
			$scope.updateAsyncCompCount('sync multiselect');
	},
	$scope.saveProject = function() {
		$scope.prepareForm();
		var confirmDialog = dialogs.confirm('CONFIRMATION','Do you want to save the project?',dialogOpt);
		confirmDialog.result.then(function(btn){
			projectService.submitForm({
				save:true
			},$scope.form,{
				notify: function() {
					$scope.isSubmitting=true;
					//show progress dialog
					var waitDialog = dialogs.wait('Please Wait',undefined,50,dialogOpt);
				},
				success: function(data,msg) {
					var notifyDialog = dialogs.notify('RESULT',msg,dialogOpt);
					$scope.isSubmitting=false;
					$scope.unbindUnloadEvent(); //unbind unload event
				},
				error: function(data) {
					$scope.isSubmitting=false;
					$scope.hasError=true;
			    	//make progress 100% and complete.
					$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 0});
					$rootScope.$broadcast('dialogs.wait.complete');
					var err=dialogs.error('Error','Service unavailable. Please try again. Thank you.',dialogOpt);
				},
				complete: function(data) {
					//make progress 100% and complete.
					$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 100});
					$rootScope.$broadcast('dialogs.wait.complete');
				}
			});
		},angular.noop);
	},
	$scope.cancelProject = function() {
		$scope.prepareForm();
		var dlg = dialogs.create('/dialogs/submit_project_options.html','submitProjectDialogCtrl',{title:'Delete Project',text:'Do you want to DELETE the project?'},{size:'md',keyboard: true,backdrop: true,windowClass: 'cust-modal'});
		dlg.result.then(function(options){
			projectService.submitForm({
				cancel:true,
				returnSubmissions:options.returnSubmissions,
				sendNotification:options.sendNotification
			},$scope.form,{
				notify: function() {
					$scope.isSubmitting=true;
					//show progress dialog
					var waitDialog = dialogs.wait('Please Wait',undefined,50,dialogOpt);
				},
				success: function(data,msg) {
					var notifyDialog = dialogs.notify('RESULT',msg,dialogOpt);
					$scope.isSubmitting=false;
					$scope.unbindUnloadEvent(); //unbind unload event
					//change the path to start over
					$location.path(ajaxPaths['createProjectPath']);
				},
				error: function(data) {
					$scope.isSubmitting=false;
					$scope.hasError=true;
			    	//make progress 100% and complete.
					$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 0});
					$rootScope.$broadcast('dialogs.wait.complete');
					var err=dialogs.error('Error','Service unavailable. Please try again. Thank you.',dialogOpt);
				},
				complete: function(data) {
					//make progress 100% and complete.
					$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 100});
					$rootScope.$broadcast('dialogs.wait.complete');
				}
			});
		},angular.noop);
	},
	$scope.publishProject = function() {
		//save form and then go to preview page
		$scope.prepareForm();
		var validationResult = formValidator.projectFormaValidator($scope.form);
		if(validationResult.status==0) {
			var waitDialog = dialogs.wait('Please Wait','Saving...',50,dialogOpt);
			projectService.submitForm({
				save:true
			},$scope.form,{
				notify: function() {
					$scope.isSubmitting=true;
					//show progress dialog
					$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 70});
				},
				success: function(data,msg) {
					//var notifyDialog = dialogs.notify('RESULT',msg,dialogOpt);
					$scope.isSubmitting=false;
					$scope.unbindUnloadEvent(); //unbind unload event
					$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 90});
					//go to preview page
					$window.open(ajaxPaths['previewCBDPath']+'?portfolioId='+data.result.originalData.portfolioId+'&contestId='+data.result.originalData.contestId,'_self');
				},
				error: function(data) {
					$scope.isSubmitting=false;
					$scope.hasError=true;
			    	//make progress 100% and complete.
					$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 0});
					$rootScope.$broadcast('dialogs.wait.complete');
					var err=dialogs.error('Error','Service unavailable. Please try again. Thank you.',dialogOpt);
				},
				complete: function(data) {
					//make progress 100% and complete.
					$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 100});
				}
			});
		}
		else {
			var err=dialogs.error('Error',validationResult.error.join('<br/>'),dialogOpt);
		}
	},
	$scope.prepareForm = function() {
		//assign portfolioId
		if($scope.data!=undefined) {
			$scope.form.contestId=$scope.data.contestId;
			$scope.form.portfolioId=$scope.data.portfolioId;
		}
		else {
			var err=dialogs.error('Error','Service unavailable. Please click START NEW PROJECT. Thank you.',dialogOpt);
			$scope.isStarted=false;
		}
		//assign product type
		var pTypeArray=new Array();
		for(var i=0;i<$scope.selectedBoardLevelList[4].length;i++)
			pTypeArray.push($scope.selectedBoardLevelList[4][i].name);
		$scope.form.productType=pTypeArray;
		var buyerArray=new Array();
		for(var i=0;i<$scope.selectedBuyerList.length;i++)
			buyerArray.push($scope.selectedBuyerList[i].userId);
		$scope.form.client=buyerArray;
		//convert date
		if($scope.form.dueDate!=undefined) {
			$scope.form.dueDate=new Date($scope.form.dueDate);
			$scope.form.dueDate=$scope.form.dueDate.toDateString();
		}
		//files
		/*
		 * 	private Integer[] portfolio_image_id;
			private String[] filename;
			private String[] filename_ext;
			private String[] filename_400;
			private String[] filename_100;
			private String[] filename_original;
			private Integer[] filestatus;
			private Integer[] active_status;
		 */
		var pImgId=new Array(),
			filename=new Array(),
			filename_ext=new Array(),
			filename_400=new Array(),
			filename_100=new Array(),
			filename_original=new Array(),
			active_status=new Array();
		if($scope.files[1]!=undefined) {
			pImgId.push($scope.files[1].portfolio_image_id);
			filename_ext.push($scope.files[1].upload_ext);
			filename.push($scope.files[1].upload_filename);
			filename_100.push($scope.files[1].upload_filename_100x100);
			filename_400.push($scope.files[1].upload_filename_400x400);
			filename_original.push($scope.files[1].upload_filename_original);
			active_status.push($scope.files[1].active_status);
		}
		
		if($scope.files[2]!=undefined) {
			pImgId.push($scope.files[2].portfolio_image_id);
			filename_ext.push($scope.files[2].upload_ext);
			filename.push($scope.files[2].upload_filename);
			filename_100.push($scope.files[2].upload_filename_100x100);
			filename_400.push($scope.files[2].upload_filename_400x400);
			filename_original.push($scope.files[2].upload_filename_original);
			active_status.push($scope.files[2].active_status);
		}
		//apply upload result to form
		$scope.form.portfolio_image_id=pImgId;
		$scope.form.filename_ext=filename_ext;
		$scope.form.filename=filename;
		$scope.form.filename_100=filename_100;
		$scope.form.filename_400=filename_400;
		$scope.form.filename_original=filename_original;
		$scope.form.active_status=active_status;
	},
	$scope.getBuyerList = function(selectedUserId) {
		$http({method: 'GET', url: ajaxPaths['buyerListPath']})
		.success(function(data, status, headers, config) {
			$scope.buyerList=data.buyerList;
			if(selectedUserId!=undefined) {
				for(var id in $scope.buyerList) {
					if($scope.buyerList[id].userId==selectedUserId) {
						$scope.buyerList[id].ticked=true;
					}
				}
				$scope.updateAsyncCompCount('buyer list'); //update asyncComp count
			}
	    })
	    .error(function(data, status, headers, config) {
	    });
	};
	
	//if mode is update, retrieve project info and show creation panel directly
	if(mode=='update') {
		$scope.isStarted=true;
		//retrieve project information
		$scope.syncIncompleted=true;
		$scope.isLoading=true;
		//retrieve the project data
		$http({method: 'GET', url: ajaxPaths['getProjectDetail'], params:{portfolioId:$routeParams.portfolioId, contestId:$routeParams.contestId}})
		.success(function(data, status, headers, config) {
			$scope.isLoading=false;
			if(data.hasError==false) {
				if(data.contests!=undefined && data.contests.length>0)
					$scope.fillForm(data.contests[0]);
				else {
					var err=dialogs.error('Error','Unable to locate the record',dialogOpt);
					//change the path to start over
					$location.path(ajaxPaths['createProjectPath']);
				}
			}
			else {
				var err=dialogs.error('Error','Service unavailable. Please try refresh the page. Thank you.',dialogOpt);
			}
		})
		.error(function(data, status, headers, config) {
		   	$scope.isLoading=false;
		   	var err=dialogs.error('Error','Service unavailable. Please try refresh the page. Thank you.',dialogOpt);
		});
	}
	else if(mode=='create') {
		//get buyer list without pre-selected user
		$scope.getBuyerList();
	}
	
	//Handler to prevent user leave the page without saving
	//watch form object to bind beforeUnload event
	$scope.formChanged=false;
	var leavingPageText = "You are about to leave the page with unsaved data, Would you like to save before leaving?";
	var unbindFormWatcher, unbindLocationChangeWatcher;
	unbindFormWatcher = $scope.$watch('form', function(newValue, oldValue) {
		if(newValue!=oldValue && !$scope.formChanged) {
			$scope.formChanged=true;
			//bind beforeunload event
			window.onbeforeunload = function() {
				return leavingPageText;
			}
			//bind unload event when route change start happen
			unbindLocationChangeWatcher = $scope.$on('$locationChangeStart', function(event, next, current) {
				event.preventDefault();
				//Show custom dialog
				var confirmDialog = dialogs.confirm('CONFIRMATION',leavingPageText,dialogOpt);
				confirmDialog.result.then(function(btn){
					var waitDialog = dialogs.wait('Please Wait','Saving...',50,dialogOpt);
					$scope.prepareForm();
					projectService.submitForm({
						save:true
					},$scope.form,{
						notify: function() {
							$scope.isSubmitting=true;
							//show progress dialog
							$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 70});
						},
						success: function(data,msg) {
							//var notifyDialog = dialogs.notify('RESULT',msg,dialogOpt);
							$scope.isSubmitting=false;
							$scope.unbindUnloadEvent(); //unbind unload event
							$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 90});
							//change url to redirect
							location.href=next;
						},
						error: function(data) {
							$scope.isSubmitting=false;
							$scope.hasError=true;
							$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 0});
							$rootScope.$broadcast('dialogs.wait.complete');
							var err=dialogs.error('Error','Service unavailable. Please try again. Thank you.',dialogOpt);
						},
						complete: function(data) {
							//make progress 100% and complete.
							$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 100});
						}
					});
				},function() {
					$scope.unbindUnloadEvent();
					location.href=next;
				});
		    });
		}
	}, true);
	$scope.unbindUnloadEvent= function() {
		window.onbeforeunload = undefined;
		unbindLocationChangeWatcher();
	};
	//unbind beforeunload event when leave this page ($destory event will be triggered)
	$scope.$on('$destroy', function() {
	    window.onbeforeunload = undefined;
	});
}]);

app.controller('manageProjectsController', ['$scope','$http','$rootScope','$log','dialogs','BoardService','$location','ProjectService', function($scope, $http, $rootScope,$log,dialogs,boardService,$location,projectService) {
	console.log('manage projects controller');
	$rootScope.tab={
		'manageProjects':true
	};
	
	//dialog options setup
	var dialogOpt={
		size: 'md'
	}
	//pagin
	$scope.currentPage=0;
	$scope.totalPages=0;
	$scope.rowsPerPage=30;
	$scope.upperBound=0;
	$scope.lowerBound=0;
	//data
	$scope.filteredData=null;
	//sort utility
	$scope.sortOpt=[1,1,1,1,1,1,1,1,1,1];
	$scope.sortingOpt={};
	$scope.sortIcon={};
	for(var id in $scope.sortOpt) {
		$scope.sortIcon[id]='glyphicon-chevron-up';
	}
	
	//
	$scope.render = function() {
		var upperBound=($scope.currentPage+1)*$scope.rowsPerPage,
			lowerBound=$scope.currentPage*$scope.rowsPerPage;
		if(upperBound>=$scope.items.length)
			upperBound=$scope.items.length;
		$scope.upperBound=upperBound;
		$scope.lowerBound=lowerBound;
		if($scope.filteredUsers==null)
			$scope.displayData=$scope.items.slice(lowerBound,upperBound);
		else
			$scope.displayData=$scope.filteredData.slice(lowerBound,upperBound);
		//load boards data
		$scope.getContestBoards($scope.items, lowerBound, upperBound);
	},
	$scope.updateRows = function() {
		$scope.totalPages=Math.floor($scope.items.length/$scope.rowsPerPage); //update total pages
		if($scope.items.length%$scope.rowsPerPage==0)
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
	$scope.navigate = function(index) {
		if(index!='' 
			&& index!=undefined 
			&& !isNaN(parseInt(index))
			&& index < $scope.items.length
			&& index > 0 ) {
			$scope.currentPage=Math.floor(index/$scope.rowsPerPage);
			if(index%$scope.rowsPerPage == 0)
				$scope.currentPage--;
			$scope.render();
		}
	},
	$scope.navigateHandler = function($event) {
		if($event == undefined || $event.keyCode == 13 ) {
			$scope.navigate($scope.itemIndex);
		}
	},
	$scope.injectData = function(data) {
		$scope.items=data.contests;
		$scope.hasError=data.hasError;
		$scope.updateRows();
	},
	$scope.getContestBoards = function(items, start, end) {
		boardService.getContestBoardsByRange(items, start, end);
	},
	$scope.sort = function(option, order) {
		/*
		1 Type 
		2 Title
		3 Status
		4 Submissions
		5 Ends
		6 Docs
		8 Actions
		7 project id
		*/
		var sortFactor=$scope.sortOpt[option];
		if(order!=undefined)
			sortFactor=order;
		if($scope.loadCompleted) {
			$scope.sortingOpt.option=0; //reset sorting option
		}
		else {
			$scope.sortingOpt.option=option;
			$scope.sortingOpt.order=sortFactor;
		}
		
		//
		switch(option) {
		case 1: //type
			$scope.items.sort(function(a, b) {
				if(a.contestType > b.contestType)
					return -1*sortFactor;
				else if(a.contestType === b.contestType)
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		case 2: //title
			$scope.items.sort(function(a, b) {
				if(a.originalData.contestPortfolioDomain.name > b.originalData.contestPortfolioDomain.name)
					return -1*sortFactor;
				else if(a.originalData.contestPortfolioDomain.name === b.originalData.contestPortfolioDomain.name)
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		case 3: //status
			$scope.items.sort(function(a, b) {
				if(a.contestStatus > b.contestStatus)
					return -1*sortFactor;
				else if(a.contestStatus === b.contestStatus)
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		case 4: //submissions
			if($scope.containUnloadBoardsInfo()) {
				
			}
			$scope.items.sort(function(a, b) {
				if(a.boards > b.boards)
					return -1*sortFactor;
				else if(a.boards === b.boards)
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		case 6: //doc
			//sorting base on the numbers of uploaded docs
			$scope.items.sort(function(a, b) {
				if(a.originalData.contestPortfolioDomain.portfolioImages.length > b.originalData.contestPortfolioDomain.portfolioImages.length)
					return -1*sortFactor;
				else if(a.originalData.contestPortfolioDomain.portfolioImages.length === b.originalData.contestPortfolioDomain.portfolioImages.length)
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		case 7:
			$scope.items.sort(function(a, b) {
				if(a.projectId > b.projectId)
					return -1*sortFactor;
				else if(a.projectId === b.projectId)
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		case 8: //action by passDue
			$scope.items.sort(function(a, b) {
				var aVal=0,bVal=0;
				if(a.passDue && !a.contestStatusMap['3'] && !a.contestStatusMap['5'] && !a.contestStatusMap['6'])
					aVal=1;
				if(b.passDue && !b.contestStatusMap['3'] && !b.contestStatusMap['5'] && !b.contestStatusMap['6'])
					bVal=1;
				if(aVal > bVal)
					return -1*sortFactor;
				else if(aVal === bVal)
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		default:
		case 5: //ends date
			$scope.items.sort(function(a, b) {
				if(a.endDate > b.endDate)
					return -1*sortFactor;
				else if(a.endDate === b.endDate)
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		}
		//
		$scope.render();
		if(order==undefined)
			$scope.sortOpt[option]=0-($scope.sortOpt[option]);
		else
			$scope.sortOpt[option]=0-order;
		if($scope.sortOpt[option] < 0)
			$scope.sortIcon[option]='glyphicon-chevron-down';
		else
			$scope.sortIcon[option]='glyphicon-chevron-up';
	},
	$scope.boardsView= function(portfolioId) {
		$location.path(ajaxPaths['approveSubmissionsPath']+'/'+portfolioId);
	},
	$scope.showImageWindow=function(path) {
		boardService.showImageWindow(path);
	},
	$scope.notifyProjectHandler=function(data) {
		var waitDialog = dialogs.wait('Please Wait',undefined,50,dialogOpt);
	},
	//event handler for submitForm service
	$scope.errorProjectHandler=function(data) {
		//make progress 100% and complete.
		$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 0});
		$rootScope.$broadcast('dialogs.wait.complete');
		var defaultMsg='Service unavailable. Please try again. Thank you.';
		if(data.errorDesc!=undefined)
			defaultMsg=data.errorDesc;
		var err=dialogs.error('Error',defaultMsg,dialogOpt);
	},
	$scope.completeProjectHandler=function(data) {
		//make progress 100% and complete.
		$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 100});
		$rootScope.$broadcast('dialogs.wait.complete');
	},
	$scope.cancelProject=function(portfolioId,contestId,viewContainerIndex) {
		var dlg = dialogs.create('/dialogs/submit_project_options.html','submitProjectDialogCtrl',{title:'Delete Project',text:'Do you want to DELETE this project?'},{size:'md',keyboard: true,backdrop: true,windowClass: 'cust-modal'});
		dlg.result.then(function(options){
			projectService.submitForm({
				cancel:true,
				returnSubmissions:options.returnSubmissions,
				sendNotification:options.sendNotification
			},{
				portfolioId: portfolioId,
				contestId: contestId
			},{
				notify: $scope.notifyProjectHandler,
				success: function(data,msg) {
					var notifyDialog = dialogs.notify('RESULT',msg,dialogOpt);
					//remove item from data container by the viewContainerIndex index.
					$scope.items.splice(($scope.currentPage*$scope.rowsPerPage)+viewContainerIndex,1);
					//re-render the list
					$scope.render();
				},
				error: $scope.errorProjectHandler,
				complete: $scope.completeProjectHandler
			});
		},function(){
			if(angular.equals($scope.name,''))
				$scope.name = 'You did not enter in your name!';
		});
	},
	$scope.pauseProject=function(portfolioId,contestId,viewContainerIndex){
		var confirmDialog = dialogs.confirm('CONFIRMATION','Do you want to PAUSE this project?',dialogOpt);
		confirmDialog.result.then(function(btn){
			projectService.submitForm({
				pause:true
			},{
				portfolioId: portfolioId,
				contestId: contestId
			},{
				notify: $scope.notifyProjectHandler,
				success: function(data,msg) {
					var notifyDialog = dialogs.notify('RESULT',msg,dialogOpt);
					//update the status
					$scope.items[($scope.currentPage*$scope.rowsPerPage)+viewContainerIndex]=data.result;
					//re-render the list
					$scope.render();
				},
				error: $scope.errorProjectHandler,
				complete: $scope.completeProjectHandler
			});
		},angular.noop);
	},
	$scope.resumeProject=function(portfolioId,contestId,viewContainerIndex){
		var dlg = dialogs.create('/dialogs/submit_project_options.html','submitProjectDialogCtrl',{title:'Delete Project',text:'Do you want to DELETE this project?'},{size:'md',keyboard: true,backdrop: true,windowClass: 'cust-modal'});
		dlg.result.then(function(options){
			projectService.submitForm({
				cancel:true,
				returnSubmissions:options.returnSubmissions,
				sendNotification:options.sendNotification
			},{
				portfolioId: portfolioId,
				contestId: contestId
			},{
				notify: $scope.notifyProjectHandler,
				success: function(data,msg) {
					var notifyDialog = dialogs.notify('RESULT',msg,dialogOpt);
					//remove item from data container by the viewContainerIndex index.
					$scope.items.splice(($scope.currentPage*$scope.rowsPerPage)+viewContainerIndex,1);
					//re-render the list
					$scope.render();
				},
				error: $scope.errorProjectHandler,
				complete: $scope.completeProjectHandler
			});
		},function(){
			if(angular.equals($scope.name,''))
				$scope.name = 'You did not enter in your name!';
		});
		
		var confirmDialog = dialogs.confirm('CONFIRMATION','Do you want to RESUME this project?',dialogOpt);
		confirmDialog.result.then(function(btn){
			projectService.submitForm({
				resume:true
			},{
				portfolioId: portfolioId,
				contestId: contestId
			},{
				notify: $scope.notifyProjectHandler,
				success: function(data,msg) {
					var notifyDialog = dialogs.notify('RESULT',msg,dialogOpt);
					//update the status
					//get absolute index
					$scope.items[($scope.currentPage*$scope.rowsPerPage)+viewContainerIndex]=data.result;
					//re-render the list
					$scope.render();
				},
				error: $scope.errorProjectHandler,
				complete: $scope.completeProjectHandler
			});
		},angular.noop);
	},
	$scope.completeProject=function(portfolioId,contestId,viewContainerIndex){
		var dlg = dialogs.create('/dialogs/submit_project_options.html','submitProjectDialogCtrl',{title:'Close Project',text:'Do you want to CLOSE this project?'},{size:'md',keyboard: true,backdrop: true,windowClass: 'cust-modal'});
		dlg.result.then(function(options){
			projectService.submitForm({
				complete:true,
				returnSubmissions:options.returnSubmissions,
				sendNotification:options.sendNotification
			},{
				portfolioId: portfolioId,
				contestId: contestId
			},{
				notify: $scope.notifyProjectHandler,
				success: function(data,msg) {
					var notifyDialog = dialogs.notify('RESULT',msg,dialogOpt);
					//update the status to the item from the data container
					$scope.items[($scope.currentPage*$scope.rowsPerPage)+viewContainerIndex]=data.result;
					//re-render the list
					$scope.render();
				},
				error: $scope.errorProjectHandler,
				complete: $scope.completeProjectHandler
			});
		},angular.noop);
	};
	//load project data
	$scope.isLoading=true;
	//get projects data
	$http({method: 'GET', url: ajaxPaths['manageProjectsDataPath']})
	.success(function(data, status, headers, config) {
		// this callback will be called asynchronously when the response is available
		$scope.isLoading=false;
		$scope.injectData(data);
    })
    .error(function(data, status, headers, config) {
    	// called asynchronously if an error occurs or server returns response with an error status.
    	$scope.isLoading=false;
    });
}]);

app.controller('approveSubmissionsController', ['$scope','$http','$rootScope','$log','$routeParams','BoardService','UserService','dialogs', function($scope, $http, $rootScope,$log,$routeParams,boardService,userService,dialogs) {
	console.log('approve submissions controller');
	$rootScope.tab={
		'approveSubmissions':true
	};
	
	//dialog options setup
	var dialogOpt={
		size: 'md'
	}
	//init
	$scope.showPanel={};
	$scope.loading={};
	$scope.boardDetail={};
	$scope.isSelected={};
	//pagin
	$scope.columnsPerRow=8;
	$scope.currentPage=0;
	$scope.totalPages=0;
	$scope.rowsPerPage=10;
	$scope.upperBound=0;
	$scope.lowerBound=0;
	
	$scope.render = function() {
		var upperBound=($scope.currentPage+1)*$scope.rowsPerPage,
			lowerBound=$scope.currentPage*$scope.rowsPerPage;
		if(upperBound>=$scope.items.length)
			upperBound=$scope.items.length;
		$scope.upperBound=upperBound;
		$scope.lowerBound=lowerBound;
		if($scope.filteredUsers==null)
			$scope.displayData=$scope.items.slice(lowerBound,upperBound);
		else
			$scope.displayData=$scope.filteredData.slice(lowerBound,upperBound);
	},
	$scope.updateRows = function() {
		$scope.totalPages=Math.floor($scope.items.length/($scope.rowsPerPage*$scope.columnsPerRow)); //update total pages
		if($scope.items.length%($scope.rowsPerPage*$scope.columnsPerRow)==0)
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
	$scope.injectData = function(data) {
		$scope.items=data.boards[$scope.portfolioId];
		$scope.hasError=data.hasError;
		$scope.updateRows();
	},
	$scope.navigate = function(index) {
		if(index!='' 
			&& index!=undefined 
			&& !isNaN(parseInt(index))
			&& index < $scope.items.length
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
	},
	$scope.showDetailInfo = function(index) {
		return $scope.showPanel[Math.floor(index/$scope.columnsPerRow)];
	},
	$scope.closeDetail = function(index) {
		//hide detail panel
		if(index!=undefined)
			$scope.showPanel[Math.floor(index/$scope.columnsPerRow)]='';
		else
			$scope.showPanel={}; //reset all
		$scope.isSelected={}; //reset
	},
	$scope.showImageWindow=function(path) {
		boardService.showImageWindow(path);
	},
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
	},
	$scope.showUserDetail = function(userId) {
		userService.showUserDetail(userId,$scope);
	},
	$scope.approveBoardHandler = function(item) {
		var confirmDialog = dialogs.confirm('CONFIRMATION','Do you want to APPROVE this submission?',dialogOpt);
		confirmDialog.result.then(function(btn){
			boardService.approveBoard(item.boardId, item.boardImages[0].mainImageUrl, {
				approve: 1,
				notify: function() {
				},
				complete: function(data) {
					if(data.hasError==false) {
						var notifyDialog = dialogs.notify('RESULT','Approved successfully',dialogOpt);
						item.publishToMP=1;
					}
					else {
						var err=dialogs.error('Error','Service unavailable. Please try again. Thank you.',dialogOpt);
					}
				}
			});
		},angular.noop);
	},
	$scope.rejectBoardHandler = function(item) {
		var dlg = dialogs.create('/dialogs/custom.html','customDialogCtrl',{},{size:'md',keyboard: true,backdrop: true,windowClass: 'cust-modal'});
		dlg.result.then(function(comments){
			boardService.approveBoard(item.boardId, item.boardImages[0].mainImageUrl, {
				approve: 0,
				comments: comments,
				notify: function() {
				},
				complete: function(data) {
					if(data.hasError==false) {
						var notifyDialog = dialogs.notify('RESULT','Rejected successfully',dialogOpt);
						item.publishToMP=0;
					}
					else {
						var err=dialogs.error('Error','Service unavailable. Please try again. Thank you.',dialogOpt);
					}
				}
			});
		},function(){
			if(angular.equals($scope.name,''))
				$scope.name = 'You did not enter in your name!';
		});
	};
	
	//set up portfolioId in scope
	$scope.portfolioId=$routeParams.portfolioId;
	//load boards data
	$scope.isLoading=true;
	$http({method: 'GET', url: ajaxPaths['viewProjectBoardsDataPath'], params: { portfolioId:$routeParams.portfolioId}})
	.success(function(data, status, headers, config) {
		$scope.isLoading=false;
		$scope.injectData(data);
    })
    .error(function(data, status, headers, config) {
    	$scope.isLoading=false;
    });
}]);

//dialog controller for reject submission
app.controller('customDialogCtrl', ['$scope','$modalInstance','data', function($scope,$modalInstance,data){
	//-- Variables --//
	$scope.comments='';
	//-- Methods --//
	$scope.cancel = function(){
		$modalInstance.dismiss('Canceled');
	}; // end cancel
	$scope.save = function(){
		$modalInstance.close($scope.comments);
	}; // end save
	$scope.hitEnter = function(evt){
		if(angular.equals(evt.keyCode,13) && !(angular.equals($scope.comments,null) || angular.equals($scope.comments,'')))
			$scope.save();
	};
}]); // end controller(customDialogCtrl)

app.controller('submitProjectDialogCtrl', ['$scope','$modalInstance','data', function($scope,$modalInstance,data){
	//inject data
	$scope.title=data.title;
	$scope.text=data.text;
	//-- Variables --//
	$scope.options={
		returnSubmissions: true,
		sendNotification: true
	};
	//-- Methods --//
	$scope.cancel = function(){
		$modalInstance.dismiss('Canceled');
	}; // end cancel
	$scope.submit = function(){
		$modalInstance.close($scope.options);
	}; // end save
	$scope.$watch('options.returnSubmissions', function(newVal, oldVal) {
		if(!newVal) //change sendNotification if returnSubmissions is false
			$scope.options.sendNotification=false;
		else
			$scope.options.sendNotification=true;
	});
}]);