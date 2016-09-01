package eu.luminis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EvolutingWorldServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvolutingWorldServiceApplication.class, args);
	}
}
