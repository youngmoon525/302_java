package pack06._game;

import java.util.Random;
import java.util.Scanner;

public class Ex02_DiceGame {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//Random r = new Random();
		//1.이 프로그램은 무한반복하는 프로그램 입니다.
		//콘솔창(1.게임시작 , -1.게임종료)
		//2.1번을 누르면 게임을 시작하고 -1을 입력하면 게임을 종료한다.
		//enter Key를 누르면!
		//컴퓨터가 주사위를 굴립니다. r.nextInt(6)+1;
		//enter Key를 누르면!		
		//사용자가 주사위를 굴립니다. r.nextInt(6)+1;
		//눈금이 더 높은 팀이 이기는 게임입니다.
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		while(true) {
			System.out.println("1.게임시작 , -1.게임종료 ▶입력");
			int userMenu = Integer.parseInt(sc.nextLine());
			if(userMenu == -1) {
				System.out.println("게임 종료");
				break;
			}else if(userMenu == 1) {
				System.out.println("주사위 게임을 시작합니다.");
				System.out.println("컴퓨터가 주사위를 굴립니다.");
				System.out.println("Enter Key를 눌러주세요.");
				sc.nextLine();//콘솔창에 입력된값을 enter key를 누르면
							  //String 형식으로 반환한다.
				int comNumber = r.nextInt(6)+1;//0~5 x : 1~6
				System.out.println("컴퓨터가 굴린 주사위 : " + comNumber);
				System.out.println("사용자가 주사위를 굴립니다.");
				System.out.println("Enter Key를 눌러주세요.");
				sc.nextLine();
				int userNumber = r.nextInt(6)+1;
				System.out.println("사용자가 굴린 주사위 : " + userNumber);
				if(comNumber == userNumber) {
					System.out.println("무승부 입니다.");
				}else if(comNumber < userNumber) {
					System.out.println("사용자의 승리");
				}else if(comNumber > userNumber) {
					System.out.println("컴퓨터의 승리");
				}else {
					System.out.println("에러입니다.");
				}
				System.out.println("다시 게임 시작화면으로 이동합니다.");
			}else {
				System.out.println("잘못된입력입니다.");
				continue;
			}
			
		}
		
		
		
	}
}
