package package1;
//default 접근제한자 <= 같은 패키지 내부에 있으면 접근이 가능하다.
public class B {
	A a = new A();
	//↑ default (같은 패키지에 있는 A )
	package3.A a2 = new package3.A();
	//package3.A <=식별자를 통해서 어디에 있는 A인지를 구별을 한다(컴퓨터,사람)
}
