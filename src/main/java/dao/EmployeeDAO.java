package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
		r.setName(rs.getString("ROLE_NAME"));

		emp.setRole(r);
		return emp;
	}

	public Employee findByEmailIdAndPassword(String emailId, String password) {

		String sql = "SELECT e.ID, e.CODE, NAME, ROLE_ID , ROLE_CODE, ROLE_NAME, EMAIL_ID, MOBILE_NO, e.ACTIVE, e.CREATED_DATE, e.MODIFIED_DATE FROM EMPLOYEES e, ROLE r WHERE e.ROLE_ID = r.ID AND e.EMAIL_ID = ? AND PASSWORD=? ";

		Employee employee = null;

		try {
			employee = jdbcTemplate.queryForObject(sql, new Object[] { emailId,password }, (rs, rowNum) -> {

				return convert(rs);

			});
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		return employee;

	}
	public void registerEmployee(Employee emp) {

		String sql = "INSERT INTO EMPLOYEES ( CODE , NAME, EMAIL_ID, MOBILE_NO, ROLE_ID,PASSWORD,CREATED_DATE,MODIFIED_DATE )"
				+ "VALUES ( ?, ?, ?, ?, ?,?,NOW(), NOW() )";

		int rows = jdbcTemplate.update(sql,emp.getCode(),emp.getName(),emp.getEmailId(),emp.getMobileNo()
				,emp.getRole().getId(),emp.getPassword());

		System.out.println("No of rows Register:" + rows);
	}
	
	public List<Employee> list() {

		String sql = "SELECT e.ID, e.CODE, NAME, ROLE_ID , ROLE_CODE, ROLE_NAME, EMAIL_ID, MOBILE_NO, e.ACTIVE, e.CREATED_DATE, e.MODIFIED_DATE FROM EMPLOYEES e, ROLE r WHERE e.ROLE_ID = r.ID";

		List<Employee> list = jdbcTemplate.query(sql, new Object[] {  }, (rs, rowNum) -> {
			return convert(rs);
		});
		return list;

	}
	public boolean changePassword(String emailId, String oldPassword, String newPassword){
		
		boolean isModified=false;
			String sql= "UPDATE EMPLOYEES SET PASSWORD=?, MODIFIED_DATE= NOW() WHERE EMAIL_ID=? AND PASSWORD= ?";
			Integer rows=jdbcTemplate.update(sql,newPassword,emailId,oldPassword);
			
			if (rows >= 1) {
				isModified = true;
			}

			System.out.println("No of rows Changed:" + rows);
			return isModified;
		}
		
		public Employee findByEmailId(String emailId) {

			String sql = "SELECT e.ID, e.CODE, NAME, ROLE_ID , ROLE_CODE, ROLE_NAME, EMAIL_ID,"
					+ " MOBILE_NO,e.PASSWORD, e.ACTIVE, e.CREATED_DATE, e.MODIFIED_DATE FROM EMPLOYEES e, "
					+ "ROLE r WHERE e.ROLE_ID = r.ID AND e.EMAIL_ID = ? ";

			Employee employee = null;

			try {
				employee = jdbcTemplate.queryForObject(sql, new Object[] { emailId }, (rs, rowNum) -> {

					Employee convert = convert(rs);
					convert.setPassword(rs.getString("PASSWORD"));
					return convert;

				});
			} catch (EmptyResultDataAccessException e) {
				e.printStackTrace();
			}
			return employee;

		}

	public void delete(Long empId) {

		String sql = "DELETE FROM EMPLOYEES WHERE ID= ? ";
		int rows = jdbcTemplate.update(sql, empId);
		System.out.println("No of rows deleted:" + rows);

	}
}
