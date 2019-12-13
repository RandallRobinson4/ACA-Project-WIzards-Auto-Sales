package com.aca.project.model;

public class Model {
	
	private String name;
	private int id;
	private Make make;
	
	public Model() {}
	
	public Model(String name, Make make, int id) {
		this.name = name;
		this.id = id;
		this.make = make;
	}

	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
