package spring;

// session 에 저장할 정보를 가지고 있는 객체
// 로그인 관련 정보

// DB 와 mapping 할때 사용   ( DB <--> Class )
// form에서 ModelAndView 객체로 사용할때 ( 화면 <---> Class )
public class AuthInfo {
	// 맴버는 99%  private / protected 정의
	// 속성은 직접 수정하지 않는다
	// 항상  method를 통해 접근
	private Long id;
	private String email;
	private String name;
	// 맴번변수를 가지고 객체를 생성하는 생성자
	// 각 맴버변수에 대한 getter / setter
	public AuthInfo(Long id, String email, String name) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
