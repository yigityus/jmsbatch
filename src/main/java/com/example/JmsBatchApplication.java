package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
@EnableJms
public class JmsBatchApplication implements CommandLineRunner {


	public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(JmsBatchApplication.class, args);
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", new String("Hello,123"));

/*


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String");
        String input = br.readLine();


        while (!"q".equals(input)) {
            jmsTemplate.convertAndSend("mailbox", new String(input));
            input =  br.readLine();
        }
*/

    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
