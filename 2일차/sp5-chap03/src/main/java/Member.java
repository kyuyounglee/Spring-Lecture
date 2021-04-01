import java.time.LocalDateTime;

/**
 * 회원정보를 담고 있는 클래스 
 * 한명당 하나의 객체
 * id email password name registerDateTime
 */
public class Member {
	private long id;
	private String email,password,name;
	private LocalDateTime registerDateTime;
	public Member(String email, String password, String name, LocalDateTime registerDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public void changePassword(String oldPsw, String newPsw) {
		if(!password.equals(oldPsw))
			throw new WrongIdPasswordException();
		password = newPsw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}
	public void setRegisterDateTime(LocalDateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}
	
	
	
}
