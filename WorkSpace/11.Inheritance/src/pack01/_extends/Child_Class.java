package pack01._extends;
//extends라는 키워드가 없는 상태에서는 각각 Parent_Class & Child_Class 이름을 가진 별개의 클래스이다.
//Child_Class가 extends라는 키워드를 통해서 부모클래스를 선택하게 되면 그때부터는 부모와 자식 관계를 가진다.
//보라색 글씨는 자바 예약어(자바에서 이미 사용중인 변수나 메소드,또는 기능을 위한 키워드들이다.)
//extends Parent_Class <=명시를 하는 순간 부모와 자식 관계가 형성됨.
public class Child_Class extends Parent_Class {
	String child_field = "자식클래스 iv";
	public void childMethod() {
		System.out.println("자식클래스의 메소드");
	}
}
