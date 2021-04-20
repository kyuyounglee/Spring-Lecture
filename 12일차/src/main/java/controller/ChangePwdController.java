package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.AuthInfo;
import spring.ChangePwdService;
import spring.MemberNotFoundException;
import spring.WrongIdPasswordException;

@Controller
@RequestMapping("/editor/changePassword")
public class ChangePwdController {

	private ChangePwdService changePwdService;
	
	
	public ChangePwdController(ChangePwdService changePwdService) {
		super();
		this.changePwdService = changePwdService;
	}
	@GetMapping
	public String form( 
			@ModelAttribute("command") ChangePwdCommand pwdCmd
			) 
	{
		return "editor/changePwdForm";
	}
	@PostMapping
	public String submit(
			@ModelAttribute("command") ChangePwdCommand pwdCmd
			,Errors errors
			,HttpSession session
			) 
	{
		new ChangePwdCommandValidator().validate(pwdCmd, errors);
		if(errors.hasErrors())
			return "editor/changePwdForm";
		AuthInfo authInfo =  (AuthInfo) session.getAttribute("authInfo");
		try {
			changePwdService.changePwd(authInfo.getEmail()
					, pwdCmd.getCurrentPassword()
					, pwdCmd.getNewPassword());
			return "editor/changePassword";
			
		}catch (MemberNotFoundException e) {
			errors.reject("memberNotFound");
			return "editor/changePwdForm";
		}catch(WrongIdPasswordException e) {
			return "editor/changePwdForm";			
		}			
	}
}
