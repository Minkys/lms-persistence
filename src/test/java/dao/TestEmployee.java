package dao;

import model.Employee;
import model.Role;

public class TestEmployee {

	public static void main(String[] args) {

		EmployeeDAO empDao = new EmployeeDAO();
		/*
		 * Employee findByEmailId =
		 * empDao.findByEmailIdAndPassword("senthil@gmail.com", "sa");
		 * System.out.println(findByEmailId);
		 */

		/*
		 * List<Employee> employee = empDao.findMyProfile(1L);
		 * System.out.println(employee);
		 */

		/*
		 * List<Employee> list = empDao.list();
		 * 
		 * for (Employee emp : list) { System.out.println(emp); }
		 * 
		 * empDao.delete(11L); System.out.println("Deleted");
		 * 
		 * empDao.changePassword("spin@gmail.com", "passwor", "password");
		 * System.out.println("ChangedPassword");
		 * 
		 * Employee employee1 = empDao.findByEmailId("senthil@gmail.com");
		 * System.out.println(employee1.getPassword());
		 * 
		 * empDao.addPasswordEntry(1L, "pass123", "pass12");
		 */
		Employee emp = empDao.findById(8L);
		emp.setCode("SP125");
		emp.setName("Raguva");
		emp.setMobileNo(98868749L);

		Role r = new Role();
		r.setId(10l);

		emp.setRole(r);
		empDao.update(emp);
		System.out.println("Updated");

	}
}
