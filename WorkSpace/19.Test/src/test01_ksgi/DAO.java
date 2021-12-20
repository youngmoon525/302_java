package test01_ksgi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {
	//라이브러리 당겨왔는지 확인하기
	//oracle.jdbc.driver.OracleDriver
	
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
	Scanner sc = new Scanner(System.in);
	
	//DB여는 메소드
		public Connection connDB() {
			String url = "jdbc:oracle:thin:@121.148.239.238:1521:xe";
			String user = "javatest";
			String password = "0000";
			Connection cn = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				cn = DriverManager.getConnection(url, user, password);			
				/*//cn이 정상적으로 열려있는지 체크하기
				if(cn.isClosed()) {
					System.out.println("닫힘");
				}else {
					System.out.println("열림");
				}*/
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cn;
		}
		
		//DB 닫는 메소드
		public void dbClose() {
				try {
					if(rs!=null) {
						rs.close();
					}
					if(ps!=null) {
						ps.close();
					}
					if(conn!=null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
/*		//통신체크 메소드
		public void connTest() {
			conn = connDB();
			String sql = "select " +  20  + " from dual";
			try {
				ps = conn.prepareStatement(sql); 
				rs = ps.executeQuery();
				while(rs.next()) {
					String data = rs.getString("20");
					System.out.println(data);
				}
			}catch(Exception e) {
				System.out.println("통신체크 에러");
				e.printStackTrace();
			}
		}*/
//=여러번 쓰는 메소드================================================================================		
		//메시지 출력 + 선택(또는 금액입력)하는 메소드
		public int start(String msg) {
			int won = 0;
			System.out.println(msg);
			while(true) {			
				try {
					won = Integer.parseInt(sc.nextLine());
					return won;
				}catch(Exception e) {
					System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				}
			}
			
		}
		
		//DB에 있는 KSG_DRINK_TBL 테이블의 정보 모두 가져오기
		public ArrayList<DTO> list (){
			conn = connDB();
			String sql = "SELECT * FROM KSG_DRINK_TBL ORDER BY NO ASC";
			ArrayList<DTO> list = new ArrayList<>();
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new DTO(rs.getInt("NO"), rs.getString("NAME"), rs.getInt("PRICE"), rs.getString("COMPANY"), rs.getInt("CNT")));
				}
			}catch (Exception e) {
				System.out.println("통신체크 에러");
				e.printStackTrace();
			}finally {
				dbClose();
			}return list;
		}
		
		//가져온 KSG_DRINK_TBL 테이블의 정보 출력하기
		public void display(ArrayList<DTO> list) {
			System.out.println("============================");
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).getNo() + "."
								+list.get(i).getName() + " : " 
								+list.get(i).getPrice()
								+"(재고: "+list.get(i).getCnt()+"개)"
								);
			}
			System.out.println("============================");
		}
		
//=로그인, 로그아웃================================================================================				
		//로그인
		public String login() {
			conn = connDB();
			//SELECT USER_ID id, USER_PW pw FROM __ WHERE USER_ID=? AND USER_PW =?;
			String sql = "SELECT USER_ID id, USER_PW pw, ADMIN admin FROM TEST_MEMBER WHERE USER_ID=? AND USER_PW = ? AND STUDENT_NO = 3";
			String id = null;
			String pw = null;
			try {
				System.out.println("아이디를 입력하세요.");
				id = sc.nextLine();
				System.out.println("비밀번호를 입력하세요.");
				pw = sc.nextLine();
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, pw);
				rs = ps.executeQuery();
				while(rs.next()) {
					if(id.equals(rs.getString("id")) && pw.equals(rs.getString("pw"))){
						System.out.println("로그인 성공");
						//System.out.println(rs.getString("admin"));
						return rs.getString("admin");	
					}
				}
			}catch (Exception e) {
				System.out.println("통신체크 에러");
				e.printStackTrace();
			}finally {
				dbClose();
			}
			System.out.println("아이디 또는 비밀번호를 잘못 입력하셨습니다. 처음 화면으로 되돌아갑니다.");
			return "로그인 실패";
		}
		
		//로그아웃
		public void logOut() {
			System.out.println("enter key를 누르면 로그아웃됩니다.");
			sc.nextLine();
		}
		
