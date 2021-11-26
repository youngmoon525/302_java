package pack05._japangi;

import java.util.Scanner;

public class DrinkDAO {
	Scanner sc = new Scanner(System.in);
	public int rtnInt(String msg ) {
		while (true) {
			try {
				System.out.println(msg);
				int temp_int = Integer.parseInt(sc.nextLine());
				return temp_int ;
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	public int rtnInt(String msg ,int beginInt , int endInt ) {
		while (true) {
			try {
				System.out.println(msg);
				int temp_int = Integer.parseInt(sc.nextLine());
				if(beginInt < temp_int && endInt > temp_int) {
					return temp_int ;
				}
				System.out.println("숫자가 범위를 벗어났습니다.");
 			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	public void display(DrinkDTO[] dtos) {
		for (int i = 0; i < dtos.length; i++) {
			System.out.print(i+1 + ".");
			System.out.print("" + dtos[i].name + "\t");
			System.out.print("금액:" + dtos[i].price );
			System.out.print("수량:" + dtos[i].cnt);
			System.out.println();
		}
		
	}
}
