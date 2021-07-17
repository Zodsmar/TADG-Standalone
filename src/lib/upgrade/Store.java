package lib.upgrade;

import java.util.ArrayList;
import java.util.Scanner;

import lib.resources.Variables;

public class Store {
	Scanner in = new Scanner(System.in);
	Variables var = new Variables();

	public void shop() {
		var.shopping = true;
		while (var.shopping) {

			System.out.println("You currently have " + var.gold + " GOLD!");
			System.out.println("Which upgrade would you like to buy?");
			System.out.println("1. A chance for Enemies to Miss which costs " + var.chanceToMissPrice);
			System.out.println("2. A chance for you to have a critical hit which costs " + var.chanceToCriticalPrice);
			System.out.println("E. To exit the Shop!");
			String input = in.nextLine();
			String inputC = input.toUpperCase();
			switch (inputC) {
			case "1":
				this.upgradeSelection(input);
				break;
			case "2":
				this.upgradeSelection(input);
				break;
			case "E":
				System.out.println("You have left the Shop!");
				System.out.println(var.dashes);
				var.shopping = false;
				break;
			default:
				System.out.println("Invalid Input!");
				continue;
			}
		}

	}

	private void upgradeSelection(String i) {
		ArrayList<String> upg = new ArrayList<String>();
		upg.add(0, var.chanceToMissString);
		upg.add(1, var.chanceToCriticalString);

		ArrayList<Boolean> bupg = new ArrayList<Boolean>();
		bupg.add(0, var.chanceToMiss);
		bupg.add(1, var.chanceToCritical);

		ArrayList<Integer> priceUpg = new ArrayList<Integer>();
		priceUpg.add(0, var.chanceToMissPrice);
		priceUpg.add(1, var.chanceToCriticalPrice);

		int convert = Integer.parseInt(i) - 1;
		String upgrade = upg.get(convert);
		boolean upgb = bupg.get(convert);
		int price = priceUpg.get(convert);

		if (priceUpg.size() > convert || upg.size() > convert || bupg.size() > convert) {

			if (upgb == false) {
				if (var.gold >= price) {
					System.out.println("You bought " + upgrade + "!");
					var.gold -= price;
					switch(i){
					case "1":
						var.chanceToMiss = true;
						break;
					case "2":
						var.chanceToCritical = true;
						break;
					}
					System.out.println("You have " + var.gold + " left over!\n");
				} else {
					System.out.println("You are unable to afford the " + upgrade + " upgrade!\n");
				}
			} else {
				System.out.println("You have already bought this upgrade!\n");
			}
			return;
		} else {
			return;
		}
	}
}
