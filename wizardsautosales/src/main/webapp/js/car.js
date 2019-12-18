let carApp = angular.module("carApp", ["ngRoute"]);


carApp.config(function($routeProvider) {
	$routeProvider
	.when("/inventory", {
		templateUrl : "inventory.html"
	})
	.when("/tour", {
		templateUrl : "tour.html"
	})
	.when("/stack", {
		templateUrl : "stack.html"
	})
	.when("/resume", {
		templateUrl : "resume.html"
	})
	.when("/admin", {
		templateUrl : "admin.html"
	})
	.when("/hobbies", {
		templateUrl : "hobbies.html"
	})
	.when("/apprenticeClub", {
		templateUrl : "apprenticeClub.html",
		controller : "apprenticeClubController"
	})
	.otherwise({
		templateUrl : "welcome.html"
	});
});

carApp.controller("carController", function($scope, $http) {
	
});