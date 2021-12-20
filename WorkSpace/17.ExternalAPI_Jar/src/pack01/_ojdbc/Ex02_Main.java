package pack01._ojdbc;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02_Main {
	public static void main(String[] args) {
		Ex02_DAO dao = new Ex02_DAO();
		Scanner sc = new Scanner(System.in);
		//WEB. COMMUNITY 
		// 게시글이 먼저 전체가 보임. ( 글의번호 , 글의제목 )
		// 1.사용자가 글을 선택을 함 ( 클릭을했다고 가정,웹사이트에서)
		// 2.사용자가 글을 추가함 ( 글의번호(?)  , 글의 제목 , 글의 내용은 직접 사용자가 작성 )
		// 3.사용자가 글을 수정함 ( 로그인처리가 필요하지만 (생략) , 글의 제목 , 글의내용 수정 )
		// 4.사용자가 글을 삭제함 ( 글의 번호를 이용해서 글을 삭제함 )
		while(true) {
			ArrayList<Ex02_BoardDTO> list = dao.selectBoardList();
			dao.display(list);
			System.out.println("게시판 메뉴 ▶ 1.글 상세보기(글번호입력) 2.글 추가 3.글 수정 4.글 삭제");
			try {
				int menu = Integer.parseInt( sc.nextLine() );
				if(menu == 1) {
					System.out.println("글 번호를 입력해주세요.");
					int whereNo = Integer.parseInt(sc.nextLine());
					Ex02_BoardDTO dto = dao.selectBoardList(whereNo);
					System.out.print(dto.getNo());
					System.out.print(dto.getTitle());
					System.out.print(dto.getContent());
					System.out.println();
					System.out.println("============글상세보기.▶ enter key 시 메인으로" );
					sc.nextLine();
				}else if(menu == 2) {
					System.out.println("==글 추가==");
					//no에 넣을 숫자값. ( board테이블의 no가 key 중복되면 안되는 고유한값 )
					//(board테이블의 no의 최대값 == 실제 있는값 +1 =! 실제 없는값.(<-구해야하는값)
					int no = dao.getMaxNo();//SELECT MAX(NO) max_no from board 
					System.out.println("글의 제목을 입력해주세요.");
					String title = sc.nextLine();
					System.out.println("글의 내용을 입력해주세요.");
					String content = sc.nextLine();
					Ex02_BoardDTO dto = new Ex02_BoardDTO(no,title, content);
					// 데이터베이스에 트랜잭션 ( 추가 , 수정 , 삭제 ) 처리를 했을때
					//※그결과는 -1 또는 0이 나오면 실패
					int result = dao.boardInsert(dto);
					//dto에 데이터를 전부넣고 dto로 데이를 묶어서 이동. 
					//Strinig title , content ,int no
					
				}else if ( menu == 3) {
					System.out.println("수정할 글의 번호를 입력해주세요.");
					//db에 실제 있는값을 수정해야함. ( 실제로 없는값인데 사용자가 내용을 입력하고
					//수정처리를 했을때 . 사용자는 불편함을 느낀다 ) 
					int no = Integer.parseInt(sc.nextLine());
					if (  dao.checkNo(no)  ) {
						Ex02_BoardDTO dto = new Ex02_BoardDTO(no, null, null);
						System.out.println("글 제목을 입력해주세요.");
						dto.setTitle(sc.nextLine());
						System.out.println("글 내용을 입력해주세요.");
						dto.setContent(sc.nextLine());
						int succ = dao.boardUpdate(dto);
						System.out.println(succ);
						
					}else  {
						System.out.println("메뉴 선택 잘못된입력");
					}
				}else if (menu == 4) {
					System.out.println("삭제 하실 글의 번호를 입력해주세요.");
					int no = Integer.parseInt(sc.nextLine());
					if (  dao.checkNo(no)  ) {
						System.out.println("글을 삭제합니다.");
						int succ = dao.deleteBoard(no);
						System.out.println(succ);
					}else {
						System.out.println("번호를 잘못입력하셨습니다. 메뉴로▶");
					}
				}
			}catch (Exception e) {
				System.out.println("잘못된 입력입니다. 1~4까지의 수만 입력해주세요.");
			}
			//다른 유저가 글을 추가하거나 삭제를 했을때는 Database 행갯수가 달라짐.따라서 계속 다시조회를해옴.
		}
		
	}
}
