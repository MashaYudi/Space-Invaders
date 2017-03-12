package space;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;



public class Menu {
	
	
	
	public Integer makeMenu (MenuPanel panel) throws InterruptedException  {
	
	/*Graphics2D g2 = (Graphics2D) panel.getGraphics();
	g2.setBackground(Color.BLACK);
	Image imgNew_Game = Toolkit.getDefaultToolkit().getImage("C://NewGame.jpeg");
	g2.drawImage(imgNew_Game, 300, 300, panel );*/
	
	while (Game.MouseClicked == false) Thread.sleep(20);
	if(Game.MouseClicked == true) return 0;
	 
	return null;
	
	}
}
	

