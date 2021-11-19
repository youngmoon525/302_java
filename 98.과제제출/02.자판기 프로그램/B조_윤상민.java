package pack02_TryCatch;

import java.util.Arrays;
import java.util.Scanner;

public class B조_윤상민 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrsize = 3;
		int[] price = new int[arrsize];
		String[] item = new String[arrsize];
		int[] addprice;
		String[] additem;
		int won;

		price[0] = 800;
		price[1] = 500;
		price[2] = 1500;

		item[0] = "콜라";
		item[1] = "생수";
		item[2] = "비타민워터";

		while (true) {
			System.out.print("금액을 입력하세요.(관리자모드를 실행하려면 -1, 그만하려면 0) : ");
			try {
				won = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다!");
				continue;
			}
			// 프로그램 종료
			if (won == 0) {
				break;
			}
			// 관리자모드
			else if (won == -1) {
				System.out.print("아이디 : ");
				String id = sc.nextLine();
				System.out.print("비밀번호 : ");
				String pw = sc.nextLine();
				if (id.equals("admin") && pw.equals("admin")) {
					while (true) {
						System.out.print("1.음료추가 2.음료삭제 3.음료 수정(그만하려면 0) : ");
						int choose = Integer.parseInt(sc.nextLine());
						if (choose == 0) { // 관리자모드 종료
							break;
						} else if (choose == 1) { // 음료 추가
							arrsize += 1;
							additem = new String[arrsize];
							addprice = new int[arrsize];
							for (int i = 0; i < item.length; i++) {
								additem[i] = item[i];
								addprice[i] = price[i];
							}
							System.out.print("추가할 음료명? ");
							additem[arrsize - 1] = sc.nextLine();
							System.out.print("추가할 음료 가격? ");
							addprice[arrsize - 1] = Integer.parseInt(sc.nextLine());
							item = new String[arrsize];
							price = new int[arrsize];
							for (int i = 0; i < item.length; i++) {
								item[i] = additem[i];
								price[i] = addprice[i];
							}
						} else if (choose == 2) { // 음료 삭제
							arrsize -= 1;
							additem = new String[arrsize];
							addprice = new int[arrsize];
							System.out.print("삭제할 음료명? ");
							String name = sc.nextLine();
							for (int i = 0; i < item.length; i++) {
								if (item[i].equals(name)) {
									for (int j = i; j < arrsize; j++) {
										additem[j] = item[j + 1];
										addprice[j] = price[j + 1];
									}
									break;
								} else {
									additem[i] = item[i];
									addprice[i] = price[i];
								}
							}
							item = new String[arrsize];
							price = new int[arrsize];
							for (int i = 0; i < item.length; i++) {
								item[i] = additem[i];
								price[i] = addprice[i];
							}
						} else if (choose == 3) { // 음료 가격 수정
							System.out.print("수정할 음료명? ");
							String name = sc.nextLine();
							for (int i = 0; i < item.length; i++) {
								if (item[i].equals(name)) {
									System.out.print("수정할 가격? ");
									price[i] = Integer.parseInt(sc.nextLine());
								}
							}
						}
						else { // 잘못된 수 입력했을 경우
							System.out.println("0~3 중에 입력하세요!");
						}
						System.out.println(Arrays.toString(item));
					}
				} else { //아이디나 비밀번호 틀렸을 경우
					System.out.println("틀렸습니다! 주문으로 넘어갑니다");
				}
				continue;
			}
			//주문
			System.out.println("메뉴를 고르세요.");
			for (int i = 0; i < item.length; i++) {
				System.out.print((i + 1) + "." + item[i] + "(" + price[i] + "원) ");
			}
			System.out.print(" >> ");
			int choice = Integer.parseInt(sc.nextLine());
			//돈이 부족할 경우
			if (won < price[choice - 1]) {
				System.out.println("돈이 부족합니다!");
				continue;
			}
			//잔돈 계산
			won -= price[choice - 1];
			System.out.println("잔돈 : " + won + "원");
			System.out.println(
					"천원 : " + (won / 1000) + "개, 오백원 : " + (won % 1000 / 500) + "개, 백원 : " + (won % 500 / 100) + "개");
		}
		sc.close();
	}
}