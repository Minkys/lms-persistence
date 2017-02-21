package dao;

import model.Employee;

public class TestEmployee {

	public static void main(String[] args) {

		EmployeeDAO empDao = new EmployeeDAO();

		/*
		 * Employee findByEmailId =
		 * empDao.findByEmailId("senthil@gmail.com","sa");
		 * System.out.println(findByEmailId);
		 * 
		 * Employee employee = empDao.findById(1L);
		 * System.out.println(employee);
		 */
		/*
		 * List<Employee> list=empDao.list();
		 * 
		 * for(Employee emp:list){ System.out.println(emp); }
		 */

		/*
		 * empDao.delete(11L); System.out.println("Deleted");
		 */

		empDao.changePassword("spin@gmail.com", "passwor", "password");
		System.out.println("ChangedPassword");

		Employee employee = empDao.findByEmailId("senthil@gmail.com");
		System.out.println(employee.getPassword());

	}
}
