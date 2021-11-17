package pack03._array2;

public class Ex03_Array {
	public static void main(String[] args) {
		//배열은 크기를 정해놓고 사용.
		//2차원 배열의 경우 요소의 갯수(1차원배열의갯수)를 미리 지정해놓고
		//1차원 배열(요소)을 따로 담는것이 가능하다.
		String[] dog = { "강아지" , "진돗개" , "불독" , "시추" };
		String[] cat = { "페르시안", "노루웨이" , "고양이"};
		//↑1차원 배열들을 요소로 가짐 (2차원 배열)
		String[][] animal = new String[2][];//1차원 배열의 데이터갯수를 모르는경우
											//1차원 배열을 따로만들어서 담는경우 등등
		animal[0] = dog;//2차원 배열의 0번인덱스에 1차원 배열 dog이 들어감
		animal[1] = cat;
		for(int i = 0 ; i < animal.length; i++) {
			for(int j = 0 ; j<animal[i].length; j++) {
				System.out.println(animal[i][j]);
			}
		}
		
	}
}
