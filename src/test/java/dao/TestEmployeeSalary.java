package dao;

import java.util.List;

import model.EmployeeSalaryDetails;

public class TestEmployeeSalary {

	public static void main(String[] args) {

		EmployeeSalaryDAO salaryDao = new EmployeeSalaryDAO();

		List<EmployeeSalaryDetails> mySalaryDetails = salaryDao.listMySalary(1L);
		System.out.println(mySalaryDetails);

		List<EmployeeSalaryDetails> list = salaryDao.list();

		for (EmployeeSalaryDetails emp : list) {
			System.out.println(emp);
		}

		EmployeeSalaryDetails emp = new EmployeeSalaryDetails();

		emp.setEmpId(3L);
		emp.setBasicPay(200000L);
		emp.setHra(100000L);
		emp.setConveyance(1600L);
		emp.setSpecialAllowance(23600L);
		emp.setMedicalInsurance(1600L);

		// salaryDao.insert(emp);
		System.out.println("Insert");

	}
}
