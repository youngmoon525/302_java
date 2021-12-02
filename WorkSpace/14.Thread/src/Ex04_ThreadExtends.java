import java.awt.Toolkit;

//Thred라는 클래스 자체를 부모클래스로 두고
//기능을 사용하게끔 만드는 방법. (부모를 상속받았기때문에 부모의 생성자에 사용이가능하다.)
//※ Thread t = new Ex04_ThreadExtends(); 
//Ex04에서 만든 메소드들은 당연히 사용이 불가능하다.
//DownCasting 
public class Ex04_ThreadExtends extends Thread{
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();//ToolKit을 리턴하는 메소드
		for (int i = 0; i < 5; i++) {
			//for문은 컴퓨터 속도에따라서 다르지만 0.0001초 내에 5번의 동작을 마무리함.
			toolkit.beep();
			//Thread를 통해서 포문에 속도를 제어할수가있다.
			//동작중인 프로세스를 잠깐 휴지 시키는 상태로 만드는 것.
			try {
				Thread.sleep(1 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//1 * 1000 ( 1초)
			System.out.println("Extends");
			test();
		}
	}
	
	public void test() {
		System.out.println("test");
	}
}
