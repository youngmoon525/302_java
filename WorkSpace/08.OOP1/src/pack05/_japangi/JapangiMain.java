package pack05._japangi;

public class JapangiMain {
	public static void main(String[] args) {
		DrinkDTO[] dtos = new DrinkDTO[4];
		DrinkDAO dao = new DrinkDAO();
		dtos[0] = new DrinkDTO("콜라", 800, 10);
		dtos[1] = new DrinkDTO("사이다", 1000, 9);
		dtos[2] = new DrinkDTO("환타", 700, 2);
		dtos[3] = new DrinkDTO("음료4", 2000, 0);
		int money = 0 ;
		//dtos <= 음료 추가 4건 로직 - O
		// 자판기 
		while(true){
			String[] a = {"스트링"};
			System.out.println(a);
			int menu = dao.rtnInt("1.사용자모드  2.관리자모드 , 0.종료",0,2);
			//1.사용자
			if(menu == 1) {
				if(money == 0) {
				money = dao.rtnInt("금액을 입력 해주세요.",100,50000);
				}
				dao.display(dtos);	
				//-음료 목록 보여줌(메소드) - O
				int choice = dao.rtnInt("음료를 선택해주세요.",1,dtos.length);
				money = dao.selectDrink(dtos , choice , money);
				System.out.println("잔돈" + money);
				//잔돈 반환하는 로직 % , / 
			}else if (menu == 0) {
				System.out.println("잔돈 반환" + money);
				System.out.println("프로그램을 종료 합니다.");
				break;
			}else {
			//2.관리자
				//0.관리자로 로그인 가능한지 체크(메소드)
				if(dao.login()) {
					//1.음료 추가(메소드)
					//dtos [] [] [] []
					//dtos [] [] [] [] ( [] ) <- 
					int admin_menu = dao.rtnInt("1.음료추가 2.음료삭제 3.음료수정",1,4);
					if(admin_menu == 1) {
						dtos = dao.addDrink(dtos);
						dao.display(dtos);
					}else if(admin_menu == 2){
						dtos = dao.delDrink(dtos);
					}else if(admin_menu == 3) {
						dtos = dao.modifyDrink(dtos);
					}
					
					//2.음료 삭제(메소드)
					//3.음료 수정(메소드)
					//4.음료 수량 추가(메소드)
				}else {
					System.out.println("아이디 비밀번호 오류 -프로그램 종료");
				}
				
			}
				
		}
				dao.sc.close();
	}
	
}
