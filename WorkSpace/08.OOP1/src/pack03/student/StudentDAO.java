package pack03.student;

public class StudentDAO {
	
	public void display(StudentDTO dto) {
		System.out.println(dto);
		System.out.print("이름 : " + dto.name +"\t");
		System.out.print("국어 : " + dto.kor+"\t");
		System.out.print("영어 : " + dto.eng+"\t");
		System.out.print("수학 : " + dto.mat+"\t");
		System.out.print("총점 : " + dto.sum+"\t");
		System.out.println("평균 : " + dto.avg);
	}

	public void getSum(StudentDTO dto) {
		dto.sum = dto.kor + dto.eng + dto.mat;
		//return dto.sum;
	}

	public void getAvg(StudentDTO dto) {
		dto.avg =  (double)dto.sum / 3;
	}
}
