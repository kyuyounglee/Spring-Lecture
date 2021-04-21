package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.Member;
import spring.MemberDao;

@Controller
public class MemberListController {
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("/members")
	public String list(
			@ModelAttribute("cmd") ListCommand cmd
			,Errors errors
			,Model model
			) 
	{
		if(errors.hasErrors())
			return "member/memberList";
		if(cmd.getFrom() != null && cmd.getTo() != null) {
			List<Member> members =  memberDao.selectByRegDate(cmd.getFrom(), cmd.getTo());			
			model.addAttribute("members", members);
		}		
		return "member/memberList";
	}
	
	
}
