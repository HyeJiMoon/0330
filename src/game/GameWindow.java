package game;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	GamePanel gamePanel;
	
	public GameWindow() {
		
		gamePanel = new GamePanel();
		add(gamePanel);
		
		//�гο� ���α׷��������� ��Ŀ�� �ø��� ��Ŀ���� �P��� �гο� �ȳ��� 
		gamePanel.setFocusable(true);
		
		pack(); //�����츦 ���빰 ũ�⿡ ���� ���� 
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	
	public static void main(String[] args) {
		new GameWindow();
	}

}
