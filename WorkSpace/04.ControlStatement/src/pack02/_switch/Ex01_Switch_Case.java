package pack02._switch;

public class Ex01_Switch_Case {
	public static void main(String[] args) {
		// 사용빈도가 낮기때문에 공부를 따로 할 필요는 없음.
		// 선택문 (switch - case )
		// 다중 if else if 를 간략하게 표현
		// 값을 기준으로만 판단을하기때문에 조건을 주기가 까다롭다.
		// 이런 제한사항 때문에 실무에서는 거의 사용을 안한다.
		// switch ( 기준값 )
		// case 값1 :
		// 값 이 case에 있는 값1과 같을때 실행하는 부분.
		// break;
		// case 값2 .........
		int score = 100;
		// 90~100 : A
		// 90~99 / 9 ? case 
		// 80~89 / 8 ? case
		switch (score / 10) {
		case 10:
			System.out.println("A학점입니다.");
		case 9:
			System.out.println("A학점입니다.");

		case 8:
			System.out.println("B학점입니다.");
			break;
		}// switch의 지역<-

	}
}
