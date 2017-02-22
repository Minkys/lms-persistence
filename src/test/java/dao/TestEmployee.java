package dao;

import java.util.List;

import model.Employee;

public class TestEmployee {

	public static void main(String[] args) {

		EmployeeDAO empDao = new EmployeeDAO();
		/*
		 * Employee findByEmailId =
		 * empDao.findByEmailIdAndPassword("senthil@gmail.com", "sa");
		 * System.out.println(findByEmailId);
		 */

		List<Employee> employee = empDao.findMyProfile(1L);
		System.out.println(employee);

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

	}
}
