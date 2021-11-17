package pack03._array2;

public class Ex02_Array {
	public static void main(String[] args) {
		//정방형 2차원 배열 : 행에 들어있는 1차원 배열의 열의 갯수가 동일함.
		//비정방형2차원 배열 : 행에 들어있는 1차원 배열의 열의 갯수가 다름.
		// [ [0] [0]2			[0] 1
		//   [1] [1]2] <=정방형     [0][0][0] 3 <= 비정방형
		//1차원 배열 : int[] arr = { 1 , 2 , 3 };
		//2차원 배열 : int[][] arr = { {1차원배열 } , {1차원배열} };
		int[][] arr = {
				{1,2},//0번인덱스 , length : 2
				{3,4,5},//1번인덱스 , length :3 
				{6,7,8,9}, //2번인덱스 , length : 4
				{10,11,12,13,14} //3번인덱스 , length : 5
		};
		System.out.println("2차원 배열의 요소 갯수 : " + arr.length);//2차원 배열의 요소 갯수(1차원배열갯수)
		System.out.println("[0]1차원 배열의 요소 갯수 : " + arr[0].length);
		System.out.println("[1]1차원 배열의 요소 갯수 : " + arr[1].length);
		System.out.println("[2]1차원 배열의 요소 갯수 : " + arr[2].length);
		System.out.println("[3]1차원 배열의 요소 갯수 : " + arr[3].length);
		//for 문을 중첩시켜서 2차원 배열(비정방형) arr[][]의 내용을 출력해보기.
		//※ Arrays.toString() <= 사용금지.
		for(int i = 0 ; i < arr.length ; i++) {//2차원배열이 가지고있는 전체 
											 //1차원 배열의 갯수만큼 반복
			for(int j = 0 ; j< arr[i].length; j ++) {
				//1차원 배열(2차원 배열의 요소) 의 내용을 전체 출력 한다.
				System.out.println( i + "번째 1차원 배열 값 : " + (arr[i][j]));
			}
			
		}
	}
}
