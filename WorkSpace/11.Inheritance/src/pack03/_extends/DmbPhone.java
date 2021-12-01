package pack03._extends;

public class DmbPhone extends CellPhone {
	//이미 기능이 완성되어있는 1세대(CellPhone)을 이용해서
	//방송을 볼수있는 기능을 추가하고 2세대 (DmbPhone)을 구현
	int channel ;

	public DmbPhone(String model , String color , int channel) {
		super();
		this.model = model;
		this.color = color;
		this.channel = channel;
	} //방송의 채널이 되는 변수(필드)
	
	//ExtendsMain2번을 만들고 기존에 있던 출력은 그대로 출력이되고 다음 메소드들을 만들고
	//출력하시오.
	
	//turnOnDmb 메소드는 
	//" 채널 2을 시청시작(DMB) 
	public void turnOnDmb() {
		System.out.println("채널 " + channel + "를 시청시작");
	}
	//changeChannelDMB 
	//사용자에게 채널을 입력받아 채널을 바꿔준다. 
	//채널 8으로 변경 됨
	//setter ↓
	public void changeChannelDMB(int channel) {
		this.channel = channel;
		System.out.println("채널 " + channel + "으로 변경 됨");
	}
	//turnOffDmb
	//8 채널을 시청하다가 시청을 종료하고 DMB가 꺼졌습니다.
	public void turnOffDmb() {
		System.out.println(channel + " 채널을 시청하다가 시청을 종료하고 DMB가 꺼졌습니다.");
	}
	
	
	
}
