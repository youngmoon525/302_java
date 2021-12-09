package pack01._ojdbc;

import java.util.ArrayList;

public class Ex02_Main {
	public static void main(String[] args) {
		Ex02_DAO dao = new Ex02_DAO();
		//dao.connDB();
		//dao.selectBoard();
		ArrayList<Ex02_BoardDTO> list = dao.selectBoardList();
		if(list != null) {
			System.out.println(list.size());
		}
		dao.display(list);
	}
}
