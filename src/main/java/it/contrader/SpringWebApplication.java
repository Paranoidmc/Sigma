package it.contrader;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;
@EnableScheduling
@SpringBootApplication
public class SpringWebApplication {
	@Bean
	RestTemplate RestTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
	
}
