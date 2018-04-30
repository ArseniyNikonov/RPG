package nl.rug.oop.introduction;
import java.util.ArrayList;
import java.util.List;

public class Room extends Inspectable {
	private List<Door> Doors = new ArrayList<Door>();
	private List<NPC> NPCs = new ArrayList<NPC>();
	public List<Door> getDoors() {
		return Doors;
	}
	public void setDoors(List<Door> doors) {
		Doors = doors;
	}
	
	public List<NPC> getNPCs() {
		return NPCs;
	}
	public void setNPCs(List<NPC> nPCs) {
		NPCs = nPCs;
	}
	public Room ( String description ) {
		super (description) ;
	 }
		
	public void addDoor(Door d) {
		Doors.add(d);
	}
	public void addNPC(NPC n) {
		NPCs.add(n);
	}
	
	
}