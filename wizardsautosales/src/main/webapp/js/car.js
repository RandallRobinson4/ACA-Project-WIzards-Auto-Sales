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
	.when("/wizardscouncil", {
		templateUrl : "wizardsCouncil.html",
		controller : "wizardsCouncilController"
	})
	.when("/portal", {
		templateUrl : "portal.html",
		controller : "adminController"
	})
	.when("/portal/new", {
		templateUrl : "new.html",
		controller : "adminController"
	})
	.when("/portal/update", {
		templateUrl : "update.html",
		controller : "adminController"
	})
	.when("/portal/delete", {
		templateUrl : "delete.html",
		controller : "adminController"
	})
	.otherwise({
		templateUrl : "welcome.html"
	});
});

carApp.controller("carController", function($scope, $http) {
	
	$scope.frontPageCarousel;
	
});

carApp.controller("wizardsCouncilController", function($scope, $http) {
	
	$scope.emailSuccess = false;
	$scope.emailFailure = false;
	
	$scope.subscribeEmail = () => {
		console.log($scope.emailAddress)
		$http.get("/wizardsautosales/inventory/v1/email/" + $scope.emailAddress).
		then(function(response) {
			$scope.emailSuccess = true;
			$scope.emailAddress = "";
		}, function(response) {
			$scope.emailFailure = true;
			$scope.emailAddress = "";
		})
	}
	
});

