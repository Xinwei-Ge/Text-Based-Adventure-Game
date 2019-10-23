package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.PrintStream;
//import files.TextFileHandler;

public class MyGame implements Game{
	private MyPlayer player;
	private MyRoom[] dungeon;
	private MyBattle [] battles;
	private MyBattle battle1;
	private MyBattle battle2;
	private MyBattle battle3;
	private MyMonster monster1;
	private MyMonster monster2; 
	private MyMonster monster3;
	private MyRoom room1;
	private MyRoom room2;
	private MyTreasureRoom room3;
	
	public MyGame() {
		
		
		
		
		File Info = new File("D:\\eclipse_workplace\\CMP_2\\src\\game\\PlayerInfo.txt");
		
		if(Info.exists()) {
			System.out.println("File found");
		} else {
			System.out.println("File not found");
		}
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Info));
			String name = reader.readLine();
			String description =reader.readLine();
			int hitPoints = Integer.parseInt(reader.readLine());
			int damage = Integer.parseInt(reader.readLine());
			int healAmount = Integer.parseInt(reader.readLine());
				
			player = new MyPlayer(name,description,hitPoints,damage,healAmount);
			
			} catch (IOException e) {
				System.out.print(e.getMessage());
			} 
			
		monster1 = new MyMonster ("Orc", "covered with green blood", 20, 5, 0);
		battle1 = new MyBattle(player, monster1);
		room1 = new MyRoom(0, "a room with an unbearable smell", monster1);
		monster2 = new MyMonster ("Skeleton", "funny how it moves", 40, 10, 10);
		battle2 = new MyBattle(player, monster2);
		room2 = new MyRoom(1, "dark and cold", monster2);
		monster3 = new MyMonster ("Fire dragon", "spout fire with each breath", 100, 20, 40);
		room3 = new MyTreasureRoom ("a giant hall with something shiny on the other end", monster3, "a large pile of gold");
		battle3 = new MyBattle(player, monster3);
		dungeon = new MyRoom[] {room1,room2,room3};
		battles = new MyBattle [] {battle1,battle2,battle3};
		
	}

	

	@Override
	public void play() {
		/*
		File file = new File("D:\\eclipse_workplace\\CMP_2\\src\\game\\GameLog.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		*/
		File file = new File("D:\\eclipse_workplace\\CMP_2\\src\\game\\GameLog.txt");
		/*
		FileWriter fr = null;
		try {
			fr = new FileWriter(file, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedWriter br = new BufferedWriter(fr);
		 */
		
		System.out.println(player.getName() + " " + player.getDescription());
		
		for (int i = 0 ; i < dungeon.length ; i++) {
			dungeon[i].enter(player);
			battles[i].run();
			//br.write("Player has killed the monster!");
			}
		
		if (player.isAlive()) {
			System.out.println("You explored the room and found the hidden treasure!");
			System.out.println("A pile of gold!");
		}
		
		}	
	public static void main(String[] args) {
		
		MyGame one = new MyGame();
		one.play();
		
	}
}
