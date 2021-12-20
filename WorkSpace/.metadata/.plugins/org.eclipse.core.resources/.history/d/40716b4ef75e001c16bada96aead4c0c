package pack03_.commonsemail;

import java.net.URL;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class EmailSend {
	public static void main(String[] args) {
		EmailSend es = new EmailSend();
		es.sendESimple();
	}
	public void htmlMail() {
		HtmlEmail mail = new HtmlEmail();
		mail.setHostName("smtp.naver.com");//naver 서버를 통하기 때문에 naver에서 지정해놓은 smtp서버를 넣어주면됨.
		mail.setCharset("UTF-8");//한글 깨짐을 방지<=Encoding
		mail.setDebug(true);//디버깅을 허용
		
		mail.setAuthentication("네이버 아이디", "네이버 비밀번호");
		mail.setSSLOnConnect(true);//인증을 ↑ 하기위해 필요함.
		try {
			//메일을 보내는 사람 , 받는사람 , 메일의 제목 , 메일의 내용.
			mail.setFrom("나의 이메일아이디 @ naver.com" , "상대방 이메일에 표시 될 이름");
			mail.addTo("상대방의 이메일 아이디@naver.com" , "상대방 이름");//받는사람이 여러명이면addto가여러번
			mail.addTo("youngmoon525@naver.com" , "테스트");
			StringBuffer msg = new StringBuffer();//버퍼에 데이터를 쭉 넣어놓고
												 //사용을할때 msg.toString();
			msg.append("<html>");
			msg.append("<body>");
			msg.append("<a href='http://www.naver.com'> 네이버로 바로가기 </a>");
			msg.append("<hr>");
			msg.append("<h2> 한울 K-digital 입교 환영 이메일 입니다. </h2>");
			msg.append("<p> 대충 축하하는 내용 . 취업 잘하시고 . 화이팅입니다. </p>");
			msg.append("</body>");
			msg.append("</html>");
			mail.setSubject("회원가입 축하 메세지");
			mail.setMsg(msg.toString());
			// ~ 5:40 제일 디자인 잘하신분 1분 기프티콘 
			EmailAttachment file = new EmailAttachment();
			file.setPath("D:\\Study_Java\\WorkSpace\\iofolder\\image1.jpg");
			mail.attach(file);
			
			file = new EmailAttachment();
			URL url = new URL("http://www.imageclick.com/imgs/main_intro.jpg");
			file.setURL(url);
			mail.attach(file);
			mail.send();//<= send를 해줘야지 실제 mail이 보내지는 처리가 됨.
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//파일첨부까지 가능한 이메일 , url , 이미지파일 \\16.IO 폴더 여기에있는 이미지사용.<-자바에서 사용하기때문에
	//오류날 가능성이 있음, 오류가 난다면 제거하고 url만 테스트하면됨.
	public void attachMail() {
		//파일 첨부(파일) MultiPart <= 여러부분으로 나누어져있는 데이터 //form Multipart/en..?
		MultiPartEmail mail = new MultiPartEmail();
		mail.setHostName("smtp.naver.com");//naver 서버를 통하기 때문에 naver에서 지정해놓은 smtp서버를 넣어주면됨.
		mail.setCharset("UTF-8");//한글 깨짐을 방지<=Encoding
		mail.setDebug(true);//디버깅을 허용
		
		mail.setAuthentication("네이버 아이디", "네이버 비밀번호");
		mail.setSSLOnConnect(true);//인증을 ↑ 하기위해 필요함.
		try {
			//메일을 보내는 사람 , 받는사람 , 메일의 제목 , 메일의 내용.
			mail.setFrom("나의 이메일아이디 @ naver.com" , "상대방 이메일에 표시 될 이름");
			mail.addTo("상대방의 이메일 아이디@naver.com" , "상대방 이름");//받는사람이 여러명이면addto가여러번
			mail.addTo("youngmoon525@naver.com" , "테스트");
			
			mail.setSubject("회원가입 축하 메세지");
			mail.setMsg("회원가입을 진심으로 축하합니다.");
			//
			EmailAttachment file = new EmailAttachment();
			file.setPath("D:\\Study_Java\\WorkSpace\\iofolder\\image1.jpg");
			mail.attach(file);
			
			file = new EmailAttachment();
			URL url = new URL("http://www.imageclick.com/imgs/main_intro.jpg");
			file.setURL(url);
			mail.attach(file);
			mail.send();//<= send를 해줘야지 실제 mail이 보내지는 처리가 됨.
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	//Email , SimpleEmail 글자만 전송하는경우 ,  AttachEmail 파일을 추가한경우
	//HtmlMail Html태그가 사용이 된 경우.
	public void sendESimple() {
		SimpleEmail mail = new SimpleEmail();//<=파라메터를 입력받는 생성자 메소드가 없음
		mail.setHostName("smtp.naver.com");//naver 서버를 통하기 때문에 naver에서 지정해놓은 smtp서버를 넣어주면됨.
		mail.setCharset("UTF-8");//한글 깨짐을 방지<=Encoding
		mail.setDebug(true);//디버깅을 허용
		
		mail.setAuthentication("네이버 아이디", "네이버 비밀번호");
		mail.setSSLOnConnect(true);//인증을 ↑ 하기위해 필요함.
		//여기까지는 이메일 전송을 위해서 (초기화) 필요한 부분 대부분 고정되서 사용함.
		
		try {
			//메일을 보내는 사람 , 받는사람 , 메일의 제목 , 메일의 내용.
			mail.setFrom("나의 이메일아이디 @ naver.com" , "상대방 이메일에 표시 될 이름");
			mail.addTo("상대방의 이메일 아이디@naver.com" , "상대방 이름");//받는사람이 여러명이면addto가여러번
			mail.addTo("youngmoon525@naver.com" , "테스트");
			
			mail.setSubject("회원가입 축하 메세지");
			mail.setMsg("회원가입을 진심으로 축하합니다.");
			
			mail.send();//<= send를 해줘야지 실제 mail이 보내지는 처리가 됨.
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
