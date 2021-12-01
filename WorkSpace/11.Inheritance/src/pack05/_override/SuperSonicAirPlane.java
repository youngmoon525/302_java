package pack05._override;

public class SuperSonicAirPlane extends AirPlane{
	//일반 비행기의 모든 기능을 가지고있고 + 음속으로 날수있는 기능도 있는 2세대.
	//final == 상수 ( 절대 변하지 않을 값을 의미함 )
	// ex) 프로젝트가 완료 된 상태에서 Server IP <- 절대 변하지 않음.
	// ex) 주민등록번호 , PIE(3.14) 
	// 값을 초기화 할때 한번만 할당을 해주면 그다음부터는 절대로 값을 바꿀수없다.
	//상수의 네이밍 규칙은 대문자로 전체를 써주는것이 관례
	//public static final double PIE = 3.14;//절대 변하지 않는 값
	public static final int NOMAL = 1;
	public static final int SUPERSONIC = 2;
	public int flyMode = NOMAL;
	
	//현재 상태에서는 fly()라는 메소드는 부모클래스에서 일반비행을 합니다 라는 기능만있다.
	//따라서 자식클래스에서 더필요한 기능이 있다면 부모클래스의 메소드와 자식클래스에서 메소드를
	//적절하게 분배해서 사용하면된다.
	
	@Override
	public void fly() {
		if(flyMode == NOMAL) {
			super.fly();//부모 클래스에 있는 일반 비행기능을 사용
		}else if(flyMode == SUPERSONIC) {
			System.out.println("음속에 속도로 비행을 합니다.");
		}
	}
	
	
	
}
