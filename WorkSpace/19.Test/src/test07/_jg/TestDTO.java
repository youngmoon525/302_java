package test07._jg;

public class TestDTO {
	private	int no ;
	private String name; 
	private String conpany;
	private	int price ;
	private int	cnt ;
	public TestDTO(int no, String name, String conpany, int price, int cnt) {
		super();
		this.no = no;
		this.name = name;
		this.conpany = conpany;
		this.price = price;
		this.cnt = cnt;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConpany() {
		return conpany;
	}
	public void setConpany(String conpany) {
		this.conpany = conpany;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
	
	
}
