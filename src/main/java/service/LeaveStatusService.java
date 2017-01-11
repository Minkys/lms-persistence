package service;

import dao.LeaveStatusDAO;
import model.LeaveStatus;

public class LeaveStatusService {

	private LeaveStatusDAO LeaveStatusDAO = new LeaveStatusDAO();
	
	public LeaveStatus findById(Long id){
		return LeaveStatusDAO.findById(id);
	}
	
}
