package com.aca.project.model;

public class Model {
	
	private String name;
	private String make;
	private int modelYear;
	
	public Model() {}
	
	public Model(String name, String make, int modelYear) {
		this.name = name;
		this.make = make;
		this.modelYear = modelYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	

}
