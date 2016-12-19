package com.f9g4.services;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import com.f9g4.businessobjects.domain.TrNotificationQDomain;
import com.f9g4.businessobjects.services.GetNotificationQForStatusResponse;
import com.f9g4.services.rest.INotificationQService;
import com.f9g4.businessobjects.services.GetNotificationQByIdResponse;

 
public class SendMailSSLJob{
	
	@Autowired
	private INotificationQService notificationQService = null;
	
	  @Autowired
	//private NotificationQServiceSDK notificationQServiceSDK;

	
	public void sendemail(TrNotificationQDomain domain) {
		
		//TODO Create Property File and read from property file
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("f4g10b","f4g10b123");
			
				}
			});
 
		try {
 			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(domain.getFromEmail()));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(domain.getToEmail()));
			message.setSubject(domain.getSubject());
			message.setText(domain.getBodyText());
 
			Transport.send(message);
	
			//System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}