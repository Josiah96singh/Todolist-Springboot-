package Myspringbootapp.fi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Myspringbootapp.fi.domain.Label;
import Myspringbootapp.fi.domain.LabelRepository;
import Myspringbootapp.fi.domain.Todo;
import Myspringbootapp.fi.domain.TodoRepository;
import Myspringbootapp.fi.domain.User;
import Myspringbootapp.fi.domain.UserRepository;

@SpringBootApplication

public class FiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiApplication.class, args);
	}
	
	@Bean 
	public CommandLineRunner todoist(TodoRepository repository, LabelRepository lrepository, UserRepository urepository) {
		return (args) -> {
		    
			//LabelRepository
			lrepository.save(new Label("Personal"));
			lrepository.save(new Label("College"));
			lrepository.save(new Label("Urgent"));
			
			//
			repository.save(new Todo("Buy Milk", "Sunday", 1996,lrepository.findByName("Personal").get(0)));
			repository.save(new Todo("Sell book", "Friday", 1990, lrepository.findByName("Urgent").get(0)));
			/*
			repository.save(new Todo("Do project", "Johhny", 2010));
			repository.save(new Todo("Buy bitcoins", "adam", 2014));
			repository.save(new Todo("Programme", "kelly", 1998));
		     */
		
			//Created users 
			User user1 = new User("josiah", "$2a$04$gHuNdRhlCYPB0SHG2HPrxeQbqlfwCj8GI784KPbDGj5ui0AsttEqK", "USER");
			User user2 = new User("admin", "$2a$04$iyqnfmWzzRdxeflE4dQfCekMTv8yc/dtAd./ZrOlsLmaft4Hdd67y", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
		};
		
	}
}
