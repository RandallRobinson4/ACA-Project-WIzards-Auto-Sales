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
		car.setInteriorColor(result.getString("interiorColor"));
		car.setAvgMPG(result.getInt("avgMPG"));
		car.setColor(result.getString("color"));
		car.setId(result.getInt("carId"));
		car.setCruiseControl(result.getBoolean("cruiseControl"));
		car.setRearCamera(result.getBoolean("rearCamera"));
		car.setNavigationSystem(result.getBoolean("navigationSystem"));
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

	public List<Car> getCarsByModelName(String modelName) {
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
	
	public List<Car> getCarsByMakeName(String makeName) {
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

	public void deleteCarById(Car car) {
		Connection con = MariaDBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = con.prepareStatement(CarSQL.DELETECARSQL.statement());
		    preparedStatement.setInt(1, car.getId());
		    preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if (con != null) {
		
				preparedStatement.close();
				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void deleteMakeName(String makeName) {
		
		Connection con = MariaDBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = con.prepareStatement(CarSQL.DELETEMAKESQL.statement());
		    preparedStatement.setString(1, makeName);
		    preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if (con != null) {
		
				preparedStatement.close();
				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void deleteModelName(String modelName) {
		Connection con = MariaDBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = con.prepareStatement(CarSQL.DELETEMODELSQL.statement());
		    preparedStatement.setString(1, modelName);
		    preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if (con != null) {
		
				preparedStatement.close();
				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public Car addCar(Car newCar) {
		Car car = newCar;
		Connection con = MariaDBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = con.prepareStatement(CarSQL.ADDNEWCARSQL.statement(), Statement.RETURN_GENERATED_KEYS);
		    preparedStatement.setInt(1, newCar.getAvgMPG());
		    preparedStatement.setString(2, newCar.getColor());
		    preparedStatement.setString(3, newCar.getInteriorColor());
		    preparedStatement.setInt(4, newCar.getMileage());
		    preparedStatement.setInt(5, newCar.getModelYear());
		    preparedStatement.setString(6, newCar.getPrice().toPlainString());
		    preparedStatement.setBoolean(7, newCar.getCruiseControl());
		    preparedStatement.setBoolean(8,  newCar.getRearCamera());
		    preparedStatement.setBoolean(9, newCar.getNavigationSystem());
		    preparedStatement.setInt(10, newCar.getMake().getId());
		    preparedStatement.setInt(11, newCar.getModel().getId());
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
		Car car = updatedCar;
		Connection con = MariaDBUtil.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = con.prepareStatement(CarSQL.UPDATECARSQL.statement());
		    preparedStatement.setString(1, car.getColor());
		    preparedStatement.setInt(2, car.getMileage());
		    preparedStatement.setString(3, car.getPrice().toPlainString());
		    preparedStatement.setInt(4, car.getAvgMPG());
		    preparedStatement.setInt(5, car.getModelYear());
		    preparedStatement.setInt(6, car.getMake().getId());
		    preparedStatement.setInt(7, car.getModel().getId());
		    preparedStatement.setString(8, car.getInteriorColor());
		    preparedStatement.setBoolean(9, car.getCruiseControl());
		    preparedStatement.setBoolean(10,  car.getRearCamera());
		    preparedStatement.setBoolean(11, car.getNavigationSystem());
		    preparedStatement.setInt(12, car.getId());
		    
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

	public Make addMake(Make newmake) {
		Make make = new Make();
		Connection con = MariaDBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = con.prepareStatement(CarSQL.ADDNEWMAKESQL.statement(), Statement.RETURN_GENERATED_KEYS);
		    preparedStatement.setString(1, newmake.getName());
		    preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					make.setId(generatedKeys.getInt(1));
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
		
		return make;
	}

	public Model addModel(Model newModel) {
		Model model = new Model();
		Connection con = MariaDBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = con.prepareStatement(CarSQL.ADDNEWMODELSQL.statement(), Statement.RETURN_GENERATED_KEYS);
		    preparedStatement.setString(1, newModel.getName());
		    preparedStatement.setInt(2, newModel.getMake().getId());
		    preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					model.setId(generatedKeys.getInt(1));
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
		
		return model;
	}

	public List<Model> getModels() {
		List<Model> models = new ArrayList<>();
		
		Connection con = MariaDBUtil.getConnection();
		Statement statement = null;
		ResultSet result = null;
		
		try {
			statement = con.createStatement();
		    result = statement.executeQuery(CarSQL.GETMODELSSQL.statement() + ";");
			
			while (result.next()) {
				Model model = makeModel(result);
				models.add(model);
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
		return models;
	}

	public List<Make> getMakes() {
		List<Make> makes = new ArrayList<>();
		
		Connection con = MariaDBUtil.getConnection();
		Statement statement = null;
		ResultSet result = null;
		
		try {
			statement = con.createStatement();
		    result = statement.executeQuery(CarSQL.GETMAKESSQL.statement() + ";");
			
			while (result.next()) {
				Make make = makeMake(result);
				makes.add(make);
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
		return makes;
	}

	public List<Make> getUnusedMakes() {
		List<Make> unusedMakes = new ArrayList<>();
		
		Connection con = MariaDBUtil.getConnection();
		Statement statement = null;
		ResultSet result = null;
		
		try {
			statement = con.createStatement();
		    result = statement.executeQuery(CarSQL.GETUNUSEDMAKES.statement() + ";");
			
			while (result.next()) {
				Make make = makeMake(result);
				unusedMakes.add(make);
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
		return unusedMakes;
	}

	public List<Model> getUnusedModels() {
		List<Model> unusedModels = new ArrayList<>();
		
		Connection con = MariaDBUtil.getConnection();
		Statement statement = null;
		ResultSet result = null;
		
		try {
			statement = con.createStatement();
		    result = statement.executeQuery(CarSQL.GETUNUSEDMODELS.statement() + ";");
			
			while (result.next()) {
				Model model = makeModel(result);
				unusedModels.add(model);
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
		return unusedModels;
	}
}
