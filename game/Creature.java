package game;

public interface Creature {
	void attack (MyCreature creature);
	boolean isAlive();
	void takeDamage(int damage);
	java.lang.String toString();
	
}
