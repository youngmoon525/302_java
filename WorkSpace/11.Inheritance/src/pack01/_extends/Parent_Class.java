package pack01._extends;

//부모클래스 라는 개념은 , 어떠한 클래스가 자식클래스로부터 선택 받는 순간 ,
//부모클래스가 된다. public class Prent_Class <=현재는 그냥 Class
public class Parent_Class {
	public String parent_field1 = "출력을 수정함. public";
	String parent_field2 = "부모 클래스의 iv2 , default";
	private String parent_field3 = "부모 클래스의 iv3 , private";
	

	public void parentMethod() {
		System.out.println("부모 클래스의 인스턴스 멤버 (메소드) 입니다.");
	}

}
