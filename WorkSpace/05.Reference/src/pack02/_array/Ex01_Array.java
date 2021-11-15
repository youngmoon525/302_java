package pack02._array;

public class Ex01_Array {
	public static void main(String[] args) {
		//배열 : 자료형 변수를 생성하고 사용할때 주로 사용하며
		// '동일한' 자료형(데이터타입)을 정해진 수만큼 저장 처리하는 '객체'
		//배열의 규칙 : ↑ 데이터타입을 선언하고 묶는다 []<-대괄호 표시로.(배열의선언)
		//ex)크기가 5개짜리 배열을 만들었으면 index라는 주소를 가지는데.
		//index는 0부터시작해서 5(n) - 1 까지인 4까지 총 5개의 index(주소)를 가짐
		//int [숫자] [숫자] [숫자] [숫자] [숫자] : n개의크기를 가진 배열 n-1
		//		0     1     2     3     4
		//int[] intArr ;      <-배열의 선언식
		//데이터타입[] 배열의이름 ;
		int a ;
		int[] intArr ; //1.선언 
		intArr = new int[4];//2.배열의 크기를 할당
		//[I@7852e922{ [30] [40] [50] [60]
		// 			    0     1   2   3  }
		System.out.println(intArr);//[I@7852e922 힙영역 어드레스 주소
								   //우리가 필요 없는값
		//3.배열의 값을 할당
		intArr[0] = 30;
		intArr[1] = 40;
		intArr[2] = 50;
		intArr[3] = 60;

		//for문과 같이 사용했을때 모든 index에 접근하기가 매우 용이하다.
		System.out.println(intArr.length);
		//for문을 이용해서 intArr에 있는 모든 값을 출력하는 프로그램을 작성하세요.
		for(int i = 0 ; i < intArr.length ; i++) {
			System.out.println(intArr[i]);
		}
		//int형 데이터타입을 묶어놓은 배열 array를 만든다.
		//크기는 총 10개를 할당. 10 - 1 = 0~9
		//배열에 값을 for문을 이용해서 1~10까지 각각의 인덱스에 할당한다. - O
		//for문을 이용해서 전체 배열의 내용을 출력하는 프로그램을 작성하세요.
		//※ 인덱스에 값을 할당하는 for문 따로 배열에 값을 출력하는 for문 따로 작성.
		int[] array = new int[10];//배열의 초기화식(선언과동시에 크기할당)
		for(int i=0 ; i<array.length; i++) {
			array[i] = (i+1);
			//int형 변수 == array[i] ;
		}
		for(int i=0 ; i<array.length; i++) {
			System.out.println(array[i]); 
		}
		
	}
}
