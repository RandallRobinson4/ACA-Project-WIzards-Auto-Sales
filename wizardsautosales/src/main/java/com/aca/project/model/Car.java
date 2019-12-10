package com.aca.project.model;

import java.math.BigDecimal;

public class Car {

		private Make make;
		private Interior interior;
		private String color;
		private int mileage;
		private BigDecimal price;
		private int id;
		private int avgMPG;
		private Model model;
		private int modelYear;
		
		public Car() {}
		
		public Car(Make make, Interior interior, String color, int mileage, BigDecimal price, int id, int avgMPG, Model model, int modelYear) {
			this.model = model;
			this.interior = interior;
			this.color = color;
			this.mileage = mileage;
			this.price = price;
			this.id = id;
			this.avgMPG = avgMPG;
			this.make = make;
			this.modelYear = modelYear;
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

		public Interior getInterior() {
			return interior;
		}

		public void setInterior(Interior interior) {
			this.interior = interior;
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
		
		
}
