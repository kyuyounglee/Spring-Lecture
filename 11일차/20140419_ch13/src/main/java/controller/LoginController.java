package controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.AuthInfo;
import spring.AuthService;
import spring.WrongIdPasswordException;

// 실제 화면과  mapping ... url 주소패턴을 가지고 호출됨
// @Controller 를 controller로 사용하려면.. 등록을 해야 한다...
//   config에 등록을 해야 함--->  bean으로 사용해서 등록---> 
// conroller bean을 관리하는 곳에 LoginController 등록
@Controller
// 화면에서 login 으로 접속하면 즉 url주소가 login을 포함하면
// post / get  방식중에 web의 url은 get방식으로 동작한다.
// post 방식은 우리가 임의로 호출하지 못하고 반드시 form 형태로 action에서 정의한다
@RequestMapping("/login")
public class LoginController {
	private AuthService authService;
	@GetMapping
	public String form(LoginCommand loginCommand) {		
		return "login/loginForm";
	}
	
	public LoginController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping
	public String submit(LoginCommand loginCommand
			,Errors error
			,HttpSession session
			,HttpServletResponse response //  cookie 정보를 셋팅
			) {
		new LoginCommandValidator().validate(loginCommand, error);
		if(error.hasErrors())
			return "login/loginForm";
		try {
			AuthInfo authinfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			session.setAttribute("authInfo", authinfo);
			//session.invalidate(); logout될때
			return "login/loginSuccess";		
		}catch (WrongIdPasswordException e) {
			error.reject("idPasswordNotMatching");
			return "login/loginForm";
		}
	}
	
}
