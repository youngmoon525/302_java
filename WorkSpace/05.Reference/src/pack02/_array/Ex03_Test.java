package pack02._array;

public class Ex03_Test {
	public static void main(String[] args) {
		//1차원 배열은 요소로 데이터타입에 해당하는 데이터를 가진다.
		
		//1. 구구단의 2단 결과를 모두 가질수있는 int형 배열을 자유롭게 만드시고
		//배열에 2단 결과를 모두 담고 출력하시오.
		int[] arr = new int[9];
		for (int i = 0; i < arr.length; i++) {
			System.out.println( (i+1) * 2 );
			arr[i] = (i+1) * 2;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		//2. for문을 이용하여 별찍기 .
		//if , for , for중첩 , while 
		//	★ <- 를 담을수있는 배열을 만드시고 각각의 인덱스에 아래에 해당하는 데이터를
		//담고 출력하는 프로그램을 작성하시오.
		//첫번째 : ★     => String , char x<-문자 하나
		//두번째 : ★★
		//세번째 : ★★★
		//네번째 : ★★★★
		//마지막 : ★★★★★
		String[] starArr = new String[5];
		//[0] [0] [0]....[0]
		//[null] [null]
		//for과 if문만 사용하는 경우 , for문을 중첩 x
		for (int i = 0; i < starArr.length; i++) {
			if(i==0) {
				starArr[i] = "★";
			}else {
				starArr[i] = starArr[i-1] + "★";
			}
		}
		for (int i = 0; i < starArr.length; i++) {
			System.out.println(starArr[i]);
		}
		
		for (int i = 1; i < starArr.length+1; i++) {
			String star = "" ;
			for (int j = 0; j < i; j++) {
				star += "☆";
			}
			starArr[i-1] = star;
			System.out.println(star);
		}
		
		
	}
}
