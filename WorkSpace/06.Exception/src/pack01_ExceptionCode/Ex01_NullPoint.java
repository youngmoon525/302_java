package pack01_ExceptionCode;

public class Ex01_NullPoint {
	public static void main(String[] args) {
		// null <- 아직 객체(String,Scanner,Random)가 사용할 준비가 되어있지않은
		// 즉 , 초기화가 되어있지 않은 상태 (비어있는 상태,참조가 없는 상태)
		//에서 어떤 기능(메소드)을 사용하게 되면 나오는 에러(빈번하게 발생하므로 알아두면 좋다)
		
		//String str1 = "a" , str2 = "a" 
		//1.str1과str2가 참조가 같은지의 비교?
		//2.str1과str2가 값이 같은지 비교.?
		String str1 = "a" , str2 = "a";
		String str3 = null;
		//↑ 참조형 데이터 타입 
		if(str1 == str2) {
			System.out.println("참조가 같습니다.");
		}else {
			System.out.println("참조가 다름");
		}
		
		if(str1.equals(str2)) {
			System.out.println("값이 같습니다.");
		}else {
			System.out.println("값이 다릅니다.");
		}
		//NullPointerException
		//객체가 null상태로 아직 참조가 없는 상태에서 나오는 에러 
		//객체를 new 또는 값을 할당해서 null상태가 아니게 만들면 해결되는 문제
		//str1.equals == String.equals
		//str3.equals == null.equals ↓
		//null을 회피하는 방법 
		//제어문 : 선택문(if)사용 
		if(str3 != null) {
			if(str3.equals(str1)) {
			System.out.println("값이 같습니다.");
			}
		}
	}
}
