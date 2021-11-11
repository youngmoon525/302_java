package pack01._if;

public class Ex05_AndOr {
	public static void main(String[] args) {
		// true , false
		//   1  ,  0
		// && AND 연산자 논리곱 : 모든 조건을 만족해야만.
		//  1 * 0 = 0; FALSE ;
		// || OR  연산자 논리합 : 하나의 조건이라도 만족하면.
		//  1 + ? = 1; TRUE ;
		//여러 조건을 연결시킬때 사용함.
		// if( 조건1(TRUE) AND 또는 OR 조건2(FALSE) )
		int score = 80;
		//		true   OR    false
		//		  1     +      0    = ?
		if(score < 100 || score < 50) {
			System.out.println("OR조건 하나의 조건이라도 만족함");
		}
		//		true   AND  false
		//		  1     *    0  = ?
		if(score < 100 && score < 90) {
			System.out.println("AND조건을 모두 만족함");
		}else {
			System.out.println("AND조건을 모두 만족하지 못함");
		}
	}
}
