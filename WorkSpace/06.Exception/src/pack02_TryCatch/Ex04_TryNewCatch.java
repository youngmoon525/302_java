package pack02_TryCatch;

public class Ex04_TryNewCatch {
	public static void main(String[] args) {
		// 1부터 100까지 누적합(sum)을 구하시오.
		// 단 , 누적합이 777 이상이 되면 , 계산을 중지하고 결과를 출력
		int sum = 0;
		try {

			for (int i = 1; i <= 100; i++) {
				sum = sum + i;
				if (sum >= 777) {
					throw new Exception("누적합이 777 이상!" + sum);
				}
				// sum += i ;
			}
		} catch (Exception e) {
			//String a
			//e.printStackTrace();<=에러를 상세하게 출력
			System.out.println("메세지만 출력 : " + e.getMessage());
		}
		System.out.println(sum);
	}
}
