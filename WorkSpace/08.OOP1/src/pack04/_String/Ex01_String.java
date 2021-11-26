package pack04._String;

public class Ex01_String {
	public static void main(String[] args) {
		String str = new String("s:t:r객체");
		String[] strs = new String[3];
		System.out.println( str.length() );//문자열의 길이.
		//ex) 몇글자 이상의 데이터를 입력 받아야 할때.
		System.out.println( str.startsWith("s"));
		System.out.println( str.startsWith("m"));
		//어떤 글자로 시작하는지 boolean 
		System.out.println( str.indexOf('r'));
		//내가 찾는 글자가 몇번 인덱스에 있는지 체크 
		System.out.println( str.replace('s', 'z' ));
		//내가 원하는 문자를 찾아서 바꾸기.
		strs = str.split(":");
		System.out.println(strs[0]);
		//원하는 구분자를 통해서 문자열을 나눌때 사용 (배열로 리턴을 받음)
		System.out.println("subString =" + str.substring(1, 3));
		System.out.println(str.toUpperCase());//대문자로 변환
		System.out.println(str.toLowerCase());//소문자로 변환
		System.out.println(str.trim());//공백을 제거
		//String도 객체이기 때문에 멤버를 가지고있다 ↑
		//값 비교 eqauls!<=
	}
}
