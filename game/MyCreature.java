package game;


public class MyCreature extends java.lang.Object implements Creature{
	private String name;
	private String description;
	private int hitPoints;
	private int damage;
	//private MyRoom room;
	
	public MyCreature() {
		name = "";
		description = "";
		hitPoints = 0;
		damage = 0;
		//room = null;
	}
	
	public MyCreature(String name, String description, int hitPoints, int damage) {
		this.name = name;
		this.description = description;
		this.hitPoints = hitPoints;
		this.damage = damage;
		//this.room = null;
	}
	
	
	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		if(hitPoints <0) {
			this.hitPoints =0;
		}
		this.hitPoints += hitPoints;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	/*public Room getRoom() {
		return room;
	}*/

	/*public void setRoom(MyRoom room) {
		this.room = room;
	}*/

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public void attack(MyCreature creature) {
		System.out.println(this.name + " attacks target " + creature.name + ", dealing " + this.damage + " damage");		
	}

	@Override
	public boolean isAlive() {
		if (hitPoints > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void takeDamage(int damage) {
		if (damage > 0) {
			hitPoints = hitPoints - damage;
		}
		if (hitPoints < 0) {
			hitPoints = 0;
		}		
	}
	
	public java.lang.String toString() {
		return "name %15s, description %20s, hitPoints %03d, damage %02d";
	}
}
