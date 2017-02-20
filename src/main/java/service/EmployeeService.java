package service;

import java.util.List;

import dao.EmployeeDAO;
import dao.UserMailManager;
import model.Employee;

public class EmployeeService {

	private EmployeeDAO employeeDAO = new EmployeeDAO();


	public Employee findByEmailId(String emailId,String password) {

		return employeeDAO.findByEmailId(emailId,password);
	}
	public Employee findById(Long empId) {

		return employeeDAO.findById(empId);
	}
	public List<Employee> list() {

		return employeeDAO.list();
	}
	public void delete(Long empId) {

		employeeDAO.delete(empId);
	}
	public void register(Employee emp) {

		employeeDAO.registerEmployee(emp);
	}
	
	
}
