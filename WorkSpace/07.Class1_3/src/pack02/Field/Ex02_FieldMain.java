package pack02.Field;

public class Ex02_FieldMain {
	public static void main(String[] args) {
		//Ex02_Field를 객체화(인스턴스화) 하고
		//모든 필드를 사용할준비를 하세요. (null,0)이 없게 만들기.
		//인스턴스화 (객체화) 한 객체로 부터 접근이 가능한
		//멤버 (변수,field,iv) 
		Ex02_Field eField = new Ex02_Field();
		eField.intField = 10;
		//int intFeild = ? // 숫자형 데이터
		System.out.println(eField.intField);
		//boolean boolFeild = ? , true , false
		eField.boolField = true;
		System.out.println(eField.boolField);
		eField.charField = 'A';
		//int[] arrField;
		//arrField = new int[3];
		eField.arrField =new int[3];
		eField.arr2Field = new int[3][3];
		// null.company == 초기화가 안된 객체
		// String aaa = null;
		eField.car =new Ex01_Car();
		System.out.println(eField.car.company ); 
		
		
		
		
	}
}