carApp.controller("inventoryController", function($scope, $http) {
	
	$scope.showCars = [];
	$scope.avgMPGs = [];
	$scope.colors = [];
	$scope.interiorColors = [];
	$scope.modelYears = [];
	$scope.filters = [];
	
	$scope.getCars = () => {
		$http.get("/wizardsautosales/inventory/v1").
		then(function(response) {
			$scope.showCars = response.data;
			$scope.setFilterArrays();
		}, function(response) {
			console.log("error http get movies" + response.status);
		});
		
	}
	
	$scope.setFilterArrays = () => {
		$scope.avgMPGs.length = 0;
		$scope.colors.length = 0;
		$scope.interiorColors.length = 0;
		$scope.modelYears.length = 0;
		
		for (let car of $scope.showCars) {
			if (!$scope.avgMPGs.includes(car.avgMPG)) {
				$scope.avgMPGs.push(car.avgMPG);
			}
			if (!$scope.colors.includes(car.color)) {
				$scope.colors.push(car.color);
			}
			if (!$scope.interiorColors.includes(car.interiorColor)) {
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
		$scope.setFilterArrays();
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
		$scope.setFilterArrays();
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
		$scope.setFilterArrays();
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
		$scope.setFilterArrays();
	}
	
	$scope.filterByPriceRange = (priceRange, priceRange2) => {
		let priceFilterName = null;
		switch (priceRange) {
		case 0:
			priceFilterName = "Under $20,000";
				break;
		case 20000:
			priceFilterName = "$20,000 - $24,999";
			break;
		case 25000:
			priceFilterName = "$25,000 - $29,999";
			break;
		case 30000:
			priceFilterName = "Over $30,000";
			break;
		default:
			priceFilterName = "Selected Price";
		}
		
		$scope.filters.push("Price: " + priceFilterName);
		for (let car of $scope.showCars) {
			let price = parseInt(car.price);
			if (price >= priceRange && price <= priceRange2) {
				if (!$scope.showCars.includes(car)) {
				$scope.showCars.push(car);
				}
			} else {
				$scope.removeCar(car);
			}
		}
		$scope.setFilterArrays();
	}
	
	$scope.removeCar = (car) => {
		let index = $scope.showCars.indexOf(car);
		$scope.showCars.splice(index, 1);
	}
	
	$scope.clearFilters = () => {
		$scope.getCars();
		$scope.filters.length = 0;
	}
});

carApp.controller("adminController", function ($scope, $http) {
	

	$scope.makes = [];
	$scope.allModels = [];
	$scope.modelsByMake = [];
	$scope.makeSelected = false;
	$scope.modelSelected = false;
	$scope.carAdded = false;
	$scope.addedCar = {};
	$scope.newCar = {};
	
	$scope.newCarInfo = () => {
		$scope.getMakes();
		$scope.getModels();
	}
	
	$scope.getMakes = () => {
		$http.get("/wizardsautosales/inventory/v1/makes").
		then(function(response) {
			$scope.makes = response.data;
		}, function(response) {
			console.log("error http get makes" + response.status);
		});
	}
	
	$scope.getModels = () => {
		$http.get("/wizardsautosales/inventory/v1/models").
		then(function(response) {
			$scope.allModels = response.data;
		}, function(response) {
			console.log("error http get models" + response.status);
		});
	}
	
	$scope.getModelsByMake = (make) => {
		for(let model of $scope.allModels) {
			if(make.name == model.make.name) {
				$scope.modelsByMake.push(model);
			}
		}
		console.log($scope.modelsByMake)
		$scope.makeSelected = true;
		console.log($scope.newCar)
	}
	
	$scope.isModelSelected = () => {
		$scope.modelSelected = true;
	}
	
	$scope.addNewMake = () => {
		$scope.jsonObject = angular.toJson($scope.newMake, false);
		console.log('new make: ' + $scope.jsonObject);		
		
		$http.post("/wizardsautosales/inventory/v1/make", $scope.jsonObject)
		.then(
				function success(response) {					
					console.log('status: ' + response.status);
					$scope.createStatus = 'successful insert of new make';
					$scope.successfulInsert = true;
				},
				function error(response) {
					console.log('error, return status: ' + response.status);
					$scope.createStatus = 'insert error, ' + response.data.message;
				}
		);	
		location.reload(true);
	}
	
	$scope.addNewModel = (make) => {
		$scope.newModel.make = make;
		$scope.jsonObject = angular.toJson($scope.newModel, false);
		
		$http.post("/wizardsautosales/inventory/v1/model", $scope.jsonObject)
		.then(			
			function success(response) {					
			console.log('status: ' + response.status);
			$scope.createStatus = 'successful insert of new model';
			$scope.successfulInsert = true;
		},
		function error(response) {
			console.log('error, return status: ' + response.status);
			$scope.createStatus = 'insert error, ' + response.data.message;
		}
	);
		location.reload(true);
	}
	
	$scope.postCar = () => {
		$scope.jsonObject = angular.toJson($scope.newCar, false);
		
		$http.post("/wizardsautosales/inventory/v1/", $scope.jsonObject)
		.then(			
			function success(response) {					
			console.log('status: ' + response.status);
			$scope.createStatus = 'successful insert of new car';
			$scope.carAdded = true;
			$scope.modelSelected = false;
			$scope.makeSelected = false;
			$scope.addedCar = $scope.newCar;
		},
		function error(response) {
			console.log('error, return status: ' + response.status);
			$scope.createStatus = 'insert error, ' + response.data.message;
			$scope.carAdded = false;
		});
	};
	
	$scope.updatedCarSelected = false;
	$scope.carUpdated = false;
	
	$scope.selectUpdatedCar = () => {
		console.log($scope.updatedCarId);
		
		$http.get("/wizardsautosales/inventory/v1/id/" + $scope.updatedCarId)
		.then(
			function success(response) {
				$scope.updatedCar = response.data;
				if ($scope.updatedCar.id != 0) {
				$scope.updatedCarSelected = true;
					$scope.incorrectUpdateId = false;
				} else {
					$scope.incorrectUpdateId = true;
				}
			},
			function error(response) {
				console.log("error, return status: " + response.status)
			}
		);
	};
	
	$scope.updateCar = () => {
		console.log($scope.updatedCar)
		$scope.body = angular.toJson($scope.updatedCar, false);
		
		$http.put("/wizardsautosales/inventory/v1", $scope.body)
		.then(
			function success(response) {
				$scope.carUpdated = true;
				$scope.updatedCarSelected = false;
			}, 
			function failure(response) {
				$scope.updateStatus = "Update Error, " + response.data.message;
			});
	};
	
	$scope.deletedCarSelected = false;
	$scope.carDeleted = false;
	$scope.incorrectDeletionId = false;
	
	$scope.selectDeletedCar = () => {
		$http.get("/wizardsautosales/inventory/v1/id/" + $scope.deletedCarId)
		.then(
			function success(response) {
			$scope.deletedCar = response.data;
			console.log($scope.deletedCar.id)
			if ($scope.deletedCar.id != 0) {
				$scope.deletedCarSelected = true;
				$scope.incorrectDeletionId = false;
			} else {
				$scope.incorrectDeletionId = true;
			}
		},
		function error(response) {
			console.log("error, return status: " + response.status)
		});
	};
	
	$scope.deleteCar = () => {
		$http.delete("/wizardsautosales/inventory/v1/id/" + $scope.deletedCar.id)
		.then(
			function success(response) {
				$scope.carDeleted = true;
				$scope.deletedCarSelected = false;
			},
			function error(response) {
				console.log("error, return status: " + response.status)
			});
	};
	
	
});
