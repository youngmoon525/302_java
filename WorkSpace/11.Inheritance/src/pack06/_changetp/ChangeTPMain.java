package pack06._changetp;

public class ChangeTPMain {
	public static void main(String[] args) {
		//A 
		//B ↑, C ↑
		//D ↑, E ↑
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		//E라는 클래스는 C를 물려받았기때문에 데이터 범위가 더 크다.
		// double => int , 강제 캐스팅 (int)
		e = (E) c; //큰것 => 작은것
		
		
	}
}
