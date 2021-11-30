package pack03._extends;

public class CellPhone {
	//기본 기능들을 가지고있는 최상위 부모클래스 
	//필드
	public String model;//핸드폰의 기종
	public String color;//핸드폰의 색상
	
	//기능 
	public void powerOn() {
		System.out.println("종료 버튼을 눌러서 전원을 ON 했습니다.");
	}
	public void powerOff() {
		System.out.println("종료 버튼을 눌러서 전원 OFF");
	}
	public void bell() {
		System.out.println("전화 벨이 울립니다(전화옴 소리도 남)");
	}
	public void sendVoice(String voice) {
		System.out.println("나(본인) : " + voice);
	}
	public void receiveVoice(String voice) {
		System.out.println("상대방(타인) : " + voice);
	}
	public void hangup() {
		System.out.println("전화를 끊음");
	}
}
