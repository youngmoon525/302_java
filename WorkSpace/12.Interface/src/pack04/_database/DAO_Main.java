package pack04._database;

public class DAO_Main {
	public static void main(String[] args) {
		//MssqlDAO dao = new MssqlDAO();
		//dao.select();
		//dao.update();
		//다형성 ? 클래스나 인터페이스가 그 형태를 바꿔서 다른 객체가 들어갈수있는 ..
		//implements 또는 extends
		MssqlDAO dao = new MssqlDAO();
		dbWork(dao);
		OracleDAO dao2 = new OracleDAO();
		dbWork(dao2);
		DataAccessObject ddd = new OracleDAO();//
		//Interface를 implements받은 객체들은 다시 Interface를 생성할수있는 객체가 된다.
		//CRUD기능을 정의 해놓은 Interface는 해당하는 Interface를 상속받은 객체를 
		//넣어서 초기화가 가능하다. (Interface를 상속받게 되면 무조건 Interface에 있는
		//기능들을 구현해야 하기 때문이다. )
	}
	
	public static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.update();
		dao.delete();
		dao.insert();
		//dao.test1();
	}
	
	
}
