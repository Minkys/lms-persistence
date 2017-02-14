package service;

import java.util.List;

import dao.LeaveRoleDAO;
import model.LeaveRole;

public class LeaveRoleService {

	private LeaveRoleDAO ldDao = new LeaveRoleDAO();
	
	public List<LeaveRole> list() {

		return ldDao.list();
	}
	
	public LeaveRole findByRoleId(long id) {

		return ldDao.findById(id);
	}
	
}
