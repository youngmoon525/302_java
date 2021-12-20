package last.project;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		// 반복문은 나중에 추가 . ※처음부터 반복문을 사용하게 되면 햇갈릴 우려가있음.
		Scanner sc = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		while (true) {

			if (MemberDAO.dto == null) {

				System.out.println("1.로그인  2.회원가입");
				String menu = sc.nextLine();
	
				if (menu.equals("1")) {
					System.out.println("아이디를 입력해주세요.");
					String id = sc.nextLine();
					System.out.println("비밀번호를 입력해주세요.");
					String pw = sc.nextLine();
					dao.memberLogin(id, pw);
					if(MemberDAO.dto == null) {
						System.out.println("로그인 실패");
					}
					// Database접근을 해서 실제로 있는 아이디라면 => 메인로직 실행.
					// => 아이디 비밀번호를 잘못입력하셨습니다.
				} else if (menu.equals("2")) {
					System.out.println("아이디를 입력해주세요.");
					//적어도 몇글자이상 입력했는지 체크 , 이미 사용중인 아이디인지 체크.
					//.length 몇글자이상인지(java), select count(*) from ...
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setUser_id(sc.nextLine());
					System.out.println("비밀번호를 입력해주세요.");
					memberDTO.setUser_pw(sc.nextLine());
					System.out.println("닉네임를 입력해주세요.");
					memberDTO.setUser_nick(sc.nextLine());
					dao.memberJoin(memberDTO);
				} else {
					System.out.println("없는 메뉴입니다. 다시 선택해주세요.");
				}

			} else {
				System.out.println("1.회원정보 수정  2.회원탈퇴 3.로그아웃" );
				
				String menu = sc.nextLine();
				if(menu.equals("1")) {
					// pw , nick 
					// 비어있는 상태로 엔터키를 치면 기본값을 그대로 유지하고,
					// 다른값을 입력했을때만 정보수정이 되게끔 처리.
					// MemberDAO.dto <- 
					String pw = sc.nextLine();
					String nick = sc.nextLine();
					System.out.println("정보를 입력하지 않았다면 기존 정보가 그대로 유지됩니다.");
					System.out.println(MemberDAO.dto.getUser_pw() + "에서 =>" + pw);
					System.out.println(MemberDAO.dto.getUser_nick() + "에서 =>" + nick);
					if(pw.trim().length() < 1) {
						pw = MemberDAO.dto.getUser_pw();
					}
					if(nick.trim().length() < 1) {
						nick = MemberDAO.dto.getUser_nick();
					}
					
					dao.memberUpdate(pw , nick);
					
					
				}else if(menu.equals("2")) {
					System.out.println("정말로 탈퇴하시겠습니까?");
					if(sc.nextLine().equalsIgnoreCase("Y")) {
						dao.memberDelete();
					}
				}else if(menu.equals("3")) {
					MemberDAO.dto = null;
				}else {
					System.out.println("잘못된입력");
				}
			}
		}
	}
}
