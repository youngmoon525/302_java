package test;

public class testmain{
	public static void main(String[] args) {
		int size = 3;
		DTO[] dto = new DTO[100];
		
		dto[0] = new DTO("콜라", 500);
		dto[1] = new DTO("사이다", 1000);
		dto[2] = new DTO("생수", 900);
		
		Interface_Main im = new Interface_Main();
		//dto = im.changemenu(dto);
		//for(int i=0; i<dto.length; i++) {
		//	System.out.println(dto[i].item + " " + dto[i].price);
		//}
		
//		dto = im.addmenu(dto, size);
//		size+=1;
//		for(int i=0; i<dto.length; i++) {
//			System.out.println(dto[i].item + " " + dto[i].price);
//		}
		
		dto = im.deletemenu(dto, size);
		size-=1;
		for(int i=0; i<size; i++) {
			System.out.println(dto[i].item + " " + dto[i].price);
		}
		
	}
}
