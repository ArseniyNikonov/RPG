package nl.rug.oop.introduction;

public class Player extends Character {
	private int lockPick = 999;
	
	
	public int getLockPick() {
		return lockPick;
	}


	public void setLockPick(int lockPick) {
		this.lockPick = lockPick;
	}


	public Player(String name) {
		super(name);
	}
	
}
