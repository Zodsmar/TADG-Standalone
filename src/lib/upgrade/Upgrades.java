package lib.upgrade;

import java.util.Random;

import lib.resources.Variables;

public class Upgrades {

	Variables var = new Variables();
	Random rand = new Random();

	public void missChance() {
			System.out.println("\t> The " + var.enemy + " has MISSED!");
	}

	public void criticalHit(int damage, int amount) {
		this.setCriticalAmount();
		damage += amount;
		System.out.println("\t> You got lucky and critically hit the  " + var.enemy + " for " + damage);
	}

	public int setMissChance() {
		var.missChanceRand = rand.nextInt(var.hundredPercent);
		return var.missChanceRand;
	}

	public int setCriticalAmount() {
		var.critAmountRand = rand.nextInt(25);
		return var.critAmountRand;
	}

	public int setCriticalChance() {
		var.critChanceRand = rand.nextInt(var.hundredPercent);
		return var.critChanceRand;
	}
}
