package pack07._changetp2;

public class ChangeTPMain {
	public static void main(String[] args) {
		//자식 클래스를 만들고 사용하게되면 모든 기능을 사용할수가있다.
		Child child = new Child();
		Child2 child2 = new Child2();
		//자식클래스 => 부모클래스
		Parent parent = child;
		parent.method1();
		parent.method2();
		parent = child2;
		parent.method1();
		parent.method2();
		
		//Parent라는 더 큰범위에 클래스에 여러가지 자식들을 넣어놓고 재정의 된부분들을 사용해야하는 상황
		//부모클래스에 정의가 안되어있는 부분은 사용불가능
	}
}
