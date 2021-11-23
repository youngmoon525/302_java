package pack04.Method;

public class Ex04_Car {
	//field 객체가 가지는 속성 (정보)
	String company ; // 제조사
	String model ; //차종
	String color ; //색상
	int speed ; //차의 속력
	int maxSpeed ; //최대 속력
	int gas ;
	public Ex04_Car(String company, String model, String color, int speed, int maxSpeed, int gas) {
		this.company = company;
		this.model = model;
		this.color = color;
		this.speed = speed;
		this.maxSpeed = maxSpeed;
		this.gas = gas;
	}
	
	//생성자 메소드. 
	//모든 필드를 입력해야지만 생성할수있게 제약을 주는 형태.
	// Ex04_Car car = new Ex04_Car(); <- 형태 사용 x
	
	//상태정보를 볼수있게 해주는 메소드 
	//return Type ? 있어야할까? 없어야할까?
	
	public void display() {
		//this 라는것은 같은 이름의 파라메터(인자값)을 입력받았을때
		//여기에있는 필드를 구분하기 위한 구분자 
		System.out.println("제조사 : " + company);
		System.out.println("모델" + model);
		System.out.println("색상 : " + color);
		System.out.println("현재 속력 : "+ speed);
		System.out.println("최대 속력 : "+maxSpeed);
		System.out.println("가스량 : " + gas);
	}

	public void changeSpeed(int i) {
		System.out.println("기존 속도 " + speed + " 현재 속도 : " + i);
		speed = i;
	}
	
	
}
