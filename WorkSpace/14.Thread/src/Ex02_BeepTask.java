import java.awt.Toolkit;

//Runnable <= Interface 요기 안에있는 메소드는 무조건 구현해야함.
public class Ex02_BeepTask implements Runnable {

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
			System.out.println("동작함");
			
		}
	}

}
