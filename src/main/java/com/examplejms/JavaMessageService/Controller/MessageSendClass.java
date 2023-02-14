package com.examplejms.JavaMessageService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageSendClass {

	@Autowired
	JmsTemplate jmsTemplate;

	@PostMapping("/send")

	public String publisher(@RequestParam("message") String message) {

		jmsTemplate.convertAndSend(message);
		return "Message received successfully ";

	}

}
