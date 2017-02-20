package dao;

import org.springframework.jdbc.core.JdbcTemplate;

import model.TaxDeclaration;
import util.ConnectionUtil;

public class EmployeeTaxDeclarationDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	
	public void applyTaxDeclaration(TaxDeclaration td) {

		String sql = "INSERT INTO TAX_DECLARATION ( EMP_ID ,PAN_NUMBER, HOUSE_RENT, HOUSE_OWNER_NAME, MEDICAL_BILLS,EPF_VPF_CONTRIBUTION,"
				+ "PPF,SENIOR_CITITIZEN,NSC,TAX_SAVING_FD,TAX_SAVING_BONDS,ELSS,LIFE_INSURANCE,PENSION_PLAN,"
				+ "CENTRAL_GOVT_PENSION_PLAN,HOUSING_LOAN,SUKANYA_SAMRIDDHI_ACCOUNT,STAMP_DUTY_CHARGES,"
				+ "TUITION_FEES,ADDITIONAL_DEDUCTION,DEDUCTION_RGESS,MEDICAL_INSURANCE_SELF,"
				+ "MEDICAL_INSURANCE_PARENTS,EDUCATION_LOAN,MEDICAL_TREATMENT,EXPENDITURE_MEDICAL_TREATMENT,DONATION_APPROVED_FUNDS,"
				+ "PHYSICALLY_DISABLED_ASSESSE )"
				+ "VALUES ( ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?,?, ?, ?,? )";

		int rows = jdbcTemplate.update(sql,td.getEmployee().getId(),td.getPanNo(),td.getHouseRent(),td.getHouseOwnerName(),
				td.getMedicalBills(),td.getEpfvpfContribution(),td.getPpf(),td.getScss(),td.getNsc(),td.getTaxSavingFD(),td.getTaxSavingBonds(),
				td.getTaxSavingMutualFund(),td.getLifeInsurancePremiums(),td.getPensionPlan(),td.getCentralGovtPlan(),td.getHousingLoan(),
				td.getSukanyaSamriddhiAccount(),td.getStampDutyCharges(),td.getTuitionFees(),td.getAdditionalDeduction(),td.getDeductionRgess(),
				td.getMedicalInsuranceSelf(),td.getMedicalInsuranceParents(),td.getEducationLoan(),td.getMedicalTreatment(),td.getExpenditureMedicalTreatment(),
				td.getDonationApprovedFunds(),td.getPhysicallyDisabled());

		System.out.println("No of rows ApplyTax:" + rows);
	}
	
	
}
