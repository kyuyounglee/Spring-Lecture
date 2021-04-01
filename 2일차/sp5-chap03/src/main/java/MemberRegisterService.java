import java.time.LocalDateTime;

/**
 * 회원가입을 처리하는 클래스
 */
public class MemberRegisterService {
	private MemberDao memberdao;

	public MemberRegisterService(MemberDao memberdao) {
		super();
		this.memberdao = memberdao;
	}
	public long regist(RegisterRequest req) {
		Member member= memberdao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new DuplicateMemberException();
		}
		member = new Member(req.getEmail()
				, req.getPassword()
				, req.getName()
				, LocalDateTime.now());
		memberdao.insert(member);
		return member.getId();
	}
	
}
