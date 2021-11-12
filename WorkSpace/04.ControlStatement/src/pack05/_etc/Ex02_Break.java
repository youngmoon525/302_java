package pack05._etc;

import java.util.Scanner;

public class Ex02_Break {
	public static void main(String[] args) {
		//Scanner를 통해서 어떤수 n을 입력받는다
		//while또는 for를 이용해서 반복을 무조건 입력한 수만큼 진행한다.
		//break를이용해서 어떤수 n / 2 를 한 시점에서 반복문을
		//종료하는 프로그램을 만드세요.
		//ex)50을 사용자가 입력함 
		// 반복을 진행하다가 25가되면 반복문이 종료된다.
		Scanner sc = new Scanner(System.in);
		String inputData = sc.nextLine();
		System.out.println("입력된값:" + inputData);
		int count = Integer.parseInt(inputData);
		System.out.println("숫자로 바꿈 : " + count);
		//	  반복문 탈출을 위한 변수선언;
		//	 i<10
		//   i<ten(10)
		
		for(int i = 0 ; i<=count; i++) {
			System.out.println(i);
			 if(i == (count/2)) {
				 break;
			 }
		}
		int i = 0 ;
		while( i<=count) {
			System.out.println(i);
			 if(i == (count/2)) {
				 break;
			 }
			 i++;
		}
		
		
		//Wrapper Class Parsing??? 
		//int => Integer 
		//double => Double
		//float => Float ..........
	}
}
