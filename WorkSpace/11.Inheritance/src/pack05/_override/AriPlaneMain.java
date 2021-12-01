package pack05._override;

public class AriPlaneMain {
	public static void main(String[] args) {
		SuperSonicAirPlane ssap = new SuperSonicAirPlane();
		ssap.takeOff();
		ssap.fly();//일반 비행을 합니다.
		System.out.println(ssap.flyMode);
		ssap.flyMode = ssap.SUPERSONIC;
		System.out.println(ssap.flyMode);
		ssap.fly();
		//메인에서 상수를 이용해서 모드를 바꾸고 , 모드를 바꾸게되면 일반비행합니다 x => 음속의 속도로 비행을 합니다.
		//
		ssap.takeOff();
		
	}
}
