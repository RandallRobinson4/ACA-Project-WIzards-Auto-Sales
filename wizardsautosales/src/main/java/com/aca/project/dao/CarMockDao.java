package com.aca.project.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.aca.project.model.Car;
import com.aca.project.model.Interior;
import com.aca.project.model.Make;
import com.aca.project.model.Model;


public class CarMockDao {
	
	private static List<Car> cars = new ArrayList<>();
	private static int counter = 1;
	private static int modelIdCounter = 1;
	private static int makeIdCounter = 1;
	
	static {
		cars.add(new Car(new Make("Kia", makeIdCounter++), new Interior("Gray", true, true, false), "White", 16000, new BigDecimal(24595), counter++, 22, new Model("Soul", modelIdCounter++), 2019));
		cars.add(new Car(new Make("GMC", makeIdCounter++), new Interior("Tan", true, false, false), "White", 82000, new BigDecimal(11492), counter++, 14, new Model("Sierra", modelIdCounter++), 2008));
		cars.add(new Car(new Make("Ford", makeIdCounter++), new Interior("Black", false, false, false), "Green", 112000, new BigDecimal(14393), counter++, 17, new Model("Mustang", modelIdCounter++), 1992));
		cars.add(new Car(new Make("Toyota", makeIdCounter++), new Interior("Gray", true, true, true), "Black", 900, new BigDecimal(32191), counter++, 33, new Model("Prius", modelIdCounter++), 2018));
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

	public Car deleteCarById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Car addCar(Car newCar) {
		// TODO Auto-generated method stub
		return null;
	}

	public Car updateCar(Car updatedCar) {
		// TODO Auto-generated method stub
		return null;
	}
}
