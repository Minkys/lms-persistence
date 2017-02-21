package util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class MailUtil {

	@SuppressWarnings("deprecation")
	public static void sendMail(String emailId, String subject, String content) throws Exception {

		Email emailObj = new SimpleEmail();

		emailObj.setSmtpPort(587);

		emailObj.setAuthenticator(new DefaultAuthenticator("senthil@gmail.com", "password"));

		emailObj.setDebug(false);

		emailObj.setHostName("smtp.gmail.com");
		emailObj.setFrom("senthil@gmail.com");

		emailObj.setSubject(subject); // change here

		emailObj.setMsg(content);

		// emailObj.addTo(emailId); // correct
		emailObj.addTo("senthil@gmail.com");

		emailObj.setTLS(true);
		emailObj.send();
		System.out.println("Mail Sent");
	}

}
