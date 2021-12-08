package pack01._ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex02_DAO {

	private Connection conn ; //null
	private PreparedStatement ps; //null
	private ResultSet rs ; //null
	//return Type void = > Connection 
	//연결이 필요하다면 항상 호출해서 사용할수있는 메소드로 만든다. 
	public Connection getConn() {

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hanul";
		String password = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}//getConn
	
	public void dbClose() {
		// 1.연결=>2.전송=>3.결과
		// 3.결과비움=>2.전송객체x=>1.연결x 역순으로 닫음.비움
		try {
			//nullpointerException<= null에서 어떤 기능을 사용할때 빈번하게 발생
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
			//이메소드를 호출했을때 에러가 발생할까?  안할까?
			//발생한다면 어떤식으로 회피할수있을까?ㅇ
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//getConn();메소드를 호출해서 Connection 객체를 초기화 하고,
	//conn=> ps(전송)초기화 => 전송
	public void connTest() {
		//전송시 필요한것 (sql문) == String , <xml> myBatis API
		conn = getConn();//DB접속이 가능하게 Connection객체를 초기화 시킴.
		String sql = " select 1 from dual ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();//executeQuery는 메소드이기때문에 메소드 블럭이끝나면 그결과가 사라짐.
			while(rs.next()) {
				int data = rs.getInt("1");
				System.out.println(data);
			}
			
		} catch (Exception e) {
			System.out.println("Conntest 에러()");
			e.printStackTrace();
		}finally {
			dbClose();//※※※※<- Close를 안시켜주면 DB에 동시에 접근이 가능한 회선수(세션수)
					  //가 한정이 되어있기때문에 꼭 닫아준다.
		}
		
	}//<- conn , ps , rs DAO클래스가 인스턴스화 되어있는 동안.
	
	
	public void selectBoard() {
		// conn->ps->rs
		//String sql = " select * from board " ; 
	}
	
	
	
	
}
