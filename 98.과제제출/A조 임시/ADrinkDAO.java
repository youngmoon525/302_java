package pack01.useprivate;

import java.util.Scanner;

public class ADrinkDAO  {

	public int inputPrice() {
		System.out.println("돈을 넣어주세요");
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("잘못입력하셨습니다");
				continue;
			}
		}
	}

	
}
