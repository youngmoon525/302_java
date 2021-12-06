package pack03._fileio;

import java.io.File;

public class Ex01_exists {
	public static void main(String[] args) {
		//Eclipse에서 바로 파일을 접근하면 권한이 부족해서 파일을 바로 못여는 경우가 빈번하다.
		//input type="file" 
		//파일쪽에서 에러가 안나려면 (예외처리) 항상 물리적으로 파일이 존재하는지를
		//먼저 체크를 해야한다.  ex) d:/study_java/workspace 있음? 없음?
		//그전에 , 경로가 존재하는지의 여부를 판단을 해야한다. 
		//File을 객체로 초기화 하는 식은 String으로 실제 경로를 파라메터로 넘겨서 생성하는 방법이
		//가장 많이 사용된다.
		String path = "D:\\Study_Java\\WorkSpace\\iofolder"; //파일의 경로를 담을 그릇
		//경로를 복사해서 붙여넣기를 하면 escape문자가 자동으로 들어감(IDE)
		File f = new File(path);//경로를 넘겨서 File객체를 인스턴스화 (초기화함)
		if(f.exists()) {
			System.out.println("경로가 존재 합니다 . 파일 업로드 시작!!!");
		}else {
			System.out.println("경로가 존재 하지 않습니다. 파일 다시확인. error");
		}
	}
}
