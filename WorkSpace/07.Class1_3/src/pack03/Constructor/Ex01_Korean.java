package pack03.Constructor;

public class Ex01_Korean {
	//클래스의 블럭킹 { } 내부에 있는 모든것들은 멤버
	// main메소드도 마찬가지로 클래스의 멤버   
	//필드(객체가 가진 속성)
	String nation = "대한민국";
	String name ; //이름
	String ssn ; //주민등록번호
	//생성자 메소드 == new Ex01_Korean();객체를 생성하기 위한
	//기능을 가진 메소드 
	//별도의 생성자 메소드를 명시(만들지)하지 않으면 기본적으로
	//해당하는 클래스의 이름이 나오고 ();가 되는것을 의미함.
	
	//생성자메소드 규칙 : 클래스의 이름과 반드시 똑같고 
	//그리고 나서 (){ } 지역을 가지는 형태 ;
	public Ex01_Korean() {//<=자바(JVM,Complier)라는 거에서
						  //기본적으로 제공해주는 형태
		System.out.println("생성자 메소드 입니다.");
	}

	//Ex01_KoreanMain클래스를 만드시고 Ex01_Korean을
	//객체화(인스턴스화) 해보기.
	//메소드 오버로딩 : 메소드의 이름이 같으면 원래 사용이 불가능 함.,   
	//매개변수의 타입이나 , 갯수를 달리해서 같은이름으로 사용할수있게 하는 기능
	//ex)매개변수의 갯수가 같고 이름이 같으면 컴퓨터(java)는 어떤 메소드를 호출했는지
	//사용하는지 구분을 할수가 없기때문에 , ():매개변수를 넣는곳
	//나중에 배움 : 오버라이드 ==재정의
	public Ex01_Korean(String n) {//매개변수 : 메소드가 실행될때 필요한 데이터를 받아서
						  //사용할수있게 하는 부분.
						  //생성자 메소드 : field에 바로 값을 주는 경우 	
						  //매개변수(parameter) == 데이터를 받을수있는 그릇
						  //을 준비. == 변수를 선언해주는것 
						  //변수의 선언 => 파라메터 부
						  //변수의 값 할당 => 메소드를 호출하는 부분에 있는것
		System.out.println("생성자 메소드 입니다.");
		System.out.println("파라메터(매개변수)를 입력받음" + n);
		
	}
	
	public Ex01_Korean(String name , String ssn) {
		//this
		//field = 파라메터로 입력받은 변수로 세팅하겠다.
		this.name = name;
		this.ssn = ssn;
		//매개변수의 갯수를 여러개 지정할때는 , 콤마로 구분.
		System.out.println("생성자 메소드 입니다.");
		//매개변수를 두개 입력받는 생성자 메소드를 Ex01_KoreanMain에서 호출하시오.
	}

	public Ex01_Korean(int b) {//매개변수 갯수는 같으나 타입이 다르기 떄문에
							 //오버로딩이 가능함.
		
	}
	public Ex01_Korean(int b , String a) {
		
	}
	public Ex01_Korean(int b , int c) {
		
	}
	
	
	
}