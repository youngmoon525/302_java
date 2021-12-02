
//중첩클래스 . 
//중첩클래스 ???
public class A {
	//멤버 : 인스턴스 멤버 (instence) , 스태틱 멤버 (static)
	//해당하는 클래스 내부에 있는것들은 전부다 클래스의 멤버 
	//인스턴스 멤버 : 해당하는 클래스 내부에 있는것들을 나타내며 , 해당하는 클래스가
	//인스턴스화 과정 (new 생성자 메소드)을 거친후에 인스턴스화 된 변수로부터 .(점)을 찍어서 접근이 가능한
	//멤버								↑(메모리에 올라감)
	//스태틱 멤버 : 해당하는 클래스 내부에 있는것들을 나타내며 , 해당하는 클래스가 인스턴스화 과정을
	//거치지 않아도 클래스에 접근만하면 이미 메모리에 올라가 있는 멤버
	//구분을 할때는 static이라는 키워드가 붙어있는지 안붙어있는지만 우리는 구분하면 한다.
	int field1; //NastedClass 멤버
	public A() {
		System.out.println("A의 멤버 메소드 (생성자)");
	}
	//중첩클래스 , 클래스 내부에 클래스를 또 만들어서 클래스의 멤버로 클래스를 가지는것.
	//A의 인스턴스 멤버(인스턴스 클래스)
	public class B{
		int field1; //??????멤버??
		public B() {
			System.out.println("B의 생성자");
		}
		void bMethod() {
			System.out.println("B의 메소드");
		}
	}//B Class
	
	public static class C{
		public C() {
			System.out.println("static 멤버 C의 생성자");
		}
		int field1;
		static int field2;
		void method1() {
			System.out.println("C의 메소드");
		}
		static void method2() {
			System.out.println("c의 스태틱 메소드 ");
		}
	}//C class
	
	void aMethod() {
		int a = 0 ; //<=로컬변수 (지역 변수 ) //Main에서 a에 접근이 가능할까??
		//로컬 클래스 (지역 , 로컬 ) 메소드의 지역안에서만 사용이 가능함
		//지역변수와 똑같은 특성을 가진다.
		class D{
			int feild1 = 30;
			void method1() {
				System.out.println("D의 메소드가 호출됨");
			}
			public D() {
				System.out.println("D의 생성자 메소드");
			}
		}
		D d = new D();
		System.out.println(d.feild1);
		d.method1();
	}//수단과 방법을 가리지 않고 어떻게든 D에 있는 생성자메소드~필드 (멤버)전체를 출력하시오.
	
	
}
