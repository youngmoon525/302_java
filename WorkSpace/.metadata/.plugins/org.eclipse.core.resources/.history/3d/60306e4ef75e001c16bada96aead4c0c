package pack02_.coolsms;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SendMassage {
	public static void main(String[] args) {
		//API_KEY = ?
		//API_SECRET = ?
		final String API_KEY = "발급받은 API_KEY";
		final String API_SECRET = "발급받은 SECRET 지문모양누르면 나오는 KEY ";
		//Coolsms (유료) : 카카오톡 플러스친구(알림톡,가맹점,사업자정보가있어야함) , 기타등등 기능이많음
		//문자를 보내기 위해서는 CoolSMS서버를 이용을 해야함.
		//CoolSMS서버에서 요구하는 Param(인자값)을 보내주기만 하면 
		//문자전송을 CoolSMS가 알아서 처리를함. ※ HashMap형태로 되어있음. <= 키중복을 막아놓음.
		//===필요하다면 이미 구현 된 현재 소스를 응용해서 사용만하면되고 따로 공부할필요가 전혀없는.부분==/
		Message coolsms = new Message(API_KEY, API_SECRET);
		HashMap<String, String> params = new HashMap<>();
		params.put("to", "자신의번호");
		params.put("from", "자신의번호");
		params.put("type", "SMS");//type (SMS , LMS , MMS , AT ....돈차이가있음)
		params.put("text", "보낼 내용 . (문자 API 테스트 중 입니다. ");
		params.put("app_version", "JAVA SDK v1.2");
		//문자 객체를 API키를 넣어서 초기화시키고 문자를 실행하기전에 필요한 파라메터를 준비한 부분.
		try {
			JSONObject obj = coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}
}
