package pack04.Method;

public class Ex01_MethodMain {
	public static void main(String[] args) {
		//인스턴스 멤버 == 객체가 인스턴스화 되어야지만 접근할수있는 부분
		Ex01_Method em = new Ex01_Method();
		em.method1();
		//em.method1()+50; //return X
		int data = em.method2()+80; //return O
		System.out.println(data);
		System.out.println(em.method2() + 20 );
		//return타입이 있는 메소드는 return타입으로 지정해놓은 변수와 똑같다고
		//생각을 하면된다. em.method2() == int (return Type int)
		String a = "a" , b = "b";
		em.method3("a", "b");
		
		//int result = em.method4(1, 2);
		System.out.println("x + y 값은 : " +em.method4(1, 2));
		//					"   String  " + int = String
	}
}
