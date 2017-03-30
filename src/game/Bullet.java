//�Ѿ��� ����

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bullet extends GameObject{ //bullet�� ������ �ִ�  int x, y ,width �� �̷��� �� ���ӿ������v���� ���־�!
								//is a ����!!!!
	public Bullet(ObjectManager objectManager,ObjectId id,int x,int y,int width,int height) {
		//this.x=x;
		//this.y=y;
		//this.width=width;
		//this.height=height;
		
		super(objectManager,id,x,y,width,height);   
		
		velX=4; //���ΰ� 2�� �����̴ϱ� �� ������
	}
	
	public void tick(){
		x+=velX;
		rect.setBounds(x, y, width, height);
	
		//������ ���� �����ϸ� , �Ѵ� �ױ� -->ObjectManager��ܿ��� ��������
		for(int i=0;i<objectManager.list.size();i++){//������ ������ �� �ִ� ī�װ��� �ʿ��� object manager���� �°� �͵��� �� ������ڳ� ���� ������ �̸����� �ַ��ϴµ�
																		//�̸��� �Ѵ޵ڿ� ���� ������ϱ� ����� �ַ��Ѵ�. �ٵ� ����� ������ ������ ������ �� �� �ִµ�, �װ� �Ẹ�� ����� �迭��->
			GameObject obj=objectManager.list.get(i);
			if(obj.rect.intersects(rect)){
			if(obj.id==ObjectId.Enemy){
				//�浹�ϸ�
					objectManager.list.remove(obj);//���װ�
					objectManager.list.remove(this); //������ 
				}
			}
		//rect.intersects(/*�����ǻ簢��*/rect)
		}
	}
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		
		Graphics2D g2=(Graphics2D)g;
		g2.fillOval(x, y, width, height);
	}
}
