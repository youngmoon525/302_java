package pack02._map;

import java.util.HashSet;
import java.util.Set;

public class Ex01_HashSet {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();// <>() <=컬렉션 자료구조
		set.add("java1");
		set.add("java2");
		System.out.println(set.add("java3"));//true
		set.add("java4");
		set.add("java5");
		set.add("java6");
		System.out.println(set.add("java6"));//false <=중복된값으로 넣을수가없음
		set.add("java6");
		set.add("java6");
		set.add("java6");
		set.add("java6");
		set.add("java6"); //Hash구조에서 중요한 부분은 같은 참조를 가진 데이터는 절대 중복해서 넣을수가없음
		set.add(new String("java6"));//같은 참조라는 말은 Hash에서는 값이 같다 라는 의미.
		//add메소드는 boolean을 return을해줌 (add가 성공하면 true , 실패하면 false)
		System.out.println(set.size());
		//index가 없기때문에 ( 데이터가 있는곳의 위치를 개발자가 알수가없음 )
		//iterator <= while 추후 사용하겠음
		//반복횟수를 모르지만 자료구조에서 element를 하나씩 빼올수있는 형태의 for
		//foreach ( 향상된for문 )
		//	(자료구조 내부에 있는 Element		:  ( 자료구조 )
		int i = 0;
		for (String str : set) {
			System.out.println(str);
			i++;
		}
		System.out.println("foreach의 반복 횟수 : " + i);
		
		
		
		
	}
}
