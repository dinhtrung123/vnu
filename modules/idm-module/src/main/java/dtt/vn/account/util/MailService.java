package dtt.vn.account.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

public class MailService implements Runnable {
	static Log logger = LogFactoryUtil.getLog(MailService.class);
	private static String[] emailTo;
	private static String subject;
	private static String header;
	private static String body;
	private static String footer;

	public Session initProps() {
		Properties props = new Properties();
		props.put("mail.smtp.host", PropsUtil.get("mail.smtp.host"));
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", PropsUtil.get("mail.smtp.port"));
		
		Authenticator authenticator = new Authenticator();
		props.setProperty("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());
		return Session.getInstance(props, authenticator);
	}

	public void sendEmailInThread() {
		Session session = new MailService().initProps();
		Message message = new MimeMessage(session);
		try {
			message.setHeader("Content-Type", "text/html; charset=UTF-8");
			message.setFrom(new InternetAddress(PropsUtil.get("mail.smtp.from")));
			InternetAddress[] internetAddresses = new InternetAddress[emailTo.length];
			for (int i = 0; i < emailTo.length; i++) {
				internetAddresses[i] = new InternetAddress(emailTo[i]);
			}
			message.setRecipients(Message.RecipientType.TO, internetAddresses);
			message.setSubject(subject);
			message.setContent(header + body + footer, "text/html; charset=UTF-8");
			message.setSentDate(new Date());
			
			Transport transport = session.getTransport("smtp");
			transport.connect(session.getProperty("mail.smtp.host"),
					Integer.parseInt(session.getProperty("mail.smtp.port")), 
					PropsUtil.get("mail.smtp.user"),
					PropsUtil.get("mail.smtp.password"));
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (MessagingException e) {
			logger.error(e);
		}
	}

	@Override
	public void run() {
		this.sendEmailInThread();
	}

	public static void sendEmail(String[] email, String sub, String head, String bod, String foot) {
		emailTo = email;
		subject = sub;
		header = head;
		body = bod;
		footer = foot;
		MailService mail = new MailService();
		Thread t = new Thread(mail);
		t.run();
	}
}

class Authenticator extends javax.mail.Authenticator {
	private PasswordAuthentication authentication;

	public Authenticator() {
		String username = PropsUtil.get("mail.smtp.user");
		String password = PropsUtil.get("mail.smtp.password");
		authentication = new PasswordAuthentication(username, password);
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return authentication;
	}
}