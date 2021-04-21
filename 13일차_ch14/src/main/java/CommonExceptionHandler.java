import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("spring")
public class CommonExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String hruntimeEx() {
		return "error/commonException";
	}
}
