package test07._jg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class TestDAO {
	Scanner sc = new Scanner(System.in);
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//=========================================================
	public Connection connDB() {
		String url = "jdbc:oracle:thin:@121.148.239.238:1521:xe";
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
	//=========================================================
	public void dbClose() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//=========================================================
	public int rtnint() {
		int no;
		while(true) {
			try {
				no = Integer.parseInt( sc.nextLine() );
				return no;
			} catch (Exception e) {
				System.out.println("숫자를 입력하세요");
				e.printStackTrace();
			}
		}
	}
	//=========================================================
	public String login() {	//로그인
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pw = sc.nextLine();
		
		conn = connDB();
		String sql = " SELECT * FROM TEST_MEMBER WHERE STUDENT_NO = 10 AND USER_ID=? AND USER_PW=? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("admin").equals("Y")) {
					System.out.println("로그인 성공 :관리자");
					return "admin";
				}else {
					System.out.println("로그인 성공 :사용자");
					return "user";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인에러");
		}
		return "fail";
	}
	//=========================================================
	public void display() {
		conn = connDB();
		String sql = " select * from jgh_drink_tbl order by no asc " ;
		try {
			ps = conn.prepareStatement(sql); 
			rs = ps.executeQuery();
			while( rs.next() ) {
				System.out.print(rs.getInt("no") + "\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("company")+"\t");
				System.out.print(rs.getString("price")+"\t");
				System.out.println(rs.getInt("cnt") );
			}
		}catch (Exception e) {
			System.out.println("메뉴판 조회 실패");
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	//=========================================================
	public int maxNo() {
		conn = connDB();
		String sql = " select max(no)+1 max_no FROM JGH_DRINK_TBL " ;
		int max = 0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				//max = Integer.parseInt(rs.getString("max_no"));
				max = Integer.parseInt(rs.getString("max_no"));
			}
		} catch (Exception e) {
			System.out.println("maxNo err");
			e.printStackTrace();
		}
		System.out.println(max);
		return  max ;
	}
	//=========================================================
	public int InsertDrink(int no) {
		String sql = "INSERT INTO jgh_drink_tbl VALUES ( ? , ? , ? , ? , ?)";
	
		int result = 0;
		String name = sc.nextLine();
		String company = sc.nextLine();
		int price = Integer.parseInt(sc.nextLine());
		int cnt = Integer.parseInt(sc.nextLine());
		
		conn = connDB();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2,name);
			ps.setString(3, company);
			ps.setInt(4, price);
			ps.setInt(5, cnt);
			result = ps.executeUpdate();//<- Auto Commit ;
			if(result == 1) {
				System.out.println("성공!");
			}else {
				System.out.println("실패");
			}
		}catch (Exception e) {
			System.out.println("글 추가 오류");
		}
		return result;
	}
	//=========================================================
	public void delete(int data) {
		conn = connDB();
		String sql = "delete jgh_drink_tbl where no = ?";
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, data);
			//rs = ps.executeUpdate();
			
			System.out.println("db에서 가지고옴");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//=========================================================
	public void display2(String a , String b ){
		conn = connDB();
		String sql = "select * from jgh_Drink_tbl where "+ a  +"=? order by no asc";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, b);
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("no") + "\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("company")+"\t");
				System.out.print(rs.getString("price")+"\t");
				System.out.println(rs.getInt("cnt") );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	//=========================================================
	public ArrayList<TestDTO> DrinkSelect() { // list에 음료 목록 저장
		conn = connDB();
		String sql = "SELECT * FROM YSM_DRINK_TBL ORDER BY no ASC";
		ArrayList<TestDTO> list = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new TestDTO(rs.getInt("no"), rs.getString("name"), rs.getString("company"),
						rs.getInt("price"), rs.getInt("cnt")));
			}
		} catch (Exception e) {
			System.out.println("상품 목록 출력 에러");
		} finally {
			dbClose();
		}
		return list;
	}
	//=========================================================
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//=========================================================
	//user
	//=========================================================
	public void order() {
		System.out.println("돈을 집어넣으");
		int money = rtnint();
		while(true) {
			ArrayList<TestDTO> list = DrinkSelect();
			display();
			System.out.println("주문음료번호");
			int choice = rtnint();
			
			conn = connDB();
			String sql = "SELECT * FROM jgh_DRINK_TBL WHERE NO=?";
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, choice);
				rs = ps.executeQuery();
				while(rs.next()) {
					if (rs.getInt("cnt") > 0) {
						if(money >= rs.getInt("price")) {
							System.out.println("상품주문완료");
							money -= rs.getInt("price");
							System.out.println("잔돈 :" + money);
							minusCnt(choice,rs.getInt("cnt"));
						}else {
							System.out.println("잔액부족입니다");
						}
					}else {
						System.out.println("재고부족입니다");
					}
				}
				System.out.println("주문이어하기1 , 로그아웃 아무숫자");
				int re = rtnint();
				if(re == 1) {
					System.out.println("보유금액추가 1 , 혹은 아무키나 누르세요");
					int num = rtnint();
					if(num == 1 ) {
						System.out.println("추가할금액");
						int add = rtnint();
						money += add;
					}else {//보유금액 추가없이계속
						continue;
					}
				}else {
					System.out.println("로그아웃합니다");
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//=========================================================
	public void minusCnt(int choice , int nowCnt) {
		conn = connDB();
		String sql = "update jgh_Drink_Tbl set cnt = ? where no = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nowCnt-1);
			ps.setInt(2, choice);
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//=========================================================
	
	
	
	
	
	
	
	public int rtnInt(String msg ,int beginInt , int endInt ) {
		while (true) {
			try {
				System.out.println(msg);
				int temp_int = Integer.parseInt(sc.nextLine());
				if(beginInt <= temp_int && endInt >= temp_int) {
					return temp_int ;
				}
				System.out.print("숫자가 범위를 벗어났습니다." );
				System.out.println( " : 범위 ( " + beginInt + "~" + endInt + "까지)");
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	public int inputInt() {
		int n ;
		while(true) {
			try {
				n= Integer.parseInt(  sc.nextLine() );
			} catch (Exception e) {
				System.out.println("숫자를 입력");
				System.out.println("다시입력");
				continue;
			}
			return n;
		}
	}
	public ArrayList<TestDTO> selectDrink() {
		conn = connDB();
		String sql = " select * from JGH_DRINK_TBL order by no " ;
		ArrayList<TestDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql); 
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new TestDTO(
						  rs.getInt("no")
						, rs.getString("name")
						, rs.getString("company")
						, rs.getInt("price")
						, rs.getInt("cnt"))
						);
			}
		}catch (Exception e) {
			System.out.println("게시판 글 조회 실패");
		}finally {
			dbClose();
		}
		return list ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
