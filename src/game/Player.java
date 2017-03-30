/*
 이클래스는 sun에서 자체제작한 UI컴포넌트가 아니기 때문에 화면에 그려질 수 없다	(버튼과 달라)
 따라서 JPanel에 그려지려면 JPanel의 Graphics의 레퍼런스를 이 객체가 보유해야한다 
 */

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Player extends GameObject{
											/*is a 관계*/
	//float g; //중력은 소수점까지 해야 자연스럽
	
	public Player(ObjectManager objectManager,ObjectId id,int x, int y,int width, int height) { //velx,y는 키보드로 지정되니까 걍 값만 주면 ㅇㅋ
		//this.x=x;
		//this.y=y;
		//this.width=width;
		//this.height=height;
		super(objectManager,id,x,y,width,height); //위것이 다 ! 물려받으면 데자나!

		
	}
	//총알 발사 행위를 정의한다 player가 키보드 누를때 발사하니까 player 만들자
	public void fire(){
		Bullet bullet=new Bullet(objectManager,ObjectId.Bullet,x, y, 10, 10); //이때 objectmanager는 게임오브젝트 매개변수
			objectManager.addObject(bullet);
	}
	
	
	//x,y,width,height 등의 물리량 등의 변화를 제어하기 위한 메서드
	//사람과 비유하자면 운동량의 변화 
	public void tick() {
		//System.out.println("tick()");
		x+=velX;
		y+=velY;
		//과거의 x,y 따라서 사각형이 나를 따라다니게 하는 값의 동기화!
		rect.setBounds(x,y,width,height);
		
	}
	public void render(Graphics g){
		g.setColor(Color.WHITE);//페인트색 바꾸기 (배경색 검정이니까)
		//g.drawRect(x, y, width, height); //이미 받아놓은게 있으니 받을 필요없음
		//System.out.println("render()");
		Graphics2D g2=(Graphics2D)g;
		g2.draw(rect); //
	}

}
