package pack04._while;

public class Test_forWhile {
	public static void main(String[] args) {
		//문제 1 ) for문 또는 while문을 이용하여
		//1~100까지의 누적합을 구하는 프로그램을 작성하시오.
		//※ 단, 출력은 누적합을 모두 구하고나서 딱 한번만 한다.
		//ex)loop를 100번해도 출력문은 콘솔에 딱 하나만 찍힘.
		//※누적을 시키고싶으면(반복문) 반복문 밖에 변수를 만들어야한다.
		int sum = 0;
		int j = 0;
		while(j<=100) {
			sum = sum + j;
			j++;
		}
		System.out.println("while로 누적합 : " + sum);
		sum = 0;
		for(int i = 0 ; i<=100; i++) {
			sum = sum + i;
			//sum += i;
		}
		System.out.println("0~100까지의 누적합 : "+sum);
		//문제2 ) for문과 while문을 하나씩사용해서 중첩한다
		//ex)for문안에 while , while문 안에 for문을 넣음.
		//2~9단까지 출력하는 프로그램을 작성하세요.
		int x = 2 ;
		while(x <= 9) {
			System.out.println(x);
			for(int i = 1; i<=9; i++) {
				System.out.println( x + " * " + i + " = " + (x*i));
			}
			x++;
		}
		
		
		//for문 안에  while을 두는 경우.
		for(int i = 2 ; i<=9 ; i++) {
			System.out.println(i);
			int y = 1;
			while(y <= 9 ) {
				System.out.println(i + " * " + y + " = " + (i*y));
				y++;
			}
		}
		
		
	}
}
