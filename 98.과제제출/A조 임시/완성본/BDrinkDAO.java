package pack01.A조;

public class BDrinkDAO extends CDrinkDAO {
	public void display(DrinkDTO[] dtos) {
		// programmer - 박종효
		for(int i = 0; i< dtos.length; i++) {	// 0번 인덱스부터 마지막(배열 길이의 -1)까지 참조한다.
			System.out.println(i + ". " + dtos[i].name + " | " + dtos[i].price + "원 | " + dtos[i].count + "개");
		}
	}
	
	// calc();
	
	// showChanges();
}
