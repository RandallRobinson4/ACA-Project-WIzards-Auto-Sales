let carApp = angular.module("carApp", ["ngRoute"]);


carApp.config(function($routeProvider) {
	$routeProvider
	.when("/inventory", {
		templateUrl : "inventory.html",
		controller : "inventoryController"
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
		templateUrl : "admin.html",
		controller : "adminController"
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
	
	$scope.frontPageCarousel;
	
});

carApp.controller("inventoryController", function($scope, $http) {
	
	
	$scope.cars = 
		[
			{
		        "avgMPG": 17,
		        "color": "ORANGE",
		        "cruiseControl": false,
		        "id": 1,
		        "interiorColor": "GRAY",
		        "make": {
		            "id": 1,
		            "name": "FORD"
		        },
		        "mileage": 99999,
		        "model": {
		            "id": 1,
		            "make": {
		                "id": 1,
		                "name": "FORD"
		            },
		            "name": "MUSTANG"
		        },
		        "modelYear": 1992,
		        "navigationSystem": false,
		        "price": 17555,
		        "rearCamera": false
		    },
		    {
	        "avgMPG": 22,
	        "color": "WHITE",
	        "cruiseControl": true,
	        "id": 2,
	        "interiorColor": "BLACK",
	        "make": {
	            "id": 2,
	            "name": "KIA"
	        },
	        "mileage": 11000,
	        "model": {
	            "id": 2,
	            "make": {
	                "id": 2,
	                "name": "KIA"
	            },
	            "name": "SOUL"
	        },
	        "modelYear": 2019,
	        "navigationSystem": false,
	        "price": 24999,
	        "rearCamera": true
	    }
	]
	

	
	$scope.avgMPGs = [];
	$scope.colors = [];
	$scope.interiorColors = [];
	$scope.modelYears = [];
	
	$scope.setFilterArrays = () => {
		for(let car of $scope.cars) {
			if (!$scope.avgMPGs.includes(car.avgMPG)) {
				$scope.avgMPGs.push(car.avgMPG);
			}
			if (!$scope.colors.includes(car.colors)) {
				$scope.colors.push(car.color);
			}
			if (!$scope.interiorColors.includes(car.interiorColors)) {
				$scope.interiorColors.push(car.interiorColor);
			}
			if (!$scope.modelYears.includes(car.modelYear)) {
				$scope.modelYears.push(car.modelYear);
			}
		};
	}
						
});


