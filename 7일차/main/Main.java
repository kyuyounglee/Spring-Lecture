package main;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.AppCtx;
import spring.Member;
import spring.MemberDao;

public class Main {

	public static void main(String[] args) {
		// 다형성
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtx.class);
		
		MemberDao memberdao= ctx.getBean(MemberDao.class);
		int count = memberdao.count();
		System.out.println(count);
		
		
		// selectbyemail
		Member member = memberdao.selectByEmail("abc@abc.com");
		// update
		if(member != null) {
			member.setName("kimkimkim");
			member.changePassword("11111", "11111");
			memberdao.update(member);
		}
		
		// insert		  
		memberdao.insert(
				new Member("12345@1.com"
				, "1"
				, "temp"
				, LocalDateTime.now())
				);
		
		// select all
		List<Member> memberall =  memberdao.selectAll();
		for (Member m : memberall) {
			System.out.println(m);
		}	
		
		
	}

}
