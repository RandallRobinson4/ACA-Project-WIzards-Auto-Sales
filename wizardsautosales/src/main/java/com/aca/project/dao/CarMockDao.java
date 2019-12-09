package com.aca.project.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.aca.project.model.Car;
import com.aca.project.model.Interior;
import com.aca.project.model.Model;


public class CarMockDao {
	
	private static List<Car> cars = new ArrayList<>();
	private static int counter = 1;
	
	static {
		cars.add(new Car(new Model("Kia", "Soul", 2019), new Interior("Gray", true, true, false), "White", 16000, new BigDecimal(24595), counter++, 22));
		cars.add(new Car(new Model("GMC", "Sierra", 2008), new Interior("Tan", true, false, false), "White", 82000, new BigDecimal(11492), counter++, 14));
		cars.add(new Car(new Model("Ford", "Mustang", 1992), new Interior("Black", false, false, false), "Green", 112000, new BigDecimal(14393), counter++, 17));
		cars.add(new Car(new Model("Toyota", "Prius", 2018), new Interior("Gray", true, true, true), "Black", 900, new BigDecimal(32191), counter++, 33));
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
	
	public String test() {
		return "testing";
	}
}
