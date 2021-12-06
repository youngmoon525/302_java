package pack01._inputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex03_InputKor {
	public static void main(String[] args) throws IOException {
		//InputStreamReader : 문자 데이터(uni code ) 를 입력받는 스트림 
		//InputStream : 바이트데이터 : ascii , 이미지 , 영상 , 음원 등등을 입력받음.
		//InputStream is = System.in;
		//InputStreamReader isr = new InputStreamReader(is);
		//↑ 한줄에서 생성되게 해보기 InputStreamReader ??
		InputStreamReader isr = new InputStreamReader(System.in);
		int data = isr.read();
		System.out.println("입력하신 글자는 Int :" + data);
		System.out.println("입력하신 글자는 변환해서 : " + (char)data + "입니다");
	}
}
