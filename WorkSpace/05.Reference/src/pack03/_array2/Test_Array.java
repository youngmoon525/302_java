package pack03._array2;

import java.util.Arrays;

public class Test_Array {
	public static void main(String[] args) {
		//1.다음과 같이 1차원 배열을 요소로 가지는 2차원 배열 
		//완성하세요.(비정방형 2차원 배열임)
		//0 [0]
		//1 [0] [0]
		//2 [0] [0] [0]
		//3 [0] [0] [0] [0]
		//4 [0] [0] [0] [0] [0]
		//10
		int[][] arr1 = new int[10][];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = new int[i+1];
			System.out.println(Arrays.toString(arr1[i]));
		}
		
		
		//2. 1과같은 형태의 2차원 배열을 String형태로 만든다.
		//0 ["1"]
		//1 ["1"] ["2"] 각각의 1차원 배열에는  1~배열의 크기만큼의 숫자를 할당한다.
		//
		//for문을 통해 2차원배열 안의 값이 홀수면 "ODD"
		//						   짝수면 "EVEN"으로 바꾸는 로직을 완성하시오.
		String[][] arr2 = new String[10][];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = new String[i+1];
			
			for (int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = (j+1) + "";
			}
			System.out.println(Arrays.toString(arr2[i]));
		}
		
		for(int i = 0 ;  i<arr2.length; i++) {
			for(int j = 0 ; j<arr2[i].length; j++) {
				//"1" % 2 .. ???
				if( Integer.parseInt( arr2[i][j]) % 2 == 0  ) {
					arr2[i][j] = "even";
				}else {
					arr2[i][j] = "odd";
				}
			}
			System.out.println(Arrays.toString(arr2[i]));
		}
		
		
	}
}
