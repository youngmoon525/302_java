package pack02._interface;

public class FruitDTO {
	// 오렌지 , 1000 , 4 , 태국
	private String name, org;
	private int price, cnt;

	public FruitDTO(String name, String org, int price, int cnt) {
		this.name = name;
		this.org = org;
		this.price = price;
		this.cnt = cnt;
		//setCnt(cnt);
		//어떤 조건 논리적으로 들어가면 안되는 값을 setter에서 막아 놨다면
		//setter를 호출해서 field를 셋팅해도 무방하다.
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
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
		if(cnt > 1) {
			this.cnt = cnt;
		}
	}

}
