package test06._osh;
import java.util.ArrayList;
public class DrinkMain {
	public static void main(String[] args) {
		DrinkDAO dao = new DrinkDAO();

		while (true) {
			int choice = dao.Scanner("1.로그인 2.관리자모드 3.종료");
			if (choice == 1) { // 로그인
				if (dao.login()) {
					while (true) {
						ArrayList<DrinkDTO> list = dao.list();
						dao.display(list);
						int money = dao.Scanner("금액을 입력해주세요");
						int menu = dao.select("선택할 음료의 숫자를 눌러주세요.");						
						dao.calculate(money, menu);
						dao.Cnt(menu);      //? 오류 나고 CONTINU 했는데 WHILE 로 안가지지?
						int choice1 = dao.Scanner("1. 계속 주문 2. 로그아웃  ");
						if (choice1 == 2) {
							System.out.println("로그아웃 되었습니다.");
							break;
						} else if (choice1 == 1) {
							dao.Scanner("아무 숫자를 누르면 메인으로 돌아갑니다.");
						}//choice1
					}//while
				}//login 안되면?
			} else if (choice == 2) { // 관리자모드
				if (dao.login()) {
					while (true) {
						ArrayList<DrinkDTO> list = dao.list();
						dao.display(list);
						int manage= dao.Scanner("1. 상품검색  2. 상품추가  3. 상품삭제  4. 재고관리 5. 로그아웃");
						if(manage==1) {//상품검색	
							int choice3= dao.Scanner("1. 음료 이름으로 검색 , 2.음료회사 이름으로 검색 ");
							if(choice3 == 1) {
								dao.search("name");
							}else if(choice3 ==2) {
								dao.search("company");
							}else {
								System.out.println("잘못입력하였습니다.");
							}						
							dao.Scanner("아무 숫자를 누르면 메인으로 돌아갑니다.");
						}else if(manage==2) {//상품추가
							int max_no = dao.maxNo();
							dao.insert(max_no);
							dao.Scanner("아무 숫자를 누르면 메인으로 돌아갑니다.");
						}else if(manage==3) {//상품삭제
					        int delMenu = dao.select("삭제할 음료의 번호를 입력하세요.");
						    dao.delete(delMenu);
						   // dao.resetNo(delMenu);
							dao.Scanner("아무 숫자를 누르면 메인으로 돌아갑니다.");
						}else if(manage==4) {//재고관리
						 	int changemenu= dao.select("수정할 음료의 번호를 입력하세요.");
							dao.update(changemenu);
							dao.Scanner("아무 숫자를 누르면 메인으로 돌아갑니다.");
						}else if(manage==5) {//로그아웃
							System.out.println("로그아웃 되었습니다.");
							break;
						}//manage    ?? 뭐 더할거 체크하기
					}//while 
				}//login
			} else if (choice == 3) { // 종료
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("잘못 눌렸습니다.");
			} // choice(if/else if/else)
		} // while
		dao.dbClose(); 
	}// main
}// class
