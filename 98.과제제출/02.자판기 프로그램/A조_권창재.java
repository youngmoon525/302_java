package pack02._TryCatch;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int change;
		
		String[] menu1 = new String[] {"콜라","생수","비타민워터"};
		int[] menu = new int[] {800,500,1500};
		
		while (true) {
			try {
				System.out.print("금액을 입력하세요 (0을 입력시 종료): ");
				
				Scanner sc = new Scanner(System.in);
				int coin = Integer.parseInt(sc.nextLine());

				
				if (coin == 0) {
					System.out.println("종료합니다.");
					break;
				} else {
					System.out.println("메뉴를 선택하세요");
					//System.out.print("1.콜라(800원) 2.생수(500원) 3.비타민워터(1500원) >> ");
					System.out.print("1. "+menu1[0]+" ("+menu[0]+"원)"+" 2. "+menu1[1]+" ("+menu[1]+"원)"+" 3. "+menu1[2]+" ("+menu[2]+"원)"+" >> ");
					int choice = Integer.parseInt(sc.nextLine());
					if (choice == 1) {
						if (coin < menu[0]) {
							System.out.println("투입 금액이 적습니다");
							System.out.println("===============");
						} else {
							change = coin - menu[0];
							int thousand = (change / 1000);
							int fhundred = (((change - thousand * 1000)) / 500);
							int hundred = (change - (fhundred * 500) - (thousand * 1000)) / 100;
							System.out.println("잔돈 : " + change);
							System.out.println("천원 : " + thousand + "개" + " 오백원 : " + fhundred + "개" + " 백원 : " + hundred + "개");
							System.out.println("===============");
						}
					} else if (choice == 2) {
						if (coin < menu[1]) {
							System.out.println("투입 금액이 적습니다");
							System.out.println("===============");
						} else {
							change = coin - menu[1];
							int thousand = (change / 1000);
							int fhundred = (((change - thousand * 1000)) / 500);
							int hundred = (change - (fhundred * 500) - (thousand * 1000)) / 100;
							System.out.println("잔돈 : " + change);
							System.out.println("천원 : " + thousand + "개" + " 오백원 : " + fhundred + "개" + " 백원 : " + hundred + "개");
							System.out.println("===============");
						}
					} else if (choice == 3) {
						if (coin < menu[2]) {
							System.out.println("투입 금액이 적습니다");
							System.out.println("===============");
						} else {
							change = coin - menu[2];
							int thousand = (change / 1000);
							int fhundred = (((change - thousand * 1000)) / 500);
							int hundred = (change - (fhundred * 500) - (thousand * 1000)) / 100;
							System.out.println("잔돈 : " + change);
							System.out.println("천원 : " + thousand + "개" + " 오백원 : " + fhundred + "개" + " 백원 : " + hundred + "개");
							System.out.println("===============");
						}
					
				}
				}
			} catch (Exception e) {
				System.out.println("잘못된입력입니다.");
				System.out.println("===============");
			}
		}
		// System.out.println(choice);

	}

}
