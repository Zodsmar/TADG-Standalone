package lib.Entities;

import java.util.Random;
import java.util.Scanner;

import lib.resources.Dialog;
import lib.resources.Stats;
import lib.resources.Variables;
import lib.upgrade.Upgrades;

public class Enemy {

	Variables var = new Variables();
	Player player = new Player();
	Random rand = new Random();
	Stats stats = new Stats();
	Dialog dg = new Dialog();
	Upgrades upg = new Upgrades();
	Scanner in = new Scanner(System.in);

	public void spawnEnemy() {
		this.setEnemyHealth();
		this.enemySpawning();
		while (var.enemyHealth > 0 && var.playerHealth > 0) {

			stats.enemyStats();
			dg.attackChoicesEnemy();
			dg.shop();

			String input = in.nextLine();

			if (input.equals("1")) {
				this.attackEnemy();
			} else if (input.equals("2")) {
				player.potionHeal();
			} else if (input.equals("3")) {
				System.out.println("\t> You have decided to run from the " + var.enemy + "!");
				return;
			} else if (input.equals("4")) {
				dg.shopWelcome();
			} else {
				System.out.println("Invalid Input!");
			}
		}

		if (var.playerHealth > 0) {
			this.killedEnemy();
		} else {
			var.breakOut = true;
		}
	}

	public String enemySpawning() {
		var.enemy = var.enemies[rand.nextInt(var.enemies.length)];
		System.out.println("\n# " + var.enemy + " appeared! # ");
		return var.enemy;
	}

	public void attackEnemy() {
		this.setEnemyAttack();
		upg.setCriticalChance();
		upg.setMissChance();
		if (var.enemyHealth > 0) {
			if (var.missChanceRand <= var.chanceTOMiss && var.chanceToMiss == true) {
				upg.missChance();
			} else {
				this.setDamageRecieved();
				player.setPlayerHealth();
				System.out.println("\t> You have been hit for " + var.damageRecieved + "!");
			}
		}

		if (var.playerHealth < 1) {
			System.out.println("\t# You have taken too much damage to continue! # ");
			return;
		}
		if(var.critChanceRand <= var.critChance && var.chanceToCritical == true){
			upg.criticalHit(var.damageDealt, var.critAmountRand);
		} else {
			System.out.println("\t> You hit the " + var.enemy + " for " + var.damageDealt + "!");
		}

	}

	public void killedEnemy() {
		System.out.println(var.dashes);
		System.out.println("\t # " + var.enemy + " was defeated! # ");
		System.out.println("> You have " + var.playerHealth + " HP left.");
		stats.scoreBoard();
		stats.setXPDrop();
		player.potionsPercentage();
		if (var.potionChance < var.potionDropChance) {
			var.potions++;
			System.out.println("### The " + var.enemy + " dropped a potion! ###");
			System.out.println("# You now have " + var.potions + " health potion(s) #");
		}
		stats.amountGold();
	}

	// GETTERS AND SETTERS

	public int setDamageRecieved() {
		var.damageRecieved = rand.nextInt(var.enemyDamage) + 1;
		return var.damageRecieved;
	}

	public int setEnemyAttack() {
		var.damageDealt = rand.nextInt(var.damage);
		var.enemyHealth -= var.damageDealt;
		return var.damageDealt;
	}

	public int setEnemyHealth() {
		var.enemyHealth = rand.nextInt(var.enemyHealthSpawn) + 25;
		return var.enemyHealth;
	}

}
