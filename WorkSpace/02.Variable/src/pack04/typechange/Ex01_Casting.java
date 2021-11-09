package pack04.typechange;

public class Ex01_Casting {
	public static void main(String[] args) {
		//byte1 < short < int < long < float < double
		//작은쪽 									큰쪽
		//작은쪽 데이터를 => 큰쪽으로 담을때 (자동) :야구공 , 박스큼
		//큰쪽에 데이터를 => 작은쪽으로 담아야할때(강제) :축구공,박스작음
		int num1 = 10;//정수형 변수(3)를 선언하고 값을 10을 주고 초기화
		double num2 = num1;//실수형 변수num2(6)를 선언하고 
						   //num1이라는 변수를 담음
						   //더큰 변수타입에 더 작은 변수타입을 담는것
						   //자동형변환이 발생함 작은타입에서 큰타입으로
						   //자동으로 변함.
						   //묵시적 형변환 , UpCasting
		
		System.out.println("변수 num1 :" + num1);
		System.out.println("변수 num2 :" + num2);
		System.out.println("===================");
		double num3 = 34.5;//데이터타입(6) 값을 34.5 초기화
		int num4 =(int) num3;//오류가 발생(Casting,형변환)이 필요함
							//강제 형변환,명시적 형변환
							//downCasting
							//큰타입데이터=>작은타입데이터타입
							//()<-열고 내부에 데이터타입을 명시해준다.
		
		System.out.println("double num3: " + num3);
		System.out.println("int num4: " + num4);
		//강제 형변환의 문제점
		//담을수없는 값을 담고있는 더큰 데이터타입의 값을 잘라버림
		//원본의 값을 찾을수가 없음.
		//byte타입의 변수 num5를 만듬
		//int타입의 변수 num6 = 30 ;=>byte
		//출력 num5 = num6;
		byte num5;//
		int num6 = 257;
		num5 = (byte) num6;//<-형변환이 필요함 더큰=>더작
		System.out.println(num5);
		System.out.println(num6);
	}
}
