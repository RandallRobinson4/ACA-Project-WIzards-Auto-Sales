package com.aca.project.dao;

public enum CarSQL {

	GETCARSSQL("SELECT * FROM CAR");
	
	private String statement;
	
	CarSQL(String statement) {
		this.statement = statement;
	}
	
	public String statement() {
		return statement;
	}
}
