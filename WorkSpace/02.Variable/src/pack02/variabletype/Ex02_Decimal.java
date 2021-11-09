package pack02.variabletype;

public class Ex02_Decimal {
	public static void main(String[] args) {
		//숫자형 데이터를 표현할수있는 데이터타입이 여러개 존재한다.
		//각 데이터타입의 특성을 알아보고 사용해보기.
		//중요: int , double
		//변수는 표현할수있는 범위가 정해져있는데 그 범위를
		//외울 필요가없다. 범위를 넘어서면 IDE(이클립스)가 알려줌.
		//변수는 표현할수있는 범위가 정해져있음<-
		int i = 1234567890;
		System.out.println("변수 int i의 값 : " + i);
		long l = 1234567890123456789L;
		//long을 사용하지 않는 이유는 값을 할당할때 뒤에 l을 붙여줘야하는
		//번거러움이 있음 (사용빈도가 낮다)
		System.out.println("변수 long l의 값 : " + l);
		//int i2 = 3.14; 정수만 저장이 가능함.
		//실수형 데이터를 저장할때 사용하는 변수가 따로 있음.
		//float , double<-
		//float도 long과 마찬가지로 값을 할당할때 뒤에 f를 붙어여줘야만
		//하는 번거러움 있음.
		//float , double형 데이터 타입의 변수 f와 d를 만드신후
		//값을 각각 3.14 , 6.11 할당하시고 출력해보기.
		float f = 3.14F;
		double d = 6.11;
		System.out.println("float f의 값은 :" + f
				+ "double d의 값은 : " + d);
		System.out.println(f+d);
		
		
	}
}
