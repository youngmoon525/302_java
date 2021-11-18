package pack01_ExceptionCode;

import java.util.Scanner;

public class Ex03_NumberFormat {
	public static void main(String[] args) {
		//1.Scanner <- 만들기
		//2.Scanner.nextLine(); 콘솔창에 있는값 입력받기
		//3(2-1).입력받은 값 변수에 저장하기
		//4.저장 된 변수 = > int형으로 바꾸기
		//5.출력하기
		Scanner sc = new Scanner(System.in);
		
		String data = sc.nextLine();
		int num = Integer.parseInt(data);
		System.out.println(num);
		//java.lang.NumberFormatException: For input string: "dlkdldl"
		//↑ 문자열을 숫자로 바꾸는 과정에서 나오는 오류(예외)
		// For input string :<- 바꾸지못한 문자열이 출력되므로 오류의 수정이 쉬움.
	}
}
