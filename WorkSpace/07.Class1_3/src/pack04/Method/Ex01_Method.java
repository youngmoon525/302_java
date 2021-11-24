package pack04.Method;

public class Ex01_Method {
	int field1 ; //
	//메소드 (기능)
	//main 메소드 : 자바 프로그램의 시작점 기능 담당함
	//Method 의 선언 (정의)
	//접근제한자 : public , private , protected , default 
	//현재는 public만 알고있으면됨 (외워서씀)
	//1.접근제한자 2.리턴타입 3.메소드의이름 4.(매개변수 부) 5.{
	//	메소드의 실제 바디(실행부) //클래스와의 차이는 리턴타입, 매개변수부가 다르다.
	//}
	//void냐 void가 아니냐.
	public void method1() {
		System.out.println("void형태는 return타입이 없습니다.????");
		System.out.println("현재 메소드는 클래스의 블럭킹안에 있습니다.");
		System.out.println("method1은 인스턴스 멤버입니다.");//???
	}
	//method2 <-만들어보기 내용은 아무렇게나 해서 ~ 메인에서 호출까지 해보기
	public int method2() {//void가 아니면 '반드시' return이라는 키워드가 나오고
						  //그뒤에 해당하는 타입의 데이터가 항상 return이 되어야함.
		System.out.println("void가 아닌 형태는 return타입이 있습니다.");
		System.out.println("현재 메소드는 클래스의 블럭킹안에 있습니다.");
		System.out.println("method2는 인스턴스 멤버 입니다.(클래스)");
		//int rtnInt = 10;
		return 10;//== return rtnInt;
	}
	//인자값을 입력받는 메소드 method(파라메터1 , 파라메터 2 )
	public void method3(String a , String b) {
		System.out.println("파라메터를 입력받아서 출력 1:" + a);
		System.out.println("파라메터를 입력받아서 출력 2:" + b);
	}
	//return 타입이 있는 , 메소드를 하나 ( method4~ )
	//파라메타를 두개 입력받는 형태로 만드세요.
	public int method4(int x , int y) {
		System.out.println("x : " + x);
		System.out.println("y : " + y);
		int result = x + y ;
		return x+y;
	}
	
}
