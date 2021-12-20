package test04.pjh;

public class DrinkDTO {
	private int NO;
	private String NAME;
	private int PRICE;
	private int CNT;
	private String COMPANY;

	public DrinkDTO(int nO, String nAME, int pRICE, int cNT, String cOMPANY) {
		super();
		NO = nO;
		NAME = nAME;
		PRICE = pRICE;
		CNT = cNT;
		COMPANY = cOMPANY;
	}

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public int getPRICE() {
		return PRICE;
	}

	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}

	public int getCNT() {
		return CNT;
	}

	public void setCNT(int cNT) {
		CNT = cNT;
	}
	
	public String getCOMPANY() {
		return COMPANY;
	}

	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}

	@Override
	public String toString() {
		return "[번호= " + NO + ", 이름= " + NAME + ", 가격= " + PRICE + ", 재고= " + CNT + ", 제조사= " + COMPANY
				+ "]";
	}

}
