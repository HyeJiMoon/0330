/*
게임에 등장할 모든 객체의 최상위 클래스를 정의한다

왜? 상속을 이용하면 코드 중복을 방지할 수 있고,(bullet, player 다 int x~이거갖고있음)
최상위 클래스 자료형으로 자식들을 가리킬수도 있으므로, 코드가 유연해진다.*/

package game;

import java.awt.Graphics;
import java.awt.Rectangle;

abstract public class GameObject {
	ObjectManager objectManager; //게임오브젝트가 보유하면 자식도 가지고있게되는 거니까 
	ObjectId id; //모든 게임 객체에 할당될 아이디
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	Rectangle rect; //교차테스트에 써먹을 사각형 객체 
	
	public GameObject(ObjectManager objectManager,ObjectId id,int x,int y,int width,int height){ //자식 때 꼭 안써두돼?
		this.objectManager=objectManager;
		this.id=id; //어떤종류인지 구분하기 위함 
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		rect=new Rectangle(x, y, width, height);
		
		
	}
	
	abstract public void tick(); // tick은 다른데서 어떻게 사용될 지 모르자나 따라서 몸체를 주지말고 구현강제를 시키자
	abstract public void render(Graphics g);
	
	
}
