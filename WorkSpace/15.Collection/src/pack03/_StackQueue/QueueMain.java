package pack03._StackQueue;

import java.util.LinkedList;
import java.util.Queue;

import pack03._StackQueue.StackMain.Coin;

public class QueueMain {
	public static void main(String[] args) {
		//Coin을 객체로 생성해보기 
		//Coin이라는 객체는 StackMain에 멤버
		StackMain sm = new StackMain();
		Coin c = sm.new Coin(1);
		
		Queue<Coin> coinBoxQ = new LinkedList<>();
		//stack = LIFO
		// 후입 선출 
		coinBoxQ.offer(sm.new Coin(100));
		coinBoxQ.offer(sm.new Coin(50));
		coinBoxQ.offer(sm.new Coin(500));
		coinBoxQ.offer(sm.new Coin(10));
		
		//Queue = FIFO ( First In First Out)
		// 선입 선출
		while(!coinBoxQ.isEmpty()) {
			Coin coin = coinBoxQ.poll();
			System.out.print(coin.getValue() + " , ");
		}
		
		
		
		
	}
}
