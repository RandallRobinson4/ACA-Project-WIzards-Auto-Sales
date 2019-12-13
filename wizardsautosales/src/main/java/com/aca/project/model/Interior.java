package com.aca.project.model;

public class Interior {
	
	private String interiorColor;
	private boolean cruiseControl;
	private boolean rearCamera;
	private boolean navigationSystem;
	
	public Interior() {}
	
	public Interior(String interiorColor, boolean cruiseControl, boolean rearCamera, boolean navigationSystem) {
		this.interiorColor = interiorColor;
		this.cruiseControl = cruiseControl;
		this.rearCamera = rearCamera;
		this.navigationSystem = navigationSystem;
	}

	public String getColor() {
		return interiorColor;
	}

	public void setInteriorColor(String interiorColor) {
		this.interiorColor = interiorColor;
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
