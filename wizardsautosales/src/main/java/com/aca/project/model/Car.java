package com.aca.project.model;

import java.math.BigDecimal;

public class Car {

		private Make make;
		private String interiorColor;
		private boolean cruiseControl;
		private boolean rearCamera;
		private boolean navigationSystem;
		private String color;
		private int mileage;
		private BigDecimal price;
		private int id;
		private int avgMPG;
		private Model model;
		private int modelYear;
		
		public Car() {}
		
		public Car(Make make, String interiorColor, boolean cruiseControl, boolean rearCamera, boolean navigationSystem, String color, int mileage, BigDecimal price, int id, int avgMPG, Model model, int modelYear) {
			this.model = model;
			this.interiorColor = interiorColor;
			this.color = color;
			this.mileage = mileage;
			this.price = price;
			this.id = id;
			this.avgMPG = avgMPG;
			this.make = make;
			this.modelYear = modelYear;
			this.cruiseControl = cruiseControl;
			this.rearCamera = rearCamera;
			this.navigationSystem = navigationSystem;
		}


		public Model getModel() {
			return model;
		}

		public int getModelYear() {
			return modelYear;
		}

		public void setModelYear(int modelYear) {
			this.modelYear = modelYear;
		}

		public void setModel(Model model) {
			this.model = model;
		}

		public int getAvgMPG() {
			return avgMPG;
		}

		public void setAvgMPG(int avgMPG) {
			this.avgMPG = avgMPG;
		}

		public Make getMake() {
			return make;
		}

		public void setMake(Make make) {
			this.make = make;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public int getMileage() {
			return mileage;
		}

		public void setMileage(int mileage) {
			this.mileage = mileage;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public String getInteriorColor() {
			return interiorColor;
		}

		public void setInteriorColor(String interiorColor) {
			this.interiorColor = interiorColor;
		}

		public Boolean getCruiseControl() {
			return cruiseControl;
		}

		public void setCruiseControl(Boolean cruiseControl) {
			this.cruiseControl = cruiseControl;
		}

		public Boolean getRearCamera() {
			return rearCamera;
		}

		public void setRearCamera(Boolean rearCamera) {
			this.rearCamera = rearCamera;
		}

		public Boolean getNavigationSystem() {
			return navigationSystem;
		}

		public void setNavigationSystem(Boolean navigationSystem) {
			this.navigationSystem = navigationSystem;
		}
		
		
}
