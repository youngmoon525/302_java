package test08.ysb;


public class DrinkDTO {

	
	int no;
	String name;
	int price;
	String company;
	int cnt;
	public DrinkDTO(int no, String name, int price, String company, int cnt) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.company = company;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	} 
}
	
	