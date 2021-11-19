package pack02_TryCatch;

import java.util.Scanner;

public class B조_오설화{

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] menu = new String[] { "콜라", "생수", "비타민 워터" };
		int[] money = new int[] { 800, 500, 1500 };
		int inputmoney;    //try랑 잔돈 

		while (true) {
			System.out.println("주문하시겠습니까? 주문을 원하시는 경우 1, 주문을 취소 0을 누르세요");
			int order = Integer.parseInt(sc.nextLine());
 
			if (order == 0) {
				System.out.println("주문을 취소하였습니다.");
				break;
				
			//관리자 모드 할 경우 
			
			} else if (order == 1) {
				System.out.println(" 금액을 입력하세요. : ");

				try {   //입금 돈이 오류
					
					inputmoney = Integer.parseInt(sc.nextLine());
					
				} catch (Exception e) {
					System.out.println("다시 입력하세요");
					continue;
				}

				System.out.println(" 메뉴를 고르세요.");
				//System.out.println(" 1. 콜라 2. 생수 3. 비타민워터");
				for (int i = 0; i < menu.length; i++) {
					System.out.print((i + 1) + ". " + menu[i] + "(" + money[i] + "원 )");
				}
				System.out.print(">>");
				
				int inputmenu;   //  try, 물건 값 적용
				try {  //메뉴를 문자로 입력하거나 메뉴의 범위를 초과했을때
					inputmenu = Integer.parseInt(sc.nextLine());
					if(inputmenu>menu.length) {
					 System.out.println("없는 메뉴입니다.");
					 continue;
					}
				}catch(Exception e ) {
					System.out.println("잘못된 입력입니다.");
					continue;
				}
				
				if(inputmoney< money[inputmenu- 1]) {   //내가 주문 금액< 물건 값
					System.out.println("금액이 부족합니다.");
					continue;
				}
				
				//잔돈
				inputmoney = inputmoney - money[inputmenu - 1];

				int chon = inputmoney / 1000;
				int won5 = chon % 500;
				int won1 = won5 % 100;

				System.out.println(" 잔돈 : " + inputmoney);
				System.out.println(" 천원 : " + chon + "  오백원 : " + won5 + "  백원 : " + won1);
			} else {
				System.out.println("잘못 입력하였습니다. 다시 입력하세요.");
			}

			
		}
	
		sc.close();
	}

}
