package pack01._inputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex05_InputBuffer {
	public static void main(String[] args) throws IOException {
		//키보드에서 여러 글자를 입력받아서 출력 => 버퍼(buffer)를 활용
		//bufferReader vs inputStremReader
		//실제 처리를 inputStreamReader(Scanner)는 한글자씩(byte , int )
		//입력한 글자수만큼 접근이 이루어짐 , ▶ 메모리 소모 ↑ + 속도 저하의 원인 , 버그가 많음
		//이러한 비효율성을 개선해서 여러글자를 입력하더라도
		//buffer라는 공간에 입력을 해놓고 한번에 출력할수있는 처리를 지원한다.
		//buffer의 크기 (기본) : 1024byte = byte[] buffer = new byte[1024]
		//readLine();메소드를 사용해서 한번에 처리가 가능하다.(enter Key)
		//InputStream in = System.in;
		//InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg = br.readLine();
		System.out.println(msg);
		br.close();
		//BufferedReader br = new BufferedReader(); 한줄만 있어도 br이 생성되게 바꾸기.
		
		
	}
}
