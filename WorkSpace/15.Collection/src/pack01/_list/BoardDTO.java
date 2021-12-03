package pack01._list;

public class BoardDTO {
//게시판의 속성을 가지고있는 객체 (실제 DB와 연동을해서 저장 된 데이터를 가지고와서 묶어놓을 객체)
	private int no; //게시글의 번호
	private String title;//게시글의 제목
	private String content;//게시글의 내용
	//글의 건수가 1건이라면 DTO하나만 있어도 크게 불편한점은 없음.
	//하지만, 글의건수가 몇건이지는 잘 모르겠지만 적어도 1건보다는 많을때
	//글의 정보들을 가지고있는 객체를 하나로 묶어놓으면 for문 그리고 for문안에 if문을넣어서
	//한번에 제어하는게 더 편리해진다.
	//BoardDTO dto1 = new 
	//BoardDTO dto2 = new <== x
	//List<BoardDTO> list = for(list) <-편리함
	public BoardDTO(int no, String title, String content) {
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
