package pack05._static;

import java.util.Scanner;

public class Test01_OddEven {

	public static void main(String[] args) {
		// 임의의 정수 2개를 입력받아(num1,num2);
		// 두 정수 사이의 짝수의 합과 홀수의 합을 구하는 메소드를 만드시고 각각,
		// (- 짝수의 합을 구하는 메소드 : Test01_인스턴스 멤버)
		// (- 홀수의 합을 구하는 메소드 : Test01_스태틱 멤버)
		// 결과값은 메소드에서 리턴 받은값을 메인 메소드에서 출력.
		// ※인스턴스 메소드는 인스턴스화 해서 호출
		// 스태틱 메소드는 클래스 자체로 호출
		// 20 , 30 ? 21 , 22 , ~~30 ? 1씩 증가 ?
		// try{ } catch(Exception e){ } 를 통해서 숫자 외에 값을
		// 입력을 받게 되면 재입력을 요청.

		int num1 = rtnInt();
		int num2 = rtnInt();
		System.out.println(oddSum(num1, num2));
		Test01_OddEven to = new Test01_OddEven();
		System.out.println(to.evenSum(num1, num2));
		// static멤버끼리는 언제든지 접근이 가능함.

		// num1 , num2 , sc , main메소드 지역안에서만 사용이가능한
		// 지역 변수(멤버)
		// 시작점 num1 , 끝 num2
		// 21~29 1씩 증가하는 규칙
		// 20 , 30

	}// main <-

	// 숫자를 입력할때까지 무한 반복하는 메소드를 만들기
	static int rtnInt() {
		Scanner sc = new Scanner(System.in);
		int temp_int = 0;
		while (true) {
			try {
				temp_int = Integer.parseInt(sc.nextLine());
				return temp_int;
			} catch (Exception e) {
				System.out.println("잘못된입력입니다. 숫자만 입력가능");
			}
		} // 무조건 문자열만 return하는 메소드를 만들어보세요.
	}
	static String rtnString() {
		Scanner sc = new Scanner(System.in);
		String temp_str = "";
		while (true) {
			try {
				temp_str = sc.nextLine();
				Integer.parseInt(temp_str);
			} catch (Exception e) {
				System.out.println("잘못된입력입니다. 숫자만 입력가능");
				return temp_str;
			}
		} // 무조건 문자열만 return하는 메소드를 만들어보세요.
	}
	// void가 아닌 타입
	static int oddSum(int num1, int num2) {
		// 누적 :<기존값 : <=기존값 + 새로운값
		int result = 0;
		for (int i = num1; i < num2; i++) {
			if (i % 2 == 1) {
				result += i;
			}
		}
		return result;
	}

	int evenSum(int num1, int num2) {
		// 누적 :<기존값 : <=기존값 + 새로운값
		int result = 0;
		for (int i = num1; i < num2; i++) {
			if (i % 2 != 1) {
				result += i;
			}
		}
		return result;
	}
}
