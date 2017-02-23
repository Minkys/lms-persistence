package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import model.EmployeeSalaryDetails;
import util.ConnectionUtil;

public class EmployeeSalaryDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public List<EmployeeSalaryDetails> list() {

		String sql = "SELECT e.ID,e.EMP_ID, e.BASIC_PAY,e.HRA,e.CONVEYANCE, e.SPECIAL_ALLOWANCE,e.MEDICAL_INSURANCE FROM EMPLOYEE_SALARY_DETAILS e";

		List<EmployeeSalaryDetails> employee = jdbcTemplate.query(sql, new Object[] {}, (rs, rowNum) -> {

			return convert(rs);

		});
		return employee;

	}

	public List<EmployeeSalaryDetails> listMySalary(Long empId) {

		String sql = "SELECT e.ID,e.EMP_ID, e.BASIC_PAY,e.HRA,e.CONVEYANCE, e.SPECIAL_ALLOWANCE,e.MEDICAL_INSURANCE"
				+ " FROM EMPLOYEE_SALARY_DETAILS e WHERE e.EMP_ID=?";

		List<EmployeeSalaryDetails> employee = jdbcTemplate.query(sql, new Object[] { empId }, (rs, rowNum) -> {

			return convert(rs);

		});
		return employee;

	}

	private EmployeeSalaryDetails convert(ResultSet rs) throws SQLException {
		EmployeeSalaryDetails emp = new EmployeeSalaryDetails();
		emp.setId(rs.getLong("ID"));
		emp.setEmpId(rs.getLong("EMP_ID"));
		emp.setBasicPay(rs.getLong("BASIC_PAY"));
		emp.setHra(rs.getLong("HRA"));
		emp.setConveyance(rs.getLong("CONVEYANCE"));
		emp.setSpecialAllowance(rs.getLong("SPECIAL_ALLOWANCE"));
		emp.setMedicalInsurance(rs.getLong("MEDICAL_INSURANCE"));

		return emp;
	}

	public void insert(EmployeeSalaryDetails emp) {

		String sql = "INSERT INTO EMPLOYEE_SALARY_DETAILS ( EMP_ID , BASIC_PAY,HRA,CONVEYANCE,SPECIAL_ALLOWANCE,MEDICAL_INSURANCE)"
				+ "VALUES ( ?, ?,?, ?,?, ?)";

		int rows = jdbcTemplate.update(sql, emp.getEmpId(), emp.getBasicPay(), emp.getHra(), emp.getConveyance(),
				emp.getSpecialAllowance(), emp.getMedicalInsurance());

		System.out.println("No of rows Inserted:" + rows);
	}

}
