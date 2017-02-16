package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import model.EmployeeHierarchy;
import util.ConnectionUtil;

public class EmployeeHierarchyDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public List<EmployeeHierarchy> list() {

		String sql = "SELECT e.ID,e.EMP_ID, e.MGR_ID FROM EMPLOYEE_HIERARCHY e";

		List<EmployeeHierarchy> employee = jdbcTemplate.query(sql, new Object[] { }, (rs, rowNum) -> {

			return convert(rs);

		});
		return employee;

	}

	private EmployeeHierarchy convert(ResultSet rs) throws SQLException {
		EmployeeHierarchy emp = new EmployeeHierarchy();
		emp.setId(rs.getInt("ID"));
		emp.setEmpId(rs.getInt("EMP_ID"));
		emp.setMgrId(rs.getInt("MGR_ID"));
		
		return emp;
	}

	
	public void insertEmployeeHierarchy(EmployeeHierarchy emp) {

		String sql = "INSERT INTO EMPLOYEE_HIERARCHY ( EMP_ID , MGR_ID)"
				+ "VALUES ( ?, ?)";

		int rows = jdbcTemplate.update(sql,emp.getEmpId(),emp.getMgrId());

		System.out.println("No of rows Inserted:" + rows);
	}

	public void updateEmployeeHierarchy(EmployeeHierarchy emp) {

		String sql = "UPDATE EMPLOYEE_HIERARCHY SET EMP_ID=?,MGR_ID=? WHERE ID = ?";
				

		int rows = jdbcTemplate.update(sql, emp.getEmpId(),emp.getMgrId(),emp.getId());

		System.out.println("No of rows updated:" + rows);
		
		}

	public void delete(Long empId) {

		String sql = "DELETE FROM EMPLOYEE_HIERARCHY WHERE ID= ? ";
		int rows = jdbcTemplate.update(sql, empId);
		System.out.println("No of rows deleted:" + rows);

	}
	
	public EmployeeHierarchy findById(Long id) {

		String sql = "SELECT EMP_ID, MGR_ID FROM EMPLOYEE_HIERARCHY  WHERE ID=?";

		EmployeeHierarchy employee = jdbcTemplate.queryForObject(sql, new Object[] {id }, (rs, rowNum) -> {

			return convert(rs);

		});
		return employee;

	}
}
