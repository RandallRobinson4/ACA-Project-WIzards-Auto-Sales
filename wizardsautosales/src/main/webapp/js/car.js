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
	
	$scope.showCars = [...$scope.cars];
	
	$scope.avgMPGs = [];
	$scope.colors = [];
	$scope.interiorColors = [];
	$scope.modelYears = [];
	$scope.filters = [];
	
	$scope.setFilterArrays = () => {
		for (let car of $scope.cars) {
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
	
	$scope.filterByAvgMPG = (avgMPG) => {
		$scope.filters.push("Average MPG: " + avgMPG);
		for (let car of $scope.showCars) {
			if(car.avgMPG == avgMPG) {
				if (!$scope.showCars.includes(car)) {
				$scope.showCars.push(car);
				}
			} else {
				$scope.removeCar(car);
			}
		}
	}
	
	$scope.filterByModelYear = (modelYear) => {
		$scope.filters.push("Model Year: " + modelYear);
		for (let car of $scope.showCars) {
			if(car.modelYear == modelYear) {
				if(!$scope.showCars.includes(car)) {
					$scope.showCars.push(car);
				}
			} else {
				$scope.removeCar(car);
			}
				
		}
	}
	
	$scope.filterByColor = (color) => {
		$scope.filters.push("Color : " + color);
		for (let car of $scope.showCars) {
			if (car.color == color) {
				if (!$scope.showCars.includes(car)) {
					$scope.showCars.push(car);
				}
			} else {
				$scope.removeCar(car);
			}
		}
	}
	
	$scope.filterByIcolor = (icolor) => {
		$scope.isFiltered();
		$scope.filters.push("Interior Color: " + icolor);
		for (let car of $scope.showCars) {
			if (car.interiorColor == icolor) {
				if(!$scope.showcars.includes(car)) {
					$scope.showCars.push(car);
				}
			} else {
				$scope.removeCar(car);
			}
		}
	}
	
	$scope.filterByPriceRange = (priceRange, priceRange2) => {
		$scope.filters.push("Price: " + priceRange);
		for (let car of $scope.showCars) {
			let price = car.price.parseInt();
			if (price <= priceRange && price >= priceRange2) {
				if (!$scope.showCars.includes(car)) {
				$scope.showCars.push(car);
				}
			} else {
				$scope.removeCar(car);
			}
		}
	}
	
	$scope.removeCar = (car) => {
		let index = $scope.showCars.indexOf(car);
		$scope.showCars.splice(index, 1);
	}
	$scope.clearFilters
});


