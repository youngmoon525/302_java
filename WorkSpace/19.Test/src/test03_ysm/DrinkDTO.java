package test03_ysm;

public class DrinkDTO {
	private int no;
	private String name;
	private String company;
	private int price;
	private int cnt;
	
	public DrinkDTO(int no, String name, String company, int price, int cnt) {
		super();
		this.no = no;
		this.name = name;
		this.company = company;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}