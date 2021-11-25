package pack01.login;
// CLASS : DTO<- Data Transfer Object
// 실제 DATABASE에서 가지고 오는 값을 필드로 지정해놓고
// 자바에서 쓸수있게 만들어놓은 형태.
// Spring : VO <- Value Object - x아직몰라도됨
// JAVA(Param) -> DataBase(데이터를 조회함 결과를 return)
// -> JAVA(Database Data 받음): DTO로 받음
// 하나의 클래스에 변수(필드)와 메소드(기능)
//를 지금까지는 하나의 클래스에 했다면 앞으로는 
// DAO :<-기능(메소드) <-DTO에 관련된 기능
// DTO :<-상태정보(변수,필드)
public class LoginDTO {
	String id ;
	String pw ;
	public LoginDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	
	//반드시 LoginDTO를 생성할때 id,pw를 입력 받아야만
	//생성할수있는 생성자 메소드를 만드시오. new LoginDTO();-X
	//생성자 메소드 : 클래스와 같은 이름 형태를 가진 메소드 
	// new 생성자 메소드() ;
	
	
	
}
