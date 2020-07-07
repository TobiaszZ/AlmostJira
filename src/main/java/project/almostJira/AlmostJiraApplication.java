package project.almostJira;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.format.FormatterRegistry;
import project.almostJira.converters.UserConverter;
import project.almostJira.models.User;
import project.almostJira.services.UserService;

import javax.persistence.Converter;

@SpringBootApplication(scanBasePackages = "project.almostJira")
public class AlmostJiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlmostJiraApplication.class, args);
	}

//	public void addFormatters(FormatterRegistry registry){
//		registry.addConverter(getUserConverter());
//	}
//
//
//	@Bean
//	public UserConverter getUserConverter(){
//		return new UserConverter();
//	}

	@Autowired
	UserService userService;

@EventListener(ApplicationReadyEvent.class)
	public void onStart(){
		User admin = new User();
			admin.setId(1);
			admin.setLogin("admin");
			admin.setFirstName("Tobiasz");
			admin.setLastName("Ziółkowski");
			admin.setPassword("123");
			userService.saveUser(admin);

}

}
