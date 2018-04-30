package nl.rug.oop.introduction;

public class Door extends Inspectable implements Interactable {
	private Room leadsTo;
	public Room getLeadsTo() {
		return leadsTo;
	}

	public void setLeadsTo(Room leadsTo) {
		this.leadsTo = leadsTo;
	}

	public Door ( String description ) {
		super (description) ;
	 }

	@Override
	public void interact() {
		// TODO Auto-generated method stub
		
	}
	public void goThrough(Door door) {
		
	}
}
