package pack02_TryCatch;

import java.util.Scanner;

public class Text_progrem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] x = new String[2][3];
		x[0][0] = "콜라";
		x[0][1] = "생수";
		x[0][2] = "비타민워터";
		x[1][0] = "800";
		x[1][1] = "500";
		x[1][2] = "1500";
		int money = 0;
		while (true) {
			try {
				System.out.println("금액을 입력해주세요.");
				String data = sc.nextLine();
				money = Integer.parseInt(data);
				System.out.println(money);
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			if (money < 0) {
				System.out.println("결제 종료");
				break;
			}else if(money == 0) {
				System.out.println("다시 입력해주세요");
				continue;
			}
			while (true) {
				System.out.println("메뉴를 고르세요.");
//			System.out.println("1.콜라 800원");
//			System.out.println("2.생수 500원");
//			System.out.println("3.비타민워터 1500원");
				System.out.println("1" + x[0][0] + x[1][0]);
				System.out.println("2" + x[0][1] + x[1][1]);
				System.out.println("3" + x[0][2] + x[1][2]);
				String data1 = sc.nextLine();
				int menu = Integer.parseInt(data1);
				System.out.println();
//			x[0][menu-1];
//			x[1][menu-1];

				System.out.println(x[0][menu - 1]);
				System.out.println(money - Integer.parseInt(x[1][menu - 1]));
				money -= Integer.parseInt(x[1][menu - 1]);
				/*
				 * if(menu.equals("1")) { System.out.println("콜라 800원"); money-= 800; }else
				 * if(menu.equals("2")) { System.out.println("생수 500원"); money-= 500; }else
				 * if(menu.equals("3")) { System.out.println("비타민워터 1500원"); money-= 1500; }
				 */

				System.out.println(" 잔돈 : " + money);
				int hun = money / 1000;
				int hun1 = (money - hun * 1000) / 500;
				int hun2 = (money - hun * 1000 - hun1 * 500) / 100;
				System.out.println(hun);
				System.out.println("천원" + hun + "개, " + "오백원" + hun1 + "개, " + "백원" + hun2 + "개 ");
			}
		}
	}
}
