package space;

import java.util.LinkedList;
import java.util.List;

public class State {

	LinkedList<Invader> invadersList = new LinkedList<>();
	LinkedList<Bullet> bulletList = new LinkedList<>();
	Gun gun;
	Boolean gameOver = false;
	Boolean gameWon = false;
	int direction=1;
	State() {
		this.gun = new Gun();
		for (int i = 0; i < 8; i++) {
			this.invadersList.add(new Invader(81 * i + 70, 41));
		}
		for (int i = 0; i < 8; i++) {
			this.invadersList.add(new Invader(81 * i + 70, 100));
		}

	}

	State(Gun gun, Boolean gOver, Boolean gWon,
			LinkedList<Invader> invadersList, LinkedList<Bullet> bulletList, int direction) {
		this.gun = gun;
		this.invadersList = invadersList;
		this.bulletList = bulletList;
		gameOver = gOver;
		gameWon = gWon;
		this.direction = direction;
	}

	int w = 811;
	int s = 15;
 
	State nextState() {

		if (Game.LeftArrowPressed) {
			if((this.gun.x - 1 * s)>0) this.gun.x -= 1 * s ;
		}
		if (Game.RightArrowPressed) {
			if((this.gun.x + 1 * s)<729) this.gun.x += 1 * s ;
		}
		if (Game.ProbelPressed) {
			this.bulletList.add(new Bullet(this.gun.x+38));
		}
		Gun newGun = new Gun(this.gun.x % w);
		Boolean newGWon = false;
		Boolean newGOver = false;
		if (invadersList.isEmpty()) {
			newGWon = true;
		}

	
		if (!invadersList.isEmpty()) {
			if((invadersList.getLast().x>=729) || (invadersList.getFirst().x <=0)){
				direction=(direction+1)%2;
				System.out.println("hey!");
			}
			for (int i = invadersList.size()-1; i >= 0; i--) {
				if (direction==0) {
					
					invadersList.get(i).x = invadersList.get(i).x + 5;
				}
				else
				{invadersList.get(i).x = invadersList.get(i).x - 5;}
		}
		}

		if (!bulletList.isEmpty()) {
			for (int i = 0; i < bulletList.size(); i++) {
				bulletList.get(i).y -= 40;
				if (bulletList.get(i).y < 0) {
					bulletList.remove(i);
				}
			}
		}
		if (!bulletList.isEmpty() && !invadersList.isEmpty())
			for (int i = 0; i < invadersList.size(); i++) {
				for (int j = 0; j < bulletList.size(); j++) {
					if (bulletList.get(j).x >=
							invadersList.get(i).x /*index out of bounds exception*/
							&& bulletList.get(j).x <= invadersList.get(i).x + 81
							&& (bulletList.get(j).y <= invadersList.get(i).y + 41 && bulletList.get(j).y >= invadersList.get(i).y)) {
						bulletList.remove(j);
						invadersList.remove(i);
					}
				}
			}

		State generatedState = new State(newGun, newGOver, newGWon,
				invadersList, bulletList, direction);
		return generatedState;
	}

}
