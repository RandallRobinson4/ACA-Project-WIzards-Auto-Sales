package com.aca.project.model;

public class Make {
	
	private String name;
	private Model model;
	private int modelYear;
	private int id;
	
	public Make() {}
	
	public Make(String name, Model model, int modelYear, int id) {
		this.name = name;
		this.model = model;
		this.modelYear = modelYear;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Model getModel() {
		return model;
	}

	public void setMake(Model model) {
		this.model = model;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	

}
