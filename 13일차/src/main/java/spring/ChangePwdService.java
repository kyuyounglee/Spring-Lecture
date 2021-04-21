package spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePwdService {
	private MemberDao memberdao;
	
	
	public ChangePwdService(MemberDao memberdao) {
		super();
		this.memberdao = memberdao;
	}

	@Transactional
	public void changePwd(String email, String oldPwd, String newPwd) 
	{
		Member member =  memberdao.selectByEmail(email);
		if(member == null)
			throw new MemberNotFoundException();
		member.changePassword(oldPwd, newPwd);
		memberdao.update(member);
	}
}








