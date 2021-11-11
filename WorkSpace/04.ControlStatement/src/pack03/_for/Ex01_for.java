package pack03._for;

public class Ex01_for {
	public static void main(String[] args) {
		//제어문 - 반복문 (어떤 조건을 주고 그조건이 true일동안
		//	반복 실행할 블럭킹(지역)을 만들고 계속해서 반복시키는것.
		//ex) 0 ,0을 증가시킴 1씩 , 0이 어떤수보다 작을동안(true)
		//계속 반복을 한다.
		//for(1.초기값(변수); 2.조건식 ; 4.증감식){
		//	3.조건식이 true일때 실행이 되는 부분.
		//	증감식에 의해서 또는 조건식에 의해서 반복되는 횟수가 달라진다.
		//}
		//int i = 0;
		// 0 , 0<10 , 
		// 1 , 1<10 
		for(int i = 0 ; i<10 ; i++) {
			//i -= 1; // 무한 루프를 조심해야함.
			//증감식 == 언젠가 우리가 원하는시점을 두고
			// 조건식을 false로 만들기 위해서 존재함.
			System.out.println(i);
		}
		
		//System.out.println("for문을 벗어난 i값 : " +i);
		//for(int i=1; i<=40; i++ ) {
		//	System.out.println(i);
		//}
		//1~40 까지 콘솔에 출력하는 for문을 만들어보세요.
		//{ }
	}
}
