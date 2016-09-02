package eu.luminis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableDiscoveryClient
public class EvolutingWorldServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvolutingWorldServiceApplication.class, args);
	}
}
