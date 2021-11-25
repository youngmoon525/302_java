package pack02.product;

public class ProductMain {
	public static void main(String[] args) {
		ProductDTO dto1 = new ProductDTO(1, "name1", 30000);
		ProductDTO dto2 = new ProductDTO(2, "name2", 40000);
		ProductDTO dto3 = new ProductDTO(3, "name3", 50000);
		ProductDAO dao = new ProductDAO();
		dao.display(dto1);
		dao.display(dto2);
		dao.display(dto3);
		
		//String str = "aa" ;
		//rtnString(str);
		//rtnString("aa");
		//dao.display(dto);
				
		//display()메소드를 ProductDAO를 만드시고 구현하기.
		
	}
}
