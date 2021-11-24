package pack05._static;

public class Ex02_Static {
	public static void main(String[] args) {
		//Ex01_static < static method display1();
		//              instence method display2();
		//static<- 클래스에만 접근해도 메모리에 올라가있음
		//instence<- 클래스를 인스턴스화(객체) 해야지만 메모리에 올라감.
		//Ex01_static. 클래스에 . 닷을 찍으면 나오는것들은 전부 static 멤버
		Ex01_static.display1();
		Ex01_static es = new Ex01_static();
		es.display1();//<-경고 : 메모리에 이미 static메소드가 있기때문에		
					  //다시 한번 인스턴스화 한 객체(메모리에 올림)에서 메소드를 호출하면
					  //메모리를 낭비하고 있다고 경고를 줌.
		es.display2();
	}
}
