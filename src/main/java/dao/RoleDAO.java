package dao;

import org.springframework.jdbc.core.JdbcTemplate;

import model.Role;
import util.ConnectionUtil;

public class RoleDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	
	public Role findById(Long id) {

		String sql = "SELECT  ID, ROLE_CODE, ROLE_NAME,CREATED_DATE,MODIFIED_DATE FROM ROLE WHERE ID= ?";
		Role list = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNo) -> {			

				Role role = new Role();
				role.setId(rs.getLong("ID"));
				role.setCode(rs.getString("ROLE_CODE"));
				role.setName(rs.getString("ROLE_NAME"));			
			    role.setCreatedDate(rs.getDate("CREATED_DATE").toLocalDate());
				role.setModifiedDate(rs.getDate("MODIFIED_DATE").toLocalDate());
			return role;
		});
		return list;

	}
}
