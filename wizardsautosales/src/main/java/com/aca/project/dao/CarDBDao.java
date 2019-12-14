package com.aca.project.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aca.project.model.Car;
import com.aca.project.model.Interior;
import com.aca.project.model.Make;
import com.aca.project.model.Model;




public class CarDBDao {
	
	

	public List<Car> getAllInventory() {
		List<Car> cars = new ArrayList<>();
		
		Connection con = MariaDBUtil.getConnection();
		Statement statement = null;
		ResultSet result = null;
		
		try {
			statement = con.createStatement();
		    result = statement.executeQuery(CarSQL.GETCARSSQL.statement() + ";");
			
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
		Make make = makeMake(result);
		Model model = makeModel(result);
		car.setAvgMPG(result.getInt("avgMPG"));
		car.setColor(result.getString("color"));
		car.setId(result.getInt("carId"));
		car.setInterior(new Interior(result.getString("interiorColor"), result.getBoolean("cruiseControl"), result.getBoolean("rearCamera"), result.getBoolean("navigationSystem")));
		car.setMake(make);
		car.setMileage(result.getInt("mileage"));
		car.setModel(model);
		car.setModelYear(result.getInt("modelYear"));
		car.setPrice(new BigDecimal(result.getString("price")));	
		return car;
	} 
	
	private Make makeMake(ResultSet result) throws SQLException {
		Make make = new Make();
		make.setName(result.getString("make.name"));
		make.setId(result.getInt("makeId"));
		return make;
		
	}
	
	private Model makeModel(ResultSet result) throws SQLException {
		Model model = new Model();
		model.setId(result.getInt("modelId"));
		model.setName(result.getString("model.name"));
		model.setMake(makeMake(result));
		return model;
		
	}

	public List<Car> getByModelName(String modelName) {
		List<Car> cars = new ArrayList<>();
		
		Connection con = MariaDBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			preparedStatement = con.prepareStatement(CarSQL.GETCARSSQL.statement() + CarSQL.GETBYMODELNAMESQL.statement() + ";");
		    preparedStatement.setString(1, modelName);
		    result = preparedStatement.executeQuery();
			
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
				preparedStatement.close();
				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cars;
	}
	
	public List<Car> getByMakeName(String makeName) {
		List<Car> cars = new ArrayList<>();
		
		Connection con = MariaDBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			preparedStatement = con.prepareStatement(CarSQL.GETCARSSQL.statement() + CarSQL.GETBYMAKENAMESQL.statement() + ";");
		    preparedStatement.setString(1, makeName);
		    result = preparedStatement.executeQuery();
			
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
				preparedStatement.close();
				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cars;
	}

	public Car getCarById(int id) {
		Car car = new Car();
		
		Connection con = MariaDBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			preparedStatement = con.prepareStatement(CarSQL.GETCARSSQL.statement() + CarSQL.GETBYCARIDSQL.statement() + ";");
		    preparedStatement.setInt(1, id);
		    result = preparedStatement.executeQuery();
			
			while (result.next()) {
				 car = makeCar(result);		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if (con != null) {
				result.close();
				preparedStatement.close();
				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return car;
	}

	public void deleteCarById(int id) {
		// TODO Auto-generated method stub
		
	}
	
	public void deleteByMakeName(String makeName) {
		
	}
	
	public void deleteByModelName(String modelName) {
		
	}

	public Car addCar(Car newCar) {
		Car car = newCar;
		Connection con = MariaDBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = con.prepareStatement(CarSQL.ADDNEWCARSQL.statement(), Statement.RETURN_GENERATED_KEYS);
		    preparedStatement.setInt(1, newCar.getAvgMPG());
		    preparedStatement.setString(2, newCar.getColor());
		    preparedStatement.setInt(3, newCar.getMileage());
		    preparedStatement.setInt(4, newCar.getModelYear());
		    preparedStatement.setString(5, newCar.getPrice().toPlainString());
		    preparedStatement.setInt(6, newCar.getInterior().getId());
		    preparedStatement.setInt(7, newCar.getMake().getId());
		    preparedStatement.setInt(8, newCar.getModel().getId());
		    preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					car.setId(generatedKeys.getInt(1));
				} 
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
			if (con != null) {
				preparedStatement.close();
				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return car;
	}

	public Car updateCar(Car updatedCar) {
		// TODO Auto-generated method stub
		return null;
	}
}
