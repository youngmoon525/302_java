package pack03.etc;

public class Ex01_Escape {
	public static void main(String[] args) {
		//이스케이프 \
		//뒤에 t나 n 붙여서 기능을 사용할수가있다.
		//tab , newLine , format 
		//※이스케이프를 쓰고 \ 뒤에 아무것도 안쓰면 오류가난다.
		//\\<-이렇게 해야만 하나의 문자로 인식한다.
		System.out.println("\\ \\");
		System.out.println("번호\tTab을했습니다.");
		//line New (새줄을 만들고 출력)
		System.out.print("그냥 프린트 입니다.\n");
		System.out.print("그냥 프린트 입니다.2");
		
	}
}
