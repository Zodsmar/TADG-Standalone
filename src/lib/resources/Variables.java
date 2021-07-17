package lib.resources;
import java.util.Random;

public class Variables {

	static Random rand = new Random();
	   
	//Boolean
	
	public static boolean breakOut;
	public static boolean bossAttack;
	public static boolean running = true;
	public static boolean shopping = true;
	public static boolean chanceToMiss = false;
	public static boolean chanceToCritical = false;
	
	// FINALS
	// Player Variables
	public final int MAX_HEALTH = 1000;
	public final int MAX_DAMAGE = 750;
	// Enemy Variables
	public final int MAX_ENEMY_HEALTH = 300;
	public final int MAX_ENEMY_DAMAGE = 250;
	public final int MAX_BOSS_HEALTH = 850; // will always have at least 150 health
	public final int MAX_BOSS_DAMAGE = 500;

	//ScoreBoard Variables
	public final int MAX_XP = 25;
	public final int MAX_GOLD_DROP = 25;
	
	// Variables
	// Player Variables
	public static int playerHealth = 100;	
	public static int damageRecieved;
	public static int damageDealt;
	public static int playerLevel;
	public static int damage = 50;
	// Enemy Variables
	public static int enemyDamage = 24; //Add 1 
	public static int bossDamage = 49;  //Add 1
	public static int enemyHealthSpawn = 50;
	public static int bossHealthSpawn = 250;
	public static int enemyHealth;
	public static int bossHealth;
	public static int chanceTOMiss = 20;
	public static int critChance = 30;
	public static int missChanceRand;
	public static int critChanceRand;
	public static int critAmountRand;
	// Potions Variables
	public static int potions = 3;
	public static int potionHeal = 40;
	public int potionDropChance = 50;
	public int hundredPercent = 100;
	public static int potionChance;
	// ScoreBoard Variables
	public static int enemiesKilled = 0;
	public static int bossSpawn = 5;
	public static int xP;
	public static int xpAmount;
	public static int levelUp = 100;
	public static int levelHeal = 100;
	//Upgrades Variables
	public static int goldDrop;
	public static int gold = 2500;
	public static int chanceToMissPrice = 1000;
	public static int chanceToCriticalPrice = 1500;
	
	// Strings
	public static String enemy;
	public static String boss;
	public String[] enemies = { "Zombie", "Skeleton", "Mummy", "Spider", "Witch", "Scorpion", "Knight" };
	public String[] bosses = { "Dragon", "Cobra", "Assasin" };
	public String dashes = "--------------------------------------";
	public static String chanceToMissString = "Chance to Miss";
	public static String chanceToCriticalString = "Chance to Critical Hit";

}
