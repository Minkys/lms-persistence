package dao;

import java.time.LocalDate;
import java.util.List;

import model.Employee;
import model.LeaveDetail;
import model.LeaveStatus;
import model.LeaveType;

public class TestLeaveDetail {

	public static void main(String[] args) {
		
		/*Employee emp = new Employee();
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
		}*/
		
		/*LeaveDetail lddao = new LeaveDetailDAO().findById(20L);
		System.out.println(lddao);	*/
		
		/*LeaveDetailDAO dao=new LeaveDetailDAO();
		dao.delete(36L);
		
		System.out.println("Deleted");*/
		
		LeaveDetail lddao = new LeaveDetailDAO().findById(20L);
		
		LeaveType lt=new LeaveType();
		lt.setId(2L);
		
		LeaveDetail ld = new LeaveDetail();	
		ld.setLeaveType(lt);
		
		
		new LeaveDetailDAO().update(ld);
		System.out.println("Updated");
	}
}
