package game;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	GamePanel gamePanel;
	
	public GameWindow() {
		
		gamePanel = new GamePanel();
		add(gamePanel);
		
		//패널에 프로그래밍적으로 포커스 올리기 포커스를 뻇어가서 패널에 안나와 
		gamePanel.setFocusable(true);
		
		pack(); //윈도우를 내용물 크기에 따라 조정 
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	
	public static void main(String[] args) {
		new GameWindow();
	}

}
