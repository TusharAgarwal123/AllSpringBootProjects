package com.email.demo.email_sending;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class App {
	public static void main(String[] args) {

		System.out.println("Preparing to send message...");
		String message = "Hello , Dear, this is message for security check . ";
		String subject = "Regarding testing the mail api";
		String to = "agarwaltushar2016@gmail.com";
		String from = "tushar.agarwal@unthinkable.co";

		// sendEmail(message, subject, to, from);
		sendAttach(message, subject, to, from);

	}

	// this is responsible to send the message with attachment.
	private static void sendAttach(String message, String subject, String to, String from) {

		// variable for gmail host.
		// host for gmail is smtp(simple mail transfer protocol)

		String host = "smtp.gmail.com";

		// get the system properties.

		Properties properties = System.getProperties();
		System.out.println("Properties" + properties);

		// setting important information to properties object.

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465"); // this is port
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// step1: to get the session object...

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("tushar.agarwal@unthinkable.co", "tushar@12345");
			}

		});

		session.setDebug(true);

		// step2: compose the message[text,multi media]

		MimeMessage m = new MimeMessage(session);

		try {
			// from email

			m.setFrom(from);

			// adding receiver
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// adding subject to message

			m.setSubject(subject);

			// attachment

			// file path
			String path = "/home/unthinkable-lap-0076/Desktop/Ini file/config.ini";

			MimeMultipart mimeMultipart = new MimeMultipart();
			// text
			// file

			// this class is use to store both text and file.
			MimeBodyPart bodyPart = new MimeBodyPart();
			MimeBodyPart fileBodyPart = new MimeBodyPart();

			try {

				bodyPart.setText(message);
				File file = new File(path);
				fileBodyPart.attachFile(file);

				mimeMultipart.addBodyPart(bodyPart);
				mimeMultipart.addBodyPart(fileBodyPart);

			} catch (Exception e) {
				e.printStackTrace();
			}

			m.setContent(mimeMultipart);

			// send

			// step3: send the message using transport class.
			Transport.send(m);

			System.out.println("Send Success...");

		} catch (MessagingException e) {

			e.printStackTrace();
		}

	}

	// this method is responsible to send email.
	private static void sendEmail(String message, String subject, String to, String from) {

		// variable for gmail host.
		// host for gmail is smtp(simple mail transfer protocol)

		String host = "smtp.gmail.com";

		// get the system properties.

		Properties properties = System.getProperties();
		System.out.println("Properties" + properties);

		// setting important information to properties object.

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465"); // this is port
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// step1: to get the session object...

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("tushar.agarwal@unthinkable.co", "tushar@12345");
			}

		});

		session.setDebug(true);

		// step2: compose the message[text,multi media]

		MimeMessage m = new MimeMessage(session);

		try {
			// from email

			m.setFrom(from);

			// adding receiver
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// adding subject to message

			m.setSubject(subject);

			// adding text to message

			m.setText(message);

			// send

			// step3: send the message using transport class.
			Transport.send(m);

			System.out.println("Send Success...");

		} catch (MessagingException e) {

			e.printStackTrace();
		}

	}
}
