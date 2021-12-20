package test02__lsj;

public class DrinkDTO_LSJ {
	private String drink;
	private String company;	
	private int price;
	private int count;
	
	public DrinkDTO_LSJ(String drink, String company, int price, int count) {
		this.drink = drink;
		this.company = company;
		this.price = price;
		this.count = count;
	}
	
	public String getDrink() {
		return drink;
	}
	public String getCompany() {
		return company;
	}
	public int getPrice() {
		return price;
	}
	public int getCount() {
		return count;
	}
}
