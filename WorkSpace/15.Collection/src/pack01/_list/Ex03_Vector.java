package pack01._list;

import java.util.List;
import java.util.Vector;

public class Ex03_Vector {
	public static void main(String[] args) {
		//다시 공부할필요가 전혀없음.
		//별로 안중요함 ( Collection 자료구조 list중에서 가장 오래됨)
		//ArrayList보다 성능이 많이 떨어진다
		//ArrayList사이즈 증가(배열) 50%를 증가시킴 (현재크기에서) 
		//Vector 사이즈 증가 100% 
		List<BoardDTO> list = new Vector<>();
		
		list.add(new BoardDTO(1, "title", "content"));
		System.out.println(list.get(0).getNo());
		System.out.println(list.get(0).getTitle());
		System.out.println(list.get(0).getContent());
		
		
		
		
		
	}
}
