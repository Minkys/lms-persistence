package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Employee;
import model.Role;
import util.ConnectionUtil;

public class EmployeeDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public Employee findById(Long id) {

		String sql = "SELECT e.ID, e.CODE, NAME, ROLE_ID , ROLE_CODE, ROLE_NAME, EMAIL_ID, MOBILE_NO, e.ACTIVE, e.CREATED_DATE, e.MODIFIED_DATE FROM EMPLOYEES e, ROLE r WHERE e.ROLE_ID = r.ID AND e.ID = ?";

		Employee employee = jdbcTemplate.queryForObject(sql, new Object[] { id }, (rs, rowNum) -> {

			return convert(rs);

		});
		return employee;

	}

	private Employee convert(ResultSet rs) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getLong("ID"));
		emp.setCode(rs.getString("CODE"));
		emp.setName(rs.getString("NAME"));
		emp.setEmailId(rs.getString("EMAIL_ID"));
		emp.setMobileNo(rs.getLong("MOBILE_NO"));
		emp.setActive(rs.getBoolean("ACTIVE"));
		emp.setCreatedDate(rs.getDate("CREATED_DATE").toLocalDate());
		emp.setModifiedDate(rs.getDate("MODIFIED_DATE").toLocalDate());

		Role r = new Role();
		r.setId(rs.getLong("ROLE_ID"));
		r.setCode(rs.getString("ROLE_CODE"));
		r.setName("ROLE_NAME");

		emp.setRole(r);
		return emp;
	}

	public Employee findByEmailId(String emailId) {

		String sql = "SELECT e.ID, e.CODE, NAME, ROLE_ID , ROLE_CODE, ROLE_NAME, EMAIL_ID, MOBILE_NO, e.ACTIVE, e.CREATED_DATE, e.MODIFIED_DATE FROM EMPLOYEES e, ROLE r WHERE e.ROLE_ID = r.ID AND e.EMAIL_ID = ?";

		Employee employee = null;

		try {
			employee = jdbcTemplate.queryForObject(sql, new Object[] { emailId }, (rs, rowNum) -> {

				return convert(rs);

			});
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		return employee;

	}

}
