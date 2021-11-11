package pack01._if;

import java.util.Scanner;

public class Test_if2 {
	public static void main(String[] args) {
		// id와 비밀번호를 입력받아 id와 비밀번호가 일치하면 로그인
		//되었습니다(콘솔)출력되는 프로그램을 작성하시오.
		//Scanner sc = new Scanner(System.in);
		//sc.nextLine();
		//스캐너를 통해 입력받은 값을 숫자로 바꾼다.(Wrapper Class)
		//									(Parsing)
		// 
		//ex) id = 10 , pw= 20 
		//아이디와 비밀번호 모두 10과20으로 일치한다면 로그인
		//그게 아니면 로그인실패 라고 나오는 프로그램.
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요.");
		String inputId = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요.");
		String inputPw = sc.nextLine();
		System.out.println(inputId);
		System.out.println(inputPw);
		int id = Integer.parseInt(inputId);
		int pw = Integer.parseInt(inputPw);
		System.out.println(inputId+inputPw);
		System.out.println(id+pw);
		if(id == 10 && pw == 20) {
//			if(pw == 20) {
				System.out.println("로그인이 되었습니다.");
//				
//			}else {
//				System.out.println("로그인실패");
//			}
		}else {
			System.out.println("로그인 실패");
		}
		
	}
}
