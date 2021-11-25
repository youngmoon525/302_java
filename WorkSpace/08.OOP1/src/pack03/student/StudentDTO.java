package pack03.student;

public class StudentDTO {
	//멤버 변수 
	String name;//학생의 이름
	int kor , eng , mat , sum ; //국 , 영 , 수 (국+영+수)총점
	double avg; //총점 / 3 평균 
	public StudentDTO(String name, int kor, int eng, int mat, int sum, double avg) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		//sum , avg --바로 평균,총점
		this.sum = sum;
		this.avg = avg;
	}
	
	
	
	//1.StudentDTO를 생성할때 모든 필드의값을 입력받아야만
	//생성할수있게 생성자 메소드를 만드시오.==new StudentDTO();
	//생성자 메소드를 별도로 만들어야 한다.
	
	//2.StudentMain , StudentDAO 
	//기능은 DAO에 전부 구현을하고 Main에서는 구현 된 기능을 호출만 한다.
	//기능1.학생의 이름 , 국,영,수,총,평균을 출력하는 display()메소드
	//기능2.학생의 평균을 구하는 메소드 getAvg();
	//기능3.학생의 총점을 구하는 메소드 getSum(); 총점 =국+영+수
	//초기 출력↓
	// 홍길동 , 90 , 50 , 100 , 0 , 0
	// 심청   , 100 , 60 , 70 , 0 , 0
	//메소드 호출 getAvg() , getSum()
	// 홍길동 , 90 , 50 , 100 , 총점 , 평균
	// 심청   , 100 , 60 , 70 , 총점 , 평균
}
