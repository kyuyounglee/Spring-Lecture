import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;

public class Main {

	public static void main(String[] args) throws IOException {
		MemberDao memberdao = new MemberDao();		
		// 의존관계에 있는객체를 생성자를 통해 주입했다
		MemberRegisterService mrs = new MemberRegisterService(memberdao);		
		// 의존관계에 있는객체를 settter를 통해 주입했다
		ChangePasswordService cps = new ChangePasswordService();
		cps.setMemberDao(memberdao);
		
		//console을 통해 데이터를 입력		
		
		BufferedReader reader 
		= new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("명령어를 입력하세요");
		String command = reader.readLine();
		// static 은 static끼리 논다
		// new abc@abc.com 123 123 홍길동
		if(command.startsWith("new ")) {
			NewProcess(command.split(" "));
		}else if(command.startsWith("change ")) {
			ChangeProcess(command.split(" "));
		}else {
			
		}
	}
	
	public static void NewProcess(String[] str) {
		if(str.length != 5) {
			return;
		}		
		MemberDao memberdao = new MemberDao();
		MemberRegisterService mrs = new MemberRegisterService(memberdao);
		RegisterRequest rr = new RegisterRequest(str[1], str[2], str[3], str[4]);
		mrs.regist(rr);		
	}
	public static void ChangeProcess(String[] str) {
		
	}

}
