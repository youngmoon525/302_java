package pack02._interface;

public class FruitMain implements IFruitInterface{
	CDAO dao = new CDAO();
	public static void main(String[] args) {
		FruitMain main = new FruitMain();
		FruitDTO[] dtos = main.initDtos();
		main.display(dtos);
		main.dispalyMax(dtos);
	}
	@Override
	public FruitDTO[] initDtos() {
		
		return  dao.initDtos();// FruitDTO[]
	}

	@Override
	public void display(FruitDTO[] dtos) {
		// TODO Auto-generated method stub
		dao.display(dtos);
		
	}

	@Override
	public void dispalyMax(FruitDTO[] dtos) {
		// TODO Auto-generated method stub
		dao.dispalyMax(dtos);
	}

}
