package pack02._outputstream;

import java.io.IOException;
import java.io.OutputStream;

public class Ex03_OutputMulti {
	public static void main(String[] args) throws IOException {
		OutputStream os = System.out;
		char a = 'a';
		char b = 'b';
		char c = 'c'; //buffer라는 저장공간에 계속해서 쌓아두면 된다.
		
		os.write(a);
		os.write(b);
		os.write(c);
		os.flush();
		//출력 해보기 abc 
		// os.close();
		
		
	}
}
