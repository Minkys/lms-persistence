package service;

import java.util.List;

import dao.LeaveDetailDAO;
import model.LeaveDetail;

public class LeaveDetailService {

	private LeaveDetailDAO ldDao = new LeaveDetailDAO();
	
	public void save(LeaveDetail ld) {
		ldDao.applyLeave(ld);
	}
	public List<LeaveDetail> list(Long employeeId) {

		return ldDao.list(employeeId);
	}
	public List<LeaveDetail> findAllPendingLeaves() {

		return ldDao.findAllPendingLeaves();
	}
	public void update(LeaveDetail ld) {
		ldDao.update(ld);
	}
	public LeaveDetail findById (Long leaveId) {

		return ldDao.findById(leaveId);
	}
	
	public List<LeaveDetail> findMyTeamPendingLeaves(long empId) {
		return ldDao.findMyTeamPendingLeaves(empId);
	}
	
}
