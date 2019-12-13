package com.aca.project.service;

import java.util.List;

import com.aca.project.dao.CarDBDao;
import com.aca.project.dao.CarMockDao;
import com.aca.project.model.Car;

public class CarService {
	
	private CarDBDao dao = new CarDBDao();
	
	public List<Car> getAllInventory() {
		return dao.getAllInventory();
	}

	public List<Car> getByModelName(String modelName) {
		return dao.getByModelName(modelName);
	}

	public Car deleteCarById(int id) {
		Car car = dao.getCarById(id);
		dao.deleteCarById(car);
		return car;
	}

	public Car addCar(Car newCar) {
		return dao.addCar(newCar);
	}

	public Car updateCar(Car updatedCar) {
		return dao.updateCar(updatedCar);
	}

	public Car getCarById(int id) {
		return dao.getCarById(id);
	}

	public List<Car> getByMakeName(String makeName) {
		return dao.getByMakeName(makeName);
	}

}
