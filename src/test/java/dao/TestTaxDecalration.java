package dao;

import model.Employee;
import model.TaxDeclaration;

public class TestTaxDecalration {

	public static void main(String[] args) {
		TaxDeclaration td = new TaxDeclaration();

		Employee emp = new Employee();
		emp.setId(1L);

		td.setEmployee(emp);
		td.setPanNo("ANYPG123L");
		td.setHouseRent(10000.0f);
		td.setHouseOwnerName("RajaRathinam");
		td.setMedicalBills(10000.0f);
		td.setEpfvpfContribution(10000.0f);
		td.setPpf(10000.0f);
		td.setScss(10000.0f);
		td.setNsc(10000.0f);
		td.setTaxSavingFD(10000.0f);
		td.setTaxSavingBonds(10000.0f);
		td.setTaxSavingMutualFund(10000.0f);
		td.setLifeInsurancePremiums(10000.0f);
		td.setPensionPlan(10000.0f);
		td.setCentralGovtPlan(10000.0f);
		td.setHousingLoan(10000.0f);
		td.setSukanyaSamriddhiAccount(10000.0f);
		td.setStampDutyCharges(10000.0f);
		td.setTuitionFees(10000.0f);
		td.setAdditionalDeduction(10000.0f);
		td.setDeductionRgess(10000.0f);
		td.setMedicalInsuranceSelf(10000.0f);
		td.setMedicalInsuranceParents(10000.0f);
		td.setEducationLoan(10000.0f);
		td.setMedicalTreatment(10000.0f);
		td.setExpenditureMedicalTreatment(10000.0f);
		td.setDonationApprovedFunds(10000.0f);
		td.setPhysicallyDisabled(10000.0f);
	

		EmployeeTaxDeclarationDAO dao = new EmployeeTaxDeclarationDAO();
		dao.applyTaxDeclaration(td);
		System.out.println("Insertd"+td);
	}

}
