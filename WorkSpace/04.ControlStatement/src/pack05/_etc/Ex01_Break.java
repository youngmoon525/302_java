package pack05._etc;

public class Ex01_Break {
	public static void main(String[] args) {
		// break; 문장을 종료시키는 기능을 담당한다.
		// 상위 하나의 지역(반복문)을 끝낸다
		// for(){
		// for(){<-↓이반복문을 종료한다. 상위 반복문은 계속해서 진행함.
		// break;
		// }
		// }
		int i = 0;
		while (true) {
			i++;
			System.out.println(i);
			for (int j = 0; j < 10; j++) {
			//ctrl + shift + f <-줄정리 
				if (i == 999) {
					break;
				}
			}
			if (i == 999) {
				break;
			}
		}
	}
}
