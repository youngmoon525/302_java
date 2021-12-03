package pack01._list;

import java.util.ArrayList;
import java.util.List;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		//List 
		//E <- Element(요소) 
		//↑String[] , TestDTO[] : 배열에서 배열 안에 넣을수있는 타입을 미리 지정해놓는데 
		//						  지정을 해놓은 배열안에 들어갈수있는타입(요소)
		//DataType(배열) == List<DataType> 
		//List컬렉션구조는 전부다 List라는 Interface를 상속받았다. 
		//자료구조의 형태가 차이가 있지만 대부분의 Interface에 있는 기능이 공통으로 있기때문에
		//자식 클래스(ArrayList,Vector,LinkedList)들은 전부 List로 다시 담을수가있다.
		String[] arr = new String[3];//<=배열은 사이즈를 미리 지정해놓기때문에 불편한점이 많음.
									//미리 정해놓은 사이즈가 계속 고정되어있는 상황이 아닐때.
									//ex)음료 추가 , 음료 삭제 등 배열의 사이즈가 변해야 하는경우 불편함
		List<String> list = new ArrayList<String>();
		//자료구조(데이터타입,Element,요소)바뀌기때문에 <바뀌는 데이터타이부분> ();
		//Element 요소는 Class타입만 넣을수있음 . int=x , Integer , double =x , Double
		System.out.println("배열의 크기를 조회할때 : " +  arr.length);//length : 변수
		
		System.out.println("리스트의 크기를 조회할때 : " + list.size());// size() : 메소드
		//데이터를 넣을때마다 크기와 인덱스가 자동으로 증가하는 형태.
		//데이터를 넣는 방법 
		list.add("java1");//크기 1 , index 0 ,
		list.add("java2");//크기 2 , index 1 ,
		list.add("java3");
		list.add("java4");
		list.add("java5");
		list.add("java6");
		list.add("java7");
		list.add("java8");
		list.add("java9");
		list.add("java10");//크기 10 , index 9 
		list.add("java11");//크기 11 , index 10 
		//list.add(0,"view1");//add메소드중에 (오버로딩된 메소드중에) 파라메터로 int값을 받는메소드는
							//데이터를 내가 원하는 index에 끼워 넣는방법
		System.out.println("리스트의 add후 사이즈 : " + list.size());
		System.out.println("리스트의 내용을 가지고 오는 방법" +list.get(0));
		//list의 사이즈와 데이터를 가지고 오는 방법을 간략하게 배웠다.
		//두가지 방법을 이용해서 for문을 이용하여 list전체 내용을 출력하는 프로그램을 작성하시오.
		for(int i = 0 ; i <list.size() ; i++) {
			System.out.println(list.get(i));//메소드를 이용해서 return을 받는 형태
			//System.out.println(arr[i]);//데이터(변수) 값 대해 값에 바로접근
		}
		
		
		
		
		
		
	}
}
