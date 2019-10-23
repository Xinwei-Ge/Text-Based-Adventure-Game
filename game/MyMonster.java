package game;

public class MyMonster extends MyCreature implements Monster{
	boolean isEnraged = false;
	int enrageThreshold;
	
	public MyMonster (String name, String description, int hitPoints, int damage, int enrageThreshold) {
		super(name,description,hitPoints,damage);
		this.enrageThreshold = enrageThreshold;
	}
	
	public boolean canEnrage() {
		if (getHitPoints() < this.enrageThreshold && isEnraged == false) {
			return true;
		}
		else {
			return false;
		}
	}

	public void enrage() {
		if (this.isEnraged == false) {
			setDamage(getDamage() * 2);
			this.isEnraged = true;
			System.out.println(getName()+ " has been enraged");
		}
		// TODO Auto-generated method stub
		
	}

}
