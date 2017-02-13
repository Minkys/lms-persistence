package service;

import dao.RoleDAO;
import model.Role;

public class RoleService {

	private RoleDAO RoleDAO = new RoleDAO();
	
	public Role findById(Long id){
		return RoleDAO.findById(id);
	}
	
}
