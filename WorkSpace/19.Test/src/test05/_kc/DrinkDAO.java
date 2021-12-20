package test05._kc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class DrinkDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	Scanner sc = new Scanner(System.in);
	
	public Connection connDB() {
		String url = "jdbc:oracle:thin:@121.148.239.238";
		String user="javatest";
		String password = "0000"; 
		Connection cn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(url, user, password);
			
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	public void dbClose() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void connTest(String aa) {
		conn = connDB();
		String sql ="select '"+aa+"' as sss from dual";
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);//연결객체를 통해서 전송객체가 이동하므로
											//항상 연결객체를 통해 전송객체는 초기화됨
			rs = ps.executeQuery(); //데이터베이스에가서 sql문을 실행하고 결과객체를 가져옴(ResultSet)
			while(rs.next()) { //rs.next()를 통해 다음칸으로 이동을하고 그결과가 성공(true)
				String data = rs.getString("sss");//파라메터 str ="컬럼의 이름"
												//파라메터 int ="컬럼의 순서"
				System.out.println("db에서 가지고옴 "+data);
			}
		}catch (Exception e) {
			System.out.println("통신체크 에러");
			e.printStackTrace();
		}
	}
	public boolean login(int num, String name) {
		conn = connDB();
		String sql =" SELECT * FROM student_info where no= ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			while(rs.next()) {
				String data = rs.getString("name");
				if(data.equals("권창재")) {
					
					return true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return false;
	}
	public void changeName(String name) {
		conn =connDB();
		String sql = "UPDATE student_info SET name=? WHERE no = 2";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	public boolean idCheck(String userID) {//아이디 중복확인
		// TODO Auto-generated method stub
		conn =connDB();
		String sql = " SELECT COUNT(*) as sss FROM TEST_MEMBER WHERE USER_ID="+"\'"+userID+"\'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int data = rs.getInt("sss");
				if(data==1) {//아이디 중복이이상함 
					//System.out.println("아이디 중복");
					return true;
				}else {
					System.out.println("중복되는 아이디가없습니다");
					return false;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return true;
	}
	public void BoardInsert(String userID, String userPW) {//테이블에 생성
		conn = connDB();
		String sql = " INSERT ";
		
	}
	public void showList() {
		conn = connDB();
		String sql = " SELECT * FROM KCJ_DRINK_TBL ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("NO");
				String NAME = rs.getString("NAME");
				String PRICE = rs.getString("PRICE");
				String CNT = rs.getString("CNT");
				System.out.println(no + " "+NAME+" "+ PRICE + " "+CNT+"개");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
	}
	public void selectdrink(int menu) {
		conn = connDB();
		String sql = " SELECT name FROM KCJ_DRINK_TBL WHERE no = ?";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
	}
	public int choiceDrink(int cho,int money,ArrayList<DrinkDTO> list) {
		if(list.get(cho).getCnt() == 0) {
			System.out.println("재고가 없습니다");
			return money;
		}else if(money <list.get(cho).getPrice()){
			System.out.println("잔액이 부족합니다");
			return money;
		}else {
			conn = connDB();
			String sql= " select * from KCJ_DRINK_TBL WHERE no = ?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, cho);
				rs = ps.executeQuery();
				while(rs.next()) {
						String name = list.get(cho).getName();
						money = money-list.get(cho).getPrice();
						countm(cho);
						
						System.out.println("선택하신 음료는 "+name+"입니다");
						System.out.println("잔돈 : "+money);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbClose();
			}
		}
		return money;
	}
	public int countm(int a) {
		conn = connDB();
		int result = 0;
		a=a+1;
		String sql = " UPDATE KCJ_DRINK_TBL set cnt=cnt-1 WHERE no = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a);
			result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<DrinkDTO> selectBoardList() {//배열이용 보여주기
		conn = connDB();
		String sql = " select * from KCJ_DRINK_TBL ";
		ArrayList<DrinkDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql); 
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new DrinkDTO(rs.getInt("no"), rs.getString("name"), rs.getInt("price"), rs.getString("company"), rs.getInt("cnt")));
			}
		}catch (Exception e) {
			System.out.println("목록 불러오기 실패");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}
	public void display(ArrayList<DrinkDTO> list) {
//		i  1-1 0
//		1.물 , list.get(0).getNo(); 
//		2.콜라
//		3.<-
//		4.콜라2   , 음료의 번호를 i로 보여주고 실제 로직처리는 getNo받아서 처리하면 사용자는
		//음료의 번호가 비어있는상태로 보는게 아니라 , 무조건 채워진 상태의 번호를 볼수있다.

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getNo() + ". ");
			System.out.print(list.get(i).getName()+"(");
			System.out.print(list.get(i).getPrice()+") ");
			System.out.println(list.get(i).getCnt());

			System.out.println();
		}
	}
	public void nameSearch(String name) {
		conn= connDB();
		String sql =" SELECT COUNT(*) as SS, NAME, PRICE, COMPANY, CNT FROM KCJ_DRINK_TBL WHERE name = \'"+name+"\' GROUP by NAME, PRICE, COMPANY, CNT";
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				int ss = rs.getInt("SS");
				if(ss == 1) {
					System.out.println("찾는거있음");
					String data1 = rs.getString("NAME");
					String data2 = rs.getString("PRICE");
					String data3 = rs.getString("COMPANY");
					String data4 = rs.getString("CNT");
					System.out.println(data1 +" "+ data2+" "+data3+" "+data4);
				}else {
					System.out.println("찾는거 없음");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	public void comSearch(String name) {
		conn= connDB();
		String sql =" SELECT COUNT(*) as SS, NAME, PRICE, COMPANY, CNT FROM KCJ_DRINK_TBL WHERE COMPANY = \'"+name+"\' GROUP by NAME, PRICE, COMPANY, CNT";
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				int ss = rs.getInt("SS");
				if(ss == 1) {
					System.out.println("찾는거있음");
					String data1 = rs.getString("NAME");
					String data2 = rs.getString("PRICE");
					String data3 = rs.getString("COMPANY");
					String data4 = rs.getString("CNT");
					System.out.println(data1 +" "+ data2+" "+data3+" "+data4);
				}else {
					System.out.println("찾는거 없음");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	//음료추가
	public void drinkAdd(ArrayList<DrinkDTO> list) {
		int a = getMaxno();
		System.out.print("추가하실 음료의 이름 : ");
		String name = sc.nextLine();
		System.out.print("추가하실 음료의 가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.print("추가하실 음료의 수량 : ");
		int count = Integer.parseInt(sc.nextLine());
		DrinkDTO list1 = new DrinkDTO(a, name, price,"" , count);
		boardInsert(list1);
	}
	private void boardInsert(DrinkDTO list1) {
		conn = connDB();
		int result = 0;
		String sql = " INSERT INTO KCJ_DRINK_TBL(no,name,price,cnt) VALUES (?,?,?,?) ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, list1.getNo());
			ps.setString(2, list1.getName());
			ps.setInt(3, list1.getPrice());
			ps.setInt(4, list1.getCnt());
			result = ps.executeUpdate();
			if(result == 1) {
				System.out.println("성공 !");
			}else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			System.out.println("음료추가 실패");
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	public int getMaxno() {//
		conn = connDB();
		String sql = " SELECT MAX(NO)+1 max_no FROM KCJ_DRINK_TBL ";
		int maxNo= 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				maxNo= rs.getInt("max_no");
				System.out.println(maxNo);
			};
		} catch (Exception e) {
			System.out.println("최대 NO 구하는 메소드 에러");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return maxNo;
	}
	
	//음료삭제
	public void DrinkDel(ArrayList<DrinkDTO> list) {
		System.out.print("삭제할 음료의 이름 > ");
		String name = sc.nextLine();
		conn = connDB();
		int result = 0;
		String sql = " DELETE KCJ_DRINK_TBL WHERE name=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			result= ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
	}
	public int inputInt() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("잘못입력하셨습니다");
				continue;
			}
		}
	}
}
