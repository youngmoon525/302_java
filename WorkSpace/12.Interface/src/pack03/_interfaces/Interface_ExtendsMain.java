package pack03._interfaces;

import pack02._interface.FruitDTO;

//Interface 설계도도 상속이 가능할까? 
//Interface는 바로 상속이 불가능함.
//Interface를 여러개 상속받은 클래스를 만들어놓고 그 클래스를 상속하는것은 가능함.
public class Interface_ExtendsMain extends Interfaces_Main {//new Interfaces_main
	
	@Override
	public void test1() {
		super.test1(); //super==부모클래스.
	}
	
	@Override
	public void display(FruitDTO[] dtos) {
		// TODO Auto-generated method stub
		super.display(dtos);
	}
	

}
