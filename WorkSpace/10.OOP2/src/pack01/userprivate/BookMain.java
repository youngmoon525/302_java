package pack01.userprivate;

public class BookMain {
	public static void main(String[] args) {
		BookDTO dto = new BookDTO();
		dto.setPrice(100);//들어가면 안되는값.
		System.out.println(dto.getPrice());
		System.out.println(dto.company);
		System.out.println(dto.title);
		System.out.println(dto.writer);
		
		//BookDTO2를 인스턴스화 시키고 값을 getter & setter 통해
		//세팅하고 출력해보기
		//
	}
}
