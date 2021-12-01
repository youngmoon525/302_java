package pack01._interface;
//Interface의 상속은 implements 라는 키워드를 통해서 한다.
//Interface를 상속받게되면 Interface 멤버에 있는 메소드들을 강제로 구현하게 된다.
public class Interface_Main implements TestInterface{
	CDAO dao = new CDAO();
	@Override
	public void serach() {
		//ADAO.serach();
		dao.serach();
	}

	@Override
	public void insert() {
		//BDAO.insert();
		dao.insert();
	}

	@Override
	public void delete() {
		//CDAO.delete();
		dao.delete();
	}

}
