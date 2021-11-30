package pack02._extends;
//아직 부모클래스를 선택하지 않은 일반 클래스=>extends SuperClass(부모)를 상속 받는 형태의 자식 클래스가 된다.
public class Sub_Class extends Super_Class{
	//public int sum , minus 메소드를 상속을 받음 
	//+(기존 기능) + (Sub_Class) 기능
	
	//@override <- @키워드 : 어노테이션 , 기계가 (java)가 인식을 하는 주석 
	//부모클래스의 기능을 자식클래스가 물려받아 형태를 유지하고 기능을 바꿀때 => 재정의 
	@Override
	public int sum(int x, int y) {
		//Super라는 것은 부모클래스의 메소드를 의미함 .
		//현재 상태는 재정의를 한다고 명시를 해놓고 재정의가 안되어있는 상태
		//(super Class에 있는 sum메소드를 그대로 호출하는것과 같다.
		//return super.sum(x, y);
		return (x+y) +1 ; //<-일반적인 의미의 재정의
	}
	
	
	public int mul(int x , int y) {
		return  ( x * y );
	}
	public int div(int x , int y) {
		return  ( x / y );
	}
	public int div_re(int x , int y) {
		return  ( x % y );
	}
}
