/*모든 게임은 이 패널안에서 그려질 예정이다
아무리 게임의 장면이 다양하더라도, 패널은 오직 1개만 사용된다

모든 오브젝트는 결국 이 패널에 그려져야하므로, 이 패널의 paint메서드의 인수로 전달되는 Graphics객체를
게임에 등장할 모든 오브젝트가 전달받아야 한다

*/
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;
																					//내가이미 누구의 자식일때 runnable은 쓰레드 아니야 따라서 선언해줘서 사용
public class GamePanel extends JPanel implements Runnable {
	//상수 : 직관성
	public static final int WIDTH=400;
	public static final int HEIGHT=300;
	public static final int SCALE=2;
	boolean flag=true; //게임가동여부를 결정하는 변수
	Thread thread; //게임운영쓰레드 
	Player player;
	ObjectManager objectManager; //객체명단 관리자 (모든것들이 포함된 데이터베이스)
	
	
	//윈도우 안으로 들어갈 것 ! 
		
		public GamePanel(){
			thread=new Thread(this); //this =runnable
			thread.start();
			
			init();
			
			setPreferredSize(new Dimension(WIDTH*SCALE ,HEIGHT*SCALE));//크기지정
				
		}
		
		
		public void init(){
			//명단 관리자 생성
			objectManager=new ObjectManager();
			
			//주인공 등장시키기 
			player=new Player(objectManager,ObjectId.Player,100, 200, 50, 50);
			objectManager.addObject(player);//1명추가
			
			//적군등장
			Random r=new Random();
			for(int i=0;i<10;i++){
				int y=r.nextInt((HEIGHT*SCALE-50)-(50)+1)+50;
				int x=r.nextInt((WIDTH*SCALE+500)-(WIDTH*SCALE+1))+50;
				Enemy enemy = new Enemy(objectManager, ObjectId.Enemy,x, y, 30,30);
				objectManager.addObject(enemy);
			}
			//패널과 키보드 리스너 연결
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
			while(flag){//게임중지를 원하면 flag을 돌려놓는다
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				//System.out.println("살아있어요");
				
				//오브젝트매니저에 등록된 모든~객체들을 대상으로 tick()을 호출해보자 ! 밑ㅇㅔ 주석의 tick 은 player 하나 
				for(int i=0; i<objectManager.list.size();i++){
					GameObject obj=objectManager.list.get(i);
					obj.tick();
					
				}
				                    
				//player.tick();
				//player.render(g); 얘는 불가 g를 갖고있는paintComponent에서 가능
				repaint();//paintComponenet를 간접호출 
				//총알의 tick ,render 이거를 어떻게 다 하나씩 호출할수 있을 까? 불가능 하다 따라서 Object Manager 같이 모든 것들을 다 관리할 가장큰 상위의 객체를 만들어보자 
				//적군의 tick, render
				//아이템 tick ,render
			}
		}

}




//Graphics 객체로 게임의 요소들을 접근해서 가지고와야해 모든 오브젝트에 Graphics객체
//심장은 하나 ! ! 모든애가 가지고 있으면 다들 작동하려해서 화면 깜박거림 따라서 tick(나의 물리량) render(그려짐-->Graphics) 
//