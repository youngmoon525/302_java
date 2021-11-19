package pack02_Try;

import java.util.Scanner;

public class Test___ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = new String[50];
		str[0] = "콜라";
		str[1] = "물";
		str[2] = "비타민워터";
		int cnt = 3;

		int[] price = new int[50];
		price[0] = 800;
		price[1] = 500;
		price[2] = 1500;

		int menu;

		while (true) {
			System.out.println("금액을 입력하세요.	종료: 0");
			int money;

			try {
				money = Integer.parseInt(sc.nextLine());

			} catch (Exception e) {
				System.out.println("숫자를입력해주세요");
				continue;
			}
			if (money == 0) {
				System.out.println("시스템 종료");
				break;
				// =============================================괁리자
			}

			while (true) {
				for (int i = 0; i < cnt; i++) {
					System.out.println((i + 1) + "." + str[i] + price[i] + "원");
				}
				System.out.println(" 메뉴를 선택하세요 ");
				menu = Integer.parseInt(sc.nextLine());
				money -= price[menu - 1];
				if(money<0) {
					System.out.println("잔액부족");
					break;
				}
				System.out.println(money);
				int test1 = money / 1000;
				money -= test1 * 1000;
				int test2 = money / 500;
				money -= test2 * 500;
				int test3 = money / 100;
				money -= test3 * 100;
				System.out.println("천원짜리 : " + test1 + "	오백원짜리: " + test2 + "	백원짜리: " + test3);
				
			}
		}

	}
}
