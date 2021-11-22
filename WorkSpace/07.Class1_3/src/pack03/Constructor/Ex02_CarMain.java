package pack03.Constructor;

public class Ex02_CarMain {
	public static void main(String[] args) {
		//Ex02_Car를 인스턴스화(객체화)하고 
		//객체화한 객체에 Field들을 전부 출력하시오. ?
		Ex02_Car car = new Ex02_Car("제조사", "모델", "색상", 300, 0);
		System.out.println(car.color);
		System.out.println(car.company);
		System.out.println(car.maxSpeed);
		System.out.println(car.model);
		System.out.println(car.speed);
	}
}
