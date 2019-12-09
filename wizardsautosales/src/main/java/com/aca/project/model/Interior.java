package com.aca.project.model;

public class Interior {
	
	private String color;
	private boolean cruiseControl;
	private boolean rearCamera;
	private boolean navigationSystem;
	
	public Interior() {}
	
	public Interior(String color, boolean cruiseControl, boolean rearCamera, boolean navigationSystem) {
		this.color = color;
		this.cruiseControl = cruiseControl;
		this.rearCamera = rearCamera;
		this.navigationSystem = navigationSystem;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isCruiseControl() {
		return cruiseControl;
	}

	public void setCruiseControl(boolean cruiseControl) {
		this.cruiseControl = cruiseControl;
	}

	public boolean isRearCamera() {
		return rearCamera;
	}

	public void setRearCamera(boolean rearCamera) {
		this.rearCamera = rearCamera;
	}

	public boolean isNavigationSystem() {
		return navigationSystem;
	}

	public void setNavigationSystem(boolean navigationSystem) {
		this.navigationSystem = navigationSystem;
	}

}
