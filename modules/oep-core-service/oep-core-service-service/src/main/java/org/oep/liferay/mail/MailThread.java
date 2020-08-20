package org.oep.liferay.mail;


import org.oep.core.service.ThamSoLocalServiceUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class MailThread  extends Thread{
	private static final String MAIL_SYSTEM_SEND_BCC="MAIL_SYSTEM_SEND_BCC";
	private static Log log = LogFactoryUtil.getLog(MailThread.class.getName());
	private String fromAddress;
	private String[] toAddress;
	private String subject;
	private String body;
	
	
	public  MailThread(String fromAddress, String toAddress[],String subject, String body) {
		// TODO Auto-generated constructor stub
		this.fromAddress =fromAddress;
		this.toAddress=toAddress;
		this.subject=subject;
		this.body=body;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		sendMail(this.fromAddress, this.toAddress, this.subject, this.body);
	}
	
	
	private boolean sendMail(String fromAddress, String toAddress[]
			, String subject, String body) {
		try {
			
			log.info("1.send email from::"+fromAddress);
			
			MailMessage mailMessage = new MailMessage();
			mailMessage.setHTMLFormat(true);
			
			mailMessage.setBody(body);
			mailMessage.setSubject(subject);
			mailMessage.setFrom(new InternetAddress(fromAddress));	
			
			InternetAddress[] to = new InternetAddress[toAddress.length];
			for (int i=0 ;i<toAddress.length;i++) {
				log.info("2."+i+".to email:"+toAddress[i]);
				to[i] =new InternetAddress(toAddress[i]);
			}
			mailMessage.setTo(to);
			InternetAddress[] bcc= getBCCAddress();
			if(bcc != null){
				
				mailMessage.setBCC(bcc);
			}
			
		//og.info("4.body:"+body);
			
			MailServiceUtil.sendEmail(mailMessage);
		
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
			return false;
		} 
		return true;
	}
	
	
	private  InternetAddress[] getBCCAddress(){
		String bcc = ThamSoLocalServiceUtil.getValue(MAIL_SYSTEM_SEND_BCC, "");
		if(bcc != null && bcc.trim().length()>0){
			String[] ccList =bcc.split(",");
			if(ccList.length>0){
				InternetAddress[] ccAddress = new InternetAddress[ccList.length];
				for (int i=0;i<ccList.length;i++) {
					try {
						log.info("3."+i+".bcc for email:"+ccList[i]);
						ccAddress[i]= new InternetAddress(ccList[i]);
						
					} catch (AddressException e) {
						// TODO Auto-generated catch block
						return null;
					}
				}
				return ccAddress;
			}
		}
		return null;
	} 
	
	
	
}
