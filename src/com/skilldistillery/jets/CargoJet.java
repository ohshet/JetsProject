package com.skilldistillery.jets;

public class CargoJet extends Jet {

	public CargoJet(String model, double speed, double range, double price) {
		super(model, speed, range, price);
	}
	public void loadCargo() {
		System.out.println(this.getModel() + " is loaded with cargo!");
	}
}
