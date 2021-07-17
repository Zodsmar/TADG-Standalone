package lib.resources;

public class Level {

	Variables var = new Variables();
	Stats stats = new Stats();

	public void levelUP() {
		if (var.xP >= var.levelUp) {
			var.playerLevel += 1;
			var.xP = 0;
			var.levelUp += 100;
			var.potionHeal += 10;
			var.levelHeal += 25;
			var.playerHealth += var.levelHeal;
			if (var.potionDropChance <= 70) {
				var.potionDropChance += 5;
			}
			if (var.damage <= var.MAX_DAMAGE) {
				var.damage += 10;
			}
			if (var.enemyDamage <= var.MAX_ENEMY_DAMAGE) {
				var.enemyDamage += 15;
			}
			if (var.bossDamage <= var.MAX_BOSS_DAMAGE) {
				var.bossDamage += 25;
			}
			if (var.enemyHealthSpawn <= var.MAX_ENEMY_HEALTH) {
				var.enemyHealthSpawn += 25;
			}
			if (var.bossHealthSpawn <= var.MAX_BOSS_HEALTH) {
				var.bossHealthSpawn += 50;
			}

			stats.levelUp();
		}
	}

}
