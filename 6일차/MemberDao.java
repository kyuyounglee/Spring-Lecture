package spring;

import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDao {
	private JdbcTemplate jdbctemplate;

	public MemberDao(DataSource ds) {
		super();
		this.jdbctemplate = new JdbcTemplate(ds);
	}

	public Member selectByEmail(String email) {
		jdbctemplate.query("select * from member where email = ?"
				, 
				(ResultSet rs, int rowNum)->{
					Member m = new Member(
							email, email, email, null);
				}
				);
	}
	
	
	
}
