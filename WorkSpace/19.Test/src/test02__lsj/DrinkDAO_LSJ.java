package test02__lsj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class DrinkDAO_LSJ {
	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
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
	
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int inputInt() {
		int n;
		while(true) {
			try {
				n = Integer.parseInt(sc.nextLine());
				return n;
			}catch(Exception e) {
				System.out.println("숫자를 입력해주세요!");
				System.out.print("다시 입력: ");
				continue;
			}
		}
	}
	
	public String inputString() {
		String str="";
		try {
			str = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return str;
		
	}
	
	public boolean login() throws IOException {
		while(true) {			
			System.out.print("아이디: ");
			String id = inputString();
			
			System.out.print("비밀번호: ");
			String pw = inputString();
			
			String sql = "select user_id, user_pw, admin\r\n" + 
					"from test_member\r\n" + 
					"where student_no=9";
			
			conn = connDB();
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					if(id.equals(rs.getString("user_id"))&&pw.equals(rs.getString("user_pw"))) {
						if("Y".equals(rs.getString("admin"))) {
							System.out.println("관리자입니다.");
							return true;
						}else {
							System.out.println("사용자입니다.");
							return false;
						}
					}
				}
				System.out.println("아이디나 비밀번호를 잘못 입력하셨습니다.");
				continue;
			}catch (Exception e) {
				System.out.println("login() 에러");
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<DrinkDTO_LSJ> selectTable() {
		ArrayList<DrinkDTO_LSJ> drinkList = new ArrayList<DrinkDTO_LSJ>();
		conn = connDB();
		String sql = "select * from lsj_drink_tbl ORDER BY count desc";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String drink = rs.getString("drink");
				String company = rs.getString("company");
				int price = rs.getInt("price");
				int count = rs.getInt("count");
				drinkList.add(new DrinkDTO_LSJ(drink, company, price, count));
			}
		}catch (Exception e) {
			System.out.println("selectTable()오류");
			e.printStackTrace();
		}
		return drinkList;
	}
	
	public void display(ArrayList<DrinkDTO_LSJ> drinkList) {
		System.out.println("번호 \t"+"이름 \t"+"회사 \t"+"가격 \t"+"수량 \t");
		System.out.println("---------------------------------------------");
		for(int i=0; i<drinkList.size(); i++) {
			System.out.print((i+1)+ "."+"\t");
			System.out.print(drinkList.get(i).getDrink()+"\t");
			System.out.print(drinkList.get(i).getCompany()+"\t");
			System.out.print(drinkList.get(i).getPrice()+"\t");
			System.out.println(drinkList.get(i).getCount()+"\t");
		}
		
	}

	public void adminMode() {
		while(true) {
			ArrayList<DrinkDTO_LSJ> dtolist = selectTable();
			display(selectTable());
			
			System.out.println();
			
			System.out.print("1. 상품검색  ");
			System.out.print("2. 상품추가  ");
			System.out.print("3. 상품삭제  ");
			System.out.print("4. 재고관리  ");
			System.out.println("5. 로그아웃");
			System.out.print("무엇을 실행하시겠습니까?(번호 입력)>> ");
			int ans = inputInt();
			
			if(ans == 1) {
				function1();
			}
			else if(ans ==2) {
				System.out.print("추가할 메뉴: ");
				String drink = inputString();
				System.out.print("해당하는 회사: ");
				String company = inputString();
				System.out.print("해당하는 가격: ");
				int price = inputInt();
				System.out.print("재고: ");
				int count = inputInt();
				function2(drink,company,price,count);
			}
			else if(ans ==3) {
				

				System.out.print("삭제할 음료의 번호: ");
				String del = dtolist.get(inputInt()-1).getDrink();
				function3(del);
			}
			else if(ans ==4) {
				System.out.print("재고 수정할 음료의 번호: ");
				String drink = dtolist.get(inputInt()-1).getDrink();
				
				System.out.print("재고: ");
				int count = inputInt();
				
				function4(drink,count);
			}
			else if(ans ==5) {
				System.out.println("관리자 모드를 종료합니다.");
				break;
			}
			else {
				System.out.println("번호를 잘못 입력하셨습니다. 다시입력해주세요");
				continue;
			}
		}
	}

	public void function1() {
		while(true) {
			System.out.print("1. 음료이름으로 검색  ");
			System.out.print("2. 음료회사로 검색  ");
			System.out.println("3. 나가기  ");
			System.out.print("무엇을 실행하시겠습니까?(번호 입력)>> ");
			int ans = inputInt();
			
			if(ans==1) {
				System.out.print("음료이름>> ");
				display(searchDrink("drink",inputString()));
				System.out.println("다음으로 넘어가려면 enter key를 누르시오.");
				sc.nextLine();
			}
			else if(ans==2) {
				System.out.print("회사이름>> ");
				display(searchDrink("company",inputString()));
			}
			else if(ans==3) {
				break;
			}
			else {
				System.out.println("번호를 잘못 입력하셨습니다. 다시입력해주세요");
				continue;
			}
		}
	}
	
	public ArrayList<DrinkDTO_LSJ> searchDrink(String search,String name) {
		ArrayList<DrinkDTO_LSJ> drinkList = new ArrayList<DrinkDTO_LSJ>();
		conn = connDB();
		String sql = "select * from lsj_drink_tbl where "+search+"=? ORDER BY count desc";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String drink = rs.getString("drink");
				String company = rs.getString("company");
				int price = rs.getInt("price");
				int count = rs.getInt("count");
				drinkList.add(new DrinkDTO_LSJ(drink, company, price, count));
			}
		}catch (Exception e) {
			System.out.println("searchDrink()오류");
			e.printStackTrace();
		}
		return drinkList;
	}
	
	private void function2(String drink, String company, int price, int count) {
		conn = connDB();
		String sql = "INSERT INTO lsj_drink_tbl VALUES (?,?,?,?)";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, drink);
			ps.setString(2, company);
			ps.setInt(3, price);
			ps.setInt(4, count);
			
			result = ps.executeUpdate();
			
			if(result == 1) {
				System.out.println("음료가 추가 되었습니다.");
			}
			else{
				System.out.println("음료 추가 중 문제가 발생.");
			}
		}catch (Exception e) {
			System.out.println("function2() 에러");
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	
	private void function3(String drink) {
		conn = connDB();
		String sql = "delete from lsj_drink_tbl where drink=?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, drink);
			
			result = ps.executeUpdate();
			
			if(result == 1) {
				System.out.println("음료가 정상적으로 삭제되었습니다.");
			}
			else{
				System.out.println("음료 삭제 중 문제가 발생.");
			}
		}catch (Exception e) {
			System.out.println("function3() 에러");
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	
	private void function4(String drink, int count) {
		conn = connDB();
		String sql = "UPDATE lsj_drink_tbl SET count=? WHERE drink=?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, count);
			ps.setString(2, drink);
			
			result = ps.executeUpdate();
			
			if(result == 1) {
				System.out.println("메뉴를 정상적으로 수정하였습니다.");
			}
			else{
				System.out.println("메뉴 수정 중 문제가 생겼습니다.");
			}
		}catch (Exception e) {
			System.out.println("function4() 에러");
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	public void userMode() {
		while(true) {
			ArrayList<DrinkDTO_LSJ> drinkList = selectTable();
			
			display(selectTable());
			System.out.print("금액을 입력하세요(로그아웃은 0): ");
			int money = inputInt();
			
			if(money == 0) {
				break;
			}
			
			System.out.print("음료를 고르세요(번호 입력): ");
			int select = inputInt()-1;
			
			if(select < 0 || select >= drinkList.size()) {
				System.out.println("메뉴를 잘못 선택하셨습니다. 다시 확인해주세요");
				continue;
			}
			else if(drinkList.get(select).getPrice() > money) {
				System.out.println("돈이 부족합니다.");
				change(money);
			}
			else if(drinkList.get(select).getCount() <= 0) {
				System.out.println("매진입니다. 다른 음료를 골라주세요");				
				continue;
			}
			int chan = money - drinkList.get(select).getPrice();
			DrinkCntUpdate(drinkList.get(select).getDrink());
			change(chan);
		}
	}
	
	public void DrinkCntUpdate(String select) {
		conn = connDB();
		String sql = "UPDATE lsj_drink_tbl SET count=count-1 WHERE drink=?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, select);
			
			result = ps.executeUpdate();
			
			if(result == 1) {
				System.out.println("음료의 수량이 수정되었습니다.");
			}
			else{
				System.out.println("음료의 수량 수정 중 문제가 발생하였습니다.");
			}
		}catch (Exception e) {
			System.out.println("DrinkCntUpdate() 에러");
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	public void change(int chan) {
		System.out.println("잔돈: " +chan+"원");
		
		int thousand=0, hundred5=0, hundred1=0, ten=0;
		while(chan>0) {
			if(chan/1000>0) {
				thousand = chan / 1000;
				chan = chan % 1000;
			}
			else if(chan/500>0) {
				hundred5 = chan / 500;
				chan = chan % 500;
			}
			else if(chan/100>0){
				hundred1 = chan / 100;
				chan = chan % 100;
			}
			else {
				ten = chan / 10;
				chan = chan % 10;
			}
		}
		System.out.println("천원: "+thousand+"개, "+"오백원: "+hundred5+"개, "+"백원: "+hundred1+"개 "+"십원: "+ten+"개 ");
		System.out.println("다음으로 넘어가기위해 enter key를 눌러주세요.");
		sc.nextLine();
	}
}
