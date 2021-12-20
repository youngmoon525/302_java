package test04.pjh;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserDAO {
	private Scanner sc = new Scanner(System.in);
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	private Connection connDB() {
		String url = "jdbc:oracle:thin:@121.148.239.238:1521:xe";
		String user = "javatest";
		String password = "0000";
		Connection cn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}

	public int validIntInputRange(int min, int max) {
		while (true) {
			try {
				int data = Integer.parseInt(sc.nextLine());
				if (min <= data && data <= max) {
					return data;
				}
				System.out.println("올바른 값을 입력해주세요.");
			} catch (Exception e) {
				System.out.println("올바른 값을 입력해주세요.");
			}
		}
	}

	private boolean checkAccount(String id) {
		conn = connDB();
		int isThere = 0;
		try {
			ps = conn.prepareStatement(" select count(*) cnt from test_member where user_id = ? AND student_no = 5");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				isThere = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return isThere == 1 ? true : false;
	}

	private boolean checkAccount(String id, String pw) {
		conn = connDB();
		int isThere = 0;
		try {
			ps = conn.prepareStatement(
					" select count(*) cnt from test_member where user_id = ? AND user_pw = ? AND student_no = 5");
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			while (rs.next()) {
				isThere = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return isThere == 1 ? true : false;
	}

	public UserDTO getUserDTO(String id) {
		UserDTO temp = null;
		conn = connDB();
		try {
			ps = conn.prepareStatement(" select * from test_member where student_no = 5 AND user_id = ? ");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				temp = new UserDTO(rs.getString("user_id"), rs.getString("user_pw"), rs.getString("admin"),
						rs.getString("user_nick"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return temp;
	}

	public UserDTO login() {
		String id, pw;
		System.out.println("=====로그인=====");
		System.out.print("ID : ");
		id = sc.nextLine();
		System.out.print("PW : ");
		pw = sc.nextLine();
		if (checkAccount(id)) {
			if (checkAccount(id, pw)) {
				System.out.println("로그인 성공!");
				return getUserDTO(id);
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		} else {
			System.out.println("계정정보가 없습니다.");
		}
		return null;
	}
	
	public boolean insertAccount(String id, String pw, String nickname) {
		conn = connDB();
		int isThere = 0;
		try {
			ps = conn.prepareStatement(
					" INSERT INTO test_member VALUES(5, ?, ?, 'N', ?) ");
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, nickname);
			isThere = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return isThere == 1 ? true : false;
	}

	public boolean register() {
		String id, pw, nickname;
		System.out.println("=====회원가입=====");
		while(true) {
			System.out.print("ID : ");
			id = sc.nextLine();
			if (!checkAccount(id)) {
				System.out.print("PW : ");
				pw = sc.nextLine();
				System.out.print("닉네임 : ");
				nickname = sc.nextLine();
				if(insertAccount(id, pw, nickname)) return true;
				else {
					System.out.println("회원가입에 실패하였습니다.");
					return false;
				}
			} else {
				System.out.println("이미 존재하는 ID입니다.");
				System.out.println("다른 ID를 사용해주세요");
				break;
			}
		}
		return false;
	}
	
	public void connTest() {
		conn = connDB();
		try {
			ps = conn.prepareStatement(" select * from student_info ");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	private void closeDB() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




/*public UserDTO login() {
	int currLimit = 0;
	String id, pw;
	while(true) {
		System.out.print("ID : ");
		id = sc.nextLine();
		System.out.print("PW : ");
		pw = sc.nextLine();
		if (checkAccount(id)) {
			if (checkAccount(id, pw)) {
				System.out.println("로그인 성공!");
				return getUserDTO(id);
			} else {
				if(currLimit >= LOGIN_LIMIT_COUNT) break;
				System.out.println("비밀번호가 틀렸습니다.");
			}
		} else {
			System.out.println("계정정보가 없습니다.");
		}
		if(++currLimit >= LOGIN_LIMIT_COUNT) break;
		System.out.println(LOGIN_LIMIT_COUNT + "번 실패 시 강제로 메뉴로 돌아갑니다.");
		System.out.println("현재 실패 횟수는" + currLimit + " 회 입니다");
	}
	return null;
}*/
