package test;

public class Interface_Main implements TestInterface {
	change c = new change();
	@Override
	public DTO[] deletemenu(DTO[] dto, int size) {
		// TODO Auto-generated method stub
		return c.deleteMenu(dto, size);
	}

	@Override
	public DTO[] changemenu(DTO[] dto) {
		// TODO Auto-generated method stub
		return c.changemenu(dto);
	}

	@Override
	public DTO[] addmenu(DTO[] dto, int size) {
		return c.addDrink(dto, size);
	}
	
}
