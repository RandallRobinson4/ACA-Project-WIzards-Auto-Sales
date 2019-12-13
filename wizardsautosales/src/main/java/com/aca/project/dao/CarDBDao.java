package com.aca.project.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.aca.project.model.Car;
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
				System.out.println(result.getObject("makeId"));
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
		/*Car car = new Car();
		car.setAvgMPG(result.getInt("aveMPG"));
		car.setColor(result.getString("color"));
		car.setId(result.getInt("carid"));
		car.setInterior(result.getObject("interiorId"));
		car.setMake(result.getObject("makeId"));
		car.setMileage(result.getInt("mileage"));
		car.setModel(result.getObject("modelId"));
		car.setModelYear(result.getInt("modelYear"));
		car.setPrice(result.getString("price"));		*/
		return null;
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
