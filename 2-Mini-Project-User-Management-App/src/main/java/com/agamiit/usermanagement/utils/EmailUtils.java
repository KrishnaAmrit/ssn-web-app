package com.agamiit.usermanagement.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender javaMailSender;
	public boolean sendEmails(String to,String subject,String Body) {
		boolean isSent=false;
		try {
			MimeMessage mimeMessage=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(Body,true);
			javaMailSender.send(mimeMessage);
			isSent=true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSent;
		
	}

}
