package pack02_interface_test;

import java.util.Scanner;

public class delete extends add {
	Scanner sc = new Scanner(System.in);
	public void deleteMenu(DTO[] dtos, int size) {
		System.out.println("삭제할 음료의 이름을 입력하세요.");
		String name = sc.nextLine();
		for(int i=0; i<size; i++) {
			if(dtos[i].item.equals(name)) {
				for(int j=i; j<size-1; j++) {
					dtos[j] = dtos[j+1];
				}
			}
		}
	}
}
