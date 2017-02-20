package dao;




import model.Employee;
import util.MailUtil;

/* 3 methods in mailmanager*/
public class UserMailManager {
	
	public static void sendNewRegistrationEmail(Employee emp) throws Exception {

		String subject = "Reg: Welcome to LMS App";

		StringBuilder message = new StringBuilder();

		message.append("Dear" + emp.getName() + ",\n");
		message.append("Successfully you are registered to LMS Website.");
		message.append("\n Please click the activation link below:");
		String activationLink ="http://localhost:8080/lmsapp-web/activateAccount.jsp?emailId=" + emp.getEmailId();
		message.append("\n" + activationLink + "\n");
		message.append("\n\nRegards ");
		message.append("\nLMS Support Team");

		MailUtil.sendMail(emp.getEmailId(), subject, message.toString());
		System.out.println("Mail sent!");

	}	
	
	

}
