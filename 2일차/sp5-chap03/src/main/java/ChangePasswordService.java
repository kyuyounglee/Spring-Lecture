/**
 * 비밀번호 변경
 * 회원 비밀번호
 * Dao롤 통해서 해당 해원정보를 찾고 그 회원의 비번을 변경
 * 저장된 비번하고 사용자가 입력한 old 비번이 같아야만...(인증)
 * 새로운 비번으로 교체
 */
public class ChangePasswordService {
	private MemberDao memberdao;
	
	public void changePassword(String email,String oldPsw,String newPsw) {
		Member member= memberdao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPsw, newPsw);
		memberdao.update(member);		
	}
	
	public void setMemberDao(MemberDao memberdao) {
		this.memberdao = memberdao;
	}
	
}
