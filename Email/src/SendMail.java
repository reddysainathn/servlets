import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void main(String[] args) {
		Properties property = new Properties();

		property.setProperty("mail.smtp.host", "smtp.gmail.com");
		//property.setProperty("mail.smpt.port", "587");
		property.setProperty("mail.smtp.auth", "true");
		property.setProperty("mail.smtp.ssl.enable", "true"); 
		Authenticator auth = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(
						"sainathreddynarahari6@gmail.com", "catchmeifucangetin");
			}

		};

		// This session will be different for each provider,the provider
		// provides Session code

		Session session = Session.getDefaultInstance(property, auth);

		Message msg = new MimeMessage(session);
		
		try {
			msg.setSubject("Cave of Progamming-Recarged");
			
			msg.setText("Hello,Please Click this link: http://google.com/");
			
			msg.setFrom( new  InternetAddress("sainathreddynarahari6@gmail.com","Sainath"));
			
			
			
			msg.setRecipient(Message.RecipientType.TO,new InternetAddress( "sainathreddynarahari6@gmail.com"));
			
			Transport.send(msg);
		} catch (MessagingException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished.");
	}

}
