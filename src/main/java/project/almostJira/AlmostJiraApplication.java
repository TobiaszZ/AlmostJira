package project.almostJira;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.format.FormatterRegistry;
import project.almostJira.converters.UserConverter;
import project.almostJira.models.Project;
import project.almostJira.models.User;
import project.almostJira.services.ProjectService;
import project.almostJira.services.UserService;

import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
	@Autowired
	ProjectService projectService;

@EventListener(ApplicationReadyEvent.class)
	public void onStart(){
		User admin = new User();
			admin.setId(1);
			admin.setLogin("admin");
			admin.setFirstName("Tobiasz");
			admin.setLastName("Ziółkowski");
			admin.setPassword("123");
			userService.saveUser(admin);

		User user = new User();
			user.setId(2);
			user.setLogin("user");
			user.setFirstName("Gal");
			user.setLastName("anonim");
			user.setPassword("321");
			userService.saveUser(user);

		User user2 = new User();
			user2.setId(3);
			user2.setLogin("user 2");
			user2.setFirstName("Gal 2");
			user2.setLastName("anonim 2");
			user2.setPassword("321");
			userService.saveUser(user2);


	Project project = new Project();
			project.setId(1);
			project.setName("projekt test");
			project.setDescription(" opis testowy");
			project.setWwwPage("strona");
			List<User> list = new ArrayList<>();
			list.add(user);
			list.add(admin);
			project.setUserList(list);
			projectService.saveProject(project);


}

}
