package com.skilldistillery.jets;


public class Airfield {
	public Airfield() {

	}

	public Jet[] makeJetArr() {
		Jet[] jetArr = new Jet[100];
		addDefaultJets(jetArr);
		return jetArr;
	}

	public static void addDefaultJets(Jet[] jetArr) {

		jetArr[0] = new FighterJet("F-15", 1650, 3450, 29_990_000);
		jetArr[1] = new FighterJet("F-16", 915, 2280, 18_800_000);
		jetArr[2] = new FighterJet("F-22", 1500, 1740, 150_000_000);
		jetArr[3] = new CargoJet("C-5", 531, 5500, 224_290_000);
		jetArr[4] = new CargoJet("C-17", 515, 2420, 218_000_000);
	}

}
