
public class Ex01_Oper {
	public static void main(String[] args) {
		//부호. +<=양수를 의미 -<=음수를 의미
		int x = -100;
		int result1 = +x;//x라는 변수에는 -100값이 담겨있음.
						 //x라는 변수앞에 부호를 붙이고 result1
						 //이라는 변수에 값을 할당했다.
		int result2 = -x;//
		//syso
		int result3 = -result2;//?<=
		System.out.println("result1 : " + result1);
		//String + int = String(연결,결합)
		System.out.println("result2 : " + result2);
		//앞에 부호를 붙이게 되면 하는 연산.
		// x * 1 = x;	
		// x * -1 = -x; -부호를 붙이게 되면 양수->음수 음수->양수
		//부호의 반전을 의미한다.
		//
		int result4 = x * -1 ; //-부호
		int result5 = x * 1 ; //+부호
		//↑ 부호를 붙이는것보다 가독성이 좋기때문에 (부호를 반전시켰다는
		//것을 여러사람이 보고 판단할수가 있음) 더 많이 사용됨.
		
	}
}
