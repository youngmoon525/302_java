package android;

public class Button {
	//backgroundtint 배경색 , src , id ....여러가지 속성이 있음
	//해당하는 Button을 클릭했을때 어떤 처리를 할것인지에 대한 정의가 있다(이벤트)
	//static 형태로 되어있다.+(Interface)
	public OnClickListner listner;//필드로도 가지고있음(static 형태이기때문에 바로 필드로 사용가능)
	
	void setOnclickListner(OnClickListner listner) {
		this.listner = listner;
	}
	void click() {
		listner.onClick();
	}
	
	//Button이라는 Class의 static멤버 interface를 넣음
	static interface OnClickListner{
		void onClick();
		//OnClickListner라는 인터페이스 형태를 사용하기 위해서는
		//onClick이라는 이벤트가 있어야함.
	}
}
