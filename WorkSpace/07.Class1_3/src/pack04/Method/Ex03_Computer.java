package pack04.Method;

public class Ex03_Computer {
	//컴퓨터가 연산처리를 하는것처럼 보이게끔 메소드를 만들 예정.
	public int sum1(int[] values) {
		//배열의 누적합을 구해서 main메소드로 반환(return)
		// [ 1 ] [ 2 ] [ 3 ] [ 4 ] [ 5 ] ? 
		//   0     1     2     3     4    총크기 - 1
		// A = (기존수 + 새로운수)기 + 새로운 수
		int result = 0;
		for(int i = 0 ; i < values.length; i++) {
			result = result + values[i];
			//result += values[i];
		}
		
		return result;
	}
}
