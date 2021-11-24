package pack05._static;

public class Ex03_MemberMain {
	public static void main(String[] args) {
		//Ex03_Member에 있는 모든 멤버(instence,static)를 출력하시오.
		//단 ※ 주의할점은 메모리 낭비 체크를 IDE(이클립스)가 하고 있기때문에
		//효율적으로 호출(출력)하시오. (노란불이 안들어오게 )
		System.out.println(Ex03_Member.field2 + Ex03_Member.field4);
		Ex03_Member.method2();
		//Ex03_Member.<-만 해도 나오는것들 == static
		Ex03_Member em = new Ex03_Member();
		System.out.println(em.field1 + em.field3);
		em.method1();
		em.method2();//<-어짜피 인스턴스화 과정에서 객체자체가 메모리에 올라가있음
					 //
	}
}
