package pack03._array2;

import java.util.Arrays;

public class Ex01_Array {
	public static void main(String[] args) {
		// 1차원 배열 : 변수는 하나의 정보만 담아짐 String a = "A" ;..B = "B"
		// String이라는 타입을 하나로 묶어서 여러개의 정보를 담을수있는 자료구조.
		// 배열은 연관 된 정보들을 그룹핑
		// [0] [0] [0] [0] [0] <- int[] iArr = new int[5];
		// x또는 y축만 존재하는 단축 구조다.
		// 2차원 배열 : 1차원 배열을 요소로 가지는 형태
		// x와y축이 존재하는 행열 (행과열의 갯수가 일정할때 == 정방형 2차원 배열)
		// [ [0] [0] [0] , 0,0 , 0,1 0,2
		// [0] [0] [0] ,]1,0 , 1,1 1,2
		// [0] [0] [0] [0] <= 비정방형 2차원 배열.
		// DataBase의 Columns(열) , Rows(행)
		// ex)3차원 배열 <= 2차원 배열을 요소로 가지는 형태 4차원<=3차원배열요소...
		// 2차원 배열의 코딩 :
		// 데이터타입[][] 배열의이름 ; <-2차원 배열의 선언
		// 배열의 이름 = new 데이터타입[행][열]; <-2차원 배열의 크기할당
		// 행*열 = 2차원 배열의 크기(정방형)
		int[][] arr = new int[2][3];// 2행 3열을 가지는 2차원배열 (2*3=6)
		System.out.println("2차원 배열의 length : " + arr.length);
		// ↑ 2차원 배열이 요소로 가지고있는 1차원 배열의 갯수를 묻는 질문
		System.out.println("2차원 배열이 가지고있는 "// 1차원배열.length
				+ "1차원 배열의 크기: " + arr[1].length);
		System.out.println("2차원 배열이 가지고있는 값" + arr[0][0]);
		// 0 1 2
		// arr 0 [1] [2] [3]
		// // 0 1 2
		// 1 [4] [5] [6] ?
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[1][0] = 4;
		arr[1][1] = 5;
		arr[1][2] = 6;
		System.out.println(arr[0][0]);
		System.out.println(arr[0][1]);
		System.out.println(arr[0][2]);
		System.out.println(arr[1][0]);
		System.out.println(arr[1][1]);
		System.out.println(arr[1][2]);
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		//↑ 가급적 사용을 자제 ( 다른 언어에서는 지원하지 않는 기능 )
		//1차원 배열 => for문 1 전체 출력이 가능 ( 행 또는 열만 가지고 있기때문에 )
		//2차원 배열 => for문 2 전체 출력이 가능 ( 행 과 열을 모두 가지고 있기 때문에)
		for(int i = 0 ; i<arr.length; i++) {
			//System.out.println(i+1 + "번");
			for(int j = 0 ; j < arr[i].length; j++) {
								//↑ 2차원 배열안에는 1차원 배열이 n개 들어있다.
								// 2차원 배열안에있는 모든 1차원 배열에 접근해야만
								// 전체 출력을 하는것.
				System.out.println(arr[i][j]);
			}
		}
		// 총 N개의 데이터를 저장할수있는 2차원 배열을 만든다.
		// 구구단 2~9단까지의 결과를 모두 담으시면 됩니다.
		// [   [2단 ] , [3단]  , [4단] ....[9단]    ]
		int[][] guArr = new int[8][9];
 		for(int i = 0 ; i<guArr.length ; i++ ) {
 			for (int j = 0; j < guArr[i].length; j++) {
				guArr[i][j] = (i+2) * (j+1);
				// i(0) + 2 , 2 * 
				// j(0) + 1 , 2 * 1
			}
 			System.out.println(Arrays.toString(guArr[i]));
 		}
		
		
		
		
		
	}
}
