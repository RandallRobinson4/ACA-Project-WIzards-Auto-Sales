package com.aca.project.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.aca.project.model.Car;
import com.aca.project.model.Make;
import com.aca.project.model.Model;


public class CarMockDao {
	
	private static List<Car> cars = new ArrayList<>();
	private static int counter = 1;
	private static int modelIdCounter = 1;
	private static int makeIdCounter = 1;
	
	static {
		Make kia = new Make("Kia", makeIdCounter++);
		Make gmc = new Make("GMC", makeIdCounter++);
		Make ford = new Make("Ford", makeIdCounter++);
		Make toyota = new Make("Toyota", makeIdCounter++);
		cars.add(new Car(kia, "Gray", true, true, false, "White", 16000, new BigDecimal(24595), counter++, 22, new Model("Soul", kia, modelIdCounter++), 2019));
		cars.add(new Car(gmc, "Tan", true, false, false, "White", 82000, new BigDecimal(11492), counter++, 14, new Model("Sierra", gmc, modelIdCounter++), 2008));
		cars.add(new Car(ford, "Black", false, false, false, "Green", 112000, new BigDecimal(14393), counter++, 17, new Model("Mustang", ford, modelIdCounter++), 1992));
		cars.add(new Car(toyota, "Gray", true, true, true, "Black", 900, new BigDecimal(32191), counter++, 33, new Model("Prius", toyota, modelIdCounter++), 2018));
	}
	
	public List<Car> getAllInventory() {
		return cars;
	}

	public List<Car> getByModelName(String modelName) {
		List<Car> carsByModel = new ArrayList<>();
		for (Car car : CarMockDao.cars) {
			if (car.getModel().getName().equalsIgnoreCase(modelName)) {
				carsByModel.add(car);
			}
		}
		return carsByModel;
	}

	public void deleteCarById(Car car) {
		cars.remove(car);
	}
	public Car addCar(Car newCar) {
		newCar.setId(counter++);
		newCar.getModel().setId(modelIdCounter++);
		newCar.getMake().setId(makeIdCounter++);
		cars.add(newCar);
		return newCar;
	}

	public Car updateCar(Car updatedCar) {
		Car car = null;
		for(Car element : cars) {
			if (element.getId() == updatedCar.getId()) {
				car = element;
			}
		}
		cars.remove(car);
		cars.add(updatedCar);
		return updatedCar;
	}

	public Car getCarById(int id) {
		Car car = null;
		 for (Car element : cars) {
			 if (element.getId() == id) {
				 car = element;
			 }
		 }
		return car;
	}

	public List<Car> getByMakeName(String makeName) {
		List<Car> carsByMake = new ArrayList<>();
		for (Car car : CarMockDao.cars) {
			if (car.getMake().getName().equalsIgnoreCase(makeName)) {
				carsByMake.add(car);
			}
		}
		return carsByMake;
	}
}
