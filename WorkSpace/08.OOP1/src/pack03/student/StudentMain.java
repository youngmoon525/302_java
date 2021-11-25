package pack03.student;

public class StudentMain {
	public static void main(String[] args) {
		// 홍길동 , 90 , 50 , 100 , 0 , 0
		// 심청   , 100 , 60 , 70 , 0 , 0
		StudentDTO dto1 = new StudentDTO("홍길동", 90, 50, 100, 0, 0);
		StudentDTO dto2 = new StudentDTO("심청", 100, 60, 70, 0, 0);
		StudentDAO dao = new StudentDAO();
		System.out.println("main : " + dto1);
		dao.display(dto1);
		dao.display(dto2);
		dao.getSum(dto1);
		dao.getSum(dto2);
		dao.getAvg(dto1);
		dao.getAvg(dto2);
		dao.display(dto1);
		dao.display(dto2);
		
		//출력 display();
	
		
	
		
	}
}
