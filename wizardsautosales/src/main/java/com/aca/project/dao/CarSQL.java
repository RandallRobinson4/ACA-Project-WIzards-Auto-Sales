package com.aca.project.dao;

public enum CarSQL {

	GETCARSSQL("SELECT make.name, model.name, car.color, car.mileage, car.price, car.avgMPG,"
					+ " car.modelYear, car.makeId, car.modelId, car.interiorColor,"
					+ " car.cruiseControl, car.rearCamera, car.navigationSystem, car.carId"
					+ " FROM car"
					+ " INNER JOIN make"
					+ " ON car.makeId = make.makeId"
					+ " INNER JOIN model"
					+ " ON car.modelId = model.modelId"),	
	GETBYMAKENAMESQL(" WHERE make.name = ?"),
	GETBYMODELNAMESQL(" WHERE model.name = ?"),
	GETBYCARIDSQL(" WHERE carId = ?"),
	ADDNEWCARSQL("INSERT INTO CAR(avgMPG, color, interiorColor, mileage, modelYear, price, cruiseControl, rearCamera, navigationSystem, makeId, modelId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),
	ADDNEWMAKESQL("INSERT INTO MAKE(name) VALUES (?)"),
	ADDNEWMODELSQL("INSERT INTO MODEL(name, makeId) VALUES (?, ?)"),
	GETMODELSSQL("SELECT model.name, make.name, model.modelId, make.makeId FROM model INNER JOIN make ON model.makeId = make.makeId"),
	GETMAKESSQL("SELECT make.name, make.makeId FROM make"),
	DELETECARSQL("DELETE FROM car WHERE car.carId = ?"),
	DELETEMAKESQL("DELETE FROM make WHERE make.name = ?"),
	DELETEMODELSQL("DELETE FROM model WHERE model.name =?"),
	UPDATECARSQL("UPDATE car SET color = ?, mileage = ?, price = ?, avgMPG = ?, modelYear = ?, makeId = ?, modelId = ?,"
					+ " interiorColor = ?, cruiseControl = ?, rearCamera = ?, navigationSystem = ? WHERE carId = ?"),
	GETUNUSEDMAKES("SELECT make.name, make.makeid FROM Make WHERE NOT EXISTS (SELECT car.makeid FROM car  WHERE car.makeid = make.makeid) AND NOT EXISTS (SELECT model.makeId FROM model WHERE model.makeid = make.makeid)"),
	GETUNUSEDMODELS("SELECT model.name, make.name, model.modelId, make.makeId FROM model INNER JOIN make ON model.makeId = make.makeId WHERE model.modelId NOT IN (SELECT car.modelId FROM car)");
	
	private String statement;
	
	CarSQL(String statement) {
		this.statement = statement;
	}
	
	public String statement() {
		return statement;
	}
}
