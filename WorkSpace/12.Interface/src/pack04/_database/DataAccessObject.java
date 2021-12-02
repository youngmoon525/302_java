package pack04._database;

public interface DataAccessObject {
//DAO == 기능( DataBase 접근 데이터를 실제로 조회,추가,수정,삭제) 
// CRUD (Create , Read , Update , Delete )
//ex) 커뮤니티 - 글 쓰기 , 글 읽기 , 글 수정 , 글 삭제 )
//Create==Insert , Read == Select , Update , Delete
//DML을 수행한다 데이터를 조작하는 행위
	public void select();//글을 조회
	public void insert();//글을 추가
	public void update();//글을 수정
	public void delete();//글을 삭제
}
