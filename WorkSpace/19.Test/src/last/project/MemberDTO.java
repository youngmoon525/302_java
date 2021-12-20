package last.project;

public class MemberDTO {
	private int student_no;
	private String user_id	;
	private String user_pw	;
	private String admin	;
	private String user_nick;
	public MemberDTO() {
		
	}
	public MemberDTO(int student_no, String user_id, String user_pw, String admin, String user_nick) {
		super();
		this.student_no = student_no;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.admin = admin;
		this.user_nick = user_nick;
	}
	public int getStudent_no() {
		return student_no;
	}
	public void setStudent_no(int student_no) {
		this.student_no = student_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	
	
}
