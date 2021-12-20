package pack02_Fruit;

public class A extends B{

	public void display(FruitDTO[] dtos) {
		for(int i = 0; i<dtos.length; i++) {
			System.out.print(dtos[i].name + "\t");
			System.out.print(dtos[i].price + "\t");
			System.out.print(dtos[i].amount + "\t");
			System.out.println(dtos[i].from + "\t");
		}
	}
	
}
