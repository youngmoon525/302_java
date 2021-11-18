package pack02_TryCatch;

public class Ex02_TryCatchFinally {
	public static void main(String[] args) {
		//가스불을 킨다=> 요리시작 => 요리끝 => 가스불을 잠근다 => 요리 종료
		//손에 화상이 입거나 아님 다른 어떤 사정이 생겼을때 무조건 해야하는것
		//=>가스불을 잠근다 =>요리종료
		try {
			System.out.println("가스불을 킨다.");
			System.out.println("요리 시작~");
			//int a = 5 / 0 ;//?
			System.out.println("요리 끝");
			//System.out.println("가스불을 잠근다");
			//System.out.println("요리종료");
		}catch (Exception e) {
			System.out.println("예외 발생");
			//System.out.println("catch :가스불을 잠근다.");
			//System.out.println("catch :요리 종료");
		}finally {
			//무조건 실행되어야 하는 코드를 위치시키면 됨
			System.out.println("가스불을 잠근다");
			System.out.println("요리종료");
			//DB에 연결함 , 어떤 작업을 함 , 오류가 발생함 , 발생안함
			//finally => DB와 연결을 해제함
		}
	}
}
