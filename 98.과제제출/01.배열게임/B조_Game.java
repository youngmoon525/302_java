package pack02._array;

import java.util.Random;
import java.util.Scanner;

public class B조_Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		while (true) {
			System.out.println("1.게임 시작  0.게임종료");

			int a = Integer.parseInt(sc.nextLine());

			if (a == 1) {
				System.out.println("1보다 큰 수를 입력하세요");
				int bb = Integer.parseInt(sc.nextLine());

				while (bb < 2) {
					System.out.println("1보다 큰 수를 입력하세요!!!");
					bb = Integer.parseInt(sc.nextLine());
				}
				
				int[] arr = new int[bb]; // bb 입력한 만큼 돌리게

				int num = r.nextInt(bb);
				arr[num] = 1;
				int i = 1;
				while (true) {
					System.out.println("어느 위치에 있을까요?");
					int bbb = Integer.parseInt(sc.nextLine());

					if (arr[bbb] == 1) {

						System.out.println(i + "번째 시도에 게임 승리");
						break;
					} else {
						i++;
						if (num > bbb) {
							System.out.println("더 큰 값을 입력하세요");
						} else {
							System.out.println("더 작은 값을 입력하세요");
						}
					}
				}
			} else if (a == 0) {
				System.out.println("종료됩니다.");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		sc.close();
	}

}
