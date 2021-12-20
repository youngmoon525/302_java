package test08.ysb;

public class Main3 {
	public static void main(String[] args) {
		
		DrinkDAO dao = new DrinkDAO();
		DrinkDTO dto = null;
		int money;
		
		while(true) {
			System.out.println("로그인");
			System.out.println("1.로그인  0.종료");
			int mode = dao.inputint();
			if(mode ==0) {
				System.out.println("종료합니다");
				break;
			}else if(mode ==1) {
				String adpick = dao.flogin();
				//dao.display(dto); < = 음료 목록을 한번만 보여주면 되기때문에 주석
				if(adpick.equals("admin")) {
					while(true) {
						dao.display();
						System.out.println("1.검색 2.추가 3.삭제 4.재고 관리 5.로그아웃");
						int pick = dao.inputint();
						if(pick ==1) {
							System.out.println("1. 음료 이름으로 검색");
							System.out.println("2. 음료 회사로 검색");
							int pick2 = dao.inputint();
							if(pick2 ==1) {
								dao.searchName("name");
							}else if(pick2 ==2) {
								//dao.searchCompany();
								dao.searchName("company");
							}
						}else if(pick ==2) {
							int maxNo = dao.maxNo();
							dao.insertMenu(maxNo);
						}else if(pick ==3) {
							dao.deleteMenu();
						}else if(pick ==4) {
							dao.control();
						}else if(pick ==5) {
							System.out.println("로그아웃");
							break;
						}
					}
				}else if(adpick.equals("user")) {
					dao.display();
					System.out.println("금액을 입력하세요");
					money = dao.inputint();
					int choice = dao.choiceMenu(dto);
					if(dao.check(choice)) {
						dao.change(money, choice);
						System.out.println("음료가 나왔습니다");
						System.out.println("로그아웃 합니다");
						break;
					}else {
						System.out.println("잘못입력 하셨습니다");
						continue;
					}
				}
				
			}
}
	}
}

