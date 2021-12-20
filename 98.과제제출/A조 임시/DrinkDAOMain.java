package pack01._interface;

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
		dao.display(DrinkDTO[] dtos);
	}

	@Override
	public int calc(DrinkDTO[] dtos, int money) {
		// TODO Auto-generated method stub
		return dao.calc(DrinkDTO[] dtos, int money);
	}

	@Override
	public void showChanges(int change) {
		// TODO Auto-generated method stub
		dao.showChanges(int change);
	}

}
