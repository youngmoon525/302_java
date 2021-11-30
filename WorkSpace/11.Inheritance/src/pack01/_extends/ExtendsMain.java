package pack01._extends;

public class ExtendsMain {
	public static void main(String[] args) {
		//1.부모클래스 ( 기능을 먼저 정의 해놓은 클래스) 인스턴스화 함
		//멤버가 어떤것들이 있는지 어떤것들이 사용가능한지 꼭! 생각을해보고 출력하고 사용해보기
		Parent_Class pc = new Parent_Class();
		System.out.println(pc.parent_field1);
		System.out.println(pc.parent_field2);
		//System.out.println(pc.parent_field3);
		//사용이 불가능함 (private 접근 제한자로 외부에서 접근을 막아놓음)
		pc.parentMethod();
		//2.자식클래스 ( 부모클래스의 기능을 물려받고???? 꼭 생각하고 ) 인스턴스화 함
		//멤버가 어떤것들이 있는지 그리고 왜 있는지? 꼭 생각 또 해보고. 출력하고 사용해보기
		Child_Class cc = new Child_Class();//Class가아닌 변수형태로 인스턴스화한것들은 소문자로 시작
		System.out.println(cc.parent_field1);
		System.out.println(cc.parent_field2);
		cc.parentMethod();
		System.out.println(cc.child_field);
		cc.childMethod();
		Child_Class2 cc2 = new Child_Class2();
		System.out.println(cc.parent_field1);
		//상속 = 부모클래스에서 구현해놓은 기능 + 자식클래스의 기능 ( 합집합 ) 
	}
}
