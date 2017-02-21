package service;

import java.util.List;

import dao.EmployeeHierarchyDAO;
import model.EmployeeHierarchy;

public class EmployeeHierarchyService {

	private EmployeeHierarchyDAO employeeHierarchyDAO = new EmployeeHierarchyDAO();

	public List<EmployeeHierarchy> list() {

		return employeeHierarchyDAO.list();
	}

	public List<EmployeeHierarchy> listMyTeam(Long empId) {

		return employeeHierarchyDAO.listMyTeam(empId);
	}

	public void insert(EmployeeHierarchy emp) {

		employeeHierarchyDAO.insertEmployeeHierarchy(emp);
	}

	public void update(EmployeeHierarchy emp) {
		employeeHierarchyDAO.updateEmployeeHierarchy(emp);
	}

	public void delete(Long empId) {
		employeeHierarchyDAO.delete(empId);
	}

	public EmployeeHierarchy findById(Long id) {

		return employeeHierarchyDAO.findById(id);
	}
}
