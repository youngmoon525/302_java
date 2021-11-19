package pack02_TryCatch;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = {"1.콜라 : 800원", "2.생수 : 500원", "3.사이다 : 1500원"};
		int money=0;
		int end2=0;
		int menu = 0;
			while(true) {
				try {
				System.out.println("자판기를 이용하시려면 1번 이용하지 않으시려면 2번을 입력해주세요.");
				String end = sc.nextLine();
				end2 = Integer.parseInt(end);
				if(end2==2) {
					break;
				}else if(end2==1) {
				}else {
					System.out.println("다시 입력해주세요");
					continue;
				}
			
				System.out.println("금액을 입력해주세요");
				String str = sc.nextLine();
				money = Integer.parseInt(str);
				System.out.println("금액 : "+money);
				System.out.println("메뉴를 골라주세요");
				System.out.println(Arrays.toString(name));
				String str2 = sc.nextLine();
				menu = Integer.parseInt(str2);
				}catch(Exception e){
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
					continue;
				}
				if(menu==1) {
					if(money<800) {
						System.out.println("금액이 부족합니다.");
					}else {
						System.out.println("콜라를 고르셨습니다.");
						System.out.println("잔돈 : "+(money-800)+"원");
						System.out.println("천원 :"+(money-800)/1000+"개 "+" 오백원 :"+(money-800)%1000/500+"개 "+"백원 :"+(money-800)%1000%500/100+"개");
					}
				}else if(menu==2) {
					if(money<500) {
						System.out.println("금액이 부족합니다.");
					}else {
						System.out.println("생수를 고르셨습니다.");
						System.out.println("잔돈 : "+(money-500)+"원");
						System.out.println("천원 :"+(money-500)/1000+"개 "+" 오백원 :"+(money-500)%1000/500+"개 "+"백원 :"+(money-500)%1000%500/100+"개");
					}
				}else if(menu==3) {
					if(money<1500) {
						System.out.println("금액이 부족합니다.");
					}else {
						System.out.println("사이다를 고르셨습니다.");
						System.out.println("잔돈 : "+(money-1500)+"원");
						System.out.println("천원 :"+(money-1500)/1000+"개 "+" 오백원 :"+(money-1500)%1000/500+"개 "+"백원 :"+(money-1500)%1000%500/100+"개");
					}
				}
			}
		}
	}
