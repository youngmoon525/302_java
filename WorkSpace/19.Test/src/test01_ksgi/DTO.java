package test01_ksgi;

public class DTO {
	int no, price, cnt;
	String name, company;
	public DTO(int no, String name, int price, String company, int cnt) {
		super();
		this.no = no;
		this.price = price;
		this.cnt = cnt;
		this.name = name;
		this.company = company;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	

}
