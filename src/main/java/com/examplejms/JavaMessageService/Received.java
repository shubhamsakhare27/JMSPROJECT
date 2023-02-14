package com.examplejms.JavaMessageService;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Received {

	@JmsListener(destination = "myQueue")
	public void received(String message) {

		System.out.println("Received message: " + message);

	}

}
