package pack01.variable;

public class Ex02_Variable {
	public static void main(String[] args) {
		//7장전까지 항상 우리가 작업하는 공간
		//소문자main + 자동완성 이용 메인이라는 메소드
		//변수에 선언과 동시에 값을 할당하는것(초기화)
		//int a ;
		//a = 10 ;
		int a = 10;//변수의 초기화 식
		//변수 a를 콘솔창에 출력하세요.
		System.out.println(a);
		//같은 타입의 변수를 여러개 초기화 시키기(나열)
		int b = 20 , c = 30 , d = 40 ;
		//b,c,d 변수는 각각 맨앞에 int형 데이터 타입을
		//가지게 된다.
		System.out.println("int형 변수 b의 값은" + b);
		//println( ) ; 항상 하나의 값만 넣을 수 있다.
		//int형 변수 c의 값은 : c
		//int형 변수 d의 값은 : d
	}
}
