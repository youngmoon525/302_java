package pack06._game;

import java.util.Random;
import java.util.Scanner;

public class Ex01_HighLowGame {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int comNumber = r.nextInt(100)+1  ;
		int userNumber = 0;
		//
		//랜덤클래스를 이용해서 1~100까지의 랜덤한수를 만듬.-O
		//유저는 랜덤한수를 입력해서 어떤 수인지 맞추는 게임.
		//userNumber = sc.nextLine();=>Parsing 
		//유저가 입력한 수가 랜덤한 수보다 크다면 더작은수를 입력하게끔 유도.
		//유저가 입력한 수가 랜덤한 수보다 작다면 더큰수를 입력하게끔 유도.
		//두수가 일치한다면 게임이 종료된다. <-break;
		//==두수가 일치하지 않는다면 게임은 계속 된다.
		while(true) {//<-유저가 어느정도의 시도횟수를 사용할지를
					//모르기때문에 무한반복을 만듬
					//유저가 입력한수 == comNumber
					//break;
					//String inputData = sc.nextLine();
			userNumber = Integer.parseInt(sc.nextLine());
			System.out.println("사용자가 입력한값 : "+userNumber);
			if(userNumber == comNumber) {
				System.out.println("정답입니다.");
				break;
			}else if(userNumber > comNumber) {
				System.out.println("더작은수를 입력해주세요.");
			}else if(userNumber < comNumber) {
				System.out.println("더큰수를 입력해주세요.");
			}
			
		}
		
		//r.nextInt를 하게되면 0~99 +1 1~100
		//클래스명 개발자가 사용할 이름 = new 클래스명();
		//Random클래스는 클래스를 이용해서 개발자가 원하는 숫자범위내에서
		//랜덤한 수를 반환하는 기능을 가졌다.
	}
}
