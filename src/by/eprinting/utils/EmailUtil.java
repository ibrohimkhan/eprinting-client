package by.eprinting.utils;

import java.util.Properties;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import by.eprinting.beans.Track;

public class EmailUtil {
	
	private static final String SMTP 	 = "google.smtp";
	private static final String PORT 	 = "google.port";
	private static final String FROM 	 = "google.from";
	private static final String USERNAME = "google.username";
	private static final String PASSWORD = "google.password";
	
	public static void sendEmail(Track track, Properties properties) {
		HtmlEmail email = new HtmlEmail();
		
		email.setHostName(properties.getProperty(SMTP));
		email.setSmtpPort(Integer.valueOf(properties.getProperty(PORT)));
		
		email.setAuthenticator(new DefaultAuthenticator(properties.getProperty(USERNAME), properties.getProperty(PASSWORD)));
		email.setStartTLSRequired(true);
		email.setCharset("UTF-8");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		sb.append("</head>");

		sb.append("<body>");
		sb.append("<h3>Dear ").append(track.getPayment().getOrder().getFullName()).append("</h3>");
		sb.append("<p>").append("<i>Your tarck number is: </i><b>").append(track.getSerial()).append("</b></p>");
		sb.append("</body>");
		sb.append("</html>");
		
		try {
			email.setFrom(properties.getProperty(FROM));
			email.setSubject("Track you order!");
			email.setHtmlMsg(sb.toString());
			email.addTo(track.getPayment().getOrder().getEmail());
			email.send();
			
		} catch (EmailException e) {
			e.printStackTrace();
		}		
	}
}
