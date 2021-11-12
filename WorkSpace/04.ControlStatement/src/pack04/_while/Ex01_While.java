package pack04._while;

public class Ex01_While {
	public static void main(String[] args) {
		//while <- 조건 정해진 횟수를 잘 모를때 사용빈도가 높다.
		//ex)구구단의경우 몇단까지 출력할지 알고있다=>for문
		//ex)어떤 데이터의 집합을 가지고왔는데 몇개 들어있는지를 모를경우=>while
			//단순하게 무한반복하는 프로그램을 만들고 싶을때
		//1~10까지 출력하는 for
		//for(1.int i = 1 ; i<=10 ; i ++) {  }
		//↓while로 변경해보기.
		//while(조건식){
			//조건식이 true일동안 반복하는 코딩.
		//}
		int i = 1;
		while(i < 10) {
			//↑ 무한반복을 의미하는 while 
			System.out.println(i);
			i ++ ;
		}
		//i는 이미 위에 while문에서 10까지 증가를 했기때문에
		//아래 while문은 10부터 작업을 진행하게된다.
		//20번의 작업을 하고싶으면 i를 0으로 초기화를 해줘야한다.
		while (i < 20) {
			System.out.println("두번째While"+i);
			i++;
		}
		System.out.println("===============");
		//for문을 이용해서 구구단중에 2단을 출력을 했었다.
		//이번에는 while문을 이용해서 2단을 출력하는 프로그램을 작성하세요.
		i = 1;
		while(i < 10) {
			System.out.println(" 2  * " + i + " = " + (i*2));
			i++;
		}
		
		
		
	}
}
