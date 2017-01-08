package dao;

import org.springframework.jdbc.core.JdbcTemplate;

import model.LeaveDetail;
import util.ConnectionUtil;

public class LeaveDetailDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void applyLeave(LeaveDetail ld) {

		String sql = "INSERT INTO EMPLOYEE_LEAVE_DETAILS ( EMP_ID , FROM_DATE, TO_DATE, NO_OF_DAYS, LEAVE_TYPE,  STATUS_ID, APPLIED_DATE,MODIFIED_BY, MODIFIED_DATE )"
				+ "VALUES ( ?, ?, ?, ?, ?, ?, NOW(),?, NOW() )";

		int rows = jdbcTemplate.update(sql, ld.getEmployee().getId(), ld.getFromDate(), ld.getToDate(),
				ld.getNoOfDays(), ld.getLeaveType().getId(), ld.getStatus().getId(),ld.getEmployee().getId());

		System.out.println("No of rows inserted:" + rows);
	}

	
}
