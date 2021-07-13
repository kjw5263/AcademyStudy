package DB;

// 오라클 DB에 저장할 데이터들을 객체 단위로 묶어서 관리하기 위한 VO 클래스
public class MemberBean {

	private String id;
	private String pass;
	private String name;
	private String phone;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", pass=" + pass + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ "]";
	}
	
	
	
	
}
