package nl.rug.oop.introduction;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.Random;

public class Game {
	private Scanner var;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		GenerateDescriptions descriptions = new GenerateDescriptions();
		descriptions.addDescriptions();
		Player player = new Player("Alider");
		Room room = new Room("StartRoom");
		room.setPlayer(player);
		room.getPlayer().setHealth(999);
		room.getPlayer().setStrength(20);
		DungeonKeeper dK = new DungeonKeeper("Dungeon Keeper");
		room.addNPC(dK);
		GenerateMap map = new GenerateMap();
		map.generateMap(room, 0, descriptions);
		map.printMap();
		
		//game.generateMap(room,0,descriptions);
		/*;
		room.setPlayer(player);
		player.setHealth(999);
		Room room2 = new Room("Room2");
		Door door = new trapDoor("Trap door",room,room2);
		Door door2 = new lockedDoor("Blue door",room,room2);
		room.addDoor(door);
		room.addDoor(door2);
		room2.addDoor(door);
		NPC sandro = new NPC("Sandro");
		NPC crag_hack = new NPC("Crag Hack");
		room.addNPC(sandro);
		room.addNPC(crag_hack);*/
		game.playGame(room);
		
	}
	/*public static GenerateDescriptions addDescriptions(GenerateDescriptions descriptions) {
		descriptions.addDoorDescription("Blue Door");
		descriptions.addDoorDescription("Red Door");
		descriptions.addDoorDescription("Black Door");
		descriptions.addDoorDescription("Door with a skull");
		descriptions.addDoorDescription("Ancient door");
		
		descriptions.addNPCDescription("Sandro");
		descriptions.addNPCDescription("Crag Hack");
		descriptions.addNPCDescription("Solmir");
		descriptions.addNPCDescription("Adelaide");
		descriptions.addNPCDescription("Adela");
		descriptions.addNPCDescription("Gelu");
		descriptions.addNPCDescription("Cyra");
		descriptions.addNPCDescription("Xsi");
		descriptions.addNPCDescription("Loynis");
		
		descriptions.addRoomDescription("Cove");
		descriptions.addRoomDescription("Cave");
		descriptions.addRoomDescription("Cemetry");
		descriptions.addRoomDescription("Treasury");
		descriptions.addRoomDescription("Library");
		descriptions.addRoomDescription("Eating Hall");
		
		return descriptions;
	}*/
	/*public String getRandomItemFromList(List<String> list) {
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}
	
	public void generateMap(Room startRoom, int depthOfMap, GenerateDescriptions descriptions){
		int maxDepthOfMap = 5;
		Random rand = new Random();
		
		Room newRoom = new Room(getRandomItemFromList(descriptions.getRoomDescriptions()));
		switch (rand.nextInt(2)) {
		case 0:
			Door door = new Door(getRandomItemFromList(descriptions.getDoorDescriptions()),startRoom,newRoom);
			newRoom.addDoor(door);
			startRoom.addDoor(door);
			break;
		case 1:
			Door door2 = new trapDoor(getRandomItemFromList(descriptions.getDoorDescriptions()),startRoom,newRoom);
			newRoom.addDoor(door2);
			startRoom.addDoor(door2);
			break;
		case 2:
			Door door3 = new lockedDoor(getRandomItemFromList(descriptions.getDoorDescriptions()),startRoom,newRoom);
			newRoom.addDoor(door3);
			startRoom.addDoor(door3);
			break;
		}
		if (maxDepthOfMap > depthOfMap) {
			generateMap(newRoom,depthOfMap+1,descriptions);
		}
		
	}*/
	public void printActions() {
		System.out.println("(-1) Give up");
		System.out.println("(0) Look around");
		System.out.println("(1) Look for a way out");
		System.out.println("(2) Look for company");
		System.out.println("(3) QuickSave");
		System.out.println("(4) QuickLoad");
		System.out.println("(5) Save");
		System.out.println("(6) Load");
	}
	public void printNpcActions(String name) {
		System.out.println(" You can inspect(0), talk(1), attack(2) or persuade(3) " + name + " or do nothing(-1)");
		
	}
	public int getInput() {
		var = new Scanner(System.in);
		try {
			return var.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("Please chooce an option from the screen");
			return getInput();
		} 
	}
	
	public void playGame(Room room) {
		int i = 0;
		List<NPC> removeList = new ArrayList<>();
		for (NPC allNPCs:room.getNPCs()) {
			if (allNPCs.getHealth() <= 0) {
				System.out.println(allNPCs.getName()+" died");
				removeList.add(allNPCs);
			}
		}
		//Removing dead NPCs
		room.getNPCs().removeAll(removeList);
		for (int j=0;j<removeList.size();j++) {
			removeList.remove(j);
		}
		System.out.println("------------------------------------------------------");
		System.out.println("Your Health: " + room.getPlayer().getHealth());
		System.out.println("Your strength: " + room.getPlayer().getStrength() );
		System.out.println("You have " + room.getPlayer().getLockPick()+" lockpicks");
		System.out.println("------------------------------------------------------");
		if (room.getPlayer().getHealth() <= 0) {
			System.out.println("Wasted");
			return;
		}
		printActions();
		switch (getInput()) {
		case -1:
			System.out.println("You gave up");
			break;
		case 0:
			room.inspect();
			playGame(room);
			break;
		case 1:
			/*int size = room.getDoors().size();
			for (int i=0; i < size; i++) {
				
			}*/
			i = 0;
			
			for (Door allDoors:room.getDoors()) {
				System.out.println("("+i+") "+allDoors.getDescription());
				i++;
			}
			System.out.println("Which door do you take ? ( -1 : stay here) ");
			int doorChoice = getInput();
			if (doorChoice==-1) {
				playGame(room);
			}else if(doorChoice > i-1) {
				System.out.println("It seems you walked into a wall");
				playGame(room);
			}else {
				//playGame(room.getThroughDoor(room.getDoors().get(doorChoice)));
				playGame(room.getDoors().get(doorChoice).getThrough(room));
				
			}
			break;
		case 2:
			i = 0;
			for (Character allChar:room.getNPCs()) {
				System.out.println("("+i+") "+allChar.getName());
				i++;
			}
			if (i==0) {
				System.out.println("You are alone in this room");
				playGame(room);
			}else {
				System.out.println("With whom do you want to interact ? ( -1 : do nothing) ");
				int charChoice = getInput();
				if (charChoice == -1) {
					playGame(room);
				}else if (charChoice > i-1) {
					System.out.println("You tried to talk to a person, but he vanished in the air. Maybe he was your hallucination... ");
					playGame(room);
				}else {
					printNpcActions(room.getNPCs().get(charChoice).getName());
					switch (getInput()) {
					case -1: 
						playGame(room);
						break;
					case 0:
						room.getNPCs().get(charChoice).inspect();
						playGame(room);
						break;
					case 1:
						room.getNPCs().get(charChoice).talk();
						playGame(room);
						break;
					case 2:
						if (room.getNPCs().get(charChoice).getFriendly()==true) {
							System.out.println("You are going to attack a friendly NPC. If you attack him he will be hostile to you. This action is irreversible.(Type -1 if you want to stop and attack, any other number otherwise");
						if (getInput()==-1)
							playGame(room);
						}
						
						
						room.getNPCs().get(charChoice).attacked(room.getPlayer());
						playGame(room);
						break;
					case 3:
						room.getNPCs().get(charChoice).persuade(room.getPlayer());
						playGame(room);
						break;
					default:
						System.out.println("You tried to perform ancient Zulu dance but "+ room.getNPCs().get(charChoice).getName() +" didn't respond. Maybe you should select more conventional action");
						playGame(room);
						break;
					}
					
				}
			}
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		default: 
			System.out.println("It seems you've chosen an incorrect action");
			playGame(room);
			break;
		
		}
	}
	
}
	
