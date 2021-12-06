package pack01._inputStream;

import java.util.Scanner;

public class Test_KymScannerMain {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//KymScanner ksc = new KymScanner(System.in);
		//↑문자열을 입력받아서 String을 넘겨주는 기능은 BufferReader가 담당함.Scanner = X
		//String inputData = ksc.nextLine();
		//syso( inputData ) ;  
		//콘솔에 " 내가 만든 스캐너입니다. " 치고 입력. 콘솔에 출력됨 1
		Test_KymScanner ksc = new Test_KymScanner(System.in);
		String inputData = ksc.nextLine();
		System.out.println(inputData);
		ksc.close();
	}
}
