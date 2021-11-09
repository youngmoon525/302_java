package pack03.etc;

import java.util.Scanner;
//java.util<-package위치에서 Scanner라는 클래스를 가지고와서
//사용할수있게하는 구문.
public class Ex02_Scanner {
	public static void main(String[] args) {
		// 콘솔에 어떤값을 입력받아서 입력받은 값을 변수에 담아서
		//사용하기 위한 Class(자바에서 제공해줌)
		//스캐너의 사용준비  (스캐너의 초기화식) ↑
		Scanner sc = new Scanner(System.in);
		String inputData = sc.nextLine();
		//sc.nextLine()이라는 구문이 있는줄을 만나게 되면
		//프로그램은 block state라는 상태의 대기상태에 접어든다.
		//사용자가 콘솔창에 어떤값을 입력하고 마지막에 enter key를
		//치기까지를 대기한다.
		System.out.println(inputData);
	}
}
