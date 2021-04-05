import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConf {
	@Autowired
	@Qualifier("memberdao")
	private MemberDao dao;
	
	@Bean	
	public MemberDao memberdao() {
		return new MemberDao();
	}
	@Bean
	public MemberDao anotherMemberdao() {
		return new MemberDao();
	}
	
	
	@Bean
	public MemberInfoPrinter meminfoprinter() {		
		//dao = new MemberDao();
		System.out.println(dao);
		return new MemberInfoPrinter(dao);
	}
	
	@Bean
	public Test test() {
		return new Test();
	}
	
}
