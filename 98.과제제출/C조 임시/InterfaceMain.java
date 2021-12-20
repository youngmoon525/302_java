package pack02_Fruit;

public class InterfaceMain implements Interface_Fruit{
	A a = new A();
	
	@Override
	public FruitDTO[] initFruitDTO() {
		return a.initFruitDTO();
	}
	
	@Override
	public void display(FruitDTO[] dtos) {
		a.display(dtos);
	}


}
