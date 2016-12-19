//custom directives
app.directive("snailUploadify", ['$log', function($log) {
    return {
        require: '?ngModel',
        restrict: 'A',
        link: function ($scope, element, attrs, ngModel) {
        	var options = {
    			'filetype':'ai',
            	"mode": "BOARD", //Three options: LOGO | BOARD | FILES
            	'auto': true
        	}
            var options = angular.extend({}, options, $scope.$eval(attrs.snailUploadify));
            var fileTypeDesc,fileTypeExts,multi;
            if(options.filetype=="jpg") {
    			fileTypeDesc='JPEG Files';
    			fileTypeExts='*.jpg; *.jpeg';
    			multi=false;
    		}
    		else if(options.filetype=="files") {
    			fileTypeDesc='Doc Files';
    			fileTypeExts='*.txt; *.doc; *.docx; *.pdf';
    			multi=true;
    		}
    		else {
    			fileTypeDesc='AI, PDF or JPG Files';
    			fileTypeExts='*.ai; *.pdf; *.jpg; *.jpeg';
    			multi=false;
    		}
            $(element).uploadify({
            	'buttonClass' : 'glyphicon glyphicon-paperclip upload-file-icon',
                'auto': options.auto!=undefined?options.auto:true,
                'swf': '/js/jquery/uploadify/uploadify.swf',
    		 	'uploader': ajaxPaths['uploaderPath']+"?mode="+options.mode+"&filetype="+options.filetype,
    		 	'successTimeout':480,
                'buttonText': options.buttonText || '',
                'width': options.width || 200,
                'height': options.height || 200,
                'fileTypeDesc': fileTypeDesc,
    		 	'fileTypeExts' : fileTypeExts,
                'onUploadSuccess': function (file, data, response) {
                	$scope.$apply(function() {
                		$scope.previewImg=angular.fromJson(data).upload_filename_400x400;
            			$scope.hasRemoved=false;
                        ngModel.$setViewValue(angular.fromJson(data));
                    });
                }
            });
        }
    };
}]);