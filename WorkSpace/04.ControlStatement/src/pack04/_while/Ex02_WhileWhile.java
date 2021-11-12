package pack04._while;

public class Ex02_WhileWhile {
	public static void main(String[] args) {
		for (int i = 0 ; i< 10 ; i++){
			for(int j = 0 ; j < 10 ; j++){
				System.out.println(i + " : " + j);
			}
		}
		int i = 0;
		while ( i < 10) {
			//System.out.println(i);
			int j = 0 ;
			while(j < 10) {
				if(j%2 == 1) {
					int result = 0;
					System.out.println("w"+ i + " : " + j);
				}//if<- result라는 변수는 } 메모리에서 사라지기때문에
				//if 지역 밖에서는 접근이 불가능하다.
				result = 1;
				j++;
			}
			i++;
		}
		//   while문을 '중첩'시켜서 위와 같은 결과를 출력하는
		//   프로그램을 작성하시오.
		//   for문으로 완성된 로직 => while문으로 완성시키기.
	}
}
