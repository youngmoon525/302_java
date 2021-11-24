package pack05._static;

public class Ex03_Member {
	//Class에는 크게 두가지 멤버가 있다.
	//멤버 : 메소드 , 클래스 , 변수 ... 클래스의 블럭킹 내부에 있는 모든것
	//동적멤버(instence) , 정적멤버(static)
	// static이 없는          , static 붙은(있는)
	//인스턴스화 해야지만 메모리에 올라감 , 인스턴스화 과정이 없어도 메모리에 올라감.
	String field1;
	static String field2;
	int field3;
	static int field4;
	
	public void method1() {
		//field1~4 :여기서 접근 가능한 필드는 몇개일까 ? 4
		//1.인스턴스 멤버끼리는 언제든지 접근이 가능하다.
		//2.인스턴스 멤버'는' 스태틱 멤버에도 접근이 가능하다.(메모리에 먼저 있기때문에)
		System.out.println("인스턴스 멤버" + field1+field3);
		System.out.println("스태틱 멤버" + field2+field4);
		System.out.println("메소드 1 인스턴스");
	}
	public static void method2() {
		//String field1 ="aa"; new = 
		//System.out.println(field1);//?메모리에 field1이라는것이 없음
		//field1~4 :여기서 접근 가능한 필드는 몇개일까 ? 2
		//1.스태틱 멤버끼리는 언제든지 접근이 가능하다.
		//2.스태틱 멤버'는' 인스턴스 멤버에 바로 접근이 불가능하다.
		//(아직 메모리에 올라가 있지 ↑ 않은 상태 이기 때문이다.)
		System.out.println("스태틱 멤버" + field2+field4);
		System.out.println("메소드2 스태틱");
	}
}
