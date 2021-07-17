package lib.resources;

import java.util.Scanner;

import lib.upgrade.Store;

public class Dialog {

	Variables var = new Variables();
	Scanner in = new Scanner(System.in);
	Store store = new Store();

	// Main Dialog

	public void dungeon() {
		System.out.println("##########################");
		System.out.println("# WELCOME TO THE DUNGEON #");
		System.out.println("##########################");
		System.out.println("\nIn this game you will be faced with numerous monsters, "
				+ "\nafter which killing a few will spawn a boss!"
				+ "\nHowever, think very carefully before taking on the boss,"
				+ "\nif you do not enough health you will most certainly parish." + "\nContinue at your own RISK!");

	}

	public void thankS() {
		System.out.println("######################");
		System.out.println("# THANKS FOR PLAYING #");
		System.out.println("######################");
	}

	// Choices

	public void attackChoicesEnemy() {
		System.out.println("What would you like to do?");
		System.out.println("1. Attack the " + var.enemy + "!");
		System.out.println("2. Drink a heal potion!");
		System.out.println("3. Run away from the " + var.enemy + "!");
	}

	public void attackChoicesBoss() {
		System.out.println("What would you like to do?");
		System.out.println("1. Attack the " + var.boss + "!");
		System.out.println("2. Drink a heal potion!");
		System.out.println("3. Run away from the " + var.boss + "!");
	}

	public void endGameChoices() {
		System.out.println(var.dashes);
		System.out.println("What would you like to do?");
		System.out.println("1. Continue?");
		System.out.println("2. Exit Dungeon!");

		String input = in.nextLine();

		while (!input.equals("1") && !input.equals("2")) {
			System.out.println("Invalid Input!");
			input = in.nextLine();
		}

		if (input.equals("1")) {
			System.out.println("You continue your adventure!");
			var.breakOut = false;
		} else if (input.equals("2")) {
			System.out.println("You exit the dungeon!");
			var.breakOut = true;
		}
	}

	public void shopWelcome() {
		System.out.println("#######################");
		System.out.println("# Welcome to the shop #");
		System.out.println("#######################");
		store.shop();
	}

	public void shop() {
		System.out.println("4. Go to shop!");
	}

}
