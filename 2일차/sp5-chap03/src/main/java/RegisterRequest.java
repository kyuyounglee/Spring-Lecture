/**
 * 등록절차를 관리하는 클래스 
 */
public class RegisterRequest {
	private String email,password,confirmPasswd,name;

	
	public RegisterRequest(String email, String password, String confirmPasswd, String name) {
		super();
		this.email = email;
		this.password = password;
		this.confirmPasswd = confirmPasswd;
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPasswd() {
		return confirmPasswd;
	}

	public void setConfirmPasswd(String confirmPasswd) {
		this.confirmPasswd = confirmPasswd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean ispswConfirmPsw() {
		return password.equals(confirmPasswd);
	}
	
}
