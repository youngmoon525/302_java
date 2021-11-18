package pack03._array2;

import java.util.Arrays;

public class Ex04_Swap {
	public static void main(String[] args) {
		int a = 10; 
		int b = 20;
		System.out.println("교환전 a " + a + "교환전 b" + b);
		int temp = a;
		a = b;
		b = temp;
		//a , b , temp ?
		// a=b , b=a;  |b| || |a| 
		//			   |b| || |a| 
		System.out.println("교환후a " + a + "교환후 b" + b);
		
		int[] arr = { 3 , 5 ,7 , 9 , 1 , 2 , 4 , 10};
		// swap이라는 개념을 이용해서 1차원 배열에 들어있는 int값들을
		// 오름 차순으로 정렬 하는 프로그램을 작성하세요.
		// 어떤 식으로 해도 상관은 없습니다. 
		// 
		//{ 3 , 5 ,7 , 9 , 1 , 2 , 4 , 10};
		int[] arrm = { 3,4,6,7,8,9,1,2,5};
		for (int i = 0; i < arrm.length; i++) {
			for (int j = i+1; j < arrm.length+2; j++) {
				if(arrm[i] > arrm[j]) {
					int tmp = arrm[i];
					arrm[i] = arrm[j];
					arrm[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arrm));
		
		
		
	}
}
