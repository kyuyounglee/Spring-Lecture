import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Test {
	@Autowired
	@Qualifier("anotherMemberdao")
	private MemberDao dao;
	
	public void test() {
		System.out.println(dao);
	}
}
