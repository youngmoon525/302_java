package pack05._japangi;

public class JapangiMain {
	public static void main(String[] args) {
		DrinkDTO[] dtos = new DrinkDTO[4];
		dtos[0] = new DrinkDTO("콜라", 800, 10);
		dtos[1] = new DrinkDTO("사이다", 1000, 9);
		dtos[2] = new DrinkDTO("환타", 700, 2);
		dtos[3] = new DrinkDTO("음료4", 2000, 0);
		DrinkDAO dao = new DrinkDAO();
		//dtos <= 음료 추가 4건 로직 - O
		//while(true){
			int menu = dao.rtnInt("1.사용자모드  2.관리자모드",0,2);
			//1.사용자
				int money = dao.rtnInt("금액을 입력 해주세요.");
				dao.display(dtos);	
				//-음료 목록 보여줌(메소드) - O
				//-음료 선택(메소드) index ?
				//-음료 선택 후 처리(메소드)금액 체크 , 잔돈 반환 등
			//2.관리자
				//0.관리자로 로그인 가능한지 체크(메소드)
				//1.음료 추가(메소드)
				//2.음료 삭제(메소드)
				//3.음료 수정(메소드)
				//4.음료 수량 추가(메소드)
		//}
				dao.sc.close();
	}
	
}
