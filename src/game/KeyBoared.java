/*  cf) 얻어오자!! ==> 메서드!!! 
 플레이어의 움직임을 제어하자
 주인공에게는 해봤자 의미없어
 
 이 키는 패널에! ! 
 */

package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoared extends KeyAdapter{
	Player player;
	//Bullet bullet;
	
	
	public KeyBoared(Player player) {//받아와야지 
		this.player=player;
	}
	
	//키보드누르면
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();

		switch (key) { //소괄호안의 값에 대해 조건을 따져보겠다 
		
			case KeyEvent.VK_LEFT:
				player.velX=-2;break; //case 문을 끝내겠다는 break
			case KeyEvent.VK_RIGHT:
				player.velX=2;break;
			case KeyEvent.VK_UP:
				player.velY=-2;break;
			case KeyEvent.VK_DOWN:
				player.velY=2;break;
			case KeyEvent.VK_SPACE:
				//총알생성코드
				player.fire();break;
				
		}
	}
  
   	//키보드 눌렀다 뗄때 
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		
		switch (key) { 
		
		case KeyEvent.VK_LEFT:
			player.velX=0;break; //case 문을 끝내겠다는 break
		case KeyEvent.VK_RIGHT:
			player.velX=0;break;
		case KeyEvent.VK_UP:
			player.velY=0;break;
		case KeyEvent.VK_DOWN:
			player.velY=0;break;
			
			
	}
	
			
	}

}
