package pack03._fileio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_FileWriter {
	public static void main(String[] args) throws IOException {
		//자바소스 => 경로에 실제 있는 파일로 쓰기 
		//※ 실제 현장에서는 DB가 오류날 경우를 대비해서 txt , csv로 로그를 항상 남긴다. (중요한 프로그램)
	
		Writer writer = new FileWriter("D:\\Study_Java\\WorkSpace\\iofolder\\ex02_file.txt");
		//복습 , str에 구구단을 누적시킨다.  \t <-탭만큼 띄어쓰기를 함 \n 줄바꿈을함
		// 2 * 1 = 2 , 2 * 2 = 4 , 2 * 3 = 6 .... 2* 9 = 18
		// 3
		// 4/
		String str = "";
		for (int i = 2; i < 10 ; i++) {
			for (int j = 1; j < 10; j++) {
				str = i + " * " + j + " = " + (i*j) + " ";
				
				writer.write(str);
			}
			writer.write("\r");
		}
		
		// 9 
		//↓
		
		writer.flush();//뿌린다.(강제)
		writer.close();//닫는다.
		
		
		
		
	}
}