//=회원가입용================================================================================		
		//아이디 중복확인
		public boolean dupliId(String newUserId) {
			conn = connDB();
			//SELECT COUNT(*) newUserId FROM TEST_MEMBER WHERE USER_ID = 'ksg1';
			String sql = "SELECT COUNT(*) newUserId FROM TEST_MEMBER WHERE USER_ID = ?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, newUserId);
				rs = ps.executeQuery();
				while(rs.next()) {
					if( rs.getInt("newUserId") == 0) {
						return true;
					}				
				}
			}catch (Exception e) {
				System.out.println("통신체크 에러");
				e.printStackTrace();
			}
			return false;
		}		
		
		//회원가입
		public void join() {
			conn = connDB();
			//INSERT INTO test_member (STUDENT_NO, USER_ID, USER_PW, ADMIN, USER_NICK)
				//VALUES(3, 'adminS', '0000', 'Y', 'Seulgi_Admin');
			String sql = "INSERT INTO test_member VALUES(3, ?, ?, 'N', ?)";
			
			System.out.println("아이디를 입력하세요.");
			String newUserId = sc.nextLine();
			if(dupliId(newUserId) == true) {
				System.out.println("비밀번호를 입력하세요.");
				String newUserPw = sc.nextLine();
				System.out.println("닉네임을 입력하세요.");
				String newUserNick = sc.nextLine();
				int a = 0;
				try {
					ps = conn.prepareStatement(sql);
					ps.setString(1, newUserId);
					ps.setString(2, newUserPw);
					ps.setString(3, newUserNick);
					a = ps.executeUpdate();
					if(a==1) {
						System.out.println("회원 가입을 축하합니다! 메인 화면으로 돌아갑니다.");
					}else {
						System.out.println("다시 시도하세요.");
					}
				}catch (Exception e) {
					System.out.println("통신체크 에러");
					e.printStackTrace();
				}				
			}else if(dupliId(newUserId)== false) {
				System.out.println("중복된 아이디입니다.");
			}			
		}
//=일반회원용================================================================================	
		//음료, 메뉴 선택하기+선택이 제대로 되었는지 확인하기
		public int choice(String msg) {
			conn = connDB();
			String sql = "SELECT COUNT(*) NO FROM KSG_DRINK_TBL WHERE NO=?";
			int choiceMenu = start(msg);		
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, choiceMenu);
				rs = ps.executeQuery();
				while(rs.next()) {
					if( rs.getInt("NO") == 1) {
						return choiceMenu;
					}else {
						System.out.println("잘못된 입력입니다.");
					}
				}
			}catch (Exception e) {
				System.out.println("통신체크 에러");
				e.printStackTrace();
			}finally {
				dbClose();
			}return 0;		
		}
		//재고 확인용
		public int checkCnt(int choiceMenu) {
			conn = connDB();
			String sql = "SELECT CNT FROM KSG_DRINK_TBL WHERE NO=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, choiceMenu);
				rs = ps.executeQuery();
				while(rs.next()) {
					if( rs.getInt("CNT") > 0) {
						return choiceMenu;
					}else if( rs.getInt("CNT") <= 0) {
						System.out.println("현재 해당 음료의 재고가 부족합니다.");
						System.out.println("enter를 누르면 주문 화면으로 돌아갑니다.");
						sc.nextLine();
						return 0;
					}
				}
			}catch (Exception e) {
				System.out.println("통신체크 에러");
				e.printStackTrace();
			}finally {
				dbClose();
			}return 0;		
		}
		

		//잔돈 계산하기
		public int calculate(int money, int choiceMenu) {
			conn = connDB();
			//SELECT PRICE FROM KSG_DRINK_TBL WHERE NO=1;
			String sql = "SELECT PRICE FROM KSG_DRINK_TBL WHERE NO=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, choiceMenu);
				rs = ps.executeQuery();
				while(rs.next()) {
					if(money>=rs.getInt("PRICE")) {
						money = money - rs.getInt("PRICE");
						System.out.println("잔돈: " + money + "원");
						System.out.println("천원: " + money/1000 + " 오백원: " + money%1000/500 + " 백원: " + money%500/100 );
						cntMiusOne(checkCnt(choiceMenu));
						return money;
					}else {
						System.out.println("돈이 부족합니다.");
						System.out.println("enter를 누르면 주문 화면으로 돌아갑니다.");
						sc.nextLine();
					}
				}
			}catch (Exception e) {
				System.out.println("통신체크 에러");
				e.printStackTrace();
			}finally {
				dbClose();
			}
			return 0;
		}
		
		//재고 빼서 업데이트 하기
		public void cntMiusOne(int choiceMenu) {
			conn = connDB();
			//UPDATE DRINK SET CNT = CNT-1 WHERE NO=3;
			String sql = "UPDATE KSG_DRINK_TBL SET CNT = CNT-? WHERE NO=?";
			int a=0;
			if(choiceMenu > 0) {
				try {
					ps = conn.prepareStatement(sql);
					ps.setInt(1, 1);
					ps.setInt(2, choiceMenu);
					a=ps.executeUpdate();
				}catch (Exception e) {
					System.out.println("통신체크 에러");
					e.printStackTrace();
				}finally {
					dbClose();
				}
			}
		}		

