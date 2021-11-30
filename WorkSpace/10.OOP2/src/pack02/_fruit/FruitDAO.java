package pack02._fruit;

public class FruitDAO {

	public FruitDTO[] initDtos() {
		FruitDTO[] dtos =new FruitDTO[5];
		dtos[0] = new FruitDTO("오렌지1" , "태국1", 1100 , 4 );
		dtos[1] = new FruitDTO("사과2" , "태국2", 1200 , 4 );
		dtos[2] = new FruitDTO("망고3" , "태국3", 1300 , 4 );
		dtos[3] = new FruitDTO("귤4" , "태국4", 1400 , 4 );
		dtos[4] = new FruitDTO("오렌지5" , "태국5", 1500 , 4 );
		return dtos;
	}

	public void display(FruitDTO[] dtos) {
		for (int i = 0; i < dtos.length; i++) {
			System.out.println(dtos[i].getName() + "," + dtos[i].getPrice() + "," + dtos[i].getCnt() + "," + dtos[i].getOrg());
		}
	}

	public void dispalyMax(FruitDTO[] dtos) {
		
		for (int i = 1; i < dtos.length; i++) {
			for (int j = 0; j < dtos.length-1; j++) {
				if(dtos[j].getPrice() < dtos[j+1].getPrice()) {
					FruitDTO dto = dtos[j];
					dtos[j] = dtos[j+1];
					dtos[j+1] = dto;
				}
			}
		}
		display(dtos);
		
	}
	
}
