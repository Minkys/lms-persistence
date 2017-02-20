package util;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

 public class MailUtil {

	@SuppressWarnings("deprecation")
	public static void sendMail(String emailId, String subject, String content) throws Exception {

		Email email = new SimpleEmail();

		email.setSmtpPort(587);

		email.setAuthenticator(new DefaultAuthenticator("ral@gmail.com", "abcgddd"));

		email.setDebug(false);

		email.setHostName("smtp.gmail.com");
		email.setFrom("ral@gmail.com");

		email.setSubject(subject); // change here

		email.setMsg(content);

		email.addTo(emailId); // correct

		email.setTLS(true);
		email.send();
	}
	
	
}
