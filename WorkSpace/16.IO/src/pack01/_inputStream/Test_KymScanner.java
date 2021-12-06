package pack01._inputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test_KymScanner {
	BufferedReader br ; // 버퍼리더를 이용해서 한줄씩 읽어와서 enter key <=
						//
	public Test_KymScanner(InputStream in) {
		br = new BufferedReader(new InputStreamReader(in));
		//Test_KymScanner를 사용할때는 항상 inputStream을 보내주고 ,
		//그리고나서는 기능만 사용할수있게 해준다.
	}
	public String nextLine(){
		
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void close()  {
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
