package com.skilldistillery.jets;

public abstract class Jet {
	private String model;
	private double speed, range, price;

	public Jet(String model, double speed, double range, double price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public void fly() {
		String type = this.getClass().getSimpleName();
		double flightTime = this.range / this.speed;
		System.out.println("Type: " + type + " Model: " + this.model + ", Speed: " + this.speed + " MPH, Range: "
				+ this.range + " Miles, Price: $" + this.price + ", Flight time at max speed: " + flightTime + "hours");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
