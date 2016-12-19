//Initialize the app and load the module
var app = angular.module('consoleApp', ['ngAnimate','adminFilters','rzModule','multi-select','ui.bootstrap','ngModal','ngRoute','dialogs.main'])
	.config(['$locationProvider', function($locationProvider) {
		//default config place here
		// use the HTML5 History API
		$locationProvider.html5Mode(true);
	}]);

app.controller('appController',['$scope','$rootScope','$log', function($scope,$rootScope,$log) {
	$rootScope.shoppingCart={};
}]);