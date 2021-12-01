package pack03._extends;

public class ExtendsMain3 {
	public static void main(String[] args) {
		//1.CellPhone을 인스턴스화 시키고 Cellphone에 있는 기능들을 사용해보기.
		// 전원을 켬
		// 전화벨이 울림
		//통화 예) 나(본인) : 여보세요?
		//		타인 : 보험을 가입하시겠습니까?
		//      전화를 끊습니다.
		SmartPhone cp = new SmartPhone("3세대 폰" , "흰색" , 2 , "5G");
		System.out.println(cp.model + " : "  + cp.color);
		cp.powerOn();
		cp.bell();
		cp.sendVoice("여보세요?");
		cp.receiveVoice("보험을 가입하시겠습니까?");
		cp.hangup();
		cp.turnOnDmb();
		cp.changeChannelDMB(10);
		cp.turnOffDmb();
		cp.onInternet();
	}
}
