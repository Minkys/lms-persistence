package service;

import java.util.List;

import dao.LeaveDetailDAO;
import model.LeaveDetail;

public class LeaveDetailService {

	private LeaveDetailDAO ldDao = new LeaveDetailDAO();
	
	public void save(LeaveDetail ld) {
		ldDao.applyLeave(ld);
	}
	public List<LeaveDetail> list(Long lId) {

		return ldDao.list(lId);
	}
	public void update(LeaveDetail ld) {
		ldDao.applyLeave(ld);
	}
	public LeaveDetail findById (Long leaveId) {

		return ldDao.findById(leaveId);
	}
	
	
}
