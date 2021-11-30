package pack01.userprivate;

public class BookDTO2 {

	private String title , writer , company ;
	private int price ;
	//getter & setter를 자동으로 만드는 방법.
		//마우스 오른쪽 클릭 => source => getter and setter 
		
		
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
	
}
