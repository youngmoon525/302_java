package last.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	public static MemberDTO dto;// 초기 상태 null
	public static final int STUDENT_NO = 99 ;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public Connection connDB() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "javatest";
		String password = "0000";

		Connection cn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}

	public void dbClose() {
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

	public void memberLogin(String id, String pw) {
		conn = connDB();
		String sql = "SELECT * FROM TEST_MEMBER WHERE STUDENT_NO = ? AND user_id = ? AND user_pw = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, STUDENT_NO);
			ps.setString(2, id);
			ps.setString(3, pw);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("user_id"));
				dto = new MemberDTO(rs.getInt("student_no"), rs.getString("user_id"), rs.getString("user_pw"),
						rs.getString("admin"), rs.getString("user_nick"));
			}
//			System.out.println(dto == null ? true : false);
//			if(dto == null) {
//				return true;
//			}else {
//				return false;
//			}
		} catch (Exception e) {

		}finally {
			dbClose();
		}
	}

	public void memberJoin(MemberDTO dto) {
		conn = connDB();
		try {
			String sql = " INSERT INTO TEST_MEMBER ( STUDENT_NO , USER_ID , USER_PW , USER_NICK) " + 
						 "       VALUES ( ? , ? , ? , ?) ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, STUDENT_NO);
			ps.setString(2, dto.getUser_id());
			ps.setString(3, dto.getUser_pw());
			ps.setString(4, dto.getUser_nick());
			int result = ps.executeUpdate();
			if(result == 1) {
				System.out.println("회원가입이 성공했습니다. 자동으로 로그인을 합니다.");
				memberLogin(dto.getUser_id(), dto.getUser_pw());
			}else {
				System.out.println("회원가입이 실패했습니다.");
			}
			
			
			
		}catch (Exception e) {
			System.out.println("회원가입 중 에러");
			e.printStackTrace();
		}
	}

	public void memberUpdate(String pw, String nick) {
		conn = connDB();
		String sql = "UPDATE TEST_MEMBER " + 
					 "SET user_pw = ? " + 
					 ",   user_nick = ? " + 
					 "WHERE student_no = ? " + 
					 "AND user_id = ? "; 
		try {

			ps = conn.prepareStatement(sql);
			ps.setString(1, pw);
			ps.setString(2, nick);
			ps.setInt(3, STUDENT_NO);
			ps.setString(4, dto.getUser_id());
			int result = ps.executeUpdate();
			if(result == 1) {
				//회원정보가 수정되고나서 다시 로그인처리를 할껀지, 로그아웃처리 ?
				//memberLogin(dto.getUser_id(), dto.getUser_pw());
				dto = null ;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원정보 수정중 에러");
		}finally {
			dbClose();
		}
		
	}
	
	public void memberDelete() {
		conn = connDB();
		try {
			ps = conn.prepareStatement("DELETE FROM TEST_MEMBER WHERE STUDENT_NO=? AND USER_ID = ? ");
			ps.setInt(1, STUDENT_NO);
			ps.setString(2, dto.getUser_id());
			int result = ps.executeUpdate();
			if(result == 1) {
				dto = null;
				System.out.println("정상적으로 탈퇴가 되었습니다.");
			}else {
				System.out.println("서버 오류 발생. 다시 시도 해주세요.");
			}
		}catch (Exception e) {
			
		}

	}
}
