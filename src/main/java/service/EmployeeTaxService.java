package service;

import dao.EmployeeTaxDeclarationDAO;
import model.TaxDeclaration;

public class EmployeeTaxService {

	private EmployeeTaxDeclarationDAO employeeTaxDAO = new EmployeeTaxDeclarationDAO();
	
	public void register(TaxDeclaration empTax) {

		employeeTaxDAO.applyTaxDeclaration(empTax);
	}
	
	
}
