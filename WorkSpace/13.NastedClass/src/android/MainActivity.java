package android;


public class MainActivity extends AppCompatActivity{
	
	@Override
	protected void onCreate() {
		//화면을 초기화 하는 단계 (무조건 있어야함 Activity) 
		Button login_btn = new Button();//find..기능을 통해서 디자인에 있는 버튼을 연결함.
		login_btn.setOnclickListner(new Button.OnClickListner() {
			
			@Override
			public void onClick() {
				System.out.println("실제 클릭을했을때 이벤트 작성부 ");
			}
		});
	}
	
	public static void main(String[] args) {
		MainActivity a = new MainActivity();
		a.onCreate();
	}
}
