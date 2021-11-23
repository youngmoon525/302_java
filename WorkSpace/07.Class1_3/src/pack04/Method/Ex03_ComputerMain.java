package pack04.Method;

public class Ex03_ComputerMain {
	public static void main(String[] args) {
		//Ex03_Computer 인스턴스화 
		//1차원 배열을 메소드 호출 시 넘겨줌. 
		//메소드는 1차원 배열을 입력받아서 배열의 크기만큼 반복을하면서
		//1차원 배열의 모든 요소의 합을 return을 해준다.(int)
		Ex03_Computer ec = new Ex03_Computer();
		int[] ab = { 1 , 2, 3 , 4 ,5 };
		System.out.println(ec.sum1(ab)); 
		// int[]  = new int[3] = x?
	}
}
