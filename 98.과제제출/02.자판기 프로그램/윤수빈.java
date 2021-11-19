package pack02_TryCatch;

import java.util.Scanner;

public class Test_game {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] menu = { "콜라", "생수", "비타민워터" };
		menu[0] = "콜라";
		menu[1] = "생수";
		menu[2] = "비타민워터";
		int[] price = { 800, 500, 1500 };
		price[0] = 800;
		price[1] = 500;
		price[2] = 1500;
		int change;
		int money;

		while (true) {
			System.out.println("음료 자판기입니다.");
			System.out.println("금액을 입력해주세요" + ("(0입력시 결제 취소)"));
			try {
				money = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다");
				continue;
			}
			if (money == 0) {
				System.out.println("결제 취소");
				break;
			}
			while (true) {
				System.out.println("메뉴를 고르세요");
				System.out.print("1. " + menu[0] + " (" + price[0] + "원)" + " 2. " + menu[1] + " (" + price[1] + "원)"
						+ " 3. " + menu[2] + " (" + price[2] + "원)");
				System.out.println("");
				int choice = Integer.parseInt(sc.nextLine());
				if (money < price[choice - 1]) {
					System.out.println("금액이 적습니다");
					System.out.println("결제가 취소되었습니다");
					break;
				} else {
					change = money - price[choice - 1];
					int thousand = (change / 1000);
					int fhundred = (((change - thousand * 1000)) / 500);
					int hundred = (change - (fhundred * 500) - (thousand * 1000)) / 100;
					System.out.println("잔돈 : " + change + "원이 반환됩니다.");
					System.out.println("천원: " + thousand + "개 " + "오백원: " + fhundred + "개 " + "백원: " + hundred + " 개");
					System.out.println(menu[choice - 1] + "가 나왔습니다.");
					break;
				}
			}
		}

	}

}
