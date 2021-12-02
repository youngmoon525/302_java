import java.awt.Toolkit;

public class Ex01_Thread {
	public static void main(String[] args) throws InterruptedException {
		//자바 애플리케이션이 실행되는 동안은 Thread라는 객체가 계속해서 동작을 하고있다. 라고생각을하면된다.
		//Windows로부터 소리를 제공받는 API <-별로 안중요하니까 공부는 따로하지말자.
		Toolkit toolkit = Toolkit.getDefaultToolkit();//ToolKit을 리턴하는 메소드
		for (int i = 0; i < 5; i++) {
			//for문은 컴퓨터 속도에따라서 다르지만 0.0001초 내에 5번의 동작을 마무리함.
			toolkit.beep();
			//Thread를 통해서 포문에 속도를 제어할수가있다.
			//동작중인 프로세스를 잠깐 휴지 시키는 상태로 만드는 것.
			Thread.sleep(2 * 1000);//1 * 1000 ( 1초)
			System.out.println("동작함");
			
		}
	}
}
