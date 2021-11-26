package pack03.student;

import java.util.Arrays;

public class StudentMainMulti {
	public static void main(String[] args) {
		//배열.
		//어떤데이터타입[] <- 배열의 선언을 의미함.
		// new 데이터타입[size] ; 몇개의 데이터를 담을건지에 대한 정의
		StudentDTO[] dtos = new StudentDTO[5];
		System.out.println(Arrays.toString(dtos));
		StudentDAO dao = new StudentDAO();
		//0~4
		for(int i = 0 ; i<dtos.length; i++) {
			dtos[i] = new StudentDTO("name"+i, 10+i, 20+i, 30+i, 0, 0);
			System.out.println(Arrays.toString(dtos));
		}
//		StudentDTO dto =  new StudentDTO("홍길동", 90, 100, 80, 0, 0);
//		dtos[1] = dto;
		
		System.out.println(Arrays.toString(dtos));
		//dao.display(dto);//<-오류안남 ↓오류남??
		dao.display(dtos[0]);//dto한건만 보내서 작업되게
		dao.display(dtos);//dto[] 배열 보내도 전체 내용이 출력되게 메소드 작성
		//↑메소드 오버로딩 ?
	
		//[int , 0] [String , null ] [StudentDTO,null] [] []
		//int[] arr = new int[3]; 
		//arr[0] = 10;<-
		//syso(arr[0]);
		//[dto] [dto] [null] [null] [null]
		//dtos[0] <- dto.field<

		//System.out.println(" DTO" + dto.name);
		//System.out.println("배열 DTO" + dtos[0].name);
		//System.out.println("배열 DTO" + dtos[1].name);
	}
}
