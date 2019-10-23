package game;

public class MyRoom implements Room{
	
	int roomIndex;
	String description;
	MyMonster monster;
	MyPlayer player;
		
	public MyRoom() {	
	}
	
	public MyRoom (int roomIndex, String description, MyMonster monster) {
		this.roomIndex = roomIndex;
		this.description = description;
		this.monster = monster;
	}
	
	public String getRoomDescription () {
		return this.description;
	}
	
	public void enter(MyPlayer player) {
		if (monster.isAlive()) {
			System.out.println("This room is " + this.description + ", and has " + this.monster.getName());	
		}		
	}

	public boolean isComplete() {
		if(!monster.isAlive()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public java.lang.String toString() {
		return "Room index %2d, description %20s, monster name %20s";
	}

}