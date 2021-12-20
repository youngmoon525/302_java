package test01_ksgi;

import java.util.ArrayList;

public class Seulgi_Main {
	public static void main(String[] args) {
		DAO dao = new DAO();
		//dao.connDB();
		//dao.connTest();
		
		int start = 0;
		while(true) {
			start = dao.start("1.로그인 2.회원가입");
			//로그인을 선택했을 경우
			if(start == 1){
				String adminYorN = dao.login();
				ArrayList<DTO> list = dao.list();
				//로그인 결과가 관리자 계정일 경우
				if(adminYorN.equals("Y")) {
					while(true) {
						list = dao.list();
						dao.display(list);
						//메뉴 선택하기
						start = dao.start("1.검색 2.추가 3.삭제 4.재고 변경 5.로그아웃");
						//1.검색
						if(start == 1) {
							start = dao.start("1.이름으로 검색  2.제조사로 검색");
							String search = null;
							if(start == 1) {
								dao.searchN(list, search);
							}else if(start == 2) {
								dao.searchC(list, search);
							}
						//2.추가	
						}else if(start == 2) {
							int max_num = dao.maxNo();
							dao.insert(max_num);
						//3.삭제	
						}else if(start == 3) {
							int delMenu = dao.choice("삭제할 음료의 번호를 입력하세요.");
							dao.delete(delMenu);
							dao.resetNum(delMenu);
						//4.재고 변경	
						}else if(start == 4) {
							int upMenu = dao.choice("재고를 변경할 음료의 번호를 입력하세요.");
							dao.updateCnt(upMenu);
						//5.로그아웃	
						}else if(start == 5) {
							dao.logOut();
							break;						
						}else {
							System.out.println("잘못된 입력입니다.");
						}
					}
				
				//로그인 결과가 일반 계정일 경우
				}else if(adminYorN.equals("N")){
					while(true) {
						list = dao.list();
						dao.display(list);
						start = dao.start("1.주문 2.로그아웃");
						if(start == 1) {
							//금액 입력받기
							int money = dao.start("금액을 입력하세요.");
							//음료 선택하기
							int choiceMenu = dao.choice("음료를 선택하세요.");
							if(dao.checkCnt(choiceMenu) != 0) {
								//잔돈 반환 + 재고-1
								dao.calculate(money, dao.checkCnt(choiceMenu));
							}
						}else if(start == 2) {
							//로그아웃
							dao.logOut();
							break;
						}else {
							System.out.println("잘못된 입력입니다.");
						}
					}
				}
				
			//회원가입을 선택했을 경우	
			}else if(start == 2){
				dao.join();
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		
		
		
	}
}
