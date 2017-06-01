package com.lw.activemq.test;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lw.activemq.service.ProducerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Client {

	@Autowired
	private ProducerService producerService;

	@Autowired
	@Qualifier("activeMQQueue")
	private Destination destination;

	@Test
	public void test() {
		for (int i = 0; i < 5; i++) {
			producerService.sendMessage(destination, "¹þ¹þ:" + i);
		}
	}

}
