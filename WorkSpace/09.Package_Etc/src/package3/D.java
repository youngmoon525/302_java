package package3;

public class D { 
//	D d1 = new D(); //public : 같은 클래스에서 접근이 O
//	D d2 = new D("STR");//default : 같은 클래스에서 접근이 O
//	D d3 = new D(1); //private : 같은 클래스에서 접근이 O
	public D() {
		System.out.println("public : D가 생성됨(파라메터 없음)");
	}
	//default public을 명시하지 않은, 아무 접근제한자가 없는 상태.
	D(String data){
		System.out.println("default 접근제한자  " + data);
	}
	private D(int num) {//<=생성자 메소드에 private(외부에서의 접근을 제한함)
						//을 쓰게 되면 어차피 밖에서 사용을 못함.
						//어차피 못쓰는 메소드(생성자)를 만들었기때문에 경고가 나온다.
		System.out.println("private 접근제한자 : " + num);
	}
}
