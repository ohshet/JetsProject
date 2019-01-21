package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {

	public static void main(String[] args) {
		Airfield airfield = new Airfield();
		Jet[] jetArr = new Jet[100];
		jetArr = airfield.makeJetArr();
		while (true) {
			userChoices(jetArr);
		}
	}

	public static void userChoices(Jet[] jetArr) {
		Scanner kb = new Scanner(System.in);
		int userInput = 0;
		System.out.println("Make a selection by number:");
		System.out.println("(1) List fleet");
		System.out.println("(2) Fly all jets");
		System.out.println("(3) View fastest jet");
		System.out.println("(4) View jet with longest range");
		System.out.println("(5) Load all cargo jets");
		System.out.println("(6) Dogfight!");
		System.out.println("(7) Add jet to fleet");
		System.out.println("(8) Quit");
		userInput = kb.nextInt();

		switch (userInput) {
		case 1:
			listFleet(jetArr);
			break;
		case 2:
			flyAll(jetArr);
			break;
		case 3:
			viewFastest(jetArr);
			break;
		case 4:
			viewLongestRange(jetArr);
			break;
		case 5:
			loadAllCargo(jetArr);
			break;
		case 6:
			dogfight(jetArr);
			break;
		case 7:
			addJet(jetArr);
			break;
		case 8:
			kb.close();
			System.exit(0);
		}
		System.out.println();
	}

	public static void listFleet(Jet[] jetArr) {
		System.out.println("The fleet currently contains:");
		for (int i = 0; i < jetArr.length; i++) {
			if (jetArr[i] != null) {
				System.out.println(jetArr[i].getModel());
			}
		}
	}

	public static void flyAll(Jet[] jetArr) {
		System.out.println("The details of each jet are:");
		for (int i = 0; i < jetArr.length; i++) {
			if (jetArr[i] != null) {
				jetArr[i].fly();

			}
		}
	}

	public static void viewFastest(Jet[] jetArr) {
		System.out.println("The fastest jet in the fleet is:");
		double jetSpeed, maxSpeed = 0.0;
		int fastestJet = 0;
		for (int i = 0; i < jetArr.length; i++) {
			if (jetArr[i] == null) {
				continue;
			}
			jetSpeed = jetArr[i].getSpeed();
			if (jetSpeed > maxSpeed) {
				maxSpeed = jetSpeed;
				fastestJet = i;
			}
		}
		System.out.println(jetArr[fastestJet].getModel() + " " + maxSpeed + " MPH");
	}

	public static void viewLongestRange(Jet[] jetArr) {
		System.out.println("The longest range jet in the fleet is:");
		double jetRange, maxRange = 0.0;
		int longestJet = 0;
		for (int i = 0; i < jetArr.length; i++) {
			if (jetArr[i] == null) {
				continue;
			}
			jetRange = jetArr[i].getRange();
			if (jetRange > maxRange) {
				maxRange = jetRange;
				longestJet = i;
			}
		}
		System.out.println(jetArr[longestJet].getModel() + " " + maxRange + " Miles");
	}

	public static void loadAllCargo(Jet[] jetArr) {
		for (int i = 0; i < jetArr.length; i++) {
			if (jetArr[i] != null && jetArr[i] instanceof CargoJet) {
				((CargoJet) jetArr[i]).loadCargo();
			}
		}
	}

	public static void dogfight(Jet[] jetArr) {
		for (int i = 0; i < jetArr.length; i++) {
			if (jetArr[i] != null && jetArr[i] instanceof FighterJet) {
				((FighterJet) jetArr[i]).dogfight();
			}
		}
	}

	public static void addJet(Jet[] jetArr) {
		int slot = openSlot(jetArr);
		if (slot > 100) {
			System.exit(0);
		}
		System.out.println("Enter details for the new jet.");
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter model:");
		String model = kb.nextLine();
		System.out.println("Enter max speed in MPH:");
		double speed = kb.nextDouble();
		System.out.println("Enter range in miles:");
		double range = kb.nextDouble();
		System.out.println("Enter price:");
		double price = kb.nextDouble();
		jetArr[slot] = new JetImpl(model, speed, range, price);
	}

	public static int openSlot(Jet[] jetArr) {
		int openSlot = 0;
		for (int i = 0; i < jetArr.length; i++) {
			if (jetArr[i] == null) {
				openSlot = i;
				return i;
			} else if (i == 100) {
				System.out.println("The airfield is full!");
			}
		}
		return 101;
	}

}
