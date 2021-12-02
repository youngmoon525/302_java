package pack04._database;
//Oracle Database를 이용하는경우 기능을 구현한다.

public class OracleDAO implements DataAccessObject{

	@Override
	public void select() {
		System.out.println("Oracle을 이용해서 조회를 합니다.");
	}

	@Override
	public void insert() {
		System.out.println("Oracle을 이용해서 추가를 합니다.");	
	}

	@Override
	public void update() {
		System.out.println("Oracle을 이용해서 수정을 합니다.");
	}

	@Override
	public void delete() {
		System.out.println("Oracle을 이용해서 삭제를 합니다.");
	}

}
