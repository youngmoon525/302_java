
public class Ex07_Bool2 {
	public static void main(String[] args) {
		//가끔 쓰이는 비교 연산식 (= if라는 제어문을 통해서 더 많이 사용됨 )
		//현실에서 같은지의 비교는 = java에서는 대입을 의미한다(값할당)
		//java에서 같은지의 비교는 == , 다른지 !=
		//컴퓨터한테(java)질문을 할때는 반드시 true , false
		//ex)오늘 날씨 좋아? , 오늘 온도가 몇도야? , 
		// 오늘 온도가 20도와 같은지? true : false
		
		int a = 10;
		String result = a == 10 ? "같다" : "다르다" ;
		// 				a라는 변수에 있는 값이 10이랑 같습니까?
		//			    식이 참일때는 좌변 true : 거짓일때 false
		System.out.println(result);
		result = a != 10 ? " a " : " b " ;
		//result에 a가 담겼을까? b가 담겼을까?
		System.out.println(result);
		
	}
}
