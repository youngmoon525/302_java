package pack02._interface;


public interface IFruitInterface {
	//메소드들을 미리정해놓고
	//하나로 합쳐진 DAO를 호출할수있게 만듬.
	public FruitDTO[] initDtos() ;
	public void display(FruitDTO[] dtos);//FruitDTO[] 배열을 입력받아서 출력할수있게 정의만해놓음.
										 //실제 기능구현은 각각의 DAO에서 한다.
	public void dispalyMax(FruitDTO[] dtos);
}
