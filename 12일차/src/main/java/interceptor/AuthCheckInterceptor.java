package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthCheckInterceptor implements HandlerInterceptor{

	// controller 가 동작하기 전에 실행되는 interceptor
	// session정보가 있는지만 판단한다...
	// 화면에서는 또는 controller 에서 이거 이용해서 
	// 로그인 상태인지 아닌지 판단
	@Override
	public boolean preHandle(HttpServletRequest request
			, HttpServletResponse response
			, Object handler)
			throws Exception 
	{
		// session이 없으면 만들지 않는다  - false
		HttpSession session =  request.getSession(false);
		if(session != null) {
			Object authInfo =  session.getAttribute("authInfo");
			if(authInfo != null)
				return true;
		}
		response.sendRedirect(request.getContextPath() + "/login");
		return false;
	}

	
}
