package pack01.A조;

public interface IDrinkDAO {
	int inputPrice();				// 창재형
	void display(DrinkDTO[] dtos);	// 종효
	int calc(DrinkDTO[] dtos, int money); 					// 영민이형
	void showChanges(int change); 	// 준영이형
}