package pack04.Method;

public class Ex02_CalculatorMain {
	//시작점 , main O
	public static void main(String[] args) {
		//Ex02_Calculator를 객체로 만드시고 , powerOn을 시켜보기.
		Ex02_Calculator cal = new Ex02_Calculator();
		cal.powerOn();
		System.out.println(cal.plus(2, 5));
		System.out.println(cal.minus(2, 5));
		System.out.println(cal.mul(2, 5));
		System.out.println(cal.div(2, 5));
	}
}
