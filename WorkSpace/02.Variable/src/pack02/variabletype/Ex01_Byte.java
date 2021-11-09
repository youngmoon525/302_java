package pack02.variabletype;

public class Ex01_Byte {
	public static void main(String[] args) {
		//byte <= 
		//bit 8개로 구성되어있는 자료구조.
		//bit 0또는 1만 정보를 표현할수있는 단위
		//최대값 127 , 최소값 -128 ;
		//알아두기만 하면 됨 사용빈도가 매우낮음
		byte var1 = 100;
		System.out.println(var1);
		byte var2 = 127;
		System.out.println(var2);
		byte var3 = 128;//byte라는 데이터타입의
						//표현할수있는 범위를 넘어섰기때문.
		byte var4 = -129;
	}
}
