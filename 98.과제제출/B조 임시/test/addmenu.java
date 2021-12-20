package test;

import java.util.Scanner;

public class addmenu {
	Scanner sc = new Scanner(System.in);

	public DTO[] addDrink(DTO[] dtos, int size) {
		DTO[] temp_dtos = new DTO[size + 1];
		for (int i = 0; i < size; i++) {
			temp_dtos[i] = dtos[i];
		}
		System.out.println("음료의 이름을 입력 해주세요.");
		String item = sc.nextLine();

		System.out.println("음료의 가격을 입력해주세요");
		int price = Integer.parseInt(sc.nextLine());

		DTO dto = new DTO(item, price);
		temp_dtos[size] = dto;

		return temp_dtos;
	}
}