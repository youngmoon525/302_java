package pack04.typechange;

import java.util.Scanner;

public class Test_Cast {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//sc.nextLine을 이용하면 하나의 문자열을 입력받는다
		//sc.nextLine을 이용해서 두개의 문자열을 각각 숫자로 입력받고
		//두 문자열을 숫자형 데이터로 바꾼후 합을 구하는 프로그램을
		//작성하세요.
		String inputData1 = sc.nextLine();
		String inputData2 = sc.nextLine();
		//↑sc.nextLine()이라는 기능을통해서 사용자가 콘솔에
		//입력한값을 엔터키 기준으로 반환한다.
		System.out.println(inputData1);
		System.out.println(inputData2);
		System.out.println(inputData1+inputData2);
		int num1 = Integer.parseInt( inputData1 );
		int num2 = Integer.parseInt( inputData2 );
		System.out.println(num1 + num2);
//		System.out.println( Integer.parseInt( inputData1 )
//							+ Integer.parseInt( inputData2 ));
	}
}
