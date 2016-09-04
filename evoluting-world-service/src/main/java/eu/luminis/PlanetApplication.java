package eu.luminis;

import eu.luminis.service.NameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableDiscoveryClient
public class PlanetApplication {

	public static void main(String[] args) {
		setName(args);
		setPort(args);
		SpringApplication.run(PlanetApplication.class, args);
	}

	private static void setName(String[] args){
		String name;
		if (args.length > 0 && !args[0].equals("--spring.output.ansi.enabled=always")) {
			name = args[0];
		} else {
			name = NameService.getRandomName();
		}
		System.setProperty("spring.application.name", name);
	}

	private static void setPort(String[] args) {
		if (args.length > 1 && !args[0].equals("--spring.output.ansi.enabled=always")) {
			System.setProperty("server.port", args[1]);
		}
	}
}
