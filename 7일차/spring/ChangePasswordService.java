package spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {
	private MemberDao memberdao;
	
	@Transactional
	public void changePassword(String email,String oldp,String newp) {
		Member member =  memberdao.selectByEmail(email);
		if(member ==null)
			throw new MemberNotFoundException();
		member.changePassword(oldp, newp);
		memberdao.update(member);		
	}
}
