package test03_ysm;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DrinkDAO dao = new DrinkDAO();

		while (true) {
			System.out.print("로그인(1), 회원가입(2), 종료(아무숫자) : ");
			int start = dao.changeInt();
			if (start == 1) { // 로그인
				String mode = dao.login();
				ArrayList<DrinkDTO> list = dao.DrinkSelect();

				if (mode.equals("admin")) { // 관리자모드
					while (true) {
						list = dao.DrinkSelect();
						dao.display(list);
						System.out.print("1.상품 검색, 2.상품 추가, 3.상품 삭제, 4.재고 관리, 5.로그아웃 : ");
						int choice = dao.changeInt();
						if (choice == 1) {
							dao.selectItem();
						} else if (choice == 2) {
							int no = dao.maxNo();
							dao.insertItem(no);
						} else if (choice == 3) {
							dao.deleteItem(list);
						} else if (choice == 4) {
							dao.updateCnt();
						} else if (choice == 5) {
							System.out.println("로그아웃 합니다");
							break;
						} else {
							System.out.println("잘못된 값을 입력했습니다. 다시 입력해주세요");
						}
						System.out.println();
					}

				} else if (mode.equals("user")) { // 사용자모드
					dao.order();
				} else {
					System.out.println("아이디나 비밀번호가 틀렸습니다.");
					continue;
				}
			} else if (start == 2) {// 회원가입
				ArrayList<String> user = dao.selectUser();
				dao.welcom(user);
			} else { // 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		sc.close();
	}
}