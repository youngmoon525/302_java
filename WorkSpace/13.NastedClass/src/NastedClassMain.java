
public class NastedClassMain {
	public static void main(String[] args) {
		//인스턴스 멤버 : 객체가 인스턴스화 되어야지만 접근이 가능한 부분
		//A의 인스턴스멤버중 , 생성자 메소드 , field1 사용해보기 
		A a = new A();
		System.out.println(a.field1);
		// A의 인스턴스 멤버중 => Class B , Class B를 생성하려면 어떻게 해야할까.. 생성해보기.
		//객체를 생성할때는
		//Class이름 사용할이름 = new 생성자메소드();
		A.B b = a.new B();
		System.out.println(b.field1);
		b.bMethod();
		//static멤버는 인스턴스화 한 객체에서 사용하는게 아니라 클래스에만 접근을해도 바로 사용이 가능하다.
		A.C c = new A.C();
		System.out.println(c.field1);
		c.method1();
		System.out.println(A.C.field2);
		A.C.method2();

		
		
	}
}
