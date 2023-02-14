package com.examplejms.JavaMessageService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import javax.swing.text.html.HTML;

import org.apache.coyote.http11.Http11AprProtocol;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import com.examplejms.JavaMessageService.Controller.MessageSendClass;

@SpringBootTest
class JavaMessageServiceApplicationTests {

	@Mock
	private JmsTemplate jmsTemplate;

	@InjectMocks
	private MessageSendClass jmsController;

	@Autowired
	RestTemplate restTemplate;

	@Test
	public void testPublisher() {
		String message = "Test message";
		jmsController.publisher(message);
		verify(jmsTemplate).convertAndSend(message);
	}

	    @Test
	    public void testSendEndpoint() {
		String message = "Test message";
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/send?message=" + message,
				null, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Message received successfully ", response.getBody());
	}
}
