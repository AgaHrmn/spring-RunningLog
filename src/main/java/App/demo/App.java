package App.demo;

import App.demo.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(0, "morning run", 5.10);
			log.info(run.toString());
		};
	}

}
