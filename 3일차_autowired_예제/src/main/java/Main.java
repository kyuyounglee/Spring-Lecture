import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 부모가 자식의 객체를 가지고 있다.. --> 다형성
		// 다형성을 잘 사용하면 de-coupling을 설계 할 수 있다
		// 객체지향적 설계
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConf.class);
		MemberDao dbd = ctx.getBean("memberdao",MemberDao.class);
		MemberInfoPrinter mip 
		= ctx.getBean("meminfoprinter",MemberInfoPrinter.class);
		System.out.println(mip);
				
		
		Test t = ctx.getBean("test",Test.class);
		t.test();
	}

}
