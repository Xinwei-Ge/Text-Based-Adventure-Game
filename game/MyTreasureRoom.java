package game;

public class MyTreasureRoom extends MyRoom implements TreasureRoom{
	String treasure;
	
	public MyTreasureRoom(String description, MyMonster monster, String treasure) {
		this.description = description;
		this.monster = monster;
		this.treasure = treasure;
	}
	
	
	@Override
	public void enter(MyPlayer player) {
		if (monster.isAlive()) {
			System.out.println("This Room is " + this.description + ", and has " + this.monster.getName() );
			System.out.println("You explored the room and found the hidden treasure!");
		}		
	}
	
}
