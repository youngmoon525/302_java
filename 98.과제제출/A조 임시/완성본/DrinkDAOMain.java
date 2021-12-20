package pack01.A조;

public class DrinkDAOMain implements IDrinkDAO {
	ADrinkDAO dao = new ADrinkDAO();

	@Override
	public int inputPrice() {
		// TODO Auto-generated method stub
		return dao.inputPrice();
	}

	@Override
	public void display(DrinkDTO[] dtos) {
		// TODO Auto-generated method stub
		dao.display(dtos);
	}

	@Override
	public int calc(DrinkDTO[] dtos, int money) {
		// TODO Auto-generated method stub
		return dao.calc(dtos, money);
	}

	@Override
	public void showChanges(int change) {
		// TODO Auto-generated method stub
		dao.showChanges(change);
	}
	
}
