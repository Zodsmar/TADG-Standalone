package lib.Entities;

import java.util.Random;

import lib.resources.Variables;

public class Player {
	
	Variables var = new Variables();
	Random rand = new Random();
	
	public void potionHeal(){
		if (var.playerHealth >= var.MAX_HEALTH) {
			System.out.println("\t # You already have Max Health! # ");
			return;
		}
		if (var.potions > 0) {
			var.playerHealth += var.potionHeal;
			var.potions--;
			System.out
					.println("\t> You drank a potion and have been healed for " + var.potionHeal + " HP!");
		} else {
			System.out.println(
					"\t # You are out of potions, try to kill the " + var.enemy + " for a drop! # ");
		}
	}

	
	
	//GETTERS AND SETTERS
	
	public int setPlayerHealth(){
		var.playerHealth -= var.damageRecieved;
		return var.playerHealth;
	}
	
	public int potionsPercentage(){
		var.potionChance = rand.nextInt(var.hundredPercent);
		return var.potionChance;
	}
}
