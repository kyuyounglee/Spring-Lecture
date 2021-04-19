package spring;
// DB에 입력된 정보를 select 해서 사용자가 입력한 정보와 비교
// ~~~service  == DB와 연계
public class AuthService {
	private MemberDao memberdao;
	// 생성자....
	
	public AuthService(MemberDao memberdao) {
		super(); // 모든 생성자는 부모의 기본생성자를 먼저 호출한다(default)
		this.memberdao = memberdao;
	}
	// key--> email  정보를 가지고 조회를 한다음 조회된 맴버의 
	// 비번을 확인한다.
	// 그래서 비번이 맞으면.... 권한정보를 가지고 있는 autoinfo 객체를 반환한다
	public AuthInfo  authenticate(String email, String password) {
		Member member =  memberdao.selectByEmail(email);
		if(member == null)
			throw new WrongIdPasswordException();
		if( !member.matchPassword(password) ) {			
			throw new WrongIdPasswordException();
		}
		// 로그인 관련 정보를 가진 객체를 리턴
		return new AuthInfo(member.getId(), member.getEmail(), member.getName());
	}
	
}
