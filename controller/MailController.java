package com.oasys.mail.controller;

import javax.mail.MessagingException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oasys.mail.dto.MailDto;
import com.oasys.mail.entity.MailEntity;
import com.oasys.mail.response.MailResponse;
import com.oasys.mail.service.MailService;

@RequestMapping("/mail")
@RestController
public class MailController {
	
	@Autowired
	MailService mailService;

	@PostMapping("/mailsend")
	public MailResponse mailsender(@RequestBody MailDto mailDto) throws Exception {
		return mailService.mailsenderService(mailDto);
		
	}
}
