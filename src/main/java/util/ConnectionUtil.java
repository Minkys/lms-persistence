package util;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionUtil {

	
	 public static DataSource getDataSource() {
	        BasicDataSource ds = new BasicDataSource();
	        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        ds.setUrl("jdbc:mysql://localhost:3306/lms_db");
	        ds.setUsername("root");
	        ds.setPassword("");
	        return ds;
	    }

	public static JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

}
