import java.util.Scanner;

public class Test_Oper {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//스캐너의 초기화식 ↑
		//두가지 수를 sc.nextLine()을 통해서 각각 입력을받는다.
		//ex) 10 , 20 ; parse?
		//10 과 20이 같은 수인지 비교를 해서 같다면 같습니다.
		//다르다면 다릅니다 라고 console창에 출력!
		//10 , 10 <-
		String inputData1 = sc.nextLine();//사용자가 enter
		String inputData2 = sc.nextLine();//사용자가 enter
		System.out.println(inputData1);
		System.out.println(inputData2);
		//String의 비교는 일반적인 Decimal(숫자형)데이터의 비교와
		//다르다. 
		//	     =<= 우측에 있는 값을 좌측에있는 변수(그릇)에 담는다.

	//	int num1 = Integer.parseInt(inputData1);
	//	int num2 = Integer.parseInt(inputData2);
		String result = Integer.parseInt(inputData1) ==  Integer.parseInt(inputData2) ? "같음" : "다름";
		System.out.println(result);
	}
}
