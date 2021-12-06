package pack02._outputstream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ex04_OutputStreamWriter {
	public static void main(String[] args) throws IOException {
		//OutputStream os = ;
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		//↑ 한줄로 줄여보기. 
		String str = "문자열을 출력 \n 줄바꿈을 넣어봤다.";
		osw.write(str);
		osw.flush();
		//↑ syso의 기본구조와 유사함.
	}
}
