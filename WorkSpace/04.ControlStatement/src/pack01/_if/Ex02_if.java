package pack01._if;

import java.util.Scanner;

public class Ex02_if {
	public static void main(String[] args) {
		//어떤수를 % 2로 나눈 나머지가 1이면 홀수 0이면 짝수 이다.
		//Scanner를 통해 어떤수 x를 입력 받고 x가 홀수인지
		//짝수인지를 if문을 통해서 판단하고 콘솔창에 출력하는
		//프로그램을 작성하세요.
		Scanner sc = new Scanner(System.in);
		//↑ 스캐너를 준비해놓는 식.
		String inputData = sc.nextLine();
		int x = Integer.parseInt(inputData);
		if(x%2 == 0) {
			//조건식 true(짝수)
			System.out.println(x + "짝수");
		}
		if(x%2 == 1) {
			//조건식 true(홀수)
			System.out.println(x + "홀수");
		}
		//Parsing , Wrapper Class 
		//( int = Integer , double == Double)
		
	}//main
}//class
