package pack05._japangi;

import java.util.Scanner;

public class DrinkDAO {
	Scanner sc = new Scanner(System.in);
	String admin_id = "admin";
	String admin_pw = "admin1234";
	
	public String rtnStr(String msg ) {
		String temp_str = "";
		while (true) {
			try {
				System.out.println(msg);
				temp_str = sc.nextLine();
				Integer.parseInt(temp_str);
				System.out.println("잘못된 입력입니다.");
				
			} catch (Exception e) {
				return temp_str ;
			}
		}
	}
	
	
	public int rtnInt(String msg ) {
		while (true) {
			try {
				System.out.println(msg);
				int temp_int = Integer.parseInt(sc.nextLine());
				return temp_int ;
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	public int rtnInt(String msg ,int beginInt , int endInt ) {
		while (true) {
			try {
				System.out.println(msg);
				int temp_int = Integer.parseInt(sc.nextLine());
				if(beginInt <= temp_int && endInt >= temp_int) {
					return temp_int ;
				}
				System.out.print("숫자가 범위를 벗어났습니다." );
				System.out.println( " : 범위 ( " + beginInt + "~" + endInt + "까지)");
 			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	public void display(DrinkDTO[] dtos) {
		for (int i = 0; i < dtos.length; i++) {
			System.out.print(i+1 + ".");
			System.out.print("" + dtos[i].name + "\t");
			System.out.print("금액:" + dtos[i].price );
			System.out.print("수량:" + dtos[i].cnt);
			System.out.println();
		}
		
	}

	public int selectDrink(DrinkDTO[] dtos, int choice, int money) {
		if(dtos[choice - 1].cnt < 1 ) {
			System.out.println("남은 수량이 없습니다.");
		}else {
			if(dtos[choice - 1].price <= money ) {
				money = money - dtos[choice - 1].price ;
				
			}else {
				System.out.println("입력하신 금액이 부족합니다.");
			}
		}
		return money;
	}

	public boolean login() {
		String id = rtnStr("id를 입력해주세요.");
		String pw = rtnStr("pw를 입력해주세요.");
		if(id.equals(admin_id) && pw.equals(admin_pw)) {
			System.out.println("로그인 되었습니다.");
			return true;
		}
		System.out.println("없는 ID와 비밀번호 입니다.");
		return false;
	}


	public DrinkDTO[] addDrink(DrinkDTO[] dtos) {
		DrinkDTO[] temp_dtos = new DrinkDTO[dtos.length+1];
		for (int i = 0; i < dtos.length; i++) {
			temp_dtos[i] = dtos[i];
		}
		String name = rtnStr("음료의 이름을 입력 해주세요.");
		int price = rtnInt("음료의 가격을 입력해주세요", 1, 3000);
		int cnt = rtnInt("음료의 수량을 입력해주세요");
		DrinkDTO dto = new DrinkDTO(name, price, cnt);
		temp_dtos[temp_dtos.length-1] = dto;
		return temp_dtos ;
	}
	
	public DrinkDTO[] modifyDrink(DrinkDTO[] dtos) {
		
		int select_num = rtnInt("수정할 음료의 번호를 입력해주세요.", 1, dtos.length);
		//1~4 , -1 , 인덱스에 있는값을 우리가 사용하기위해서 범위를 지정해줌.
		//0~3 
		
		String name = rtnStr("음료의 이름을 입력 해주세요.");
		int price = rtnInt("음료의 가격을 입력해주세요", 1, 3000);
		int cnt = rtnInt("음료의 수량을 입력해주세요");
		DrinkDTO dto = new DrinkDTO(name, price, cnt);
		dtos[select_num-1] = dto;
		display(dtos);
		return dtos ;
	}


	public DrinkDTO[] delDrink(DrinkDTO[] dtos) {
		display(dtos);
		int select_num = rtnInt("삭제할 음료의 번호를 입력해주세요.", 1, dtos.length);
		dtos[select_num-1] = null;
		DrinkDTO[] temp_dtos = new DrinkDTO[dtos.length-1];
		int j = 0;
		for (int i = 0; i < dtos.length; i++) {
			if(dtos[i] !=null) {
				temp_dtos[j] = dtos[i];
				j++;
			}
		}
		display(temp_dtos);
		return temp_dtos ;
	}
}
