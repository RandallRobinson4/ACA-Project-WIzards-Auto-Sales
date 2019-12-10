package com.aca.project.service;

import java.util.List;

import com.aca.project.dao.CarMockDao;
import com.aca.project.model.Car;

public class CarService {
	
	private CarMockDao dao = new CarMockDao();
	
	public List<Car> getAllInventory() {
		return dao.getAllInventory();
	}

	public List<Car> getByModelName(String modelName) {
		return dao.getByModelName(modelName);
	}

	public Car deleteCarById(int id) {
		return dao.deleteCarById(id);
	}

	public Car addCar(Car newCar) {
		return dao.addCar(newCar);
	}

	public Car updateCar(Car updatedCar) {
		return dao.updateCar(updatedCar);
	}

}
