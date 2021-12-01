package pack08._protected2;

import pack08._protected.B;
import pack08._protected.A;
//protected 상속 받은 객체에서 다른 패키지 클래스에서는 사용이 불가능하게 막는것
//A클래스를 사용하고싶으면 B라는 클래스를 이용해서 중간에 B클래스에 A클래스의 기능을 호출하는 부분을 만들어줘야한다.
public class C extends A{
	public static void main(String[] args) {
		B b = new B();
		b.init();
	}
}
