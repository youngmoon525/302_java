package pack04.typechange;

public class Ex02_CastStringInt {
	public static void main(String[] args) {
		//String 클래스를 이용하여 문자 10(str1) , 20(str2)
		String str1 = "10";
		String str2 = "20";
		System.out.println(str1+str2);
		//결합,연결 (Concatenation) 
		//html <p>태그 안에있던 10과 20의 값을 더하고싶다.
		//int num1 =(int) str1;//일반적인 강제형변환으로는 불가능
		//Class규칙(첫글자가 대문자로 시작하는것(관례))
		//String이라는 클래스를 숫자형 데이터로 바꿀때는 
		//Wrapper Class라는것을 사용한다.
		//int num1 = str1;// 10 , "10" <- 쌍따옴표를 제거해야만한다.
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		double num3 = Double.parseDouble(str1);
		System.out.println(num1+num2+num3);
		//문자열 데이터 "" => 숫자형 데이터 int로 바꾸기
		//숫자형데이터 (어떤데이터든) 뒤에 문자열 표시인 ""더해주면
		//무조건 문자열이 된다.
		str1 = num1+"";//
		System.out.println("문자열" + (num1 + num2));
		//String에 어떤값을 + 하면 무조건 연결을 시킨다(=String)
		//따로 연산결과를 받고싶은 항이있다면 그 항을 소괄호로 싸준다.
	}
}
