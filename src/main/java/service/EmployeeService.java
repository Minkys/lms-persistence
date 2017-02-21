package service;

import java.util.List;

import dao.EmployeeDAO;
import dao.UserMailManager;
import model.Employee;

public class EmployeeService {

	private EmployeeDAO employeeDAO = new EmployeeDAO();

	public Employee findByEmailId(String emailId, String password) {

		return employeeDAO.findByEmailIdAndPassword(emailId, password);
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

	public void forgotPassword(String emailId) throws Exception {

		Employee employee = employeeDAO.findByEmailId(emailId);

		if (employee == null) {
			throw new Exception("MailId does not exists");
		}

		UserMailManager.sendPassword(employee);

	}

	public void changePassword(String emailId, String oldPassword, String newPassword) throws Exception {

		if (oldPassword.equals(newPassword)) {
			throw new Exception("Old Password and New Password is same");
		}

		Employee emp1 = employeeDAO.findByEmailIdAndPassword(emailId, oldPassword);

		if (emp1 == null) {
			throw new Exception("Invalid Password");
		}

		boolean isModified = employeeDAO.changePassword(emailId, oldPassword, newPassword);
		if (isModified) {
			// employeeDAO.addPasswordEntry(emp1.getId(),oldPassword,newPassword);
		} else {
			throw new Exception("Unable to change Password.");

		}

		UserMailManager.changePassword(emp1, newPassword);

	}
}
