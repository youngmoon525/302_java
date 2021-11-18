package pack02_TryCatch;

public class Ex03_TryCatchOrder {
	public static void main(String[] args) {
		// 지금은 공부를 따로 할 필요가 없다. (자동완성을 이용하면 됨)
		try {
			int[] arr = new int[3];
			arr[5] = 10;
		}catch (NumberFormatException e) {
			System.out.println("숫자 잘못 바꿨을때 오류 처리");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndex");
		}catch (Exception e) {
			System.out.println("Exception");
		}//Exception<-최상위기때문에 맨 밑에 붙여준다. if에서 else
	
	}
}
