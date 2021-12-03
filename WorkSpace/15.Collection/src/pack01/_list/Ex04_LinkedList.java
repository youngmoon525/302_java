package pack01._list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex04_LinkedList {
	public static void main(String[] args) {
		//데이터 자료구조가 서로를 연결시켜놓는 구조라서 접근속도가 떨어짐
		//데이터를 추가하는것 빠름
		//많이 사용을 안하기때문에 따로 공부할 필요는 없다.
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<>();//자료구조 형태가 차이가있음
		//=========여기 밑에서 부터는 중요한 소스가 아니기때문에 외우지말고,
		//공부도 따로할필요는없다, ArrayList vs LinkedList 데이터 처리속도
		long startTime;
		long endTime;
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			list1.add( new String("aa"));//ArrayList
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList가 작업에 소요한시간 : " + (endTime-startTime) + "ns");
		
		
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			list2.add( new String("aa"));//LinkedList
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList가 작업에 소요한시간 : " + (endTime-startTime) + "ns");
		
		
		
		
		
		
		
		
	}
}
