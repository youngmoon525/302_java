package pack02._interface;



public class CDAO extends BDAO{
	//A + B(BDAO) < A + B + C = 모든 기능을 사용이 가능하다.
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
