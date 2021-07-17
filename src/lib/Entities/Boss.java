package lib.Entities;

import java.util.Random;
import java.util.Scanner;

import lib.resources.Dialog;
import lib.resources.Stats;
import lib.resources.Variables;

public class Boss {
	Variables var = new Variables();
	Player player = new Player();
	Random rand = new Random();
	Stats stats = new Stats();
	Dialog dg = new Dialog();

	Scanner in = new Scanner(System.in);

	public void spawnBoss() {
		var.bossSpawn += 5;
		this.setBossHealth();
		this.bossSpawning();
		while (var.bossHealth > 0 && var.playerHealth > 0) {
			stats.bossStats();
			dg.attackChoicesBoss();
			String input = in.nextLine();

			if (input.equals("1")) {
				this.attackBoss();
			} else if (input.equals("2")) {
				player.potionHeal();
			} else if (input.equals("3")) {
				System.out.println("\t> You have decided to run from the " + var.boss + "!");
				var.bossAttack = false;
				return;
			} else {
				System.out.println("Invalid Input!");
			}

		}

		if (var.playerHealth > 0) {
			this.killedBoss();
		} else {
			var.bossAttack = false;
			var.breakOut = true;
		}
	}

	public String bossSpawning() {
		var.boss = var.bosses[rand.nextInt(var.bosses.length)];
		System.out.println("\n# " + var.boss + " appeared! # ");
		return var.boss;
	}

	public void attackBoss() {
		this.setBossAttack();
		if (var.bossHealth > 0) {
			this.setDamageRecieved();
			player.setPlayerHealth();
			System.out.println("\t> You have been hit for " + var.damageRecieved + "!");
		}

		if (var.playerHealth < 1) {
			System.out.println("\t# You have taken too much damage to continue! # ");
			var.bossAttack = false;
			return;
		}
		System.out.println("\t> You hit the " + var.boss + " for " + var.damageDealt + "!");
	}

	public void killedBoss() {
		System.out.println(var.dashes);
		System.out.println("\t # " + var.boss + " was defeated! # ");
		System.out.println("> You have " + var.playerHealth + " HP left.");
		stats.scoreBoard();
		player.potionsPercentage();
		if (var.potionChance < var.potionDropChance) {
			var.potions += 2;
			System.out.println("### The " + var.boss + " dropped two potion! ### \n");
			System.out.println("# You now have " + var.potions + " health potion(s) #");
		}
		stats.amountGold();
		var.bossAttack = false;
	}

	// GETTERS AND SETTERS

	public int setDamageRecieved() {
		var.damageRecieved = rand.nextInt(var.bossDamage) + 1;
		return var.damageRecieved;
	}

	public int setBossAttack() {
		var.damageDealt = rand.nextInt(var.damage);
		var.bossHealth -= var.damageDealt;
		return var.damageDealt;
	}

	public int setBossHealth() {
		var.bossHealth = rand.nextInt(var.bossHealthSpawn) + 150;
		return var.bossHealth;
	}

}
