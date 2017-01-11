package service;

import dao.LeaveTypeDAO;
import model.LeaveType;

public class LeaveTypeService {

	private LeaveTypeDAO leaveTypeDAO = new LeaveTypeDAO();
	
	public LeaveType findById(Long id){
		return leaveTypeDAO.findById(id);
	}
	
}
