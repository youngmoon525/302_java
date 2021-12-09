package pack01._ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex02_DAO {
	// Java <-> Oracle Database 연동하기위해서 필요한 객체
	//Connection <- Database와 연결로(통로)를 만듬 
	//PreparedStateMent <- Connection을 통해서 만들어진 통로를 통해 전송을 담당함.(java->db , db->java)
	//ResultSet <- PreparedStateMent가 가지고온 결과를 담는 용도로 사용하는 객체 
	private Connection conn ; //연결객체 선언 null(Interface)
	private PreparedStatement ps;//전송객체 선언
	private ResultSet rs ; //결과객체 선언.
	
	//1.Connection이 정상적으로 열리는지를 확인. (isClosed)라는 메소드(boolean을 return하는 메소드)
	public Connection connDB() {
		//Connection을 하기위해서는 ojdbc8.jar(API) => (oracle.jdbc.driver.OracleDriver)
		//url(아이피,포트,오라클 버전정보) , user(계정이름 : hanul, hr) , password ( 0000)
		//String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hanul";//※ Employees ( 사원정보 테이블) => hr , hanul =>BOARD
		String password = "0000";//실무에서는 암호화를 통해 알아볼수없는값이 들어있음(보안)
		//동적 Driver를 로딩!. Class.forName(Driver.class);
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
	
	public void dbClose() {
		//1.연결 -> 2.전송 <->DB 3.전송->결과
		//3.결과닫음->전송닫고->연결.
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
			//NullpointerException , rs가 인스턴스화 되지 않은경우,ps,conn
			//null.close() ==X -> null을 회피하는 방법.(null이 아닌경우에만 기능(멤버)을 사용하면됨)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//초기 DB연결시에는 반드시 바로 실제 테이블에 접근해서 정보를 조회,수정,추가,삭제하는게아니라,
	//가상의 테이블인 dual을 이용해서 1값을 조회하고 1을 그대로 java에 가져오는지 체크를 먼저하는게 좋다.
	//통신체크 ( java->(1)->db(1)->java(1) )
	
	public void connTest(String data) {//() => String data를 입력받는 형태로 변경됨.
		conn = connDB();//Connection 객체를 초기화 시킴.
		String sql = " SELECT '" +  data + "' as col from dual  " ; //String + String = String
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);//연결객체를 통해서 전송객체가 이동하므로
											//항상 연결객체를 통해 전송객체는 초기화됨
			rs = ps.executeQuery(); // 데이터베이스에가서 sql문을 실행하고 그 결과를 가지고옴.(ResultSet)
			while(rs.next()) {//rs.next() 다음칸으로 이동을하고 그결과가 성공(true)
				 data = rs.getString("col");//파라메터 STR ="컬럼의 이름"
												//파라메터 INT = 컬럼의 순서
				System.out.println("db에서 가지고옴"+data);
				
			}
		}catch (Exception e) {
			System.out.println("통신체크 에러");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	
	
	public void connTest2(String data1 , String data2 , int data3) {//() => String data를 입력받는 형태로 변경됨.
		conn = connDB();//Connection 객체를 초기화 시킴.
		//파라메터를 여러개 보내개 되면 String형식이나 int형식이나 '<-홑따옴표처리가 들어가야하는지
		//안들어가야하는지 햇갈림(혼동이옴)
		// ?<-라는 파라메터 부를 만드는 방법. (전송객체에 파라메터를 넘겨주고 타입을 지정)
		String sql = " SELECT ? AS COL1, ? COL2 , ? AS COL3 FROM DUAL " ; //String + String = String
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);//연결객체를 통해서 전송객체가 이동하므로
											//항상 연결객체를 통해 전송객체는 초기화됨
			ps.setString(1, data1);//반드시 ps가 실행전에 파라메터를 추가해줘야함※
			ps.setInt(2, data3);
			ps.setString(3, data2);
			rs = ps.executeQuery(); // 데이터베이스에가서 sql문을 실행하고 그 결과를 가지고옴.(ResultSet)
			while(rs.next()) {//rs.next() 다음칸으로 이동을하고 그결과가 성공(true)
				 data1 = rs.getString("col1");//파라메터 STR ="컬럼의 이름"
				 data3 = rs.getInt("col2");	
				 data2 = rs.getString("col3");//파라메터 INT = 컬럼의 순서
				System.out.println("db에서 가지고옴"+data1 + data2 + data3);
				
			}
		}catch (Exception e) {
			System.out.println("통신체크 에러");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	
	public void selectBoard() {
		conn = connDB();
		// 테이블의 내용을 정렬해서 내가 필요한 순서가 있다면 Database에서 그순서를 만들어온다.
		String sql = " select * from board order by no desc " ;
		try {
			ps = conn.prepareStatement(sql); 
			rs = ps.executeQuery(); //ResultSet( 조회결과)
			while(rs.next()) {
				System.out.print(rs.getInt("no") + ".");
				System.out.print(rs.getString("title")+" ");
				System.out.println(rs.getString("content"));
			}
		}catch (Exception e) {
			System.out.println("게시판 글 조회 실패");
		}finally {
			dbClose();
		}
		
	}
	
	
	public ArrayList<Ex02_BoardDTO> selectBoardList() {
		conn = connDB();
		String sql = " select * from board order by no desc " ;
		ArrayList<Ex02_BoardDTO> list = new ArrayList<>();
		//선언만함 == null
		//선언을하고 new로 인스턴스화함  listCollection> [ ]
		try {
			ps = conn.prepareStatement(sql); 
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Ex02_BoardDTO(
						rs.getInt("no")
						, rs.getString("title")
						, rs.getString("content"))
						);
			}
		}catch (Exception e) {
			System.out.println("게시판 글 조회 실패");
		}finally {
			dbClose();
		}
		return list ;
		
	}

	public void display(ArrayList<Ex02_BoardDTO> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getNo()+".");
			System.out.print(list.get(i).getTitle()+" ");
			System.out.print(list.get(i).getContent()+" ");
			System.out.println();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
