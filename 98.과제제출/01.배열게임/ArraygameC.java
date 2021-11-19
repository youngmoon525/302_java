package pack02._Array;

import java.util.Random;
import java.util.Scanner;

public class ArraygameC {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Random r = new Random();
		while(true) {
			System.out.println("----게임시작----");
			System.out.println("- 숫자를 입력해주세요 (0은 게임종료)");
			int level = Integer.parseInt(sc.nextLine());
			if(level==0) {
				System.out.println("게임종료");	
					break;
			}else {
				int arr[] = new int[level];
				int randNum = r.nextInt(level);
				arr[randNum] = 1;
				while(true) {
					System.out.println("1부터 " + level + "까지");
					System.out.println("숫자를 맞춰보세요 1이 어디에 있을까요?"); 
					int userNum = Integer.parseInt(sc.nextLine());
					if(randNum==(userNum-1)) {
						System.out.println("정답입니다");
						break;
					}else if(level<userNum) {
						System.out.println("숫자를 다시 입력해주세요");
					}
					else {
						System.out.println("오답입니다");
					}
				}
				
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
		}
		
	}
}
