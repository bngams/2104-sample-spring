package fr.aelion.gfi.spring.demo;

import fr.aelion.gfi.spring.demo.sample.models.entities.User;
import fr.aelion.gfi.spring.demo.sample.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Optional;

// @ComponentScan + Config
@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
