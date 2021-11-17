package test;

import java.util.Random;
import java.util.Scanner;

public class TestA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 랜덤, 스캐너
		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		// 게임이 끝나지 않도록 무한반복
		while (true) {
			// 난이도 입력
			System.out.println("난이도를 입력해주세요\n -1을 입력시 게임종료");
			String inputData = sc.nextLine();
			int user = Integer.parseInt(inputData);
			// 1보다 작을 때 오류
			if(user == -1) {
				System.out.println("게임이 종료됩니다");
				break;
			}else if (user < 1) {
				System.out.println("오류입니다 재입력해주세요");
				continue;
			} else {
				// 1보다 크거나 같을 때 진행.
				int[] i = new int[user]; // 입력한 값 만큼의 크기를 가진 int 배열
				int y = r.nextInt(user); // 배열 안에 숨길 곳을 정하는 랜덤한 값

				i[y] = 1; // 숨겼다/
				
				// 0~4

				int count = 0;
				while (true) {
					if(count++ >= 5) {
						System.out.println("시도횟수초과");
						break;
					}
					String x = sc.nextLine();
					int answer = Integer.parseInt(x) - 1;
					// 1  // 0

					if (answer == y) {
						System.out.println("정답입니다");
						break;
					} else {
						System.out.println("틀렸습니다");
						continue;
					}
				}

//				for(int m = 0; m < i.length; m++) {
//					System.out.println(i[m]);
//				}

			}
		}
	}
}
