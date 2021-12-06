package pack01._inputStream;

import java.io.IOException;
import java.io.InputStream;

public class Ex02_InputMulti {
	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		System.out.println("영문자 여러글자를 입력해주세요.");
		//반복문. ( 여러글자 =? 아직 뚜렷한 작업 횟수가 정해지지 않음 , for < while )
		int data ;
		while( (data = is.read())  != -1  ) {
			System.out.println("입력하신 문자 int : " + data);
			System.out.println("입력하신 영문자는 " + (char)data + "입니다.");
		}
		System.out.println("종료되었습니다.");
	}
}
