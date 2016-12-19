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
		    	// called asynchronously if an error occurs or server returns response with an error status.
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
					item['boards']=data.boards;
				})
				.error(function(data, status, headers, config) {
				});
			}
		},
		getBoardDetail: function(boardId, callback) {
			$http({method: 'GET', url: ajaxPaths['boardDetailPath']+'/'+boardId})
			.success(function(data, status, headers, config) {
				// this callback will be called asynchronously when the response is available
				callback(data,{
					'success':true
				});
			})
			.error(function(data, status, headers, config) {
			  	// called asynchronously if an error occurs or server returns response with an error status.
				callback(undefined,{
					'success':false
				});
			});
		}
	};
}])
.factory("FormValidator",[function() {
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
		}
	}
}]);