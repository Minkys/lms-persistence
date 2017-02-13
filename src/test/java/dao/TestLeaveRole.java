package dao;

import java.util.List;

import model.LeaveRole;
import service.LeaveRoleService;


public class TestLeaveRole {

	public static void main(String[] args) {		
		
		LeaveRoleService ldDao = new LeaveRoleService();
		
		List<LeaveRole> list = ldDao.list();
		for (LeaveRole LeaveRole : list) {
			System.out.println(LeaveRole);
		}
		
	}
}
