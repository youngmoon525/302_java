package pack01._if;

public class Ex03_ifelse {
	public static void main(String[] args) {
		//기본적인 if문 if(조건식){ if지역 true일때 실행됨 }
		//else문<- if의 블럭킹 끝}에 붙어서만 사용이 가능하다.
		//if(조건식){
			//if지역 
			//true일때 실행되는 부분
		//}else {
			//else지역 조건식이 false일때 실행되는 부분
		//}
		int score = 80;
		// > , < 초과 또는 미만을 뜻(그수보다 큼 , 작음)
		// >= , <= 이상 또는 이하 (그수와 같거나 큼,작음)
		if(score >= 90) {
			System.out.println("A학점" + score);
		}else {
			//false일때 , 조건식을 만족하지 못한경우 실행되는 부분.
			System.out.println("A학점이 아닙니다." + score);
		}
		
		//score가 홀수인지 짝수인지를 if else문으로 판단해서
		//콘솔창에 홀수,짝수를 출력하는 프로그램을 완성해주세요.
		
		
	}
}
