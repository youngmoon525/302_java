package test04.pjh;

public class UserDTO {
	private String USER_ID;
	private String USER_PW;
	private String ADMIN;
	private String USER_NICK;

	public UserDTO(String uSER_ID, String uSER_PW, String aDMIN, String uSER_NICK) {
		super();
		USER_ID = uSER_ID;
		USER_PW = uSER_PW;
		ADMIN = aDMIN;
		USER_NICK = uSER_NICK;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_PW() {
		return USER_PW;
	}

	public void setUSER_PW(String uSER_PW) {
		USER_PW = uSER_PW;
	}

	public String getADMIN() {
		return ADMIN;
	}

	public void setADMIN(String aDMIN) {
		ADMIN = aDMIN;
	}

	public String getUSER_NICK() {
		return USER_NICK;
	}

	public void setUSER_NICK(String uSER_NICK) {
		USER_NICK = uSER_NICK;
	}

}
