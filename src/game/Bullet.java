//총알을 정의

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bullet extends GameObject{ //bullet이 가지고 있던  int x, y ,width 등 이런거 다 게임오브젝틍한테 가있어!
								//is a 관계!!!!
	public Bullet(ObjectManager objectManager,ObjectId id,int x,int y,int width,int height) {
		//this.x=x;
		//this.y=y;
		//this.width=width;
		//this.height=height;
		
		super(objectManager,id,x,y,width,height);   
		
		velX=4; //주인공 2씩 움직이니까 더 빠르게
	}
	
	public void tick(){
		x+=velX;
		rect.setBounds(x, y, width, height);
	
		//적군과 내가 교차하면 , 둘다 죽기 -->ObjectManager명단에서 없어지게
		for(int i=0;i<objectManager.list.size();i++){//종류를 구분할 수 있는 카테고리가 필요해 object manager에는 온갖 것들이 다 들어있자나 따라서 각각의 이름값을 주려하는데
																		//이름은 한달뒤에 보면 까먹으니까 상수로 주려한다. 근데 상수도 순서를 가지는 집합을 할 수 있는데, 그걸 써보자 상수를 배열로->
			GameObject obj=objectManager.list.get(i);
			if(obj.rect.intersects(rect)){
			if(obj.id==ObjectId.Enemy){
				//충돌하면
					objectManager.list.remove(obj);//너죽고
					objectManager.list.remove(this); //나죽자 
				}
			}
		//rect.intersects(/*적군의사각형*/rect)
		}
	}
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		
		Graphics2D g2=(Graphics2D)g;
		g2.fillOval(x, y, width, height);
	}
}
