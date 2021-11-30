package pack01.userprivate;

public class BookDTO {
	//제목 , 가격 , 저자 , 출판사
	//title , price , writer , company ;?
	// <= BookMain.java ( main 에서 필드 접근해보기)
	//해리포터 , 20000 , 조앤롤링 , 모름
	String title , writer , company ;
	private int price ;
	//인스턴스 멤버 ( 객체화 시켜야만 사용할수 있는 영역,new를 통해서 메모리에 올라감)
	//개발자가 별도로 생성자 메소드를 만들지 않았을때는 비어있는 형태의 new BookDTO();
	//↑를 사용할수가있다.
	
	
	//getter & setter 메소드를 이용해서 필드에 접근하게 함.
	//get(); 가져오다.
	//set(); 값을 세팅(대입) 
	//getter & setter는 적어도 default 이상의 접근제한자를 써야만한다.
	public int getPrice() {//return Type은 필드의 데이터 타입과 똑같야한다.
						   //(반드시는 아니나 대부분 ..ex)int price , public int)
		return this.price; //내가 가지고있는 field가 private 접근제한자로
						   //외부 접근을 막아놓은 상태라면, 사용하는 getter메소드의
						   //기본형태
	}

	public void setPrice(int price) {//dto.setPrice(-100);
		//필드에 접근을 바로 막는 이유 : 필드에 논리적으로 들어가면 안되는값이
		//들어가는것을 방지하고자.
		if(price > 0) {
			this.price = price ;
		}
		//메소드 호출 시 세팅할값을 보내주고 그값을 통해서 필드를 세팅을 한다.
	}
	
	
	
	
	
}
