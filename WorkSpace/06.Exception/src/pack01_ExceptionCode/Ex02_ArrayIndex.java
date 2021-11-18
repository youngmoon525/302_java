package pack01_ExceptionCode;

public class Ex02_ArrayIndex {
	public static void main(String[] args) {
		// 배열의 인덱스를 초과했습니다. (에러를 일부러 만들어 보기)
		//배열을 만들게 되면 주소부(인덱스) 0~ N-1까지 가 생김
		//N-1을 넘어선 인덱스부를 사용하게 되면 에러가 발생함 
		//ex) new int[3];<-배열에 크기 3을 할당 (index: 0~n-1(2) 0,1,2)
		//arr[3] <- 3이라는 인덱스는 존재 하지않음.
		int[] arr = new int[3];
		arr[10] = 10; 
		// java.lang.ArrayIndexOutOfBoundsException: 10
		//↑해당하는 오류(인덱스)는 :<-기준으로 숫자가 나오는데 해당하는 숫자에
		//인덱스가 없다고 알려주기때문에 금방 인지가 가능하다.
	}
}
