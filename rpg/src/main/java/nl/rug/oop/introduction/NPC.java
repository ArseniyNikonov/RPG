package nl.rug.oop.introduction;

public class NPC extends Character implements NPCactions{
	public NPC(String name) {
		super(name);
	}
	public NPC(String name,int health) {
		super(name,health);
	}
	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"sing loudly");
		
	}
	@Override
	public void dance() {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"dances");
	}
	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"jumps");
	}
	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("Hi, my name is "+this.getName());
	}
	
}
