
public class Ex08_Bool3 {
	public static void main(String[] args) {
		// ? true : false <-한가지 조건만 비교함(bool2)
		// 중요도가 낮기때문에 bool2까지만 알면된다.
		int score = 45 ; //점수가 되는 변수 95
		//다항 연산자 'A' , 'B'   
		//항이 여러개 일때는 제어문 if문을 사용하는것이 더 편리하고
		//가독성이 좋기때문에 사용빈도가 낮다. 
		//60보다크면 D , 50보다크면 E , 나머지는 F가 되게
		//다항 연산자를 수정하시오.(테스트는 socre 값을 바꿔가면서 테스트)
		char grade = (score > 90) ? 'A':
					 (score > 80) ? 'B':
				     (score > 70) ? 'C' :
				     (score > 60) ? 'D':
				     (score > 50) ? 'E':'F';
		System.out.println("나의 학점은 : " + grade);
	}
}
