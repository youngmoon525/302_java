package pack01._list;

import java.util.ArrayList;

public class Ex02_ArrayListRef {
	public static void main(String[] args) {
		BoardDTO[] dtos = new BoardDTO[5];//<=5건의 글 정보만 가지고있을수있음.
		dtos[0] = new BoardDTO(1, "공지사항", "공지사항 입니다.");
		//↑ ↓ 크기에 제약이없는 List형태로 만들기
		ArrayList<BoardDTO> list = new ArrayList<>();
		list.add(new BoardDTO(1, "리스트 공지사항1", "공지사항 입니다1"));
		list.add(new BoardDTO(2, "리스트 공지사항2", "공지사항 입니다2"));
		list.add(new BoardDTO(3, "리스트 공지사항3", "공지사항 입니다3"));
		list.add(new BoardDTO(4, "리스트 공지사항4", "공지사항 입니다4"));
		//for문을 이용해서 list안에 들어있는 공지사항 글 정보를 전체 출력하기.
		//hint ) BoardDTO[] dtos <= ?
		// dtos[index] <= 해당하는 DataType이 들어있음
		// list.get(index) <= 해당하는 DataType이 들어있음.
		for(int i = 0 ; i< list.size() ; i ++) {
			//list.get(index) => return dto; (element를 리턴해준다)
			System.out.println(list.get(i).getNo());//DTO가 참조하고있는 메모리 번지수가나온다(참조타입)
			System.out.println(list.get(i).getTitle());//DTO가 참조하고있는 메모리 번지수가나온다(참조타입)
			System.out.println(list.get(i).getContent());//DTO가 참조하고있는 메모리 번지수가나온다(참조타입)
			//BoardDTO dto = list.get(i);//return dto
			//System.out.println("dto에 담고출력" + dto.getNo() + " : " + dto.getContent() + dto.getTitle());
		}
		
		
		
	}
}
