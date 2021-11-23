package pack04.Method;

public class Ex02_Calculator {
	//main x 프로그램의 시작점 x
	//void o, void x
	//return타입이 없는 == void
	public void powerOn() {
		System.out.println("전원을 켭니다");
		//  return a ;
	}
//	public String aaa() {
//		return "aaa"; //return키워드를 만나면 메소드는 끝이 나게됨(메인으로 반환)
//		System.out.println("dfafsdfds");//절대 실행되지 않는 코드를 작성 (오류)
//	}
	//메인메소드에서 아래와 같은 결과를 받아서 출력할수있게 , 메소드를 작성하시오.
	//Ex02_Caculator 에서는 연산 처리만 한다 (출력 x) 
	//1.메소드의 이름 : plus -기능 int형 데이터 두개를 입력받아 두 데이터의 합을 return
	//2.메소드의 이름 : minus - 기능 = 두 데이터의 차를 return
	//3.메소드의 이름 : mul - 기능 = 두 데이터의 곱을 return
	//4.메소드의 이름 : div - int형 데이터 두개를 두 데이터의 나눗셈의 결과를 double return
	// int => double (자동)
	public int plus(int x, int y) {
		//int result = x + y;
		//return result;
		return x+y;//int + int = int Type <-
	}
	public int minus(int x, int y) {
		//int result = x - y;
		//return result;
		return x-y;//int - int = int Type <-
	}
	public int mul(int x, int y) {
		//int result = x * y;
		//return result;
		return x*y;//int * int = int Type <-
	}
	
	public double div(int x, int y) {
		//int result = x / y;
		//return result;
		return (double)x/(double)y;//int / int = int Type <-
	}
	
}
