package pack01._ojdbc;

public class Ex02_BoardDTO {
	// no , content , title List로 묶을수있게 DTO객체를 만듬.
	// int , String , String 
	// ctrl + shift + y = 소문자로 변환 
	// alt + shift + a = 행모드로 변환 , 이모드에서는 행을 선택할수있음(블럭모드)
	private int no            ;
	private String title      ;
	private String content    ;
	public Ex02_BoardDTO(int no, String title, String content) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
