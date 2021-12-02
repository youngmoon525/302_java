import java.awt.Toolkit;

public class Ex03_ThreadInterface {
	public static void main(String[] args) {
		//Interface를 사용해서 Trhead 동작 시키기.
		//Thread t = new Thread( Runnable 인터페이스 ) ;
		//어떤 객채를 생성할때 파라메터로 인터페이스를 넘기는 방법은 , 인터페이스에 구현해야할
		//모든 부분들을 작성하는것 , ex)button.setOnclickListener(new OnClick(){
		//					  });;
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(1 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}//1 * 1000 ( 1초)
					System.out.println("익명으로 사용함 (인스턴스화 하지않고 구현부분을 그대로)");
					
				}
			}
		});
		thread.start();
	}
}
