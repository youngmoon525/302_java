package pack02_TryCatch;

import java.util.Scanner;

public class ExTest_Pos_System {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] menus = new String[256]; // 메뉴 이름
		int[] prices = new int[256]; // 메뉴 가격
		int money = 0, purpose = 0, repeat = 0, selectNum = 0; // 현재 남은 돈, 목적
		String id = "", pw = "";
		int menuCount = 4;
		String productName="";
		int productPrice=0;

		// 일단 초기화.
		menus[0] = "콜라";
		menus[1] = "사이다";
		menus[2] = "환타";
		menus[3] = "2프로";

		prices[0] = 800;
		prices[1] = 1000;
		prices[2] = 1200;
		prices[3] = 700;

		// 전체 루프
		while (true) {
			// 모드 체크
			System.out.println("======메인 메뉴======");
			System.out.println("단순 결제는 1, 결제창을 닫으려면 -1, Admin계정은 0을 입력해주세요");
			try {
				purpose = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다!\n다시 입력해주세요.\n");
				continue;
			}

			// 모드별로 다른 처리
			if (purpose == -1) { // 나가
				System.out.println("결제창이 닫힙니다.");
				break;
			} else if (purpose == 0) { // 어드민 계정
				// 아이디와 비밀번호 입력
				System.out.println("======계정입력======");
				System.out.println("아이디와 비밀번호를 입력해 주십시오");
				System.out.print("아이디 : ");
				id = sc.nextLine();
				System.out.print("비밀번호 : ");
				pw = sc.nextLine();
				// 로그인 체크.
				if (id.equals("admin") && pw.equals("admin")) {
					System.out.println("관리자 모드에 진입합니다.");
					while (true) {
						System.out.println("1. 음료 추가 / 2. 음료 삭제 / 3. 음료 수정 / 그 외 숫자. 관리자모드 나가기");
						try {
							purpose = Integer.parseInt(sc.nextLine());
						} catch (Exception e) {
							System.out.println("잘못된 입력입니다!\n다시 입력해주세요");
							continue;
						}
						
						if(purpose == 1) {
							System.out.println("====음료 추가====");
							System.out.print("추가할 음료의 이름 : ");
							productName = sc.nextLine();
							System.out.print("추가할 음료의 가격 : ");
							try {
								productPrice = Integer.parseInt(sc.nextLine());
							} catch (Exception e) {
								System.out.println("잘못된 입력입니다!\n관리자모드로 돌아갑니다.");
								continue;
							}
							menus[menuCount] = productName;
							prices[menuCount] = productPrice;
							menuCount++;
							System.out.println("추가되었습니다.");
						} else if(purpose == 2) {
							System.out.println("====음료 삭제====");
							int menuIndex = 0;
							while (menuIndex < menuCount) {
								System.out.print((menuIndex + 1) + ". " + menus[menuIndex] + "(" + prices[menuIndex] + ") ");
								menuIndex++;
							}
							System.out.print("\n삭제할 음료의 번호를 써주세요. : ");
							try {
								purpose = Integer.parseInt(sc.nextLine());
							} catch (Exception e) {
								System.out.println("잘못된 입력입니다!\n관리자모드로 돌아갑니다.");
								continue;
							}
							// 여기서 번호를 체크
							if(purpose > menuCount || purpose <= 0) {
								System.out.println("잘못된 입력입니다!\n관리자모드로 돌아갑니다.");
								continue;
							}
							for(int i = purpose-1; i<menuCount-1; i++) {
								menus[i] = menus[i+1];
								prices[i] = prices[i+1];
							}
							menuCount--;
							menus[menuCount] = null;
							prices[menuCount] = 0;
							System.out.println("삭제되었습니다.");
						} else if(purpose == 3) {
							System.out.println("====음료 수정====");
							int menuIndex = 0;
							while (menuIndex < menuCount) {
								System.out.print((menuIndex + 1) + ". " + menus[menuIndex] + "(" + prices[menuIndex] + ") ");
								menuIndex++;
							}
							System.out.print("\n수정할 음료의 번호를 써주세요. : ");
							try {
								purpose = Integer.parseInt(sc.nextLine());
							} catch (Exception e) {
								System.out.println("잘못된 입력입니다!\n관리자모드로 돌아갑니다.");
								continue;
							}
							// 여기서 번호를 체크
							if(purpose > menuCount || purpose <= 0) {
								System.out.println("잘못된 입력입니다!\n관리자모드로 돌아갑니다.");
								continue;
							}
							System.out.print("음료의 수정될 이름 : ");
							productName = sc.nextLine();
							System.out.print("음료의 수정될 가격 : ");
							try {
								productPrice = Integer.parseInt(sc.nextLine());
							} catch (Exception e) {
								System.out.println("잘못된 입력입니다!\n관리자모드로 돌아갑니다.");
								continue;
							}
							menus[purpose-1] = productName;
							prices[purpose-1] = productPrice;
							System.out.println("수정되었습니다.");
						} else {
							System.out.println("관리자모드에서 나갑니다.");
							break;
						}
					}
				} else {
					System.out.println("로그인에 실패하였습니다 처음으로 돌아갑니다.");
					continue;
				}
			} else if (purpose == 1) { // 결제 화면
				System.out.println("======결제 화면======");

				while (true) {
					// 현재 돈 체크(1회)
					System.out.println("금액을 입력하세요. : ");
					try {
						money = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						System.out.println("잘못된 입력입니다!\n다시 입력해주세요");
						continue;
					}
					break;
				}

				while (true) {
					System.out.println("메뉴를 고르세요.");
					int menuIndex = 0;
					while (menuIndex < menuCount) {
						System.out.print((menuIndex + 1) + ". " + menus[menuIndex] + "(" + prices[menuIndex] + ") ");
						menuIndex++;
					}

					while (true) {
						try {
							System.out.print("\n>> ");
							selectNum = Integer.parseInt(sc.nextLine());
						} catch (Exception e) {
							System.out.println("다시 입력해 주세요.");
							continue;
						}
						break;
					}

					System.out.println(menus[selectNum - 1] + "를 선택하셨습니다");
					if (money < prices[selectNum - 1]) {
						System.out.println("돈이 부족합니다.");
					} else {
						money -= prices[selectNum - 1];
						System.out.println("결제완료. 잔돈은 " + money + "원입니다.");
						System.out.println("천원 : " + (money / 1000) + "개, 오백원 : " + (money / 500 % 2) + "개, 백원 : "
								+ (money / 100 % 5) + "개");
					}
					System.out.println("결제를 더 하시려면 1, 끝내시려면 아무숫자를 입력해주세요.");

					while (true) {
						System.out.print(">> ");
						try {
							repeat = Integer.parseInt(sc.nextLine());
						} catch (Exception e) {
							System.out.println("제대로 입력해주세요.");
							continue;
						}
						break;
					}

					if (repeat == 1) {
						continue;
					} else {
						System.out.println("결제화면에서 벗어납니다.");
						break;
					}
				}
			} else {
				System.out.println("잘못된 입력입니다!\n다시 입력해주세요.\n");
				continue;
			}
		}
	}
}
