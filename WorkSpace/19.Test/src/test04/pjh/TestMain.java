package test04.pjh;

public class TestMain {
	public static void main(String[] args) {
		DrinkDAO d_dao = new DrinkDAO();
		UserDAO u_dao = new UserDAO();
		UserDTO user = null;
		// dao.connTest();
		while (true) {
			// 1. 로그인 OR 회원가입
			System.out.println("=====메뉴=====");
			System.out.println("0. 종료 1. 로그인 2. 회원가입");
			int menu = u_dao.validIntInputRange(0, 2);
			if (menu == 1) {
				user = u_dao.login();
			} else if (menu == 2) {
				if (u_dao.register()) {
					System.out.println("회원가입 완료되었습니다.");
					System.out.println("다시 로그인해주세요.");
				}
				continue;
			} else {
				System.out.println("시스템 종료");
				break;
			}
			if (user == null)
				continue;
			System.out.println("안녕하세요 " + user.getUSER_NICK() + "님!");
			// 2. 진입.
			// 2-1. 관리자 계정일 시 관리자모드가 됨
			if (user.getADMIN().equals("Y")) {
				System.out.println("==========관리자모드==========");
				while (true) {
					// 0) 전체 상품의 목록을 출력해줌
					d_dao.display();
					// 1) 무엇을 할 것인지 묻는다.
					System.out.println("=====메뉴=====");
					System.out.println("0. 로그아웃 | 1. 상품검색 | 2. 상품추가 | 3. 상품삭제 | 4. 재고관리");
					menu = d_dao.validIntInputRange(0, 4);
					// 1> 상품 검색(음료 이름, 음료 회사)
					if(menu == 1) {
						d_dao.searchProduct();
					}
					// 2> 상품 추가
					else if(menu == 2) {
						d_dao.insertProduct();
					}
					// 3> 상품 삭제
					else if(menu == 3) {
						d_dao.deleteProduct();
					}
					// 4> 재고 관리
					else if(menu == 4) {
						d_dao.manageProduct();
					}
					// 0> 로그 아웃
					else {
						System.out.println("로그아웃합니다.");
						break;
					}
				}
				// 2-2. 관리자 계정이 아닐 시 사용자모드가 됨
			} else {
				System.out.println("==========사용자모드==========");
				int money = 0;
				// 0) 현재 가지고 있는 금액을 입력받음.
				System.out.println("현재 잔액을 입력해주세요.");
				money = d_dao.validIntInput();
				if(money <= 0) {
					System.out.println("잔액의 수가 비정상적이므로 처음으로 돌아갑니다.");
					continue;
				}
				while (true) {
					// 2) 상품을 선택함
					int selDrinkNo = d_dao.selectDrink();
					if(selDrinkNo != -1) {
						// 3) 상품을 계산함.
						money = d_dao.calcDrink(selDrinkNo, money);
					}
					// 4) 로그 아웃을 물어보고 다시 계산할 것인지 물어봄.
					System.out.println("0. 로그아웃 1. 계속 쇼핑");
					if(d_dao.validIntInputRange(0, 1) == 0) {
						System.out.println("로그아웃합니다.");
						user = null;
						break;
					} 
				}
			}
		}
	}
}