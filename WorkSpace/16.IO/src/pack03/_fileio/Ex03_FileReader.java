package pack03._fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex03_FileReader {
	public static void main(String[] args) throws IOException {
		//Stream ( I , O )
		//실제로 있는 경로를 넣어줘야함 
		File f = new File("D:\\Study_Java\\WorkSpace\\iofolder\\ex02_file.txt");
		if(f.exists()) {
			Reader reader = new FileReader(f);
			BufferedReader br = new BufferedReader(reader);//한줄로 바꾸기 연습.
			String str = "";
			while(true) {
				str = br.readLine();
				if(str == null) {
					br.close();
					break;
				}
				System.out.println(str);
			}
			
			
		}else {
			System.out.println("경로가 없습니다 또는 권한부족!");
		}
	
		//1.조금 불편한 방법
		//char[] buffer = new char[1000];//return을 각각의 글씨를 
		//int readCharNum = reader.read(buffer);
//		if(readCharNum != 1) {
//			for (int i = 0; i < buffer.length; i++) {
//				System.out.println(buffer[i]);
//			}
//		}
		
		
		
		
		
	}
}
