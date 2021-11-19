package pack02_try_catch_finally;

import java.util.Scanner;

public class Ex06_Test_2nd_Kim_Seulgi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int[] price = new int[3];
			String[] item = new String[3];
			int money;
			int start;
			
			price[0]=800;
			price[1]=500;
			price[2]=1500;
			
			item[0]="콜라";
			item[1]="생수";
			item[2]="비타민워터";
			
			while(true) {
				System.out.println("-1. 주문하기 -2.그만하기");
				//메인메뉴 선택	
				try {
					start = Integer.parseInt(sc.nextLine());
				}catch(Exception e) {
					System.out.println("잘못된 입력입니다.");
					continue;
				}
				//-1(주문하기)을 입력했을 경우
				if(start==-1) {
					System.out.println("금액을 입력하세요.");
					//숫자가 아닌 걸 입력했을 경우
					try {
						money = Integer.parseInt(sc.nextLine());
					}catch(Exception e) {
						System.out.println("잘못된 입력입니다.");
						continue;
					}
					//메뉴 고르기
					System.out.println("메뉴를 고르세요.");
					System.out.println("1.콜라(800)원 2.생수(500원) 3.비타민워터(1500원)");
					int choice;
					try {
						choice = Integer.parseInt(sc.nextLine());
						if(choice > item.length) {
							System.out.println("없는 메뉴입니다.");
							continue;
						}
					}catch(Exception e) {
						System.out.println("잘못된 입력입니다.");
						continue;
					}	
					if(money < price[choice-1]) {
						System.out.println("돈이 부족합니다.");
						continue;
					}
					money = money-price[choice-1];
					System.out.println("잔돈: " + money + "원");
					System.out.println("천원: " + money/1000 + " 오백원: " + money%1000/500 + " 백원: " + money%500/100 );
					
				}//-2(그만하기)를 입력했을 경우
				else if(start==-2){
					System.out.println("종료합니다.");
					break;
				}//메인 메뉴창에서 입력이 잘못된 경우
				else {
					System.out.println("잘못된 입력입니다!");
					continue;
				}
				
				
			}
			sc.close();
	}

}
