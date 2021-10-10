package br.com.seasoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WebTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebTestApplication.class, args);
	}

}
