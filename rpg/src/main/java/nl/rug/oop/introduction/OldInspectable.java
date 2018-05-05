package nl.rug.oop.introduction;

import java.util.Scanner;

abstract public class Inspectable {
	private String description;
	private String actions[];
	private Scanner var;

	public Inspectable(String description) {
		this.description = description;
	}

	public String[] getActions() {
		return actions;
	}

	public void setActions(String[] actions) {
		this.actions = actions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void inspectRoom(Room r) {
		for (int i = 0; i < (r.getActions()).length; i++) {
			if (actions[i] != null) {
				System.out.println("(" + i + ")" + actions[i]);
			}
		}
		var = new Scanner(System.in);
		int choice = var.nextInt();
		switch (choice) {
		case 0:
			System.out.println(r.getDescription());
			r.inspectRoom(r);
			break;
		case 1:
			int size = r.getDoors().size();
			for (int i = 0; i < size; i++) {
				System.out.println("(" + i + ")" + ((r.getDoors()).get(i)).getDescription());

			}
			System.out.println("Which door do you take ? ( -1 : stay here) ");
			int chosenDoor = var.nextInt();
			if (chosenDoor == -1) {
				r.inspectRoom(r);
			} else {
				r.getDoors().get(chosenDoor).getLeadsTo().inspectRoom(r.getDoors().get(chosenDoor).getLeadsTo());
			}
			break;
		case 2:
			// System.out.println("Looking for company");
			int numberOfNpc = r.getNPCs().size();
			if (numberOfNpc == 0) {
				System.out.println("You are alone in this room");
				System.out.println("--------------------------");
				r.inspectRoom(r);
				break;
			}
			for (int i = 0; i < numberOfNpc; i++) {
				System.out.println("(" + i + ")" + ((r.getNPCs()).get(i)).getName());

			}

			System.out.println("With whom do you want to talk ? ( -1 : with noone) ");
			int chosenNPC = var.nextInt();
			if (chosenNPC == -1) {
				r.inspectRoom(r);

			} else {
				r.getNPCs().get(chosenNPC).talk();
				r.inspectRoom(r);

			}
			break;
		case 3:
			System.out.println("See you next time");
		default:
			;
		}
	}
}
