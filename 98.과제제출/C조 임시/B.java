package pack02_Fruit;

public class B {

	public FruitDTO[] initFruitDTO() {
		FruitDTO[] dtos = new FruitDTO[5];
		dtos[0] = new FruitDTO("오렌지", "한국", 800, 3);
		dtos[1] = new FruitDTO("사과", "한국", 1300, 7);
		dtos[2] = new FruitDTO("수박","한국", 1400, 7 );
		dtos[3] = new FruitDTO("귤","중국", 800, 10);
		dtos[4] = new FruitDTO("망고", "필리", 2200, 5);
		return dtos;
	}

	

}
