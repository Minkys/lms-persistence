package service;

import java.util.List;

import dao.EmployeeSalaryDAO;
import model.EmployeeSalaryDetails;

public class EmployeeSalaryService {

	private EmployeeSalaryDAO employeeSalaryDAO = new EmployeeSalaryDAO();

	public List<EmployeeSalaryDetails> list() {

		return employeeSalaryDAO.list();
	}

	public EmployeeSalaryDetails listMySalary(Long empId) {

		return employeeSalaryDAO.listMySalary(empId);
	}

	public void insert(EmployeeSalaryDetails emp) {

		employeeSalaryDAO.insert(emp);
	}

}
