package test05._kc;

import java.util.ArrayList;
import java.util.Scanner;


public class TestMain {

	public static void main(String[] args) {
		DrinkDAO dao = new DrinkDAO();
		Scanner sc = new Scanner(System.in);
		
		int menu= 0,money = 0, change=0;
		String userID ,userPW;
		System.out.println("아이디를 입력");
		userID = sc.nextLine();
		System.out.println("비밀번호를 입력");
		userPW = sc.nextLine();
		//우선 아이디만 데이터베이스에 있는것이면 통과하도록 하였습니다 id = 1111로 하시면됩니다
		while(true) {
			if(dao.idCheck(userID)) {
				//로그인 성공
				//1. 관리자 모드 2.사용자모드 선택
				System.out.println("모드를 선택하세요");
				System.out.println("1. 관리자 모드 2.사용자모드");
				menu = Integer.parseInt(sc.nextLine());
				if(menu == 1) {
					//관리자모드
					ArrayList<DrinkDTO> list = dao.selectBoardList();
					System.out.println("======== 상품목록 ========");
					dao.display(list);
					System.out.println("========================");
					System.out.println("1.상품검색 2.상품추가 3.상품삭제 4.재고관리 5.로그아웃");
					menu = Integer.parseInt(sc.nextLine());
					if(menu == 1) {
						//상품검색
						System.out.println("1. 이름으로 검색 2.음료회사로 검색");
						menu = Integer.parseInt(sc.nextLine());
						
						if(menu == 1) {//이름으로 검색
							System.out.println("음료의 이름 입력");
							String name = sc.nextLine();
							dao.nameSearch(name);
							//sc.close();
							System.out.println("\n종료는 0 \n다시 시작은 1");
							if (dao.inputInt() != 1)
								break;
//							menu = Integer.parseInt(sc.nextLine());
//							if (menu == 0) {
//								System.out.println("종료");
//								break;
//							}else {
//								System.out.println("다시시작");
//							}
						}else if(menu ==2) {
							//회사로 검색
							System.out.println("음료의 회사 입력");
							String com = sc.nextLine();
							dao.comSearch(com);
						}else {
							System.out.println("잘못입력");
							break;
						}
					}else if(menu ==2) {
						//상품추가
						dao.drinkAdd(list);
					}else if(menu == 3) {
						//상품삭제
						dao.DrinkDel(list);
					}else if(menu == 4) {
						//재고관리
						//update drink_tbl set cnt = cnt + ? where no = ? 
					}else if(menu == 5){
						//로그아웃
						
					}else {
						System.out.println("잘못입력");
					}
				}else if(menu ==2) {
					//사용자모드
					//전체 상품출력
					ArrayList<DrinkDTO> list = dao.selectBoardList();
					dao.display(list);
					System.out.println("금액입력 : ");
					money = Integer.parseInt(sc.nextLine());
					System.out.println("주문하실상품의 번호를 입력");
					menu = Integer.parseInt(sc.nextLine())-1;
					dao.choiceDrink(menu,money,list);
					//dao.selectdrink(menu);
				}else {
					System.out.println("잘못입력하셨습니다");
				}
			}else {
				//로그인 실패
				System.out.println("로그인실패");
				break;
			}
		}
		
		
		//12.19 처음부터 다시
		/*
		System.out.println("1.로그인 2.회원가입");
		menu = Integer.parseInt(sc.nextLine()) ;
		System.out.println("번호를 입력해주세요");
		if(menu == 1) {
			//로그인
			System.out.println("번호를 입력해주세요");
			int num= Integer.parseInt(sc.nextLine()) ;
			System.out.println("이름을 입력해주세요");
			String name = sc.nextLine();
			if(dao.login(num,name)) {
				//로그인성공하면 1.회원정보 수정 2.회원탈퇴 3.공지사항보기
				System.out.println("성공");
				System.out.println("1.회원정보수정 \n2.회원탈퇴 \n3.공지사항보기");
				menu = Integer.parseInt(sc.nextLine()) ;
				if(menu == 1) {
					//회원정보 수정
					System.out.println("");
					System.out.println("회원정보를 수정합니다\n바꾸실이름을 입력해주세요");
					name = sc.nextLine();
					dao.changeName(name);
				}else if(menu ==2 ) {
					//회원탈퇴
				}else if(menu == 3) {
					//공지사항
				}else {
					System.out.println("잘못입력하셨습니다");
				}
			}else {
				System.out.println("실패");
			}
		}else if(menu == 2) {
			//회원가입
			System.out.println("사용하실 아이디를 입력하세요");
			String userID= sc.nextLine();
			if(dao.idCheck(userID)) {
				System.out.println("중복");
			}else {
				System.out.println("사용이 가능한 아이디입니다");
				System.out.println("사용하실 비밀번호를 입력하세요");
				String userPW= sc.nextLine();
				dao.BoardInsert(userID,userPW);
			}
		}
		
		else {
			System.out.println("잘못입력하셨습니다");
		}
		*/
		

	}

}
