package eu.luminis;

import eu.luminis.service.NameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableDiscoveryClient
public class EvolutingPlanetApplication {

	public static void main(String[] args) {
		System.setProperty("spring.application.name", getName(args));
		SpringApplication.run(EvolutingPlanetApplication.class, args);
	}

	private static String getName(String[] args){
		if(args.length > 0 && !args[0].equals("--spring.output.ansi.enabled=always")){
			return args[0];
		}

		return NameService.getRandomName();
	}

}
