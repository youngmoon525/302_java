package pack02.IDrink;

import java.util.Scanner;

public class CDrinkDAO implements IDrinkDAO{

	@Override
	public int inputPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display(DrinkDTO[] dtos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int calc(DrinkDTO[] dtos, int money) {
		int pInt = 0;
			while (true) {
				try {//오류가나면 catch로 빠지는것
					System.out.println("음료를 선택해 주세요.");
					Scanner sc = new Scanner(System.in);//이줄이 뭘 의미할까? Scanner 사용의 준비
					String data = sc.nextLine();//콘솔창을 엔터키를치면 String으로 리턴을 해주는 메소드
					pInt = Integer.parseInt(data);//int값을 숫자로 바꿈
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					continue;
				}
				if(pInt >= dtos.length || pInt <0) {
					
				}else {
					break;
				}
			}
			return money - dtos[pInt].price;
		}
	@Override
	public void showChanges(int change) {
		// TODO Auto-generated method stub
		
	}
	
}
