package pack09._abstract;

public class Cat extends Animal{
//상속을 받을때 반드시 가져가야하는 ( 구현해야 하는 부분을 ) 강제한다.
// A dao <= B extends dao C <=       DAO
	@Override
	public void breathe() {
		System.out.println("고양이가 숨을 쉽니다.");
	}

	@Override
	public void sound() {
		System.out.println("고양이가 소리를 냅니다.");
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method5() {
		// TODO Auto-generated method stub
		
	}

}
