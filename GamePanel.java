package space;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	int w = 811;
	int h = 608;
	int hGun = h - 102;
		
	private Color randomColor() {
		Random r = new Random();
		return (new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
	}

	public void render(State s) {
		
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		//g2d.setBackground(Color.BLACK);
		//g2d.clearRect(0, 0, w, h);
		Image img = Toolkit.getDefaultToolkit().getImage("C://cosmos.jpeg");
		g2d.drawImage(img, 0, 0, this );
		  
		if(s.gameWon){
			g2d.setBackground(Color.YELLOW );
		}
		else{
		Gun gun = s.gun;
		if (gun != null) {
			Image img1 = Toolkit.getDefaultToolkit().getImage("C://Enterpraise.png");
			g2d.drawImage(img1, gun.x, hGun, this );
			//g2d.setPaint(Color.BLUE);
			//g2d.fillRect(gun.x, hGun, 50, 50);
			
		}
		LinkedList<Invader> invadersList = s.invadersList;
		if (!invadersList.isEmpty()) {
			g2d.setPaint(Color.WHITE);
			for (int i = 0; i <= invadersList.indexOf(invadersList.getLast()); i++) {
				Image img2 = Toolkit.getDefaultToolkit().getImage("C://nlo_resizes.png");
				g2d.drawImage(img2, invadersList.get(i).x, invadersList.get(i).y, this );
				//g2d.fillRect(invadersList.get(i).x, invadersList.get(i).y, 20, 40);
			}
		}

		LinkedList<Bullet> bulletList = s.bulletList;
		if (!bulletList.isEmpty()) {
			for (int i = 0; i < bulletList.size(); i++) {
				g2d.fillRect(bulletList.get(i).x, bulletList.get(i).y, 4, 15);
			}
				}
	}
	}
}

