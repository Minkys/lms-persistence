package service;

import dao.EmployeeDAO;
import model.Employee;

public class EmployeeService {

	private EmployeeDAO employeeDAO = new EmployeeDAO();


	public Employee findByEmailId(String emailId) {

		return employeeDAO.findByEmailId(emailId);
	}
	public Employee findById(Long empId) {

		return employeeDAO.findById(empId);
	}

}
