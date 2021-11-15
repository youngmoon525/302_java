package pack01._string;

import java.util.Scanner;

public class Ex01_String {
	public static void main(String[] args) {
		//String <- 일반변수와 다름 대문자로 시작함(클래스)
		//참조형데이터 타입 (열거 , 클래스v , 인터페이스 , 배열)
		Scanner sc = new Scanner(System.in);
		String str1 = "kym";
		String str2 = "kym";
		String str3 = sc.nextLine();//<str1,str2,같은값을 입력
		if(str1 == str2) {
			// == 같은 어드레스를 참조하고있는지를 묻는것
			System.out.println("참조가 같습니다.");
		}else {
			System.out.println("참조가 다릅니다.");
		}
		
		if(str1 == str3) {
			System.out.println("참조가 같습니다.");
		}else {
			System.out.println("참조가 다릅니다.");
		}
		if(str1.equals(str3)) {
			System.out.println("값이 같습니다.");
		}
		
	}
}
