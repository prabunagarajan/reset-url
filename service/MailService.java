package com.oasys.mail.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.oasys.mail.dto.MailDto;
import com.oasys.mail.entity.MailEntity;
import com.oasys.mail.repository.MailRepository;
import com.oasys.mail.response.MailResponse;

@Service
public class MailService {

	@Autowired
	MailRepository mailRepository;
	
	@Autowired
	JavaMailSender javaMailSender;
	public MailResponse mailsenderService(MailDto mailDto) throws Exception {
		
		MailEntity mailEntity=mailRepository.findByEmail(mailDto.getEmail());
		
		if(mailEntity != null) {
			
			this.sendemail(mailDto.getEmail());
			
			MailResponse response=new MailResponse();
			response.setErrorCode(0);
			response.setErrorMessage("URL send successfully");
			//response.getErrorCode();
			
			return response;
		}
		else {
			MailResponse response=new MailResponse();
			response.setErrorCode(1);
			response.setErrorMessage("Invalid / Not Register");
			
			return response;
		}
	}
	
	public void sendemail(String email) throws Exception {
	

		
		MimeMessage message= javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		
		helper.setTo(email);
		helper.setText("URL");
		helper.setSubject("Reset URL");
		javaMailSender.send(message);
		
	
	}
}
