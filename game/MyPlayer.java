package game;

public class MyPlayer extends MyCreature implements Player{
	private int healAmount;
	
	public MyPlayer (String name, String description, int hitPoints, int damage, int healAmount) {
		super(name,description,hitPoints,damage);
		this.healAmount = healAmount;
	}

	@Override
	public void heal() {
		setHitPoints(this.healAmount) ;  
		System.out.println(getName() + " is healed by " + this.healAmount);
		
		// TODO Auto-generated method stub
		
	}
	
	
}
