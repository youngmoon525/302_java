package pack03._for;

public class Ex03_for {
	public static void main(String[] args) {
		// 구구단을 출력.
		// 2단만 출력 해보기.
		//for문을 이용해서. i.<
		// 2 * i = 2?
		// 2 * 2 = 4
		// 2 * 3 = 6
		//	 .
		//   .
		//   .
		// 2 * 9 = 18
		for(int i = 1 ; i<10 ; i++) {
			//  2 * i = 2
			//  "2 * " + i + "=" + 
			//String aa = "2 * " + i + " = " + (i*2) ;
			System.out.println("2 * " + i + " = " + (i*2) );
		}
	}
}
