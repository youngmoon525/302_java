package test02__lsj;

import java.io.IOException;

public class DrinkMain_LSJ {
	public static void main(String[] args) throws IOException {
		DrinkDAO_LSJ dao = new DrinkDAO_LSJ();
		
		while(true) {
			if(dao.login()) {
				dao.adminMode();
				
				System.out.print("프로그램을 종료하시겠습니까?(y/n)>> ");
				String ans = dao.inputString();
				if(ans.equals("y") || ans.equals("Y")) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
			}else {
				dao.userMode();
				
				System.out.print("프로그램을 종료하시겠습니까?(y/n)>> ");
				String ans = dao.inputString();
				if(ans.equals("y") || ans.equals("Y")) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
			}
		}
		
		dao.br.close();
		dao.sc.close();
	}
}
