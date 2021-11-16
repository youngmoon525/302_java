package pack02._array;

public class Ex02_Array {
	public static void main(String[] args) {
		// [] <- 배열 데이터구조를 의미.
		//어떤 데이터타입 뒤에 [] 가 붙으면 배열이라고 생각하면 됨.
		//ex) int[] <-int만 담을수있는 배열 , String[] <-String만 담을수
		// Button[] <-Button만 담을수있는 배열 , .....
		
		//String타입을 담을수있는 sArr이라는 배열을 만드시고 크기를 10을 할당하세요.
		String[] sArr = new String[10];
		sArr[0] = "A"; // int[0] = int만 넣을수있음.
		sArr[1] = "B"; // <- 문자열만 담을 수있음
		//null ? : 아직 객체를 참조하고 있지 않은 (메모리 참조 번지 어드레스가 없는)
		//[A][B]....[null]
		//java.lang.NullPointerException 
		//객체 참조가 없다. (인스턴스화 , 아직 객체로 만들어지지 않은 ) 상태에서
		//어떠한 기능을 이용하게 되면 발생하게 되는 오류
		//null == 아직 값을 할당하지 않은 (사용준비가 안된 상태)
		//String.equals("A")
		//null.equals("A") <- X 객체 참조가 없음 (String이 아님)
		//기본적으로 int형이나 기본 데이터타입은 나올일이 없는 오류↑
		for(int i = 0 ; i<sArr.length; i++) {
			if(sArr[i].equals("A")) {
				System.out.println("A와 같은 값을 가진 인덱스는 : " + i);
			}
		}
		
		
		
		String[] sArr2 = { "강아지" , "고양이" , "병아리" };
		//↑ sArr2에 ,<-로 구분된 크기만큼의 배열에 각각 0번인덱스부터
		//강아지 , 고양이 , 병아리 
		//for문을 이용해서 sArr2에 들어있는 동물 목록을 출력하시오.
		for(int i = 0 ; i<sArr2.length; i++) {
			System.out.println(sArr2[i]);
		}
	}

}
