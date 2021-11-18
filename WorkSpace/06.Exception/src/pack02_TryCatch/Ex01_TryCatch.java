package pack02_TryCatch;

public class Ex01_TryCatch {
	public static void main(String[] args) {
		int[] arr = new int[3];//3개의 크기를 가지는 배열을 생성
		//오류가 날것같은 코드를 개발자에 경험에 의해 try라는 블럭과 catch라는 블럭을
		//이용해서 예외처리를 할수가있다.↓(예외 발생 가능성이 있는 코드)
		try {
			//예외 발생 가능성이 있는 코드 위치
			arr[0] = 10;
			arr[1] = 20;
			arr[2] = 30;
			arr[3] = 40;//<= 3이라는 인덱스는 없음 ( 총크기 3 : 3-1 )
		}catch(Exception e) {
			//↑아직은 무엇을 의미하는지 모름.
			//예외가 실제로 발생하게 되면 실행되는 코드 위치
			System.out.println("배열 인덱스에 잘못 된 접근을 하셨습니다.");
		}
		
		//NumberFormatException을 강제로 만들기.
		//문자열 => 숫자
		//try{ }catch(Exception e){ }<-이용해서 예외처리 해보기 
		try {
			Integer.parseInt("nbn");
		}catch (Exception e) {
			System.out.println("숫자로 바꿀수 없는값");
		}
		
	}
}
