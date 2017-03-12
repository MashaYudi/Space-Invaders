package space;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game {

	static JFrame frame = new JFrame("Invaders");
	static JFrame frame1 = new JFrame("Menu");
	static Menu m = new Menu();
	static Integer mResult=1;
	static GamePanel panel = new GamePanel();
	static State s = new State();
	//static MenuPanel mpanel = new MenuPanel();
	static Boolean LeftArrowPressed = false;
	static Boolean RightArrowPressed = false;
	static Boolean ProbelPressed = false;
	static Boolean MouseClicked = false;
	static KeyListener keyListener = new KeyListener() {
	//int w = 400;
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			if (arg0.getKeyCode() == 39) {
				RightArrowPressed = true;
				System.out.println("Right!");
			}
			if (arg0.getKeyCode() == 37) {
				LeftArrowPressed = true;
				System.out.println("Left!");
			}
			if (arg0.getKeyCode() == 32) {
				ProbelPressed = true;
				System.out.println("Piu!");
			}

		}
	};
	static MouseListener mouseListener = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			MouseClicked = true;
			frame1.setVisible(false);
			frame.setVisible(true);
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};

	public static void main(String[] args) throws Exception {

	/*	frame1.setSize(811, 608);
		frame1.add(panel);
		frame1.setResizable(false);
		frame1.setVisible(true);

		frame1.addMouseListener(mouseListener);
		frame1.setBackground(Color.BLACK);*/
		// panel.setLayout(new BorderLayout());
		frame.setSize(811, 608);
		frame.add(panel);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.addKeyListener(keyListener);

		frame.setBackground(Color.BLACK);
		//while (Game.MouseClicked == false) Thread.sleep(20);
		 runLogic();
		

	}

	private static void runLogic() throws InterruptedException {
		//mpanel.drawMenuPanel();
	//	mResult = m.makeMenu(mpanel);
	//	if (mResult == 0) 
	//	{
	//	frame.add(panel);
		
		while (true) {
			s = s.nextState();
			LeftArrowPressed = false;
			RightArrowPressed = false;
			ProbelPressed = false;
			panel.render(s);
			if(s.gameWon == true) {
				JOptionPane.showMessageDialog(null, "Вы выиграли!");
				System.exit(0);
			};
			Thread.sleep(40);
		}
	//	}
	}
	}


