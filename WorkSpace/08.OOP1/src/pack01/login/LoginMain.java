package pack01.login;

import java.util.Scanner;

public class LoginMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		String pw = sc.nextLine();
		//콘솔창으로 id , pw를 입력받음 
		System.out.println(id + " : " + pw);
		// id:admin , pw:admin123
		// 아이디 & 비밀번호가 일치한다면 로그인 되었습니다 출력
		// != 아이디 비밀번호를 다시 확인 해주세요.
		LoginDTO dto = new LoginDTO(id, pw);
		LoginDAO dao = new LoginDAO();
		if(dao.login(dto)) {
			System.out.println("마이 페이지로 이동하는 로직");
		}else {
			System.out.println("경고창을 띄우고 input Type Text 비움");
		}
		//dao.login() == return Type boolean
		//System.out.println(dao.login(dto));
		//System.out.println(true);
		//↑ LoginDTO <- field (id , pw ) 
		
	}
}
