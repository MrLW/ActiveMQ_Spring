package com.lw.activemq.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.lw.activemq.service.ProducerService;

@Component
public class ProducerServiceImpl implements ProducerService {

	@Autowired
	private JmsTemplate jmsTemplate;
	

	/* (non-Javadoc)
	 * @see com.lw.activemq.service.ProducerService#sendMessage(javax.jms.Destination, java.lang.String)
	 */
	public void sendMessage(Destination destination, final String message) {
		System.out.println(jmsTemplate);
		jmsTemplate.send(destination, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {

				return session.createTextMessage(message);
			}

		});

	}
}
