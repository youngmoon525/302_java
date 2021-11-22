package pack03.Constructor;

public class Ex01_KoreanMain {
	public static void main(String[] args) {
		Ex01_Korean ek = new Ex01_Korean();
		//String n = "kym";
		Ex01_Korean ek2 = new Ex01_Korean("abfab");//?
		
		Ex01_Korean ek3 = new Ex01_Korean("n", "s");
		Ex01_Korean ek4 = new Ex01_Korean(1 , 2);
		
		Ex01_Korean ek5 = new Ex01_Korean("자신의이름", "생년월일");
		//ek5에있는 field를 전부 출력해보기.
		System.out.println(ek5.nation);
		System.out.println(ek5.name);
		System.out.println(ek5.ssn);
		//int[] arr <- 정수형 데이터만 묶어놓을수있음
		//String[] str <- 문자열 데이터만 묶어놓을수있음
		if(ek5.nation.equals("대한민국")) {
			System.out.println("한국 사람입니다,");
		}else {
			System.out.println("한국사람이 아닙니다.");
		}
		
	}
}
