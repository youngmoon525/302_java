package pack09._abstract;

public abstract class Animal {
//동물 클래스
//abstract == 무조건 있어야 하는 메소드나 기능을 의미함.
//동물 = 무조건 호흡을 한다 , 소리도 낸다. 그외에도 여러가지 속성이 있지만 ..2가지만 사용
	public String kind ; //동물의 종류
	public abstract void breathe();//호흡
	public abstract void sound();//소리
	public abstract void method1();//검색기능
	public abstract void method2();//검색기능
	public abstract void method3();//검색기능
	public abstract void method4();//검색기능
	public abstract void method5();//검색기능
	//====abstract 클래스는 무엇일까? == 추상 클래스 
}
