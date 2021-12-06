package pack01._inputStream;

import java.io.IOException;
import java.io.InputStream;

public class Ex01_SystemIn {
	//IO사용시 주의점.
	//프로그램의 외부에서 작업을 하는것이기때문에 '예외처리'가 반드시 필요한 부분이다.
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in); <-? InputStream , Keyboard에서 들어오는 정보
		//System.in <= Node Stream (노트 스트림 : 가장 먼저 연결되는 스트림 ,외부에서 들어오는 데이터를 받을수있는)
		int inData = System.in.read();
		System.out.println(inData);//한글자씩 inputream이 읽어오는 처리 10진수를 읽어온다.
		char cData = (char) inData;
		System.out.println(cData);//dec to ascii(사람이보는 글자)
		
		
		InputStream is = System.in; //System.in을 바로이용하는게 아니라 ,우리가 사용할 변수에 담아서 이용
		int inData2 = is.read();
		System.out.println(inData2);
		int inData3 = is.read();
		System.out.println(inData3);
		// Scanner sc.nextLine() =X , sc.nextInt() <= 메소드 사용시 나오는 에러
		//사용자가 어떤 글자를 입력을하고 (하나의글자만) enter Key를 입력하는 순간
		//프로그램을 종료하거나 다른 처리가 일어나는게 아니라 두가지 작업이 일어남.
		//CR(Carriage Return) : 커서를 줄의 맨앞으로 이동시킴 == 13
		//LF(Line Feed ) : 커서를 한 줄 아래로 이동 시킴 == 10
		
	}
}
