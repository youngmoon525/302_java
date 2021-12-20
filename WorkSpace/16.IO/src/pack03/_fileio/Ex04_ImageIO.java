package pack03._fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex04_ImageIO {
	public static void main(String[] args) throws IOException {
		//파일 ( 그림 , 음원 , 영상 ) 에서 바이트 단위로 입출력하는 스트림
		//FileInput , FileOutput Stream
		//이미지를 읽어서 출력하는 프로그램 : Copy & Paste //원본을 복사하고 사본을 만드는 행위
		//원본의 이미지파일은 iofolder
		File fi = new File("D:\\Study_Java\\WorkSpace\\iofolder\\image2.jpg");//실제 현재 이미지가 있는 경로 (파일 마우스오른쪽클릭 ->속성->보안 탭)
		//1.원본 파일이 있는지 여부를 체크한다.
		//2.원본파일을 이용해서 만들 사본파일이 저장될경로를 지정을 미리 해둔다.
		File fo = new File("D:\\Study_Java\\WorkSpace\\iofolder\\image3.jpg");//실제 현재 이미지가 있는 경로 (파일 마우스오른쪽클릭 ->속성->보안 탭)
		if(fi.exists()) {
			FileInputStream fis = new FileInputStream(fi);
			//원본 파일을 자바소스에서 가져와서 byte단위로 접근할수있음.
			FileOutputStream fos = new FileOutputStream(fo);
			
			int data , cnt = 0 ; //<-픽셀 단위를 얻어오고 몇번에 접근을 하는지 확인하기위한 변수
			while( ( data = fis.read() ) != -1  ) {
				cnt ++ ;
				System.out.println(data);// 현재 읽어온 픽셀값 ( ???)
				fos.write(data);// 현재 읽어온 픽셀값을 차곡차곡 누적을시킴 (그림파일의 기초)
			}
			
			fos.flush();
			fos.close();
			fis.close();
			System.out.println(cnt);
			
			
			
			
			
			
		}else {
			System.out.println("경로에 접근할수없음 (보안 또는 파일없음)");
		}
	}
}
