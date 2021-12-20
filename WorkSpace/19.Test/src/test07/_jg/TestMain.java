package test07._jg;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		TestDAO dao = new TestDAO();
		ArrayList<TestDTO> list = dao.selectDrink();
		Scanner sc = new Scanner(System.in);
		
		
		
		while(true) {
			System.out.println("로그인하세요");
			String mode = dao.login();
			if(mode.equals("admin")) {	//관리자 모드
				System.out.println("관리자 로그인 성공");
				dao.display();
				System.out.println("1.상품검색2.상품추가3.상품삭제4.재고관리5.로그아웃");
				int option = dao.rtnint();
				if(option == 1) {
					System.out.println("1.음료이름으로 검색 2.음료회사로 검색");
					int num = dao.rtnint();
					if(num == 1) {
						System.out.println("음료 이름으로 검색");
						String name = sc.nextLine();
						dao.display2("name",name);
					}else if(num == 2) {
						System.out.println("음료 회사로검색");
						String company = sc.nextLine();
						dao.display2("company",company);
					}
				}else if(option ==2) {
					dao.InsertDrink(dao.maxNo());
				}else if(option ==3) {
				//	dao.delete(data);
				}else if(option ==4) {
					
				}else if(option ==5) {
					
				}
			}else if(mode == "user") {	//사용자 모드
				System.out.println("사용자 로그인 성공");
				dao.order();
			}
		}
				
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		int mode = dao.inputInt();
//		dao.display();
	/*	while(true) {
			int menu = Integer.parseInt( sc.nextLine() );
			System.out.println("모드를 선택하세요 "+menu);
			if(menu == 0) {
				System.out.println("관리자 모드");
			}
			else if(menu == 1) {
				System.out.println("사용자 모드");
				dao.display();// 메뉴를 보여줌
				dao.rtnInt("음료를 선택하시오", 1, 5);
				
			}
		}
	*/	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
