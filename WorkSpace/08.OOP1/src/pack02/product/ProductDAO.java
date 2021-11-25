package pack02.product;

public class ProductDAO {
	//메소드의 타입을 모르는경우 (리턴이 뭐가 필요한지 모르는경우)
	public void display(ProductDTO dto) {
		 //= new ProductDTO(1, "name", 123);
		System.out.println(dto.num);
		System.out.println(dto.name);
		System.out.println(dto.price);
	}
}
