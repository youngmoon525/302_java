package pack02._map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ex02_HashMap {
	public static void main(String[] args) {
		//이번장에서는 자료구조의 형태를 어느정도만 파악을 하고
		// ArrayList , HashMap을 사용할수 있으면된다.
		// ↑<----
		//HashMap = key , value를 가지는 DTO와 비슷한 형태의 자료구조
		// key <=데이터를 가지고올때 index가 아니라 식별자로 가지고온다. , value <=식별자로 접근했을때 있는 값
		//	ex )          주민등록번호                                            , 나이,이름
 		Map<String, Integer> map = new HashMap<>();
 		//map에 데이터 추가는 Add가 아니라 put이라는 메소드를 이용을한다.
 		map.put("LoginID", 1) ;
 		System.out.println(map.get("LoginID"));
 		System.out.println(map.size());
 		
 		
 		map.put("임꺽정", 40);
 		map.put("성춘향", 20);
 		map.put("이몽룡", 60);
 		System.out.println("24번째줄"+map.size());
 		map.put("이몽룡", 99);
 		System.out.println(map.size());
 		map.put("이몽룡", 60);
 		System.out.println(map.size());
 		System.out.println(map.get("이몽룡"));
 		//Hash자료구조에서 데이터 중복을 허용하지않는데
 		//HashMap에서 중복된 키값을 사용하고 값을 달리하면 데이터가 추가가될까?
 		//HashMap에서 중복된 키값을 사용하고 값을 달리하면 마지막에 추가한값으로 덮어써짐
 		//Update됨 
 		map.remove("이몽룡"); 
 		
 		//여기서부터는 어려운부분이고 HashMap자체를 반복문을이용해서 사용하는경우는 많지않음
 		//따로 공부를 해두면 좋긴하지만 이해가 안간다면 공부를 안해도 되는 부분
 		//Iterator<- 
 		Iterator<String> keys = map.keySet().iterator();//map자료구조에있는 iterator로 초기화
 		while(keys.hasNext()) {//실제로 이동하는게 아님 (Iterator)
 			String key = keys.next();
 			int value = map.get(key);
 			System.out.println(" key : " + key + " value : " + value);
 		}//방법 1
 		
 		//방법2.foreach
 		for( String key : map.keySet()) {
 			int value = map.get(key);
 			System.out.println(" key : " + key + " value : " + value);
 		}
 		
 		
 		
 		
 		
	}
}
