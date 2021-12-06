package pack01._inputStream;

import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04_InputKorMulti {
	public static void main(String[] args) throws IOException {
		// 문자열을 읽어오기 위한 (한글) InputStream => InputStreamReader
		String inputData = kymScanner();
		System.out.println(inputData);
		// 1. return 을 받는 메소드로 형태를 바꿈(정의)
		// 2. 입력한 데이터중에 CR&LF는 입력을 받으면 안된다. (13 , 10?)
		// 3. 입력한 데이터를 하나의 문자열로 만들고 return을 해주면된다.
	}

	public static String kymScanner() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		System.out.println("한글 여러글자를 입력해주세요.");
		int data;
		String rtnString = "";
		while (   (data = isr.read()) != -1) {
			if (data == 13 || data == 10) {
				break;
			}
				rtnString += (char) data + "";
			
			// System.out.println(data);
			// System.out.println("입력하신 글자 : " + (char)data);
		}
		return rtnString;
	}
}
