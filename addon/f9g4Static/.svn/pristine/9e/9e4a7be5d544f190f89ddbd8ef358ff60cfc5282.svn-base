//Controller
app.controller('dashboard', ['$scope','$http','$rootScope','$sce','UserService','$log','dialogs', function($scope,$http,$rootScope,$sce,userService,$log,dialogs) {
	$scope.data=[];
	$scope.users=[];
	$scope.filteredUsers=null;
	$scope.loadCompleted = false;
	//sort utility
	$scope.sortOpt=[1,1,1,1,1,1,1,1,1,1];
	$scope.sortIcon={};
	for(var id in $scope.sortOpt) {
		$scope.sortIcon[id]='glyphicon-chevron-up';
	}
	//dialog options setup
	var dialogOpt={
		size: 'md'
	}
	
	$scope.projectList={};
	$scope.selectedProjectList={};
	$scope.selectedUsers={};
	$scope.usersName={};
	$scope.mailEntry={};
	$scope.isEditing={};
	
	$scope.render = function() {
		var upperBound=($scope.currentPage+1)*$scope.rowsPerPage,
			lowerBound=$scope.currentPage*$scope.rowsPerPage;
		if(upperBound>=$scope.data.users.length)
			upperBound=$scope.data.users.length;
		$scope.upperBound=upperBound;
		$scope.lowerBound=lowerBound;
		if($scope.filteredUsers==null)
			$scope.users=$scope.data.users.slice(lowerBound,upperBound);
		else
			$scope.users=$scope.filteredUsers.slice(lowerBound,upperBound);
	},
	$scope.updateRows = function() {
		$scope.totalPages=Math.floor($scope.data.users.length/$scope.rowsPerPage); //update total pages
		if($scope.data.users.length%$scope.rowsPerPage==0)
			$scope.totalPages-=1;
		$scope.render();
	},
	$scope.getRecordsByPage = function(page, concatMode, callback) {
		//Ajax
		$http({method: 'GET', url: '/f4g/admin/usersviewer/list?p='+page})
			.success(function(data, status, headers, config) {
				//setup pagin parameters
				if(concatMode) {
					$scope.data.users = $scope.data.users.concat(data.users);
					angular.extend($scope.signupdate, data.effectiveDateHM);
				}
				else {
					$scope.data=data;
					$scope.signups=data.usersCount;
					$scope.signupsDisplay=data.usersCount;
					$scope.signupdate=data.effectiveDateHM;
					$scope.expdate=data.expDateHM;
				}
				$scope.mergeData();
				$scope.updateRows();
				if(typeof(callback)=='function')
					callback();
		    })
		    .error(function(data, status, headers, config) {
		    });
	},
	$scope.mergeData = function() {
		for(var id in $scope.data.users) {
			$scope.data.users[id].effectiveDate=$scope.data.effectiveDateHM[$scope.data.users[id].userId];
			$scope.data.users[id].expDate=$scope.data.expDateHM[$scope.data.users[id].userId];
		}
	},
	$scope.workerDone = function() {
		$scope.loadCompleted = true;
	},
	$scope.workerProgress = function() {
		$scope.loadingProgress=Math.floor(($scope.data.users.length/$scope.data.usersCount)*100);
		if($scope.sortingOpt!=-1 && $scope.sortingOpt!=null && $scope.sortingOpt!=undefined) {
			$scope.sort($scope.sortingOpt.option, $scope.sortingOpt.order);
		}
		if($scope.searchingOpt!=-1 && $scope.searchingOpt!=null && $scope.searchingOpt!=undefined)
			$scope.userSearch();
	},
	$scope.worker = function() {
		if($scope.workerPage <= $scope.data.totalPages) {
			$scope.getRecordsByPage($scope.workerPage++, true, $scope.worker);
			$scope.workerProgress(); //trigger in progress event
		}
		else
			$scope.workerDone(); //trigger finish event
	},
	$scope.getRecords = function() {
		$scope.signupsDisplay='---';
		$scope.workerPage=2;
		$scope.getRecordsByPage(1, false, function() {
			$scope.worker();
		});
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
	$scope.sort = function(option, order) {
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
		switch(option) {
		case 1:
			$scope.data.users.sort(function(a, b) {
				if(a.firstname+' '+a.lastname > b.firstname+' '+b.lastname)
					return -1*sortFactor;
				else if(a.firstname+' '+a.lastname === b.firstname+' '+b.lastname)
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		case 2:
			$scope.data.users.sort(function(a, b) {
				if(a.userName > b.userName)
					return -1*sortFactor;
				else if(a.userName === b.userName)
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		case 3:
			$scope.data.users.sort(function(a, b) {
				//change the date format to support all browsers date casting.
				var dataA=new Date(a.effectiveDate.replace(/-/g,'/')),
				dataB=new Date(b.effectiveDate.replace(/-/g,'/'));
				if(dataA.getTime() > dataB.getTime())
					return -1*sortFactor;
				else if(dataA.getTime() === dataB.getTime())
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		case 4:
			$scope.data.users.sort(function(a, b) {
				if(a.adminRating > b.adminRating)
					return -1*sortFactor;
				else if(a.adminRating === b.adminRating)
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		case 5:
			$scope.data.users.sort(function(a, b) {
				if(a.registerStatus.description > b.registerStatus.description)
					return -1*sortFactor;
				else if(a.registerStatus.description === b.registerStatus.description)
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		case 6:
			$scope.data.users.sort(function(a, b) {
				if(a.profileScore > b.profileScore)
					return -1*sortFactor;
				else if(a.profileScore === b.profileScore)
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		case 7:
			$scope.data.users.sort(function(a, b) {
				var strA='',
					strB='';
				if(a.howDidYouHearAboutUs != undefined && a.howDidYouHearAboutUs != null)
					strA=a.howDidYouHearAboutUs.trim();
				if(b.howDidYouHearAboutUs != undefined && b.howDidYouHearAboutUs != null)
					strB=b.howDidYouHearAboutUs.trim();
				
				if(strA > strB)
					return -1*sortFactor;
				else if(strA === strB)
					return 0;
				else
					return 1*sortFactor;
			});
			break;
		case 8:
			break;
		case 9:
			break;
		}
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
	$scope.dateChange = function() {
		$scope.filteredUsers=new Array();
		for(var id in $scope.data.users) {
			var date=new Date($scope.data.users[id].effectiveDate);
			if(($scope.dt_start==undefined || $scope.dt_start < date) && ($scope.dt_end==undefined || $scope.dt_end > date)) {
				$scope.filteredUsers.push($scope.data.users[id]);
			}
		}
		$scope.render();
	},
	$scope.userSearch = function() {
		$scope.filteredUsers=new Array();
		if($scope.keyword.trim()!='' && $scope.keyword!=undefined) {
			var pattern=$scope.keyword.trim().toUpperCase().replace(/\s+/g,'.*');
			var regexp=new RegExp(pattern,'i');
			if($scope.loadCompleted) {
				$scope.searchingOpt=null;
			}
			else {
				$scope.searchingOpt=regexp;
			}
			for(var id in $scope.data.users) {
				var fullname=$scope.data.users[id].firstname+$scope.data.users[id].lastname;
				if(fullname.toUpperCase().replace(/\s/g,'').search(regexp) != -1 
					|| $scope.data.users[id].userName.toUpperCase().replace(/\s/g,'').search(regexp) != -1) {
					$scope.filteredUsers.push($scope.data.users[id]);
				}
			}
		}
		else
			$scope.filteredUsers=null;
		
		//reset the current page
		if($scope.currentPage!=0) {
			$scope.currentPage=0;
		}
		$scope.render();
	},
	$scope.sendMsg = function() {
		$scope.showMsgBox=!$scope.showMsgBox;
	},
	$scope.archived = function() {
		/*$http({method: 'GET', url: '/f4g/admin/paths/ajax', responseType:'text'})
		.success(function(data, status, headers, config) {
	    })
	    .error(function(data, status, headers, config) {
	    });*/
	},
	$scope.hide = function() {
		
	},
	$scope.reload = function() {
		$scope.getRecords(1); //get first page record
	},
	$scope.getExamplesCount = function() {
		$scope.examplesCount="---";
		$scope.boardsCount="---";
		$http({method: 'POST', url: ajaxPaths['dashboardPath'], responseType:'text'})
		.success(function(data, status, headers, config) {
			if(data.hasError==false) {
				$scope.examplesCount=data.examplesCount;
				$scope.boardsCount=data.boardsCount;
			}
	    })
	    .error(function(data, status, headers, config) {
	    });
	},
	$scope.navigate = function(index) {
		if(index!='' 
			&& index!=undefined 
			&& !isNaN(parseInt(index))
			&& index < $scope.data.users.length
			&& index > 0 ) {
			$scope.currentPage=Math.floor(index/$scope.rowsPerPage);
			if(index%$scope.rowsPerPage == 0)
				$scope.currentPage--;
			$scope.render();
		}
	}
	$scope.navigateHandler = function($event) {
		if($event == undefined || $event.keyCode == 13 ) {
			$scope.navigate($scope.itemIndex);
		}
	},
	//selected users event handler
	$scope.updateUserCount = function(item) {
		var count=0;
		for(var key in $scope.selectedUsers) {
			if($scope.selectedUsers[key]==true) {
				count++;
			}
		}
		if(item!=undefined) {
			$scope.usersName[item.userId]={
				name:item.firstname+' '+item.lastname,
				status:'pending',
				value:true
			};
		}
		$scope.selectedUsersCount=count;
		$scope.mergeProjectMembers($scope.selectedUsers);
	},
	$scope.countUsers=function(source) {
		var count=0;
		for(var id in source) {
			if(source[id].value)
				count++;
		}
		return count;
	},
	//Message utility
	$scope.deleteRecipient = function(key) {
		$scope.selectedUsers[key]=false;
		$scope.updateUserCount();
		//sync with projectMembers
		if($scope.projectMembers[key]!=undefined)
			$scope.projectMembers[key].value=false;
		$scope.mergeProjectMembers($scope.selectedUsers);
	},
	$scope.clearMessageHandler = function(mode) {
		$scope.selectedUsers={};
		$scope.updateUserCount();
		if(mode=='all') {
			$scope.mailEntry={};
		}
	},
	$scope.sendMessageHandler = function() {
		if($scope.mailEntry.mailSubject != undefined && $scope.mailEntry.mailSubject.trim()!=""
			&& $scope.mailEntry.mailContent != undefined && $scope.mailEntry.mailContent.trim()!=""
			&& $scope.selectedUsersCount>0) {
			//reset to pending status
			for(var key in $scope.selectedUsers) {
				if($scope.selectedUsers[key]==true) {
					$scope.usersName[key].status='pending';
				}
			}
			for(var key in $scope.selectedUsers) {
				if($scope.selectedUsers[key]==true) {
					$scope.usersName[key].status='sending'; //change the send status to sending
					//prepare the mailEntry
					var targetEntry={
						mailUserId:0,
						mailSubject:$scope.mailEntry.mailSubject,
						mailContent:$scope.mailEntry.mailContent
					};
					//bind userId to mailEntry
					targetEntry.mailUserId=key;
					$scope.sendMessage(targetEntry);
				}
			}
		}
	},
	$scope.sendMessage = function(mailEntry) {
		$http({method: 'POST', url: ajaxPaths['sendMailPath'], params: mailEntry})
		.success(function(data, status, headers, config) {
			// this callback will be called asynchronously when the response is available
			$scope.usersName[mailEntry.mailUserId].status='success';
	    })
	    .error(function(data, status, headers, config) {
	    	// called asynchronously if an error occurs or server returns response with an error status.
	    	$scope.usersName[mailEntry.mailUserId].status='pending';
	    });
	},
	$scope.showUserDetail = function(userId) {
		userService.showUserDetail(userId,$scope);
	},
	$scope.editAdminRating = function(userId) {
		$scope.isEditing[userId]=true;
	};
	//Assign project utility
	//get project list
	$scope.getProjectList=function() {
		$http({method: 'GET', url: ajaxPaths['manageProjectsDataPath'], params:{access:'basic'}})
		.success(function(data, status, headers, config) {
			$scope.projectList=data.contests;
	    })
	    .error(function(data, status, headers, config) {
	    });
	},
	$scope.getAssignedMembers=function(portfolioId,contestId) {
		$scope.isLoadingProjectMembers=true;
		$scope.projectMembers={}; //reset projectMember list to place new list
		$scope.assignUsers={}; //reset the assignUser list to remove the previous selected project members
		$scope.mergeProjectMembers($scope.selectedUsers); //assign the selectedUser back to assignUsers list
		$http({method: 'GET', url: ajaxPaths['getProjectMembersDataPath']+'/'+portfolioId+'/'+contestId})
		.success(function(data, status, headers, config) {
			$scope.isLoadingProjectMembers=false;
			if(data.hasError!=undefined && data.hasError==false) {
				$scope.hasEmptyMembers=false;
				for(var id in data.members) {
					$scope.projectMembers[data.members[id].userId]={
						value:true,
						name:data.members[id].userDomain.firstname+' '+data.members[id].userDomain.lastname,
						status:'pending'
					};
				}
				if(data.members.length<=0)
					$scope.hasEmptyMembers=true;
				//merge to the assignUsers container
				$scope.mergeProjectMembers($scope.projectMembers);
			}
			else {
				$log.log('Error');
			}
	    })
	    .error(function(data, status, headers, config) {
	    	$scope.isLoadingProjectMembers=false;
	    });
	},
	$scope.toggleMember=function(userId) {
		$scope.projectMembers[userId].value=!$scope.projectMembers[userId].value;
		$scope.mergeProjectMembers($scope.projectMembers);
		//sync with selectedUsers container
		if($scope.selectedUsers[userId]!=undefined) {
			$scope.selectedUsers[userId]=$scope.projectMembers[userId].value;
			$scope.updateUserCount();
		}
	},
	$scope.deleteMember=function(userId) {
		//delete from projectMembers
		if($scope.projectMembers[userId]!=undefined) {
			$scope.projectMembers[userId].value=false;
			//delete from projectMembers
			$scope.mergeProjectMembers($scope.projectMembers);
		}
		//delete from selectedUsers
		if($scope.selectedUsers[userId]!=null) {
			$scope.selectedUsers[userId]=false;
			$scope.mergeProjectMembers($scope.selectedUsers);
			$scope.updateUserCount();
		}
	},
	//show assign project util box
	$scope.assignProjectUtil = function() {
		$scope.showAssignProjectUtil=!$scope.showAssignProjectUtil;
		if($scope.showAssignProjectUtil) {
			if($scope.projectList.result==undefined) {
				$scope.getProjectList();
			}
		}
	},
	$scope.mergeProjectMembers=function(source) {
		$log.log('Merge members');
		for(var id in source) {
			//id: userId
			if(typeof(source[id])=='boolean') {
				//from selectedUsers container
				$scope.assignUsers[id]=$scope.usersName[id];
				$scope.assignUsers[id].value=source[id];
				//sync with projectMembers
				if($scope.projectMembers[id]!=undefined)
					$scope.projectMembers[id].value=source[id];
			}
			else {
				//from projectMembers container
				if(source[id].value==true)
					$scope.assignUsers[id]=source[id];
			}
		}
		$log.log($scope.assignUsers);
	},
	//multi-select click handler
	$scope.selectProjectItem=function(data) {
		//retrieve assigned members for the selected project item
		$scope.getAssignedMembers(data.portfolioId, data.contestId);
		$scope.portfolioId=data.portfolioId;
	},
	$scope.assignProject=function() {
		if($scope.portfolioId!=undefined) {
			var confirmDialog = dialogs.confirm('CONFIRMATION','Do you want to assign these members to the project?',dialogOpt);
			confirmDialog.result.then(function(btn) {
				var uid=new Array();
				for(var id in $scope.assignUsers) {
					if($scope.assignUsers[id].value==true)
						uid.push(id);
				};
				var membersEntry={
					uid: uid
				}
				//show progress dialog
				var waitDialog = dialogs.wait('Please Wait',undefined,50,dialogOpt);
				$http({method: 'POST', url: ajaxPaths['assignProjectMembersPath']+'/'+$scope.portfolioId, params: membersEntry})
				.success(function(data, status, headers, config) {
					//make progress 100% and complete.
					$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 100});
					$rootScope.$broadcast('dialogs.wait.complete');
					if(data.hasError!=undefined && data.hasError==false) {
						var notifyDialog = dialogs.notify('RESULT','Assigned successfully',dialogOpt);
						//move assignUsers List to projectMembers List
						$scope.projectMembers=$scope.assignUsers;
						$scope.hasEmptyMembers=false;
					}
			    })
			    .error(function(data, status, headers, config) {
			    	//make progress 100% and complete.
					$rootScope.$broadcast('dialogs.wait.progress',{'progress' : 0});
					$rootScope.$broadcast('dialogs.wait.complete');
			    });
			},angular.noop);
		}
		else {
			var err=dialogs.error('Error','Please select project to assign.',dialogOpt);
		}
		
	},
	$scope.clearProjectMembers=function(mode) {
		for(var id in $scope.selectedUsers) {
			$scope.selectedUsers[id]=false;
			if($scope.usersName[id]!=undefined)
				$scope.usersName[id].value=false;
		}
		$scope.updateUserCount();
		$scope.mergeProjectMembers($scope.selectedUsers);
	};
	//Initialization
	$scope.dt_start=null;
	$scope.dt_end=new Date();
	//pagin
	$scope.currentPage=0;
	$scope.totalPages=0;
	$scope.rowsPerPage=20;
	
	$scope.getRecords(1); //get first page record
	$scope.sortingOpt={
		option:3,
		order:1
	};
	$scope.getExamplesCount();
	//user profile modal
	$scope.modalHeight='600px';
	$scope.modalWidth='800px';
	//box util
	$scope.showAssignProjectUtil=false;
	$scope.projectMembers={};
	$scope.assignUsers={};
	$scope.getProjectList();
}]);

//controller for assignProject utility in dashboard
app.controller('assignProjController',['$scope', function($scope) {
	$scope.verticalMode=false,
	$scope.changeMode=function() {
		$scope.verticalMode=!$scope.verticalMode;
	};
}]);

app.controller('adminSearch', ['$scope', '$http', '$filter', function($scope,$http,$filter) {
	$scope.asyncCompCount=0;
	$scope.syncIncompleted=true;
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
		$scope.adminRatingSlider = {
		   	min: 0,
		   	max: 5,
		   	ceil: 5,
		   	floor: 0,
		   	step: 1	
		};
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
		$scope.adminRatingSlider.min=form.minAdminRating;
		$scope.adminRatingSlider.max=form.maxAdminRating;
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
		if(data.syncSearchResult==0) {
			$scope.portfolioPagesCount=0;
		    $scope.marketplaceSubmissionCount=0;
		    $scope.profilesCount=0;
		    $scope.examplesCount=0;
		    $scope.syncIncompleted=false;
		}
		else {
			//sync criteria
			$scope.syncCriteria(data.syncSearchResult.form);
			//sync the result count
			$scope.portfolioPagesCount=data.syncSearchResult.portfolioPages.data.length;
			$scope.marketplaceSubmissionCount=data.syncSearchResult.marketplaceSubmission.data.length;
			$scope.profilesCount=data.syncSearchResult.profiles.data.length;
			$scope.examplesCount=data.syncSearchResult.examples.data.length;
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
		$scope.criteria.minAdminRating=$scope.adminRatingSlider.min;
		$scope.criteria.maxAdminRating=$scope.adminRatingSlider.max;
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
			$scope.portfolioPagesCount=data.result.portfolioPages.data.length;
			$scope.marketplaceSubmissionCount=data.result.marketplaceSubmission.data.length;
			$scope.profilesCount=data.result.profiles.data.length;
			$scope.examplesCount=data.result.examples.data.length;
	    })
	    .error(function(data, status, headers, config) {
	    	// called asynchronously if an error occurs or server returns response with an error status.
	    	$scope.isSearching=false;
	    });
	};
}]);

app.controller('adminSearchViewer', ['$scope', '$http', '$filter', '$location', '$rootScope','UserService', function($scope,$http,$filter,$location,$rootScope,userService) {
	//initialization
	$scope.columnNumber=10;
	$scope.showPanel={};
	$scope.loading={};
	$scope.boardDetail={};
	$scope.dt_start=null;
	$scope.dt_end=new Date();
	$scope.columnsPerRow=10;
	//pagin
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
	//user profile modal
	$scope.modalHeight='600px';
	$scope.modalWidth='800px';
	
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
		//get search result
		$scope.isUpdating=true; //show data updating panel
		$scope.isEmptyResult=false;
		$http({method: 'POST', url: ajaxPaths['searchViewerPath']})
		.success(function(data, status, headers, config) {
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
	},
	$scope.showUserDetail = function(userId) {
		userService.showUserDetail(userId,$scope);
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
			console.log(data);
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
}]);

app.controller('datePickerController', ['$scope', function($scope) {
	$scope.open = function($event) {
	    $event.preventDefault();
	    $event.stopPropagation();
	    $scope.opened = true;
	};
}]);

app.controller('adminMembers', ['$scope', '$http', function($scope, $http) {
	$scope.names=['Igor Minar', 'Brad Green', 'Dave Geddes', 'Naomi Black', 'Greg Weber', 'Dean Sofer', 'Wes Alvaro', 'John Scott', 'Daniel Nadasi'];
	$scope.checked=true;
	
	$scope.test = function() {
		arguments[3]();
	};
	
	$scope.test($scope,$http,'test',function($scope,$test) {
	});
}]);
    