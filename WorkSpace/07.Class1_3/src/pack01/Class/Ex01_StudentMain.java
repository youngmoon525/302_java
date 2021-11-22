package pack01.Class;

public class Ex01_StudentMain {
	public static void main(String[] args) {
		//Ex01_Student라는 Class만듬 
		//Class의개념은 자바에서 설계도의 개념 
		//설계도를 이용해서 어떠한 객체를 만들기 위해서는
		//인스턴스화(객체화)라는 과정이 필요하다.
		//인스턴스화 과정을 거치면 Class를 통해서 객체가 생성되고
		//이때 메모리에 올라가기때문에 변수처럼 사용이 가능한 상태가 된다.
		//new <-연산자(키워드)를 통해서 항상 인스턴스화가 된다.
		//객체 생성식
		//객체(Class) 사용할이름(아무거나) = new 객체(Class);
		Ex01_Student kym = new Ex01_Student();
		//인스턴스화(객체를 사용할 준비)
		System.out.println("kym이라는 객체는 무슨 값을 가지고 있을까? " + kym);
		//객체가 참조하고있는 메모리 번지수가 나온다.(==배열)참조형 데이터타입
		//참조형 데이터타입에 초기값 ? int <- 0 ,String = ?
		Ex01_Student kym2 = null ; //참조형 데이터타입은 null로 비워둘수있다.
								   //null로 비워둔상태에서 사용하게되면
								   //참조형 데이터입은 nullpointerException을 발생한다.
		Ex01_Student kym3 = null;
		if(kym2 == kym3) {//값의비교 x 참조하는 어드레스를 비교 o
			System.out.println("kym2 , kym3의 객체 참조가 같습니다.");
			System.out.println("kym2 :" + kym2 + "kym3" + kym3);
		}
		kym2 = new Ex01_Student();
		kym3 = new Ex01_Student();
		// kym2 , kym3의 객체 참조가 같을까? 같다 , 다르 
		//같은지 다른지를 한번 출력해보기 if
		if(kym2 == kym3) {
			System.out.println("참조가 같습니다.");
			System.out.println("kym2 : " + kym2);
			System.out.println("kym3 : " + kym3);
		}else {
			System.out.println("참조가 다릅니다.");
			System.out.println("kym2 : " + kym2);
			System.out.println("kym3 : " + kym3);
		}
		
	}
}
