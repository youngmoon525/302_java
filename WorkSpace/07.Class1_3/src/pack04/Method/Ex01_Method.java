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
	public void method1() {
		System.out.println("void형태는 return타입이 없습니다.????");
		System.out.println("현재 메소드는 클래스의 블럭킹안에 있습니다.");
		System.out.println("method1은 인스턴스 멤버입니다.");//???
	
	}
	//method2 <-만들어보기 내용은 아무렇게나 해서 ~ 메인에서 호출까지 해보기
}
