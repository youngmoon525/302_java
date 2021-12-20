package pack04_.OpenAPI;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;

public class OpenGO {
	public static void main(String[] args) {
		//1.Url의 구조 ( ip / context(was) / mapping
		//https://api.odcloud.kr/api/3082925/v1/uddi:eeb6164d-1dd7-4382-8a96-a6888185864a
		//2.Url을 요청할때 필요한 값 ↓ (Method의 Parameter , 인수,인자값)
		//?page=1
		//&perPage=10
		//&serviceKey=C%2Bs6aUnodQBsE9joWNITkbdNay8YjJkk%2BbBPEHHuPr63PvQcSd3PIPeYiH3aKgyOYMJQzI0RSm%2BLpIISoE03Sg%3D%3D
		//3.Json 형태로 받아서 사용하기. (정보 제공을 xml 또는 json ,csv)=공공데이터포털
		//Json은 key와 value 가 중괄호 블럭으로 { , } 안에서 표현이 되고 ==DTO ,
		// 대괄호 [ , ]는 하나의 리스트라고 생각을 하면된다. == ArrayList , List
		String url = "https://api.odcloud.kr/api/3082925/v1/uddi:eeb6164d-1dd7-4382-8a96-a6888185864a";
		//요청할 url주소 ( ?기준으로 왼쪽에 있는 부분까지가 요청하는 주소)
		//javaCode에서 web주소로 요청을 보내고 받기위한 처리 , ex)www.naver.com > enter key (요청)
		try {
			
		String doc = Jsoup.connect(url).data("page" , "1").data("perPage" , "10")
		.data("serviceKey","C+s6aUnodQBsE9joWNITkbdNay8YjJkk+bBPEHHuPr63PvQcSd3PIPeYiH3aKgyOYMJQzI0RSm+LpIISoE03Sg==")
		.timeout(4000).userAgent("Chrome").ignoreContentType(true)
		.execute().body();
		System.out.println(doc);
		JSONParser jsonParser = new JSONParser();//String => JsonObject로 바꾸기위한 객체
		JSONObject jsonObj = (JSONObject) jsonParser.parse(doc);
		//[] <= ArrayList , List , Collection 구조
		//obj.get(list) => JsonArray  
		JSONArray jarr = (JSONArray) jsonObj.get("data");
		for (int i = 0; i < jarr.size(); i++) {
			//{ } == dto , [] == ArrayList
			//ArrayList<DTO> list = new ArrayList<>();
			//list <= for문 , list.get(i) == DTO.field ;<<<?
			JSONObject obj =  (JSONObject) jarr.get(i);//?
			//key값을 이용해서 데이터를 뺴는것 ( json 의 기초이자 핵심 ) 
			//key값은 대소문자와 공백을 구분을 해줘야된다. ※ key != ke y
			System.out.println(obj.get("상 호"));
			System.out.println(obj.get("비고"));
			
			//추후 시간이 남는다면..
			//1.json의 모든 obj내용을 받을수있는 DTO를 만듬.
			//2.DTO를 이용해서 모든 내용을 출력.
			
			
			
			
			
			
			
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
