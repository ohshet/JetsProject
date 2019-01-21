package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady{

	public FighterJet(String model, double speed, double range, double price) {
		super(model, speed, range, price);
	}
	
	public void dogfight() {
		System.out.println(this.getModel() + " has scrambled for a dog fight!");
	}
}
