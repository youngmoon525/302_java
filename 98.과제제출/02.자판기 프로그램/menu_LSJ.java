package homeWork;

import java.util.Scanner;

public class menu_LSJ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] menu = new String[100];
		menu[0] = "콜라";
		menu[1] = "물";
		menu[2] = "비타민워터";
		int[] price = new int[100];
		price[0] = 800;
		price[1] = 500;
		price[2] = 1500;
		
		int cnt=3;
		
		while(true) {
			System.out.println("---자판기 입니다.---");
			System.out.print("금액을 입력하세요(종료는 0, 관리자 모드는 1): ");
			int money;
			
			try {
				money = Integer.parseInt(sc.nextLine());							
			}
			catch(NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
				continue;
			}
			
			if(money==1) {
				System.out.print("아이디: ");
				String id = sc.nextLine();
				System.out.print("비밀번호: ");
				String pw = sc.nextLine();
				if(id.equals("admin") && pw.equals("admin")) {
					while(true) {
						System.out.println("1.음료추가  2.음료 삭제  3.음료 수정 4.로그아웃");
						
						int adPick;
						try {
							adPick = Integer.parseInt(sc.nextLine());
						}catch(NumberFormatException e) {
							System.out.println("숫자를 입력해주세요.");
							continue;
						}
						
						if(adPick == 1) {
							System.out.print("추가할 메뉴:");
							String addm = sc.nextLine();
							System.out.print("해당하는 가격:");
							
							int addp;
							try {
								addp = Integer.parseInt(sc.nextLine());
							}catch(NumberFormatException e) {
								System.out.println("숫자를 입력해주세요.");
								continue;
							}
							
							menu[cnt] = addm;
							price[cnt] = addp;
							cnt++;
						}
						else if(adPick == 2) {
							cnt=0;
							while(menu[cnt] != null) {
								System.out.print((cnt+1) +". "+ menu[cnt]+"("+price[cnt]+"원) ");
								cnt++;
							}
							System.out.print("삭제할 음료를 고르시오 >> ");
							int del = Integer.parseInt(sc.nextLine());
							
							if(del > cnt || del <= 0) {
								System.out.println("음료를 잘못 선택하셨습니다.");
								continue;
							}
							
							while(del<cnt) {
								menu[del-1] = menu[del];
								price[del-1] = price[del];
								del++;
							}
							menu[--del] = null;
							price[del] = 0;
						}
						else if(adPick == 3) {
							cnt=0;
							while(menu[cnt] != null) {
								System.out.print((cnt+1) +". "+ menu[cnt]+"("+price[cnt]+"원) ");
								cnt++;
							}
							System.out.print("수정할 메뉴를 고르시오>> ");
							int chg = Integer.parseInt(sc.nextLine());
							
							if(chg > cnt || chg <= 0) {
								System.out.println("메뉴를 잘못 선택하셨습니다.");
								continue;
							}
							
							System.out.println(menu[chg-1] + "의 가격 수정을 수정합니다.");
							System.out.print("가격: ");
							
							int chgPri;
							try {
								chgPri = Integer.parseInt(sc.nextLine());								
							}catch(NumberFormatException e) {
								System.out.println("숫자를 입력해주세요.");
								continue;
							}
							price[chg-1] = chgPri;
						}
						else if(adPick == 4) {
							System.out.println("로그아웃");
							break;
						}
						else {
							System.out.println("메뉴를 잘못 선택하셨습니다.");
							continue;
						}
					}
					continue;
				}
				else {
					System.out.println("아이디 또는 비번이 틀렸습니다.");
					continue;
				}
			}
			
			else if(money == 0) {
				System.out.println("종료됩니다.");
				break;
			}
			
			System.out.println("메뉴를 고르세요.");
			cnt=0;
			while(menu[cnt] != null) {
				System.out.print((cnt+1) +". "+ menu[cnt]+"("+price[cnt]+"원) ");
				cnt++;
			}
			System.out.print(">> ");
			
			int pick = Integer.parseInt(sc.nextLine());
			if(pick > cnt || pick <= 0) {
				System.out.println("메뉴를 잘못 선택하셨습니다.");
				continue;
			}
			
			int res = money - price[pick-1];
			if(res < 0) {
				System.out.println("돈이 부족합니다.");
				continue;
			}
			
			System.out.println("잔돈: " +res+"원");
			
			int chen=0, obaek=0, baek=0;
			while(res>0) {
				if(res/1000>0) {
					chen = res / 1000;
					res = res%1000;
				}
				else if(res/500>0) {
					obaek = res / 500;
					res = res%500;
				}
				else {
					baek = res / 100;
					res = res%100;
				}
			}
			System.out.println("천원: "+chen+"개, "+"오백원: "+obaek+"개, "+"백원: "+baek+"개 ");
		}
	}
}
