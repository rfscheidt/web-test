package br.com.seasoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	private static final Logger log = LoggerFactory.getLogger(EmpresaController.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	// public CustomMessageSender(final RabbitTemplate rabbitTemplate) {
	//     this.rabbitTemplate = rabbitTemplate;
	// }

	@CrossOrigin
	@GetMapping("/q1")
	public List<String> findAll() {
		List<String> companies = new ArrayList<String>();
		companies.add("Foka1");
		companies.add("Foka2");
		companies.add("Foka3");

		sendMessage();
		
		return companies;
	}
	
	@CrossOrigin
	@GetMapping("/q2")
	public List<String> findAll2() {
		List<String> companies = new ArrayList<String>();
		companies.add("Foka4");
		companies.add("Foka5");
		companies.add("Foka6");

		sendMessage2();
		
		return companies;
	}
	
	@CrossOrigin
	@GetMapping("/q3")
	public List<String> findAll3() {
		List<String> companies = new ArrayList<String>();
		companies.add("Foka7");
		companies.add("Foka8");
		companies.add("Foka9");

		sendMessage3();
		
		return companies;
	}

	//@Scheduled(fixedDelay = 3000L)
	public void sendMessage() {
		String message = new String("Hello there! " + new Random().nextInt(50));
		log.info("Sending message...");
		rabbitTemplate.convertAndSend(Config.QUEUE_GENERIC_NAME, message);
	}
	
	public void sendMessage2() {
		String message = new String("Hello there! " + new Random().nextInt(50));
		log.info("Sending message...");
		rabbitTemplate.convertAndSend(Config.QUEUE_SPECIFIC_NAME, message);
	}
	
	public void sendMessage3() {
		String message = new String("Hello there! " + new Random().nextInt(50));
		log.info("Sending message...");
		rabbitTemplate.convertAndSend(Config.EXCHANGE_NAME, Config.ROUTING_KEY, message);
	}

}
