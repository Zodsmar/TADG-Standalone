package lib.game;

import lib.Entities.Boss;
import lib.Entities.Enemy;
import lib.resources.Dialog;
import lib.resources.Level;
import lib.resources.Sound;
import lib.resources.Variables;

public class MainGame {

	public static void main(String[] args) {

		Enemy enemyM = new Enemy();
		Boss bossM = new Boss();

		Variables var = new Variables();
		// Stats stats = new Stats();
		Level level = new Level();
		Dialog dg = new Dialog();
		
		dg.dungeon();
		Sound.playTitleMusic();
		

		while (var.running) {
			if (var.enemiesKilled == var.bossSpawn) {
				var.bossAttack = true;
				var.breakOut = false;
				bossM.spawnBoss();
				if (var.breakOut == true) {
					break;
				}
			} else {
				var.breakOut = false;
				enemyM.spawnEnemy();
				if (var.breakOut == true) {
					break;
				}
			}
			if (var.playerHealth < 1) {
				System.out.println("You somehow escape the dungeon!");
				break;
			}
			level.levelUP();
			var.breakOut = false;
			dg.endGameChoices();
			if (var.breakOut == true) {
				break;
			}
		}
		dg.thankS();
		System.exit(0);
	}

}
