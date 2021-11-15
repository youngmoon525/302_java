package pack05._etc;

public class Ex03_Continue {
	public static void main(String[] args) {
		//continue == 반복문을 종료하지 않고
		//continue밑의 문장들을 실행하지 않는다.
		//반복문의 { <-블럭킹시작으로 이동을 의미한다고 생각하면됨
		//ex)어떤조건을 주고 밑에 실행을 방지하기위한 문장.
		int oddSum = 0; //홀수의 누적합을 구하기위한 변수
		//1~10 
		for(int i = 1; i<=10; i++) {
			if(i%2 != 0) {
				oddSum += i;
				//oddSum = oddSum + i;
			}
		}
		System.out.println("1~10까지의 홀수 누적합 : " + oddSum);
		//위에 for문을 continue를 사용해보기 
		oddSum = 0;
		for(int i = 1; i<=10; i++) {
			if(i%2 == 0) {
				//짝수인경우 밑의 문장의 실행을 방지한다.
				continue;
			}
			oddSum += i;
		}
	}
}
