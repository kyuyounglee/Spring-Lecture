package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class MemberDao {
	private JdbcTemplate jdbctemplate;

	public MemberDao(DataSource ds) {
		super();
		this.jdbctemplate = new JdbcTemplate(ds);
	}

	public Member selectByEmail(String email) {
//		RowMapper<Member>를 lamda 로 표현		
		List<Member> result =  jdbctemplate.query("select * from member where email = ?"				, 
				(ResultSet rs, int rowNum)->{
					Member m = new Member(
							rs.getString("email"), 
							rs.getString("password"), 
							rs.getString("name"), 
							rs.getTimestamp("regdate").toLocalDateTime()
							);
					m.setId(rs.getLong("id"));
					return m;
				}
				,email
				);
		return result.get(0);
	}
	
	public List<Member> selectAll() {
//		RowMapper<Member>를 lamda 로 표현		
		List<Member> result =  jdbctemplate.query("select * from member", 
				(ResultSet rs, int rowNum)->{
					Timestamp tt = rs.getTimestamp("regdate");
					Member m = new Member(
							rs.getString("email"), 
							rs.getString("password"), 
							rs.getString("name"),
							(tt!=null)? tt.toLocalDateTime() : null
//							rs.getTimestamp("regdate").toLocalDateTime()
							);
					m.setId(rs.getLong("id"));
					return m;
				}
				);
		return result;
	}
	
	public int count() {
		int count = jdbctemplate.queryForObject("select count(*) from member", Integer.class);
		return count;
	}
	
	public void update(Member member) 
	{
		String sql= "update member set name=?,password=? where email = ?";
		jdbctemplate.update(sql,member.getName()
				,member.getPassword(),member.getEmail()
				);
	}
	
	public void insert(Member member) {
		jdbctemplate.update(new PreparedStatementCreator() {			
			@Override
			public PreparedStatement 
			createPreparedStatement(Connection conn) throws SQLException 
			{
				String sql = "insert into member(email,password,name,regdate)";
				sql += " values(?,?,?,?)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, member.getEmail());
				psmt.setString(2, member.getPassword());
				psmt.setString(3, member.getName());
				psmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));				
				return psmt;
			}
		});
	}
	public void insertLamda(Member member) {
		jdbctemplate.update(
				(Connection conn)->{
					String sql = "insert into member(email,password,name,regdate)";
					sql += " values(?,?,?,?)";
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setString(1, member.getEmail());
					psmt.setString(2, member.getPassword());
					psmt.setString(3, member.getName());
					psmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));				
					return psmt;
				}
				);
	}
	
	
}




