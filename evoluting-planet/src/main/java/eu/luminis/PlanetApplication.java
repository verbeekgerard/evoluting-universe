package eu.luminis;

import eu.luminis.service.NameUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAsync
@EnableDiscoveryClient
@EnableSwagger2
public class PlanetApplication {

	public static void main(String[] args) {
		setName(args);
		setPort(args);
		SpringApplication.run(PlanetApplication.class, args);
	}

	private static void setName(String[] args){
		String name;
		if (args.length > 1 && !args[0].equals("--spring.output.ansi.enabled=always")) {
			name = args[1];
		} else {
			name = NameUtil.getRandomName();
		}
		System.setProperty("spring.application.name", name);
	}

	private static void setPort(String[] args) {
		if (args.length > 0 && !args[0].equals("--spring.output.ansi.enabled=always")) {
			System.setProperty("server.port", args[0]);
		}
	}

	@Bean
	public Docket swaggerSettings() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("eu.luminis.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Evoluting Life Planet",
				"Try the API operations. Each operation has it's own description",
				"",
				"",
				"",
				"",
				"");
		return apiInfo;
	}
}
