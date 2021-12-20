package test03_ysm;

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

	public Connection connDB() { // db 연결
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

	public void dbClose() { // db 닫기
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

	public int changeInt() { // 숫자가 아닌 값 입력 방지
		while (true) {
			try {
				int num = Integer.parseInt(sc.nextLine());
				return num;
			} catch (Exception e) {
				System.out.print("다시 입력하세요. : ");
			}
		}
	}

	public int maxNo() { // 컬럼 최대값 구하기
		conn = connDB();
		int max = 0;
		String sql = "SELECT MAX(NO)+1 max_no FROM YSM_DRINK_TBL";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				max = Integer.parseInt(rs.getString("max_no"));
			}
		} catch (Exception e) {
			System.out.println("최대값 구하기 에러");
		}
		return max;
	}

	public boolean checkCnt(int no) { // 테이블에 존재하는 음료인지 체크
		conn = connDB();
		String sql = "SELECT COUNT(*) cnt FROM YSM_DRINK_TBL WHERE no=?";
		int data = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			while (rs.next()) {
				data = Integer.parseInt(rs.getString("cnt"));
				if (data == 1) {
					return true;
				} else {
					System.out.println("존재하지 않는 음료입니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String login() { // 로그인
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();

		conn = connDB();
		String sql = "SELECT * FROM TEST_MEMBER WHERE STUDENT_NO=7 AND USER_ID=? AND USER_PW=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString("ADMIN").equals("Y")) {
					System.out.println("로그인 성공 : 관리자");
					return "admin";
				} else {
					System.out.println("로그인 성공 : 일반 회원");
					return "user";
				}
			}
		} catch (Exception e) {
			System.out.println("로그인 함수 에러");
		}
		System.out.println("로그인 실패");
		return "fail";
	}

	public ArrayList<DrinkDTO> DrinkSelect() { // list에 음료 목록 저장
		conn = connDB();
		String sql = "SELECT * FROM YSM_DRINK_TBL ORDER BY no ASC";
		ArrayList<DrinkDTO> list = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DrinkDTO(rs.getInt("no"), rs.getString("name"), rs.getString("company"),
						rs.getInt("price"), rs.getInt("cnt")));
			}
		} catch (Exception e) {
			System.out.println("상품 목록 출력 에러");
		} finally {
			dbClose();
		}
		return list;
	}

	public void display(ArrayList<DrinkDTO> list) { // 전체 상품 목록 출력
		System.out.println("=================================================");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getNo() + "." + list.get(i).getName() + "(" + list.get(i).getPrice()
					+ "원, 수량:" + list.get(i).getCnt() + "개)");
		}
		System.out.println("=================================================");
	}

	// 관리자모드
	public void selectItem() { // 상품검색
		System.out.print("검색어를 입력해주세요(음료 이름, 회사) : ");
		String search = sc.nextLine();

		conn = connDB();
		String sql = "SELECT * FROM YSM_DRINK_TBL WHERE NAME=? OR COMPANY=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, search);
			ps.setString(2, search);
			rs = ps.executeQuery();
			System.out.println("검색 결과");
			while (rs.next()) {
				System.out.print("상품번호 : " + rs.getInt("no"));
				System.out.print(", 이름 : " + rs.getString("name"));
				System.out.print(", 회사 : " + rs.getString("company"));
				System.out.print(", 가격 : " + rs.getInt("price"));
				System.out.println(", 재고 : " + rs.getInt("cnt"));
			}
		} catch (Exception e) {
			System.out.println("상품검색 에러");
		}
	}

	public void insertItem(int maxNo) { // 상품 추가
		System.out.print("추가할 음료 이름 : ");
		String name = sc.nextLine();
		System.out.print("추가할 음료 회사 : ");
		String company = sc.nextLine();
		System.out.print("추가할 음료 가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.print("추가할 음료 재고 : ");
		int cnt = Integer.parseInt(sc.nextLine());

		conn = connDB();
		String sql = "INSERT INTO YSM_DRINK_TBL VALUES (?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maxNo);
			ps.setString(2, name);
			ps.setString(3, company);
			ps.setInt(4, price);
			ps.setInt(5, cnt);
			int result = ps.executeUpdate();
			if (result == 1) {
				System.out.println("상품 추가 성공!");
			} else {
				System.out.println("상품 추가 실패..");
			}
		} catch (Exception e) {
			System.out.println("상품 추가 에러");
		}
	}

	public void deleteItem(ArrayList<DrinkDTO> list) { // 상품 삭제
		System.out.print("삭제할 음료 번호 : ");
		int choice = changeInt();

		if (checkCnt(choice)) {
			conn = connDB();
			String sql = "DELETE FROM YSM_DRINK_TBL WHERE no=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, choice);
				int result = ps.executeUpdate();
				if (result == 1) {
					System.out.println("상품 삭제 성공!");
				} else {
					System.out.println("상품 삭제 실패..");
				}
			} catch (Exception e) {
				System.out.println("상품 삭제 에러");
			}
		}
	}

	public void updateCnt() { // 재고 관리
		System.out.print("재고를 수정할 음료 번호 : ");
		int choice = changeInt();
		if (checkCnt(choice)) {
			System.out.print("음료의 총 재고 : ");
			int change = changeInt();
			if (change < 0) {
				System.out.println("0 이상의 값을 입력하세요");
			} else {
				conn = connDB();
				String sql = "UPDATE YSM_DRINK_TBL SET cnt=? WHERE no=?";
				try {
					ps = conn.prepareStatement(sql);
					ps.setInt(1, change);
					ps.setInt(2, choice);
					int result = ps.executeUpdate();
					if (result == 1) {
						System.out.println("재고 수정 완료!");
					} else {
						System.out.println("재고 수정 실패..");
					}
				} catch (Exception e) {
					System.out.println("재고 관리 에러");
				}
			}
		}
	}

	// 사용자 모드
	public void order() { // 금액 입력 및 상품 주문
		System.out.print("보유 금액 : ");
		int won = changeInt();
		while (true) {
			ArrayList<DrinkDTO> list = DrinkSelect();
			display(list);
			System.out.print("주문할 음료 번호 : ");
			int choice = changeInt();

			conn = connDB();
			String sql = "SELECT * FROM YSM_DRINK_TBL WHERE NO=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, choice);
				rs = ps.executeQuery();
				while (rs.next()) {
					if (rs.getInt("cnt") > 0) {
						if (won >= rs.getInt("price")) {
							System.out.println("상품 주문 완료!");
							won -= rs.getInt("price");
							System.out.println("잔돈은 " + won + "원입니다.");
							minusCnt(choice, rs.getInt("cnt"));
						} else {
							System.out.println("보유 금액이 부족하여 주문하지 못했습니다.");
						}
					} else {
						System.out.println("죄송합니다.재고가 부족합니다.");
					}
				}
				System.out.print("주문 이어하기(1), 로그아웃(아무숫자)");
				int re = changeInt();
				if (re == 1) { // 주문 이어하기
					System.out.print("보유 금액 추가(1), 주문(아무숫자) : ");
					int num = changeInt();
					if (num == 1) { // 보유 금액 추기
						System.out.print("추가할 금액 : ");
						int add = changeInt();
						won += add;
					} else { //보유 금액 추가 없이 계속 주문
						continue;
					}
				} else {
					System.out.println("로그아웃 합니다");
					break;
				}
			} catch (Exception e) {
				System.out.println("주문 에러");
			}
		}
	}

