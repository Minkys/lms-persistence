package service;

import java.util.List;

import dao.EmployeeTaxDeclarationDAO;
import model.TaxDeclaration;

public class EmployeeTaxService {

	private EmployeeTaxDeclarationDAO employeeTaxDAO = new EmployeeTaxDeclarationDAO();

	public void register(TaxDeclaration empTax) {

		employeeTaxDAO.applyTaxDeclaration(empTax);
	}

	public TaxDeclaration findByEmpId(Long empId) {

		return employeeTaxDAO.findByEmpId(empId);
	}

	public List<TaxDeclaration> findAll() {

		return employeeTaxDAO.findAll();
	}
}
