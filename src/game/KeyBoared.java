/*  cf) ������!! ==> �޼���!!! 
 �÷��̾��� �������� ��������
 ���ΰ����Դ� �غ��� �ǹ̾���
 
 �� Ű�� �гο�! ! 
 */

package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoared extends KeyAdapter{
	Player player;
	//Bullet bullet;
	
	
	public KeyBoared(Player player) {//�޾ƿ;��� 
		this.player=player;
	}
	
	//Ű���崩����
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();

		switch (key) { //�Ұ�ȣ���� ���� ���� ������ �������ڴ� 
		
			case KeyEvent.VK_LEFT:
				player.velX=-2;break; //case ���� �����ڴٴ� break
			case KeyEvent.VK_RIGHT:
				player.velX=2;break;
			case KeyEvent.VK_UP:
				player.velY=-2;break;
			case KeyEvent.VK_DOWN:
				player.velY=2;break;
			case KeyEvent.VK_SPACE:
				//�Ѿ˻����ڵ�
				player.fire();break;
				
		}
	}
  
   	//Ű���� ������ ���� 
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		
		switch (key) { 
		
		case KeyEvent.VK_LEFT:
			player.velX=0;break; //case ���� �����ڴٴ� break
		case KeyEvent.VK_RIGHT:
			player.velX=0;break;
		case KeyEvent.VK_UP:
			player.velY=0;break;
		case KeyEvent.VK_DOWN:
			player.velY=0;break;
			
			
	}
	
			
	}

}