public void minusCnt(int choice, int nowCnt) { // 사용자가 주문한 음료 재고 1개 빼기
		conn = connDB();
		String sql = "UPDATE YSM_DRINK_TBL SET cnt=? WHERE no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nowCnt - 1);
			ps.setInt(2, choice);
			int result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("재고 줄이기 에러");
		}
	}

	// 회원가입
	public ArrayList<String> selectUser() { // 회원가입된 사용자들의 아이디 리스트에 저장
		ArrayList<String> list = new ArrayList<>();
		conn = connDB();
		String sql = "SELECT * FROM TEST_MEMBER WHERE STUDENT_NO=7";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("USER_ID"));
			}
		} catch (Exception e) {
			System.out.println("회원 목록 조회 에러");
		}
		return list;
	}

	public String du_id(ArrayList<String> list) { // 아이디 중복 방지
		String id = "";
		while (true) {
			System.out.print("아이디 : ");
			id = sc.nextLine();
			int duplicate = 0;
			for (int i = 0; i < list.size(); i++) {
				if (id.equals(list.get(i))) {
					duplicate++;
				}
			}
			if (duplicate == 1) {
				System.out.println("이미 존재하는 아이디입니다.");
				continue;
			}
			return id;
		}
	}

	public void welcom(ArrayList<String> list) { // 회원가입
		String id = du_id(list);
		System.out.println(id);
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		System.out.print("닉네임 : ");
		String nick = sc.nextLine();

		conn = connDB();
		String sql = "INSERT INTO TEST_MEMBER VALUES (7, ?, ?, 'N', ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, nick);
			int result = ps.executeUpdate();
			if (result == 1) {
				System.out.println("회원가입 성공!");
			} else {
				System.out.println("회원가입 실패..");
			}
		} catch (Exception e) {
			System.out.println("회원가입 에러");
		}
	}
}