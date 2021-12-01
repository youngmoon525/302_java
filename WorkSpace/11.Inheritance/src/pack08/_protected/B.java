package pack08._protected;

public class B extends A{

	public B() {
		super();
		this.method1();
	}
	public void init() {
		A a = new A();
		a.method1();
		a.field1 = "";
	}
	
	
}
