package nl.rug.oop.introduction;
//Class for player

//Class for room

public class Main{
	public static void main(String[] args) {
		String[] act;
		act =new String[5];
		
		act[0]="Look around";
		act[1]="Look for a way out";
		act[2]="Look for a company";
		act[3]="Leave game";
		
		Room aRoom = new Room("Start Room");
		Room bRoom = new Room("Cove");
		Room cRoom = new Room("Shop");
		Room dRoom = new Room("Cemetry");
		
		aRoom.setActions(act);
		bRoom.setActions(act);
		cRoom.setActions(act);
		dRoom.setActions(act);
		
		Door aToB = new Door("Suspicious Door");
		aToB.setLeadsTo(bRoom);
		Door bToA = new Door("Suspicious Door");
		bToA.setLeadsTo(aRoom);
		
		Door aToD = new Door("Door with a skull");
		aToD.setLeadsTo(dRoom);
		Door dToA = new Door("Door with a skull");
		dToA.setLeadsTo(aRoom);
		
		Door bToC = new Door("Fancy door");
		bToC.setLeadsTo(cRoom);
		Door cToB = new Door("Fancy door");
		cToB.setLeadsTo(bRoom);
		
		Door cToD = new Door("Backdoor of the shop");
		cToD.setLeadsTo(dRoom);
		Door dToC = new Door("Backdoor of the shop");
		dToC.setLeadsTo(cRoom);
		
		aRoom.addDoor(aToB);
		aRoom.addDoor(aToD);
		bRoom.addDoor(bToA);
		bRoom.addDoor(bToC);
		cRoom.addDoor(cToD);
		cRoom.addDoor(cToB);
		dRoom.addDoor(dToC);
		dRoom.addDoor(dToA);
		
		NPC sandro = new NPC("Sandro");
		dRoom.addNPC(sandro);
		NPC cragHack = new NPC("CragHack",20);
		dRoom.addNPC(cragHack);
		NPC shopkeeper = new NPC("Shopkeeper");
		cRoom.addNPC(shopkeeper);
		
		aRoom.inspectRoom(aRoom);
	}
}
