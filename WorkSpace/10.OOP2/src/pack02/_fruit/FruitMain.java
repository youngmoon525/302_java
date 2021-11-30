package pack02._fruit;

import java.util.Scanner;

public class FruitMain {
	public static void main(String[] args) {

		FruitDAO dao = new FruitDAO();
		FruitDTO[] dtos = dao.initDtos();
		dao.display(dtos);
		dao.dispalyMax(dtos);
//		dtos[i] = ?S
//		dao.display( ? );
//		dao.displaymax();

		
		
		//dto.cnt = -100; //<=외부에서 접근이 불가능한 변수가 됨.
	}
}
