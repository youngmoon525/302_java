package pack03._interfaces;

import pack02._interface.FruitDTO;
import pack02._interface.IFruitInterface;

//여러개의 Interface를 implements받아보기 ? 가능할까? 
//extends 상속은 단일 상속만 가능했음.
//implemnets의 상속은 어떤 차이가 있을까?
//↑ 추상 클래스인 Interface는 여러개를 상속 받을수있다.(다중 상속 O)
public class Interfaces_Main implements IFruitInterface , ItestInterface {

	@Override
	public FruitDTO[] initDtos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void display(FruitDTO[] dtos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispalyMax(FruitDTO[] dtos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test3() {
		// TODO Auto-generated method stub
		
	}

}
