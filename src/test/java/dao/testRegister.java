package dao;

import model.Employee;
import model.Role;

public class testRegister {
	
	public static void main(String[] args) {
		Employee emp=new Employee();
		emp.setCode("SP0001");
		emp.setName("SenthilGanesh");
		emp.setEmailId("spin@gmail.com");
		emp.setPassword("pass");
		emp.setMobileNo(9000L);
		
		Role r=new Role();
		r.setId(10L); //employeee
		emp.setRole(r);
		System.out.println(emp);
		
		EmployeeDAO dao=new EmployeeDAO();
		dao.registerEmployee(emp);
	}

}
