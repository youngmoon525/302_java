package pack01._interface;

public interface TestInterface {
//인터페이스에서 구현하는 모든것들은 추상 메소드 , 또는 상수
//여러 개발자가 같은 인터페이스를 상속받고 각자의 DAO를 만들고 소스를 합치게 되면 오류없이 잘 합쳐짐.
	String SERVERIP = "192.168.0.10";//final <= 이제 수정할수 없는값 (초기값만 설정이 가능함)
	void serach(); //개발자1
	void insert(); //개발자2
	void delete(); //개발자3
	//인터페이스는 기능을 넣는게 아니라 , 메소드의 이름과 리턴타입 등을 미리 정의해놓는것.
	
}
