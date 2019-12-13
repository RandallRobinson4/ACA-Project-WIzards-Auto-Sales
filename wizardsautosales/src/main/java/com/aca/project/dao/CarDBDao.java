package com.aca.project.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.aca.project.model.Car;
import com.aca.project.model.Interior;
import com.aca.project.model.Make;
import com.aca.project.model.Model;



public class CarDBDao {
	
	List<Car> cars = new ArrayList<>();

	public List<Car> getAllInventory() {
		
		Connection con = MariaDBUtil.getConnection();
		Statement statement = null;
		ResultSet result = null;
		
		try {
			statement = con.createStatement();
		    result = statement.executeQuery(CarSQL.GETCARSSQL.statement());
			
			while (result.next()) {
				Car car = makeCar(result);
				cars.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if (con != null) {
				result.close();
				statement.close();
				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cars;
	}
	
	private Car makeCar(ResultSet result) throws SQLException {
		Car car = new Car();
		Make make = new Make(result.getString("make.name"), result.getInt("makeId"));
		car.setAvgMPG(result.getInt("avgMPG"));
		car.setColor(result.getString("color"));
		car.setId(result.getInt("carId"));
		car.setInterior(new Interior(result.getString("interiorColor"), result.getBoolean("cruiseControl"), result.getBoolean("rearCamera"), result.getBoolean("navigationSystem")));
		car.setMake(make);
		car.setMileage(result.getInt("mileage"));
		car.setModel(new Model(result.getString("model.name"), make, result.getInt("modelId")));
		car.setModelYear(result.getInt("modelYear"));
		car.setPrice(new BigDecimal(result.getString("price")));	
		return car;
	} 
	
	private Make makeMake(ResultSet result) throws SQLException {
		return null;
		
	}
	
	private Model makeModel(ResultSet result) throws SQLException {
		return null;
		
	}

	public List<Car> getByModelName(String modelName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Car getCarById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteCarById(Car car) {
		// TODO Auto-generated method stub
		
	}

	public Car addCar(Car newCar) {
		// TODO Auto-generated method stub
		return null;
	}

	public Car updateCar(Car updatedCar) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Car> getByMakeName(String makeName) {
		// TODO Auto-generated method stub
		return null;
	}


}
