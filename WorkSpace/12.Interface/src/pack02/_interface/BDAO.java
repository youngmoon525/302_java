package pack02._interface;


public class BDAO extends ADAO {
	public void display(FruitDTO[] dtos) {
		for (int i = 0; i < dtos.length; i++) {
			System.out.println(dtos[i].getName() + "," + dtos[i].getPrice() + "," + dtos[i].getCnt() + "," + dtos[i].getOrg());
		}
	}
}
