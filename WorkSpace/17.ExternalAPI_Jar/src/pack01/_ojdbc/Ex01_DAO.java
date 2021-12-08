package pack01._ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex01_DAO {
//Data Access Ojbect 
//Java Database Connectivity ( oracle , mysql , mariadb , mssql .. )
//Java <=> DB 연결하는 방법.
// 1.Connection 이라는 연결 객체 .  (통로를 만듬)
// 2.PreparedStatement 전송 객체 . ↑(통로를 통해서 sql질의어를 전송을 함 DB 그결과도 통로를 통해서 받아옴)
// 3.ResultSet 				 (전송된 결과를 받아오기위한 객체 )
// 연결을함=>전송을함=>전송이정상적이면 결과를받아옴=>결과를받아온것을 결과객체에 담음
//   1===>  2============================> 3
	private Connection conn ; //연결 , Interface 객체 , Connection을 선언만 해둠
	private PreparedStatement ps; //전송 , 선언만 해둠
	private ResultSet rs ; //결과 , 전송객체로부터 받음.
	
	public void getConn() {
		//연결객체가 초기화 되기 위해서는 여러가지 정보와 Driver가 필요함.
		//url <= 접속 하려는 데이터베이스의 아이피나 버전정보등
		//username <= hr(교육용 계정) , hanul(우리가만든계정) , 계정의 이름이 필요함
		//password <= ↑ 비밀번호
		
		//String url = "jdbc:oracle:thin@localhost:1521:xe";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hanul";
		String password = "0000";
		//oracle.jdbc.driver.OracleDriver <= Class형태로 동적으로 로딩을함.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			//정확한 정보와 Driver가 넘어갔다면 정상적으로 커넥션이 된 상태가 됨. 
			if(conn.isClosed()) {
				System.out.println("연결안됨");
			}else {
				System.out.println("연결됨");
			}
			//나중에 메소드 별로 Connection만 초기화하고 , Connection => Ps전송객체를 초기화하고
			//각각의 기능을 수행하도록 나눌거임.
			String sql = " select 1 from dual ";//<=Database에 전송할 질의어(sql문)
			try {
				
			ps = conn.prepareStatement(sql);//전송객체 초기화(연결객체)
			rs = ps.executeQuery();//실행 => rs(결과객체)
			while(rs.next()) {//Iterator 
				// rs.get으로 받음 
				//getString => 파라메터로 String : "컬럼의 이름" ★★★★★
				//getString => 파라메터로 int를  : 컬럼의 순서 ★ ↑위에것이 오류가 안나고 정확함.
				String data = rs.getString(1);
				System.out.println(data);
			}
			
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("쿼리 실행 에러.");
			}
			
			
			conn.close();
			if(conn.isClosed()) {
				System.out.println("닫힘");
			}else {
				System.out.println("열림??에러");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	
	
}
