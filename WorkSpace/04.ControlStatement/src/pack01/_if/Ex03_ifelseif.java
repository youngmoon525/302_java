package pack01._if;

public class Ex03_ifelseif {
	public static void main(String[] args) {
		//if (조건식1) { } else if (조건식2) { } .....else{ }
		// 조건식 1이 true이면 실행 조건식2가 true이면 실행 ....
		// 모든 조건식이
		// false이면 else블럭을 실행한다.
		int score = 87; 
		if(score >= 90) {
			System.out.println("A학점 입니다.");
		}else if(score >= 80) {
			System.out.println("B학점 입니다.");
		}else if(score >= 70) {
			System.out.println("C학점 입니다.");
		}else if(score >= 60) {
			System.out.println("D학점 입니다.");
		}else if(score >= 50) {
			System.out.println("E학점 입니다.");
		}else {
			System.out.println("F학점 입니다.");
		}
		//else if를 더 사용해서 70이상이면 C 60이상 D 50이상 E
		//그 외에는 F학점이 되는 프로그램을 작성하세요.
		//if 와 else if 블럭으로 조건을 주게 되면.
		//하나의 조건이라도 만족하게 되면 나머지 else if블럭들을
		//실행을 안하기 때문에(비교) 메모리를 더 효율적으로 사용할수있다.
		if(score >= 70) {
			System.out.println("C학점 입니다.");
		}else if(score >= 60) {
			System.out.println("D학점 입니다.");
		}else if(score >= 50) {
			System.out.println("E학점 입니다.");
		}
	}
}
