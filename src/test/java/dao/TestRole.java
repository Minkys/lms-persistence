package dao;

import model.Role;
import service.RoleService;

public class TestRole {

	public static void main(String[] args) {
		

		RoleService roleService = new RoleService();
			
		Role findById = roleService.findById(1L);
		System.out.println(findById);
	}
}
