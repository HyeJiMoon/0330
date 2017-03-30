/*
 ��Ŭ������ sun���� ��ü������ UI������Ʈ�� �ƴϱ� ������ ȭ�鿡 �׷��� �� ����	(��ư�� �޶�)
 ���� JPanel�� �׷������� JPanel�� Graphics�� ���۷����� �� ��ü�� �����ؾ��Ѵ� 
 */

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Player extends GameObject{
											/*is a ����*/
	//float g; //�߷��� �Ҽ������� �ؾ� �ڿ�����
	
	public Player(ObjectManager objectManager,ObjectId id,int x, int y,int width, int height) { //velx,y�� Ű����� �����Ǵϱ� �� ���� �ָ� ����
		//this.x=x;
		//this.y=y;
		//this.width=width;
		//this.height=height;
		super(objectManager,id,x,y,width,height); //������ �� ! ���������� ���ڳ�!

		
	}
	//�Ѿ� �߻� ������ �����Ѵ� player�� Ű���� ������ �߻��ϴϱ� player ������
	public void fire(){
		Bullet bullet=new Bullet(objectManager,ObjectId.Bullet,x, y, 10, 10); //�̶� objectmanager�� ���ӿ�����Ʈ �Ű�����
			objectManager.addObject(bullet);
	}
	
	
	//x,y,width,height ���� ������ ���� ��ȭ�� �����ϱ� ���� �޼���
	//����� �������ڸ� ����� ��ȭ 
	public void tick() {
		//System.out.println("tick()");
		x+=velX;
		y+=velY;
		//������ x,y ���� �簢���� ���� ����ٴϰ� �ϴ� ���� ����ȭ!
		rect.setBounds(x,y,width,height);
		
	}
	public void render(Graphics g){
		g.setColor(Color.WHITE);//����Ʈ�� �ٲٱ� (���� �����̴ϱ�)
		//g.drawRect(x, y, width, height); //�̹� �޾Ƴ����� ������ ���� �ʿ����
		//System.out.println("render()");
		Graphics2D g2=(Graphics2D)g;
		g2.draw(rect); //
	}

}
