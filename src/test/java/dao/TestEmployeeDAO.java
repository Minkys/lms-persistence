package dao;

import model.Employee;

public class TestEmployeeDAO {

	public static void main(String[] args) {
		
		EmployeeDAO empDao = new EmployeeDAO();		
			
		Employee findByEmailId = empDao.findByEmailId("senthil@gmail.com");
		System.out.println(findByEmailId);
		
		Employee employee = empDao.findById(1L);
		System.out.println(employee);	
		
		
	}
}