//=관리자용================================================================================		
		//관리자모드 1.검색 - 이름으로 
		public void searchN(ArrayList<DTO> list, String search) {
			System.out.println("검색할 이름을 입력하세요.");
			search = sc.nextLine();
			Boolean res = false;
			for(int i=0; i<list.size(); i++) { 
				if(search.equals(list.get(i).getName())) {
					res = true;
				}
			}
			if(res == true) {
				System.out.println("'"+search+"' 음료가 존재합니다.");
			}else {
				System.out.println("해당 음료가 존재하지 않습니다.");
			}

			System.out.println("enter key를 누르면 관리자 메인화면으로 돌아갑니다.");
			sc.nextLine();			
		}
		
		//관리자모드 1.검색 - 제조사로 
		public void searchC(ArrayList<DTO> list, String search) {
			System.out.println("검색할 제조사명을 입력하세요.");
			search = sc.nextLine();
			
			Boolean res = false;
			for(int i=0; i<list.size(); i++) { 
				if(search.equals(list.get(i).getCompany())) {
					res = true;
				}
			}
			if(res == true) {
				System.out.println("'"+search+"' 에는 다음과 같은 음료가 있습니다.");
				searchCR(search);
			}else {
				System.out.println("해당 제조사가 없습니다.");
			}
			System.out.println("enter key를 누르면 관리자 메인화면으로 돌아갑니다.");
			sc.nextLine();			
		}
		
		//관리자모드 1.검색 - 제조사 - 결과
		public void searchCR(String search) {
			conn = connDB();
			//SELECT * FROM ksg_drink_tbl WHERE company = 'LOTTE';
			String sql = "SELECT * FROM ksg_drink_tbl WHERE company = ?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, search);
				rs = ps.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt("NO") + "." 
										+ rs.getString("NAME") + " : " 
										+ rs.getInt("price") + "(재고: " + rs.getInt("CNT") + ")");
				}
			}catch (Exception e) {
				System.out.println("통신체크 에러");
				e.printStackTrace();
			}finally {
				dbClose();
			}
		}
		
		
		//NO칼럼의 최댓값 알아오기
		public int maxNo() {
			conn = connDB();
			String sql = "SELECT MAX(NO)+" + 1 + " FROM KSG_DRINK_TBL";
			int maxNo = 0;
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					maxNo = rs.getInt("MAX(NO)+1");
					//System.out.println(maxNo);
				}
			}catch(Exception e) {
				System.out.println("통신체크 에러");
				e.printStackTrace();
			}finally {
				dbClose();
			}return maxNo;
		}
		
		//관리자모드 2.추가
		public int insert(int max_num) {
			conn = connDB();
			String sql = "INSERT INTO KSG_DRINK_TBL VALUES(?, ?, ?, ?, ?)";
			
			System.out.println("음료명을 입력하세요.");
			String name = sc.nextLine();
			int price = start("음료의 가격을 입력하세요.");			
			System.out.println("제조사를 입력하세요.");
			String company = sc.nextLine();
			int cnt = start("음료의 수량을 입력하세요.");
			
			DTO dto = new DTO(max_num, name, price, company, cnt);
			int a  = 0;
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, dto.getNo());
				ps.setString(2, dto.getName());
				ps.setInt(3, dto.getPrice());				
				ps.setString(4, dto.getCompany());
				ps.setInt(5, dto.getCnt());
				a = ps.executeUpdate();
				if(a==1) {
					System.out.println("추가 성공");
				}else {
					System.out.println("다시 시도하세요.");
				}
			}catch (Exception e) {
				System.out.println("통신체크 에러");
				e.printStackTrace();
			}finally {
				dbClose();
			}
			return a;
		}
		
		//관리자모드 3.삭제
		public void delete(int delMenu) {
			conn = connDB();
			String sql = "DELETE FROM KSG_DRINK_TBL WHERE NO=" + delMenu;
			int a = 0;
			try {
				ps = conn.prepareStatement(sql);
				a = ps.executeUpdate();
				if(a==1) {
					System.out.println("삭제 성공");
				}
			}catch (Exception e) {
				System.out.println("통신체크 에러");
				e.printStackTrace();
			}finally {
				dbClose();
			}
		}
		
		//삭제 후 음료 번호 바꾸기
		public void resetNum(int delMenu) {
			conn = connDB();
			//UPDATE DRINK SETO NO=NO-1 WHERE NO>?
			String sql = "UPDATE KSG_DRINK_TBL SET NO = NO-1 WHERE NO>?";
			int a=0;
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, 1);
				ps.setInt(2, delMenu);
				a = ps.executeUpdate();
				if(a==1) {
					System.out.println("번호 변경 성공");
				}			
			}catch (Exception e) {
				System.out.println("통신체크 에러");
				e.printStackTrace();
			}finally {
				dbClose();
			}
		}
		
		//관리자모드 4.재고 수정
		public void updateCnt(int upMenu) {			
			conn = connDB();			
			String sql = "UPDATE KSG_DRINK_TBL SET CNT = ? WHERE NO = ?";
			int cnt = start("새로운 수량을 입력하세요.");
			int a  = 0;
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, cnt);
				ps.setInt(2, upMenu);
				a = ps.executeUpdate();
				if(a==1) {
					System.out.println("재고 수정 성공");
				}
			}catch (Exception e) {
				System.out.println("통신체크 에러");
				e.printStackTrace();
			}finally {
				dbClose();
			}
		}
}
