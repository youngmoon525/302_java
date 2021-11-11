package pack01._if;

public class Test_if {
	public static void main(String[] args) {
		//if 와 else if 그리고 else
		//AND OR연산자를 이용해서 다음의 조건을 만족하는 프로그램을
		//작성하세요.
		// < 초과  , > 미만 , >= 이상 , <= 이하 , ==같음
		//int형 성별코드가 있음. 
		//코드가 1또는 3이라면 남자
		//코드가 2또는 4라면 여자
		//그외에는 성별코드가 잘못되었습니다.
		//라고 출력이되는 프로그램을 작성하세요.
		int code = 2; // Scanner 입력
		// && 논리곱 : 모든 조건을 만족 해야만함.
		// N숫자 1이면서 3인 숫자 ? ↓ 그런숫자는 없기때문에
		// if문 첫번째 블럭킹은 절대 실행이 안된다.
		// OR 논리합 : 하나의 조건이라도 만족하면 TRUE
		// N숫자 2 또는 4 ( 2나 4 둘중하나 라면 실행이됨)
		if(code == 1 && code == 3) {
			System.out.println("남자");
		}else if(code == 2 || code == 4) {
			System.out.println("여자");
		}else {
			System.out.println("코드가 잘못됨");
		}
		
	}
}
