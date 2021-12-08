package pack01._ojdbc;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex01_OjdbcMain {
	public static void main(String[] args) {
		// https://brunch.co.kr/@operator/65 <-API에 대한 쉬운 설명
		//API java에서도 미리 API를 제공을 하고있다 Jre System lib 안에 .jar파일 형태로.
		//Scanner , InputStream , OutputStream ..등등 우리가 직접 코딩하지않은 객체들을 제공을해준다.
		//API라는것은 미리 만들어놓은 기능을 우리가 용도에 맡게 사용하는 것. 
		//Oaracle <=> Java OjdbcAPI가 필요하다.
		//API를 다운받기위한 사이트 (API 모음 ) maven repository : https://mvnrepository.com/
		//프로젝트에 API를 추가하는 방법.
		//1.파일로 lib을 추가하는 방법
		//-1. 하드에 있는 물리적인 경로를 이용해서 추가하는 방법 : 프로젝트 마우스 오른쪽 클릭
		//=> build path = > configure build path => lib탭 => extenal jars. 파일추가
		//-2.프로젝트 내에 lib라는 폴더를 하나만들고 (이름은 크게 관계는 없으나 가독성이 좋다 )
		//add jars를 통해서 추가하는 방법 
		// 1  vs 2 : 2) 다른사람이 내 소스파일을 받아도 물리적인 경로에 있는 jar가아니기때문에 바로사용이가능
		//<=동적으로 Class로딩을해서 사용을 할것임.
//		Ex01_DAO dao = new Ex01_DAO();
//		dao.getConn();
		
//		Ex02_DAO dao = new Ex02_DAO(); // 메모리에 멤버가 없음(인스턴스화 과정이 필요함)
//		dao.getConn();	//null.getConn();
//		dao.dbClose();
		
		
		//나는 8글자 이상의 문자열이 필요함. sc.nextLine()은 String을 리턴함.
		// 그말은 sc.nextLine().length라는 메소드도 사용가능함 (문자열 길이 )
	
		Ex02_DAO dao = new Ex02_DAO();
		dao.connTest();
		
		
		
		
		
	}
}
