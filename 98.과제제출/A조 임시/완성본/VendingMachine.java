package pack01.A조;

public class VendingMachine {
	public static void main(String[] args) {
		DrinkDAOMain dao = new DrinkDAOMain();
		DrinkDTO[] dtos = new DrinkDTO[4];
		dtos[0] = new DrinkDTO("솔의 눈", 1200, 20);
		dtos[1] = new DrinkDTO("ZICO", 3300, 33);
		dtos[2] = new DrinkDTO("2프로", 700, 15);
		dtos[3] = new DrinkDTO("데자와", 2400, 49);
		int money = 0;
		
		money = dao.inputPrice();
		dao.display(dtos);
		dao.showChanges(dao.calc(dtos, money));
		
	}
}
