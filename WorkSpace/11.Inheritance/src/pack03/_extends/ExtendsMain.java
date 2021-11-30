package pack03._extends;

public class ExtendsMain {
	public static void main(String[] args) {
		//1.CellPhone을 인스턴스화 시키고 Cellphone에 있는 기능들을 사용해보기.
		// 전원을 켬
		// 전화벨이 울림
		//통화 예) 나(본인) : 여보세요?
		//		타인 : 보험을 가입하시겠습니까?
		//      전화를 끊습니다.
		CellPhone cp = new CellPhone();
		cp.model = "1세대 폰";
		cp.color = "검정";
		System.out.println(cp.model + " : "  + cp.color);
		cp.powerOn();
		cp.bell();
		cp.sendVoice("여보세요?");
		cp.receiveVoice("보험을 가입하시겠습니까?");
		cp.hangup();
		System.out.println("최상위 클래스의 기본기능들을 출력해봄======↑");
	}
}
