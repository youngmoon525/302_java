import java.awt.Toolkit;

public class Test_Task implements Runnable{
	int mill = 0; // *1000 ?
	String msg ; // 파일을 다운로드 , 영화를 봅니다 
	int count = 0;//for문 동작 횟수를 지정함
	
	
	
	public Test_Task(int mill, String msg, int count) {
		super();
		this.mill = mill;
		this.msg = msg;
		this.count = count;
	}

	@Override
	public void run() {
		for (int i = 0; i < count; i++) {
			try {
				Thread.sleep(mill * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//1 * 1000 ( 1초)
			System.out.println(msg);
			
		}
	}

}
