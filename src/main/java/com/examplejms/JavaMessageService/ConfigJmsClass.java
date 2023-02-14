package com.examplejms.JavaMessageService;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ConfigJmsClass {

	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;

	@Value("${spring.activemq.user}")
	private String userName;

	@Value("${spring.activemq.password}")
	private String password;

	@Bean
    public ConnectionFactory connectionFactory() {
     ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();

		activeMQConnectionFactory.setBrokerURL(brokerUrl);
		activeMQConnectionFactory.setUserName(userName);
		activeMQConnectionFactory.setPassword(password);

		return activeMQConnectionFactory;

	}

	@Bean
	  
	public   JmsTemplate jmsTemplate() {
		
		JmsTemplate jmsTemplate =new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		jmsTemplate.setDefaultDestinationName("myQueue");;
		
		
		return jmsTemplate;
		
		
		
		
	}
			
	
}
