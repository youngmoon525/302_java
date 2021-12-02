
public class Test_TaskMain {
	public static void main(String[] args) {
		Runnable run1 = new Test_Task(1, "파일 다운", 11);
		Thread thread1 = new Thread(run1);
		thread1.start();
		Runnable run2 = new Test_Task(2, "동영상을 봅니다.", 11);
		Thread thread2 = new Thread(run2);
		thread2.start();
		//생성자를 이용하는 방법↑
		Thread thread3 = new Thread( new Test_Task(3, "문자가옵니다", 3));
		thread3.start();
		
		
		Thread simpleThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				//반복할 코드 넣고 실행 ↑ 
				//어플리케이션 시작을할때 내가 몇초동안 로고화면을 보여주고싶을때(SplashActivity)
			}
		});
		simpleThread.start();
		
		
	}
}
