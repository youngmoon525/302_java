package pack01.login;

//DTO: 상태정보 (속성)을 가지고 있다면,
//DAO: 기능 (메소드)를 모아놓는 역할을 한다.
//(Data Access Object)
public class LoginDAO {
	// 대부분의 DAO는 따로 Field(변수)를 가지지 않음.
	//메소드들만. 가짐.
	//rtnInt()<- rtnStr() , login()<-
	//메소드의 파라메터 부 또는 return Type 부
	// 어떤것이든 올수있다.
	//static , static x
	public boolean login(LoginDTO dto) { // field ?
		if(dto.id.equals("admin") && dto.pw.equals("admin123") ) {
			System.out.println("로그인 완료");
			return true;
		}else {
			System.out.println("아이디 비밀번호를 다시 확인하세요.");
		}
		return false;
	}
}
