import java.awt.Toolkit;
import java.util.ArrayList;

public class Ex02_BeepTaskMain {
	public static void main(String[] args) throws InterruptedException {
		//Interface를 상속받은 객체는 다시 Interface에 넣을수있음 (다형성)
		Runnable beep_task = new Ex02_BeepTask();//<=implements Runnable //run
		Thread thread = new Thread(beep_task);
		thread.start();
		System.out.println("테스크가 동작을 함");
		Toolkit toolkit = Toolkit.getDefaultToolkit();//ToolKit을 리턴하는 메소드
		for (int i = 0; i < 5; i++) {
			//for문은 컴퓨터 속도에따라서 다르지만 0.0001초 내에 5번의 동작을 마무리함.
			toolkit.beep();
			//Thread를 통해서 포문에 속도를 제어할수가있다.
			//동작중인 프로세스를 잠깐 휴지 시키는 상태로 만드는 것.
			Thread.sleep(500);//1 * 1000 ( 1초)
			System.out.println("메인임.");
			
		}
	}
}
