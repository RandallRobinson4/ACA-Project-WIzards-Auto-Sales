package com.aca.project.dao;

public enum CarSQL {

	GETCARSSQL("SELECT make.name, model.name, car.color, car.mileage, car.price, car.avgMPG,"
					+ " car.modelYear, interior.interiorColor, interior.cruiseControl,"
					+ " interior.rearCamera, interior.navigationSystem, car.makeId, car.modelId, car.interiorId, car.carId"
					+ " FROM car"
					+ " INNER JOIN interior"
					+ " ON car.interiorId = interior.interiorid"
					+ " INNER JOIN make"
					+ " ON car.makeId = make.makeId"
					+ " INNER JOIN model"
					+ " ON car.modelId = model.modelId"),	
	GETBYMAKENAMESQL(" WHERE make.name = ?"),
	GETBYMODELNAMESQL(" WHERE model.name = ?"),
	GETBYCARIDSQL(" WHERE carId = ?"),
	ADDNEWCARSQL("INSERT INTO CAR(avgMPG, color, mileage, modelYear, price, interiorId, makeId, modelId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	
	private String statement;
	
	CarSQL(String statement) {
		this.statement = statement;
	}
	
	public String statement() {
		return statement;
	}
}
