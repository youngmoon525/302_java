package pack02._outputstream;

public class Ex01_Systemout {
	public static void main(String[] args) {
		//System.out <= OutputStream
		//Scanner( System.in) <= InputStream
		System.out.write(65);
		System.out.flush();
		//스트림 버퍼에 저장되어 있는 데이터를 강제로 출력시키는것 ( flush )
		//기본적으로 출력 스트림 버퍼(저장공간) 데이터가 가득 차면 그때 데이터를 출력시킴 
		//이 메소드를 사용하게 되면 강제로 저장된 데이터의 크기와 상관없이 전체를 강제적으로 출력한다.
		// ex)데이터를 열심히 담음 ..데이터공간을 못채웠음..flush안함.. 데이터 이동안되고 출력도안됨.
		// 데이터공간을 채우고 출력을 하더라도 캐시(임시데이터 , 찌꺼기 데이터 )가 쌓이기때문에 flush로 항상비움
	}
}
