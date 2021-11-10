
public class Ex02_Oper4 {
	public static void main(String[] args) {
		int v1 = 5;
		int v2 = 2;//<-계산에 사용할 변수 2개를 초기화
		int result1 = v1 + v2;
		System.out.println("v1 + v2 = " + result1);
		int result2 = v1 - v2;
		System.out.println("v1 - v2 = " + result2);
		int result3 = v1 * v2;
		System.out.println("v1 * v2 = " + result3);
		int result4 = v1 / v2;
		System.out.println("v1 / v2 = " + result4);
		int result5 = v1 % v2;//나머지 구하기
		//2로 나눴을때 나머지가 0이면 짝수 , 그외는 홀수.
		//2로 나눴을때 나머지가 1이면 홀수 , 그외는 짝수.
		System.out.println("v1 % v2 = " + result5);
		//출력
		//int변수 result2~4 - , * , /
		//출력해보기.
		// v1 % v2 == ? 
	}
}
