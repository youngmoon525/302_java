
public class Test_TaskMain2 {
	public static void main(String[] args) {

		Thread thread1 = new Thread(new Test_Task(1, "파일 다운", 11));
		thread1.start();
		
		Thread[] threads = new Thread[5];
		threads[0] = new Thread(new Test_Task(1, "A", 11));
		threads[1] = new Thread(new Test_Task(1, "B", 5));
		threads[2] = new Thread(new Test_Task(1, "C", 8));
		threads[3] = new Thread(new Test_Task(1, "D", 1));
		threads[4] = new Thread(new Test_Task(1, "E", 4));
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
	}
}
