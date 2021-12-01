package pack07._changetp2;

public class Child2 extends Parent{
	@Override
	public void method1() {
		System.out.println("자식클래스 메소드1 ====기능이 추가됨");
	}
	
	public void method3() {
		System.out.println("사용못하는 메소드 부모클래스에 정의가 안되어있는 부분은 사용불가능");
	}
}
