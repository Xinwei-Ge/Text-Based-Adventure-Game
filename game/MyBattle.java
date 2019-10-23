package game;

import java.util.Scanner;

public class MyBattle implements Battle{
	private MyPlayer player;
	private MyMonster monster;
	Scanner kb = new Scanner(System.in);
	
	public MyBattle (MyPlayer player , MyMonster monster) {
		this.player = player;
		this.monster = monster;
	}
	
	public void run() {
		System.out.println("Battle begins: " + player.getName() + " vs. " + monster.getName());
		
		while (player.isAlive() && monster.isAlive()) {
			battle();
		}
		if (player.isAlive()) {
			System.out.println("You have defeated " + monster.getName() + "!!!");
		}
		else {
			System.out.println("Oh no! Game Over :( Try again?");
		}
	}
	
	public void battle() {
		System.out.println("Your HP: " + player.getHitPoints());
		System.out.println(monster.getName() + "\' HP: " + monster.getHitPoints());
		System.out.println("what would you like to do?");
		System.out.println("(a) Attack     (h) Heal");
		String input = kb.next().toLowerCase();
		while (!input.equals("a") && !input.equals("h") && !input.equals("attack") && !input.equals("heal")) {
			System.out.println("command not recognized please re-enter");
			input = kb.next().toLowerCase();
		}
		
		if (input.equals("a") || input.equals("attack")) {
			player.attack(monster);
			monster.takeDamage(player.getDamage());
		}
		else {
			player.heal();
		}
		
		if (monster.isAlive()) {
			if(monster.canEnrage()) {
				monster.enrage();
				System.out.println(monster.getName() + " is now enraged!");
			}
			monster.attack(player);
			player.takeDamage(monster.getDamage());
		}
		
	}
	

}
