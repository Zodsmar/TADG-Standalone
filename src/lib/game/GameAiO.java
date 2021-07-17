package lib.game;

import java.util.Random;
import java.util.Scanner;

public class GameAiO {

	public static void main(String[] args) {

		// Game Objects
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		// Player Variables
		final int MAX_HEALTH = 1000;
		int playerHealth = 100;
		final int MAX_DAMAGE = 50;
		// Enemy Variables
		final int MAX_ENEMY_HEALTH = 75;
		int enemyDamage = 25;
		final int MAX_BOSS_HEALTH = 350; // will always have at least 150 health
		int bossDamage = 50;
		// Potions Variables
		int potions = 3;
		int potionHeal = 40;
		int potionDropChance = 50;
		// ScoreBoard Variables
		int enemiesKilled = 0;
		int bossSpawn = 5;

		// Strings
		String dashes = "--------------------------------------";
		String[] enemies = { "Zombie", "Skeleton", "Mummy", "Spider", "Witch", "Scorpion", "Knight" };
		String[] bosses = { "Dragon", "Cobra", "Assasin" };

		// Game Variables
		boolean running = true;

		// Start of the Game
		System.out.println("Welcome to the dungeon!\n");

		GAME: while (running) {

			if (enemiesKilled == bossSpawn) {
				bossSpawn += 5;

				System.out.println(dashes);

				int bossHealth = rand.nextInt(MAX_BOSS_HEALTH) + 150;
				String boss = bosses[rand.nextInt(bosses.length)];
				System.out.println("\t# " + boss + " appeared! # ");

				while (bossHealth > 0 && playerHealth > 0) {
					System.out.println("The " + boss + " has " + bossHealth + " HP.");
					System.out.println("You have " + playerHealth + " HP.");
					System.out.println("You have " + potions + " health potions.");
					System.out.println("What would you like to do?");
					System.out.println("1. Attack the " + boss + "!");
					System.out.println("2. Drink a heal potion!");
					System.out.println("3. Run away from the " + boss + "!");

					String input2 = in.nextLine();

					if (input2.equals("1")) {
						int damageDealt = rand.nextInt(MAX_DAMAGE);
						int damageRecieved = rand.nextInt(bossDamage);
						bossHealth -= damageDealt;
						if (bossHealth > 0) {
							playerHealth -= damageRecieved;
							System.out.println("\t> You have been hit for " + damageRecieved + "!");
						}
						if (playerHealth < 1) {
							System.out.println("\t # You have taken too much damage to continue! # ");
							break;
						}
						System.out.println("\t> You hit the " + boss + " for " + damageDealt + "!");
					} else if (input2.equals("2")) {
						if (playerHealth >= MAX_HEALTH) {
							System.out.println("\t # You already have Max Health! # ");
							continue;
						}
						if (potions > 0) {
							playerHealth += potionHeal;
							potions--;
							System.out
									.println("\t> You drank a potion and have been healed for " + potionHeal + " HP!");
						} else {
							System.out.println(
									"\t # You are out of potions, try to kill the " + boss + " for a drop! # ");
						}
					} else if (input2.equals("3")) {
						System.out.println("\t> You have decided to run from the " + boss + "!");
						continue GAME;

					} else {
						System.out.println("Invalid Input!");
					}
				}
				if (playerHealth > 0) {
					System.out.println(dashes);
					System.out.println("\t # " + boss + " was defeated! # ");
					enemiesKilled++;
					System.out.println("\t  You have " + playerHealth + " HP left.");
					System.out.println("\t  You have killed " + enemiesKilled + " enemies!");
					if (rand.nextInt(75) < potionDropChance) {
						potions += 2;
						System.out.println("The " + boss + " dropped two potions!");
						System.out.println(" # You now have " + potions + " health potion(s) #");
					}
				} else {
					break;
				}
			} else {
				System.out.println(dashes);

				int enemyHealth = rand.nextInt(MAX_ENEMY_HEALTH);
				String enemy = enemies[rand.nextInt(enemies.length)];
				System.out.println("\t# " + enemy + " appeared! # ");
				while (enemyHealth > 0 && playerHealth > 0) {
					System.out.println("The " + enemy + " has " + enemyHealth + " HP.");
					System.out.println("You have " + playerHealth + " HP.");
					System.out.println("You have " + potions + " health potions.");
					System.out.println("What would you like to do?");
					System.out.println("1. Attack the " + enemy + "!");
					System.out.println("2. Drink a heal potion!");
					System.out.println("3. Run away from the " + enemy + "!");

					String input = in.nextLine();

					if (input.equals("1")) {
						int damageDealt = rand.nextInt(MAX_DAMAGE);
						int damageRecieved = rand.nextInt(enemyDamage);
						enemyHealth -= damageDealt;
						if (enemyHealth > 0) {
							playerHealth -= damageRecieved;
							System.out.println("\t> You have been hit for " + damageRecieved + "!");
						}

						if (playerHealth < 1) {
							System.out.println("\t # You have taken too much damage to continue! # ");
							break;
						}
						System.out.println("\t> You hit the " + enemy + " for " + damageDealt + "!");
					} else if (input.equals("2")) {
						if (playerHealth >= MAX_HEALTH) {
							System.out.println("\t # You already have Max Health! # ");
							continue;
						}
						if (potions > 0) {
							playerHealth += potionHeal;
							potions--;
							System.out
									.println("\t> You drank a potion and have been healed for " + potionHeal + " HP!");
						} else {
							System.out.println(
									"\t # You are out of potions, try to kill the " + enemy + " for a drop! # ");
						}

					} else if (input.equals("3")) {
						System.out.println("\t> You have decided to run from the " + enemy + "!");
						continue GAME;
					} else {
						System.out.println("Invalid Input!");
					}

				}
				if (playerHealth > 0) {
					System.out.println(dashes);
					System.out.println("\t # " + enemy + " was defeated! # ");
					enemiesKilled++;
					System.out.println("\t  You have " + playerHealth + " HP left.");
					System.out.println("\t  You have killed " + enemiesKilled + " enemies!");
					if (rand.nextInt(100) < potionDropChance) {
						potions++;
						System.out.println("### The " + enemy + " dropped a potion! ### \n");
						System.out.println("# You now have " + potions + " health potion(s) #");
					}
				} else {
					break;
				}
			}
			if (playerHealth < 1) {
				System.out.println("You somehow escape the dungeon!");
				break;
			}

			System.out.println(dashes);
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
			} else if (input.equals("2")) {
				System.out.println("You exit the dungeon!");
				break;
			}

		}
		System.out.println("######################");
		System.out.println("# THANKS FOR PLAYING #");
		System.out.println("######################");
	}
}