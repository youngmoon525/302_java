package pack01.userprivate;

public class BookMain {
	public static void main(String[] args) {
		BookDTO dto = new BookDTO();
		System.out.println(dto.getPrice());
		System.out.println(dto.company);
		System.out.println(dto.title);
		System.out.println(dto.writer);
	}
}
