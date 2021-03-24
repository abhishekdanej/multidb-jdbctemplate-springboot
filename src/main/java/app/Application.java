package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import app.model.APRJson;
import app.model.Person;
import app.service.APRJsonService;
import app.service.PersonService;

@Component
@SpringBootApplication
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Application implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private APRJsonService jsonService;

	public static void main(String[] args) {
		log.info("Starting App");
		SpringApplication.run(Application.class, args);
		
	}
	
	public void run(String... args) throws Exception {
		log.info("EXECUTING: CLI");
		for (int i=0; i< args.length; ++i) {
			log.info("args[" + i + "] : " + args[i]);
		}
		
		for(APRJson json: jsonService.getAllJson()) {
			log.info(json.getBody());
		}

		for(Person p: personService.getAllPerson()) {
			log.info(p.getEmail() + " - " + p.getUpn());
		}
		
	}

}
