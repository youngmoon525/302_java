package pack02._interface;


public class ADAO {

	public FruitDTO[] initDtos() {
		FruitDTO[] dtos =new FruitDTO[5];
		dtos[0] = new FruitDTO("오렌지1" , "태국1", 1100 , 4 );
		dtos[1] = new FruitDTO("사과2" , "태국2", 1200 , 4 );
		dtos[2] = new FruitDTO("망고3" , "태국3", 1300 , 4 );
		dtos[3] = new FruitDTO("귤4" , "태국4", 1400 , 4 );
		dtos[4] = new FruitDTO("오렌지5" , "태국5", 1500 , 4 );
		return dtos;
	}
}
