package com.aca.project.service;

import java.util.List;

import com.aca.project.dao.CarDBDao;
import com.aca.project.dao.CarMockDao;
import com.aca.project.model.Car;
import com.aca.project.model.Make;
import com.aca.project.model.Model;

public class CarService {
	
	private CarDBDao dao = new CarDBDao();
	
	public List<Car> getAllInventory() {
		return dao.getAllInventory();
	}

	public List<Car> getCarsByModelName(String modelName) {
		return dao.getCarsByModelName(modelName);
	}

	public List<Car> getCarsByMakeName(String makeName) {
		return dao.getCarsByMakeName(makeName);
	}

	public Car deleteCarById(int id) {
		Car car = dao.getCarById(id);
		dao.deleteCarById(car);
		return car;
	}
	
	public String deleteMakeName(String makeName) {
		List<Car> cars = dao.getAllInventory();
		List<Model> models = dao.getModels();
		for (Car element : cars) {
			if (element.getMake().getName().equalsIgnoreCase(makeName)) {
				CarErrorService.cannotDeleteMake();
			} 
		}
		for (Model element : models) {
			if (element.getMake().getName().equalsIgnoreCase(makeName)) {
				CarErrorService.cannotDeleteMake();
			}
		}
		dao.deleteMakeName(makeName);
		return makeName;	
	}
	
	public String deleteModelName(String modelName) {
		List<Car> cars = dao.getAllInventory();
		for (Car element : cars) {
			if (element.getModel().getName().equalsIgnoreCase(modelName)) {
				CarErrorService.cannotDeleteModel();
			}
		}
		dao.deleteModelName(modelName);
		return modelName;
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

	public Make addMake(String newMake) {
		return dao.addMake(newMake);
	}

	public Model addModel(String newModel, Make make) {
		return dao.addModel(newModel, make);
	}

	public List<Model> getModels() {
		return dao.getModels();
	}

	public List<Make> getMakes() {
		return dao.getMakes();
	}

}
