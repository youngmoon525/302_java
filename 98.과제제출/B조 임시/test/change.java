package test;

import java.util.Scanner;

public class change extends delete{
	public DTO[] changemenu(DTO[] dtos) {
		Scanner sc = new Scanner(System.in);
		System.out.print("기존 음료 이름? ");
		String name = sc.nextLine();
		for(int i=0; i<dtos.length; i++) {
			if(dtos[i].item.equals(name)) {
				System.out.println("새로운 음료 이름? ");
				name =sc.nextLine();
				dtos[i].item = name;
				System.out.println("가격? ");
				int won = Integer.parseInt(sc.nextLine());
				dtos[i].price = won;
			}
		}
		return dtos;
	}
}