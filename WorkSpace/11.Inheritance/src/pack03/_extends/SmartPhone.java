package pack03._extends;

//1세대 구현되어있는 기능을 2세대가 상속을받아서 전부다 사용이가능하다.
//3세대는 1세대를 상속받는게 아니라 2세대까지 구현해놓은 기능을 전부 상속을 받는다. + 기능
public class SmartPhone extends DmbPhone {//new DmbPhone
	//
	String internetSpd ; //1.5G또는 4G가 들어가면 되는데, 생성자메소드에서 입력을 맨처음에 받는다.
	//2.powerOn<-메소드를 재정의해서
	//옆에있는 전원 버튼을 통해서 전원이 ON되었습니다.(기능을 재정의)
	@Override
	public void powerOn() {
		//super.powerOn();//<= 부모클래스에 있는 메소드를 사용.
		System.out.println("옆에 있는 전원 버튼을 통해서 전원이 ON 되었습니다.");
	}
	//3.onInterNet
	//필드의 속도로 인터넷에 접속해서 웹툰을 봅니다.<=
	public void onInternet() {
		System.out.println( internetSpd + " 의 속도로 인터넷에 접속해서 웹툰을 봅니다.");
	}
	
	
	public SmartPhone(String model, String color, int channel , String internetSpd) {
		super(model, color, channel);//<-부모클래스의 생성자 메소드
		this.internetSpd = internetSpd;
	}

}
