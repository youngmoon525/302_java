package pack03._StackQueue;

import java.util.Stack;

public class StackMain {

	public static void main(String[] args) {
		//Coin 이라는 클래스를 인스턴스화 시켜서 사용할 준비를 해보기.
		//static 이미 메모리에 올라가있음( 먼저 )↓접근이 바로는 불가능함
		//instence 객체가 인스턴스화 되어야만 메모리에 올라감( 나중에 new를통해서)↑접근바로가능
		StackMain sm = new StackMain();//StackMain을 인스턴스화 해야지만
									   //static main가 접근이 가능함(StackMain Instence멤버)
		//Coin coin1 = sm.new Coin(3);
		//Coin coin2 = new StackMain().new Coin(5);
		//Stack이라는 자료구조를 한번 직접 사용해보기(이론적인 부분 실제 사용 x)
		Stack<Coin> coinBoxSt = new Stack<>();
		//데이터가 들어가고 나오는 작업에 방향이 정해져있음
		//데이터를 넣는것은 push라는 메소드를 통해서(기능)
		//데이터를 빼오는것 pop이라는 메소드를 통해서 , push , pop 
		coinBoxSt.push(sm.new Coin(100));
		coinBoxSt.push(sm.new Coin(50));
		coinBoxSt.push(sm.new Coin(500));
		coinBoxSt.push(sm.new Coin(10));// 100 , 50 , 500 , 10
		//
		System.out.println("데이터를 넣은 순서는 100 , 50 , 500 , 10");
		while(!coinBoxSt.isEmpty()) { //pop이라는 명령어를 사용하면 데이터가 몇개있든 일단 빼옴
									  //isEmpty()를 이용해서 비어있는지를 체크함.
			Coin coin = coinBoxSt.pop();
			System.out.print(coin.value + ",");
			
		}
		//Stack이라는 자료구조는 LIFO구조를 가지고있다.
		//Last In First Out
		
		
		
		
		
	
	}
	
	
	
	//StackMain 이라는 클래스의 멤버 (인스턴스 멤버)
	public class Coin{
		private int value;
		
		public Coin(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		
		
	}
}
