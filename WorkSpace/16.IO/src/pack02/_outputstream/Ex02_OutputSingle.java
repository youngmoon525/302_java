package pack02._outputstream;

import java.io.IOException;
import java.io.OutputStream;

public class Ex02_OutputSingle {
	public static void main(String[] args) {
		//System.out == Outputstream 
		OutputStream os = System.out;
		
		try {
			os.write(97);//outputStream buffer라는 데이터 저장공간(개념) 데이터를 쌓아둠.
			os.flush();//<= 출력 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
