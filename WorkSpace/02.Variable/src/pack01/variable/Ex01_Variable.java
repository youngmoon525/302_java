package pack01.variable;

public class Ex01_Variable {
//주석 : 컴퓨터가 인식하지 않는 글씨 
//작업을 할때 Class를 추가하고 Class{ }<-
//사이에 main이라는 메소드를 만들고 {}그안에서 작업을한다.
//6장 Class_Method를 배우기전까지는 외워서 사용한다.
//소문자로 main이라고 타이핑을 한 후 ctrl + space bar
	public static void main(String[] args) {
		//main메소드의 {} 중괄호 사이에서 작업을 한다.
		//변수의 선언은 변수의타입 변수의이름;
		int a;//변수의 선언
		int b;//int라는 변수타입은 정수형 숫자를
			  //담을 때 쓰는 타입이다.
		a=10;//java에서는 값을 할당한다.
			   // =를 기준으로 좌측에 있는 변수에
			   // 우측에 있는 값을 담는다.
		//b라는 변수에 30이라는 값을 담아보세요.
		//c라는 변수를 만들고 40이라는 값을 담아보세요.
		//보라색으로 나오는 것은 자바에서의 예약어
		b = 30 ;
		int c ;
		c = 40 ;
		//syso  + 자동 완성
		System.out.println(c);
	}
}
