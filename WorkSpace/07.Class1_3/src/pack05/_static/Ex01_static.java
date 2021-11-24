package pack05._static;

public class Ex01_static {
	//멤버는 크게 static과 instence로 나누어져 있다.
	//static이냐 static이 안붙어있으면 인스턴스 멤버.
	//static이 붙어있으면 static멤버 
	//static멤버는 인스턴스 멤버에 바로 
	//접근이 불가능함(인스턴스화 과정을 거쳐야만)접근이 가능함.
	
	//메모리에 항상 먼저 올라가기때문에 인스턴스화 과정이 필요없는 멤버
	//↑ 과정때문에 인스턴스멤버는 접근이 불가능하다(인스턴스화 해야지만 메모리에 올라가기때문)
	//과도한 static멤버를 만드는것은 프로그램 속도 저하의 원인이다.
	public static void main(String[] args) {
		display1();
		Ex01_static es = new Ex01_static();
		es.display2();
		//display2(); static은 메모리에 먼저 올라가기때문에.
		// 			  instence를 같이 메모리에 올릴수없는 구조.
		//			  접근이 불가능함.
	}
	
	public static void display1() {
		System.out.println("static멤버 메소드 입니다.");
		//아직 메모리에 없는 display2()를 접근
	}
	
	public void display2() {
		System.out.println("instence 멤버 메소드 입니다.");
		display1();//이미 메모리에 있는 static에 접근
	}
	
	//singleTone <- 프로그램 시작전에 먼저 메모리에 할당 , 프로그램 종료 시 소멸
	//프로그램 종료 시<----프로그램이 실행중에는 항상 메모리에 있음.
	//자바프로그램은 메모리를 효율적으로 사용하기 위해서 블럭킹 기준으로 블럭킹 끝부분
	//에서는 메모리에서 사라지게 만듬. static이 붙어있으면 항상 메모리에 있기떄문에
	//메모리 관리 차원에서 나쁨.
	//if(){ }<- for(){ }< 
	static {
		System.out.println("static 초기화 블럭");
	}
	
	
	
	
}
