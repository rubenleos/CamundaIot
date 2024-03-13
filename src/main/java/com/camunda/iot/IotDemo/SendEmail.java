package com.camunda.iot.IotDemo;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendEmail implements JavaDelegate {
	public void execute (DelegateExecution execution) throws Exception{
		
			String email=(String) execution.getVariable("email");
			if (email == null) {
	            System.out.println("Email address is null. Cannot send email.");
	            return; // or handle the error appropriately
	        }
			System.out.println("Prepare an email to "+email);
			Properties properties=new Properties();
			
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			
			String myAccountEmail="jleos@txmglobal.com";   //the gmail account
			String password="vunz okdy qpba ltxk";     //the password
			
			Session session=Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myAccountEmail,password);
				}
			});
			
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("Uom Bank - Loan Application");
			message.setText("Your application has been created.");
			
			Transport.send(message);
			System.out.println("Message sent successfully");
	
			
	}
}