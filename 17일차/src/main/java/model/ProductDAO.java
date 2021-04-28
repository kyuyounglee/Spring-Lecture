package model;
// crud

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		String sql = "select * from product where id = ?";
		return jdbcTemp.queryForObject(sql, rowMapper);
	}
	
	public List<Product> selectByAll() {
		String sql = "select * from product";
		return jdbcTemp.query(sql,rowMapper);
	}
	
}
