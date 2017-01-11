package dao;

import java.time.LocalDate;
import java.util.List;

import model.Employee;
import model.LeaveDetail;
import model.LeaveStatus;
import model.LeaveType;

public class TestLeaveDetail {

	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setId(1L);
		
		LeaveStatus ls = new LeaveStatus();
		ls.setId(1L);
		
		LeaveType lt = new LeaveType();
		lt.setId(1L);
		
		LeaveDetail ld = new LeaveDetail();
		ld.setEmployee(emp);
		ld.setFromDate(LocalDate.now());
		ld.setToDate(LocalDate.now());
		ld.setNoOfDays(1f);
		ld.setStatus(ls);
		ld.setLeaveType(lt);
		
		
		LeaveDetailDAO ldDao = new LeaveDetailDAO();
		ldDao.applyLeave(ld);
		List<LeaveDetail> list = ldDao.list(1L);
		for (LeaveDetail leaveDetail : list) {
			System.out.println(leaveDetail);
		}
	}
}
