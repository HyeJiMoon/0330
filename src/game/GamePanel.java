/*��� ������ �� �гξȿ��� �׷��� �����̴�
�ƹ��� ������ ����� �پ��ϴ���, �г��� ���� 1���� ���ȴ�

��� ������Ʈ�� �ᱹ �� �гο� �׷������ϹǷ�, �� �г��� paint�޼����� �μ��� ���޵Ǵ� Graphics��ü��
���ӿ� ������ ��� ������Ʈ�� ���޹޾ƾ� �Ѵ�

*/
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;
																					//�����̹� ������ �ڽ��϶� runnable�� ������ �ƴϾ� ���� �������༭ ���
public class GamePanel extends JPanel implements Runnable {
	//��� : ������
	public static final int WIDTH=400;
	public static final int HEIGHT=300;
	public static final int SCALE=2;
	boolean flag=true; //���Ӱ������θ� �����ϴ� ����
	Thread thread; //���ӿ������ 
	Player player;
	ObjectManager objectManager; //��ü��� ������ (���͵��� ���Ե� �����ͺ��̽�)
	
	
	//������ ������ �� �� ! 
		
		public GamePanel(){
			thread=new Thread(this); //this =runnable
			thread.start();
			
			init();
			
			setPreferredSize(new Dimension(WIDTH*SCALE ,HEIGHT*SCALE));//ũ������
				
		}
		
		
		public void init(){
			//��� ������ ����
			objectManager=new ObjectManager();
			
			//���ΰ� �����Ű�� 
			player=new Player(objectManager,ObjectId.Player,100, 200, 50, 50);
			objectManager.addObject(player);//1���߰�
			
			//��������
			Random r=new Random();
			for(int i=0;i<10;i++){
				int y=r.nextInt((HEIGHT*SCALE-50)-(50)+1)+50;
				int x=r.nextInt((WIDTH*SCALE+500)-(WIDTH*SCALE+1))+50;
				Enemy enemy = new Enemy(objectManager, ObjectId.Enemy,x, y, 30,30);
				objectManager.addObject(enemy);
			}
			//�гΰ� Ű���� ������ ����
			this.addKeyListener(new KeyBoared(player));
			
		}
		
		protected void paintComponent(Graphics g){
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
			
			for(int i=0; i<objectManager.list.size();i++){
				GameObject obj=objectManager.list.get(i);
				obj.render(g); 
				
			}
		
			//player.render(g);
			
	}
		
		public void run() {
			while(flag){//���������� ���ϸ� flag�� �������´�
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				//System.out.println("����־��");
				
				//������Ʈ�Ŵ����� ��ϵ� ���~��ü���� ������� tick()�� ȣ���غ��� ! �ؤ��� �ּ��� tick �� player �ϳ� 
				for(int i=0; i<objectManager.list.size();i++){
					GameObject obj=objectManager.list.get(i);
					obj.tick();
					
				}
				                    
				//player.tick();
				//player.render(g); ��� �Ұ� g�� �����ִ�paintComponent���� ����
				repaint();//paintComponenet�� ����ȣ�� 
				//�Ѿ��� tick ,render �̰Ÿ� ��� �� �ϳ��� ȣ���Ҽ� ���� ��? �Ұ��� �ϴ� ���� Object Manager ���� ��� �͵��� �� ������ ����ū ������ ��ü�� ������ 
				//������ tick, render
				//������ tick ,render
			}
		}

}




//Graphics ��ü�� ������ ��ҵ��� �����ؼ� ������;��� ��� ������Ʈ�� Graphics��ü
//������ �ϳ� ! ! ���ְ� ������ ������ �ٵ� �۵��Ϸ��ؼ� ȭ�� ���ڰŸ� ���� tick(���� ������) render(�׷���-->Graphics) 
//