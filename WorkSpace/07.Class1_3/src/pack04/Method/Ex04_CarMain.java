package pack04.Method;

public class Ex04_CarMain {
	public static void main(String[] args) {
		Ex04_Car car = new Ex04_Car("쌍용","티볼리","검정",0,200,40);
 		car.display();//Ex04_Car라는 객체의 상태를(field) 보기위한 메소드
 					  //return타입은 없음 : 출력하고나서 어떤 결과를 main에서 받을
 					  //필요가 없기 때문.
 		//문제. 현재 속력을 100으로 바꿈.
 		//문제. 현재 속력을 100으로 바꿈 . 
 		// "기존 속력 0 = > 100 바뀜" 으로 내용이 출력되고
 		// 실제 필드값(speed)100으로 바뀌게 메소드로만 처리(int형 데이터를 파라메터)
 		car.changeSpeed(2);
 		//제약조건 - 차량의 speed는 반드시 changeSpeed메소드로만 가능함.
		//최대 속도가 200인 차량이 현재속도가 300으로 바뀔수는 없다.
 		//따라서 입력된속도 ex)300가 차의 최대속도를 넘어서면 그이상으로 안바뀌게
 		//프로그램 수정하세요.
		
		
		
		
		

	
	
	}
}
