package com.nt.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service("purchaseOrder")
public class PurchaseOrderServiceImpl implements IProductOrder {
	@Autowired
	private JavaMailSender sender;
	@Value("${spring.mail.username}")
	private String fromEmail;
	@Override
	public String shopping(String[] items, float[] price, String[] emails) throws Exception{
		float billamt=0.0f;
		for(float p:price) {
			billamt=billamt+p;
		}
		String msg=Arrays.toString(items)+" items are purchased having prices"+Arrays.toString(price)+
				" with the bill amount::"+billamt;
		String status=sendMail(fromEmail, emails,msg);
		return msg+"--->"+status;
	}
	
	//message created
	private String sendMail(String fromEmail,String toEmail[],String msg)throws Exception{
	MimeMessage message=sender.createMimeMessage();
	MimeMessageHelper helper=new MimeMessageHelper(message,true);
		helper.setFrom(fromEmail); 
		helper.setTo(toEmail);
		helper.setSubject("open it to know it");
		helper.setSentDate(new Date());
		helper.setText(msg);
		helper.addAttachment("nit.jpeg", new ClassPathResource("nit.jpeg"));
		//helper.addAttachment("nit.jpeg", new ClassPathResource("nit.jpeg"));
		//helper.addAttachment("nit.jpeg", new ClassPathResource("nit.jpeg"));
		//send mail
		sender.send(message);
			
		return "mail is having attachment";
		
	}

}
