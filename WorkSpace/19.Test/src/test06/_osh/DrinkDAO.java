package test06._osh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DrinkDAO<drinkDTO> {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	Scanner sc = new Scanner(System.in);

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
			System.out.println("연결오류입니다.");
		}
		return cn;
	}

	// 닫기
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

	// 테스트 용
	public void connTest(String data) {
		conn = connDB();
		String sql = "SELECT 1 col FROM dual";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getString("col");
				System.out.println("테스트");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("테스트 오류");
		}
		dbClose();
	}

	// 스캐너 및 형변환
	public int Scanner(String msg) {
		int num = 0;
		try {
			System.out.println(msg);
			num = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			Scanner("다시 입력하세요");
		}finally {
			dbClose();
		}
		return num;
	}

// 글자 스캐너
	/*public String Scanner1() {
		String st = null;
		try {

			System.out.println(sc.nextInt());

		} catch (Exception e) {
			System.out.println("잘못된 입력입니다. 다시입력하세요");
			Scanner1();
		}
		return st;
	}*/

	// 로그인
	public boolean login() {
		conn = connDB();
		// SELECT USER_ID id, USER_PW pw, ADMIN FROM TEST_MEMBER WHERE USER_ID =
		// 'OSH_USER' and USER_PW ='1111'and ADMIN= 'N'
		String sql = "SELECT upper(USER_ID) id, USER_PW pw, ADMIN ad FROM TEST_MEMBER WHERE upper(USER_ID) = upper(?) and USER_PW =? ";
		String id = null;
		String pw = null;
		try {
			System.out.println("아이디를 입력하세요.");
			id = sc.nextLine(); // 출력하면 바로 대문자 만들기
			System.out.println("비밀번호를 입력하세요.");
			pw = sc.nextLine();
			ps = conn.prepareStatement(sql);
			/// System.out.println(id); 대문자 들어가는지 확인하고자
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			while (rs.next()) {   //equalsIgnoreCase 대소문자 구분없이 값만 비교
				if (id.equalsIgnoreCase(rs.getString("id")) && pw.equals(rs.getString("pw"))) {
					if (rs.getString("ad").equals("Y")) {
						System.out.println("관리자 로그인 성공");
			
					} else {
						System.out.println("로그인 성공");
					}
					return true;
				}
//				if(id.equals(rs.getString("id")) && pw.equals(rs.getString("pw"))  
//						&& ad.equals(rs.getString("ad"))) {
//					System.out.println("관리자 모드로 로그인 하였습니다.");
//					return true;
//				}
			}
		} catch (Exception e) {
			System.out.println("로그인을 실패하였습니다.");
		}
		System.out.println("로그인실패"); // 오라클에서 값이 없을 때
		// finally { ??? finally 언제??? //dbClose 여기위치 맞나?
		dbClose();
		// }
		return false;
	}

	// drinkDTO 리스트 만들기
	public ArrayList<DrinkDTO> list() {
		conn = connDB();
		String sql = "SELECT * FROM OSH_DRINK_TBL ORDER BY NO ASC";
		ArrayList<DrinkDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DrinkDTO(rs.getInt("NO"), rs.getString("NAME"), rs.getInt("PRICE"),
						rs.getString("company"), rs.getInt("cnt")));
			}
		} catch (Exception e) {
			System.out.println("통신체크 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	// 가져온 DRINK테이블의 정보 출력하기
	public void display(ArrayList<DrinkDTO> list) {
		System.out.println("========음료 목록========");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getNo() + "." + list.get(i).getName() + "\t : " + list.get(i).getPrice()
					+ " 원 \t  " + "(재고: " + list.get(i).getCnt() + "개)");
		}
	}

	//물품있는지 체크
	public int select(String msg) {
		conn = connDB();
		String sql = "SELECT COUNT(*) NO FROM OSH_DRINK_TBL  WHERE NO= ?";
		System.out.println(msg);
		int choiceMenu = Integer.parseInt(sc.nextLine());
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, choiceMenu);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt("NO") == 1) {
					return choiceMenu;
				}
			}
		} catch (Exception e) {
			System.out.println("통신체크 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return 0;
	}

//잔돈 계산하기
	public void calculate(int money, int menu) {
		conn = connDB();
		// SELECT * FROM OSH_DRINK_TBL where no = 5
		String sql = "SELECT * FROM OSH_DRINK_TBL where no =  ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, menu);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (money >= rs.getInt("PRICE")) {
					money = money - rs.getInt("PRICE");
					System.out.println("잔돈: " + money + "원");
				} else if (money < rs.getInt("PRICE")) {
					System.out.println("잔액이 부족합니다.");
					continue;
				}
			}
		} catch (Exception e) {
			System.out.println("통신체크 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	// 선택음료 수량 업데이트
	public void Cnt(int menu) {
		conn = connDB();
		String sql = "UPDATE OSH_DRINK_TBL  SET cnt = cnt-1 WHERE no = ? ";
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, menu);
			ps.executeUpdate();
			// System.out.println(ps.executeUpdate());
		} catch (SQLException e) {
			System.out.println("해당하는 음료번호가 없습니다.");
			e.printStackTrace();
		}
		dbClose();
	}

	// 2. NO칼럼의 최댓값 알아오기
	public int maxNo() {
		conn = connDB();
		String sql = "SELECT MAX(NO)+" + 1 + " FROM osh_drink_tbl";
		int maxNo = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				maxNo = rs.getInt("MAX(NO)+1");
			}
		} catch (Exception e) {
			System.out.println("통신체크 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return maxNo;
	}

//2. 입력하기
	public int insert(int max_no) {
		conn = connDB();
		String sql = "INSERT INTO osh_drink_tbl VALUES(?, ?, ?, ?,?)";
		System.out.println("음료명을 입력하세요.");
		String name = sc.nextLine();
		System.out.println("음료의 가격을 입력하세요.");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println("음료회사명을 입력하세요.");
		String company = sc.nextLine();
		System.out.println("음료의 수량을 입력하세요.");
		int cnt = Integer.parseInt(sc.nextLine());
		DrinkDTO dto = new DrinkDTO(max_no, name, price, company, cnt);
		int a = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getNo());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getPrice());
			ps.setString(4, dto.getCompany());
			ps.setInt(5, dto.getCnt());
			a = ps.executeUpdate();
			if (a == 1) {
				System.out.println("추가 성공");
			} else {
				System.out.println("다시 시도하세요.");
			}
		} catch (Exception e) {
			System.out.println("통신체크 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return a;
	}

//1. 검색 이름
	public Boolean search(String name) {
		conn = connDB();
		String sql = "SELECT * FROM osh_drink_tbl WHERE "+ name + " LIKE '%'||?||'%'";
		System.out.println("상품명을 입력하세요.");
		String data1 = sc.nextLine();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, data1);
			rs = ps.executeQuery();
			while (rs.next()) {		
						System.out.println(rs.getInt("no")+".  "
											+rs.getString("name") +":  "
											+rs.getInt("price") +"원   "
											+rs.getInt("cnt"));
			}
			return true;
		} catch (Exception e) {
			System.out.println("통신체크 에러");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return false;
	}

	// 검색- 회사
	/*public void search2() {
		conn = connDB();
		String sql = "SELECT * FROM osh_drink_tbl WHERE company LIKE '%?%'";
		String data1 = null;
		try {
			System.out.println("회사명을 입력하세요.");
			data1 = sc.nextLine();
			ps = conn.prepareStatement(sql);
			ps.setString(1, data1);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (data1.equals(rs.getString("company"))) {
					System.out.println(data1);
				}
			}
		} catch (Exception e) {
			System.out.println("통신체크 에러");
			e.printStackTrace();
		}
	}*/

	// 관리자모드 3.삭제
	public void delete(int delMenu) {
		conn = connDB();
		String sql = "DELETE FROM  osh_drink_tbl WHERE NO =" + delMenu;
		int a = 0;
		try {
			ps = conn.prepareStatement(sql);
			a = ps.executeUpdate();
			// System.out.println(a);
		} catch (Exception e) {
			System.out.println("통신체크 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	// 3. 삭제 후 음료 숫자 재정비
	public void resetNo(int delMenu) {
		conn = connDB();
		String sql = "UPDATE  osh_drink_tbl SET NO = NO-1 WHERE NO = " + delMenu;
		int a = 0;
		try {
			ps = conn.prepareStatement(sql);
			a = ps.executeUpdate();
			if (a == 1) {
				System.out.println("삭제 성공");   //왜 성공이 아니지?
			} else {
				System.out.println("다시 시도하세요.");
			}
		} catch (Exception e) {
			System.out.println("통신체크 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	// 관리자모드 4.수정
	public void update(int changemenu) {
		conn = connDB();
		String sql = "UPDATE osh_drink_tbl SET NAME  = ?, PRICE = ?, company = ?, CNT = ? WHERE NO = ?";
		System.out.println("음료명을 입력하세요.");
		String name = sc.nextLine();
		System.out.println("음료의 가격을 입력하세요.");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println("회사명을 입력하세요.");
		String company = sc.nextLine();
		System.out.println("음료의 수량을 입력하세요.");
		int cnt = Integer.parseInt(sc.nextLine());
		DrinkDTO dto= new DrinkDTO(changemenu, name, price, company, cnt);
		int a = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getPrice());
			ps.setString(3, dto.getCompany());
			ps.setInt(4, dto.getCnt());
			ps.setInt(5, changemenu);
			a = ps.executeUpdate();
			//System.out.println(a);
		} catch (Exception e) {
			System.out.println("통신체크 에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}



}// class
