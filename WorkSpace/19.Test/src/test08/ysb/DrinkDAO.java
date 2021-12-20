package test08.ysb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class DrinkDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	Scanner sc = new Scanner(System.in);
	
	//1.연결 2.전송 3.결과
	//DB랑 연결하기 계속 사용할것
	public Connection connDB() {
		String url = "jdbc:oracle:thin:@121.148.239.238:1521:xe";
		String user = "javatest"; 
		String password = "0000";
		Connection cn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(url, user, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	//연결 테스트 dual;
	public void ConnTest() {
		conn = connDB();
		String sql = " select 1 from dual ";
		try { 
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();//실행
			while(rs.next()) {
				rs.getInt(1);
				System.out.println(1);
		} 	
			}catch (Exception e) {
				System.out.println("연결 오류");
				e.printStackTrace();
		}
	}
	//DB 닫기
	//역순으로 결과-전송-연결
	public void dbClose() {
		try { //null을 회피하는것
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//1. 로그인 
	
	//숫자만 입력받기
	public int inputint() {
		int a;
		while(true) {
			try {
				System.out.println("입력 :");
				a = Integer.parseInt(sc.nextLine());
				return a;
			}catch (Exception e) {
				System.out.println("잘못 입력하셨습니다");
				System.out.println("숫자로 입력하세요");
				continue;
			}
		}
	}
	//문자만 입력받기
	public String inputString() {
		System.out.println("입력: ");
		String str = sc.nextLine();
		return str;
	}
	
	//음료 전체 목록
	public void display() {
		conn = connDB();
		String sql = "select * from YSB_DRINK_TBL";
		try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt("no")+"."+rs.getString("name")+"."+rs.getInt("price")+"원 제조|"+rs.getString("company")+"."+rs.getInt("cnt")+"개");
				}
		}catch (Exception e) {
			System.out.println("조회 실패");
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	//고른 메뉴 보여주기
	public int choiceMenu(DrinkDTO dto) {
		System.out.println("음료의 번호를 고르세요");
		display();
		int choice = inputint();
		return choice;
	}
	
	//음료 매진 확인 
	public boolean check(int no) {
		conn = connDB();
		String sql = "select count(*) cnt from YSB_DRINK_TBL where no=?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
				while(rs.next()) {
					result = rs.getInt("cnt");
					if(result == 1) {
						return true;
					}
				}
		}catch (Exception e) {
			System.out.println("선택 불가");
		}
		return false;
	}
	
	//음료 수량 제거
	public void minus(int choice, int Ncnt) {
		conn = connDB();
		String sql = " update YSB_DRINK_TBL set cnt = ?  where no = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Ncnt-1);
			ps.setInt(2, choice);
			int result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//금액 처리
	public void change(int money, int choice) {
		conn = connDB();
		String sql = " select * from YSB_DRINK_TBL where no = ?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, choice);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt("cnt") > 0) {
					result = money - rs.getInt("price");
					if(result >=100) {
						System.out.println("잔돈은 :"+result);
						System.out.println("천원: "+result/1000+"개 오백원: "+result%1000/500+"개 백원"+result%500/100+"개");
						minus(choice, rs.getInt("cnt"));;//DB에 있는 수량
					}else {
						System.out.println("금액이 부족합니다");
					}
				}else {
					System.out.println("수량이 부족합니다");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//관리자
	//음료 추가시 번호 증가
	public int maxNo() {
		conn = connDB();
		String sql = " select max(no)+1 max_no from YSB_DRINK_TBL ";
		int max_no = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				max_no = Integer.parseInt(rs.getString("max_no"));
			}
		}catch (Exception e) {
			
		}
		return max_no;
	}
	//음료 추가
	public void insertMenu(int no) {
		System.out.println("추가될 음료 이름: ");
		String name = sc.nextLine();
		System.out.println("추가될 음료의 가격: ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println("추가될 음료의 제조사: ");
		String company = sc.nextLine();
		System.out.println("추가될 음료의 수량: ");
		int cnt = Integer.parseInt(sc.nextLine());
		conn = connDB();
		String sql = " insert into YSB_DRINK_TBL values(?, ?, ?, ?, ?)";
		int result;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, name);
			ps.setInt(3, price);
			ps.setString(4, company);
			ps.setInt(5, cnt);
			result = ps.executeUpdate();
				if(result == 1) {
					System.out.println("추가 성공");
				}else {
					System.out.println("오류");
				}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	
	//음료 삭제
	public void deleteMenu() {
		System.out.println("삭제할 음료의 번호: ");
		int no = Integer.parseInt(sc.nextLine());
		conn = connDB();
		String sql = " delete YSB_DRINK_TBL where no=?";
		int result= 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			result = ps.executeUpdate();
			if(result == 1) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("오류");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	//재고 관리
	public void control() {
		System.out.println("관리할 음료의 번호: ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("조정할 수량: ");
		int Ncnt = Integer.parseInt(sc.nextLine());
		conn = connDB();
		String sql = " update YSB_DRINK_TBL set cnt=? where no=? ";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Ncnt);
			ps.setInt(2, no);
			result = ps.executeUpdate();
			if(result ==1 ) {
				System.out.println("수량 관리 성공");
			}else {
				System.out.println("오류");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	//음료 이름으로 검색
	public void searchName(String col) {
		String name = null;
		System.out.println("검색할 음료의 이름: ");
		name = sc.nextLine();
		conn = connDB();
		//String sql = " select * from YSB_DRINK_TBL where " + col +  " =? ";
		//전체 음료의 이름을 정확히 입력해야지만 나옴.↑ 사용자 편의상 좋지않음.
		String sql = " select * from YSB_DRINK_TBL where " + col +  " like '%'||?||'%' ";
		try {
			ps = conn.prepareStatement(sql);
//			ps.setString(1, "%"+name+"%");
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("no")+"."+rs.getString("name")+"."+rs.getInt("price")+"원 제조: "+rs.getString("company")+"."+rs.getInt("cnt")+"개");
				System.out.println("검색 완료");
				System.out.println("메인으로 돌아갑니다");
				}
		}catch (Exception e) {
			System.out.println("해당 이름의 음료 없음");
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	//음료 회사로 검색
	public void searchCompany() {
		String company = null;
		System.out.println("검색할 회사명: ");
		company = sc.nextLine();
		conn = connDB();
		String sql = "select * from YSB_DRINK_TBL where company=? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, company);
			rs = ps.executeQuery();
			while(rs.next()) {
					System.out.println(rs.getInt("no")+"."+rs.getString("name")+"."+rs.getInt("price")+"원 제조: "+rs.getString("company")+"."+rs.getInt("cnt")+"개");
					System.out.println("검색 완료");
					System.out.println("메인으로 돌아갑니다");
			}
		}catch (Exception e) {
			System.out.println("해당 회사의 음료가 없습니다.");
		}
	}
	//로그인 사용자
	public boolean userlogin() {
		conn = connDB();
		String sql = "select * from test_member where student_no= 8 and user_id=? and user_pw=?";
		String user_id = "";
		System.out.println("아이디: ");
		user_id = sc.nextLine();
		String user_pw = "";
		System.out.println("비밀번호: ");
		user_pw = sc.nextLine();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, user_pw);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("사용자 로그인 성공");
				return true;
			}
		}catch (Exception e) {
			System.out.println("로그인 실패");
			e.printStackTrace();
		}
		return false;
	}
	//관리자 로그인
	public boolean login() {
		conn = connDB();
		String sql = " select user_id, user_pw from test_member where user_id=? and user_pw=? ";
		String user_id = "";
		System.out.println("아이디: ");
		user_id = sc.nextLine();
		String user_pw = "";
		System.out.println("비밀번호: ");
		user_pw = sc.nextLine();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, user_pw);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("admin").equals("y")) {
					System.out.println("관리자 로그인 성공");
					return true;
				}
			}
			
		}catch (Exception e) {
			System.out.println("로그인 실패");
			e.printStackTrace();
		}
		return false;
	}
	
	public String flogin() {
		System.out.println("아이디:");
		String id = sc.nextLine();
		System.out.println("비밀번호: ");
		String pw = sc.nextLine();
		conn = connDB();
		String sql = "select * from test_member where student_no= 8 and user_id=? and user_pw=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("admin").equals("y")) {
					System.out.println("로그인 성공");
					return "admin";
				}else {
						System.out.println("로그인 성공");
						return "user";
				}
			
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		System.out.println("로그인 실패");
		return "fail";
	
	
	
	}	
	
	
	
	
}//DAO Class
