package com.SPASM.required;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.SPASM.model.ForgotModel;

public class SendMail {
	Session session;
	final String fromEmail = "spasmproject@gmail.com";
	final String password = "urgywpuudmruzihu";

	public SendMail() {
		Properties p = new Properties();
		p.setProperty("mail.smtp.host", "smtp.gmail.com");
		p.setProperty("mail.smtp.port", "587");
		p.setProperty("mail.smtp.auth", "true");
		p.setProperty("mail.smtp.starttls.enable", "true");
		p.put("gmail.smtp.socketFactory.port", "587");
		p.put("gmail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		session = Session.getInstance(p, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);

			}
		});
	}

	public String getRandom() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}

	public boolean sendMail(ForgotModel u) throws AddressException, MessagingException, UnsupportedEncodingException {
		boolean test = false;

		String toMail = u.getEmail();
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromEmail, "e-Ducation"));

		message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
		message.setSubject(u.getCode() + " is your e-Ducation account recovery code");
		message.setText("We received a request to reset your e-Ducation password.\r\n"
				+ "Enter the following passwords reset code: " + u.getCode());

		Transport.send(message);
		test = true;
		return test;
	}

}
