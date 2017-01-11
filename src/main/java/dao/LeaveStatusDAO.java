package dao;

import org.springframework.jdbc.core.JdbcTemplate;

import model.LeaveStatus;
import util.ConnectionUtil;

public class LeaveStatusDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	
	public LeaveStatus findById(Long id) {

		String sql = "SELECT  ID, CODE, DESCRIPTION FROM LEAVE_STATUS WHERE ID= ?";
		LeaveStatus list = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNo) -> {			

				LeaveStatus lt = new LeaveStatus();
				lt.setId(rs.getLong("ID"));
				lt.setStatus(rs.getString("CODE"));
				lt.setDescription("DESCRIPTION");				
			
			return lt;
		});
		return list;

	}
}
