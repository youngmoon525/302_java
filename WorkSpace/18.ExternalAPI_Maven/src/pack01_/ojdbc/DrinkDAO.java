package pack01_.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DrinkDAO {
	Connection conn; // 1.연결객체
	PreparedStatement ps ; //2.전송
	ResultSet rs ; //3.전송객체가 전송을 한 후에 결과를 받아오기 위한 객체.
	
	public DrinkDTO checkDrink(int no) {
		//1.연결 2.전송 3.결과 ( select )
		DrinkDTO dto = null ;
		conn = getConn();
		try {
			ps = conn.prepareStatement(" SELECT * FROM DRINK WHERE NO = " + no);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new DrinkDTO(rs.getInt("no"), 
						rs.getString("name"), 
						rs.getInt("price"), rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return dto;
	}
	
	public void drinkdisplay() {
		conn = getConn(); // dbConn
		try {
			ps = conn.prepareStatement(" SELECT * FROM DRINK ");
			rs = ps.executeQuery();
			while(rs.next()) {
				
				System.out.print(rs.getInt("NO") + "\t");
				System.out.print(rs.getString("NAME")+ "\t");
				System.out.print(rs.getInt("PRICE")+ "\t");
				System.out.println(rs.getInt("CNT")+ "\t");
				//java.sql.SQLException: 내부 표기로 변환할 수 없습니다 : 데이터타입이 Strinig인데 int로 받은경우 나는 에러
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hanul";
		String password = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			//통신 확인 ( 전송 확인) 
//			ps = conn.prepareStatement(" SELECT 1 FROM DUAL ");
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				System.out.println(rs.getInt("1"));
//			}
		} catch (Exception e) {
			System.out.println("연결을 하다가 오류가남.");
		}
		return conn;
	}
	
	public void dbClose() {
		try {
			//if(rs != null) rs.close();
			//if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
