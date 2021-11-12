package pack03._for;

public class Ex02_for {
	public static void main(String[] args) {
		//제어문은 중첩이 가능하다.
		//선택문(if,switch,ifelse...)
		//반복문(for,while , do-while....)
		//지역안에 또 지역을 만들고 만들어진 지역안에 또 여러개의
		//지역을 만들수있다. (기준은 블럭킹)
		//0~9
		for(int i = 0 ; i<10 ; i++) {
			
			//0~9의 수중 짝수인것만 출력을 하고싶을때. 어떻게 해야할까?
			//n % 2 ... 0인것.
			if(i%2 == 0) {//if< true일때만 실행되는블럭
				System.out.println("짝수 :"+i);
			}else {
				System.out.println("홀수 :"+i);
			}
		}
		// 0~9까지의 수중 홀수인 수의 합 1,3,5,7,9
		// 0~9까지의 수중 짝수인 수의 합 0,2,4,8..
		// 0~9까지의 모든 합 : 45
		// 을 출력하시오.
		// ※ 누적을 시키고 싶다. 
		//(for 지역안에서 만든 변수는 누적이 불가능함 ) 
		int oddNum = 0 , evenNum = 0 , sum = 0;
		for(int i = 0 ; i<=9 ; i++) {
			//int oddNum = 0 ; 변수 선언 위치를 반복문 밖으로 이동↑
			if(i%2 == 1) {
				 oddNum += i;//oddNum = oddNum+i;
			}else {
				evenNum += i;//evenNum = evenNum+i;
			}
			sum += i;//sum = sum+i;
		}
		System.out.println("홀수의 합 : " + oddNum);
		System.out.println("짝수의 합 : " + evenNum);
		System.out.println("총 합 : " + sum);
	}
}
