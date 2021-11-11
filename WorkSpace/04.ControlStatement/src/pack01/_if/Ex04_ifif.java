package pack01._if;

public class Ex04_ifif {
	public static void main(String[] args) {
		//제어문들은 중첩이 가능하다.<-
		//중첩: if문 블럭킹 내부에 또 if문을 사용할수있다.
		//if(조건식1){ 
			//if(조건식2){
				//if(조건식3){
				//변수 선언<- 
				//}//변수 사라짐
			//}
		//}
		int score = 70;
		//if문이 3개가있다. 
		//1.공통으로 사용할수 있는 변수를 어디에 만들면 될까?
			int result1 = 100; 
		//2.두번쨰 if문에서부터만 사용할수있는 변수는 어디에 만들면될까?
			//int result2 = 100;
		if(score < 100) {
			System.out.println(result2);
			System.out.println(result1);
			System.out.println("첫번째 if문 실행됨");
			if(score < 90) {
				int result2 = 100;
				System.out.println(result1);
				System.out.println("두번째 if문 실행됨");
				if(score < 80) {
					result2 = 100;
					System.out.println(result1);
					System.out.println("세번쨰 if문 실행됨");
				}//if 3
			}// if 2
		}//if 1
	}
}
