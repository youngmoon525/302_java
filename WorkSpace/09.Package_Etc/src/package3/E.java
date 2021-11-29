package package3;

public class E {
	public static void main(String[] args) {
		//생성해보기 D클래스에 있는 모든 생성자를 이용하기.
		//어떤 접근제한자들을 사용할수있을까? public , default(같은 패키지) , private?
		D d = new D(); //외부 클래스에 접근이 가능함(public)
		D d1 = new D("default");//외부 클래스 같은 패키지일때 접근이 가능함(default)
		//D d2 = new D(3);//private 외부에서의 접근을 막는다.
	}
}
