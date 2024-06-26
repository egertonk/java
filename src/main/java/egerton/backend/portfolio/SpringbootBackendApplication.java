package egerton.backend.portfolio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@ComponentScan
@EnableJpaRepositories(basePackages = {"egerton.backend.portfolio"})
@EntityScan(basePackages = {"egerton.backend.portfolio"})
@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(SpringbootBackendApplication.class);
	
	@GetMapping("/message")
	public String message(){
		return "Egerton, Jessa, Brighton During";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("***** In Egerton's Backend Application *****", LOGGER);
	}
}
