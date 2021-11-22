package pack02.Field;

public class Ex01_CarMain {
	public static void main(String[] args) {
		//main메소드가 없으면 java소스파일은 실행점을 모르기때문에
		//실행되지 않는다. ==자바 시간에만 main메소드를 이용함
		//추후에는 html,jsp , Controller..등등의 시작점을가짐.
		
		//Ex01_Car라는 설계도를 이용해서 인스턴스화 작업을 하게되면
		//해당하는 객체를 사용할수 있게된다. 
		//Ex01_Car라는 설계도를 이용해서 car라는 이름으로 인스턴스화
		//객체화를 하세요.
		//객체화시킬 클래스이름 사용할이름 = new 객체화시킬 클래스이름();
		Ex01_Car car = new Ex01_Car();
		//car라는 이름으로 객체를 생성함(인스턴스화 완료 ,메모리에 올라감)
		//클래스가 가지고있는 멤버(iv,field)를 사용하는 방법
		//인스턴스화 시킨 객체의 뒤에 .점을 찍는다. 
		System.out.println("차의 색상:" + car.color);
		System.out.println("차의 최대 속도 : " + car.maxSpeed);
		car.company = "현대자동차";
		car.color = "검정";
		car.model = "그랜져";
		car.maxSpeed = 300;
		System.out.println("차의 제조사 : " + car.company);
		System.out.println("차의 색상 : " + car.color);
		System.out.println("차의 모델 : " + car.model);
		System.out.println("차의 최고속력 : " + car.maxSpeed);
		//↓ 나중에 메소드로 바꿀수있는 부분.(기능)
		System.out.println("사람이 타서 엑셀을 밟습니다.");
		car.speed = 80 ;
		System.out.println(car.speed);
		System.out.println("사람이 브레이크를 밟고 내립니다.");
		car.speed = 0 ;
		System.out.println(car.speed);
		
		
	}
}
