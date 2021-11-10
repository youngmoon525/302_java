
public class Ex03_ppmm {
	public static void main(String[] args) {
		//breaking point <-프로그램의 어느지점에서 멈출껀지
		//ex) int x=1 ; <-이줄을 실행하기 전에 멈춤.
		//증감 ++ , 가감-- (증감 연산자)
		//선행 , 후행
		int x = 1; 
		int y = 1;
		
		System.out.println("x++ :" + (x++));//x의 뒤에 ++증감연산자가 붙음
		System.out.println("++y :" + (++y));//y의 앞에 ++증감연산자가 붙음
		//++ 의미하는것은 현재값 +1 
		//++앞에 붙은 경우에는 1을 증가 시키고 출력.(먼저)
		//++뒤에 붙은 경우에는 출력을 먼저하고 1을 증가시킴.(나중에)
		
		int z = y++;//y(2) 일때 z에는 무슨값이 담아질까 .? 
		//x , y , z의값을 각각 syso로 출력해보고 결과 확인.
		//디버깅<-
		System.out.println("x의 값 : " + x);
		System.out.println("y의 값 : " + y);
		System.out.println("z의 값 : " + z);
		
		
		
	}
}
