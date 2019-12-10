package com.aca.project.model;

import java.math.BigDecimal;

public class Car {

		private Make model;
		private Interior interior;
		private String color;
		private int mileage;
		private BigDecimal price;
		private int id;
		private int avgMPG;
		
		public Car() {}
		
		public Car(Make model, Interior interior, String color, int mileage, BigDecimal price, int id, int avgMPG) {
			this.model = model;
			this.interior = interior;
			this.color = color;
			this.mileage = mileage;
			this.price = price;
			this.id = id;
			this.avgMPG = avgMPG;
		}

		public int getAvgMPG() {
			return avgMPG;
		}

		public void setAvgMPG(int avgMPG) {
			this.avgMPG = avgMPG;
		}

		public Make getModel() {
			return model;
		}

		public void setModel(Make model) {
			this.model = model;
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
