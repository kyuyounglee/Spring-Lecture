package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.ChangePwdController;
import controller.HelloController;
import controller.LoginController;
import controller.LogoutController;
import controller.RegisterController;
import spring.AuthService;
import spring.ChangePasswordService;
import spring.ChangePwdService;
import spring.MemberRegisterService;
import survey.SurveyController;

@Configuration
public class ControllerConfig {
	@Autowired
	private MemberRegisterService memberRegSvc;
	@Autowired
	private AuthService authservice;	
	@Autowired
	private ChangePwdService changePwdService;	
	
	@Bean
	public HelloController h() {
		return new HelloController();
	}
	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}
	
	@Bean
	public SurveyController surveyController() {
		return new SurveyController();
	}
	
	@Bean
	public LoginController loginController() {
		return new LoginController(authservice);
	}
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	@Bean
	public ChangePwdController changePwdController() {
		return new ChangePwdController(changePwdService);
	}
}
