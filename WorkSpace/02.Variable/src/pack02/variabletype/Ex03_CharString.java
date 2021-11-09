package pack02.variabletype;

public class Ex03_CharString {
	public static void main(String[] args) {
		//문자 , 문자열 
		//char , String<-첫글자가 대문자로 시작함 ?
		//문자 데이터타입 : char(2byte) ▶ 하나의 글자만 저장 : 유니코드
		//값을 할당(대입) 할때는 ' ' 싱글코테이션 홑따옴표로 싸준값을 넣어준다.
		//중요 : String <- 
		char a = 'a';
		System.out.println(a);
		char b = '가';
		System.out.println(b);
		//String : 문자 , 문자열 모두를 담을수있는 (클래스)
		//값을 할당(대입)할때는 "" 더블코테이션 쌍따옴표를 사용해서 
		//값을 싸주면 된다.
		//※ String "1" ? int 1
		String str1 = "ABCD";
		String str2 = "가나다라";
		System.out.println(str1 + str2);
		int x = 10 , y = 20;
		String str3 = "10" , str4 = "20";
		System.out.println(x+y);
		//숫자형 데이터의 + (합) = SUM
		System.out.println(str3 + str4);
		//문자열 데이터의 + (결합) "10" + "20"
		//					  "1020"	
		//문자열 데이터에 숫자값(합을 구하고싶은)이 있을때
		//Casting , Parsing <- 
	}
}
