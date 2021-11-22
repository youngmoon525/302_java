package pack03.Constructor;

public class Ex02_Car {
//자동완성
//이클립스를 사용하는 이유(목적)중에 하나는 코드의 자동완성이 용이한점이 있다.
//generate 를 이용해서 자동완성 사용해보기.
//1.내가 사용할 field(인스턴스멤버,인스턴스 변수,클래스의 멤버 변수)를 먼저 만든다.
	String company;//제조사
	String model;//자동차의 모델
	String color;//자동차의 색상
	int maxSpeed;//자동차의 최고속력
	int speed ; //자동차의 속력(현재)
//2.클래스의 내부에 커서를 둔다.
//-마우스 오른쪽 클릭 -> source -> Genarate Constructor Using Field
//생성자 메소드의 자동완성 ( 체크 되어있는 필드를 입력받는 생성자메소드를 만든다)
//public Ex02_Car() { } <=비어있는 형태를 만들거나
//별도의 생성자 메소드가 없을때만 new Ex02_Car();형태의 생성자 메소드를 사용할수있었다.
	public Ex02_Car(String company, String model, String color, int maxSpeed, int speed) {

		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.speed = speed;
	}
	public Ex02_Car() {
		
	}
	
	
}
