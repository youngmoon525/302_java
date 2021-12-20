package pack001;

public class DDrinkDAO {
	
	public void showChanges(int change) {
			System.out.println("천원 :" + change / 1000 + "개 " + " 오백원 :" + (change % 1000) / 500 + "개 " + " 백원 :" + (change % 1000 % 500) / 100 + "개");	
	}	
}
