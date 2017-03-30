/*
우리가 제작중인 게임은 게임루프가 오직 1개만 존재하기 때문에
while 내에서 게임에 등장할 모든 오브젝트의 tick, render 를 호출해야할 의무가 있다
하지만 게임에 등장할 객체들이 너무나 여러 클래스에 걸쳐서 복잡하게 등장하기 때문에 
게임루프인 while 문 내에서 모든 객체들의 레퍼런스를 접근하기란 쉽지 않다

해결책 ?
게임에 등장할 모든 객체들을 관리해주는 존재가 필요하다 --> objectManeger라고 지정하고 만들어보자 총감독이라 생각! 데이터를 관리할 집합!(데이터베이스)*/

package game;

import java.util.ArrayList;

public class ObjectManager {
	//데이터베이스 역할을 할 존재
	ArrayList<GameObject> list = new ArrayList<GameObject>(); //할머니가 핸드폰을 그거좀 치워 한거처럼 object는 애매한ㄷ 일단은 해보자  -->결국 GameObject
	
	//객체등록
	//모든 게임에등장할 객체는 생성될 떄 아래의 메서드를 통해 데이터베이스에 등록된다
	public void addObject(GameObject obj){ //이메서드를 호출할 사람이 진행해야하니까 object라하자 
		list.add(obj);
		
		
	}
}
