package pack02.product;

// DTO : 상태정보(field,변수) 
public class ProductDTO {
	int num ; //상품의 번호
	String name ;//상품 명
	int price ; //가격 
	
	public ProductDTO(int num, String name, int price) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
	}
	
	
}
