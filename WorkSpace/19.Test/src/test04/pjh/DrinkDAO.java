package test04.pjh;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DrinkDAO {
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

	public int validIntInput() {
		while (true) {
			try {
				int data = Integer.parseInt(sc.nextLine());
				return data;
			} catch (Exception e) {
				System.out.println("올바른 값을 입력해주세요.");
			}
		}
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

	public void display() {
		conn = connDB();
		try {
			ps = conn.prepareStatement(" select * from PJH_DRINK_TBL ORDER BY no ");
			rs = ps.executeQuery();
			System.out.println("=====전체 상품=====");
			while (rs.next()) {
				System.out.println(rs.getInt("no") + ", " + rs.getString("name") + ", " + rs.getInt("price") + "원");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	
	public void display(String option) {
		conn = connDB();
		try {
			ps = conn.prepareStatement(" select * from PJH_DRINK_TBL ORDER BY no ");
			rs = ps.executeQuery();
			System.out.println("=====전체 상품=====");
			while (rs.next()) {
				System.out.print(rs.getInt("no"));
				System.out.print(", " + rs.getString("name"));
				System.out.print(", " + rs.getInt("price")+"원");
				if(option.equals("cnt")) {
					System.out.print(", " + rs.getInt("cnt")+"개");	
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
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

	private boolean checkDrink(int no) {
		conn = connDB();
		int isThere = 0;
		try {
			ps = conn.prepareStatement(" select count(*) cnt from PJH_DRINK_TBL where no = ?");
			ps.setString(1, no + "");
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

	public int selectDrink() {
		// TODO Auto-generated method stub
		int result = 0;
		while (true) {
			display();
			System.out.println("=====입력=====");
			System.out.println("뒤로가기 : -1을 입력");
			System.out.print("결제하려는 음료 선택 : ");
			result = validIntInput();
			if (result == -1)
				break;
			if (!checkDrink(result)) {
				System.out.println("존재하는 음료의 번호를 입력해주세요.\n");
				continue;
			}
			break;
		}
		return result;
	}

	private DrinkDTO getDrinkDTO(int no) {
		conn = connDB();
		DrinkDTO temp = null;
		try {
			ps = conn.prepareStatement(" select * from PJH_DRINK_TBL where no = ?");
			ps.setString(1, no + "");
			rs = ps.executeQuery();
			while (rs.next()) {
				temp = new DrinkDTO(rs.getInt("no"), rs.getString("name"), rs.getInt("price"), rs.getInt("cnt"),
						rs.getString("company"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return temp;
	}

	private void soldDrink(DrinkDTO dto) {
		conn = connDB();
		try {
			ps = conn.prepareStatement(" UPDATE PJH_DRINK_TBL SET cnt = ? where no = ?");
			ps.setInt(1, dto.getCNT() - 1);
			ps.setInt(2, dto.getNO());
			int result = ps.executeUpdate();
			if (result == 1) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	public int calcDrink(int selDrinkNo, int money) {
		// TODO Auto-generated method stub
		DrinkDTO selInfo = getDrinkDTO(selDrinkNo);
		int calcMoney = money - selInfo.getPRICE();
		if (selInfo.getCNT() == 0) {
			System.out.println("재고가 부족합니다.");
			return money;
		}
		if (calcMoney < 0) {
			System.out.println("돈이 부족합니다.");
			return money;
		}
		soldDrink(selInfo);
		changeBills(calcMoney);
		return calcMoney;
	}

	private void changeBills(int money) {
		System.out.println("결제완료. 잔돈은 " + money + "원입니다.");
		System.out.println(
				"천원 : " + (money / 1000) + "개, 오백원 : " + (money / 500 % 2) + "개, 백원 : " + (money / 100 % 5) + "개");
	}

	public void searchProduct() {
		System.out.println("=====입력=====");
		System.out.println("1. 이름으로 찾기 | 2. 회사명으로 찾기 | 0. 돌아가기");
		int menu = validIntInputRange(0, 2);
		if (menu == 1) {
			System.out.println("찾을 이름을 입력");
			searchWithName(sc.nextLine());
		} else if (menu == 2) {
			System.out.println("찾을 회사명을 입력");
			searchWithCompany(sc.nextLine());
		}
		System.out.println("");
	}

	private void searchWithCompany(String company) {
		conn = connDB();
		try {
			ps = conn.prepareStatement(" SELECT * FROM PJH_DRINK_TBL where company like '%" + company + "%' ORDER BY no ");
//			ps.setString(1, company);
			rs = ps.executeQuery();
			System.out.println("====검색결과====");
			while (rs.next()) {
				System.out.println(new DrinkDTO(rs.getInt("no"), rs.getString("name"), rs.getInt("price"),
						rs.getInt("cnt"), rs.getString("company")).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	private void searchWithName(String name) {
		conn = connDB();
		try {
			ps = conn.prepareStatement(" SELECT * FROM PJH_DRINK_TBL where name like '%" + name + "%' ORDER BY no ");
			rs = ps.executeQuery();
			System.out.println("====검색결과====");
			while (rs.next()) {
				System.out.println(new DrinkDTO(rs.getInt("no"), rs.getString("name"), rs.getInt("price"),
						rs.getInt("cnt"), rs.getString("company")).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	private int getMaxNo() {
		conn = connDB();
		int max = -1;
		try {
			ps = conn.prepareStatement(" SELECT max(no) max FROM PJH_DRINK_TBL ");
			rs = ps.executeQuery();
			while (rs.next()) {
				max = rs.getInt("max");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return max;
	}

	public void insertProduct() {
		System.out.println("=====입력=====");
		int no = getMaxNo() + 1;
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("가격 : ");
		int price = validIntInputRange(0, Integer.MAX_VALUE);
		System.out.print("수량 : ");
		int cnt = validIntInputRange(0, Integer.MAX_VALUE);
		System.out.print("제조사 : ");
		String company = sc.nextLine();
		insertProductDB(new DrinkDTO(no, name, price, cnt, company));
	}

	public void insertProductDB(DrinkDTO dto) {
		conn = connDB();
		try {
			ps = conn.prepareStatement(" INSERT INTO pjh_drink_tbl VALUES(?, ?, ?, ?, ?)");
			ps.setInt(1, dto.getNO());
			ps.setString(2, dto.getNAME());
			ps.setInt(3, dto.getPRICE());
			ps.setInt(4, dto.getCNT());
			ps.setString(5, dto.getCOMPANY());
			int result = ps.executeUpdate();
			if (result == 1) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	public void deleteProduct() {
		int num = 0;
		while (true) {
			display();
			System.out.println("=====입력=====");
			System.out.println("뒤로가기 : -1을 입력");
			System.out.print("삭제할 음료의 번호 : ");
			num = validIntInput();
			if (num == -1)
				return;
			if (checkDrink(num)) {
				deleteProductDB(num);
				break;
			} else {
				System.out.println("해당하는 번호가 존재하지 않습니다.");
			}
		}
	}

	public void deleteProductDB(int no) {
		conn = connDB();
		try {
			ps = conn.prepareStatement(" DELETE FROM PJH_DRINK_TBL WHERE no = ?");
			ps.setInt(1, no);
			int result = ps.executeUpdate();
			if (result == 1) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	public void manageProduct() {
		// TODO Auto-generated method stub
		while (true) {
			display("cnt");
			System.out.println("=====입력=====");
			System.out.println("뒤로가기 : -1을 입력");
			System.out.print("재고를 수정할 음료의 번호 : ");
			int no = validIntInput();
			if (no == -1)
				return;
			if (checkDrink(no)) {
				DrinkDTO temp = getDrinkDTO(no);
				System.out.println(temp.getNAME() + "의 재고량 : " + temp.getCNT());
				System.out.print("바뀐 재고량 입력 : ");
				int changeCnt = validIntInputRange(0, Integer.MAX_VALUE);
				manageProductDB(no, changeCnt);
			} else {
				continue;
			}
		}
	}

	public void manageProductDB(int no, int cnt) {
		conn = connDB();
		try {
			ps = conn.prepareStatement(" UPDATE PJH_DRINK_TBL SET cnt = ? where no = ?");
			ps.setInt(1, cnt);
			ps.setInt(2, no);
			int result = ps.executeUpdate();
			if (result == 1) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
}
