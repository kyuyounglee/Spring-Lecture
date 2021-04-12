package dbquery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.jdbc.pool.DataSource;

public class Dbquery {
	private DataSource datasource;

	public Dbquery(DataSource datasource) {
		super();
		this.datasource = datasource;
	}
//	전체 데이터의 갯수
	public int count() {
		Connection conn = null;
		try
		{
			conn = datasource.getConnection();
			try(Statement stmt = conn.createStatement();)
			{
				String sql = "select count(*) from member";
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();				
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException();			
		} // connection pool
		finally {
			try {
				if(conn != null)
					conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}









