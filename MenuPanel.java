package space;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class MenuPanel  extends JPanel {

	int w = 811;
	int h = 608;
	
public	void drawMenuPanel (){
		Graphics2D g2 = (Graphics2D) this.getGraphics();
		g2.setBackground(Color.BLACK);
		Image imgNew_Game = Toolkit.getDefaultToolkit().getImage("C://NewGame.jpeg");
		g2.drawImage(imgNew_Game, 300, 300, this );
	}

}
