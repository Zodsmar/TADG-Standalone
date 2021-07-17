package lib.resources;

import java.util.Random;
import java.util.Scanner;

public class Stats {
	
	Random rand = new Random();
	Variables var = new Variables();
	Scanner in = new Scanner(System.in);
	
	public void amountGold(){
		this.setGoldDrop();
		var.gold += var.goldDrop;
		System.out.println("# You know have " + var.gold +" total Gold! # ");
	}
	
	public void scoreBoard(){
		this.setXPDrop();
		var.xP += var.xpAmount;
		var.enemiesKilled++;
		System.out.println("> You have killed " + var.enemiesKilled + " enemies, "
				+ "and recieved " + var.xpAmount + " XP!");
		System.out.println("# You know have " + var.xP +" total XP! # ");
	}
	
	public void	enemyStats(){
		System.out.println("The " + var.enemy + " has " + var.enemyHealth + " HP.");
		System.out.println("You have " + var.playerHealth + " HP.");
		System.out.println("You have " + var.potions + " health potions.");
	}
	
	public void bossStats(){
		System.out.println("The " + var.boss + " has " + var.bossHealth + " HP.");
		System.out.println("You have " + var.playerHealth + " HP.");
		System.out.println("You have " + var.potions + " health potions.");
	}
	
	public void levelUp(){
		System.out.println("\n##### YOU LEVELED UP TO LEVEL " + var.playerLevel + " #####");
		System.out.println("##### YOU GAINED " + var.levelHeal + " HEALTH #####");
		System.out.println("##### POTIONS NOW HEAL YOU FOR " + var.potionHeal + " #####");
		if(var.damage >= var.MAX_DAMAGE){
			System.out.println("##### YOU HAVE MAX DAMAGE #####");
		} else {
		System.out.println("##### YOU CAN NOW DO " + var.damage + " DAMAGE #####");
		}
		if(var.enemyDamage >= var.MAX_ENEMY_DAMAGE){
			System.out.println("##### ENEMIES HAVE MAX DAMAGE #####");
		} else {
		System.out.println("##### ENEMIES CAN NOW DO UP TO " + (var.enemyDamage + 1) + " DAMAGE #####"); 
		}
		if(var.bossDamage >= var.MAX_BOSS_DAMAGE){
			System.out.println("##### BOSSES HAVE MAX DAMAGE #####");
		} else {
		System.out.println("##### BOSSES CAN NOW DO UP TO " + (var.bossDamage + 1) + " DAMAGE #####");
		}
		if(var.enemyHealthSpawn >= var.MAX_ENEMY_HEALTH){
			System.out.println("##### ENEMIES HAVE MAX HEALTH #####");
		} else {
		System.out.println("##### ENEMIES NOW HAVE UP TO " + var.enemyHealthSpawn + " HEALTH #####"); 
		}
		if(var.bossHealthSpawn >= var.MAX_BOSS_HEALTH){
			System.out.println("##### BOSSES HAVE MAX HEALTH #####");
		} else {
		System.out.println("##### BOSSES NOW HAVE UP TO " + var.bossHealthSpawn + " HEALTH #####");
		}
	}
	
	//GETTERS AND SETTERS
	
	public int setXPDrop(){
		if(var.bossAttack == false){
		var.xpAmount = rand.nextInt(var.MAX_XP);
		return var.xpAmount;
		}else{
			var.xpAmount = rand.nextInt(var.MAX_XP) + 50;
			return var.xpAmount;
		}
	}
	public int setGoldDrop(){
		var.goldDrop = rand.nextInt(var.MAX_GOLD_DROP);
		return var.goldDrop;
	}
}
