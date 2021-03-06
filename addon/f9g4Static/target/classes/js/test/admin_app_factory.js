//Factory
app.factory("BoardService", ['$http', function($http) {
	return {
		showImageWindow: function(imgPath) {
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
		    });
		},
		getContestBoards: function(item) {
			if(item.boards==undefined) {
				item['boards']=undefined; //loading
				var param = {
					'portfolioId':item.originalData.contestPortfolioDomain.portfolioId
				}
				$http({method: 'GET', url: ajaxPaths['viewProjectBoardsDataPath'], params: param})
				.success(function(data, status, headers, config) {
					if(data.hasError!=undefined && !data.hasError) {
						for(var id in data.boards) {
							item.boards=data.boards[id];
						}
					}
				})
				.error(function(data, status, headers, config) {
				});
			}
		},
		getContestBoardsByRange: function(items, start, end) {
			//collect a list of portfolioId
			var portfolioIds=new Array();
			for(var i=start;i<end;i++) {
				//load boards count if the count did not sync.
				if(items[i].boards==undefined) {
					portfolioIds.push(items[i].originalData.contestPortfolioDomain.portfolioId);
					items[i]['boards']=undefined;
				}
			}
			if(portfolioIds.length>0) {
				var param= {
					'portfolioId':portfolioIds
				}
				$http({method: 'GET', url: ajaxPaths['viewProjectBoardsDataPath'], params: param})
				.success(function(data, status, headers, config) {
					if(data.hasError!=undefined && !data.hasError) {
						for(var i=start;i<end;i++) {
							//only update count if the portfolioId exists in the response boards object
							if(data.boards[items[i].originalData.contestPortfolioDomain.portfolioId]!=undefined) {
								items[i].boards=data.boards[items[i].originalData.contestPortfolioDomain.portfolioId];
							}
						}
					}
				})
				.error(function(data, status, headers, config) {
				});
			}
		},
		getBoardDetail: function(boardId, callback) {
			$http({method: 'GET', url: ajaxPaths['boardDetailPath']+'/'+boardId})
			.success(function(data, status, headers, config) {
				callback(data,{
					'success':true
				});
			})
			.error(function(data, status, headers, config) {
				callback(undefined,{
					'success':false
				});
			});
		},
		//for admin
		approveBoard: function(boardId, imageUrl, custOpts) {
			var opts= {
				approve: 0, //0=reject, 1=approve
				comments: '',
				notify: angular.noop,
				complete: angular.noop
			};
			opts=angular.extend({},opts,custOpts);
			opts.notify();
			//params
			var paramEntry={
				'board_id': boardId,
				'comments': opts.comments,
				'main_image_url': imageUrl,
				'approval_status': opts.approve
			};
			$http({method: 'POST', url: ajaxPaths['sumbitBoardApprovalPath'], params: paramEntry})
			.success(function(data, status, headers, config) {
				opts.complete(data);
			})
			.error(function(data, status, headers, config) {
				opts.complete(data);
			});
		}
	};
}])
.factory("FormValidator",function() {
	return {
		projectBoardFormValidator: function(form) {
			var result= {
				status:0,
				error:[]
			}
			if(form==undefined || form.hasAgreedTerms==undefined || !form.hasAgreedTerms) {
				result.status=1; //error
				result.error.push('Please agree the board terms and conditions.');
			}
			if(form==undefined || form.boardImageUrl_file==undefined) {
				result.status=1; //error
				result.error.push('Please upload the board image.');
			}
			return result;
		},
		projectFormaValidator: function(form) {
			var result= {
				status:0,
				error:[]
			}
			if(form.title==undefined || form.title.trim()=='' || form.title.length<=0) {
				result.status=1;
				result.error.push('Please enter title');
			}
			if(form.contestType==undefined || form.contestType=='') {
				result.status=1;
				result.error.push('Please select project type');
			}
			if(form.dueDate==undefined) {
				result.status=1;
				result.error.push('Please choose due date');
			}
			if(form.winners==undefined || form.winners=='') {
				result.status=1;
				result.error.push('Please select winners');
			}
			if(form.client==undefined || form.client.length<=0) {
				result.status=1;
				result.error.push('Please select client');
			}
			if(form.division==undefined) {
				result.status=1;
				result.error.push('Please select division');
			}
			if(form.category==undefined) {
				result.status=1;
				result.error.push('Please select category');
			}
			if(form.product==undefined) {
				result.status=1;
				result.error.push('Please select product');
			}
			if(form.productType==undefined || form.productType.length<=0) {
				result.status=1;
				result.error.push('Please select at least one product type');
			}
			if(form.season==undefined || form.season=='') {
				result.status=1;
				result.error.push('Please select season');
			}
			if(form.dimensions==undefined) {
				result.status=1;
				result.error.push('Please select board dimension');
			}
			if(form.format==undefined) {
				result.status=1;
				result.error.push('Please select board format');
			}
			return result;
		}
	}
})
.factory("UserService", ['$http','$sce', function($http,$sce) {
	return {
		showUserDetail: function(userId,$scope) {
			$scope.dialogShown=true;
			$scope.dialogContent="";
			$scope.isDialogLoading=true;
			$http({method: 'GET', url: ajaxPaths['usersViewerDetailPath']+'&userId='+userId})
			.success(function(data, status, headers, config) {
				$scope.dialogContent=$sce.trustAsHtml(data);
				$scope.isDialogLoading=false;
		    })
		    .error(function(data, status, headers, config) {
		    });
		}
	};
}])
.factory('ProjectService',['$http', function($http) {
	return {
		submitForm: function(mode, form, custOpts) {
			var path=ajaxPaths['saveProjectPath'];
			var notifyDialogMsg='Project saved successfully';
			var opts={
				//events
				notify: angular.noop,
				success: angular.noop,
				error: angular.noop,
				complete: angular.noop
			};
			var defaultMode={
				//options
				returnSubmissions:false,
				sendNotification:false
			};
			opts=angular.extend({},opts,custOpts);
			mode=angular.extend({},defaultMode,mode);
			if(mode.publish) {
				path=ajaxPaths['publishProjectPath'];
				notifyDialogMsg='Project published successfully';
			}
			else if(mode.cancel){
				path=ajaxPaths['cancelProjectPath'];
				notifyDialogMsg='Project deleted successfully';
			}
			else if(mode.resume){
				path=ajaxPaths['resumeProjectPath'];
				notifyDialogMsg='Project resumed successfully';
			}
			else if(mode.pause){
				path=ajaxPaths['pauseProjectPath'];
				notifyDialogMsg='Project paused successfully';
			}
			else if(mode.complete){
				path=ajaxPaths['completeProjectPath'];
				notifyDialogMsg='Project closed successfully';
			}
			//attach options to the form
			form['returnSubmissions']=mode.returnSubmissions;
			form['sendNotification']=mode.sendNotification;
			//call notify
			opts.notify();
			try {
				if(form != undefined) {
					$http({method: 'POST', url: path, params: form})
					.success(function(data, status, headers, config) {
						if(data!=undefined && data.hasError==false) {
							opts.success(data,notifyDialogMsg);
						}
						else {
							opts.error(data);
						}
						//call complete
						opts.complete(data);
				    })
				    .error(function(data, status, headers, config) {
				    	opts.error();
				    	opts.complete();
				    });
				}
			}
			catch(e) {
				opts.error();
			}
		}
	};
}])