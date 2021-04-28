package model;
// crud

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

public class ProductDAO {
	@Autowired  // 자동주입
	private JdbcTemplate jdbcTemp;	
	// select   
	// 1 전체    multi
	// 2 pk 로 검색해서  one	
	private RowMapper<Product> rowMapper = 
			new RowMapper<Product>() {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Product(rs.getString("p_id"), 
					rs.getString("p_name"), 
					rs.getLong("p_unitPrice"), 
					rs.getString("p_description"),
					rs.getString("p_category"), 
					rs.getString("p_manufacturer"), 
					rs.getString("p_condition"), 
					rs.getString("p_fileName"));						
		}
	};
	
	public Product selectById(String id) {
		String sql = "select * from product where p_id = ?";
		return jdbcTemp.queryForObject(sql, rowMapper,id);
	}
	
	public List<Product> selectByAll() {
		String sql = "select * from product";
		return jdbcTemp.query(sql,rowMapper);
	}	
	
	// ID 채번.... 채변 규칙을 정하고  새로운 id 를 채번  why?? insert
	// 메소드를 만든다
	
	// 쿼리를 2번 트랜잭션을 거는...
	public void insert(Product product) {
		
		//JdbcTemplate.
		
		jdbcTemp.update(
				new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement pstmt= 
								con.prepareStatement("INSERT INTO product(p_name , p_unitPrice,  p_description, p_category,  p_manufacturer,  p_condition) "+
						"VALUES(?,?,?,?,?,?)");
						
						pstmt.setString(1, product.getP_name());
						pstmt.setLong(2, product.getP_unitPrice());
						pstmt.setString(3, product.getP_description());
						pstmt.setString(4, product.getP_category());
						pstmt.setString(5, product.getP_manufacturer());
						pstmt.setString(6, product.getP_condition());						
						return pstmt;
					}
				},
				null);
	}
	
	
	
}
